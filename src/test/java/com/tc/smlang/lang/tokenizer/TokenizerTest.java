package com.tc.smlang.lang.tokenizer;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.tc.smlang.lang.io.FileHandler;

public class TokenizerTest {

	@Test
	public void testTokenizerPatternList() {
		List<TokenType> patterns = Tokenizer.getPatternMatchList();
		System.out.println("--------------------------");
		System.out.println("testTokenizerPatternList");
		System.out.println("--------------------------");
		for(TokenType pattern : patterns) {
			System.out.println(pattern.getPattern());
		}
		System.out.println("--------------------------");
		assertNotNull(patterns);
	}
	
	@Test
	public void testTokenizerTokenizes() {
		System.out.println("testTokenizerTokenizes");
		System.out.println("--------------------------");
		String classContents = FileHandler.loadClassFile("test-tokenizer.txt");
		System.out.println(classContents);
		List<Token> tokens = Tokenizer.tokenizeKeywords(classContents);
		for(Token token : tokens) {
			//System.out.println(token.getTokenValue());
		}
		tokens = Tokenizer.tokenizeNonKeywords(classContents, tokens);
		for(Token token : tokens) {
			System.out.println(token.getTokenType() + " : " + token.getTokenValue());
		}
		System.out.println("--------------------------");
		assertNotNull(tokens);
	}
}
