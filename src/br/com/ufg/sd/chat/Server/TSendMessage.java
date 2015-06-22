package br.com.ufg.sd.chat.Server;

import Common.interfaces.IMessage;
import Common.interfaces.IReceiver;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by tales on 21/06/15.
 */
public class TSendMessage implements Runnable {
    private int workerNumbers;
    private IMessage message;

    public TSendMessage(int workerNumbers,IMessage msg){
        this.workerNumbers = workerNumbers;
        this.message = msg;
    }

    @Override
    public void run() {
        IMessage msg = this.message;

        try {
            Registry r = LocateRegistry.getRegistry(msg.getIp(), msg.getDoor());
            IReceiver client = (IReceiver) r.lookup("Receiver");
            client.receive(this.message);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }
}
