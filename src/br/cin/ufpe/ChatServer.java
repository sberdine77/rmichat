package br.cin.ufpe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ChatServer {
	public static void main (String args[]) {
		try {
			ChatImplementation chat = new ChatImplementation();
			System.out.println("Criando registro");
			LocateRegistry.createRegistry(1099);
			System.out.println("Obtendo registro");
			Registry registry = LocateRegistry.getRegistry();
			System.out.println("Servidor Criado");
			// Bind the remote object's stub in the registry
			registry.rebind("localhost/MyChat", chat);
			System.out.println("chat server ready.");
			System.out.println("Digite <ENTER> para encerrar");
			BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
			// O buffered reader serve apenas para "parar" a execução
			b.read();
		} catch (Exception e) {
			System.out.println("chat server main " + e.getMessage());
		}
	}
}
