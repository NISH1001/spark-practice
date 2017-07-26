package com.codingparadox.nlp.tokenizer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class RegexTokenizer implements Tokenizer {

	/**
	 * It is the regex pattern string
	 */
	private String regex;
	
	/**
	 * It is the regex object to be constructed from regex string
	 */
	private Pattern re; 

	public RegexTokenizer(String regex) {
		this.setRegex(regex);
		this.re = Pattern.compile(this.regex, Pattern.MULTILINE | Pattern.COMMENTS);
	}
	
	public RegexTokenizer() { }

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public List<String> tokenize(String text) {
		List<String> sentences = new ArrayList<String>();

		Matcher reMatcher = re.matcher(text);
		while (reMatcher.find()) {
			sentences.add(reMatcher.group());
		}
		return sentences;
	}
}
