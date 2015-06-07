package Common.objects;

import Common.interfaces.IPacket;
import Common.interfaces.IUser;

import java.io.Serializable;

/**
 * Created by tales on 07/06/15.
 */
public class Packet implements IPacket,Serializable {

    private String message;
    private IUser user;
    private String host;
    private int door;


    @Override
    public void setName(String name) {

    }

    @Override
    public void setUser(IUser user) {

    }

    @Override
    public void setdata(String message) {

    }

    @Override
    public IPacket getData() {
        return null;
    }

    @Override
    public IUser getUser() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public String getUserName() {
        return null;
    }
}
