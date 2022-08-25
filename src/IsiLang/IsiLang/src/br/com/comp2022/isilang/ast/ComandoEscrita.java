package br.com.comp2022.isilang.ast;

import br.com.comp2022.isilang.datastructures.IsiVariable;

public class ComandoEscrita extends AbstractCommand {
	private String id;
	private String texto;
	private String regex;

	public ComandoEscrita(String id) {
		this.id = id;
		this.texto = null;
	}

	public ComandoEscrita(IsiVariable var) {
		this.id = var.getName();
		this.texto = var.getValue();

		this.regex = var.getType() == IsiVariable.TEXT ? "\"%s\"" : "\"%lf\"";
	}

	public ComandoEscrita(String texto, boolean isText) {
		if (isText) {
			this.texto = texto;
			this.id = null;
			this.regex = "\"%lf\"";
		} else {
			this.id = texto;
			this.texto = null;
			this.regex = "\"%s\"";
		}
	}

	@Override
	public String generateJavaCode() {
		if (id == null) {
			return "System.out.println(" + texto + ");\n";
		} else {
			return "System.out.println(" + id + ");\n";
		}

	}

	@Override
	public String generateClangCode() {
		if (id == null) {
			return "printf(" + texto + ");\n";
		} else {
			return "printf(" + this.regex + "," + id + ");\n";
		}
	}

	@Override
	public String toString() {
		return "CommandEscrita"
				+ "[id="
				+ id
				+ "]"
				+ "[texto="
				+ texto
				+ "]";
	}
}