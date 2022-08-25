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

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IsiLangParser}.
 */
public interface IsiLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(IsiLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(IsiLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(IsiLangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(IsiLangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(IsiLangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(IsiLangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmddeclara}.
	 * @param ctx the parse tree
	 */
	void enterCmddeclara(IsiLangParser.CmddeclaraContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmddeclara}.
	 * @param ctx the parse tree
	 */
	void exitCmddeclara(IsiLangParser.CmddeclaraContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(IsiLangParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(IsiLangParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(IsiLangParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(IsiLangParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(IsiLangParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(IsiLangParser.CmdleituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdattrib(IsiLangParser.CmdattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdattrib(IsiLangParser.CmdattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdcondicao}.
	 * @param ctx the parse tree
	 */
	void enterCmdcondicao(IsiLangParser.CmdcondicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdcondicao}.
	 * @param ctx the parse tree
	 */
	void exitCmdcondicao(IsiLangParser.CmdcondicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdrepeticao}.
	 * @param ctx the parse tree
	 */
	void enterCmdrepeticao(IsiLangParser.CmdrepeticaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdrepeticao}.
	 * @param ctx the parse tree
	 */
	void exitCmdrepeticao(IsiLangParser.CmdrepeticaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdoperacao}.
	 * @param ctx the parse tree
	 */
	void enterCmdoperacao(IsiLangParser.CmdoperacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdoperacao}.
	 * @param ctx the parse tree
	 */
	void exitCmdoperacao(IsiLangParser.CmdoperacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(IsiLangParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(IsiLangParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(IsiLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(IsiLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#exprTermo}.
	 * @param ctx the parse tree
	 */
	void enterExprTermo(IsiLangParser.ExprTermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#exprTermo}.
	 * @param ctx the parse tree
	 */
	void exitExprTermo(IsiLangParser.ExprTermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(IsiLangParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(IsiLangParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#boolExprChild}.
	 * @param ctx the parse tree
	 */
	void enterBoolExprChild(IsiLangParser.BoolExprChildContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#boolExprChild}.
	 * @param ctx the parse tree
	 */
	void exitBoolExprChild(IsiLangParser.BoolExprChildContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#boolExprChildChild}.
	 * @param ctx the parse tree
	 */
	void enterBoolExprChildChild(IsiLangParser.BoolExprChildChildContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#boolExprChildChild}.
	 * @param ctx the parse tree
	 */
	void exitBoolExprChildChild(IsiLangParser.BoolExprChildChildContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#boolTermo}.
	 * @param ctx the parse tree
	 */
	void enterBoolTermo(IsiLangParser.BoolTermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#boolTermo}.
	 * @param ctx the parse tree
	 */
	void exitBoolTermo(IsiLangParser.BoolTermoContext ctx);
}