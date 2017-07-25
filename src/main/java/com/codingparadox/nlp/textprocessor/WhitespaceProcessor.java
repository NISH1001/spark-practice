package com.codingparadox.nlp.textprocessor;

/**
 * This text processor removes multiple spaces
 */
public class WhitespaceProcessor implements TextProcessor {

	public String processText(String text) {
		return text.trim().replaceAll("\\s+", " ");
	}

}
