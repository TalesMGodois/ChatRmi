package br.com.ufg.sd.chat.Client;

import Common.interfaces.IUser;

/**
 * Created by tales on 13/06/15.
 */
public class TEnvio implements Runnable {

    public TEnvio(String msg){
        System.out.println("Enviando Mensagem");
    }

    public TEnvio(IUser user){

        System.out.println("Enviando Usuario");
    }

    @Override
    public void run() {
        System.out.println("Thread de envio");
    }
}
