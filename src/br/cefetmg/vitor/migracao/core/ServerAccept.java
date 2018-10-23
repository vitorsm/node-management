package br.cefetmg.vitor.migracao.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import br.cefetmg.vitor.migracao.Constants;

public class ServerAccept implements Runnable {

	private SuperNodeCore core;
	
	public ServerAccept(SuperNodeCore core) {
		this.core = core;
	}
	
	@Override
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(Constants.SERVER_PORT);
			
			Socket client = serverSocket.accept();
			core.joinning(client);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
