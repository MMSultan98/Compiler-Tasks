package csen1002.main.task8;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class task8Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Q2=1, Q3=2, Q4=3;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Q2", "Q3", "Q4", "E", "Q0"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Q2", "Q3", "Q4"
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


	public task8Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "task8.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\5>\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\5\3\31\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5%\n\5\3\5\3"+
		"\5\3\5\7\5*\n\5\f\5\16\5-\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\7\6:\n\6\f\6\16\6=\13\6\2\2\7\3\3\5\4\7\5\t\2\13\2\3\2\2\2C\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\3\r\3\2\2\2\5\21\3\2\2\2\7\32\3\2\2\2\t"+
		"$\3\2\2\2\13;\3\2\2\2\r\16\5\13\6\2\16\17\7\62\2\2\17\20\7\62\2\2\20\4"+
		"\3\2\2\2\21\30\5\13\6\2\22\23\7\62\2\2\23\24\7\62\2\2\24\31\7\62\2\2\25"+
		"\26\5\t\5\2\26\27\7\62\2\2\27\31\3\2\2\2\30\22\3\2\2\2\30\25\3\2\2\2\31"+
		"\6\3\2\2\2\32\33\5\13\6\2\33\34\5\t\5\2\34\b\3\2\2\2\35\36\7\62\2\2\36"+
		"\37\7\62\2\2\37%\7\63\2\2 !\7\62\2\2!\"\7\62\2\2\"#\7\62\2\2#%\7\63\2"+
		"\2$\35\3\2\2\2$ \3\2\2\2%+\3\2\2\2&\'\7\62\2\2\'*\7\63\2\2(*\7\63\2\2"+
		")&\3\2\2\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\n\3\2\2\2-+\3\2\2"+
		"\2.:\7\63\2\2/\60\7\62\2\2\60:\7\63\2\2\61\62\7\62\2\2\62\63\7\62\2\2"+
		"\63\64\7\62\2\2\64:\7\62\2\2\65\66\5\t\5\2\66\67\7\62\2\2\678\7\62\2\2"+
		"8:\3\2\2\29.\3\2\2\29/\3\2\2\29\61\3\2\2\29\65\3\2\2\2:=\3\2\2\2;9\3\2"+
		"\2\2;<\3\2\2\2<\f\3\2\2\2=;\3\2\2\2\t\2\30$)+9;\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}