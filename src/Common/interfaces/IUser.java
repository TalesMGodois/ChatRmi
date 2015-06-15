package Common.interfaces;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by tales on 07/06/15.
 */
public interface IUser  {

    public void setName(String name);
    public String  getName();
    public boolean sendMessage(IMessage msg) throws RemoteException, NotBoundException, AlreadyBoundException;


}
