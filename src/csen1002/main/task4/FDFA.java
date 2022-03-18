package csen1002.main.task4;

import java.util.LinkedList;

/**
 * @name Mohammad Marwan Sultan
 * @id 43-3275
 * @labNumber 12
 */

public class FDFA {

	private class FDFAState {
		private int stateZero;
		private int stateOne;
		private String action;
		private boolean isAcceptState;

		public FDFAState(int stateZero, int stateOne, String action) {
			this.stateZero = stateZero;
			this.stateOne = stateOne;
			this.action = action;
			this.isAcceptState = false;
		}

		public int getNextState(char c) {
			return c == '0' ? stateZero : stateOne;
		}
	}

	private FDFAState[] states;

	/**
	 * FDFA constructor
	 * 
	 * @param description is the string describing a FDFA
	 */
	public FDFA(String description) {
		String[] splitDescription = description.split("#");
		String[] p = splitDescription[0].split(";");
		String[] s = splitDescription.length > 1 ? splitDescription[1].split(",") : new String[0];

		this.states = new FDFAState[p.length];
		for (String stateInfo : p) {
			String[] splitStateInfo = stateInfo.split(",");
			int state = Integer.parseInt(splitStateInfo[0]);
			int stateZero = Integer.parseInt(splitStateInfo[1]);
			int stateOne = Integer.parseInt(splitStateInfo[2]);
			String action = splitStateInfo[3];
			this.states[state] = new FDFAState(stateZero, stateOne, action);
		}

		for (String acceptState : s) {
			int state = Integer.parseInt(acceptState);
			this.states[state].isAcceptState = true;	
		}
	}

	/**
	 * Returns a string of actions.
	 * 
	 * @param input is the string to simulate by the FDFA.
	 * @return string of actions.
	 */
	public String run(String input) {
		return runHelper(input);
	}

	private String runHelper(String input) {
		LinkedList<FDFAState> stack = new LinkedList<FDFAState>();
		
		FDFAState currentState = this.states[0];
		stack.push(currentState);
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			currentState = this.states[currentState.getNextState(c)];
			stack.push(currentState);
		}

		if (currentState.isAcceptState) {
			return input + "," + currentState.action + ";";
		}

		int i = 0;
		int j = input.length();
		FDFAState finalState = currentState;
		currentState = stack.pop();
		while (!stack.isEmpty()) {
			currentState = stack.pop();
			j--;
			if (currentState.isAcceptState) {
				String result = input.substring(i, j) + "," + currentState.action + ";";
				return result + runHelper(input.substring(j));
			}
		}

		return input + "," + finalState.action + ";";
	}

}
