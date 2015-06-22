package br.com.ufg.sd.chat.Client;

import Common.interfaces.IUser;
import Common.objects.Message;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * Created by tales on 14/06/15.
 */
public class TSendMonitor implements Runnable {
    private IUser user;

    public TSendMonitor(IUser user){
        this.user = user;
    }

    @Override
    public void run() {
        while(true){
            System.out.printf(">> ");
            Scanner input = new Scanner(System.in);
            String msg = input.nextLine();
            System.out.println(msg);
            Message message = new Message(msg);
            try {
                this.user.sendMessage(message);
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            } catch (AlreadyBoundException e) {
                e.printStackTrace();
            }
        }
    }
}
