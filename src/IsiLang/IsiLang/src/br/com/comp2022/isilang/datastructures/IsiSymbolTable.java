package br.com.comp2022.isilang.datastructures;

import java.util.ArrayList;
import java.util.HashMap;

public class IsiSymbolTable {

    private HashMap<String, IsiVariable> map;

    public IsiSymbolTable() {
        map = new HashMap<String, IsiVariable>();
    }

    public void add(IsiVariable symbol) {
        map.put(symbol.getName(), symbol);
    }

    public boolean exists(String symbolName) {
        return map.get(symbolName) != null;
    }

    public IsiVariable get(String symbolName) {
        return map.get(symbolName);
    }

    public ArrayList<IsiVariable> getAll() {
        return new ArrayList<IsiVariable>(map.values());
    }

    public void replace(String id, IsiVariable newSymbol) {
        map.replace(id, newSymbol);
    }

    public IsiVariable getVar(String varName) {
        return (IsiVariable) map.get(varName);
    }

}
