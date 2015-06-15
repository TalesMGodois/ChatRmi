package br.com.ufg.sd.chat.Server;

import Common.interfaces.IGroup;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by tales on 13/06/15.
 */
public class TListMessages implements Runnable {
    @Override
    public void run() {
        Registry r = null;
        while (true){
            try {
                r = LocateRegistry.getRegistry("localhost", 1901);
                IGroup group = (IGroup) r.lookup("ChatService");
                group.listUsers();
                Thread.sleep(1000);
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            } catch (AlreadyBoundException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
