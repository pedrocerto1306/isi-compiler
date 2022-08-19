// Generated from IsiLang.g4 by ANTLR 4.10.1
package br.com.comp2022.isilang.parser;

    import br.com.comp2022.isilang.datastructures.IsiSymbol;
    import br.com.comp2022.isilang.datastructures.IsiVariable;
    import br.com.comp2022.isilang.datastructures.IsiSymbolTable;
    import br.com.comp2022.isilang.exceptions.IsiSemanticException;
    import java.util.ArrayList;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, DP=17, 
		AP=18, FP=19, ATTR=20, PT=21, OP=22, ACH=23, FCH=24, VIR=25, OPREL=26, 
		ID=27, NUMBER=28, TEXT=29, BOOL=30, ASP=31, WP=32;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "DP", "AP", 
			"FP", "ATTR", "PT", "OP", "ACH", "FCH", "VIR", "OPREL", "ID", "NUMBER", 
			"TEXT", "BOOL", "ASP", "WP"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog.'", "'declare'", "'number'", "'text'", 
			"'bool'", "'escreva'", "'leia'", "'se'", "'entao'", "'senao'", "'escolha'", 
			"'caso'", "'quebra.'", "'enquanto'", "'fa\\u00E7a'", "':'", "'('", "')'", 
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


	public IsiLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000 \u00f8\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0003\u0019\u00c8\b\u0019\u0001\u001a\u0001\u001a"+
		"\u0005\u001a\u00cc\b\u001a\n\u001a\f\u001a\u00cf\t\u001a\u0001\u001b\u0004"+
		"\u001b\u00d2\b\u001b\u000b\u001b\f\u001b\u00d3\u0001\u001b\u0001\u001b"+
		"\u0004\u001b\u00d8\b\u001b\u000b\u001b\f\u001b\u00d9\u0003\u001b\u00dc"+
		"\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0003\u001d\u00f1\b\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0000\u0000 \u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010"+
		"!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a"+
		"5\u001b7\u001c9\u001d;\u001e=\u001f? \u0001\u0000\u0006\u0006\u0000##"+
		"%%*+--//^^\u0002\u0000<<>>\u0001\u0000az\u0003\u000009AZaz\u0001\u0000"+
		"09\u0003\u0000\t\n\r\r  \u0100\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-"+
		"\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000"+
		"\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000"+
		"\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;"+
		"\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000"+
		"\u0000\u0000\u0001A\u0001\u0000\u0000\u0000\u0003J\u0001\u0000\u0000\u0000"+
		"\u0005S\u0001\u0000\u0000\u0000\u0007[\u0001\u0000\u0000\u0000\tb\u0001"+
		"\u0000\u0000\u0000\u000bg\u0001\u0000\u0000\u0000\rl\u0001\u0000\u0000"+
		"\u0000\u000ft\u0001\u0000\u0000\u0000\u0011y\u0001\u0000\u0000\u0000\u0013"+
		"|\u0001\u0000\u0000\u0000\u0015\u0082\u0001\u0000\u0000\u0000\u0017\u0088"+
		"\u0001\u0000\u0000\u0000\u0019\u0090\u0001\u0000\u0000\u0000\u001b\u0095"+
		"\u0001\u0000\u0000\u0000\u001d\u009d\u0001\u0000\u0000\u0000\u001f\u00a6"+
		"\u0001\u0000\u0000\u0000!\u00ab\u0001\u0000\u0000\u0000#\u00ad\u0001\u0000"+
		"\u0000\u0000%\u00af\u0001\u0000\u0000\u0000\'\u00b1\u0001\u0000\u0000"+
		"\u0000)\u00b4\u0001\u0000\u0000\u0000+\u00b6\u0001\u0000\u0000\u0000-"+
		"\u00b8\u0001\u0000\u0000\u0000/\u00ba\u0001\u0000\u0000\u00001\u00bc\u0001"+
		"\u0000\u0000\u00003\u00c7\u0001\u0000\u0000\u00005\u00c9\u0001\u0000\u0000"+
		"\u00007\u00d1\u0001\u0000\u0000\u00009\u00dd\u0001\u0000\u0000\u0000;"+
		"\u00f0\u0001\u0000\u0000\u0000=\u00f2\u0001\u0000\u0000\u0000?\u00f4\u0001"+
		"\u0000\u0000\u0000AB\u0005p\u0000\u0000BC\u0005r\u0000\u0000CD\u0005o"+
		"\u0000\u0000DE\u0005g\u0000\u0000EF\u0005r\u0000\u0000FG\u0005a\u0000"+
		"\u0000GH\u0005m\u0000\u0000HI\u0005a\u0000\u0000I\u0002\u0001\u0000\u0000"+
		"\u0000JK\u0005f\u0000\u0000KL\u0005i\u0000\u0000LM\u0005m\u0000\u0000"+
		"MN\u0005p\u0000\u0000NO\u0005r\u0000\u0000OP\u0005o\u0000\u0000PQ\u0005"+
		"g\u0000\u0000QR\u0005.\u0000\u0000R\u0004\u0001\u0000\u0000\u0000ST\u0005"+
		"d\u0000\u0000TU\u0005e\u0000\u0000UV\u0005c\u0000\u0000VW\u0005l\u0000"+
		"\u0000WX\u0005a\u0000\u0000XY\u0005r\u0000\u0000YZ\u0005e\u0000\u0000"+
		"Z\u0006\u0001\u0000\u0000\u0000[\\\u0005n\u0000\u0000\\]\u0005u\u0000"+
		"\u0000]^\u0005m\u0000\u0000^_\u0005b\u0000\u0000_`\u0005e\u0000\u0000"+
		"`a\u0005r\u0000\u0000a\b\u0001\u0000\u0000\u0000bc\u0005t\u0000\u0000"+
		"cd\u0005e\u0000\u0000de\u0005x\u0000\u0000ef\u0005t\u0000\u0000f\n\u0001"+
		"\u0000\u0000\u0000gh\u0005b\u0000\u0000hi\u0005o\u0000\u0000ij\u0005o"+
		"\u0000\u0000jk\u0005l\u0000\u0000k\f\u0001\u0000\u0000\u0000lm\u0005e"+
		"\u0000\u0000mn\u0005s\u0000\u0000no\u0005c\u0000\u0000op\u0005r\u0000"+
		"\u0000pq\u0005e\u0000\u0000qr\u0005v\u0000\u0000rs\u0005a\u0000\u0000"+
		"s\u000e\u0001\u0000\u0000\u0000tu\u0005l\u0000\u0000uv\u0005e\u0000\u0000"+
		"vw\u0005i\u0000\u0000wx\u0005a\u0000\u0000x\u0010\u0001\u0000\u0000\u0000"+
		"yz\u0005s\u0000\u0000z{\u0005e\u0000\u0000{\u0012\u0001\u0000\u0000\u0000"+
		"|}\u0005e\u0000\u0000}~\u0005n\u0000\u0000~\u007f\u0005t\u0000\u0000\u007f"+
		"\u0080\u0005a\u0000\u0000\u0080\u0081\u0005o\u0000\u0000\u0081\u0014\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0005s\u0000\u0000\u0083\u0084\u0005e\u0000"+
		"\u0000\u0084\u0085\u0005n\u0000\u0000\u0085\u0086\u0005a\u0000\u0000\u0086"+
		"\u0087\u0005o\u0000\u0000\u0087\u0016\u0001\u0000\u0000\u0000\u0088\u0089"+
		"\u0005e\u0000\u0000\u0089\u008a\u0005s\u0000\u0000\u008a\u008b\u0005c"+
		"\u0000\u0000\u008b\u008c\u0005o\u0000\u0000\u008c\u008d\u0005l\u0000\u0000"+
		"\u008d\u008e\u0005h\u0000\u0000\u008e\u008f\u0005a\u0000\u0000\u008f\u0018"+
		"\u0001\u0000\u0000\u0000\u0090\u0091\u0005c\u0000\u0000\u0091\u0092\u0005"+
		"a\u0000\u0000\u0092\u0093\u0005s\u0000\u0000\u0093\u0094\u0005o\u0000"+
		"\u0000\u0094\u001a\u0001\u0000\u0000\u0000\u0095\u0096\u0005q\u0000\u0000"+
		"\u0096\u0097\u0005u\u0000\u0000\u0097\u0098\u0005e\u0000\u0000\u0098\u0099"+
		"\u0005b\u0000\u0000\u0099\u009a\u0005r\u0000\u0000\u009a\u009b\u0005a"+
		"\u0000\u0000\u009b\u009c\u0005.\u0000\u0000\u009c\u001c\u0001\u0000\u0000"+
		"\u0000\u009d\u009e\u0005e\u0000\u0000\u009e\u009f\u0005n\u0000\u0000\u009f"+
		"\u00a0\u0005q\u0000\u0000\u00a0\u00a1\u0005u\u0000\u0000\u00a1\u00a2\u0005"+
		"a\u0000\u0000\u00a2\u00a3\u0005n\u0000\u0000\u00a3\u00a4\u0005t\u0000"+
		"\u0000\u00a4\u00a5\u0005o\u0000\u0000\u00a5\u001e\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a7\u0005f\u0000\u0000\u00a7\u00a8\u0005a\u0000\u0000\u00a8\u00a9"+
		"\u0005\u00e7\u0000\u0000\u00a9\u00aa\u0005a\u0000\u0000\u00aa \u0001\u0000"+
		"\u0000\u0000\u00ab\u00ac\u0005:\u0000\u0000\u00ac\"\u0001\u0000\u0000"+
		"\u0000\u00ad\u00ae\u0005(\u0000\u0000\u00ae$\u0001\u0000\u0000\u0000\u00af"+
		"\u00b0\u0005)\u0000\u0000\u00b0&\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005"+
		":\u0000\u0000\u00b2\u00b3\u0005=\u0000\u0000\u00b3(\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b5\u0005.\u0000\u0000\u00b5*\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b7\u0007\u0000\u0000\u0000\u00b7,\u0001\u0000\u0000\u0000\u00b8\u00b9"+
		"\u0005{\u0000\u0000\u00b9.\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005}"+
		"\u0000\u0000\u00bb0\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005,\u0000\u0000"+
		"\u00bd2\u0001\u0000\u0000\u0000\u00be\u00c8\u0007\u0001\u0000\u0000\u00bf"+
		"\u00c0\u0005>\u0000\u0000\u00c0\u00c8\u0005=\u0000\u0000\u00c1\u00c2\u0005"+
		"<\u0000\u0000\u00c2\u00c8\u0005=\u0000\u0000\u00c3\u00c4\u0005=\u0000"+
		"\u0000\u00c4\u00c8\u0005=\u0000\u0000\u00c5\u00c6\u0005!\u0000\u0000\u00c6"+
		"\u00c8\u0005=\u0000\u0000\u00c7\u00be\u0001\u0000\u0000\u0000\u00c7\u00bf"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c1\u0001\u0000\u0000\u0000\u00c7\u00c3"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c84\u0001"+
		"\u0000\u0000\u0000\u00c9\u00cd\u0007\u0002\u0000\u0000\u00ca\u00cc\u0007"+
		"\u0003\u0000\u0000\u00cb\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cf\u0001"+
		"\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001"+
		"\u0000\u0000\u0000\u00ce6\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000"+
		"\u0000\u0000\u00d0\u00d2\u0007\u0004\u0000\u0000\u00d1\u00d0\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00db\u0001\u0000"+
		"\u0000\u0000\u00d5\u00d7\u0005;\u0000\u0000\u00d6\u00d8\u0007\u0004\u0000"+
		"\u0000\u00d7\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000"+
		"\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000"+
		"\u0000\u00da\u00dc\u0001\u0000\u0000\u0000\u00db\u00d5\u0001\u0000\u0000"+
		"\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc8\u0001\u0000\u0000\u0000"+
		"\u00dd\u00de\u0003=\u001e\u0000\u00de\u00df\u00035\u001a\u0000\u00df\u00e0"+
		"\u0003=\u001e\u0000\u00e0:\u0001\u0000\u0000\u0000\u00e1\u00e2\u0005v"+
		"\u0000\u0000\u00e2\u00e3\u0005e\u0000\u0000\u00e3\u00e4\u0005r\u0000\u0000"+
		"\u00e4\u00e5\u0005d\u0000\u0000\u00e5\u00e6\u0005a\u0000\u0000\u00e6\u00e7"+
		"\u0005d\u0000\u0000\u00e7\u00e8\u0005e\u0000\u0000\u00e8\u00e9\u0005i"+
		"\u0000\u0000\u00e9\u00ea\u0005r\u0000\u0000\u00ea\u00f1\u0005o\u0000\u0000"+
		"\u00eb\u00ec\u0005f\u0000\u0000\u00ec\u00ed\u0005a\u0000\u0000\u00ed\u00ee"+
		"\u0005l\u0000\u0000\u00ee\u00ef\u0005s\u0000\u0000\u00ef\u00f1\u0005o"+
		"\u0000\u0000\u00f0\u00e1\u0001\u0000\u0000\u0000\u00f0\u00eb\u0001\u0000"+
		"\u0000\u0000\u00f1<\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005\"\u0000"+
		"\u0000\u00f3>\u0001\u0000\u0000\u0000\u00f4\u00f5\u0007\u0005\u0000\u0000"+
		"\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6\u00f7\u0006\u001f\u0000\u0000"+
		"\u00f7@\u0001\u0000\u0000\u0000\b\u0000\u00c7\u00cb\u00cd\u00d3\u00d9"+
		"\u00db\u00f0\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}