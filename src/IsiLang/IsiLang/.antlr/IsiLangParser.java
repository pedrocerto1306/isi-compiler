// Generated from c:\Users\Pedro Certo\Documents\UFABC\Compiladores\isi-compiler\src\IsiLang\IsiLang\IsiLang.g4 by ANTLR 4.9.2

    import br.com.comp2022.isilang.datastructures.IsiSymbol;
    import br.com.comp2022.isilang.datastructures.IsiVariable;
    import br.com.comp2022.isilang.datastructures.IsiSymbolTable;
    import br.com.comp2022.isilang.exceptions.IsiSemanticException;
    import java.util.ArrayList;

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
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, DP=17, 
		AP=18, FP=19, ATTR=20, PT=21, OP=22, ACH=23, FCH=24, VIR=25, OPREL=26, 
		ID=27, NUMBER=28, TEXT=29, BOOL=30, ASP=31, WP=32;
	public static final int
		RULE_prog = 0, RULE_bloco = 1, RULE_cmd = 2, RULE_cmddeclara = 3, RULE_tipo = 4, 
		RULE_cmdescrita = 5, RULE_cmdleitura = 6, RULE_cmdattrib = 7, RULE_cmdcondicao = 8, 
		RULE_cmdrepeticao = 9, RULE_expr = 10, RULE_termo = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "bloco", "cmd", "cmddeclara", "tipo", "cmdescrita", "cmdleitura", 
			"cmdattrib", "cmdcondicao", "cmdrepeticao", "expr", "termo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog.'", "'declare'", "'number'", "'text'", 
			"'bool'", "'escreva'", "'leia'", "'se'", "'entao'", "'senao'", "'escolha'", 
			"'caso'", "'quebra.'", "'enquanto'", "'fa\u00E7a'", "':'", "'('", "')'", 
			"':='", "'.'", null, "'{'", "'}'", "','", null, null, null, null, null, 
			"'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "DP", "AP", "FP", "ATTR", "PT", "OP", "ACH", 
			"FCH", "VIR", "OPREL", "ID", "NUMBER", "TEXT", "BOOL", "ASP", "WP"
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
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(T__0);
			setState(25);
			bloco();
			setState(26);
			match(T__1);
			  
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
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(29);
				cmd();
				}
				}
				setState(32); 
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
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_cmd);
		try {
			setState(40);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				cmdescrita();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				cmdleitura();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(36);
				cmdattrib();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 4);
				{
				setState(37);
				cmddeclara();
				}
				break;
			case T__8:
			case T__11:
				enterOuterAlt(_localctx, 5);
				{
				setState(38);
				cmdcondicao();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 6);
				{
				setState(39);
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
	}

	public final CmddeclaraContext cmddeclara() throws RecognitionException {
		CmddeclaraContext _localctx = new CmddeclaraContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cmddeclara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(T__2);
			setState(43);
			tipo();
			setState(44);
			match(ID);

			            _varName = _input.LT(-1).getText();
			            _varValue = null;
			            symbol = new IsiVariable(_varName, _tipo, _varValue);
			            if(!symbolTable.exists(_varName)){
			                symbolTable.add(symbol);
			            }else{
			                throw new IsiSemanticException("Symbol already declared: "+_varName);
			            }
			            
			        
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(46);
				match(VIR);
				setState(47);
				match(ID);

				            _varName = _input.LT(-1).getText();
				            _varValue = null;
				            symbol = new IsiVariable(_varName, _tipo, _varValue);
				            if(!symbolTable.exists(_varName)){
				                symbolTable.add(symbol);
				            }else{
				                throw new IsiSemanticException("Symbol already declared: "+_varName);
				            }
				        
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
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
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tipo);
		try {
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(T__3);
				_tipo = IsiVariable.NUMBER;
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				match(T__4);
				_tipo = IsiVariable.TEXT;
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(60);
				match(T__5);
				_tipo = IsiVariable.BOOLEAN;
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
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(T__6);
			setState(65);
			match(AP);
			setState(66);
			match(ID);
			 verificaTabelaDeSimbolos(_input.LT(-1).getText()); 
			setState(68);
			match(FP);
			setState(69);
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

	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode PT() { return getToken(IsiLangParser.PT, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__7);
			setState(72);
			match(AP);
			setState(73);
			match(ID);
			 verificaTabelaDeSimbolos(_input.LT(-1).getText()); 
			setState(75);
			match(FP);
			setState(76);
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
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(ID);
			 verificaTabelaDeSimbolos(_input.LT(-1).getText()); 
			setState(80);
			match(ATTR);
			setState(81);
			expr();
			setState(82);
			match(PT);

			        _varName = _input.LT(-4).getText();

			        IsiVariable var1 = symbolTable.getVar(_varName);

			        // verificaCompatibilidade(var1, _input.LT(-2));
					
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
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
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
		public List<TerminalNode> NUMBER() { return getTokens(IsiLangParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(IsiLangParser.NUMBER, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public List<TerminalNode> DP() { return getTokens(IsiLangParser.DP); }
		public TerminalNode DP(int i) {
			return getToken(IsiLangParser.DP, i);
		}
		public CmdcondicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdcondicao; }
	}

	public final CmdcondicaoContext cmdcondicao() throws RecognitionException {
		CmdcondicaoContext _localctx = new CmdcondicaoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdcondicao);
		int _la;
		try {
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				match(T__8);
				setState(86);
				match(AP);
				setState(87);
				match(ID);
				setState(88);
				match(OPREL);
				setState(89);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==NUMBER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(90);
				match(FP);
				setState(91);
				match(T__9);
				setState(92);
				match(ACH);
				setState(94); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(93);
					cmd();
					}
					}
					setState(96); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__14) | (1L << ID))) != 0) );
				setState(98);
				match(FCH);
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(99);
					match(T__10);
					setState(100);
					match(ACH);
					setState(102); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(101);
						cmd();
						}
						}
						setState(104); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__14) | (1L << ID))) != 0) );
					setState(106);
					match(FCH);
					}
				}

				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(T__11);
				setState(111);
				match(AP);
				setState(112);
				match(ID);
				setState(113);
				match(FP);
				setState(114);
				match(ACH);
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__12) {
					{
					{
					setState(115);
					match(T__12);
					setState(116);
					match(AP);
					setState(117);
					_la = _input.LA(1);
					if ( !(_la==ID || _la==NUMBER) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(118);
					match(FP);
					setState(119);
					match(DP);
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
					setState(125);
					match(T__13);
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(132);
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
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
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
	}

	public final CmdrepeticaoContext cmdrepeticao() throws RecognitionException {
		CmdrepeticaoContext _localctx = new CmdrepeticaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdrepeticao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(T__14);
			setState(136);
			match(AP);
			setState(137);
			match(ID);
			setState(138);
			match(OPREL);
			setState(139);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(140);
			match(FP);
			setState(141);
			match(T__15);
			setState(142);
			match(ACH);
			setState(144); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(143);
				cmd();
				}
				}
				setState(146); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__14) | (1L << ID))) != 0) );
			setState(148);
			match(FCH);
			 //System.out.println("Sintaxe do laço funcionando!") ;
					
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
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(IsiLangParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(IsiLangParser.OP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			termo();
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(152);
				match(OP);
				setState(153);
				termo();
				}
				}
				setState(158);
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

	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public TerminalNode TEXT() { return getToken(IsiLangParser.TEXT, 0); }
		public TerminalNode BOOL() { return getToken(IsiLangParser.BOOL, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_termo);
		try {
			setState(164);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				match(ID);
				 verificaTabelaDeSimbolos(_input.LT(-1).getText()); 
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				match(NUMBER);
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 3);
				{
				setState(162);
				match(TEXT);
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(163);
				match(BOOL);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u00a9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\3\6\3!\n\3\r\3\16\3\"\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\5\4+\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\64\n\5\f\5"+
		"\16\5\67\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6A\n\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\6\na\n\n\r\n\16\nb\3\n\3\n\3\n\3\n"+
		"\6\ni\n\n\r\n\16\nj\3\n\3\n\5\no\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\6\n|\n\n\r\n\16\n}\3\n\3\n\7\n\u0082\n\n\f\n\16\n\u0085\13"+
		"\n\3\n\5\n\u0088\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\6\13"+
		"\u0093\n\13\r\13\16\13\u0094\3\13\3\13\3\13\3\f\3\f\3\f\7\f\u009d\n\f"+
		"\f\f\16\f\u00a0\13\f\3\r\3\r\3\r\3\r\3\r\5\r\u00a7\n\r\3\r\2\2\16\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\2\3\3\2\35\36\2\u00b0\2\32\3\2\2\2\4 \3\2\2"+
		"\2\6*\3\2\2\2\b,\3\2\2\2\n@\3\2\2\2\fB\3\2\2\2\16I\3\2\2\2\20P\3\2\2\2"+
		"\22\u0087\3\2\2\2\24\u0089\3\2\2\2\26\u0099\3\2\2\2\30\u00a6\3\2\2\2\32"+
		"\33\7\3\2\2\33\34\5\4\3\2\34\35\7\4\2\2\35\36\b\2\1\2\36\3\3\2\2\2\37"+
		"!\5\6\4\2 \37\3\2\2\2!\"\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#\5\3\2\2\2$+\5"+
		"\f\7\2%+\5\16\b\2&+\5\20\t\2\'+\5\b\5\2(+\5\22\n\2)+\5\24\13\2*$\3\2\2"+
		"\2*%\3\2\2\2*&\3\2\2\2*\'\3\2\2\2*(\3\2\2\2*)\3\2\2\2+\7\3\2\2\2,-\7\5"+
		"\2\2-.\5\n\6\2./\7\35\2\2/\65\b\5\1\2\60\61\7\33\2\2\61\62\7\35\2\2\62"+
		"\64\b\5\1\2\63\60\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66"+
		"8\3\2\2\2\67\65\3\2\2\289\7\27\2\29\t\3\2\2\2:;\7\6\2\2;A\b\6\1\2<=\7"+
		"\7\2\2=A\b\6\1\2>?\7\b\2\2?A\b\6\1\2@:\3\2\2\2@<\3\2\2\2@>\3\2\2\2A\13"+
		"\3\2\2\2BC\7\t\2\2CD\7\24\2\2DE\7\35\2\2EF\b\7\1\2FG\7\25\2\2GH\7\27\2"+
		"\2H\r\3\2\2\2IJ\7\n\2\2JK\7\24\2\2KL\7\35\2\2LM\b\b\1\2MN\7\25\2\2NO\7"+
		"\27\2\2O\17\3\2\2\2PQ\7\35\2\2QR\b\t\1\2RS\7\26\2\2ST\5\26\f\2TU\7\27"+
		"\2\2UV\b\t\1\2V\21\3\2\2\2WX\7\13\2\2XY\7\24\2\2YZ\7\35\2\2Z[\7\34\2\2"+
		"[\\\t\2\2\2\\]\7\25\2\2]^\7\f\2\2^`\7\31\2\2_a\5\6\4\2`_\3\2\2\2ab\3\2"+
		"\2\2b`\3\2\2\2bc\3\2\2\2cd\3\2\2\2dn\7\32\2\2ef\7\r\2\2fh\7\31\2\2gi\5"+
		"\6\4\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2jk\3\2\2\2kl\3\2\2\2lm\7\32\2\2mo"+
		"\3\2\2\2ne\3\2\2\2no\3\2\2\2o\u0088\3\2\2\2pq\7\16\2\2qr\7\24\2\2rs\7"+
		"\35\2\2st\7\25\2\2t\u0083\7\31\2\2uv\7\17\2\2vw\7\24\2\2wx\t\2\2\2xy\7"+
		"\25\2\2y{\7\23\2\2z|\5\6\4\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~"+
		"\177\3\2\2\2\177\u0080\7\20\2\2\u0080\u0082\3\2\2\2\u0081u\3\2\2\2\u0082"+
		"\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086\3\2"+
		"\2\2\u0085\u0083\3\2\2\2\u0086\u0088\7\32\2\2\u0087W\3\2\2\2\u0087p\3"+
		"\2\2\2\u0088\23\3\2\2\2\u0089\u008a\7\21\2\2\u008a\u008b\7\24\2\2\u008b"+
		"\u008c\7\35\2\2\u008c\u008d\7\34\2\2\u008d\u008e\t\2\2\2\u008e\u008f\7"+
		"\25\2\2\u008f\u0090\7\22\2\2\u0090\u0092\7\31\2\2\u0091\u0093\5\6\4\2"+
		"\u0092\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095"+
		"\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\7\32\2\2\u0097\u0098\b\13\1\2"+
		"\u0098\25\3\2\2\2\u0099\u009e\5\30\r\2\u009a\u009b\7\30\2\2\u009b\u009d"+
		"\5\30\r\2\u009c\u009a\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2"+
		"\u009e\u009f\3\2\2\2\u009f\27\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a2"+
		"\7\35\2\2\u00a2\u00a7\b\r\1\2\u00a3\u00a7\7\36\2\2\u00a4\u00a7\7\37\2"+
		"\2\u00a5\u00a7\7 \2\2\u00a6\u00a1\3\2\2\2\u00a6\u00a3\3\2\2\2\u00a6\u00a4"+
		"\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\31\3\2\2\2\17\"*\65@bjn}\u0083\u0087"+
		"\u0094\u009e\u00a6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}