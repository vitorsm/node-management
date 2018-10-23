package br.cefetmg.vitor.migracao.core;

public class SimpleNodeCore {

	private String serverIp;
	
	public SimpleNodeCore(String serverIp) {
		this.serverIp = serverIp;
	}
	
	public void run() {
		System.out.println("teste");
	}
}
