package csen1002.tests.task3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import csen1002.main.task3.RegToNFA;

class Task3TestsV6 {

	@Test
	@Timeout(5)
	public void testReg1() {
		RegToNFA regToNFA = new RegToNFA("10|ee||");
		assertEquals("14#12#13#2,3#0,1#1,5;3,5;4,0;4,2;5,13;6,7;7,11;8,9;9,11;10,6;10,8;11,13;12,4;12,10", regToNFA.toString());
	}
	
	@Test
	@Timeout(5)
	public void testReg2() {
		RegToNFA regToNFA = new RegToNFA("1*ee..e.");
		assertEquals("10#2#9##0,1#1,0;1,3;2,0;2,3;3,4;4,5;5,6;6,7;7,8;8,9", regToNFA.toString());
	}
	
	@Test
	@Timeout(5)
	public void testReg3() {
		RegToNFA regToNFA = new RegToNFA("1e1.**|");
		assertEquals("12#10#11##0,1;4,5#1,11;2,3;3,4;5,2;5,7;6,2;6,7;7,6;7,9;8,6;8,9;9,11;10,0;10,8", regToNFA.toString());
	}
	
	@Test
	@Timeout(5)
	public void testReg4() {
		RegToNFA regToNFA = new RegToNFA("e1*.1*|0.");
		assertEquals("14#10#13#12,13#2,3;6,7#0,1;1,4;3,2;3,5;4,2;4,5;5,11;7,6;7,9;8,6;8,9;9,11;10,0;10,8;11,12", regToNFA.toString());
	}
	
	@Test
	@Timeout(5)
	public void testReg5() {
		RegToNFA regToNFA = new RegToNFA("e1e.|e|*");
		assertEquals("14#12#13##2,3#0,1;1,7;3,4;4,5;5,7;6,0;6,2;7,11;8,9;9,11;10,6;10,8;11,10;11,13;12,10;12,13", regToNFA.toString());
	}
	
	@Test
	@Timeout(5)
	public void testReg6() {
		RegToNFA regToNFA = new RegToNFA("101|0.*|");
		assertEquals("14#12#13#2,3;8,9#0,1;4,5#1,13;3,7;5,7;6,2;6,4;7,8;9,6;9,11;10,6;10,11;11,13;12,0;12,10", regToNFA.toString());
	}
	
	@Test
	@Timeout(5)
	public void testReg7() {
		RegToNFA regToNFA = new RegToNFA("1*e*1.*.");
		assertEquals("12#2#11##0,1;8,9#1,0;1,3;2,0;2,3;3,10;4,5;5,4;5,7;6,4;6,7;7,8;9,6;9,11;10,6;10,11", regToNFA.toString());
	}
	
	@Test
	@Timeout(5)
	public void testReg8() {
		RegToNFA regToNFA = new RegToNFA("1e11|*.|");
		assertEquals("14#12#13##0,1;4,5;6,7#1,13;2,3;3,10;5,9;7,9;8,4;8,6;9,8;9,11;10,8;10,11;11,13;12,0;12,2", regToNFA.toString());
	}

	@Test
	@Timeout(5)
	public void testReg9() {
		RegToNFA regToNFA = new RegToNFA("1*ee.|");
		assertEquals("10#8#9##0,1#1,0;1,3;2,0;2,3;3,9;4,5;5,6;6,7;7,9;8,2;8,4", regToNFA.toString());
	}
	
	@Test
	@Timeout(5)
	public void testReg10() {
		RegToNFA regToNFA = new RegToNFA("1*1|**e.");
		assertEquals("14#10#13##0,1;4,5#1,0;1,3;2,0;2,3;3,7;5,7;6,2;6,4;7,6;7,9;8,6;8,9;9,8;9,11;10,8;10,11;11,12;12,13", regToNFA.toString());
	}

}