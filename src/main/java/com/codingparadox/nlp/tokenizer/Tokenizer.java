package com.codingparadox.nlp.tokenizer;

import java.util.List;

/**
 * A tokenizers actually splits the text into relevant tokens.
 * A list of tokens is generated which are used for further processes.
 *
 */
public interface Tokenizer {
	
	public List<String> tokenize(String text);
}
