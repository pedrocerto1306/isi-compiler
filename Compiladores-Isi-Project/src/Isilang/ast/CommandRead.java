package Isilang.ast;

import  Isilang.datastructures.IsiVariable;

public class CommandRead extends AbstractCommand {

    private String id;
    private IsiVariable var;

    public CommandRead (String id, IsiVariable var) {
        this.id = id;
        this.var = var;
    }
    @Override
    public String generateJavaCode() {
        return id +"= _key." + (var.getType()==IsiVariable.NUMBER? "nextDouble();": "next();");
    }
    @Override
    public String toString() {
        return "CommandLeitura [id=" + id + "]";
    }
}
