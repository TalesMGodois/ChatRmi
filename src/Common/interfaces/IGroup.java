package Common.interfaces;

import com.sun.org.apache.bcel.internal.generic.IUSHR;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by tales on 07/06/15.
 */
public interface IGroup extends Remote{
    public boolean addUser(IUser user) throws RemoteException,AlreadyBoundException,NotBoundException;

    public void removeUser(IUser user) throws RemoteException,AlreadyBoundException,NotBoundException;

    public void removeAll() throws RemoteException,AlreadyBoundException,NotBoundException;

    public void listUsers() throws RemoteException,AlreadyBoundException,NotBoundException;

    public boolean addMessage(IMessage msg)throws RemoteException,AlreadyBoundException,NotBoundException;

}
