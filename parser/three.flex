
package com.cesar31.threewaycode.parser;

import java_cup.runtime.Symbol;
import static com.cesar31.threewaycode.parser.ThreeParserSym.*;

%%

%class ThreeLex
%type java_cup.runtime.Symbol
%public
%unicode
%cup
%line
%column

%{
	private Symbol symbol(int type) {
		return new Symbol(type, yyline + 1, yycolumn + 1);
	}

	private Symbol symbol(int type, Object object) {
		return new Symbol(type, yyline + 1, yycolumn + 1, object);
	}
%}

%eofval{
	return symbol(EOF);
%eofval}
%eofclose

LineTerminator = \r|\n|\r\n
WhiteSpace = [ \t\f]|{LineTerminator}

Id = \w+
Integer = 0|[1-9][0-9]*

%%

<YYINITIAL> {
	{Id}
	{ return symbol(ID, yytext()); }

	{Integer}
	{ return symbol(INTEGER, yytext()); }

	"+"
	{ return symbol(PLUS); }

	"-"
	{ return symbol(MINUS); }

	"*"
	{ return symbol(TIMES); }

	"/"
	{ return symbol(DIVIDE); }

	"("
	{ return symbol(LPAREN); }

	")"
	{ return symbol(RPAREN); }

	";"
	{ return symbol(SEMI); }

	"="
	{ return symbol(EQUAL); }

	{WhiteSpace}
	{ /* Ignore */ }

}

[^]
{
	System.out.println("Error: < " + yytext() + " >");
	return symbol(ERROR, yytext());
}