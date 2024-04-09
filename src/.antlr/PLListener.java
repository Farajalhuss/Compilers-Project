// Generated from c:/Users/Faraj/OneDrive - Ontario Tech University/School/Compilers/CompilersProject/Compilers-Project/src/PL.g4 by ANTLR 4.13.1

import backend.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PLParser}.
 */
public interface PLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PLParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PLParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PLParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PLParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PLParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(PLParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(PLParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(PLParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(PLParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(PLParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(PLParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#ifElse}.
	 * @param ctx the parse tree
	 */
	void enterIfElse(PLParser.IfElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#ifElse}.
	 * @param ctx the parse tree
	 */
	void exitIfElse(PLParser.IfElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#compareOp}.
	 * @param ctx the parse tree
	 */
	void enterCompareOp(PLParser.CompareOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#compareOp}.
	 * @param ctx the parse tree
	 */
	void exitCompareOp(PLParser.CompareOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void enterFuncDecl(PLParser.FuncDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void exitFuncDecl(PLParser.FuncDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#funcInvoke}.
	 * @param ctx the parse tree
	 */
	void enterFuncInvoke(PLParser.FuncInvokeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#funcInvoke}.
	 * @param ctx the parse tree
	 */
	void exitFuncInvoke(PLParser.FuncInvokeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(PLParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(PLParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(PLParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(PLParser.ArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(PLParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(PLParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#intLiteral}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteral(PLParser.IntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#intLiteral}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteral(PLParser.IntLiteralContext ctx);
}