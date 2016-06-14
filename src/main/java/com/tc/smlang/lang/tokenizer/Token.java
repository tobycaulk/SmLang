package com.tc.smlang.lang.tokenizer;

public class Token {

	private TokenType tokenType;
	private String tokenValue;
	private int beginIndex;
	private int endIndex;
	
	public Token(TokenType tokenType, String tokenValue, int beginIndex, int endIndex) {
		this.tokenType = tokenType;
		this.tokenValue = tokenValue;
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
	}

	public TokenType getTokenType() {
		return tokenType;
	}

	public void setTokenType(TokenType tokenType) {
		this.tokenType = tokenType;
	}

	public String getTokenValue() {
		return tokenValue;
	}
	
	public void setTokenValue(String tokenValue) {
		this.tokenValue = tokenValue;
	}
	
	public int getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
}
