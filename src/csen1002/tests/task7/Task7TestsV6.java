package csen1002.tests.task7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import csen1002.main.task7.LL1CFG;

@Timeout(5)
public class Task7TestsV6 {
	@Test
	public void testLL1CFG1Parse1() {
		LL1CFG ll1cfg1 = new LL1CFG("S,zSvX,vL,tS;L,nMn,tSnXX;X,zLSn,hXn;M,vSSh,tLhM,e#S,z,v,t;L,n,t;X,z,h;M,v,t,e#S,hntvz$;L,hntvz$;X,hntvz$;M,n");
		assertEquals("S,vL,vnMn,vnn", ll1cfg1.parse("vnn"));
	}

	@Test
	public void testLL1CFG1Parse2() {
		LL1CFG ll1cfg1 = new LL1CFG("S,zSvX,vL,tS;L,nMn,tSnXX;X,zLSn,hXn;M,vSSh,tLhM,e#S,z,v,t;L,n,t;X,z,h;M,v,t,e#S,hntvz$;L,hntvz$;X,hntvz$;M,n");
		assertEquals("S,tS,ttS,ttvL,ttvnMn,ttvnn", ll1cfg1.parse("ttvnn"));
	}

	@Test
	public void testLL1CFG1Parse3() {
		LL1CFG ll1cfg1 = new LL1CFG("S,zSvX,vL,tS;L,nMn,tSnXX;X,zLSn,hXn;M,vSSh,tLhM,e#S,z,v,t;L,n,t;X,z,h;M,v,t,e#S,hntvz$;L,hntvz$;X,hntvz$;M,n");
		assertEquals("S,tS,ttS,tttS,ttttS,tttttS,ttttttS,ttttttvL,ttttttvnMn,ttttttvnn", ll1cfg1.parse("ttttttvnn"));
	}

	@Test
	public void testLL1CFG1Parse4() {
		LL1CFG ll1cfg1 = new LL1CFG("S,zSvX,vL,tS;L,nMn,tSnXX;X,zLSn,hXn;M,vSSh,tLhM,e#S,z,v,t;L,n,t;X,z,h;M,v,t,e#S,hntvz$;L,hntvz$;X,hntvz$;M,n");
		assertEquals("S,zSvX,zzSvXvX,zzzSvXvXvX,ERROR", ll1cfg1.parse("zzz"));
	}

	@Test
	public void testLL1CFG1Parse5() {
		LL1CFG ll1cfg1 = new LL1CFG("S,zSvX,vL,tS;L,nMn,tSnXX;X,zLSn,hXn;M,vSSh,tLhM,e#S,z,v,t;L,n,t;X,z,h;M,v,t,e#S,hntvz$;L,hntvz$;X,hntvz$;M,n");
		assertEquals("S,zSvX,zvLvX,zvnMnvX,ERROR", ll1cfg1.parse("zvn"));
	}

	@Test
	public void testLL1CFG2Parse1() {
		LL1CFG ll1cfg2 = new LL1CFG("S,jLz,yNXy,gSy;N,SgLg,zXoN;X,ySjSj,xSoN;L,xNjNj,oNzN,yXNz,e#S,j,y,g;N,gjy,z;X,y,x;L,x,o,y,e#S,gjoy$;N,gjoxyz;X,gjoyz;L,gz");
		assertEquals("S,gSy,gjLzy,gjzy", ll1cfg2.parse("gjzy"));
	}

	@Test
	public void testLL1CFG2Parse2() {
		LL1CFG ll1cfg2 = new LL1CFG("S,jLz,yNXy,gSy;N,SgLg,zXoN;X,ySjSj,xSoN;L,xNjNj,oNzN,yXNz,e#S,j,y,g;N,gjy,z;X,y,x;L,x,o,y,e#S,gjoy$;N,gjoxyz;X,gjoyz;L,gz");
		assertEquals("S,gSy,ggSyy,gggSyyy,gggjLzyyy,gggjzyyy", ll1cfg2.parse("gggjzyyy"));
	}

	@Test
	public void testLL1CFG2Parse3() {
		LL1CFG ll1cfg2 = new LL1CFG("S,jLz,yNXy,gSy;N,SgLg,zXoN;X,ySjSj,xSoN;L,xNjNj,oNzN,yXNz,e#S,j,y,g;N,gjy,z;X,y,x;L,x,o,y,e#S,gjoy$;N,gjoxyz;X,gjoyz;L,gz");
		assertEquals("S,jLz,jz", ll1cfg2.parse("jz"));
	}

	@Test
	public void testLL1CFG2Parse4() {
		LL1CFG ll1cfg2 = new LL1CFG("S,jLz,yNXy,gSy;N,SgLg,zXoN;X,ySjSj,xSoN;L,xNjNj,oNzN,yXNz,e#S,j,y,g;N,gjy,z;X,y,x;L,x,o,y,e#S,gjoy$;N,gjoxyz;X,gjoyz;L,gz");
		assertEquals("S,yNXy,ySgLgXy,ygSygLgXy,ERROR", ll1cfg2.parse("yg"));
	}

	@Test
	public void testLL1CFG2Parse5() {
		LL1CFG ll1cfg2 = new LL1CFG("S,jLz,yNXy,gSy;N,SgLg,zXoN;X,ySjSj,xSoN;L,xNjNj,oNzN,yXNz,e#S,j,y,g;N,gjy,z;X,y,x;L,x,o,y,e#S,gjoy$;N,gjoxyz;X,gjoyz;L,gz");
		assertEquals("S,jLz,jxNjNjz,jxSgLgjNjz,jxjLzgLgjNjz,ERROR", ll1cfg2.parse("jxj"));
	}

}