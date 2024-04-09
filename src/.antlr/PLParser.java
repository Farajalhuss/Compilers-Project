// Generated from c:/Users/Faraj/OneDrive - Ontario Tech University/School/Compilers/CompilersProject/Compilers-Project/src/PL.g4 by ANTLR 4.13.1

import backend.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, CONCAT=24, 
		STRING=25, ID=26, NUMBER=27, WHITESPACE=28, NEWLINE=29;
	public static final int
		RULE_program = 0, RULE_block = 1, RULE_statement = 2, RULE_expression = 3, 
		RULE_assignment = 4, RULE_print = 5, RULE_forLoop = 6, RULE_ifElse = 7, 
		RULE_compareOp = 8, RULE_funcDecl = 9, RULE_funcInvoke = 10, RULE_paramList = 11, 
		RULE_argList = 12, RULE_stringLiteral = 13, RULE_intLiteral = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "block", "statement", "expression", "assignment", "print", 
			"forLoop", "ifElse", "compareOp", "funcDecl", "funcInvoke", "paramList", 
			"argList", "stringLiteral", "intLiteral"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'+'", "'-'", "'*'", "'='", "'print'", "'('", "')'", "'for'", 
			"'in'", "'..'", "'{'", "'}'", "'if'", "'else'", "'<'", "'<='", "'>'", 
			"'>='", "'=='", "'!='", "'function'", "','", "'++'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"CONCAT", "STRING", "ID", "NUMBER", "WHITESPACE", "NEWLINE"
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
	public String getGrammarFileName() { return "PL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	public PLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Expr expr;
		public BlockContext block;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PLParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			((ProgramContext)_localctx).block = block();
			setState(31);
			match(EOF);
			 ((ProgramContext)_localctx).expr =  ((ProgramContext)_localctx).block.blockExpr; 
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public Expr blockExpr;
		public StatementContext statement;
		public List<StatementContext> statements = new ArrayList<StatementContext>();
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(PLParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(PLParser.NEWLINE, i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				((BlockContext)_localctx).statement = statement();
				((BlockContext)_localctx).statements.add(((BlockContext)_localctx).statement);
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0 || _la==NEWLINE) {
					{
					setState(35);
					_la = _input.LA(1);
					if ( !(_la==T__0 || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				}
				}
				setState(40); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 239092416L) != 0) );
			 
			        List<Expr> exprList = new ArrayList<Expr>();
			        for (StatementContext stmt : ((BlockContext)_localctx).statements) {
			            exprList.add(stmt.statementExpr);
			        }
			        ((BlockContext)_localctx).blockExpr =  new Block(exprList);
			      
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Expr statementExpr;
		public AssignmentContext assignment;
		public FuncDeclContext funcDecl;
		public ForLoopContext forLoop;
		public IfElseContext ifElse;
		public PrintContext print;
		public ExpressionContext expression;
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public FuncDeclContext funcDecl() {
			return getRuleContext(FuncDeclContext.class,0);
		}
		public ForLoopContext forLoop() {
			return getRuleContext(ForLoopContext.class,0);
		}
		public IfElseContext ifElse() {
			return getRuleContext(IfElseContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				((StatementContext)_localctx).assignment = assignment();
				 ((StatementContext)_localctx).statementExpr =  ((StatementContext)_localctx).assignment.assignmentExpr; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				((StatementContext)_localctx).funcDecl = funcDecl();
				 ((StatementContext)_localctx).statementExpr =  ((StatementContext)_localctx).funcDecl.funcResult; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				((StatementContext)_localctx).forLoop = forLoop();
				((StatementContext)_localctx).statementExpr =  ((StatementContext)_localctx).forLoop.forLoopExpr; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(53);
				((StatementContext)_localctx).ifElse = ifElse();
				((StatementContext)_localctx).statementExpr =  ((StatementContext)_localctx).ifElse.ifElseExpr; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(56);
				((StatementContext)_localctx).print = print();
				 ((StatementContext)_localctx).statementExpr =  ((StatementContext)_localctx).print.printExpr; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(59);
				((StatementContext)_localctx).expression = expression(0);
				((StatementContext)_localctx).statementExpr =  ((StatementContext)_localctx).expression.expressionExpr; 
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expr expressionExpr;
		public ExpressionContext left;
		public FuncInvokeContext funcInvoke;
		public StringLiteralContext stringLiteral;
		public IntLiteralContext intLiteral;
		public CompareOpContext comparator;
		public ExpressionContext right;
		public FuncInvokeContext funcInvoke() {
			return getRuleContext(FuncInvokeContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public IntLiteralContext intLiteral() {
			return getRuleContext(IntLiteralContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CompareOpContext compareOp() {
			return getRuleContext(CompareOpContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(65);
				((ExpressionContext)_localctx).funcInvoke = funcInvoke();
				 ((ExpressionContext)_localctx).expressionExpr =  ((ExpressionContext)_localctx).funcInvoke.invokeResult; 
				}
				break;
			case 2:
				{
				setState(68);
				((ExpressionContext)_localctx).stringLiteral = stringLiteral(0);
				 ((ExpressionContext)_localctx).expressionExpr =  ((ExpressionContext)_localctx).stringLiteral.stringExpr; 
				}
				break;
			case 3:
				{
				setState(71);
				((ExpressionContext)_localctx).intLiteral = intLiteral();
				 ((ExpressionContext)_localctx).expressionExpr =  ((ExpressionContext)_localctx).intLiteral.intExpr; 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(98);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(96);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(76);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(77);
						((ExpressionContext)_localctx).comparator = compareOp();
						setState(78);
						((ExpressionContext)_localctx).right = expression(7);
						 ((ExpressionContext)_localctx).expressionExpr =  new Compare(((ExpressionContext)_localctx).comparator.comparator, ((ExpressionContext)_localctx).left.expressionExpr, ((ExpressionContext)_localctx).right.expressionExpr); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(81);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(82);
						match(T__1);
						setState(83);
						((ExpressionContext)_localctx).right = expression(4);
						 ((ExpressionContext)_localctx).expressionExpr =  new Arithmetics(Operator.Add, ((ExpressionContext)_localctx).left.expressionExpr, ((ExpressionContext)_localctx).right.expressionExpr); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(86);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(87);
						match(T__2);
						setState(88);
						((ExpressionContext)_localctx).right = expression(3);
						 ((ExpressionContext)_localctx).expressionExpr =  new Arithmetics(Operator.Sub, ((ExpressionContext)_localctx).left.expressionExpr, ((ExpressionContext)_localctx).right.expressionExpr); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(91);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(92);
						match(T__3);
						setState(93);
						((ExpressionContext)_localctx).right = expression(2);
						 ((ExpressionContext)_localctx).expressionExpr =  new Arithmetics(Operator.Mul, ((ExpressionContext)_localctx).left.expressionExpr, ((ExpressionContext)_localctx).right.expressionExpr); 
						}
						break;
					}
					} 
				}
				setState(100);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public Expr assignmentExpr;
		public Token ID;
		public ExpressionContext expression;
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			((AssignmentContext)_localctx).ID = match(ID);
			setState(102);
			match(T__4);
			setState(103);
			((AssignmentContext)_localctx).expression = expression(0);
			 ((AssignmentContext)_localctx).assignmentExpr =  new Assign((((AssignmentContext)_localctx).ID!=null?((AssignmentContext)_localctx).ID.getText():null), ((AssignmentContext)_localctx).expression.expressionExpr); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrintContext extends ParserRuleContext {
		public Expr printExpr;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitPrint(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__5);
			setState(107);
			match(T__6);
			setState(108);
			((PrintContext)_localctx).expression = expression(0);
			setState(109);
			match(T__7);
			 ((PrintContext)_localctx).printExpr =  new PrintExpr(((PrintContext)_localctx).expression.expressionExpr); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForLoopContext extends ParserRuleContext {
		public Expr forLoopExpr;
		public Token ID;
		public IntLiteralContext begin;
		public IntLiteralContext end;
		public BlockContext block;
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<IntLiteralContext> intLiteral() {
			return getRuleContexts(IntLiteralContext.class);
		}
		public IntLiteralContext intLiteral(int i) {
			return getRuleContext(IntLiteralContext.class,i);
		}
		public ForLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterForLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitForLoop(this);
		}
	}

	public final ForLoopContext forLoop() throws RecognitionException {
		ForLoopContext _localctx = new ForLoopContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_forLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(T__8);
			setState(113);
			match(T__6);
			setState(114);
			((ForLoopContext)_localctx).ID = match(ID);
			setState(115);
			match(T__9);
			setState(116);
			((ForLoopContext)_localctx).begin = intLiteral();
			setState(117);
			match(T__10);
			setState(118);
			((ForLoopContext)_localctx).end = intLiteral();
			setState(119);
			match(T__7);
			setState(120);
			match(T__11);
			setState(121);
			((ForLoopContext)_localctx).block = block();
			setState(122);
			match(T__12);
			 ((ForLoopContext)_localctx).forLoopExpr =  new ForLoop((((ForLoopContext)_localctx).ID!=null?((ForLoopContext)_localctx).ID.getText():null), ((ForLoopContext)_localctx).begin.intExpr, ((ForLoopContext)_localctx).end.intExpr, ((ForLoopContext)_localctx).block.blockExpr); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfElseContext extends ParserRuleContext {
		public Expr ifElseExpr;
		public ExpressionContext condition;
		public BlockContext trueBlock;
		public BlockContext falseBlock;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterIfElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitIfElse(this);
		}
	}

	public final IfElseContext ifElse() throws RecognitionException {
		IfElseContext _localctx = new IfElseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ifElse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(T__13);
			setState(126);
			match(T__6);
			setState(127);
			((IfElseContext)_localctx).condition = expression(0);
			setState(128);
			match(T__7);
			setState(129);
			match(T__11);
			setState(130);
			((IfElseContext)_localctx).trueBlock = block();
			setState(131);
			match(T__12);
			setState(132);
			match(T__14);
			setState(133);
			match(T__11);
			setState(134);
			((IfElseContext)_localctx).falseBlock = block();
			setState(135);
			match(T__12);
			 ((IfElseContext)_localctx).ifElseExpr =  new Ifelse(((IfElseContext)_localctx).condition.expressionExpr, ((IfElseContext)_localctx).trueBlock.blockExpr, ((IfElseContext)_localctx).falseBlock.blockExpr); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class CompareOpContext extends ParserRuleContext {
		public Comparator comparator;
		public CompareOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compareOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterCompareOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitCompareOp(this);
		}
	}

	public final CompareOpContext compareOp() throws RecognitionException {
		CompareOpContext _localctx = new CompareOpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_compareOp);
		try {
			setState(150);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				match(T__15);
				 ((CompareOpContext)_localctx).comparator =  Comparator.LT; 
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				match(T__16);
				 ((CompareOpContext)_localctx).comparator =  Comparator.LE; 
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				match(T__17);
				 ((CompareOpContext)_localctx).comparator =  Comparator.GT; 
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 4);
				{
				setState(144);
				match(T__18);
				 ((CompareOpContext)_localctx).comparator =  Comparator.GE; 
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 5);
				{
				setState(146);
				match(T__19);
				 ((CompareOpContext)_localctx).comparator =  Comparator.EQ; 
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 6);
				{
				setState(148);
				match(T__20);
				 ((CompareOpContext)_localctx).comparator =  Comparator.NE; 
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

	@SuppressWarnings("CheckReturnValue")
	public static class FuncDeclContext extends ParserRuleContext {
		public Expr funcResult;
		public Token funcName;
		public ParamListContext params;
		public BlockContext body;
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FuncDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterFuncDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitFuncDecl(this);
		}
	}

	public final FuncDeclContext funcDecl() throws RecognitionException {
		FuncDeclContext _localctx = new FuncDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_funcDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(T__21);
			setState(153);
			((FuncDeclContext)_localctx).funcName = match(ID);
			setState(154);
			match(T__6);
			setState(155);
			((FuncDeclContext)_localctx).params = paramList();
			setState(156);
			match(T__7);
			setState(157);
			match(T__11);
			setState(158);
			((FuncDeclContext)_localctx).body = block();
			setState(159);
			match(T__12);
			 ((FuncDeclContext)_localctx).funcResult =  new Declare((((FuncDeclContext)_localctx).funcName!=null?((FuncDeclContext)_localctx).funcName.getText():null), ((FuncDeclContext)_localctx).params.paramsList, ((FuncDeclContext)_localctx).body.blockExpr); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class FuncInvokeContext extends ParserRuleContext {
		public Expr invokeResult;
		public Token funcName;
		public ArgListContext args;
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public FuncInvokeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcInvoke; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterFuncInvoke(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitFuncInvoke(this);
		}
	}

	public final FuncInvokeContext funcInvoke() throws RecognitionException {
		FuncInvokeContext _localctx = new FuncInvokeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funcInvoke);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			((FuncInvokeContext)_localctx).funcName = match(ID);
			setState(163);
			match(T__6);
			setState(164);
			((FuncInvokeContext)_localctx).args = argList();
			setState(165);
			match(T__7);
			 ((FuncInvokeContext)_localctx).invokeResult =  new Invoke((((FuncInvokeContext)_localctx).funcName!=null?((FuncInvokeContext)_localctx).funcName.getText():null), ((FuncInvokeContext)_localctx).args.argsList); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamListContext extends ParserRuleContext {
		public List<String> paramsList;
		public Token id1;
		public Token ID;
		public List<Token> id2 = new ArrayList<Token>();
		public List<TerminalNode> ID() { return getTokens(PLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PLParser.ID, i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitParamList(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			((ParamListContext)_localctx).id1 = match(ID);
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__22) {
				{
				{
				setState(169);
				match(T__22);
				setState(170);
				((ParamListContext)_localctx).ID = match(ID);
				((ParamListContext)_localctx).id2.add(((ParamListContext)_localctx).ID);
				}
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			        ((ParamListContext)_localctx).paramsList =  new ArrayList<String>();
			        _localctx.paramsList.add((((ParamListContext)_localctx).id1!=null?((ParamListContext)_localctx).id1.getText():null)); 
			        for (Token t : ((ParamListContext)_localctx).id2) {     
			            _localctx.paramsList.add(t.getText()); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgListContext extends ParserRuleContext {
		public List<Expr> argsList;
		public ExpressionContext e1;
		public ExpressionContext expression;
		public List<ExpressionContext> e2 = new ArrayList<ExpressionContext>();
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitArgList(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			((ArgListContext)_localctx).e1 = expression(0);
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__22) {
				{
				{
				setState(179);
				match(T__22);
				setState(180);
				((ArgListContext)_localctx).expression = expression(0);
				((ArgListContext)_localctx).e2.add(((ArgListContext)_localctx).expression);
				}
				}
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			        ((ArgListContext)_localctx).argsList =  new ArrayList<Expr>();
			        _localctx.argsList.add(((ArgListContext)_localctx).e1.expressionExpr);
			        for (ExpressionContext e : ((ArgListContext)_localctx).e2) { 
			            _localctx.argsList.add(e.expressionExpr);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StringLiteralContext extends ParserRuleContext {
		public Expr stringExpr;
		public StringLiteralContext first;
		public StringLiteralContext left;
		public Token STRING;
		public Token ID;
		public ExpressionContext expression;
		public StringLiteralContext second;
		public IntLiteralContext right;
		public TerminalNode STRING() { return getToken(PLParser.STRING, 0); }
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CONCAT() { return getToken(PLParser.CONCAT, 0); }
		public List<StringLiteralContext> stringLiteral() {
			return getRuleContexts(StringLiteralContext.class);
		}
		public StringLiteralContext stringLiteral(int i) {
			return getRuleContext(StringLiteralContext.class,i);
		}
		public IntLiteralContext intLiteral() {
			return getRuleContext(IntLiteralContext.class,0);
		}
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitStringLiteral(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		return stringLiteral(0);
	}

	private StringLiteralContext stringLiteral(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, _parentState);
		StringLiteralContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_stringLiteral, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				{
				setState(189);
				((StringLiteralContext)_localctx).STRING = match(STRING);
				 ((StringLiteralContext)_localctx).stringExpr =  new StringLiteral((((StringLiteralContext)_localctx).STRING!=null?((StringLiteralContext)_localctx).STRING.getText():null).substring(1, (((StringLiteralContext)_localctx).STRING!=null?((StringLiteralContext)_localctx).STRING.getText():null).length() - 1)); 
				}
				break;
			case ID:
				{
				setState(191);
				((StringLiteralContext)_localctx).ID = match(ID);
				 ((StringLiteralContext)_localctx).stringExpr =  new Deref((((StringLiteralContext)_localctx).ID!=null?((StringLiteralContext)_localctx).ID.getText():null)); 
				}
				break;
			case T__6:
				{
				setState(193);
				match(T__6);
				setState(194);
				((StringLiteralContext)_localctx).expression = expression(0);
				setState(195);
				match(T__7);
				 ((StringLiteralContext)_localctx).stringExpr =  ((StringLiteralContext)_localctx).expression.expressionExpr; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(212);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(210);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new StringLiteralContext(_parentctx, _parentState);
						_localctx.first = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_stringLiteral);
						setState(200);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(201);
						match(CONCAT);
						setState(202);
						((StringLiteralContext)_localctx).second = stringLiteral(4);
						 ((StringLiteralContext)_localctx).stringExpr =  new StringConcatExpr(((StringLiteralContext)_localctx).first.stringExpr, ((StringLiteralContext)_localctx).second.stringExpr); 
						}
						break;
					case 2:
						{
						_localctx = new StringLiteralContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_stringLiteral);
						setState(205);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(206);
						match(T__3);
						setState(207);
						((StringLiteralContext)_localctx).right = intLiteral();
						 ((StringLiteralContext)_localctx).stringExpr =  new StringRepeatExpr(((StringLiteralContext)_localctx).left.stringExpr, ((StringLiteralContext)_localctx).right.intExpr); 
						}
						break;
					}
					} 
				}
				setState(214);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IntLiteralContext extends ParserRuleContext {
		public Expr intExpr;
		public Token NUMBER;
		public TerminalNode NUMBER() { return getToken(PLParser.NUMBER, 0); }
		public IntLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterIntLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitIntLiteral(this);
		}
	}

	public final IntLiteralContext intLiteral() throws RecognitionException {
		IntLiteralContext _localctx = new IntLiteralContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_intLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			((IntLiteralContext)_localctx).NUMBER = match(NUMBER);
			 ((IntLiteralContext)_localctx).intExpr =  new IntLiteral((((IntLiteralContext)_localctx).NUMBER!=null?((IntLiteralContext)_localctx).NUMBER.getText():null)); 
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 13:
			return stringLiteral_sempred((StringLiteralContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean stringLiteral_sempred(StringLiteralContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001d\u00db\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u0001%\b"+
		"\u0001\u0004\u0001\'\b\u0001\u000b\u0001\f\u0001(\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002?\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003K\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003a\b\u0003"+
		"\n\u0003\f\u0003d\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0097"+
		"\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0005\u000b\u00ac\b\u000b\n\u000b\f\u000b\u00af"+
		"\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u00b6"+
		"\b\f\n\f\f\f\u00b9\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00c7\b\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u00d3\b\r\n\r\f\r\u00d6\t\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0000\u0002\u0006\u001a\u000f\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000\u0001\u0002\u0000"+
		"\u0001\u0001\u001d\u001d\u00e3\u0000\u001e\u0001\u0000\u0000\u0000\u0002"+
		"&\u0001\u0000\u0000\u0000\u0004>\u0001\u0000\u0000\u0000\u0006J\u0001"+
		"\u0000\u0000\u0000\be\u0001\u0000\u0000\u0000\nj\u0001\u0000\u0000\u0000"+
		"\fp\u0001\u0000\u0000\u0000\u000e}\u0001\u0000\u0000\u0000\u0010\u0096"+
		"\u0001\u0000\u0000\u0000\u0012\u0098\u0001\u0000\u0000\u0000\u0014\u00a2"+
		"\u0001\u0000\u0000\u0000\u0016\u00a8\u0001\u0000\u0000\u0000\u0018\u00b2"+
		"\u0001\u0000\u0000\u0000\u001a\u00c6\u0001\u0000\u0000\u0000\u001c\u00d7"+
		"\u0001\u0000\u0000\u0000\u001e\u001f\u0003\u0002\u0001\u0000\u001f \u0005"+
		"\u0000\u0000\u0001 !\u0006\u0000\uffff\uffff\u0000!\u0001\u0001\u0000"+
		"\u0000\u0000\"$\u0003\u0004\u0002\u0000#%\u0007\u0000\u0000\u0000$#\u0001"+
		"\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%\'\u0001\u0000\u0000\u0000"+
		"&\"\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000"+
		"\u0000()\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*+\u0006\u0001"+
		"\uffff\uffff\u0000+\u0003\u0001\u0000\u0000\u0000,-\u0003\b\u0004\u0000"+
		"-.\u0006\u0002\uffff\uffff\u0000.?\u0001\u0000\u0000\u0000/0\u0003\u0012"+
		"\t\u000001\u0006\u0002\uffff\uffff\u00001?\u0001\u0000\u0000\u000023\u0003"+
		"\f\u0006\u000034\u0006\u0002\uffff\uffff\u00004?\u0001\u0000\u0000\u0000"+
		"56\u0003\u000e\u0007\u000067\u0006\u0002\uffff\uffff\u00007?\u0001\u0000"+
		"\u0000\u000089\u0003\n\u0005\u00009:\u0006\u0002\uffff\uffff\u0000:?\u0001"+
		"\u0000\u0000\u0000;<\u0003\u0006\u0003\u0000<=\u0006\u0002\uffff\uffff"+
		"\u0000=?\u0001\u0000\u0000\u0000>,\u0001\u0000\u0000\u0000>/\u0001\u0000"+
		"\u0000\u0000>2\u0001\u0000\u0000\u0000>5\u0001\u0000\u0000\u0000>8\u0001"+
		"\u0000\u0000\u0000>;\u0001\u0000\u0000\u0000?\u0005\u0001\u0000\u0000"+
		"\u0000@A\u0006\u0003\uffff\uffff\u0000AB\u0003\u0014\n\u0000BC\u0006\u0003"+
		"\uffff\uffff\u0000CK\u0001\u0000\u0000\u0000DE\u0003\u001a\r\u0000EF\u0006"+
		"\u0003\uffff\uffff\u0000FK\u0001\u0000\u0000\u0000GH\u0003\u001c\u000e"+
		"\u0000HI\u0006\u0003\uffff\uffff\u0000IK\u0001\u0000\u0000\u0000J@\u0001"+
		"\u0000\u0000\u0000JD\u0001\u0000\u0000\u0000JG\u0001\u0000\u0000\u0000"+
		"Kb\u0001\u0000\u0000\u0000LM\n\u0006\u0000\u0000MN\u0003\u0010\b\u0000"+
		"NO\u0003\u0006\u0003\u0007OP\u0006\u0003\uffff\uffff\u0000Pa\u0001\u0000"+
		"\u0000\u0000QR\n\u0003\u0000\u0000RS\u0005\u0002\u0000\u0000ST\u0003\u0006"+
		"\u0003\u0004TU\u0006\u0003\uffff\uffff\u0000Ua\u0001\u0000\u0000\u0000"+
		"VW\n\u0002\u0000\u0000WX\u0005\u0003\u0000\u0000XY\u0003\u0006\u0003\u0003"+
		"YZ\u0006\u0003\uffff\uffff\u0000Za\u0001\u0000\u0000\u0000[\\\n\u0001"+
		"\u0000\u0000\\]\u0005\u0004\u0000\u0000]^\u0003\u0006\u0003\u0002^_\u0006"+
		"\u0003\uffff\uffff\u0000_a\u0001\u0000\u0000\u0000`L\u0001\u0000\u0000"+
		"\u0000`Q\u0001\u0000\u0000\u0000`V\u0001\u0000\u0000\u0000`[\u0001\u0000"+
		"\u0000\u0000ad\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001"+
		"\u0000\u0000\u0000c\u0007\u0001\u0000\u0000\u0000db\u0001\u0000\u0000"+
		"\u0000ef\u0005\u001a\u0000\u0000fg\u0005\u0005\u0000\u0000gh\u0003\u0006"+
		"\u0003\u0000hi\u0006\u0004\uffff\uffff\u0000i\t\u0001\u0000\u0000\u0000"+
		"jk\u0005\u0006\u0000\u0000kl\u0005\u0007\u0000\u0000lm\u0003\u0006\u0003"+
		"\u0000mn\u0005\b\u0000\u0000no\u0006\u0005\uffff\uffff\u0000o\u000b\u0001"+
		"\u0000\u0000\u0000pq\u0005\t\u0000\u0000qr\u0005\u0007\u0000\u0000rs\u0005"+
		"\u001a\u0000\u0000st\u0005\n\u0000\u0000tu\u0003\u001c\u000e\u0000uv\u0005"+
		"\u000b\u0000\u0000vw\u0003\u001c\u000e\u0000wx\u0005\b\u0000\u0000xy\u0005"+
		"\f\u0000\u0000yz\u0003\u0002\u0001\u0000z{\u0005\r\u0000\u0000{|\u0006"+
		"\u0006\uffff\uffff\u0000|\r\u0001\u0000\u0000\u0000}~\u0005\u000e\u0000"+
		"\u0000~\u007f\u0005\u0007\u0000\u0000\u007f\u0080\u0003\u0006\u0003\u0000"+
		"\u0080\u0081\u0005\b\u0000\u0000\u0081\u0082\u0005\f\u0000\u0000\u0082"+
		"\u0083\u0003\u0002\u0001\u0000\u0083\u0084\u0005\r\u0000\u0000\u0084\u0085"+
		"\u0005\u000f\u0000\u0000\u0085\u0086\u0005\f\u0000\u0000\u0086\u0087\u0003"+
		"\u0002\u0001\u0000\u0087\u0088\u0005\r\u0000\u0000\u0088\u0089\u0006\u0007"+
		"\uffff\uffff\u0000\u0089\u000f\u0001\u0000\u0000\u0000\u008a\u008b\u0005"+
		"\u0010\u0000\u0000\u008b\u0097\u0006\b\uffff\uffff\u0000\u008c\u008d\u0005"+
		"\u0011\u0000\u0000\u008d\u0097\u0006\b\uffff\uffff\u0000\u008e\u008f\u0005"+
		"\u0012\u0000\u0000\u008f\u0097\u0006\b\uffff\uffff\u0000\u0090\u0091\u0005"+
		"\u0013\u0000\u0000\u0091\u0097\u0006\b\uffff\uffff\u0000\u0092\u0093\u0005"+
		"\u0014\u0000\u0000\u0093\u0097\u0006\b\uffff\uffff\u0000\u0094\u0095\u0005"+
		"\u0015\u0000\u0000\u0095\u0097\u0006\b\uffff\uffff\u0000\u0096\u008a\u0001"+
		"\u0000\u0000\u0000\u0096\u008c\u0001\u0000\u0000\u0000\u0096\u008e\u0001"+
		"\u0000\u0000\u0000\u0096\u0090\u0001\u0000\u0000\u0000\u0096\u0092\u0001"+
		"\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0097\u0011\u0001"+
		"\u0000\u0000\u0000\u0098\u0099\u0005\u0016\u0000\u0000\u0099\u009a\u0005"+
		"\u001a\u0000\u0000\u009a\u009b\u0005\u0007\u0000\u0000\u009b\u009c\u0003"+
		"\u0016\u000b\u0000\u009c\u009d\u0005\b\u0000\u0000\u009d\u009e\u0005\f"+
		"\u0000\u0000\u009e\u009f\u0003\u0002\u0001\u0000\u009f\u00a0\u0005\r\u0000"+
		"\u0000\u00a0\u00a1\u0006\t\uffff\uffff\u0000\u00a1\u0013\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a3\u0005\u001a\u0000\u0000\u00a3\u00a4\u0005\u0007\u0000"+
		"\u0000\u00a4\u00a5\u0003\u0018\f\u0000\u00a5\u00a6\u0005\b\u0000\u0000"+
		"\u00a6\u00a7\u0006\n\uffff\uffff\u0000\u00a7\u0015\u0001\u0000\u0000\u0000"+
		"\u00a8\u00ad\u0005\u001a\u0000\u0000\u00a9\u00aa\u0005\u0017\u0000\u0000"+
		"\u00aa\u00ac\u0005\u001a\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000"+
		"\u00ac\u00af\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00b0\u0001\u0000\u0000\u0000"+
		"\u00af\u00ad\u0001\u0000\u0000\u0000\u00b0\u00b1\u0006\u000b\uffff\uffff"+
		"\u0000\u00b1\u0017\u0001\u0000\u0000\u0000\u00b2\u00b7\u0003\u0006\u0003"+
		"\u0000\u00b3\u00b4\u0005\u0017\u0000\u0000\u00b4\u00b6\u0003\u0006\u0003"+
		"\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b6\u00b9\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000"+
		"\u0000\u00b8\u00ba\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000"+
		"\u0000\u00ba\u00bb\u0006\f\uffff\uffff\u0000\u00bb\u0019\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0006\r\uffff\uffff\u0000\u00bd\u00be\u0005\u0019\u0000"+
		"\u0000\u00be\u00c7\u0006\r\uffff\uffff\u0000\u00bf\u00c0\u0005\u001a\u0000"+
		"\u0000\u00c0\u00c7\u0006\r\uffff\uffff\u0000\u00c1\u00c2\u0005\u0007\u0000"+
		"\u0000\u00c2\u00c3\u0003\u0006\u0003\u0000\u00c3\u00c4\u0005\b\u0000\u0000"+
		"\u00c4\u00c5\u0006\r\uffff\uffff\u0000\u00c5\u00c7\u0001\u0000\u0000\u0000"+
		"\u00c6\u00bc\u0001\u0000\u0000\u0000\u00c6\u00bf\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c1\u0001\u0000\u0000\u0000\u00c7\u00d4\u0001\u0000\u0000\u0000"+
		"\u00c8\u00c9\n\u0003\u0000\u0000\u00c9\u00ca\u0005\u0018\u0000\u0000\u00ca"+
		"\u00cb\u0003\u001a\r\u0004\u00cb\u00cc\u0006\r\uffff\uffff\u0000\u00cc"+
		"\u00d3\u0001\u0000\u0000\u0000\u00cd\u00ce\n\u0001\u0000\u0000\u00ce\u00cf"+
		"\u0005\u0004\u0000\u0000\u00cf\u00d0\u0003\u001c\u000e\u0000\u00d0\u00d1"+
		"\u0006\r\uffff\uffff\u0000\u00d1\u00d3\u0001\u0000\u0000\u0000\u00d2\u00c8"+
		"\u0001\u0000\u0000\u0000\u00d2\u00cd\u0001\u0000\u0000\u0000\u00d3\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d5\u001b\u0001\u0000\u0000\u0000\u00d6\u00d4"+
		"\u0001\u0000\u0000\u0000\u00d7\u00d8\u0005\u001b\u0000\u0000\u00d8\u00d9"+
		"\u0006\u000e\uffff\uffff\u0000\u00d9\u001d\u0001\u0000\u0000\u0000\f$"+
		"(>J`b\u0096\u00ad\u00b7\u00c6\u00d2\u00d4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}