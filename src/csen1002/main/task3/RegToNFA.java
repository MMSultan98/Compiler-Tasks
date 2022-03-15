package csen1002.main.task3;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @name Mohammad Marwan Sultan
 * @id 43-3275
 * @labNumber 12
 */

public class RegToNFA {

	private class NFA {
		
		private int initialState;
		private int finalState;

		public NFA(int initialState, int finalState) {
			this.initialState = initialState;
			this.finalState = finalState;
		}
	}

	private int numberOfStates;
	private int initialState;
	private int finalState;
	private TreeMap<Integer, TreeSet<Integer>> zeroTransitions;
	private TreeMap<Integer, TreeSet<Integer>> oneTransitions;
	private TreeMap<Integer, TreeSet<Integer>> epsilonTransitions;

	/**
	 * Constructs an NFA corresponding to a regular expression based on Thompson's
	 * construction
	 * 
	 * @param regex The regular expression in postfix notation for which the NFA is
	 *              to be constructed
	 */
	public RegToNFA(String regex) {
		this.numberOfStates = 0;
		this.zeroTransitions = new TreeMap<Integer, TreeSet<Integer>>();
		this.oneTransitions = new TreeMap<Integer, TreeSet<Integer>>();
		this.epsilonTransitions = new TreeMap<Integer, TreeSet<Integer>>();

		LinkedList<NFA> stack = new LinkedList<NFA>();
		for (int i = 0; i < regex.length(); i++) {
			char c = regex.charAt(i);
			if (c == '0') {
				int initialState = numberOfStates++;
				int finalState = numberOfStates++;
				addTransition(initialState, finalState, zeroTransitions);
				stack.push(new NFA(initialState, finalState));
			}
			else if (c == '1') {
				int initialState = numberOfStates++;
				int finalState = numberOfStates++;
				addTransition(initialState, finalState, oneTransitions);
				stack.push(new NFA(initialState, finalState));
			}
			else if (c == 'e') {
				int initialState = numberOfStates++;
				int finalState = numberOfStates++;
				addTransition(initialState, finalState, epsilonTransitions);
				stack.push(new NFA(initialState, finalState));
			}
			else if (c == '*') {
				int initialState = numberOfStates++;
				int finalState = numberOfStates++;
				NFA operandNFA = stack.pop();
				addTransition(operandNFA.finalState, operandNFA.initialState, epsilonTransitions);
				addTransition(initialState, operandNFA.initialState, epsilonTransitions);
				addTransition(operandNFA.finalState, finalState, epsilonTransitions);
				addTransition(initialState, finalState, epsilonTransitions);
				stack.push(new NFA(initialState, finalState));
			}
			else if (c == '|') {
				int initialState = numberOfStates++;
				int finalState = numberOfStates++;
				NFA operandNFA2 = stack.pop();
				NFA operandNFA1 = stack.pop();
				addTransition(initialState, operandNFA1.initialState, epsilonTransitions);
				addTransition(initialState, operandNFA2.initialState, epsilonTransitions);
				addTransition(operandNFA1.finalState, finalState, epsilonTransitions);
				addTransition(operandNFA2.finalState, finalState, epsilonTransitions);
				stack.push(new NFA(initialState, finalState));
			}
			else if (c == '.') {
				NFA operandNFA2 = stack.pop();
				NFA operandNFA1 = stack.pop();
				addTransition(operandNFA1.finalState, operandNFA2.initialState, epsilonTransitions);
				stack.push(new NFA(operandNFA1.initialState, operandNFA2.finalState));
			}
		}
		NFA finalNFA = stack.pop();
		this.initialState = finalNFA.initialState;
		this.finalState = finalNFA.finalState;
	}

	/**
	 * @return Returns a formatted string representation of the NFA. The string
	 *         representation follows the one in the task description
	 */
	@Override
	public String toString() {
		String result = "";
		result += this.numberOfStates + "#";
		result += this.initialState + "#";
		result += this.finalState + "#";
		result += transitionsToString(this.zeroTransitions) + "#";
		result += transitionsToString(this.oneTransitions) + "#";
		result += transitionsToString(this.epsilonTransitions);
		return result;
	}

	private static void addTransition(int initialState, int finalState, TreeMap<Integer, TreeSet<Integer>> transitions) {
		TreeSet<Integer> set = transitions.get(initialState);
		if (set == null) {
			set = new TreeSet<Integer>();
			transitions.put(initialState, set);
		}
		set.add(finalState);
	}

	private static String transitionsToString(TreeMap<Integer, TreeSet<Integer>> transitions) {
		String transitionsString = "";
		for (Map.Entry<Integer, TreeSet<Integer>> entry : transitions.entrySet()) {
			int i = entry.getKey();
			for (Integer j : entry.getValue()) {
				transitionsString += i + "," + j + ";";
			}
		}
		return transitionsString == "" ? "" : transitionsString.substring(0, transitionsString.length()-1);
	}

}
