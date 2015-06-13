package Common.objects;

import Common.interfaces.IGroup;
import Common.interfaces.IUser;

import java.util.ArrayList;

/**
 * Created by tales on 07/06/15.
 */
public class Group implements IGroup {

    private ArrayList<IUser> USERS;

    public Group(){
        this.USERS = new ArrayList<IUser>();
    }


    /*
    *   Inserir um usuario quando for pedido a entrada
    * */

    @Override
    public void addUser(IUser user) {
        if(!this.USERS.contains(user))
            this.USERS.add(user);
        else
            System.out.println("Usuário já está online");
    }

    /*
    *   Fazer remocao de um usuario quando for deslogado
    * */

    @Override
    public void removeUser(IUser user) {
        if(this.USERS.contains(user))
            this.USERS.remove(user);
        else
            System.out.println("Usuário não está online");
    }


    /*
    *   Remover todos os usuarios online caso necessario
    * */
    @Override
    public void removeAll() {
        if(this.USERS.size() > 0) {
            this.USERS.clear();

        }else {
            System.out.printf("Não Existem usuários online");
        }

    }

    /*
    *   Imprime todos os usuario online
    * */

    @Override
    public void listUsers() {
        for(Object i:this.USERS){
            System.out.printf(i.toString());
        }
    }


}
