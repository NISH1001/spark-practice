package com.codingparadox.nlp.textprocessor;

/**
 * Removes dots from the acronym.
 * Eg:
 * 		C.E.O. => CEO
 * 
 * @param text
 * 		It is the input text
 * @return
 * 		Text with acronym without dots
 */
public class AcronymDotRemover implements TextProcessor {

	public String processText(String text) {
		return text.replaceAll("(?<!\\w)([A-Za-z])\\.", "$1");
	}

}
