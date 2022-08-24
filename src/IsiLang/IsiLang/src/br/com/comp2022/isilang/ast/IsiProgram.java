package br.com.comp2022.isilang.ast;

import br.com.comp2022.isilang.datastructures.IsiSymbol;
import br.com.comp2022.isilang.datastructures.IsiSymbolTable;
import br.com.comp2022.isilang.datastructures.IsiVariable;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class IsiProgram {
	private IsiSymbolTable varTable;
	private ArrayList<AbstractCommand> comandos;
	private String programName;
	private ArrayList<IsiVariable> testeArray;

	public void generateTarget() {
		try {
			StringBuilder str = new StringBuilder();
			str.append("import java.util.Scanner;\n");
			str.append("public class Main{ \n");
			str.append("  public static void main(String args[]){\n ");
			str.append("      Scanner _key = new Scanner(System.in);\n");

			for (IsiVariable symbol : varTable.getAll()) {
				str.append(symbol.generateJavaCode() + "\n");
			}

			for (AbstractCommand command : comandos) {
				str.append(command.generateJavaCode() + "\n");
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