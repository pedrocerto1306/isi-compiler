package br.com.comp2022.isilang.ast;

import br.com.comp2022.isilang.datastructures.IsiVariable;

public class ComandoLeitura extends AbstractCommand
{
    private String id;
    private IsiVariable var;

    public ComandoLeitura (String id, IsiVariable var)
	{
        this.id = id;
        this.var = var;
    }

    @Override
    public String generateJavaCode()
	{
        return    id 
                + "= _key."
                + (var.getType()==IsiVariable.NUMBER? "nextDouble();": "next();");
    }

    @Override
    public String toString()
	{
        return    "CommandLeitura"
                + "[id="
                + id
                + "]";
    }
}