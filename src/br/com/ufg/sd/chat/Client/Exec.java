package br.com.ufg.sd.chat.Client;

import Common.objects.User;
import com.sun.xml.internal.stream.util.ThreadLocalBufferAllocator;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by tales on 13/06/15.
 */
public class Exec    {
    public static void main(String[] args) throws RemoteException, NotBoundException, AlreadyBoundException, NoSuchElementException {
        String name = "guest";
        System.out.println("Insira seu nome de Usuário para acessar o Chat");
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
        User user = new User(name);
        System.out.println("Usuário: " + user.getName() + " Foi criado com sucesso");
        System.out.println("Entrando no Servidor...");
        TEnvio t = new TEnvio(user);
        Thread envio = new Thread(t);
        envio.start();

        TSendMonitor ts = new TSendMonitor(user);
        Thread tsMonitor = new Thread(ts);
        tsMonitor.start();

    }
}
