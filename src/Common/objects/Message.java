package Common.objects;

import Common.interfaces.IMessage;
import Common.interfaces.IUser;

/**
 * Created by tales on 14/06/15.
 */
public class Message implements IMessage{
    private IUser user;
    private String msg;

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
    public void setuser(IUser user) {
        this.user = user;
    }
}
