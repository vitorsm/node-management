package br.cefetmg.vitor.node_management.models;

import java.net.Socket;

public class Node {
	
	private boolean isIdle;
	private Socket client;
	
	public boolean isIdle() {
		return isIdle;
	}
	public void setIdle(boolean isIdle) {
		this.isIdle = isIdle;
	}
	public Socket getClient() {
		return client;
	}
	public void setClient(Socket client) {
		this.client = client;
	}
	
}
