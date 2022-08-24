grammar IsiLang;

@header {
    import br.com.comp2022.isilang.datastructures.IsiSymbol;
    import br.com.comp2022.isilang.datastructures.IsiVariable;
    import br.com.comp2022.isilang.datastructures.IsiSymbolTable;
    import br.com.comp2022.isilang.exceptions.IsiSemanticException;
    import java.util.ArrayList;

    import br.com.comp2022.isilang.ast.IsiProgram;
    import br.com.comp2022.isilang.ast.AbstractCommand;
    import br.com.comp2022.isilang.ast.ComandoAtribuicao;
    import br.com.comp2022.isilang.ast.ComandoLeitura;
    import br.com.comp2022.isilang.ast.ComandoEscrita;
    import br.com.comp2022.isilang.ast.ComandoEscrita;
    import br.com.comp2022.isilang.ast.ComandoRep;
    import br.com.comp2022.isilang.ast.ComandoSe;
    import java.util.ArrayList;
    import java.util.Stack;
}

@members {
    private int _tipo;
    private String _varName;
    private String _varValue;
    private IsiSymbolTable symbolTable = new IsiSymbolTable();
    private IsiSymbol symbol;
    private IsiVariable variable;
    private String _exprContent;
    private String _readID;
    private String _writeID;
    private String _exprDecision;
    private String _exprID;
    private IsiProgram program = new IsiProgram();
    private ArrayList<AbstractCommand> curThread;
    private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
    private ArrayList<AbstractCommand> listTrue;
    private ArrayList<AbstractCommand> listFalse;

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

    public boolean verificaInicializacao(String id) {
        if(symbolTable.exists(id)){
            return symbolTable.getVar(id).isInit();
        }else{
            throw new IsiSemanticException("Variable `"+id+"` not initialized");
        }
    }

    public void initializeVar(String id) {
        if(symbolTable.exists(id)){
            IsiVariable var = symbolTable.getVar(id);
            var.setInit(true);
            symbolTable.replace(id, var);
            System.out.println("Variavel inicializada");
        }else{
            throw new IsiSemanticException("Variable not initialized");
        }
    }

    public boolean isNumber(String id){
        if(symbolTable.exists(id)){
            IsiVariable var = symbolTable.getVar(id);
            if(var.getType() == IsiVariable.NUMBER)
                return true;
            return false;
        }
        return false;
    }

    public void generateJavaCode(){
        program.generateTarget();
    }

}

prog:
	'programa' bloco 'fimprog.' {
            program.setVarTable(symbolTable);
            program.setComandos(stack.pop());
        };

