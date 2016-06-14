package com.tc.smlang.lang.tokenizer;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
	
	public static List<TokenType> getPatternMatchList() {
		List<TokenType> patterns = new ArrayList<>();
		for(TokenType token : TokenType.values()) {
			if(!token.name().equals(TokenType.NONKEYWORD.name())) {
				patterns.add(token);
			}
		}
		
		return patterns;
	}
	
	public static List<Token> tokenizeKeywords(String contents) {
		List<Token> tokens = new ArrayList<>();
		List<TokenType> patterns = getPatternMatchList();
		
		for(int i = 0; i < contents.length(); i++) {
			for(TokenType pattern : patterns) {
				if(contents.charAt(i) == pattern.getPattern().charAt(0)) {
					//Match, keep looping over 
					StringBuilder builder = new StringBuilder();
					int contentIndex = i;
					for(int patternIndex = 0; patternIndex < pattern.getPattern().length(); patternIndex++) {
						if(contentIndex + 1 > contents.length() || contents.charAt(contentIndex) != pattern.getPattern().charAt(patternIndex)) {
							break;
						}

						builder.append(contents.charAt(contentIndex));
						contentIndex++;
					}
					String potentialMatch = builder.toString();
					if(potentialMatch.equals(pattern.getPattern())) {
						int beginIndex = i;
						int endIndex = beginIndex + (pattern.getPattern().length() - 1);
						Token token = new Token(pattern, pattern.getValue(), beginIndex, endIndex);
						tokens.add(token);
						i += (pattern.getPattern().length() - 1);
						break;
					}
					//If we do not explicitly break out of the pattern loop, continue with it. 
					//This is used by the if statement with the two conditionals 
					continue;
				}
			}
		}
		
		return tokens;
	}
	
	public static List<Token> tokenizeNonKeywords(String contents, List<Token> tokens) {
		for(int i = 0; i < tokens.size(); i++) {
			if(i + 1 >= tokens.size()) {
				break;
			}
			
			int beforeEndIndex = tokens.get(i).getEndIndex();
			int afterBeginIndex = tokens.get(i + 1).getBeginIndex();
			if(afterBeginIndex - beforeEndIndex == 1) {
				continue;
			}

			String tokenValue = contents.substring(beforeEndIndex + 1, afterBeginIndex);
			//begin and end index only used during tokenization. Maybe re-calculate after tokenization to correct
			Token token = new Token(TokenType.NONKEYWORD, tokenValue, 0, 0);
			tokens.add(i + 1, token);
			
			i++;
		}
		
		return tokens;
	}
}
