package expr.subsetc;

import beaver.Symbol;
import beaver.Scanner;

import expr.subsetc.SubsetParser.Terminals;

%%

%class SubsetScanner
%extends Scanner
%function nextToken
%type Symbol
%yylexthrow Scanner.Exception
%eofval{
        return newToken(Terminals.EOF, "yo - end-of-file");
%eofval}
%unicode
%line
%column
%{
        private Symbol newToken(short id)
        {
                return new Symbol(id, yyline + 1, yycolumn + 1, yylength());
        }
        private Symbol newToken(short id, Object value)
        {
                return new Symbol(id, yyline + 1, yycolumn + 1, yylength(), value);
        
        }
%}

LineTerminator = \r|\n|\r\n
WhiteSpace = {LineTerminator} | [ \t\f]

Number = [:digit:] [:digit:]*

%%

{WhiteSpace}+           {/* ignore */}
<YYINITIAL> {
          {Number} { return newToken(Terminals.NUMBER, new Integer(yytext())); }
}

"a"     {return newToken(Terminals.ID);}
. | \n  {throw new Scanner.Exception("unexpected character '"+ yytext() +"'"); }