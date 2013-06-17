package com.qsoft.longdt;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RStackTest {

	@Test
	public void test1() {
		ArrayList<String> al = new ArrayList<String>();
		RStack rStack = new RStack(al);
		assertEquals(0, rStack.size());
	}

	@Test
	public void test2() throws EmptyStringException, LongStringException {
		ArrayList<String> al = new ArrayList<String>();
		RStack rStack = new RStack(al);
		rStack.push("num1");
		assertEquals(1, rStack.size());
	}

	@Test
	public void test3() throws EmptyStringException, LongStringException {
		RStack rStack = new RStack(new ArrayList<String>());
		for (int i = 0; i < 5; i++) {
			rStack.push("num" + i);
		}
		assertEquals(5, rStack.size());
		rStack.push("num 6");
		assertEquals(6, rStack.size());
	}

	@Test
	public void test4() {
		ArrayList<String> al = new ArrayList<String>();
		RStack rStack = new RStack(al);
		assertEquals(null, rStack.top());
	}

	@Test
	public void test5() throws EmptyStringException, LongStringException {
		ArrayList<String> al = new ArrayList<String>();
		RStack rStack = new RStack(al);
		rStack.push("num");
		assertEquals("num", rStack.top());
	}

	@Rule
	public ExpectedException ex = ExpectedException.none();

	@Test
	public void test6() throws StackEmptyException {
		ex.expect(StackEmptyException.class);
		ArrayList<String> al = new ArrayList<String>();
		RStack rStack = new RStack(al);
		rStack.pop();
	}

	@Test
	public void test7() throws StackEmptyException, EmptyStringException,
			LongStringException {
		RStack rStack = new RStack(new ArrayList<String>());
		for (int i = 0; i < 5; i++) {
			rStack.push("num" + i);
		}
		assertEquals(5, rStack.size());
		rStack.pop();
		assertEquals(4, rStack.size());
	}

	@Test
	public void test8() throws StackEmptyException {
		ArrayList<String> al = new ArrayList<String>();
		al.add("num");
		RStack rStack = new RStack(al);
		assertEquals(1, rStack.size());
		rStack.pop();
		assertEquals(0, rStack.size());
	}

	@Test
	public void test9() throws StackEmptyException, EmptyStringException,
			LongStringException {
		RStack rStack = new RStack(new ArrayList<String>());
		for (int i = 0; i < 5; i++) {
			rStack.push("num" + i);
		}
		assertEquals("num4", rStack.top());
		assertEquals("num4", rStack.pop());
	}

	@Test
	public void test10() throws StackEmptyException, EmptyStringException,
			LongStringException {
		RStack rStack = new RStack(new ArrayList<String>());
		for (int i = 0; i < 5; i++) {
			rStack.push("num" + i);
		}
		for (int i = 4; i >= 0; i--) {
			assertEquals("num" + i, rStack.pop());
		}
		assertEquals(0, rStack.size());
	}

	@Rule
	public ExpectedException ex1 = ExpectedException.none();

	@Test
	public void testPushNull() throws EmptyStringException, LongStringException {
		ex1.expect(NullPointerException.class);
		ArrayList<String> al = new ArrayList<String>();
		RStack rStack = new RStack(al);
		rStack.push(null);
	}

	@Rule
	public ExpectedException ex2 = ExpectedException.none();

	@Test
	public void testPushEmpty() throws EmptyStringException,
			LongStringException {
		ex2.expect(EmptyStringException.class);
		ArrayList<String> al = new ArrayList<String>();
		RStack rStack = new RStack(al);
		rStack.push("");
	}

	@Rule
	public ExpectedException ex3 = ExpectedException.none();

	@Test
	public void testLongStringException() throws EmptyStringException,
			LongStringException {
		ex3.expect(LongStringException.class);
		ArrayList<String> al = new ArrayList<String>();
		RStack rStack = new RStack(al);
		rStack.push("qsoftvietnamqsoftvietnamqsoftvietnamqsoftvietnamqsoftvietnamqsoftvietnamqsoftvietnamqsoftvietnamqsoftvietnamqsoftvietnamqsoftvietnam");
	}

}
