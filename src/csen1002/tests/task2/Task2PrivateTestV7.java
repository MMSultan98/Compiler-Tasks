package csen1002.tests.task2;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import csen1002.main.task2.NFA;

public class Task2PrivateTestV7 {
	
	//////////1st NFA Strings Validation///////////////
	@Test 
	@Timeout(5)
	public void testNFA1T1() {
		NFA NFA1 = new NFA("3,4#6,7;8,9;13,14#0,1;0,12;1,2;1,6;2,3;2,5;4,3;4,5;5,11;7,8;7,10;9,8;9,10;10,11;11,1;11,12;12,13;12,15;14,13;14,15#15");
		assertTrue(NFA1.run("01101"));
	}
	@Test
	@Timeout(5)
	public void testNFA1T2() {
		NFA NFA1 = new NFA("3,4#6,7;8,9;13,14#0,1;0,12;1,2;1,6;2,3;2,5;4,3;4,5;5,11;7,8;7,10;9,8;9,10;10,11;11,1;11,12;12,13;12,15;14,13;14,15#15");
		assertTrue(NFA1.run("111000"));
	}
	@Test
	@Timeout(5)
	public void testNFA1T3() {
		NFA NFA1 = new NFA("3,4#6,7;8,9;13,14#0,1;0,12;1,2;1,6;2,3;2,5;4,3;4,5;5,11;7,8;7,10;9,8;9,10;10,11;11,1;11,12;12,13;12,15;14,13;14,15#15");
		assertTrue(NFA1.run("000000"));
	}
	@Test
	@Timeout(5)
	public void testNFA1T4() {
		NFA NFA1 = new NFA("3,4#6,7;8,9;13,14#0,1;0,12;1,2;1,6;2,3;2,5;4,3;4,5;5,11;7,8;7,10;9,8;9,10;10,11;11,1;11,12;12,13;12,15;14,13;14,15#15");
		assertTrue(NFA1.run("0001111000"));
	}
	@Test
	@Timeout(5)
	public void testNFA1T5() {
		NFA NFA1 = new NFA("3,4#6,7;8,9;13,14#0,1;0,12;1,2;1,6;2,3;2,5;4,3;4,5;5,11;7,8;7,10;9,8;9,10;10,11;11,1;11,12;12,13;12,15;14,13;14,15#15");
		assertTrue(NFA1.run("1100"));
	}
	//////////2nd NFA Strings Validation///////////////
	@Test
	@Timeout(5)
	public void testNFA2T1() {
		NFA NFA2 = new NFA("4,5;9,10#2,3#0,1;0,13;1,2;1,9;3,4;3,6;5,8;6,7;7,8;8,12;11,12;12,1;12,13;13,14;13,16;14,15;15,18;16,17;17,18#18");
		assertTrue(NFA2.run("1"));
	}
	@Test
	@Timeout(5)
	public void testNFA2T2() {
		NFA NFA2 = new NFA("4,5;9,10#2,3#0,1;0,13;1,2;1,9;3,4;3,6;5,8;6,7;7,8;8,12;11,12;12,1;12,13;13,14;13,16;14,15;15,18;16,17;17,18#18");
		assertFalse(NFA2.run("010"));
	}
	@Test
	@Timeout(5)
	public void testNFA2T3() {
		NFA NFA2 = new NFA("4,5;9,10#2,3#0,1;0,13;1,2;1,9;3,4;3,6;5,8;6,7;7,8;8,12;11,12;12,1;12,13;13,14;13,16;14,15;15,18;16,17;17,18#18");
		assertFalse(NFA2.run("01100"));
	}
	@Test
	@Timeout(5)
	public void testNFA2T4() {
		NFA NFA2 = new NFA("4,5;9,10#2,3#0,1;0,13;1,2;1,9;3,4;3,6;5,8;6,7;7,8;8,12;11,12;12,1;12,13;13,14;13,16;14,15;15,18;16,17;17,18#18");
		assertFalse(NFA2.run("010110100"));
	}
	@Test
	@Timeout(5)
	public void testNFA2T5() {
		NFA NFA2 = new NFA("4,5;9,10#2,3#0,1;0,13;1,2;1,9;3,4;3,6;5,8;6,7;7,8;8,12;11,12;12,1;12,13;13,14;13,16;14,15;15,18;16,17;17,18#18");
		assertFalse(NFA2.run("000101010"));
	}

}
