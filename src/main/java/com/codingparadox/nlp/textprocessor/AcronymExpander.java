package com.codingparadox.nlp.textprocessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.tuple.Pair;

import com.codingparadox.utils.StringUtils;

/**
 * It is used to expand the acronym in the text.
 * 
 */
public class AcronymExpander implements TextProcessor {
	
	private final TextProcessor acronymDotRemover = new AcronymDotRemover();

	/**
	 * Mapping for the acronym
	 */
	private Map<String, String> acronymMap = new HashMap();

	public AcronymExpander() {
		this.acronymMap.put("CEO", "Chief Executive Officer");
		this.acronymMap.put("CIO", "Chief Information Officer");
		this.acronymMap.put("CFO", "Chief Financial Officer");
		this.acronymMap.put("CTO", "Chief Techincal Officer");
		this.acronymMap.put("COO", "Chief Operating Officer");
		this.acronymMap.put("CMO", "Chief Marketing Officer");
		this.acronymMap.put("CCO", "Chief Compliance Officer");
		this.acronymMap.put("CSO", "Chief Security Officer");
		this.acronymMap.put("CDO", "Chief Data Officer");
		this.acronymMap.put("Sr", "Senior");
		this.acronymMap.put("Jr", "Junior");
		this.acronymMap.put("Mr", "Mister");
	}

	public String processText(String text) {
		text = this.acronymDotRemover.processText(text);

		// loop through the map
		for(Entry entry : this.acronymMap.entrySet()) {
			String acronym = (String) entry.getKey();
			String fullForm = (String) entry.getValue();

			// find the match
			// if no match, the pair contains (-1,-1)
			List<Pair<Integer, Integer>> matches = 
					StringUtils.matchWord(text, acronym, true);
			text = this.expand(matches, text, fullForm, acronym.length());
		}
		return text;
	}

	/**
	 * It expands the acronym
	 * 
	 * @param matches
	 * 		List of Tuple(start, end) that gives the positions of the acronym
	 * @param source
	 * 		The original text
	 * @param substitute
	 * 		Full form to substitute
	 * @param acronymLength
	 * 		Length of the acronym
	 * @return
	 */
	private String expand(List<Pair<Integer, Integer>> matches,
			String source,
			String substitute,
			int acronymLength) {
		if(matches.isEmpty()) {
			return source;
		}

		String text = source;
		boolean multipleExpansion = false;
		int substituteLength = substitute.length();
		for(Pair<Integer, Integer> match : matches) {
			int start = match.getLeft();
			int end = match.getRight();
			int offset = (!multipleExpansion) ? 0 : substituteLength - acronymLength;
			
			text = StringUtils.replaceStringChars(start + offset, 
					end + offset, 
					text, 
					substitute);
			multipleExpansion = true;
		}
		return text;
	}

}