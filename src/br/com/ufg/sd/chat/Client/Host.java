package br.com.ufg.sd.chat.Client;

import br.com.ufg.sd.chat.Server.Server;

import java.net.InetAddress;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;

/**
 * Created by tales on 13/06/15.
 */
public class Host {
    private int door = 1905;
    private String ip = "127.0.1.1";
    private String sName = "ReceiverService";


    private Host(int port){
        this.door = port;
    }

    /* My Singleton */
    private Host(){}

    private static Host INSTANCE = new Host();

    public static Host self(){
        return INSTANCE;
    }

    public int getDoor(){
        return this.door;
    }

    public String getIp(){
        return this.ip;
    }

    public void start() throws Exception {

        try {
            this.ip = InetAddress.getLocalHost().getHostAddress();

        } catch (Exception e) {
            e.printStackTrace();
        }



        System.setProperty("java.rmi.server.hostname", ip);
        System.setProperty("java.security.policy", "java.policy");
        System.setSecurityManager(new RMISecurityManager());
        try{
            Registry r = LocateRegistry.createRegistry(this.door);

            r.bind(sName, new Receiver());
        }catch (ExportException e){
            this.door++;
            Registry r = LocateRegistry.createRegistry(this.door);

            r.bind(sName, new Receiver());
        }

        System.out.println("Servidor " + this.sName + " Rodando(" + this.ip + ":" + this.door + ")");
        Object lock = new Object();
        synchronized (lock) {
            lock.wait();
        }

    }
}
