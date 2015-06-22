package br.com.ufg.sd.chat.Client;

import Common.objects.User;

import java.util.Scanner;
import java.util.concurrent.Callable;

/**
 * Created by tales on 21/06/15.
 */
public class TInitial extends Thread {

    public void run(){
        try {
            this.sendThreads();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendThreads() throws Exception {
        String name = "guest";
        System.out.println("Insira seu nome de Usuário para acessar o Chat");
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
        User user = new User(name);
        System.out.println("Usuário: " + user.getName() + " Foi criado com sucesso");
        TValidUser t = new TValidUser(user);
        Callable<Boolean> envio = new TValidUser(user);
        boolean isSending = envio.call();
        if(isSending){
            TSendMonitor ts = new TSendMonitor(user);
            Thread tsMonitor = new Thread(ts);
            tsMonitor.start();
        }else{
            sendThreads();
        }
    }
}
