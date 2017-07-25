package com.codingparadox.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class StringUtils {

	/**
	 * Check if the given string contains the word as a whole
	 * 
	 * @param source
	 * 		Original string 
	 * @param subItem
	 * 		The word that should be checked
	 * @return
	 * 		boolean Return true if the word is contained in the string
	 */
	public static List<Pair<Integer, Integer>> matchWord(String source, 
			String subItem,
			boolean ignoreCase){
		if(ignoreCase) {
			source = source.toLowerCase();
			subItem = subItem.toLowerCase();
		}

		String pattern = "\\b" + subItem + "\\b";
		Pattern patternObject = Pattern.compile(pattern);
		Matcher matcher = patternObject.matcher(source);
		
		List<Pair<Integer, Integer>> matches = new ArrayList();
		while(matcher.find()) {
			matches.add(new ImmutablePair<Integer, Integer>(matcher.start(), matcher.end()));
		}
		return matches;
	}

	/**
	 * Replaces the range of characters in the source
	 * by the substitution string
	 * 
	 * @param start
	 * 		Start index in the source
	 * @param end
	 * 		End index in the source
	 * @param source
	 * 		Original string
	 * @param substitution
	 * 		String to replace given range of characters
	 * @return
	 * 		Return the string after substitution
	 */
	public static String replaceStringChars(int start, int end, 
			String source, String substitution) {
		StringBuffer buffer = new StringBuffer(source);
		buffer.replace(start, end, substitution);
		return buffer.toString();
	}

}
