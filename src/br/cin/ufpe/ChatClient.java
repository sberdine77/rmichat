package br.cin.ufpe;

import java.rmi.*;
import javax.swing.*;
import java.util.Scanner;
import java.lang.Thread.*;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class ChatClient {
	public static void main (String args[]) throws MalformedURLException, RemoteException, NotBoundException {
		try {
			final ChatInterface chat = (ChatInterface) Naming.lookup("localhost/MyChat");
		    String nome;
		    String msg = "";
		    Scanner scanner = new Scanner(System.in);
		    System.out.println("Digite seu nome:");
		    nome = scanner.nextLine();
		    
		    Thread thread = new Thread(new Runnable() {
		    	int cont = chat.read().size();
		    	@Override
		    	public void run() {
		    		while(true){
						try {
							if (chat.read().size() > cont){
								System.out.println(chat.read().get(chat.read().size()-1));
								cont++;
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
		    	}
		    });
		    thread.start();
		    
		    while (msg != "exit") {
		    	System.out.println(nome+": ");
		    	msg = scanner.nextLine();
	
		    	chat.send(nome+": "+msg);
		    }
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
}
