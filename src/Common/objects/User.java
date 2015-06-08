package Common.objects;

import Common.interfaces.IUser;

/**
 * Created by tales on 07/06/15.
 */
public class User implements IUser {
    private String name;
    private String id;
    private String email;
    private String host;
    private int door;


    public User(String name){
        setName(name);
    }


    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName(String name) {
        return this.name;
    }

    @Override
    public boolean sendMessage(String msg) {
        return false;
    }

    public String toString(){
        String retorno = "Nome: " + name + "; Host:"+host+":"+door;
        return retorno;
    }
}
