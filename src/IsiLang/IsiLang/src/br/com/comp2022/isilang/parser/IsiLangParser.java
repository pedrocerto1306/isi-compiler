// Generated from IsiLang.g4 by ANTLR 4.10.1
package br.com.comp2022.isilang.parser;

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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, NOT=19, DP=20, AP=21, FP=22, ATTR=23, PT=24, OP=25, ACH=26, 
		FCH=27, VIR=28, OPREL=29, ID=30, NUMBER=31, TEXT=32, INTEGER=33, VAR=34, 
		ASP=35, WP=36;
	public static final int
		RULE_prog = 0, RULE_bloco = 1, RULE_cmd = 2, RULE_cmddeclara = 3, RULE_tipo = 4, 
		RULE_cmdescrita = 5, RULE_cmdleitura = 6, RULE_cmdattrib = 7, RULE_cmdcondicao = 8, 
		RULE_cmdrepeticao = 9, RULE_cmdoperacao = 10, RULE_termo = 11, RULE_expr = 12, 
		RULE_exprTermo = 13, RULE_boolExpr = 14, RULE_boolExprChild = 15, RULE_boolExprChildChild = 16, 
		RULE_boolTermo = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "bloco", "cmd", "cmddeclara", "tipo", "cmdescrita", "cmdleitura", 
			"cmdattrib", "cmdcondicao", "cmdrepeticao", "cmdoperacao", "termo", "expr", 
			"exprTermo", "boolExpr", "boolExprChild", "boolExprChildChild", "boolTermo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog.'", "'declare'", "'real'", "'text'", "'int'", 
			"'escreva'", "'leia'", "'se'", "'entao'", "'senao'", "'escolha'", "'caso'", 
			"'quebra.'", "'enquanto'", "'fa\\u00E7a'", "'&&'", "'||'", "'!'", "':'", 
			"'('", "')'", "':='", "'.'", null, "'{'", "'}'", "','", null, null, null, 
			null, null, null, "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "NOT", "DP", "AP", "FP", "ATTR", 
			"PT", "OP", "ACH", "FCH", "VIR", "OPREL", "ID", "NUMBER", "TEXT", "INTEGER", 
			"VAR", "ASP", "WP"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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


	public IsiLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(T__0);
			setState(37);
			bloco();
			setState(38);
			match(T__1);

			            program.setVarTable(symbolTable);
			            program.setComandos(stack.pop());
			            program.varreVarTable(symbolTable);
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			        curThread = new ArrayList<AbstractCommand>();
			        stack.push(curThread);
			    
			setState(43); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(42);
				cmd();
				}
				}
				setState(45); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__14) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdContext extends ParserRuleContext {
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdattribContext cmdattrib() {
			return getRuleContext(CmdattribContext.class,0);
		}
		public CmddeclaraContext cmddeclara() {
			return getRuleContext(CmddeclaraContext.class,0);
		}
		public CmdcondicaoContext cmdcondicao() {
			return getRuleContext(CmdcondicaoContext.class,0);
		}
		public CmdrepeticaoContext cmdrepeticao() {
			return getRuleContext(CmdrepeticaoContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_cmd);
		try {
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				cmdescrita();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				cmdleitura();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(49);
				cmdattrib();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 4);
				{
				setState(50);
				cmddeclara();
				}
				break;
			case T__8:
			case T__11:
				enterOuterAlt(_localctx, 5);
				{
				setState(51);
				cmdcondicao();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 6);
				{
				setState(52);
				cmdrepeticao();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmddeclaraContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode PT() { return getToken(IsiLangParser.PT, 0); }
		public List<TerminalNode> VIR() { return getTokens(IsiLangParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(IsiLangParser.VIR, i);
		}
		public CmddeclaraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmddeclara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmddeclara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmddeclara(this);
		}
	}

	public final CmddeclaraContext cmddeclara() throws RecognitionException {
		CmddeclaraContext _localctx = new CmddeclaraContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cmddeclara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__2);
			setState(56);
			tipo();
			setState(57);
			match(ID);

			            _varName = _input.LT(-1).getText();
			            _varValue = null;
			            variable = new IsiVariable(_varName, _tipo, _varValue);
			            if(!symbolTable.exists(_varName)){
			                symbolTable.add(variable);
			            }else{
			                throw new IsiSemanticException("Symbol already declared: "+_varName);
			            }
			            
			        
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(59);
				match(VIR);
				setState(60);
				match(ID);

				            _varName = _input.LT(-1).getText();
				            _varValue = null;
				            variable = new IsiVariable(_varName, _tipo, _varValue);
				            if(!symbolTable.exists(_varName)){
				                symbolTable.add(variable);
				            }else{
				                throw new IsiSemanticException("Symbol already declared: "+_varName);
				            }
				        
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
			match(PT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tipo);
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				match(T__3);
				_tipo = IsiVariable.NUMBER;
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				match(T__4);
				_tipo = IsiVariable.TEXT;
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				match(T__5);
				_tipo = IsiVariable.INTEGER;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdescritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode PT() { return getToken(IsiLangParser.PT, 0); }
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdescrita(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__6);
			setState(78);
			match(AP);
			setState(79);
			match(ID);
			 
			                        _writeID = _input.LT(-1).getText();
			                        verificaTabelaDeSimbolos(_input.LT(-1).getText());
			                        verificaInicializacao(_input.LT(-1).getText());
			                    
			setState(81);
			match(FP);
			setState(82);
			match(PT);

			                        IsiVariable var = symbolTable.getVar(_writeID);
			                        ComandoEscrita cmd = new ComandoEscrita(var);
			                        stack.peek().add(cmd);   
			                    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode PT() { return getToken(IsiLangParser.PT, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdleitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdleitura(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__7);
			setState(86);
			match(AP);
			setState(87);
			match(ID);
			  _readID = _input.LT(-1).getText();
			                    verificaTabelaDeSimbolos(_readID); 
			                
			setState(89);
			match(FP);
			setState(90);
			match(PT);

			                    initializeVar(_readID);
			                    IsiVariable var = symbolTable.getVar(_readID);
			                    ComandoLeitura cmd = new ComandoLeitura(_readID, var);
			                    stack.peek().add(cmd);
			                
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdattribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(IsiLangParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PT() { return getToken(IsiLangParser.PT, 0); }
		public CmdattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdattrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdattrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdattrib(this);
		}
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(ID);
			 
			            _exprID = _input.LT(-1).getText();
			            verificaTabelaDeSimbolos(_exprID); 
			        
			setState(95);
			match(ATTR);
			 _exprContent = ""; 
			setState(97);
			expr();
			setState(98);
			match(PT);

			            initializeVar(_exprID);
			            //verifyType(_exprID, _exprContent); //Comparar o tipo da variavel com o tipo da expressão
			            IsiVariable var = symbolTable.getVar(_exprID);
			            ComandoAtribuicao cmd = new ComandoAtribuicao(var, _exprContent);
			            stack.peek().add(cmd);
					
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdcondicaoContext extends ParserRuleContext {
		public List<TerminalNode> AP() { return getTokens(IsiLangParser.AP); }
		public TerminalNode AP(int i) {
			return getToken(IsiLangParser.AP, i);
		}
		public BoolExprContext boolExpr() {
			return getRuleContext(BoolExprContext.class,0);
		}
		public List<TerminalNode> FP() { return getTokens(IsiLangParser.FP); }
		public TerminalNode FP(int i) {
			return getToken(IsiLangParser.FP, i);
		}
		public List<TerminalNode> ACH() { return getTokens(IsiLangParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(IsiLangParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(IsiLangParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(IsiLangParser.FCH, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public List<TerminalNode> DP() { return getTokens(IsiLangParser.DP); }
		public TerminalNode DP(int i) {
			return getToken(IsiLangParser.DP, i);
		}
		public List<TerminalNode> VAR() { return getTokens(IsiLangParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(IsiLangParser.VAR, i);
		}
		public CmdcondicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdcondicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdcondicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdcondicao(this);
		}
	}

	public final CmdcondicaoContext cmdcondicao() throws RecognitionException {
		CmdcondicaoContext _localctx = new CmdcondicaoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdcondicao);
		int _la;
		try {
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				match(T__8);
				setState(102);
				match(AP);

				                ArrayList<AbstractCommand> trueThread = new ArrayList<AbstractCommand>();
				                ArrayList<AbstractCommand> falseThread = new ArrayList<AbstractCommand>();
				                ArrayList<AbstractCommand> listTrue = new ArrayList<AbstractCommand>();
				                ArrayList<AbstractCommand> listFalse = new ArrayList<AbstractCommand>();
				            
				setState(104);
				boolExpr();
				setState(105);
				match(FP);
				 ComandoSe cmd = new ComandoSe(_exprDecision, listTrue, listFalse);  
				setState(107);
				match(T__9);
				setState(108);
				match(ACH);
				 
				                    trueThread = new ArrayList<AbstractCommand>();
				                    stack.push(trueThread);
				                
				setState(111); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(110);
					cmd();
					}
					}
					setState(113); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__14) | (1L << ID))) != 0) );
				setState(115);
				match(FCH);

				                    listTrue = stack.pop();
				                
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(117);
					match(T__10);
					setState(118);
					match(ACH);

					                        curThread = new ArrayList<AbstractCommand>();
					                        stack.push(curThread);
					                    
					{
					setState(121); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(120);
						cmd();
						}
						}
						setState(123); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__14) | (1L << ID))) != 0) );
					}
					setState(125);
					match(FCH);

					                        listFalse = stack.pop();
					                    
					}
				}


				        cmd.setListaTrue(listTrue);
				        cmd.setListaFalse(listFalse);
				        stack.peek().add(cmd);
				    
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				match(T__11);
				setState(133);
				match(AP);
				setState(134);
				match(ID);
				setState(135);
				match(FP);
				setState(136);
				match(ACH);
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__12) {
					{
					{
					setState(137);
					match(T__12);
					setState(138);
					match(AP);
					{
					setState(139);
					match(VAR);
					}
					setState(140);
					match(FP);
					setState(141);
					match(DP);
					setState(143); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(142);
						cmd();
						}
						}
						setState(145); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__14) | (1L << ID))) != 0) );
					setState(147);
					match(T__13);
					}
					}
					setState(153);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(154);
				match(FCH);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdrepeticaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public BoolExprContext boolExpr() {
			return getRuleContext(BoolExprContext.class,0);
		}
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdrepeticaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdrepeticao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdrepeticao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdrepeticao(this);
		}
	}

	public final CmdrepeticaoContext cmdrepeticao() throws RecognitionException {
		CmdrepeticaoContext _localctx = new CmdrepeticaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdrepeticao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(T__14);
			setState(158);
			match(AP);

			        ArrayList<AbstractCommand> whileThread = new ArrayList<AbstractCommand>();
			        ArrayList<AbstractCommand> whileList = new ArrayList<AbstractCommand>();
			    
			setState(160);
			boolExpr();
			setState(161);
			match(FP);
			 ComandoRep cmd = new ComandoRep(_exprDecision, whileList); 
			setState(163);
			match(T__15);
			setState(164);
			match(ACH);

			        whileThread = new ArrayList<AbstractCommand>();
			        stack.push(whileThread);
			    
			setState(167); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(166);
				cmd();
				}
				}
				setState(169); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__14) | (1L << ID))) != 0) );
			setState(171);
			match(FCH);
			 
			        whileList = stack.pop();
			        cmd.setComandoRep(whileList);
			        stack.peek().add(cmd);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdoperacaoContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode OP() { return getToken(IsiLangParser.OP, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(IsiLangParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(IsiLangParser.NUMBER, i);
		}
		public CmdoperacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdoperacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdoperacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdoperacao(this);
		}
	}

	public final CmdoperacaoContext cmdoperacao() throws RecognitionException {
		CmdoperacaoContext _localctx = new CmdoperacaoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdoperacao);
		try {
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				match(ID);
				setState(175);
				match(OP);
				setState(176);
				match(ID);
				 
				        verificaTabelaDeSimbolos(_input.LT(-1).getText()); 
				        verificaTabelaDeSimbolos(_input.LT(-3).getText());
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				match(ID);
				setState(179);
				match(OP);
				setState(180);
				match(NUMBER);
				 
				        verificaTabelaDeSimbolos(_input.LT(-3).getText());
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(182);
				match(NUMBER);
				setState(183);
				match(OP);
				setState(184);
				match(NUMBER);
				 
				        String n1 = _input.LT(-3).getText();
				        String op = _input.LT(-2).getText();
				        String n2 = _input.LT(-1).getText();
				        ComandoOperacao cmd = new ComandoOperacao(n1, op, n2);
				        stack.peek().add(cmd);
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public TerminalNode TEXT() { return getToken(IsiLangParser.TEXT, 0); }
		public TerminalNode INTEGER() { return getToken(IsiLangParser.INTEGER, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_termo);
		try {
			setState(193);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				match(ID);
				 verificaTabelaDeSimbolos(_input.LT(-1).getText()); 
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				match(NUMBER);
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 3);
				{
				setState(191);
				match(TEXT);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 4);
				{
				setState(192);
				match(INTEGER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<ExprTermoContext> exprTermo() {
			return getRuleContexts(ExprTermoContext.class);
		}
		public ExprTermoContext exprTermo(int i) {
			return getRuleContext(ExprTermoContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AP) | (1L << OP) | (1L << ID) | (1L << NUMBER) | (1L << TEXT) | (1L << INTEGER))) != 0)) {
				{
				{
				setState(195);
				exprTermo();
				}
				}
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprTermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public TerminalNode OP() { return getToken(IsiLangParser.OP, 0); }
		public TerminalNode INTEGER() { return getToken(IsiLangParser.INTEGER, 0); }
		public TerminalNode TEXT() { return getToken(IsiLangParser.TEXT, 0); }
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public ExprTermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprTermo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterExprTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitExprTermo(this);
		}
	}

	public final ExprTermoContext exprTermo() throws RecognitionException {
		ExprTermoContext _localctx = new ExprTermoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_exprTermo);
		try {
			setState(217);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				match(ID);

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
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				match(NUMBER);

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
				break;
			case OP:
				enterOuterAlt(_localctx, 3);
				{
				setState(205);
				match(OP);

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
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 4);
				{
				setState(207);
				match(INTEGER);

				                    if(!isInt(_exprID)){
				                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` expectating a 'number' type, NOT a 'int' type");
				                    }
				                    _exprContent += _input.LT(-1).getText();
				            
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 5);
				{
				setState(209);
				match(TEXT);

				                    if(isNumber(_exprID)){
				                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` expectating a 'number' type, NOT a 'text' type");
				                    }
				                    _exprContent += _input.LT(-1).getText();
				            
				}
				break;
			case AP:
				enterOuterAlt(_localctx, 6);
				{
				setState(211);
				match(AP);
				 _exprContent += _input.LT(-1).getText(); 
				setState(213);
				expr();
				setState(214);
				match(FP);
				 _exprContent += _input.LT(-1).getText(); 
						
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolExprContext extends ParserRuleContext {
		public BoolExprChildContext boolExprChild() {
			return getRuleContext(BoolExprChildContext.class,0);
		}
		public BoolExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBoolExpr(this);
		}
	}

	public final BoolExprContext boolExpr() throws RecognitionException {
		BoolExprContext _localctx = new BoolExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_boolExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 _exprDecision = "";
			setState(220);
			boolExprChild();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolExprChildContext extends ParserRuleContext {
		public List<BoolExprChildChildContext> boolExprChildChild() {
			return getRuleContexts(BoolExprChildChildContext.class);
		}
		public BoolExprChildChildContext boolExprChildChild(int i) {
			return getRuleContext(BoolExprChildChildContext.class,i);
		}
		public List<TerminalNode> AP() { return getTokens(IsiLangParser.AP); }
		public TerminalNode AP(int i) {
			return getToken(IsiLangParser.AP, i);
		}
		public List<BoolExprChildContext> boolExprChild() {
			return getRuleContexts(BoolExprChildContext.class);
		}
		public BoolExprChildContext boolExprChild(int i) {
			return getRuleContext(BoolExprChildContext.class,i);
		}
		public List<TerminalNode> FP() { return getTokens(IsiLangParser.FP); }
		public TerminalNode FP(int i) {
			return getToken(IsiLangParser.FP, i);
		}
		public List<TerminalNode> NOT() { return getTokens(IsiLangParser.NOT); }
		public TerminalNode NOT(int i) {
			return getToken(IsiLangParser.NOT, i);
		}
		public BoolExprChildContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolExprChild; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBoolExprChild(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBoolExprChild(this);
		}
	}

	public final BoolExprChildContext boolExprChild() throws RecognitionException {
		BoolExprChildContext _localctx = new BoolExprChildContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_boolExprChild);
		int _la;
		try {
			int _alt;
			setState(251);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				boolExprChildChild();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(248);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(227);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==ID || _la==NUMBER) {
							{
							setState(223);
							boolExprChildChild();
							setState(224);
							_la = _input.LA(1);
							if ( !(_la==T__16 || _la==T__17) ) {
							_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							 _exprDecision += _input.LT(-1).getText();
							}
						}

						setState(230);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(229);
							match(NOT);
							}
						}

						 _exprDecision += _input.LT(-1).getText();
						setState(233);
						match(AP);
						 _exprDecision += _input.LT(-1).getText();
									
						setState(235);
						boolExprChild();
						setState(236);
						match(FP);
						 _exprDecision += _input.LT(-1).getText();
						setState(243);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(238);
								_la = _input.LA(1);
								if ( !(_la==T__16 || _la==T__17) ) {
								_errHandler.recoverInline(this);
								}
								else {
									if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
									_errHandler.reportMatch(this);
									consume();
								}
								 _exprDecision += _input.LT(-1).getText();
								setState(240);
								boolExprChild();
								}
								} 
							}
							setState(245);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
						}
						}
						} 
					}
					setState(250);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolExprChildChildContext extends ParserRuleContext {
		public List<BoolTermoContext> boolTermo() {
			return getRuleContexts(BoolTermoContext.class);
		}
		public BoolTermoContext boolTermo(int i) {
			return getRuleContext(BoolTermoContext.class,i);
		}
		public List<TerminalNode> OPREL() { return getTokens(IsiLangParser.OPREL); }
		public TerminalNode OPREL(int i) {
			return getToken(IsiLangParser.OPREL, i);
		}
		public BoolExprChildChildContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolExprChildChild; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBoolExprChildChild(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBoolExprChildChild(this);
		}
	}

	public final BoolExprChildChildContext boolExprChildChild() throws RecognitionException {
		BoolExprChildChildContext _localctx = new BoolExprChildChildContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_boolExprChildChild);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			boolTermo();
			 _exprDecision += _input.LT(-1).getText(); 
			setState(255);
			match(OPREL);
			 _exprDecision += _input.LT(-1).getText(); 
					
			setState(257);
			boolTermo();
			 _exprDecision += _input.LT(-1).getText(); 
			setState(270);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(259);
					_la = _input.LA(1);
					if ( !(_la==T__16 || _la==T__17) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					 _exprDecision += _input.LT(-1).getText(); 
					setState(261);
					boolTermo();
					 _exprDecision += _input.LT(-1).getText(); 
								
					setState(263);
					match(OPREL);
					 _exprDecision += _input.LT(-1).getText(); 
					setState(265);
					boolTermo();
					 _exprDecision += _input.LT(-1).getText(); 
								
					}
					} 
				}
				setState(272);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolTermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public BoolTermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolTermo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBoolTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBoolTermo(this);
		}
	}

	public final BoolTermoContext boolTermo() throws RecognitionException {
		BoolTermoContext _localctx = new BoolTermoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_boolTermo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(273);
				match(ID);

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
				break;
			case NUMBER:
				{
				setState(275);
				match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001$\u0117\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0004\u0001"+
		",\b\u0001\u000b\u0001\f\u0001-\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u00026\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005"+
		"\u0003?\b\u0003\n\u0003\f\u0003B\t\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004L\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0004\bp\b\b\u000b\b\f\bq\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0004\bz\b\b\u000b\b\f\b{\u0001\b\u0001\b\u0001"+
		"\b\u0003\b\u0081\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0004\b\u0090\b\b\u000b"+
		"\b\f\b\u0091\u0001\b\u0001\b\u0005\b\u0096\b\b\n\b\f\b\u0099\t\b\u0001"+
		"\b\u0003\b\u009c\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0004\t\u00a8\b\t\u000b\t\f\t\u00a9\u0001\t"+
		"\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00bb\b\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00c2\b\u000b"+
		"\u0001\f\u0005\f\u00c5\b\f\n\f\f\f\u00c8\t\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0003\r\u00da\b\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u00e4\b\u000f\u0001\u000f\u0003\u000f\u00e7\b\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0005\u000f\u00f2\b\u000f\n\u000f\f\u000f\u00f5"+
		"\t\u000f\u0005\u000f\u00f7\b\u000f\n\u000f\f\u000f\u00fa\t\u000f\u0003"+
		"\u000f\u00fc\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u010d"+
		"\b\u0010\n\u0010\f\u0010\u0110\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u0115\b\u0011\u0001\u0011\u0000\u0000\u0012\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"\u0000\u0001\u0001\u0000\u0011\u0012\u0126\u0000$\u0001\u0000\u0000\u0000"+
		"\u0002)\u0001\u0000\u0000\u0000\u00045\u0001\u0000\u0000\u0000\u00067"+
		"\u0001\u0000\u0000\u0000\bK\u0001\u0000\u0000\u0000\nM\u0001\u0000\u0000"+
		"\u0000\fU\u0001\u0000\u0000\u0000\u000e]\u0001\u0000\u0000\u0000\u0010"+
		"\u009b\u0001\u0000\u0000\u0000\u0012\u009d\u0001\u0000\u0000\u0000\u0014"+
		"\u00ba\u0001\u0000\u0000\u0000\u0016\u00c1\u0001\u0000\u0000\u0000\u0018"+
		"\u00c6\u0001\u0000\u0000\u0000\u001a\u00d9\u0001\u0000\u0000\u0000\u001c"+
		"\u00db\u0001\u0000\u0000\u0000\u001e\u00fb\u0001\u0000\u0000\u0000 \u00fd"+
		"\u0001\u0000\u0000\u0000\"\u0114\u0001\u0000\u0000\u0000$%\u0005\u0001"+
		"\u0000\u0000%&\u0003\u0002\u0001\u0000&\'\u0005\u0002\u0000\u0000\'(\u0006"+
		"\u0000\uffff\uffff\u0000(\u0001\u0001\u0000\u0000\u0000)+\u0006\u0001"+
		"\uffff\uffff\u0000*,\u0003\u0004\u0002\u0000+*\u0001\u0000\u0000\u0000"+
		",-\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000"+
		"\u0000.\u0003\u0001\u0000\u0000\u0000/6\u0003\n\u0005\u000006\u0003\f"+
		"\u0006\u000016\u0003\u000e\u0007\u000026\u0003\u0006\u0003\u000036\u0003"+
		"\u0010\b\u000046\u0003\u0012\t\u00005/\u0001\u0000\u0000\u000050\u0001"+
		"\u0000\u0000\u000051\u0001\u0000\u0000\u000052\u0001\u0000\u0000\u0000"+
		"53\u0001\u0000\u0000\u000054\u0001\u0000\u0000\u00006\u0005\u0001\u0000"+
		"\u0000\u000078\u0005\u0003\u0000\u000089\u0003\b\u0004\u00009:\u0005\u001e"+
		"\u0000\u0000:@\u0006\u0003\uffff\uffff\u0000;<\u0005\u001c\u0000\u0000"+
		"<=\u0005\u001e\u0000\u0000=?\u0006\u0003\uffff\uffff\u0000>;\u0001\u0000"+
		"\u0000\u0000?B\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000@A\u0001"+
		"\u0000\u0000\u0000AC\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000"+
		"CD\u0005\u0018\u0000\u0000D\u0007\u0001\u0000\u0000\u0000EF\u0005\u0004"+
		"\u0000\u0000FL\u0006\u0004\uffff\uffff\u0000GH\u0005\u0005\u0000\u0000"+
		"HL\u0006\u0004\uffff\uffff\u0000IJ\u0005\u0006\u0000\u0000JL\u0006\u0004"+
		"\uffff\uffff\u0000KE\u0001\u0000\u0000\u0000KG\u0001\u0000\u0000\u0000"+
		"KI\u0001\u0000\u0000\u0000L\t\u0001\u0000\u0000\u0000MN\u0005\u0007\u0000"+
		"\u0000NO\u0005\u0015\u0000\u0000OP\u0005\u001e\u0000\u0000PQ\u0006\u0005"+
		"\uffff\uffff\u0000QR\u0005\u0016\u0000\u0000RS\u0005\u0018\u0000\u0000"+
		"ST\u0006\u0005\uffff\uffff\u0000T\u000b\u0001\u0000\u0000\u0000UV\u0005"+
		"\b\u0000\u0000VW\u0005\u0015\u0000\u0000WX\u0005\u001e\u0000\u0000XY\u0006"+
		"\u0006\uffff\uffff\u0000YZ\u0005\u0016\u0000\u0000Z[\u0005\u0018\u0000"+
		"\u0000[\\\u0006\u0006\uffff\uffff\u0000\\\r\u0001\u0000\u0000\u0000]^"+
		"\u0005\u001e\u0000\u0000^_\u0006\u0007\uffff\uffff\u0000_`\u0005\u0017"+
		"\u0000\u0000`a\u0006\u0007\uffff\uffff\u0000ab\u0003\u0018\f\u0000bc\u0005"+
		"\u0018\u0000\u0000cd\u0006\u0007\uffff\uffff\u0000d\u000f\u0001\u0000"+
		"\u0000\u0000ef\u0005\t\u0000\u0000fg\u0005\u0015\u0000\u0000gh\u0006\b"+
		"\uffff\uffff\u0000hi\u0003\u001c\u000e\u0000ij\u0005\u0016\u0000\u0000"+
		"jk\u0006\b\uffff\uffff\u0000kl\u0005\n\u0000\u0000lm\u0005\u001a\u0000"+
		"\u0000mo\u0006\b\uffff\uffff\u0000np\u0003\u0004\u0002\u0000on\u0001\u0000"+
		"\u0000\u0000pq\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000qr\u0001"+
		"\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0005\u001b\u0000\u0000"+
		"t\u0080\u0006\b\uffff\uffff\u0000uv\u0005\u000b\u0000\u0000vw\u0005\u001a"+
		"\u0000\u0000wy\u0006\b\uffff\uffff\u0000xz\u0003\u0004\u0002\u0000yx\u0001"+
		"\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000"+
		"{|\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0005\u001b\u0000"+
		"\u0000~\u007f\u0006\b\uffff\uffff\u0000\u007f\u0081\u0001\u0000\u0000"+
		"\u0000\u0080u\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000"+
		"\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0083\u0006\b\uffff\uffff\u0000"+
		"\u0083\u009c\u0001\u0000\u0000\u0000\u0084\u0085\u0005\f\u0000\u0000\u0085"+
		"\u0086\u0005\u0015\u0000\u0000\u0086\u0087\u0005\u001e\u0000\u0000\u0087"+
		"\u0088\u0005\u0016\u0000\u0000\u0088\u0097\u0005\u001a\u0000\u0000\u0089"+
		"\u008a\u0005\r\u0000\u0000\u008a\u008b\u0005\u0015\u0000\u0000\u008b\u008c"+
		"\u0005\"\u0000\u0000\u008c\u008d\u0005\u0016\u0000\u0000\u008d\u008f\u0005"+
		"\u0014\u0000\u0000\u008e\u0090\u0003\u0004\u0002\u0000\u008f\u008e\u0001"+
		"\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u008f\u0001"+
		"\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0093\u0001"+
		"\u0000\u0000\u0000\u0093\u0094\u0005\u000e\u0000\u0000\u0094\u0096\u0001"+
		"\u0000\u0000\u0000\u0095\u0089\u0001\u0000\u0000\u0000\u0096\u0099\u0001"+
		"\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0097\u0098\u0001"+
		"\u0000\u0000\u0000\u0098\u009a\u0001\u0000\u0000\u0000\u0099\u0097\u0001"+
		"\u0000\u0000\u0000\u009a\u009c\u0005\u001b\u0000\u0000\u009be\u0001\u0000"+
		"\u0000\u0000\u009b\u0084\u0001\u0000\u0000\u0000\u009c\u0011\u0001\u0000"+
		"\u0000\u0000\u009d\u009e\u0005\u000f\u0000\u0000\u009e\u009f\u0005\u0015"+
		"\u0000\u0000\u009f\u00a0\u0006\t\uffff\uffff\u0000\u00a0\u00a1\u0003\u001c"+
		"\u000e\u0000\u00a1\u00a2\u0005\u0016\u0000\u0000\u00a2\u00a3\u0006\t\uffff"+
		"\uffff\u0000\u00a3\u00a4\u0005\u0010\u0000\u0000\u00a4\u00a5\u0005\u001a"+
		"\u0000\u0000\u00a5\u00a7\u0006\t\uffff\uffff\u0000\u00a6\u00a8\u0003\u0004"+
		"\u0002\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000"+
		"\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005\u001b"+
		"\u0000\u0000\u00ac\u00ad\u0006\t\uffff\uffff\u0000\u00ad\u0013\u0001\u0000"+
		"\u0000\u0000\u00ae\u00af\u0005\u001e\u0000\u0000\u00af\u00b0\u0005\u0019"+
		"\u0000\u0000\u00b0\u00b1\u0005\u001e\u0000\u0000\u00b1\u00bb\u0006\n\uffff"+
		"\uffff\u0000\u00b2\u00b3\u0005\u001e\u0000\u0000\u00b3\u00b4\u0005\u0019"+
		"\u0000\u0000\u00b4\u00b5\u0005\u001f\u0000\u0000\u00b5\u00bb\u0006\n\uffff"+
		"\uffff\u0000\u00b6\u00b7\u0005\u001f\u0000\u0000\u00b7\u00b8\u0005\u0019"+
		"\u0000\u0000\u00b8\u00b9\u0005\u001f\u0000\u0000\u00b9\u00bb\u0006\n\uffff"+
		"\uffff\u0000\u00ba\u00ae\u0001\u0000\u0000\u0000\u00ba\u00b2\u0001\u0000"+
		"\u0000\u0000\u00ba\u00b6\u0001\u0000\u0000\u0000\u00bb\u0015\u0001\u0000"+
		"\u0000\u0000\u00bc\u00bd\u0005\u001e\u0000\u0000\u00bd\u00c2\u0006\u000b"+
		"\uffff\uffff\u0000\u00be\u00c2\u0005\u001f\u0000\u0000\u00bf\u00c2\u0005"+
		" \u0000\u0000\u00c0\u00c2\u0005!\u0000\u0000\u00c1\u00bc\u0001\u0000\u0000"+
		"\u0000\u00c1\u00be\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000"+
		"\u0000\u00c1\u00c0\u0001\u0000\u0000\u0000\u00c2\u0017\u0001\u0000\u0000"+
		"\u0000\u00c3\u00c5\u0003\u001a\r\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000"+
		"\u00c5\u00c8\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u0019\u0001\u0000\u0000\u0000"+
		"\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005\u001e\u0000\u0000"+
		"\u00ca\u00da\u0006\r\uffff\uffff\u0000\u00cb\u00cc\u0005\u001f\u0000\u0000"+
		"\u00cc\u00da\u0006\r\uffff\uffff\u0000\u00cd\u00ce\u0005\u0019\u0000\u0000"+
		"\u00ce\u00da\u0006\r\uffff\uffff\u0000\u00cf\u00d0\u0005!\u0000\u0000"+
		"\u00d0\u00da\u0006\r\uffff\uffff\u0000\u00d1\u00d2\u0005 \u0000\u0000"+
		"\u00d2\u00da\u0006\r\uffff\uffff\u0000\u00d3\u00d4\u0005\u0015\u0000\u0000"+
		"\u00d4\u00d5\u0006\r\uffff\uffff\u0000\u00d5\u00d6\u0003\u0018\f\u0000"+
		"\u00d6\u00d7\u0005\u0016\u0000\u0000\u00d7\u00d8\u0006\r\uffff\uffff\u0000"+
		"\u00d8\u00da\u0001\u0000\u0000\u0000\u00d9\u00c9\u0001\u0000\u0000\u0000"+
		"\u00d9\u00cb\u0001\u0000\u0000\u0000\u00d9\u00cd\u0001\u0000\u0000\u0000"+
		"\u00d9\u00cf\u0001\u0000\u0000\u0000\u00d9\u00d1\u0001\u0000\u0000\u0000"+
		"\u00d9\u00d3\u0001\u0000\u0000\u0000\u00da\u001b\u0001\u0000\u0000\u0000"+
		"\u00db\u00dc\u0006\u000e\uffff\uffff\u0000\u00dc\u00dd\u0003\u001e\u000f"+
		"\u0000\u00dd\u001d\u0001\u0000\u0000\u0000\u00de\u00fc\u0003 \u0010\u0000"+
		"\u00df\u00e0\u0003 \u0010\u0000\u00e0\u00e1\u0007\u0000\u0000\u0000\u00e1"+
		"\u00e2\u0006\u000f\uffff\uffff\u0000\u00e2\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e3\u00df\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e4\u00e6\u0001\u0000\u0000\u0000\u00e5\u00e7\u0005\u0013\u0000\u0000"+
		"\u00e6\u00e5\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000"+
		"\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8\u00e9\u0006\u000f\uffff\uffff"+
		"\u0000\u00e9\u00ea\u0005\u0015\u0000\u0000\u00ea\u00eb\u0006\u000f\uffff"+
		"\uffff\u0000\u00eb\u00ec\u0003\u001e\u000f\u0000\u00ec\u00ed\u0005\u0016"+
		"\u0000\u0000\u00ed\u00f3\u0006\u000f\uffff\uffff\u0000\u00ee\u00ef\u0007"+
		"\u0000\u0000\u0000\u00ef\u00f0\u0006\u000f\uffff\uffff\u0000\u00f0\u00f2"+
		"\u0003\u001e\u000f\u0000\u00f1\u00ee\u0001\u0000\u0000\u0000\u00f2\u00f5"+
		"\u0001\u0000\u0000\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f4"+
		"\u0001\u0000\u0000\u0000\u00f4\u00f7\u0001\u0000\u0000\u0000\u00f5\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f6\u00e3\u0001\u0000\u0000\u0000\u00f7\u00fa"+
		"\u0001\u0000\u0000\u0000\u00f8\u00f6\u0001\u0000\u0000\u0000\u00f8\u00f9"+
		"\u0001\u0000\u0000\u0000\u00f9\u00fc\u0001\u0000\u0000\u0000\u00fa\u00f8"+
		"\u0001\u0000\u0000\u0000\u00fb\u00de\u0001\u0000\u0000\u0000\u00fb\u00f8"+
		"\u0001\u0000\u0000\u0000\u00fc\u001f\u0001\u0000\u0000\u0000\u00fd\u00fe"+
		"\u0003\"\u0011\u0000\u00fe\u00ff\u0006\u0010\uffff\uffff\u0000\u00ff\u0100"+
		"\u0005\u001d\u0000\u0000\u0100\u0101\u0006\u0010\uffff\uffff\u0000\u0101"+
		"\u0102\u0003\"\u0011\u0000\u0102\u010e\u0006\u0010\uffff\uffff\u0000\u0103"+
		"\u0104\u0007\u0000\u0000\u0000\u0104\u0105\u0006\u0010\uffff\uffff\u0000"+
		"\u0105\u0106\u0003\"\u0011\u0000\u0106\u0107\u0006\u0010\uffff\uffff\u0000"+
		"\u0107\u0108\u0005\u001d\u0000\u0000\u0108\u0109\u0006\u0010\uffff\uffff"+
		"\u0000\u0109\u010a\u0003\"\u0011\u0000\u010a\u010b\u0006\u0010\uffff\uffff"+
		"\u0000\u010b\u010d\u0001\u0000\u0000\u0000\u010c\u0103\u0001\u0000\u0000"+
		"\u0000\u010d\u0110\u0001\u0000\u0000\u0000\u010e\u010c\u0001\u0000\u0000"+
		"\u0000\u010e\u010f\u0001\u0000\u0000\u0000\u010f!\u0001\u0000\u0000\u0000"+
		"\u0110\u010e\u0001\u0000\u0000\u0000\u0111\u0112\u0005\u001e\u0000\u0000"+
		"\u0112\u0115\u0006\u0011\uffff\uffff\u0000\u0113\u0115\u0005\u001f\u0000"+
		"\u0000\u0114\u0111\u0001\u0000\u0000\u0000\u0114\u0113\u0001\u0000\u0000"+
		"\u0000\u0115#\u0001\u0000\u0000\u0000\u0016-5@Kq{\u0080\u0091\u0097\u009b"+
		"\u00a9\u00ba\u00c1\u00c6\u00d9\u00e3\u00e6\u00f3\u00f8\u00fb\u010e\u0114";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}