package br.com.ufg.sd.chat.Server;

import Common.interfaces.IGroup;
import Common.interfaces.IMessage;
import Common.interfaces.IUser;

import java.net.InetAddress;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by tales on 13/06/15.
 */
public class Server extends UnicastRemoteObject implements IGroup {

    private static ArrayList<IUser> USERS;

    private static final long serialVersionUID = -8550306338084922644L;

    protected Server() throws RemoteException {
        super();
        USERS = new ArrayList<IUser>();

//        TListMessages listMessages= new TListMessages();
//        Thread t1 = new Thread(listMessages);
//        t1.start();
    }

    @Override
    public boolean addUser(IUser user) {
        if(USERS.contains(user)){
            return false;
        }else{
            System.out.println("Usuario: " + user.getName() + " Entrou no Chat");
            USERS.add(user);
            return true;
        }

    }

    @Override
    public void removeUser(IUser user) {
        if(USERS.contains(user))
            USERS.remove(user);
        else
            System.out.println("Usuário não está online");
    }

    @Override
    public void removeAll() {
        if(USERS.size() > 0) {
            USERS.clear();

        }else {
            System.out.printf("Não Existem usuários online");
        }
    }

    @Override
    public void listUsers() {
        for(Object i:USERS){
            System.out.println(i.toString());
        }
    }

    @Override
    public boolean addMessage(IMessage msg) throws RemoteException, AlreadyBoundException, NotBoundException {
        System.out.println(msg.getUser().getName() +":  " +msg.getMessage() + ".");
        return true;
    }
}