bloco:
	{
        curThread = new ArrayList<AbstractCommand>();
        stack.push(curThread);
    } (cmd)+;

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
            variable = new IsiVariable(_varName, _tipo, _varValue);
            if(!symbolTable.exists(_varName)){
                symbolTable.add(variable);
            }else{
                throw new IsiSemanticException("Symbol already declared: "+_varName);
            }
            
        } (
		VIR ID {
            _varName = _input.LT(-1).getText();
            _varValue = null;
            variable = new IsiVariable(_varName, _tipo, _varValue);
            if(!symbolTable.exists(_varName)){
                symbolTable.add(variable);
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
	'escreva' AP ID { 
                        verificaTabelaDeSimbolos(_input.LT(-1).getText());
                        verificaInicializacao(_input.LT(-1).getText());
                    } FP PT {
                        ComandoEscrita cmd = new ComandoEscrita(_writeID);
                        stack.peek().add(cmd);   
                    };

cmdleitura:
	'leia' AP ID { 
                    verificaTabelaDeSimbolos(_input.LT(-1).getText()); 
                } FP PT {
                    initializeVar(_readID);
                    IsiVariable var = symbolTable.getVar(_readID);
                    ComandoLeitura cmd = new ComandoLeitura(_readID, var);
                    stack.peek().add(cmd);
                };

cmdattrib:
	ID { 
            _exprID = _input.LT(-1).getText();
            verificaTabelaDeSimbolos(_exprID); 
        } ATTR { _exprContent = ""; } expr PT {
            initializeVar(_exprID);
            //verifyType(_exprID, _exprContent); //Comparar o tipo da variavel com o tipo da expressão
            ComandoAtribuicao cmd = new ComandoAtribuicao(_exprID, _exprContent);
            stack.peek().add(cmd);
		};

cmdcondicao:
	'se' AP {
                ArrayList<AbstractCommand> trueThread = new ArrayList<AbstractCommand>();
                ArrayList<AbstractCommand> falseThread = new ArrayList<AbstractCommand>();
                ArrayList<AbstractCommand> listTrue = new ArrayList<AbstractCommand>();
                ArrayList<AbstractCommand> listFalse = new ArrayList<AbstractCommand>();
            } boolExpr FP { ComandoSe cmd = new ComandoSe(_exprDecision, listTrue, listFalse);  }
		'entao' ACH { 
                    trueThread = new ArrayList<AbstractCommand>();
                    stack.push(trueThread);
                } (cmd)+ FCH {
                    listTrue = stack.pop();
                } (
		'senao' ACH {
                        falseThread = new ArrayList<AbstractCommand>();
                        stack.push(falseThread);
                    } (cmd)+ FCH {
                    listFalse = stack.pop();
                }
	)? {
        cmd.setListaTrue(listTrue);
        cmd.setListaFalse(listFalse);
        stack.peek().add(cmd);
    }
	| 'escolha' AP ID FP ACH (
		'caso' AP (VAR) FP DP (cmd)+ 'quebra.'
	)* FCH;

cmdrepeticao:
	'enquanto' AP {
        ArrayList<AbstractCommand> whileThread = new ArrayList<AbstractCommand>();
        ArrayList<AbstractCommand> whileList = new ArrayList<AbstractCommand>();
    } boolExpr FP { ComandoRep cmd = new ComandoRep(_exprDecision, whileList); } 'faça' ACH {
        whileThread = new ArrayList<AbstractCommand>();
        stack.push(whileThread);
    } (cmd)+ FCH { 
        whileList = stack.pop();
        cmd.setComandoRep(whileList);
        stack.peek().add(cmd);
    };

termo:
	ID { verificaTabelaDeSimbolos(_input.LT(-1).getText()); }
	| NUMBER
	| TEXT
	| BOOL;

expr:
	exprTermo (
		OP { _exprContent += _input.LT(-1).getText(); } exprTermo
	)*;

exprTermo:
	ID {
                    String id = _input.LT(-1).getText();
                    if(!symbolTable.exists(_input.LT(-1).getText())){
                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _input.LT(-1).getText()  + "` NOT declared");
                    }
                    if(!verificaInicializacao(_input.LT(-1).getText())){
                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _input.LT(-1).getText()  + "` NOT initialized");
                    }
                    if(!isNumber(_input.LT(-1).getText())){
                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Comparsion operations are expectating a 'numero' type, NOT a 'texto' type");
                    }
                    if(isNumber(_exprID) && !isNumber(id)){
                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` expectating a 'numero' type, NOT a 'texto' type");
                    }
                    _exprContent += _input.LT(-1).getText();

              }
	| NUMBER {
                    if(!isNumber(_exprID)){
                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` expectating a 'text' type, NOT a 'number' type");
                    }
                    _exprContent += _input.LT(-1).getText();
            }
	| TEXT {
                    if(isNumber(_exprID)){
                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` expectating a 'number' type, NOT a 'text' type");
                    }
                    _exprContent += _input.LT(-1).getText();
            }
	| AP { _exprContent += _input.LT(-1).getText(); } expr FP { _exprContent += _input.LT(-1).getText(); 
		};

boolExpr: { _exprDecision = "";} boolExprChild;

boolExprChild:
	boolExprChildChild
	| (
		(
			boolExprChildChild ('&&' | '||') { _exprDecision += _input.LT(-1).getText();}
		)? NOT? { _exprDecision += _input.LT(-1).getText();} AP { _exprDecision += _input.LT(-1).getText();
			} boolExprChild FP { _exprDecision += _input.LT(-1).getText();} (
			('&&' | '||') { _exprDecision += _input.LT(-1).getText();} boolExprChild
		)*
	)*;

boolExprChildChild:
	boolTermo { _exprDecision += _input.LT(-1).getText(); } OPREL { _exprDecision += _input.LT(-1).getText(); 
		} boolTermo { _exprDecision += _input.LT(-1).getText(); } (
		('&&' | '||') { _exprDecision += _input.LT(-1).getText(); } boolTermo { _exprDecision += _input.LT(-1).getText(); 
			} OPREL { _exprDecision += _input.LT(-1).getText(); } boolTermo { _exprDecision += _input.LT(-1).getText(); 
			}
	)*;

boolTermo: (
		ID {
                if(!symbolTable.exists(_input.LT(-1).getText())){
                    throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _input.LT(-1).getText()  + "` NOT declared");
                }
                if(!verificaInicializacao(_input.LT(-1).getText())){
                    throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _input.LT(-1).getText()  + "` NOT initialized");
                }
                if(!isNumber(_input.LT(-1).getText())){
                    throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Comparsion operations are expectating a 'numero' type, NOT a 'texto' type");
                }
            }
		| NUMBER
	);

NOT: '!';

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

NUMBER: [0-9]+ ('.' [0-9]+)?;

TEXT: ASP .*? ASP;

BOOL: 'verdadeiro' | 'falso';

VAR: NUMBER | TEXT | BOOL;

ASP: '"';

WP: (' ' | '\t' | '\n' | '\r') -> skip;
