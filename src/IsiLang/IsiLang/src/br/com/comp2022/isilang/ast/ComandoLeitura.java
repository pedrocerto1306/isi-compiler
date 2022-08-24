package br.com.comp2022.isilang.ast;

import br.com.comp2022.isilang.datastructures.IsiVariable;

public class ComandoLeitura extends AbstractCommand {
    private String id;
    private IsiVariable var;

    public ComandoLeitura(String id, IsiVariable var) {
        this.id = id;
        this.var = var;
    }

    public IsiVariable getVar() {
        return var;
    }

    public void setVar(IsiVariable var) {
        this.var = var;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String generateJavaCode() {
        return id
                + "= _key."
                + (var.getType() == IsiVariable.NUMBER ? "nextDouble();" : "next();");
    }

    @Override
    public String toString() {
        return "CommandLeitura"
                + "[id="
                + id
                + "]";
    }
}