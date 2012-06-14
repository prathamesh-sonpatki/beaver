package expr.tree;

import java.util.ArrayList;
import beaver.*;
import expr.tree.ast.*;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "expr.grammar".
 */
public class ExpressionParser extends Parser {
	static public class Terminals {
		static public final short EOF = 0;
		static public final short MINUS = 1;
		static public final short LPAREN = 2;
		static public final short NUMBER = 3;
		static public final short MULT = 4;
		static public final short DIV = 5;
		static public final short RPAREN = 6;
		static public final short PLUS = 7;
	}

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9oDZziEWZ0GHASW20L58IP6eube8c$#eZ$j$R9Eov8GdsXpEjFjxcOBu2I2524YJuenHix" +
		"9ZIx359D1vnm5IWI#ye8O2InopEGAmB1Zv37icNWNqncVF#HCE9VLoepQxfWRgCxmAsy5XT" +
		"vBrOM8VAbBKfErY#lRbXpLHwHHlr7jydQgjUfUzT3hjUfyBrPf6xW9v4FUv4MUyl3nkoPO$" +
		"ilmJ#4V0MdZATLXVyKy9yW=");

	private final Action[] actions;

	public ExpressionParser() {
		super(PARSING_TABLES);
		actions = new Action[] {
			Action.RETURN,	// [0] $goal = expr
			new Action() {	// [1] expr = expr.a MULT expr.b
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new MultExpr (a, b);
				}
			},
			new Action() {	// [2] expr = expr.a DIV expr.b
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new DivExpr  (a, b);
				}
			},
			new Action() {	// [3] expr = expr.a PLUS expr.b
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new PlusExpr (a, b);
				}
			},
			new Action() {	// [4] expr = expr.a MINUS expr.b
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new MinusExpr(a, b);
				}
			},
			new Action() {	// [5] expr = MINUS expr.e
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 2];
					final Expr e = (Expr) _symbol_e.value;
					 return new NegExpr  (e);
				}
			},
			new Action() {	// [6] expr = NUMBER.n
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_n = _symbols[offset + 1];
					final Number n = (Number) _symbol_n.value;
					 return new NumExpr  (n);
				}
			},
			new Action() {	// [7] expr = LPAREN pexpr.e RPAREN
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 2];
					final Expr e = (Expr) _symbol_e.value;
					 return e;
				}
			},
			Action.RETURN,	// [8] pexpr = expr
			new Action() {	// [9] pexpr = error
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new ErrExpr();
				}
			}
		};
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		return actions[rule_num].reduce(_symbols, offset);
	}
}
