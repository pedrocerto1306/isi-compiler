package br.com.comp2022.isilang.datastructures;

import java.util.HashMap;

public class IsiSymbolTable {

    private HashMap<String, IsiSymbol> map;

    public IsiSymbolTable() {
        map = new HashMap<String, IsiSymbol>();
    }

    public void add(IsiSymbol symbol) {
        map.put(symbol.getName(), symbol);
    }

    public boolean exists(String symbolName) {
        return map.get(symbolName) != null;
    }

    public IsiSymbol get(String symbolName) {
        return map.get(symbolName);
    }

    public IsiVariable getVar(String varName) {
        return (IsiVariable) map.get(varName);
    }

}
