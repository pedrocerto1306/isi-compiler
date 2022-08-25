package br.com.comp2022.isilang.ast;

import java.util.ArrayList;

public class ComandoSe extends AbstractCommand {
	private String condicao;
	private ArrayList<AbstractCommand> listaTrue;
	private ArrayList<AbstractCommand> listaFalse;

	public ComandoSe(String condicao, ArrayList<AbstractCommand> lt, ArrayList<AbstractCommand> lf) {
		this.condicao = condicao;
		this.listaTrue = lt;
		this.listaFalse = lf;
	}

	public ArrayList<AbstractCommand> getListaTrue() {
		return listaTrue;
	}

	public void setListaTrue(ArrayList<AbstractCommand> listaTrue) {
		this.listaTrue = listaTrue;
	}

	public ArrayList<AbstractCommand> getListaFalse() {
		return listaFalse;
	}

	public void setListaFalse(ArrayList<AbstractCommand> listaFalse) {
		this.listaFalse = listaFalse;
	}

	@Override
	public String generateJavaCode() {
		StringBuilder str = new StringBuilder();
		str.append("if (" + condicao + ") {\n");
		for (AbstractCommand cmd : listaTrue) {
			str.append(cmd.generateJavaCode());
		}
		str.append("}");
		if (listaFalse.size() > 0) {
			str.append(" else {\n");
			for (AbstractCommand cmd : listaFalse) {
				str.append(cmd.generateJavaCode());
			}
			str.append("}\n");
		}
		return str.toString();
	}

	@Override
	public String generateClangCode() {
		StringBuilder str = new StringBuilder();
		str.append("if (" + condicao + ") {\n");
		for (AbstractCommand cmd : listaTrue) {
			str.append(cmd.generateJavaCode());
		}
		str.append("}");
		if (listaFalse.size() > 0) {
			str.append(" else {\n");
			for (AbstractCommand cmd : listaFalse) {
				str.append(cmd.generateJavaCode());
			}
			str.append("}\n");
		}
		return str.toString();
	}

	@Override
	public String toString() {
		return "ComandoSe "
				+ "[condicao="
				+ condicao
				+ ", listaTrue="
				+ listaTrue
				+ ", listaFalse="
				+ listaFalse
				+ "]";
	}
}