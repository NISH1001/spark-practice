package com.codingparadox.nlp.textprocessor;

/**
 * Remove unnecessary punctuation by converting them to space
 *
 */
public class PunctuationRemover implements TextProcessor {
	
	public String processText(String text) {
		return text.trim().replaceAll("(\\s+)|([,!.;]\\s+)", " ");
	}

}
