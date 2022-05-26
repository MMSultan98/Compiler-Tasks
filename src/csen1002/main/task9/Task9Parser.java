package csen1002.main.task9;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Task9Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		A=1, B=2, C=3;
	public static final int
		RULE_s = 0, RULE_a = 1, RULE_b = 2, RULE_c = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"s", "a", "b", "c"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'a'", "'b'", "'c'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "A", "B", "C"
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
	public String getGrammarFileName() { return "Task9.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		/**
		 * Compares two integer numbers
		 *
		 * @param x the first number to compare
		 * @param y the second number to compare
		 * @return 1 if x is equal to y, and 0 otherwise
		 */
		public static int equals(int x, int y) {
		    return x == y ? 1 : 0;
		}

	public Task9Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SContext extends ParserRuleContext {
		public int check;
		public AContext a;
		public CContext c;
		public BContext b;
		public AContext a() {
			return getRuleContext(AContext.class,0);
		}
		public CContext c() {
			return getRuleContext(CContext.class,0);
		}
		public BContext b() {
			return getRuleContext(BContext.class,0);
		}
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_s);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			((SContext)_localctx).a = a();
			setState(9);
			((SContext)_localctx).c = c();
			setState(10);
			((SContext)_localctx).b = b();
			 ((SContext)_localctx).check =  equals(((SContext)_localctx).a.n, ((SContext)_localctx).b.n) * equals(((SContext)_localctx).a.n, ((SContext)_localctx).c.n); 
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

	public static class AContext extends ParserRuleContext {
		public int n;
		public AContext a;
		public TerminalNode A() { return getToken(Task9Parser.A, 0); }
		public AContext a() {
			return getRuleContext(AContext.class,0);
		}
		public AContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_a; }
	}

	public final AContext a() throws RecognitionException {
		AContext _localctx = new AContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_a);
		try {
			setState(18);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case A:
				enterOuterAlt(_localctx, 1);
				{
				setState(13);
				match(A);
				setState(14);
				((AContext)_localctx).a = a();
				 ((AContext)_localctx).n =  ((AContext)_localctx).a.n + 1; 
				}
				break;
			case EOF:
			case B:
			case C:
				enterOuterAlt(_localctx, 2);
				{
				 ((AContext)_localctx).n =  0; 
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

	public static class BContext extends ParserRuleContext {
		public int n;
		public BContext b;
		public TerminalNode B() { return getToken(Task9Parser.B, 0); }
		public BContext b() {
			return getRuleContext(BContext.class,0);
		}
		public BContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_b; }
	}

	public final BContext b() throws RecognitionException {
		BContext _localctx = new BContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_b);
		try {
			setState(25);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case B:
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				match(B);
				setState(21);
				((BContext)_localctx).b = b();
				 ((BContext)_localctx).n =  ((BContext)_localctx).b.n + 1; 
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				 ((BContext)_localctx).n =  0; 
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

	public static class CContext extends ParserRuleContext {
		public int n;
		public CContext c;
		public TerminalNode C() { return getToken(Task9Parser.C, 0); }
		public CContext c() {
			return getRuleContext(CContext.class,0);
		}
		public CContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_c; }
	}

	public final CContext c() throws RecognitionException {
		CContext _localctx = new CContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_c);
		try {
			setState(32);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case C:
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				match(C);
				setState(28);
				((CContext)_localctx).c = c();
				 ((CContext)_localctx).n =  ((CContext)_localctx).c.n + 1; 
				}
				break;
			case EOF:
			case B:
				enterOuterAlt(_localctx, 2);
				{
				 ((CContext)_localctx).n =  0; 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\5%\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3\25\n\3"+
		"\3\4\3\4\3\4\3\4\3\4\5\4\34\n\4\3\5\3\5\3\5\3\5\3\5\5\5#\n\5\3\5\2\2\6"+
		"\2\4\6\b\2\2\2#\2\n\3\2\2\2\4\24\3\2\2\2\6\33\3\2\2\2\b\"\3\2\2\2\n\13"+
		"\5\4\3\2\13\f\5\b\5\2\f\r\5\6\4\2\r\16\b\2\1\2\16\3\3\2\2\2\17\20\7\3"+
		"\2\2\20\21\5\4\3\2\21\22\b\3\1\2\22\25\3\2\2\2\23\25\b\3\1\2\24\17\3\2"+
		"\2\2\24\23\3\2\2\2\25\5\3\2\2\2\26\27\7\4\2\2\27\30\5\6\4\2\30\31\b\4"+
		"\1\2\31\34\3\2\2\2\32\34\b\4\1\2\33\26\3\2\2\2\33\32\3\2\2\2\34\7\3\2"+
		"\2\2\35\36\7\5\2\2\36\37\5\b\5\2\37 \b\5\1\2 #\3\2\2\2!#\b\5\1\2\"\35"+
		"\3\2\2\2\"!\3\2\2\2#\t\3\2\2\2\5\24\33\"";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}