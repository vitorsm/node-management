package br.cefetmg.vitor.migracao.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExecutorData {
	
	private byte[] file;
	private boolean idle;

	public ExecutorData(File file) {
		try {
			this.file = convertFileToBytes(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public byte[] getFile() {
		return this.file;
	}
	
	public boolean isIdle() {
		return idle;
	}

	public void setIdle(boolean idle) {
		this.idle = idle;
	}
	
	private byte[] convertFileToBytes(File file) throws IOException {
		int lengthFile = (int) file.length();
		byte[] fileBytes = new byte[lengthFile];
		
		FileInputStream fileIn = new FileInputStream(file);

		fileIn.read(fileBytes, 0, lengthFile);
		
		return fileBytes;
	}
}
