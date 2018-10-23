package br.cefetmg.vitor.node_management.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import br.cefetmg.vitor.node_management.Constants;
import br.cefetmg.vitor.node_management.models.ExecutorData;

public class ServerExecutor implements Runnable {
	
	private SuperNodeCore core;
	
	public ServerExecutor(SuperNodeCore core) {
		this.core = core;
	}
	
	@Override
	public void run() {
		
		while (true) {
			
			try {
				ObjectInputStream objIn = new ObjectInputStream(core.getNodeExecutor().getClient().getInputStream());
				Object object = objIn.readObject();
				
				if (object instanceof ExecutorData) {
				
					ExecutorData data = (ExecutorData) object;
					
					if (data.getFile() != null) {
						updateDataBaseFile(data.getFile());
					}
					
					if (!data.isIdle()) {
						core.setNodeExecutor(null);
					}
				}
				
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void updateDataBaseFile(byte[] fileBytes) throws IOException {
		
		File localFile = new File(Constants.SMG_PATH + File.separator + Constants.DATABASE_FILE_NAME);
		localFile.createNewFile();
		
		FileOutputStream fileOut = new FileOutputStream(localFile);
		fileOut.write(fileBytes, 0, fileBytes.length);
	}

}
