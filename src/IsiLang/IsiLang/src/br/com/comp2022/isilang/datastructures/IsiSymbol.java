package br.com.comp2022.isilang.datastructures;

public abstract class IsiSymbol {

    protected String name;

    public abstract String generateJavaCode();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IsiSymbol(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "IsiSymbol [name=" + name + "]";
    }
}