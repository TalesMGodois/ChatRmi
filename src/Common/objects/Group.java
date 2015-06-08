package Common.objects;

import Common.interfaces.IGroup;
import Common.interfaces.IUser;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by tales on 07/06/15.
 */
public class Group implements IGroup {

    private ArrayList<IUser> USERS;

    public Group(){
        this.USERS = new ArrayList<IUser>();
    }


    @Override
    public void addUser(IUser user) {
        if(!this.USERS.contains(user))
            this.USERS.add(user);
        else
            System.out.println("Usuário já está online");
    }

    @Override
    public void removeUser(IUser user) {
        if(this.USERS.contains(user))
            this.USERS.remove(user);
        else
            System.out.println("Usuário não está online");
    }

    @Override
    public void removeAll() {
        if(this.USERS.size() > 0) {
            this.USERS.clear();

        }else {
            System.out.printf("Não Existem usuários online");
        }

    }

    @Override
    public void listUsers() {
        for(Object i:this.USERS){
            System.out.printf(i.toString());
        }
    }


}
