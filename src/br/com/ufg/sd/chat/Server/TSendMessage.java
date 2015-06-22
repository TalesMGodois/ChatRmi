package br.com.ufg.sd.chat.Server;

import Common.interfaces.IMessage;
import Common.interfaces.IReceiver;
import Common.interfaces.IUser;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by tales on 21/06/15.
 */
public class TSendMessage implements Runnable {
    private int workerNumbers;
    private IMessage message;


    public TSendMessage(int workerNumbers,IMessage msg){
        this.workerNumbers = workerNumbers;
        this.message = msg;
    }

    public boolean isSame(IUser user1, IUser user2){
        if(user1.getDoor() == user1.getDoor() && user1.getIp().equals(user2.getIp()) && user1.getName().equals(user2.getName())){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public void run() {
        IMessage msg = this.message;
        IUser user = msg.getUser();

        for(IUser usr : Server.getUsers()){
            if(!isSame(usr,user)){
                try {
                    Registry r = LocateRegistry.getRegistry(usr.getIp(), usr.getDoor());
                    IReceiver client = (IReceiver)r.lookup("ReceiverService");
                    client.receive(this.message);
                } catch (NotBoundException e){
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
            }

        }


    }
}
