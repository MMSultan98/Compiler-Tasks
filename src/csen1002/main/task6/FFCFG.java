package csen1002.main.task6;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;

/**
 * @name Mohammad Marwan Sultan
 * @id 43-3275
 * @labNumber 12
 */

public class FFCFG {

	public LinkedHashMap<Character, LinkedList<String>> variablesRules;
	public LinkedHashMap<Character, TreeSet<Character>> first;
	public LinkedHashMap<Character, TreeSet<Character>> follow;
	
	/**
	 * Constructs a CFG for which the First and Follow are to be computed
	 * 
	 * @param description A string representation of a CFG as specified in the task
	 *                    description
	 */
	public FFCFG(String description) {
		String[] splitDescription = description.split(";");
		this.variablesRules = new LinkedHashMap<Character, LinkedList<String>>();
		
		for (String ruleInfo : splitDescription) {
			String[] splitRuleInfo = ruleInfo.split(",");
			char v = splitRuleInfo[0].charAt(0);
			LinkedList<String> vRules = new LinkedList<String>();
			for (int i = 1; i < splitRuleInfo.length; i++) {
				vRules.add(splitRuleInfo[i]);
			}
			this.variablesRules.put(v, vRules);
		}
	}

	/**
	 * Calculates the First of each variable in the CFG.
	 * 
	 * @return A string representation of the First of each variable in the CFG,
	 *         formatted as specified in the task description.
	 */
	public String first() {
		LinkedHashMap<Character, TreeSet<Character>> first = new LinkedHashMap<Character, TreeSet<Character>>();
		for (char variable : this.variablesRules.keySet()) {
			first.put(variable, new TreeSet<Character>());
		}
		
		boolean change = true;
		while (change) {
			change = false;
			for (Map.Entry<Character, LinkedList<String>> entry : this.variablesRules.entrySet()) {
				char variable = entry.getKey();
				LinkedList<String> vRules = entry.getValue();
				for (String rule : vRules) {
					if (epsilonInFirst(rule, first)) {
						if (first.get(variable).add('e')) {
							change = true;
						}
					}
					for (int i = 0; i < rule.length(); i++) {
						if (epsilonInFirst(rule.substring(0, i), first)) {
							char c = rule.charAt(i);
							TreeSet<Character> firstOfC = getFirstOfChar(c, first);
							firstOfC.remove('e');
							if (first.get(variable).addAll(firstOfC)) {
								change = true;
							}
						}
					}
				}
			}
		}

		this.first = first;
		return mapToString(first);
	}

	/**
	 * Calculates the Follow of each variable in the CFG.
	 * 
	 * @return A string representation of the Follow of each variable in the CFG,
	 *         formatted as specified in the task description.
	 */
	public String follow() {
		this.first();
		LinkedHashMap<Character, TreeSet<Character>> follow = new LinkedHashMap<Character, TreeSet<Character>>();
		for (char variable : this.variablesRules.keySet()) {
			follow.put(variable, new TreeSet<Character>());
		}
		follow.get('S').add('$');
		
		boolean change = true;
		while (change) {
			change = false;
			for (Map.Entry<Character, LinkedList<String>> entry : this.variablesRules.entrySet()) {
				char variable = entry.getKey();
				LinkedList<String> vRules = entry.getValue();
				for (String rule : vRules) {
					for (int i = 0; i < rule.length(); i++) {
						char c = rule.charAt(i);
						if (isVariable(c)) {
							String beta = rule.substring(i+1);
							char B = c;
							TreeSet<Character> firstOfBeta = getFirstOfString(beta, this.first);
							boolean epsilonInFirstOfBeta = firstOfBeta.remove('e');
							if (follow.get(B).addAll(firstOfBeta)) {
								change = true;
							}
							if (epsilonInFirstOfBeta) {
								if (follow.get(B).addAll(follow.get(variable))) {
									change = true;
								}
							}
						}
					}
				}
			}
		}

		this.follow = follow;
		return mapToString(follow);
	}

	private static boolean isTerminal(char c) {
		return c != 'e' && c >= 'a' && c <= 'z';
	}

	private static boolean isVariable(char c) {
		return c >= 'A' && c <= 'Z';
	}

	private static boolean epsilonInFirst(String s, LinkedHashMap<Character, TreeSet<Character>> first) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (isTerminal(c)) {
				return false;
			}
			else if (isVariable(c)) {
				if (!first.get(c).contains('e')) {
					return false;
				}
			}
		}
		return true;
	}

	private static TreeSet<Character> getFirstOfChar(char c, LinkedHashMap<Character, TreeSet<Character>> first) {
		TreeSet<Character> firstOfC = new TreeSet<Character>();
		if (isTerminal(c)) {
			firstOfC.add(c);
		}
		else if (isVariable(c)) {
			firstOfC.addAll(first.get(c));
		}
		else if (c == 'e') {
			firstOfC.add('e');
		}
		return firstOfC;
	}

	private static TreeSet<Character> getFirstOfString(String s, LinkedHashMap<Character, TreeSet<Character>> first) {
		TreeSet<Character> firstOfS = new TreeSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			firstOfS.addAll(getFirstOfChar(c, first));
			firstOfS.remove('e');
			if (!epsilonInFirst(s.substring(0, i+1), first)) {
				break;
			}
		}
		if (epsilonInFirst(s, first)) {
			firstOfS.add('e');
		}
		return firstOfS;
	}

	private static String mapToString(LinkedHashMap<Character, TreeSet<Character>> map) {
		String result = "";
		for (Map.Entry<Character, TreeSet<Character>> entry : map.entrySet()) {
			char variable = entry.getKey();
			TreeSet<Character> set = entry.getValue();
			result += variable + ",";
			boolean dollarSign = false;
			for (char c : set) {
				if (c == '$') {
					dollarSign = true;
					continue;
				}
				result += c;
			}
			if (dollarSign) {
				result += '$';
			}
			result += ";";
		}
		return result.substring(0, result.length()-1);
	}

}
