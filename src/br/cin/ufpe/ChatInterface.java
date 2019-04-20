package br.cin.ufpe;
import java.rmi.Remote;
import java.util.ArrayList;

public interface ChatInterface extends Remote {
	void send (String msg) throws Exception;
	ArrayList<String> read () throws Exception;
}
