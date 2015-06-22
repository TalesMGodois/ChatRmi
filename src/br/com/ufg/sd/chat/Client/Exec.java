package br.com.ufg.sd.chat.Client;

import Common.interfaces.IUser;
import Common.objects.User;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.Callable;

/**
 * Created by tales on 13/06/15.
 */
public class Exec    {
    private static boolean isValid = false;


    public static void main(String[] args) throws Exception {
        TInitial initial = new TInitial();
        initial.start();
        Host.self().start();

    }
}
