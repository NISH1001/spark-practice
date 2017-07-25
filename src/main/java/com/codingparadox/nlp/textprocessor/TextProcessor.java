package com.codingparadox.nlp.textprocessor;

/*
 * It processes the given text by various methods
 * 
 */
public interface TextProcessor {
	/**
	 * It processes the text.
	 * 
	 * @param text
	 * 		It is the input text
	 * @return
	 * 		//List of sentence : Sentence is list of tokens
	 * 		Processed text
	 */
	String processText(String text);
}
