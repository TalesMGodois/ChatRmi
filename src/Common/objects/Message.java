package Common.objects;

import Common.interfaces.IMessage;
import Common.interfaces.IUser;

/**
 * Created by tales on 14/06/15.
 */
public class Message implements IMessage{
    private IUser user;
    private String msg;
    private String ip;
    private int door;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    }

    public Message(String message){
        this.msg = message;
    }

    @Override
    public String getMessage() {
        return this.msg;
    }

    @Override
    public void setMessage(String msg) {
        this.msg = msg;
    }

    @Override
    public IUser getUser() {
        return this.user;
    }

    @Override
    public void setUser(IUser user) {
        this.user = user;
    }
}
