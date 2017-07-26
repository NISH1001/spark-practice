package com.codingparadox.nlp.tokenizer;

/**
 * Splits the text in to list of sentence
 *
 */
public class SentenceTokenizer extends RegexTokenizer {
	
	public static String regex = "[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)"
				+ "[^.!?]*)*[.!?]?['\"]?(?=\\s|$)";

	public SentenceTokenizer(String regex) {
		super(regex);
	}

	public SentenceTokenizer() {
		this(SentenceTokenizer.regex);
	}
}