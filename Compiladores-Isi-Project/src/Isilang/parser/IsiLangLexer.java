// Generated from IsiLang.g4 by ANTLR 4.10.1
package Isilang.parser;

    import Isilang.exceptions.IsiSemanticException;
    import Isilang.datastructures.IsiSymbolTable;
    import Isilang.datastructures.IsiVariable;
    import Isilang.datastructures.IsiSymbol;

    import Isilang.ast.IsiProgram;
    import Isilang.ast.AbstractCommand;

    import Isilang.ast.CommandAttribution;
    import Isilang.ast.CommandRead;
    import Isilang.ast.CommandWrite;
    import Isilang.ast.CommandIf;
    import Isilang.ast.CommandWhile;

    import java.util.ArrayList;
    import java.util.Stack;

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
		T__9=10, T__10=11, T__11=12, ACH=13, FCH=14, OPREL=15, NOT=16, VIR=17, 
		AP=18, FP=19, SC=20, OP=21, ATTR=22, ID=23, NUMBER=24, STR=25, WS=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "ACH", "FCH", "OPREL", "NOT", "VIR", "AP", 
			"FP", "SC", "OP", "ATTR", "ID", "NUMBER", "STR", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "'declare'", "'numero'", "'texto'", 
			"'leia'", "'escreva'", "'se'", "'senao'", "'enquanto'", "'&&'", "'||'", 
			"'{'", "'}'", null, "'!'", "','", "'('", "')'", "'.'", null, "':='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "ACH", "FCH", "OPREL", "NOT", "VIR", "AP", "FP", "SC", "OP", "ATTR", 
			"ID", "NUMBER", "STR", "WS"
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


	    private int _type;
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

	    public boolean isIDDeclared(String id){
	        return symbolTable.exists(id);
	    }

	    public void initializeVar(String id) {
	        if(isIDDeclared(id)){
	            IsiVariable var = symbolTable.get(id);
	            var.setInitialized(true);
	            symbolTable.replace(id, var);
	        }
	    }

	    public boolean isVarInitialized(String id) {
	        if(isIDDeclared(id)){
	            return symbolTable.get(id).isInitialized();
	        }
	        return false;
	    }

	    public void showCommands(){
	    		for (AbstractCommand c: program.getCommands()){
	    			System.out.println(c);
	    		}
	    	}

	    public boolean isNumber(String id){
	        if(isIDDeclared(id)){
	            IsiVariable var = symbolTable.get(id);
	            if(var.getType() == IsiVariable.NUMBER)
	                return true;
	            return false;
	        }
	        return false;
	    }

	    public void generateJavaCode(){
	        program.generateTarget();
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
		"\u0004\u0000\u001a\u00bf\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0003\u000e\u008e\b\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0005\u0016\u00a1\b\u0016\n\u0016\f\u0016\u00a4\t\u0016"+
		"\u0001\u0017\u0004\u0017\u00a7\b\u0017\u000b\u0017\f\u0017\u00a8\u0001"+
		"\u0017\u0001\u0017\u0004\u0017\u00ad\b\u0017\u000b\u0017\f\u0017\u00ae"+
		"\u0003\u0017\u00b1\b\u0017\u0001\u0018\u0001\u0018\u0005\u0018\u00b5\b"+
		"\u0018\n\u0018\f\u0018\u00b8\t\u0018\u0001\u0018\u0001\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u00b6\u0000\u001a\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u0018"+
		"1\u00193\u001a\u0001\u0000\u0006\u0002\u0000<<>>\u0003\u0000*+--//\u0001"+
		"\u0000az\u0003\u000009AZaz\u0001\u000009\u0003\u0000\t\n\r\r  \u00c7\u0000"+
		"\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000"+
		"\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000"+
		"\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r"+
		"\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/"+
		"\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000"+
		"\u0000\u0000\u00015\u0001\u0000\u0000\u0000\u0003>\u0001\u0000\u0000\u0000"+
		"\u0005F\u0001\u0000\u0000\u0000\u0007N\u0001\u0000\u0000\u0000\tU\u0001"+
		"\u0000\u0000\u0000\u000b[\u0001\u0000\u0000\u0000\r`\u0001\u0000\u0000"+
		"\u0000\u000fh\u0001\u0000\u0000\u0000\u0011k\u0001\u0000\u0000\u0000\u0013"+
		"q\u0001\u0000\u0000\u0000\u0015z\u0001\u0000\u0000\u0000\u0017}\u0001"+
		"\u0000\u0000\u0000\u0019\u0080\u0001\u0000\u0000\u0000\u001b\u0082\u0001"+
		"\u0000\u0000\u0000\u001d\u008d\u0001\u0000\u0000\u0000\u001f\u008f\u0001"+
		"\u0000\u0000\u0000!\u0091\u0001\u0000\u0000\u0000#\u0093\u0001\u0000\u0000"+
		"\u0000%\u0095\u0001\u0000\u0000\u0000\'\u0097\u0001\u0000\u0000\u0000"+
		")\u0099\u0001\u0000\u0000\u0000+\u009b\u0001\u0000\u0000\u0000-\u009e"+
		"\u0001\u0000\u0000\u0000/\u00a6\u0001\u0000\u0000\u00001\u00b2\u0001\u0000"+
		"\u0000\u00003\u00bb\u0001\u0000\u0000\u000056\u0005p\u0000\u000067\u0005"+
		"r\u0000\u000078\u0005o\u0000\u000089\u0005g\u0000\u00009:\u0005r\u0000"+
		"\u0000:;\u0005a\u0000\u0000;<\u0005m\u0000\u0000<=\u0005a\u0000\u0000"+
		"=\u0002\u0001\u0000\u0000\u0000>?\u0005f\u0000\u0000?@\u0005i\u0000\u0000"+
		"@A\u0005m\u0000\u0000AB\u0005p\u0000\u0000BC\u0005r\u0000\u0000CD\u0005"+
		"o\u0000\u0000DE\u0005g\u0000\u0000E\u0004\u0001\u0000\u0000\u0000FG\u0005"+
		"d\u0000\u0000GH\u0005e\u0000\u0000HI\u0005c\u0000\u0000IJ\u0005l\u0000"+
		"\u0000JK\u0005a\u0000\u0000KL\u0005r\u0000\u0000LM\u0005e\u0000\u0000"+
		"M\u0006\u0001\u0000\u0000\u0000NO\u0005n\u0000\u0000OP\u0005u\u0000\u0000"+
		"PQ\u0005m\u0000\u0000QR\u0005e\u0000\u0000RS\u0005r\u0000\u0000ST\u0005"+
		"o\u0000\u0000T\b\u0001\u0000\u0000\u0000UV\u0005t\u0000\u0000VW\u0005"+
		"e\u0000\u0000WX\u0005x\u0000\u0000XY\u0005t\u0000\u0000YZ\u0005o\u0000"+
		"\u0000Z\n\u0001\u0000\u0000\u0000[\\\u0005l\u0000\u0000\\]\u0005e\u0000"+
		"\u0000]^\u0005i\u0000\u0000^_\u0005a\u0000\u0000_\f\u0001\u0000\u0000"+
		"\u0000`a\u0005e\u0000\u0000ab\u0005s\u0000\u0000bc\u0005c\u0000\u0000"+
		"cd\u0005r\u0000\u0000de\u0005e\u0000\u0000ef\u0005v\u0000\u0000fg\u0005"+
		"a\u0000\u0000g\u000e\u0001\u0000\u0000\u0000hi\u0005s\u0000\u0000ij\u0005"+
		"e\u0000\u0000j\u0010\u0001\u0000\u0000\u0000kl\u0005s\u0000\u0000lm\u0005"+
		"e\u0000\u0000mn\u0005n\u0000\u0000no\u0005a\u0000\u0000op\u0005o\u0000"+
		"\u0000p\u0012\u0001\u0000\u0000\u0000qr\u0005e\u0000\u0000rs\u0005n\u0000"+
		"\u0000st\u0005q\u0000\u0000tu\u0005u\u0000\u0000uv\u0005a\u0000\u0000"+
		"vw\u0005n\u0000\u0000wx\u0005t\u0000\u0000xy\u0005o\u0000\u0000y\u0014"+
		"\u0001\u0000\u0000\u0000z{\u0005&\u0000\u0000{|\u0005&\u0000\u0000|\u0016"+
		"\u0001\u0000\u0000\u0000}~\u0005|\u0000\u0000~\u007f\u0005|\u0000\u0000"+
		"\u007f\u0018\u0001\u0000\u0000\u0000\u0080\u0081\u0005{\u0000\u0000\u0081"+
		"\u001a\u0001\u0000\u0000\u0000\u0082\u0083\u0005}\u0000\u0000\u0083\u001c"+
		"\u0001\u0000\u0000\u0000\u0084\u008e\u0007\u0000\u0000\u0000\u0085\u0086"+
		"\u0005>\u0000\u0000\u0086\u008e\u0005=\u0000\u0000\u0087\u0088\u0005<"+
		"\u0000\u0000\u0088\u008e\u0005=\u0000\u0000\u0089\u008a\u0005=\u0000\u0000"+
		"\u008a\u008e\u0005=\u0000\u0000\u008b\u008c\u0005!\u0000\u0000\u008c\u008e"+
		"\u0005=\u0000\u0000\u008d\u0084\u0001\u0000\u0000\u0000\u008d\u0085\u0001"+
		"\u0000\u0000\u0000\u008d\u0087\u0001\u0000\u0000\u0000\u008d\u0089\u0001"+
		"\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e\u001e\u0001"+
		"\u0000\u0000\u0000\u008f\u0090\u0005!\u0000\u0000\u0090 \u0001\u0000\u0000"+
		"\u0000\u0091\u0092\u0005,\u0000\u0000\u0092\"\u0001\u0000\u0000\u0000"+
		"\u0093\u0094\u0005(\u0000\u0000\u0094$\u0001\u0000\u0000\u0000\u0095\u0096"+
		"\u0005)\u0000\u0000\u0096&\u0001\u0000\u0000\u0000\u0097\u0098\u0005."+
		"\u0000\u0000\u0098(\u0001\u0000\u0000\u0000\u0099\u009a\u0007\u0001\u0000"+
		"\u0000\u009a*\u0001\u0000\u0000\u0000\u009b\u009c\u0005:\u0000\u0000\u009c"+
		"\u009d\u0005=\u0000\u0000\u009d,\u0001\u0000\u0000\u0000\u009e\u00a2\u0007"+
		"\u0002\u0000\u0000\u009f\u00a1\u0007\u0003\u0000\u0000\u00a0\u009f\u0001"+
		"\u0000\u0000\u0000\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3.\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a7\u0007\u0004"+
		"\u0000\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000"+
		"\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000"+
		"\u0000\u0000\u00a9\u00b0\u0001\u0000\u0000\u0000\u00aa\u00ac\u0005.\u0000"+
		"\u0000\u00ab\u00ad\u0007\u0004\u0000\u0000\u00ac\u00ab\u0001\u0000\u0000"+
		"\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000"+
		"\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00b1\u0001\u0000\u0000"+
		"\u0000\u00b0\u00aa\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000"+
		"\u0000\u00b10\u0001\u0000\u0000\u0000\u00b2\u00b6\u0005\"\u0000\u0000"+
		"\u00b3\u00b5\t\u0000\u0000\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b8\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b4\u0001\u0000\u0000\u0000\u00b7\u00b9\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005\"\u0000\u0000\u00ba2"+
		"\u0001\u0000\u0000\u0000\u00bb\u00bc\u0007\u0005\u0000\u0000\u00bc\u00bd"+
		"\u0001\u0000\u0000\u0000\u00bd\u00be\u0006\u0019\u0000\u0000\u00be4\u0001"+
		"\u0000\u0000\u0000\b\u0000\u008d\u00a0\u00a2\u00a8\u00ae\u00b0\u00b6\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}