package Isilang.ast;

public class CommandAttribution extends AbstractCommand{
    private String id;
    private String expr;

    public CommandAttribution(String id, String expr) {
        this.id = id;
        this.expr = expr;
    }
    @Override
    public String generateJavaCode() {
        return id + " = "+expr+";";
    }
    @Override
    public String toString() {
        return "CommandAtribuicao [id=" + id + ", expr=" + expr + "]";
    }
}
