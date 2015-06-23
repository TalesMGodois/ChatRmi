package br.com.ufg.sd.chat.Client;

import Common.interfaces.IGroup;
import Common.interfaces.IMessage;
import Common.interfaces.IUser;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.Callable;

/**
 * Created by tales on 13/06/15.
 */
public class TValidUser implements Callable<Boolean> {
    private  String ip ="127.0.1.1";
    private  int door = 1901;
    private IUser user;
    private IMessage msg;
    private int send;

    public TValidUser(IMessage msg){
        this.msg = msg;
        send = 1;
    }

    public TValidUser(IUser user)  {
        this.user = user;
        send = 0;
    }

    @Override
    public Boolean call() throws Exception {
        boolean bl =  false;
        try{
            System.out.println("Entrando...");
            Registry r = LocateRegistry.getRegistry(ip, door);
            IGroup group = (IGroup) r.lookup("ChatService");
            boolean isDone = group.addUser(user);
            if (isDone == true) {
                bl = true;
                System.out.println("Usuário entrou no grupo");

            } else {
                bl = false;
                System.out.println("Usuário já está no grupo ou aconteceu algum erro");
            }


        }catch (NotBoundException e){
            e.printStackTrace();
        } catch (AccessException e) {
            e.printStackTrace();
        } catch (ConnectException e){
            System.out.println("Servidor Temporariamente indisponível");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
        return bl;
    }
}
