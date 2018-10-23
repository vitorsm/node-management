package br.cefetmg.vitor.node_management.core;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import br.cefetmg.vitor.node_management.Constants;
import br.cefetmg.vitor.node_management.models.ExecutorData;
import br.cefetmg.vitor.node_management.models.Message;
import br.cefetmg.vitor.node_management.models.Node;

public class SuperNodeCore {
	private List<Node> nodes;
	private boolean active;
	private Node nodeExecutor;
	
	public SuperNodeCore() {
		nodes = new ArrayList<Node>();
		active = true;
	}
	
	
	public void setNodeExecutor(Node node) throws IOException {
		this.nodeExecutor = node;
		
		if (node != null) {
			sendExecutorData();
		} else {
			setSuperNodeAsExecutor();
		}
	}
	
	public Node getNodeExecutor() {
		return this.nodeExecutor;
	}
	
	public void joinning(Socket client) {
		Node node = new Node();
		node.setClient(client);
		nodes.add(node);
	}
	
	public void run() {
		
		ServerAccept server = new ServerAccept(this);
		Thread t = new Thread(server);
		t.start();
		
	}

	public void findExecutor() throws IOException, ClassNotFoundException {
		
		for (Node node : nodes) {
			ObjectOutputStream objOutputStream = new ObjectOutputStream(node.getClient().getOutputStream());
			objOutputStream.writeObject(Message.REQUEST_STATUS);
			
			ObjectInputStream objInputStream = new ObjectInputStream(node.getClient().getInputStream());
			Object object = objInputStream.readObject();
			
			if (object instanceof Message) {
				Message message = (Message) object;
				
				if (message == Message.RESPONSE_STATUS_IDLE) {
					setNodeExecutor(node);
					break;
				}
			}
		}
	}
	
	private void sendExecutorData() throws IOException {
		ObjectOutputStream objOutputStream = new ObjectOutputStream(nodeExecutor.getClient().getOutputStream());
		
		File file = new File(Constants.SMG_PATH + File.separator + Constants.DATABASE_FILE_NAME);
		if (!file.exists())
			file = null;
		
		ExecutorData executorData = new ExecutorData(file);
		
		objOutputStream.writeObject(executorData);
	}
	
	private void setSuperNodeAsExecutor() throws IOException {
		StartSMG.start();
	}
}
