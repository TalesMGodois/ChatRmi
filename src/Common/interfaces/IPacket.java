package Common.interfaces;

/**
 * Created by tales on 07/06/15.
 */
public interface IPacket {
    public void setName(String name);

    public void setUser(IUser user);

    public void setdata(String message);

    public IPacket getData();

    public IUser getUser();

    public String getMessage();

    public String getUserName();
}
