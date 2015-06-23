package Common.interfaces;

import java.io.Serializable;

/**
 * Created by tales on 14/06/15.
 */
public interface IMessage extends Serializable{

    public String getMessage();

    public void setMessage(String msg);

    public IUser getUser();

    public  void setUser(IUser user);

    public void setDoor(int door);
    public void setIp(String ip);

    public int getDoor();
    public String getIp();


}
