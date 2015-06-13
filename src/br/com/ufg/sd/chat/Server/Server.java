package br.com.ufg.sd.chat.Server;

import Common.interfaces.IGroup;
import Common.interfaces.IGroupService;
import Common.interfaces.IUser;

import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by tales on 13/06/15.
 */
public class Server extends UnicastRemoteObject implements IGroup {


    protected Server() throws RemoteException {
        super();

    }

    @Override
    public void addUser(IUser user) {

    }

    @Override
    public void removeUser(IUser user) {

    }

    @Override
    public void removeAll() {

    }

    @Override
    public void listUsers() {

    }
}
