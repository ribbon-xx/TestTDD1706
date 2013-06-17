package com.qsoft.longdt;

import java.util.ArrayList;

public class RStack {

	private ArrayList<String> internalAL;

	public RStack(ArrayList<String> externalAL) {
		internalAL = externalAL;
	}

	public int size() {
		return internalAL.size();
	}

	public void push(String input) throws EmptyStringException,
			LongStringException {
		if (null == input) {
			throw new NullPointerException();
		} else if (input.isEmpty()) {
			throw new EmptyStringException();
		} else if (input.length() > 30) {
			throw new LongStringException();
		} else {
			internalAL.add(input);
		}
	}

	public String top() {
		if (internalAL.size() < 1) {
			return null;
		} else {
			return internalAL.get(internalAL.size() - 1);
		}
	}

	public String pop() throws StackEmptyException {
		if (internalAL.size() < 1) {
			throw new StackEmptyException();
		} else {
			String popStr = internalAL.get(internalAL.size() - 1);
			internalAL.remove(internalAL.size() - 1);
			return popStr;
		}
	}
}
