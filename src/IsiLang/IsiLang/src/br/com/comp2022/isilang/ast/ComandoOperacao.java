package br.com.comp2022.isilang.ast;

import br.com.comp2022.isilang.exceptions.*;

public class ComandoOperacao extends AbstractCommand {

    private String n1;
    private String op;
    private String n2;

    private String result;

    public ComandoOperacao(String n1, String op) {
        this.n1 = n1;
        this.op = op;

        if ((char) this.op.charAt(0) == '$') {
            this.result = "Math.sqrt(" + this.n1 + ")";
        } else if ((char) this.op.charAt(0) == '#') {
            this.result = "Math.log(" + this.n1 + ")";
        } else {
            throw new IsiSemanticException("Operator not recognized: " + this.op);
        }
    }

    public ComandoOperacao(String n1, String op, String n2) {
        this.n1 = n1;
        this.op = op;
        this.n2 = n2;

        if ((char) this.op.charAt(0) == '^') {
            this.result = "Math.pow(" + this.n1 + "," + this.n2 + ")";
        } else {
            this.result = this.n1 + " " + this.op + " " + this.n2;
        }
    }

    public String getExpression() {
        return this.result;
    }

    @Override
    public String generateJavaCode() {
        if ((char) this.op.charAt(0) == '^') {
            return "Math.pow(" + this.n1 + "," + this.n2 + ")";
        } else if ((char) this.op.charAt(0) == '$') {
            return "Math.sqrt(" + this.n1 + ")";
        } else if ((char) this.op.charAt(0) == '#') {
            return "Math.log(" + this.n1 + ")";
        } else {
            return this.n1 + " " + this.op + " " + this.n2;
        }
    }

    @Override
    public String generateClangCode() {
        if ((char) this.op.charAt(0) == '^') {
            return "pow(" + this.n1 + "," + this.n2 + ")";
        } else if ((char) this.op.charAt(0) == '$') {
            return "sqrt(" + this.n1 + ")";
        } else if ((char) this.op.charAt(0) == '#') {
            return "log(" + this.n1 + ")";
        } else {
            return this.n1 + " " + this.op + " " + this.n2;
        }
    }

    @Override
    public String toString() {
        return "ComandoOperacao"
                + "[Num 1="
                + n1
                + ", Num 2="
                + n2
                + ", Oper ="
                + op
                + "]";
    }
}
