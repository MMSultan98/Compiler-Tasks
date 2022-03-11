package csen1002.main.task1;

/**
 * @name Mohammad Marwan Sultan
 * @id 43-3275
 * @labNumber 12
 */

public class DFA {
	
	private class DFAState {
		private int stateZero;
		private int stateOne;
		private boolean isAcceptState;

		public DFAState(int stateZero, int stateOne) {
			this.stateZero = stateZero;
			this.stateOne = stateOne;
			this.isAcceptState = false;
		}

		public int getNextState(char c) {
			return c == '0' ? stateZero : stateOne;
		}

		public void setAcceptState(boolean isAcceptState) {
			this.isAcceptState = isAcceptState;
		}

		public boolean isAcceptState() {
			return isAcceptState;
		}
	}

	private DFAState[] states;

	/**
	 * DFA constructor
	 * 
	 * @param description is the string describing a DFA
	 */
	public DFA(String description) {
		String[] splitDescription = description.split("#");
		
		String[] p = splitDescription[0].split(";");
		this.states = new DFAState[p.length];
		for (String stateInfo : p) {
			String[] splitStateInfo = stateInfo.split(",");
			int state = Integer.parseInt(splitStateInfo[0]);
			int stateZero = Integer.parseInt(splitStateInfo[1]);
			int stateOne = Integer.parseInt(splitStateInfo[2]);
			this.states[state] = new DFAState(stateZero, stateOne);
		}

		String[] s = splitDescription.length > 1 ? splitDescription[1].split(",") : new String[0];
		for (String acceptState : s) {
			int state = Integer.parseInt(acceptState);
			this.states[state].setAcceptState(true);	
		}
	}

	/**
	 * Returns true if the string is accepted by the DFA and false otherwise.
	 * 
	 * @param input is the string to check by the DFA.
	 * @return if the string is accepted or not.
	 */
	public boolean run(String input) {
		DFAState currentState = this.states[0];
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			currentState = this.states[currentState.getNextState(c)];
		}
		return currentState.isAcceptState();
	}

}
