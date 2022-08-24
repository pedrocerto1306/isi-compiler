package br.com.comp2022.isilang.main;

import org.antlr.v4.runtime.CharStreams;

import br.com.comp2022.isilang.exceptions.IsiSemanticException;
import br.com.comp2022.isilang.parser.IsiLangLexer;
import br.com.comp2022.isilang.parser.IsiLangParser;

public class Main {
    public static void main(String[] args) {
        try {
            IsiLangLexer lexer;
            IsiLangParser parser;

            lexer = new IsiLangLexer(CharStreams.fromFileName("script.isi"));

            parser = new IsiLangParser(new org.antlr.v4.runtime.CommonTokenStream(lexer));

            parser.prog();

            System.out.println("Build Successful!");

            parser.generateJavaCode();
        } catch (IsiSemanticException isiEx) {
            System.err.println("Isi Semantic Error: " + isiEx.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

// java -cp .:antlr-4.10.1-complete.jar -jar
// C:\Javalib\antlr-4.10.1-complete.jar IsiLang.g4 -package
// br.com.comp2022.isilang.parser -o ./src/br/com/comp2022/isilang/parser