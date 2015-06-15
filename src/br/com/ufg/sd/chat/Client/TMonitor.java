package br.com.ufg.sd.chat.Client;

import Common.interfaces.IGroup;
import br.com.ufg.sd.chat.Server.Server;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by tales on 13/06/15.
 */
public class TMonitor implements Runnable {
    @Override
    public void run() {
        System.out.println(":: Conversas ::");


    }
}
