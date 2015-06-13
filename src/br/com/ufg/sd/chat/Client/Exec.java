package br.com.ufg.sd.chat.Client;

import Common.objects.User;

import java.util.Scanner;

/**
 * Created by tales on 13/06/15.
 */
public class Exec    {
    public static void main(String[] args){
        String name = "guest";
        System.out.println("Insira seu nome de Usuário para acessar o Chat");
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
        User user = new User(name);
        System.out.println("Usuário: " + user.getName() + " Foi criado com sucesso");
        System.out.println("Entrando no Servidor...");


    }
}
