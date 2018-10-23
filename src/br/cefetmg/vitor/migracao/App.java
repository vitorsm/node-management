package br.cefetmg.vitor.migracao;

import br.cefetmg.vitor.migracao.core.SimpleNodeCore;
import br.cefetmg.vitor.migracao.core.SuperNodeCore;

public class App {

	public static void main(String[] args) {
		
		if (args != null && args.length >= 1) {
			SimpleNodeCore core = new SimpleNodeCore(args[0]);
			core.run();
		} else {
			SuperNodeCore core = new SuperNodeCore();
			core.run();
		}
	}
	
}
