package br.com.ufg.sd.chat.Client;

import Common.interfaces.IGroup;
import Common.interfaces.IMessage;
import Common.interfaces.IUser;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by tales on 13/06/15.
 */
public class TEnvio implements Runnable {
    private  String ip ="127.0.1.1";
    private  int door = 1901;
    private IUser user;
    private IMessage msg;
    private int send;

    public TEnvio(IMessage msg){
        this.msg = msg;
        send = 1;
    }

    public TEnvio(IUser user)  {
        this.user = user;
        send = 0;
    }
    @Override
    public void run() {
        try{
            System.out.println("Entrando...");
            Registry r = LocateRegistry.getRegistry(ip, door);
            IGroup group = (IGroup) r.lookup("ChatService");
            boolean isDone = group.addUser(user);
            if (isDone == true) {
                System.out.println("Usuário entrou no grupo");
            } else {
                System.out.println("Usuário já está no grupo ou aconteceu algum erro");
            }


        }catch (NotBoundException e){
            e.printStackTrace();
        } catch (AccessException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
