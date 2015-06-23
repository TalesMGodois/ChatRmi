package Common.interfaces;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by tales on 21/06/15.
 */
public interface IReceiver extends Remote {

    public void receive(IMessage message) throws RemoteException,AlreadyBoundException,NotBoundException;;
}
