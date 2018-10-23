package br.cefetmg.vitor.node_management;

import br.cefetmg.vitor.node_management.core.SimpleNodeCore;
import br.cefetmg.vitor.node_management.core.SuperNodeCore;

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
