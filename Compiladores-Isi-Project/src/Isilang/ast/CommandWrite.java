package Isilang.ast;

public class CommandWrite extends AbstractCommand{

    private String id;

    public CommandWrite(String id) {
        this.id = id;
    }
    @Override
    public String generateJavaCode() {
        return "System.out.println(" + id + ");";
    }

    @Override
    public String toString() {
        return "CommandWrite{" +
                "id='" + id + '\'' +
                '}';
    }
}
