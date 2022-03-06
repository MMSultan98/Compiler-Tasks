package csen1002.main.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Write your info here
 * 
 * @name Mohammad Marwan Sultan
 * @id 43-3275
 * @labNumber 12
 */
public class NFA {

	private class DFAState {

		private HashSet<Integer> nfaStates;
		private DFAState stateZero;
		private DFAState stateOne;

		public DFAState() {
			this.nfaStates = new HashSet<Integer>();
			this.stateZero = this;
			this.stateOne = this;
		}

		public DFAState(HashSet<Integer> nfaStates) {
			this.nfaStates = nfaStates;
		}

		public DFAState getNextState(char c) {
			return c == '0' ? stateZero : stateOne;
		}
	}

	private ArrayList<DFAState> states;
	private HashSet<Integer> acceptStates;

	/**
	 * NFA constructor
	 * 
	 * @param description is the string describing a NFA
	 */
	public NFA(String description) {
		String[] splitDescription = description.split("#");

		String[] z = splitDescription[0].split(";");
		String[] o = splitDescription[1].split(";");
		String[] e = splitDescription[2].split(";");

		HashMap<Integer, HashSet<Integer>> zeroTransitions = new HashMap<Integer, HashSet<Integer>>();
		HashMap<Integer, HashSet<Integer>> oneTransitions = new HashMap<Integer, HashSet<Integer>>();
		HashMap<Integer, HashSet<Integer>> epsilonTransitions = new HashMap<Integer, HashSet<Integer>>();

		for (String transition : z) {
			String[] splitTransition =  transition.split(",");
			int i = Integer.parseInt(splitTransition[0]);
			int j = Integer.parseInt(splitTransition[1]);
			HashSet<Integer> s = zeroTransitions.get(i) == null ? new HashSet<Integer>() : zeroTransitions.get(i);
			s.add(j);
			zeroTransitions.put(i, s);
		}
		for (String transition : o) {
			String[] splitTransition =  transition.split(",");
			int i = Integer.parseInt(splitTransition[0]);
			int j = Integer.parseInt(splitTransition[1]);
			HashSet<Integer> s = oneTransitions.get(i) == null ? new HashSet<Integer>() : oneTransitions.get(i);
			s.add(j);
			oneTransitions.put(i, s);
		}
		for (String transition : e) {
			String[] splitTransition =  transition.split(",");
			int i = Integer.parseInt(splitTransition[0]);
			int j = Integer.parseInt(splitTransition[1]);
			HashSet<Integer> s = epsilonTransitions.get(i) == null ? new HashSet<Integer>() : epsilonTransitions.get(i);
			s.add(j);
			epsilonTransitions.put(i, s);
		}

		DFAState initialState = new DFAState(getEpsilonClosure(new HashSet<Integer>(Arrays.asList(0)), epsilonTransitions));
		DFAState deadState = new DFAState();
		this.states = new ArrayList<DFAState>();
		this.states.add(initialState);
		this.states.add(deadState);

		while (!this.transitionsCompleted()) {
			DFAState state = getUnfinishedState();
			HashSet<Integer> zeroNFAStates = getNextNFAStates(state.nfaStates, zeroTransitions, epsilonTransitions);
			DFAState stateZero = getState(zeroNFAStates);
			if (stateZero == null) {
				stateZero = new DFAState(zeroNFAStates);
				this.states.add(stateZero);
			}
			state.stateZero = stateZero;
			HashSet<Integer> oneNFAStates = getNextNFAStates(state.nfaStates, oneTransitions, epsilonTransitions);
			DFAState stateOne = getState(oneNFAStates);
			if (stateOne == null) {
				stateOne = new DFAState(oneNFAStates);
				this.states.add(stateOne);
			}
			state.stateOne = stateOne;
		}

		String[] f = splitDescription.length > 3 ? splitDescription[3].split(",") : new String[0];
		this.acceptStates = new HashSet<Integer>();
		for (String state : f) {
			this.acceptStates.add(Integer.parseInt(state));
		}
	}

	private boolean transitionsCompleted() {
		for (DFAState state : this.states) {
			if (state.stateOne == null || state.stateZero == null)
				return false;
		}
		return true;
	}

	private DFAState getUnfinishedState() {
		for (DFAState state : this.states) {
			if (state.stateOne == null || state.stateZero == null)
				return state;
		}
		return null;
	}

	private DFAState getState(HashSet<Integer> nfaStates) {
		for (DFAState state : this.states) {
			if (state.nfaStates.size() == nfaStates.size() && state.nfaStates.containsAll(nfaStates))
				return state;
		}
		return null;
	}

	/**
	 * Returns true if the string is accepted by the NFA and false otherwise.
	 * 
	 * @param input is the string to check by the NFA.
	 * @return if the string is accepted or not.
	 */
	public boolean run(String input) {
		DFAState currentState = states.get(0);
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			currentState = currentState.getNextState(c);
		}
		return !Collections.disjoint(currentState.nfaStates, acceptStates);
	}

	private static HashSet<Integer> getEpsilonClosure(HashSet<Integer> set, HashMap<Integer, HashSet<Integer>> epsilonTransitions) {
		HashSet<Integer> epsilonClosure = new HashSet<Integer>(set);
		int oldLength = -1;
		int newLength = epsilonClosure.size();

		while (oldLength != newLength) {
			HashSet<Integer> updatedEpsilonClosure = new HashSet<Integer>(epsilonClosure);
			for (Integer i : epsilonClosure) {
				HashSet<Integer> transitions = epsilonTransitions.get(i) == null ? new HashSet<Integer>() : epsilonTransitions.get(i);
				updatedEpsilonClosure.addAll(transitions);
			}
			epsilonClosure = updatedEpsilonClosure;
			oldLength = newLength;
			newLength = epsilonClosure.size();
		}
		
		return epsilonClosure;
	}

	private static HashSet<Integer> getNextNFAStates(HashSet<Integer> nfaStates, HashMap<Integer, HashSet<Integer>> transitions, HashMap<Integer, HashSet<Integer>> epsilonTransitions) {
		HashSet<Integer> nextNFAStates = new HashSet<Integer>();
		for (Integer state : nfaStates) {
			HashSet<Integer> set = transitions.get(state) == null ? new HashSet<Integer>() : transitions.get(state);
			nextNFAStates.addAll(getEpsilonClosure(set, epsilonTransitions));
		}
		return nextNFAStates;
	}
	
}
