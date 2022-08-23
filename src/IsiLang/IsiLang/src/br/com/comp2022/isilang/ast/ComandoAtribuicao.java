package br.com.comp2022.isilang.ast;

import br.com.comp2022.isilang.datastructures.IsiVariable;

public class ComandoAtribuicao extends AbstractCommand
{
	private String id;
	private String expr;
	
	public ComandoAtribuicao(String id, String expr)
    {
		this.id = id;
		this.expr = expr;
	}

	@Override
	public String generateJavaCode()
    {
		return id + " = " + expr + ";";
	}

	@Override
	public String toString()
    {
		return    "CommandAtribuicao"
                + "[id="
                + id
                + ", expr="
                + expr
                + "]";
	}
}