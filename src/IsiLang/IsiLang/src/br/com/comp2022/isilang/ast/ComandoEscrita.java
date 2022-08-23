package br.com.comp2022.isilang.ast;

public class ComandoEscrita extends AbstractCommand
{
	private String id;
	private String texto;
	
	public ComandoEscrita(String id)
	{
		this.id = id;
		this.texto = null;
	}

	public ComandoEscrita(String texto, boolean isText)
	{
		if (isText)
		{
			this.texto = texto;
			this.id = null;
		} else
		{
			this.id = texto;
			this.texto = null;
		}
	}

	@Override
	public String generateJavaCode()
	{
		if (id == null)
		{
			return "System.out.println(" + texto + ");";
		} else
		{
			return "System.out.println(" + id + ");";
		}
		
	}

	@Override
	public String toString()
	{
		return    "CommandEscrita"
				+ "[id="
				+ id
				+ "]"
				+ "[texto="
				+ texto
				+ "]";
	}
}