package br.com.comp2022.isilang.ast;

import java.util.ArrayList;

public class ComandoRep extends AbstractCommand 
{
	private String condicao;
	private ArrayList<AbstractCommand> comandoRep;

	public ComandoRep(String condicao, ArrayList<AbstractCommand> comandoRep)
	{
		this.condicao = condicao;
		this.comandoRep = comandoRep;
	}

	public String generateJavaCode()
	{
		StringBuilder str = new StringBuilder();
		str.append("while (" + condicao + ") {\n");
		for (AbstractCommand cmd : comandoRep)
		{
			str.append(cmd.generateJavaCode());
		}
		str.append("}\n");
		return str.toString();
	}
	
	@Override
	public String toString()
	{
		return    "ComandoRep "
				+ "[condicao=" 
				+ condicao
				+ ", comandoRep="
				+ comandoRep
				+ "]";
	}
}