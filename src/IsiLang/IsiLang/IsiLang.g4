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
    import br.com.comp2022.isilang.ast.ComandoOperacao;
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
        }else{
            throw new IsiSemanticException("Variable not initialized");
        }
    }

    public boolean isOperator(String id) {
		if ((char) id.charAt(0) == '+' || (char) id.charAt(0) == '-' || (char) id.charAt(0) == '*'
				|| (char) id.charAt(0) == '/' | (char) id.charAt(0) == '^' | (char) id.charAt(0) == '$'
						| (char) id.charAt(0) == '#') {
			return true;
		} else {
			return false;
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

    public boolean isText(String id){
        if(symbolTable.exists(id)){
            IsiVariable var = symbolTable.getVar(id);
            if(var.getType() == IsiVariable.TEXT)
                return true;
            return false;
        }
        return false;
    }

    public boolean isInt(String id){
        if(symbolTable.exists(id)){
            IsiVariable var = symbolTable.getVar(id);
            if(var.getType() == IsiVariable.INTEGER)
                return true;
            return false;
        }
        return false;
    }

    public void generateJavaCode(){
        program.generateJava();
    }

    public void generateClangCode(){
        program.generateClang();
    }

}

prog:
	'programa' bloco 'fimprog.' {
            program.setVarTable(symbolTable);
            program.setComandos(stack.pop());
            program.varreVarTable(symbolTable);
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
	'real' {_tipo = IsiVariable.NUMBER;}
	| 'text' {_tipo = IsiVariable.TEXT;}
	| 'int' {_tipo = IsiVariable.INTEGER;};

cmdescrita:
	'escreva' AP ID { 
                        _writeID = _input.LT(-1).getText();
                        verificaTabelaDeSimbolos(_input.LT(-1).getText());
                        verificaInicializacao(_input.LT(-1).getText());
                    } FP PT {
                        IsiVariable var = symbolTable.getVar(_writeID);
                        ComandoEscrita cmd = new ComandoEscrita(var);
                        stack.peek().add(cmd);   
                    };

cmdleitura:
	'leia' AP ID {  _readID = _input.LT(-1).getText();
                    verificaTabelaDeSimbolos(_readID); 
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
                        curThread = new ArrayList<AbstractCommand>();
                        stack.push(curThread);
                    } (cmd+) FCH {
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

cmdoperacao:
	ID OP ID { 
        verificaTabelaDeSimbolos(_input.LT(-1).getText()); 
        verificaTabelaDeSimbolos(_input.LT(-3).getText());
    }
	| ID OP NUMBER { 
        verificaTabelaDeSimbolos(_input.LT(-3).getText());
    }
	| NUMBER OP NUMBER { 
        String n1 = _input.LT(-3).getText();
        String op = _input.LT(-2).getText();
        String n2 = _input.LT(-1).getText();
        ComandoOperacao cmd = new ComandoOperacao(n1, op, n2);
        stack.peek().add(cmd);
    };

termo:
	ID { verificaTabelaDeSimbolos(_input.LT(-1).getText()); }
	| NUMBER
	| TEXT
	| INTEGER;

expr: (exprTermo)*;
// ( exprTermo {

// } // { // String op = _input.LT(-2).getText(); // if (op == "POT") { // //
// System.out.println(_input.LT(-2).getText()); // _exprContent = "Math.pow(" + //
// _input.LT(-3).getText() + "," + _input.LT(-1).getText() // + ")"; // } else { // // _exprContent
// += _input.LT(-1).getText(); // } // // System.out.println(_input.LT(-3).getText() +
// _input.LT(-2).getText() + // _input.LT(-1).getText()); } )*;

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
                    if(isText(_exprID) && !isText(id)){
                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` expectating a 'texto' type, NOT a 'numero' type");
                    }
                    if(isInt(_exprID) && !isInt(id)){
                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` expectating a 'inteiro' type");
                    }
                    _exprContent += _input.LT(-1).getText();

              }
	| NUMBER {
            //id := num ^ num
            //id := num
            String op = _input.LT(-2).getText(); 
            String n2 = _input.LT(-1).getText(); 
            if(isOperator(op)){
                String n1 = _input.LT(-3).getText(); 
                ComandoOperacao cmd = new ComandoOperacao(n1, op, n2); 
                _exprContent += cmd.getExpression();
                // _exprContent = "";
                // stack.push(cmd);
            } else { 
                if((char)op.charAt(0) != ':' && (char)op.charAt(1) != '='){ 
                    _exprContent = op + n2; 
                }else{ 
                    if(!isNumber(_exprID)){
                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` expectating a 'text' type, NOT a 'number' type");
                    }
                    _exprContent += _input.LT(-1).getText();
                } //throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(),"Number expected to make an operation!")
            }
        }
	| OP {
            //id := num $
            String number = _input.LT(-2).getText();
            if(isOperator(_input.LT(-1).getText())){
                String op = _input.LT(-1).getText();
                if((char)_input.LT(-1).getText().charAt(0) == '$' || (char)_input.LT(-1).getText().charAt(0) == '#'){
                    ComandoOperacao cmd = new ComandoOperacao(number, op);
                    _exprContent = cmd.getExpression();
                    // _exprContent = "";
                    // stack.push(cmd);
                }else if((char) _input.LT(-1).getText().charAt(0) == '^'){
                    _exprContent = "";
                }else{
                    _exprContent = number + op;
                }
            }else{
                if(!isNumber(_exprID)){
                    throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` expectating a 'text' type, NOT a 'number' type");
                }
                _exprContent += _input.LT(-1).getText();
            }
        }
	// | OP NUMBER{ //id := num $ String number = _input.LT(-2).getText();
	// if(isOperator(_input.LT(-1).getText())){ String op = _input.LT(-1).getText();
	// if((char)_input.LT(-1).getText().charAt(0) == '$' || (char)_input.LT(-1).getText().charAt(0)
	// == '#'){ ComandoOperacao cmd = new ComandoOperacao(number, op); _exprContent +=
	// cmd.getExpression(); }else if((char) _input.LT(-1).getText().charAt(0) == '^'){
	// System.out.println("Problema"); } }else{ if(!isNumber(_exprID)){ throw new
	// IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(),
	// "Symbol `" + _exprID + "` expectating a 'text' type, NOT a 'number' type"); } _exprContent +=
	// _input.LT(-1).getText(); } }
	| INTEGER {
                    if(!isInt(_exprID)){
                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` expectating a 'number' type, NOT a 'int' type");
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

OP: '+' | '-' | '*' | '/' | '^' | '$' | '#';

ACH: '{';

FCH: '}';

VIR: ',';

OPREL: '>' | '<' | '>=' | '<=' | '==' | '!=';

ID: [a-z] ([a-z] | [A-Z] | [0-9])*;

NUMBER: [0-9]+ ('.' [0-9]+)?;

TEXT: ASP .*? ASP;

INTEGER: [0-9]+ ([0-9]+)?;

VAR: NUMBER | TEXT | INTEGER;

ASP: '"';

WP: (' ' | '\t' | '\n' | '\r') -> skip;