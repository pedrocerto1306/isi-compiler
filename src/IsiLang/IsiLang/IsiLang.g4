grammar IsiLang;

@header {
    import br.com.comp2022.isilang.datastructures.IsiSymbol;
    import br.com.comp2022.isilang.datastructures.IsiVariable;
    import br.com.comp2022.isilang.datastructures.IsiSymbolTable;
    import br.com.comp2022.isilang.exceptions.IsiSemanticException;
    import java.util.ArrayList;
}

@members {
    private int _tipo;
    private String _varName;
    private String _varValue;
    private IsiSymbolTable symbolTable = new IsiSymbolTable();
    private IsiSymbol symbol;

    public void verificaTabelaDeSimbolos(String id){
        if(!symbolTable.exists(id)){
            throw new IsiSemanticException("Symbol not declared: "+id);
        }
    }

    public void verificaCompatibilidade(IsiVariable var1, IsiVariable var2){
        if(var1.getType() != var2.getType()){
            throw new IsiSemanticException("Type mismatch: "+var1.toString()+var2.toString());
        }
    }
}

prog: 'programa' bloco 'fimprog.' {  };

bloco: (cmd)+;

cmd:
	cmdescrita
	| cmdleitura
	| cmdattrib
	| cmddeclara
	| cmdcondicao
	| cmdrepeticao;

cmddeclara:
	'declare' tipo ID {
            _varName = _input.LT(-1).getText();
            _varValue = null;
            symbol = new IsiVariable(_varName, _tipo, _varValue);
            if(!symbolTable.exists(_varName)){
                symbolTable.add(symbol);
            }else{
                throw new IsiSemanticException("Symbol already declared: "+_varName);
            }
            
        } (
		VIR ID {
            _varName = _input.LT(-1).getText();
            _varValue = null;
            symbol = new IsiVariable(_varName, _tipo, _varValue);
            if(!symbolTable.exists(_varName)){
                symbolTable.add(symbol);
            }else{
                throw new IsiSemanticException("Symbol already declared: "+_varName);
            }
        }
	)* PT;

tipo:
	'number' {_tipo = IsiVariable.NUMBER;}
	| 'text' {_tipo = IsiVariable.TEXT;}
	| 'bool' {_tipo = IsiVariable.BOOLEAN;};

cmdescrita:
	'escreva' AP ID { verificaTabelaDeSimbolos(_input.LT(-1).getText()); } FP PT;

cmdleitura:
	'leia' AP ID { verificaTabelaDeSimbolos(_input.LT(-1).getText()); } FP PT;

cmdattrib:
	ID { verificaTabelaDeSimbolos(_input.LT(-1).getText()); } ATTR expr PT {
        _varName = _input.LT(-4).getText();

        IsiVariable var1 = symbolTable.getVar(_varName);

        // verificaCompatibilidade(var1, _input.LT(-2));
		};

cmdcondicao:
	'se' AP ID OPREL (ID | NUMBER) FP 'entao' ACH (cmd)+ FCH (
		'senao' ACH (cmd)+ FCH
	)?
	| 'escolha' AP ID FP ACH (
		'caso' AP (ID | NUMBER) FP DP (cmd)+ 'quebra.'
	)* FCH;

cmdrepeticao:
	'enquanto' AP ID OPREL (ID | NUMBER) FP 'faça' ACH (cmd)+ FCH { //System.out.println("Sintaxe do laço funcionando!") ;
		};

expr: termo (OP termo)*;

termo:
	ID { verificaTabelaDeSimbolos(_input.LT(-1).getText()); }
	| NUMBER
	| TEXT
	| BOOL;

DP: ':';

AP: '(';

FP: ')';

ATTR: ':=';

PT: '.';

OP: '+' | '-' | '*' | '/' | '^' | '%' | '#';

ACH: '{';

FCH: '}';

VIR: ',';

OPREL: '>' | '<' | '>=' | '<=' | '==' | '!=';

ID: [a-z] ([a-z] | [A-Z] | [0-9])*;

NUMBER: [0-9]+ (';' [0-9]+)?;

TEXT: ASP ID ASP;

BOOL: 'verdadeiro' | 'falso';

ASP: '"';

WP: (' ' | '\t' | '\n' | '\r') -> skip;
