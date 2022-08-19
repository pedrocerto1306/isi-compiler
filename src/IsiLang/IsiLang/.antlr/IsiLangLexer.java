// Generated from c:\Users\Pedro Certo\Documents\UFABC\Compiladores\isi-compiler\src\IsiLang\IsiLang\IsiLang.g4 by ANTLR 4.9.2

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
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\"\u00fa\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00ca\n\33\3\34\3\34\7\34"+
		"\u00ce\n\34\f\34\16\34\u00d1\13\34\3\35\6\35\u00d4\n\35\r\35\16\35\u00d5"+
		"\3\35\3\35\6\35\u00da\n\35\r\35\16\35\u00db\5\35\u00de\n\35\3\36\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\5\37\u00f3\n\37\3 \3 \3!\3!\3!\3!\2\2\"\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"\3\2\b"+
		"\b\2%%\'\',-//\61\61``\4\2>>@@\3\2c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17"+
		"\17\"\"\2\u0102\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\3C\3\2\2\2\5L\3"+
		"\2\2\2\7U\3\2\2\2\t]\3\2\2\2\13d\3\2\2\2\ri\3\2\2\2\17n\3\2\2\2\21v\3"+
		"\2\2\2\23{\3\2\2\2\25~\3\2\2\2\27\u0084\3\2\2\2\31\u008a\3\2\2\2\33\u0092"+
		"\3\2\2\2\35\u0097\3\2\2\2\37\u009f\3\2\2\2!\u00a8\3\2\2\2#\u00ad\3\2\2"+
		"\2%\u00af\3\2\2\2\'\u00b1\3\2\2\2)\u00b3\3\2\2\2+\u00b6\3\2\2\2-\u00b8"+
		"\3\2\2\2/\u00ba\3\2\2\2\61\u00bc\3\2\2\2\63\u00be\3\2\2\2\65\u00c9\3\2"+
		"\2\2\67\u00cb\3\2\2\29\u00d3\3\2\2\2;\u00df\3\2\2\2=\u00f2\3\2\2\2?\u00f4"+
		"\3\2\2\2A\u00f6\3\2\2\2CD\7r\2\2DE\7t\2\2EF\7q\2\2FG\7i\2\2GH\7t\2\2H"+
		"I\7c\2\2IJ\7o\2\2JK\7c\2\2K\4\3\2\2\2LM\7h\2\2MN\7k\2\2NO\7o\2\2OP\7r"+
		"\2\2PQ\7t\2\2QR\7q\2\2RS\7i\2\2ST\7\60\2\2T\6\3\2\2\2UV\7f\2\2VW\7g\2"+
		"\2WX\7e\2\2XY\7n\2\2YZ\7c\2\2Z[\7t\2\2[\\\7g\2\2\\\b\3\2\2\2]^\7p\2\2"+
		"^_\7w\2\2_`\7o\2\2`a\7d\2\2ab\7g\2\2bc\7t\2\2c\n\3\2\2\2de\7v\2\2ef\7"+
		"g\2\2fg\7z\2\2gh\7v\2\2h\f\3\2\2\2ij\7d\2\2jk\7q\2\2kl\7q\2\2lm\7n\2\2"+
		"m\16\3\2\2\2no\7g\2\2op\7u\2\2pq\7e\2\2qr\7t\2\2rs\7g\2\2st\7x\2\2tu\7"+
		"c\2\2u\20\3\2\2\2vw\7n\2\2wx\7g\2\2xy\7k\2\2yz\7c\2\2z\22\3\2\2\2{|\7"+
		"u\2\2|}\7g\2\2}\24\3\2\2\2~\177\7g\2\2\177\u0080\7p\2\2\u0080\u0081\7"+
		"v\2\2\u0081\u0082\7c\2\2\u0082\u0083\7q\2\2\u0083\26\3\2\2\2\u0084\u0085"+
		"\7u\2\2\u0085\u0086\7g\2\2\u0086\u0087\7p\2\2\u0087\u0088\7c\2\2\u0088"+
		"\u0089\7q\2\2\u0089\30\3\2\2\2\u008a\u008b\7g\2\2\u008b\u008c\7u\2\2\u008c"+
		"\u008d\7e\2\2\u008d\u008e\7q\2\2\u008e\u008f\7n\2\2\u008f\u0090\7j\2\2"+
		"\u0090\u0091\7c\2\2\u0091\32\3\2\2\2\u0092\u0093\7e\2\2\u0093\u0094\7"+
		"c\2\2\u0094\u0095\7u\2\2\u0095\u0096\7q\2\2\u0096\34\3\2\2\2\u0097\u0098"+
		"\7s\2\2\u0098\u0099\7w\2\2\u0099\u009a\7g\2\2\u009a\u009b\7d\2\2\u009b"+
		"\u009c\7t\2\2\u009c\u009d\7c\2\2\u009d\u009e\7\60\2\2\u009e\36\3\2\2\2"+
		"\u009f\u00a0\7g\2\2\u00a0\u00a1\7p\2\2\u00a1\u00a2\7s\2\2\u00a2\u00a3"+
		"\7w\2\2\u00a3\u00a4\7c\2\2\u00a4\u00a5\7p\2\2\u00a5\u00a6\7v\2\2\u00a6"+
		"\u00a7\7q\2\2\u00a7 \3\2\2\2\u00a8\u00a9\7h\2\2\u00a9\u00aa\7c\2\2\u00aa"+
		"\u00ab\7\u00e9\2\2\u00ab\u00ac\7c\2\2\u00ac\"\3\2\2\2\u00ad\u00ae\7<\2"+
		"\2\u00ae$\3\2\2\2\u00af\u00b0\7*\2\2\u00b0&\3\2\2\2\u00b1\u00b2\7+\2\2"+
		"\u00b2(\3\2\2\2\u00b3\u00b4\7<\2\2\u00b4\u00b5\7?\2\2\u00b5*\3\2\2\2\u00b6"+
		"\u00b7\7\60\2\2\u00b7,\3\2\2\2\u00b8\u00b9\t\2\2\2\u00b9.\3\2\2\2\u00ba"+
		"\u00bb\7}\2\2\u00bb\60\3\2\2\2\u00bc\u00bd\7\177\2\2\u00bd\62\3\2\2\2"+
		"\u00be\u00bf\7.\2\2\u00bf\64\3\2\2\2\u00c0\u00ca\t\3\2\2\u00c1\u00c2\7"+
		"@\2\2\u00c2\u00ca\7?\2\2\u00c3\u00c4\7>\2\2\u00c4\u00ca\7?\2\2\u00c5\u00c6"+
		"\7?\2\2\u00c6\u00ca\7?\2\2\u00c7\u00c8\7#\2\2\u00c8\u00ca\7?\2\2\u00c9"+
		"\u00c0\3\2\2\2\u00c9\u00c1\3\2\2\2\u00c9\u00c3\3\2\2\2\u00c9\u00c5\3\2"+
		"\2\2\u00c9\u00c7\3\2\2\2\u00ca\66\3\2\2\2\u00cb\u00cf\t\4\2\2\u00cc\u00ce"+
		"\t\5\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf"+
		"\u00d0\3\2\2\2\u00d08\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d4\t\6\2\2"+
		"\u00d3\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6"+
		"\3\2\2\2\u00d6\u00dd\3\2\2\2\u00d7\u00d9\7=\2\2\u00d8\u00da\t\6\2\2\u00d9"+
		"\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2"+
		"\2\2\u00dc\u00de\3\2\2\2\u00dd\u00d7\3\2\2\2\u00dd\u00de\3\2\2\2\u00de"+
		":\3\2\2\2\u00df\u00e0\5? \2\u00e0\u00e1\5\67\34\2\u00e1\u00e2\5? \2\u00e2"+
		"<\3\2\2\2\u00e3\u00e4\7x\2\2\u00e4\u00e5\7g\2\2\u00e5\u00e6\7t\2\2\u00e6"+
		"\u00e7\7f\2\2\u00e7\u00e8\7c\2\2\u00e8\u00e9\7f\2\2\u00e9\u00ea\7g\2\2"+
		"\u00ea\u00eb\7k\2\2\u00eb\u00ec\7t\2\2\u00ec\u00f3\7q\2\2\u00ed\u00ee"+
		"\7h\2\2\u00ee\u00ef\7c\2\2\u00ef\u00f0\7n\2\2\u00f0\u00f1\7u\2\2\u00f1"+
		"\u00f3\7q\2\2\u00f2\u00e3\3\2\2\2\u00f2\u00ed\3\2\2\2\u00f3>\3\2\2\2\u00f4"+
		"\u00f5\7$\2\2\u00f5@\3\2\2\2\u00f6\u00f7\t\7\2\2\u00f7\u00f8\3\2\2\2\u00f8"+
		"\u00f9\b!\2\2\u00f9B\3\2\2\2\n\2\u00c9\u00cd\u00cf\u00d5\u00db\u00dd\u00f2"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}