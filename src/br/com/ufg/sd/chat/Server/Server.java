package br.com.ufg.sd.chat.Server;

import Common.interfaces.IGroup;
import Common.interfaces.IMessage;
import Common.interfaces.IUser;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tales on 13/06/15.
 */
public class Server extends UnicastRemoteObject implements IGroup {

    private static ArrayList<IUser> USERS;
    private static ExecutorService EXECS;
    private static Queue<TSendMessage> MessagesQUEUE;
    private static int thrads = 0;

    private static final long serialVersionUID = -8550306338084922644L;

    protected Server() throws RemoteException {
        super();
        USERS = new ArrayList<IUser>();
        this.EXECS = Executors.newFixedThreadPool(10);
        this.MessagesQUEUE = new PriorityQueue<TSendMessage>();

    }

    public static ArrayList<IUser> getUsers(){
        return USERS;
    }

    private void insertMessageOnThread(IMessage msg){
        thrads++;
        TSendMessage tmsg = new TSendMessage(thrads,msg);
        MessagesQUEUE.add(tmsg);
    }


    @Override
    public boolean addUser(IUser user) {
        if(hasName(user.getName())){
            return false;
        }else{
            USERS.add(user);
            System.out.println(user.getName()+ " Entrou no chat");
            return true;
        }
    }

    public boolean hasName(String name){
        boolean retorno = false;
        for(IUser user: USERS){
            if (user.getName().equals(name)){
                retorno = true;
            }
        }
        return retorno;
    }

    @Override
    public void removeUser(IUser user) {
        if(USERS.contains(user))
            USERS.remove(user);
        else
            System.out.println("Usuário não está online");
    }

    @Override
    public void removeAll() {
        if(USERS.size() > 0) {
            USERS.clear();

        }else {
            System.out.printf("Não Existem usuários online");
        }
    }

    @Override
    public void listUsers() {
        for(Object i:USERS){
            System.out.println(i.toString());
        }
    }

    @Override
    public boolean addMessage(IMessage msg) throws RemoteException, AlreadyBoundException, NotBoundException {
        if(hasName(msg.getUser().getName())){
            System.out.println(msg.getUser().getName() +":  " +msg.getMessage() + ".");
            insertMessageOnThread(msg);
            sendAll();
            return true;
        }else
            return false;

    }



    @Override
    public void sendAll() throws RemoteException, AlreadyBoundException, NotBoundException {
        while(MessagesQUEUE.size() >0){
            EXECS.execute(MessagesQUEUE.remove());
        }
    }
}
