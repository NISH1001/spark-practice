package com.codingparadox.nlp.textprocessor;

public class TextProcessorTest {
	
	public static void main(String[] args) {
		String text = "Hello! I am    Paradox. I am the ceo of CodingParadox. "
				+ "There are many Sr. Engineers in the company. "
				+ "Mr. X is the C.T.O. and ceo";
		TextProcessor textProcessor = new PunctuationRemover();
		TextProcessor acronymExpander = new AcronymExpander();
		
		String processedText = textProcessor.processText(text);
		System.out.println(acronymExpander.processText(processedText));
	}

}