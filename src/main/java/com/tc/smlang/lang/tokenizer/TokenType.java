package com.tc.smlang.lang.tokenizer;

public enum TokenType {

	CONDITIONAL("if", "if"),
	DEFINE_FUNCTION("def", "def"),
	RETURN("ret", "ret"),
	OPEN_PARENTHESIS("(", "("),
	CLOSE_PARENTHESIS(")", ")"),
	OPEN_CURLY_BRACKET("{", "{"),
	CLOSE_CURLY_BRACKET("}", "}"),
	SEMICOLON(";", ";"),
	ADDITION_OPERATOR("+", "+"),
	SUBTRACTION_OPERATOR("-", "-"),
	DIVISION_OPERATOR("//", "//"), 
	MULTIPLICATION_OPERATOR("*", "*"),
	EQUALITY_OPERATOR("=", "="),
	VAR_STRING("string", "string"),
	VAR_INT("int", "int"),
	QUOTATION_MARK("\"", "\""),
	NONKEYWORD("", "");
	
	private final String pattern;
	private final String value;
	
	private TokenType(String pattern, String value) {
		this.pattern = pattern;
		this.value = value;
	}
	
	public String getPattern() {
		return pattern;
	}
	
	public String getValue() {
		return value;
	}
}
