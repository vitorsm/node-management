package br.cefetmg.vitor.node_management.core;

import java.io.File;
import java.io.IOException;

import br.cefetmg.vitor.node_management.Constants;

public class StartSMG {

	final private static String COMMAND = "java -jar " + Constants.SMG_PATH + File.separator + Constants.SMG_FILE_NAME;
	
	public static void start() throws IOException {
		Runtime.getRuntime().exec(COMMAND);
	}
	
}
