package csen1002.main.task7;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @name Mohammad Marwan Sultan
 * @id 43-3275
 * @labNumber 12
 */

public class LL1CFG {

	private LinkedHashMap<Character, LinkedList<String>> grammarRules;
	private LinkedHashMap<Character, TreeSet<Character>> first;
	private LinkedHashMap<Character, TreeSet<Character>> follow;
	private LinkedHashMap<Character, TreeMap<Character, String>> parsingTable;

	/**
	 * LL1 CFG constructor
	 * 
	 * @param description is the string describing an LL(1) CFG, first, and follow as represented in the task description.
	 */
	public LL1CFG(String description) {
		String[] splitDescription = description.split("#");
		
		String[] splitGrammarDescription = splitDescription[0].split(";");
		this.grammarRules = new LinkedHashMap<Character, LinkedList<String>>();
		for (String ruleInfo : splitGrammarDescription) {
			String[] splitRuleInfo = ruleInfo.split(",");
			char v = splitRuleInfo[0].charAt(0);
			LinkedList<String> vRules = new LinkedList<String>();
			for (int i = 1; i < splitRuleInfo.length; i++) {
				vRules.add(splitRuleInfo[i]);
			}
			this.grammarRules.put(v, vRules);
		}

		String[] splitFirstDescription =  splitDescription[1].split(";");
		this.first = new LinkedHashMap<Character, TreeSet<Character>>();
		for (String variableInfo : splitFirstDescription) {
			String[] splitVariableInfo = variableInfo.split(",");
			char v = splitVariableInfo[0].charAt(0);
			TreeSet<Character> vFirstSet = new TreeSet<Character>();
			for (int i = 1; i < splitVariableInfo.length; i++) {
				String ruleFirst = splitVariableInfo[i];
				for (int j = 0; j < ruleFirst.length(); j++) {
					vFirstSet.add(ruleFirst.charAt(j));
				}
			}
			this.first.put(v, vFirstSet);
		}
		
		String[] splitFollowDescription =  splitDescription[2].split(";");
		this.follow = new LinkedHashMap<Character, TreeSet<Character>>();
		for (String variableInfo : splitFollowDescription) {
			String[] splitVariableInfo = variableInfo.split(",");
			char v = splitVariableInfo[0].charAt(0);
			String vFollow = splitVariableInfo[1];
			TreeSet<Character> vFollowSet = new TreeSet<Character>();
			for (int i = 0; i < vFollow.length(); i++) {
				vFollowSet.add(vFollow.charAt(i));
			}
			this.follow.put(v, vFollowSet);
		}

		this.parsingTable = new LinkedHashMap<Character, TreeMap<Character, String>>();
		for (Map.Entry<Character, LinkedList<String>> entry : this.grammarRules.entrySet()) {
			char v = entry.getKey();
			LinkedList<String> vRules = entry.getValue();
			TreeMap<Character, String> variableRow = new TreeMap<Character, String>();
			for (String rule : vRules) {
				TreeSet<Character> ruleFirst = getFirstOfString(rule, this.first);
				TreeSet<Character> vFollow = this.follow.get(v);
				TreeSet<Character> ruleTerminals = new TreeSet<Character>();
				if (ruleFirst.remove('e')) {
					ruleTerminals.addAll(vFollow);
				}
				ruleTerminals.addAll(ruleFirst);
				for (Character terminal : ruleTerminals) {
					variableRow.put(terminal, rule);
				}
			}
			parsingTable.put(v, variableRow);
		}
	}
	
	/**
	 * Returns A string encoding a derivation is a comma-separated sequence of sentential forms each representing a step in the derivation..
	 * 
	 * @param input is the string to be parsed by the LL(1) CFG.
	 * @return returns a string encoding a left-most derivation.
	 */
	public String parse(String input) {
		String tape = input + "$";
		String derivation = "S,";
		LinkedList<Character> stack = new LinkedList<Character>();
		stack.push('$');
		stack.push('S');
		int i = 0;
		String currentStep = "S";
		
		while (i < tape.length()) {
			char head = tape.charAt(i);
			char top = stack.peek();
			if (isVariable(top)) {
				String rule = this.parsingTable.get(top).get(head);
				if (rule == null) {
					break;
				}
				stack.pop();
				rule = rule.replace("e", "");
				for (int j = rule.length()-1; j >= 0; j--) {
					stack.push(rule.charAt(j));
				}
				currentStep = replaceFirstVariable(currentStep, rule);
				derivation += currentStep + ",";
			}
			else {
				if (head != top) {
					break;
				}
				stack.pop();
				i++;
			}
		}
		
		if (stack.isEmpty() && i == tape.length()) {
			derivation = derivation.substring(0, derivation.length()-1);
		}
		else {
			derivation += "ERROR";
		}
		return derivation;
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

	private String replaceFirstVariable(String sent, String rule) {
		String result = "";
		for (int i = 0; i < sent.length(); i++) {
			char c = sent.charAt(i);
			if (isVariable(c)) {
				result += rule;
				result += sent.substring(i+1);
				break;
			}
			result += c;
		}
		return result;
	}

}
