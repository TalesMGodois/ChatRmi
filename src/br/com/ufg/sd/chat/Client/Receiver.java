package br.com.ufg.sd.chat.Client;

import Common.interfaces.IMessage;
import Common.interfaces.IReceiver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by tales on 21/06/15.
 */
public class Receiver extends UnicastRemoteObject implements IReceiver {

    private static final long serialVersionUID = -8550306338084922644L;

    public Receiver() throws RemoteException {
        super();
    }

    @Override
    public void receive(IMessage message) {
        System.out.println(message.getUser() + ": " + message.getUser());
    }
}
