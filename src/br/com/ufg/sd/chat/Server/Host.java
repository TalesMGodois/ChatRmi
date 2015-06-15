package br.com.ufg.sd.chat.Server;

import java.net.InetAddress;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by tales on 13/06/15.
 */
public class Host {
    private int door = 1901;

    private String ip = "127.0.1.1";

    private boolean isRun = false;

    private String sName = "ChatService";

    private Host(int port){
        this.door = port;
    }

    /* My Singleton */
    private Host(){}

    private static Host INSTANCE = new Host();

    public static Host self(){
        return INSTANCE;
    }

    public void start() throws Exception {

        try {
            this.ip = InetAddress.getLocalHost().getHostAddress();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Servidor " + this.sName + " Rodando(" + this.ip + ":" + this.door + ")");

        System.setProperty("java.rmi.server.hostname", ip);
        System.setProperty("java.security.policy", "java.policy");
        System.setSecurityManager(new RMISecurityManager());

        Registry r = LocateRegistry.createRegistry(this.door);

        r.bind(sName, new Server());

        Object lock = new Object();
        synchronized (lock) {
            lock.wait();
        }



    }
}
