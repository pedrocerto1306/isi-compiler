package Isilang.main;

import org.antlr.v4.runtime.CharStreams;


import Isilang.parser.IsiLangLexer;
import Isilang.parser.IsiLangParser;



public class Main {
	public static void main(String[] args) {

		try {
            IsiLangLexer lexer;
            IsiLangParser parser;

			lexer = new IsiLangLexer(CharStreams.fromFileName("IsiTeste.isi"));
			System.out.println("IsiTeste.isi, recebido!");
			lexer.removeErrorListeners();
			

			parser = new IsiLangParser(new org.antlr.v4.runtime.CommonTokenStream(lexer));
			System.out.println("IsiTeste.isi, lido!");
			
			parser.prog();

			parser.generateJavaCode();

			System.out.println("IsiTeste.isi, Compilado!");
			
		}
		catch(Exception ex) {
			System.err.println("ERROR "+ex.getMessage());
		}
		
	}

}

// java -cp .:antlr-4.10.1-complete.jar -jar
// C:\Javalib\antlr-4.10.1-complete.jar IsiLang.g4 -package
//old path
// br.com.comp2022.isilang.parser -o ./src/br/com/comp2022/isilang/parser