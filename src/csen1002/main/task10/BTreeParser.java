package csen1002.main.task10;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BTreeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Number=1, NIL=2, LP=3, RP=4, C=5;
	public static final int
		RULE_btree = 0, RULE_t = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"btree", "t"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'nil'", "'('", "')'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Number", "NIL", "LP", "RP", "C"
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
	public String getGrammarFileName() { return "BTree.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BTreeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class BtreeContext extends ParserRuleContext {
		public boolean val;
		public TContext t;
		public TContext t() {
			return getRuleContext(TContext.class,0);
		}
		public BtreeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_btree; }
	}

	public final BtreeContext btree() throws RecognitionException {
		BtreeContext _localctx = new BtreeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_btree);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4);
			((BtreeContext)_localctx).t = t();
			 ((BtreeContext)_localctx).val =  ((BtreeContext)_localctx).t.val; 
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

	public static class TContext extends ParserRuleContext {
		public int sum;
		public boolean val;
		public Token Number;
		public TContext t1;
		public TContext t2;
		public TerminalNode NIL() { return getToken(BTreeParser.NIL, 0); }
		public TerminalNode Number() { return getToken(BTreeParser.Number, 0); }
		public TerminalNode LP() { return getToken(BTreeParser.LP, 0); }
		public List<TerminalNode> C() { return getTokens(BTreeParser.C); }
		public TerminalNode C(int i) {
			return getToken(BTreeParser.C, i);
		}
		public TerminalNode RP() { return getToken(BTreeParser.RP, 0); }
		public List<TContext> t() {
			return getRuleContexts(TContext.class);
		}
		public TContext t(int i) {
			return getRuleContext(TContext.class,i);
		}
		public TContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_t; }
	}

	public final TContext t() throws RecognitionException {
		TContext _localctx = new TContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_t);
		try {
			setState(20);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NIL:
				enterOuterAlt(_localctx, 1);
				{
				setState(7);
				match(NIL);
				 ((TContext)_localctx).sum =  0; ((TContext)_localctx).val =  true; 
				}
				break;
			case Number:
				enterOuterAlt(_localctx, 2);
				{
				setState(9);
				((TContext)_localctx).Number = match(Number);
				 ((TContext)_localctx).sum =  (((TContext)_localctx).Number!=null?Integer.valueOf(((TContext)_localctx).Number.getText()):0); ((TContext)_localctx).val =  true; 
				}
				break;
			case LP:
				enterOuterAlt(_localctx, 3);
				{
				setState(11);
				match(LP);
				setState(12);
				((TContext)_localctx).Number = match(Number);
				setState(13);
				match(C);
				setState(14);
				((TContext)_localctx).t1 = t();
				setState(15);
				match(C);
				setState(16);
				((TContext)_localctx).t2 = t();
				setState(17);
				match(RP);
				 ((TContext)_localctx).sum =  ((TContext)_localctx).t1.sum + ((TContext)_localctx).t2.sum + (((TContext)_localctx).Number!=null?Integer.valueOf(((TContext)_localctx).Number.getText()):0); ((TContext)_localctx).val =  ((TContext)_localctx).t1.val && ((TContext)_localctx).t2.val && (((TContext)_localctx).t1.sum <= ((TContext)_localctx).t2.sum); 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\7\31\4\2\t\2\4\3"+
		"\t\3\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5"+
		"\3\27\n\3\3\3\2\2\4\2\4\2\2\2\30\2\6\3\2\2\2\4\26\3\2\2\2\6\7\5\4\3\2"+
		"\7\b\b\2\1\2\b\3\3\2\2\2\t\n\7\4\2\2\n\27\b\3\1\2\13\f\7\3\2\2\f\27\b"+
		"\3\1\2\r\16\7\5\2\2\16\17\7\3\2\2\17\20\7\7\2\2\20\21\5\4\3\2\21\22\7"+
		"\7\2\2\22\23\5\4\3\2\23\24\7\6\2\2\24\25\b\3\1\2\25\27\3\2\2\2\26\t\3"+
		"\2\2\2\26\13\3\2\2\2\26\r\3\2\2\2\27\5\3\2\2\2\3\26";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}