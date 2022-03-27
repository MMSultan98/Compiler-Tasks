package csen1002.main.task5;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @name Mohammad Marwan Sultan
 * @id 43-3275
 * @labNumber 12
 */

public class CFG {

	private ArrayList<Character> variables;
	private ArrayList<LinkedList<String>> rules;

	/**
	 * CFG constructor
	 * 
	 * @param description is the string describing a CFG
	 */
	public CFG(String description) {
		String[] splitDescription = description.split(";");
		this.variables = new ArrayList<Character>(splitDescription.length);
		this.rules = new ArrayList<LinkedList<String>>(splitDescription.length);
		
		for (String ruleInfo : splitDescription) {
			String[] splitRuleInfo = ruleInfo.split(",");
			char v = splitRuleInfo[0].charAt(0);
			LinkedList<String> vRules = new LinkedList<String>();
			for (int i = 1; i < splitRuleInfo.length; i++) {
				vRules.add(splitRuleInfo[i]);
			}
			this.variables.add(v);
			this.rules.add(vRules);
		}
	}

	/**
	 * Returns a string of elimnated left recursion.
	 * 
	 * @param input is the string to simulate by the CFG.
	 * @return string of elimnated left recursion.
	 */
	public String lre() {
		ArrayList<LinkedList<String>> rules = cloneRules(this.rules);
		ArrayList<LinkedList<String>> newRules = new ArrayList<LinkedList<String>>(rules.size());

		for (int i = 0; i < this.variables.size(); i++) {
			char v = this.variables.get(i);
			for (int j = 0; j < i; j++) {
				char v2 = this.variables.get(j);
				LinkedList<String> modifiedRules = replaceRules(v, v2, rules.get(i), rules.get(j));
				rules.set(i, modifiedRules);
			}
			ArrayList<LinkedList<String>> dlreResult = dlre(v, rules.get(i));
			if (dlreResult.get(1).size() > 1) {
				rules.set(i, dlreResult.get(0));
			}
			newRules.add(dlreResult.get(1));
		}

		String result = "";
		for (int i = 0; i < this.variables.size(); i++) {
			char v = this.variables.get(i);
			result += rulesToString(v + "", rules.get(i));
			if (newRules.get(i).size() > 1) {
				result += rulesToString(v + "'", newRules.get(i));
			}
		}
		return result.substring(0, result.length() - 1);
	}

	private static ArrayList<LinkedList<String>> cloneRules(ArrayList<LinkedList<String>> rules) {
		ArrayList<LinkedList<String>> clonedRules = new ArrayList<LinkedList<String>>();
		for (LinkedList<String> linkedList : rules) {
			clonedRules.add(new LinkedList<String>(linkedList));
		}
		return clonedRules;
	}

	private static LinkedList<String> replaceRules(char v, char v2, LinkedList<String> vRules, LinkedList<String> v2Rules) {
		LinkedList<String> modifiedRules = new LinkedList<String>();
		for (String vRule : vRules) {
			if (vRule.charAt(0) == v2) {
				for (String v2Rule : v2Rules) {
					modifiedRules.add(v2Rule + vRule.substring(1));
				}
			}
			else {
				modifiedRules.add(vRule);
			}
		}
		return modifiedRules;
	}

	private static ArrayList<LinkedList<String>> dlre(char v, LinkedList<String> rules) {
		ArrayList<LinkedList<String>> newRules = new ArrayList<LinkedList<String>>(2);
		newRules.add(new LinkedList<String>());
		newRules.add(new LinkedList<String>());
		
		LinkedList<String> alphas = new LinkedList<String>();
		LinkedList<String> betas = new LinkedList<String>();
		for (String rule : rules) {
			if (rule.charAt(0) == v) {
				alphas.add(rule.substring(1));
			}
			else {
				betas.add(rule);
			}
		}
		for (String b : betas) {
			newRules.get(0).add(b + v + "'");
		}
		for (String a : alphas) {
			newRules.get(1).add(a + v + "'");
		}
		newRules.get(1).add("e");

		return newRules;
	}

	private static String rulesToString(String v, LinkedList<String> rules) {
		String result = v;
		for (String rule : rules) {
			result += "," + rule;
		}
		result += ";";
		return result;
	}

}
