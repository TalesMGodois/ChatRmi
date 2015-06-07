package Common.interfaces;

import com.sun.org.apache.bcel.internal.generic.IUSHR;

/**
 * Created by tales on 07/06/15.
 */
public interface IGroup {
    public void addUser(IUser user);

    public void removeUser(IUser user);

    public void removeAll();

    public void listUsers();



}
