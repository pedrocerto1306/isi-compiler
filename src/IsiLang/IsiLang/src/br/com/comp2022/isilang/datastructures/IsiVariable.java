package br.com.comp2022.isilang.datastructures;

public class IsiVariable extends IsiSymbol {
    public static final int NUMBER = 0;
    public static final int TEXT = 1;
    public static final int INTEGER = 2;

    private int type;
    private String value;
    private boolean isInit = false;

    public IsiVariable(String name, int type, String value) {
        super(name);
        this.type = type;
        this.value = value;
    }

    public boolean isInit() {
        return isInit;
    }

    public void setInit(boolean isInit) {
        this.isInit = isInit;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "IsiVariable [name=" + name + ", type=" + type + ", value=" + value + "]";
    }

    @Override
    public String generateJavaCode() {
        String str;
        if (type == NUMBER) {
            str = "double ";
        } else if (type == TEXT) {
            str = "String ";
        } else {
            str = "int ";
        }
        return str + " " + super.name + ";\n";
    }

    public String generateClangCode() {
        String str;
        if (type == NUMBER) {
            str = "double " + super.name + ";\n";
        } else if (type == TEXT) {
            str = "char " + super.name + "[255];\n";
        } else {
            str = "int " + super.name + ";\n";
        }
        return str;
    }
}