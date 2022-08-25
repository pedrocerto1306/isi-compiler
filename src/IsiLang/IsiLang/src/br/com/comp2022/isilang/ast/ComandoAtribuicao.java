package br.com.comp2022.isilang.ast;

import br.com.comp2022.isilang.datastructures.IsiVariable;

public class ComandoAtribuicao extends AbstractCommand {
	private String id;
	private String expr;
	private int type;

	public ComandoAtribuicao(String id, String expr) {
		this.id = id;
		this.expr = expr;
	}

	public ComandoAtribuicao(IsiVariable var, String expr) {
		this.id = var.getName();
		this.expr = expr;
		this.type = var.getType();
	}

	@Override
	public String generateJavaCode() {
		return id + " = " + expr + ";\n";
	}

	@Override
	public String generateClangCode() {
		if (this.type == IsiVariable.TEXT) {
			return "strcpy(" + id + "," + expr + ");\n";
		} else {
			return id + "=" + expr + ";\n";
		}
	}

	@Override
	public String toString() {
		return "CommandAtribuicao"
				+ "[id="
				+ id
				+ ", expr="
				+ expr
				+ "]";
	}
}