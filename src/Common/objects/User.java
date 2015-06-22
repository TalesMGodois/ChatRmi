package Common.objects;

import Common.interfaces.IGroup;
import Common.interfaces.IMessage;
import Common.interfaces.IUser;
import br.com.ufg.sd.chat.Client.Host;
import br.com.ufg.sd.chat.Server.Server;

import java.io.Serializable;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by tales on 07/06/15.
 */
public class User implements IUser,Serializable{
    private String name;
    private String ip = "localhost";
    private String email;
    private String host;
    private int door = 1901;


    public User(String name){
        setName(name);
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setDoor(int door) {
        this.door = door;
    }

    public String getIp() {

        return ip;
    }

    public String getEmail() {
        return email;
    }

    public String getHost() {
        return host;
    }

    public int getDoor() {
        return door;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean sendMessage(IMessage msg) throws RemoteException, NotBoundException, AlreadyBoundException {
        Registry r = LocateRegistry.getRegistry(ip, door);
        IGroup group = (IGroup) r.lookup("ChatService");
        msg.setUser(this);
        msg.setDoor(Host.self().getDoor());
        msg.setIp(Host.self().getIp());

        return  group.addMessage(msg);
    }

}
