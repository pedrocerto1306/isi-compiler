package br.com.comp2022.isilang.ast;

import br.com.comp2022.isilang.datastructures.IsiSymbol;
import br.com.comp2022.isilang.datastructures.IsiSymbolTable;
import br.com.comp2022.isilang.datastructures.IsiVariable;
import br.com.comp2022.isilang.exceptions.IsiSemanticException;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class IsiProgram {
	private IsiSymbolTable varTable;
	private ArrayList<AbstractCommand> comandos;
	private String programName;

	public void generateJava() {
		try {
			StringBuilder str = new StringBuilder();
			str.append("import java.util.Scanner;\n");
			str.append("import java.math.*;\n");
			str.append("public class Main{ \n");
			str.append("\tpublic static void main(String args[]){\n ");
			str.append("\t\tScanner _key = new Scanner(System.in);\n");

			for (IsiVariable symbol : varTable.getAll()) {
				str.append("\t\t");
				str.append(symbol.generateJavaCode());
			}

			for (AbstractCommand command : comandos) {
				str.append("\t\t");
				str.append(command.generateJavaCode());
			}

			str.append("  }");
			str.append("}");

			try {
				FileWriter fr = new FileWriter(new File("Main.java"));
				fr.write(str.toString());
				fr.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			System.err.println("Erro na geracao de codigo: " + e);
		}
	}

	public void generateClang() {
		try {
			StringBuilder str = new StringBuilder();
			str.append("#include <stdio.h>\n");
			str.append("#include <math.h>\n");
			str.append("int main(){ \n");

			for (IsiVariable symbol : varTable.getAll()) {
				str.append("\t\t");
				str.append(symbol.generateClangCode());
			}

			for (AbstractCommand command : comandos) {
				str.append("\t\t");
				str.append(command.generateClangCode());
			}

			str.append("\treturn 0;\n");
			str.append("}");

			String IsiToCLang = str.toString().replaceAll("Math.", "");

			try {
				FileWriter fr = new FileWriter(new File("Main.c"));
				fr.write(IsiToCLang);
				fr.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			System.err.println("Erro na geracao de codigo: " + e);
		}
	}

	public void varreVarTable(IsiSymbolTable varTable) {
		for (IsiVariable symbol : varTable.getAll()) {
			if (!symbol.isInit())
				throw new IsiSemanticException("Variable not initialized: " + symbol.toString());
		}
	}

	public IsiSymbolTable getVarTable() {
		return varTable;
	}

	public void setVarTable(IsiSymbolTable varTable) {
		this.varTable = varTable;
	}

	public ArrayList<AbstractCommand> getComandos() {
		return comandos;
	}

	public void setComandos(ArrayList<AbstractCommand> comandos) {
		this.comandos = comandos;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}
}