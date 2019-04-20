package br.cin.ufpe;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChatImplementation extends UnicastRemoteObject implements ChatInterface {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<String> messages;
	int messageCount;

	protected ChatImplementation() throws RemoteException {
		super();
		this.messages = new ArrayList<String>();
		//this.messageCount = 0;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void send(String msg) {
		this.messages.add(msg);
	}

	@Override
	public ArrayList<String> read() {
		return this.messages;
	}

}
