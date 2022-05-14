package csen1002.tests.task7;

import csen1002.main.task7.LL1CFG;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LL1_MoreTests {
    //s21 public 1
    @Test
    @Timeout(5)
    public void testParser_1_1() {
        LL1CFG l = new LL1CFG("S,zToS,n,e;T,zTo,No;N,n,e#S,z,n,e;T,z,no;N,n,e#S,$;T,o;N,o");
        String input = "zzznoooon";
        String expected_output = "S,zToS,zzTooS,zzzToooS,zzzNooooS,zzznooooS,zzznoooon";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_1_2() {
        LL1CFG l = new LL1CFG("S,zToS,n,e;T,zTo,No;N,n,e#S,z,n,e;T,z,no;N,n,e#S,$;T,o;N,o");
        String input = "zzooo";
        String expected_output = "S,zToS,zzTooS,zzNoooS,zzoooS,zzooo";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_1_3() {
        LL1CFG l = new LL1CFG("S,zToS,n,e;T,zTo,No;N,n,e#S,z,n,e;T,z,no;N,n,e#S,$;T,o;N,o");
        String input = "zoozznooo";
        String expected_output = "S,zToS,zNooS,zooS,zoozToS,zoozzTooS,zoozzNoooS,zoozznoooS,zoozznooo";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_1_4() {
        LL1CFG l = new LL1CFG("S,zToS,n,e;T,zTo,No;N,n,e#S,z,n,e;T,z,no;N,n,e#S,$;T,o;N,o");
        String input = "zooznoon";
        String expected_output = "S,zToS,zNooS,zooS,zoozToS,zoozNooS,zooznooS,zooznoon";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_1_5() {
        LL1CFG l = new LL1CFG("S,zToS,n,e;T,zTo,No;N,n,e#S,z,n,e;T,z,no;N,n,e#S,$;T,o;N,o");
        String input = "zzz";
        String expected_output = "S,zToS,zzTooS,zzzToooS,ERROR";
        assertEquals(expected_output, l.parse(input));
    }

    //s21 public 2
    @Test
    @Timeout(5)
    public void testParser_2_1() {
        LL1CFG l = new LL1CFG("S,ipD,oSmDc,e;D,VmS,LxS;V,n,e;L,oSc,e#S,i,o,e;D,mn,ox;V,n,e;L,o,e#S,cm$;D,cm$;V,m;L,x");
        String input = "omocxc";
        String expected_output = "S,oSmDc,omDc,omLxSc,omoScxSc,omocxSc,omocxc";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_2_2() {
        LL1CFG l = new LL1CFG("S,ipD,oSmDc,e;D,VmS,LxS;V,n,e;L,oSc,e#S,i,o,e;D,mn,ox;V,n,e;L,o,e#S,cm$;D,cm$;V,m;L,x");
        String input = "ommc";
        String expected_output = "S,oSmDc,omDc,omVmSc,ommSc,ommc";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_2_3() {
        LL1CFG l = new LL1CFG("S,ipD,oSmDc,e;D,VmS,LxS;V,n,e;L,oSc,e#S,i,o,e;D,mn,ox;V,n,e;L,o,e#S,cm$;D,cm$;V,m;L,x");
        String input = "ipxomxc";
        String expected_output = "S,ipD,ipLxS,ipxS,ipxoSmDc,ipxomDc,ipxomLxSc,ipxomxSc,ipxomxc";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_2_4() {
        LL1CFG l = new LL1CFG("S,ipD,oSmDc,e;D,VmS,LxS;V,n,e;L,oSc,e#S,i,o,e;D,mn,ox;V,n,e;L,o,e#S,cm$;D,cm$;V,m;L,x");
        String input = "omocxipmc";
        String expected_output = "S,oSmDc,omDc,omLxSc,omoScxSc,omocxSc,omocxipDc,omocxipVmSc,omocxipmSc,omocxipmc";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_2_5() {
        LL1CFG l = new LL1CFG("S,ipD,oSmDc,e;D,VmS,LxS;V,n,e;L,oSc,e#S,i,o,e;D,mn,ox;V,n,e;L,o,e#S,cm$;D,cm$;V,m;L,x");
        String input = "oo";
        String expected_output = "S,oSmDc,ooSmDcmDc,oomDcmDc,ERROR";
        assertEquals(expected_output, l.parse(input));
    }

    //s21 private 8_1
    @Test
    @Timeout(5)
    public void testParser_3_1() {
        LL1CFG l = new LL1CFG("S,oEc,xy;E,SL;L,sL,S#S,o,x;E,ox;L,s,ox#S,cosx$;E,c;L,c");
        String input = "oxysxyc";
        String expected_output = "S,oEc,oSLc,oxyLc,oxysLc,oxysSc,oxysxyc";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_3_2() {
        LL1CFG l = new LL1CFG("S,oEc,xy;E,SL;L,sL,S#S,o,x;E,ox;L,s,ox#S,cosx$;E,c;L,c");
        String input = "oxyxyc";
        String expected_output = "S,oEc,oSLc,oxyLc,oxySc,oxyxyc";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_3_3() {
        LL1CFG l = new LL1CFG("S,oEc,xy;E,SL;L,sL,S#S,o,x;E,ox;L,s,ox#S,cosx$;E,c;L,c");
        String input = "oxyssxyc";
        String expected_output = "S,oEc,oSLc,oxyLc,oxysLc,oxyssLc,oxyssSc,oxyssxyc";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_3_4() {
        LL1CFG l = new LL1CFG("S,oEc,xy;E,SL;L,sL,S#S,o,x;E,ox;L,s,ox#S,cosx$;E,c;L,c");
        String input = "oxysssxyc";
        String expected_output = "S,oEc,oSLc,oxyLc,oxysLc,oxyssLc,oxysssLc,oxysssSc,oxysssxyc";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_3_5() {
        LL1CFG l = new LL1CFG("S,oEc,xy;E,SL;L,sL,S#S,o,x;E,ox;L,s,ox#S,cosx$;E,c;L,c");
        String input = "ooyc";
        String expected_output = "S,oEc,oSLc,ooEcLc,ERROR";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_4_1() {
        LL1CFG l = new LL1CFG("S,mF,iX;F,LX;X,aL,e;L,mL,i#S,m,i;F,im;X,a,e;L,m,i#S,$;F,$;X,$;L,a$");
        String input = "iammi";
        String expected_output = "S,iX,iaL,iamL,iammL,iammi";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_4_2() {
        LL1CFG l = new LL1CFG("S,mF,iX;F,LX;X,aL,e;L,mL,i#S,m,i;F,im;X,a,e;L,m,i#S,$;F,$;X,$;L,a$");
        String input = "miami";
        String expected_output = "S,mF,mLX,miX,miaL,miamL,miami";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_4_3() {
        LL1CFG l = new LL1CFG("S,mF,iX;F,LX;X,aL,e;L,mL,i#S,m,i;F,im;X,a,e;L,m,i#S,$;F,$;X,$;L,a$");
        String input = "mmmmiammi";
        String expected_output = "S,mF,mLX,mmLX,mmmLX,mmmmLX,mmmmiX,mmmmiaL,mmmmiamL,mmmmiammL,mmmmiammi";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_4_4() {
        LL1CFG l = new LL1CFG("S,mF,iX;F,LX;X,aL,e;L,mL,i#S,m,i;F,im;X,a,e;L,m,i#S,$;F,$;X,$;L,a$");
        String input = "iammmmmmi";
        String expected_output = "S,iX,iaL,iamL,iammL,iammmL,iammmmL,iammmmmL,iammmmmmL,iammmmmmi";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_4_5() {
        LL1CFG l = new LL1CFG("S,mF,iX;F,LX;X,aL,e;L,mL,i#S,m,i;F,im;X,a,e;L,m,i#S,$;F,$;X,$;L,a$");
        String input = "mmaa";
        String expected_output = "S,mF,mLX,mmLX,ERROR";
        assertEquals(expected_output, l.parse(input));
    }

    //s21 private 8_2
    @Test
    @Timeout(5)
    public void testParser_5_1() {
        LL1CFG l = new LL1CFG("S,aX,xX;X,bY,cY,yS;Y,X,x#S,a,x;X,b,c,y;Y,bcy,x#S,$;X,$;Y,$");
        String input = "ayacx";
        String expected_output = "S,aX,ayS,ayaX,ayacY,ayacx";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_5_2() {
        LL1CFG l = new LL1CFG("S,aX,xX;X,bY,cY,yS;Y,X,x#S,a,x;X,b,c,y;Y,bcy,x#S,$;X,$;Y,$");
        String input = "xcbx";
        String expected_output = "S,xX,xcY,xcX,xcbY,xcbx";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_5_3() {
        LL1CFG l = new LL1CFG("S,aX,xX;X,bY,cY,yS;Y,X,x#S,a,x;X,b,c,y;Y,bcy,x#S,$;X,$;Y,$");
        String input = "xbyxcx";
        String expected_output = "S,xX,xbY,xbX,xbyS,xbyxX,xbyxcY,xbyxcx";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_5_4() {
        LL1CFG l = new LL1CFG("S,aX,xX;X,bY,cY,yS;Y,X,x#S,a,x;X,b,c,y;Y,bcy,x#S,$;X,$;Y,$");
        String input = "acyxcbx";
        String expected_output = "S,aX,acY,acX,acyS,acyxX,acyxcY,acyxcX,acyxcbY,acyxcbx";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_5_5() {
        LL1CFG l = new LL1CFG("S,aX,xX;X,bY,cY,yS;Y,X,x#S,a,x;X,b,c,y;Y,bcy,x#S,$;X,$;Y,$");
        String input = "abc";
        String expected_output = "S,aX,abY,abX,abcY,ERROR";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_6_1() {
        LL1CFG l = new LL1CFG("S,oLc,a;L,oLcD,aD;D,mSD,e#S,o,a;L,o,a;D,m,e#S,cm$;L,c;D,c");
        String input = "oamac";
        String expected_output = "S,oLc,oaDc,oamSDc,oamaDc,oamac";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_6_2() {
        LL1CFG l = new LL1CFG("S,oLc,a;L,oLcD,aD;D,mSD,e#S,o,a;L,o,a;D,m,e#S,cm$;L,c;D,c");
        String input = "ooacc";
        String expected_output = "S,oLc,ooLcDc,ooaDcDc,ooacDc,ooacc";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_6_3() {
        LL1CFG l = new LL1CFG("S,oLc,a;L,oLcD,aD;D,mSD,e#S,o,a;L,o,a;D,m,e#S,cm$;L,c;D,c");
        String input = "oamamac";
        String expected_output = "S,oLc,oaDc,oamSDc,oamaDc,oamamSDc,oamamaDc,oamamac";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_6_4() {
        LL1CFG l = new LL1CFG("S,oLc,a;L,oLcD,aD;D,mSD,e#S,o,a;L,o,a;D,m,e#S,cm$;L,c;D,c");
        String input = "oamoamacc";
        String expected_output = "S,oLc,oaDc,oamSDc,oamoLcDc,oamoaDcDc,oamoamSDcDc,oamoamaDcDc,oamoamacDc,oamoamacc";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_6_5() {
        LL1CFG l = new LL1CFG("S,oLc,a;L,oLcD,aD;D,mSD,e#S,o,a;L,o,a;D,m,e#S,cm$;L,c;D,c");
        String input = "oacoc";
        String expected_output = "S,oLc,oaDc,oac,ERROR";
        assertEquals(expected_output, l.parse(input));
    }

    //s21 private 8_3
    @Test
    @Timeout(5)
    public void testParser_7_1() {
        LL1CFG l = new LL1CFG("S,B,xC,yS;B,CB;C,r#S,r,x,y;B,r;C,r#S,$;B,$;C,r$");
        String input = "yyyxr";
        String expected_output = "S,yS,yyS,yyyS,yyyxC,yyyxr";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_7_2() {
        LL1CFG l = new LL1CFG("S,B,xC,yS;B,CB;C,r#S,r,x,y;B,r;C,r#S,$;B,$;C,r$");
        String input = "yyyyxr";
        String expected_output = "S,yS,yyS,yyyS,yyyyS,yyyyxC,yyyyxr";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_7_3() {
        LL1CFG l = new LL1CFG("S,B,xC,yS;B,CB;C,r#S,r,x,y;B,r;C,r#S,$;B,$;C,r$");
        String input = "yyyyyyxr";
        String expected_output = "S,yS,yyS,yyyS,yyyyS,yyyyyS,yyyyyyS,yyyyyyxC,yyyyyyxr";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_7_4() {
        LL1CFG l = new LL1CFG("S,B,xC,yS;B,CB;C,r#S,r,x,y;B,r;C,r#S,$;B,$;C,r$");
        String input = "yyyyyxr";
        String expected_output = "S,yS,yyS,yyyS,yyyyS,yyyyyS,yyyyyxC,yyyyyxr";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_7_5() {
        LL1CFG l = new LL1CFG("S,B,xC,yS;B,CB;C,r#S,r,x,y;B,r;C,r#S,$;B,$;C,r$");
        String input = "rxryr";
        String expected_output = "S,B,CB,rB,ERROR";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_8_1() {
        LL1CFG l = new LL1CFG("S,bLc,a;L,SN;N,kSN,e#S,b,a;L,ab;N,k,e#S,ck$;L,c;N,c");
        String input = "bakac";
        String expected_output = "S,bLc,bSNc,baNc,bakSNc,bakaNc,bakac";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_8_2() {
        LL1CFG l = new LL1CFG("S,bLc,a;L,SN;N,kSN,e#S,b,a;L,ab;N,k,e#S,ck$;L,c;N,c");
        String input = "bbacc";
        String expected_output = "S,bLc,bSNc,bbLcNc,bbSNcNc,bbaNcNc,bbacNc,bbacc";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_8_3() {
        LL1CFG l = new LL1CFG("S,bLc,a;L,SN;N,kSN,e#S,b,a;L,ab;N,k,e#S,ck$;L,c;N,c");
        String input = "bakbackac";
        String expected_output = "S,bLc,bSNc,baNc,bakSNc,bakbLcNc,bakbSNcNc,bakbaNcNc,bakbacNc,bakbackSNc,bakbackaNc,bakbackac";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_8_4() {
        LL1CFG l = new LL1CFG("S,bLc,a;L,SN;N,kSN,e#S,b,a;L,ab;N,k,e#S,ck$;L,c;N,c");
        String input = "bakakbacc";
        String expected_output = "S,bLc,bSNc,baNc,bakSNc,bakaNc,bakakSNc,bakakbLcNc,bakakbSNcNc,bakakbaNcNc,bakakbacNc,bakakbacc";
        assertEquals(expected_output, l.parse(input));
    }

    @Test
    @Timeout(5)
    public void testParser_8_5() {
        LL1CFG l = new LL1CFG("S,bLc,a;L,SN;N,kSN,e#S,b,a;L,ab;N,k,e#S,ck$;L,c;N,c");
        String input = "ba";
        String expected_output = "S,bLc,bSNc,baNc,ERROR";
        assertEquals(expected_output, l.parse(input));
    }

    // fb 37- met grp
    // https://www.facebook.com/groups/1640157849618962/permalink/2264383597196381/
    // https://github.com/Hamahmi/CompilersLabTests/blob/master/task7Test.java
    // private final String cfg1 = "S,iST,e;T,cS,a";
    // private final String table1 = "S,$,e;S,a,e;S,c,e;S,i,iST;T,a,a;T,c,cS";
    private final String input1_1 = "iiac";
    private final String derivation1_1 = "S,iST,iiSTT,iiTT,iiaT,iiacS,iiac";
    private final String input1_2 = "iia";
    private final String derivation1_2 = "S,iST,iiSTT,iiTT,iiaT,ERROR";
    private final String c1 = "S,iST,e;T,cS,a#S,i,ace;T,c,a#S,ac$;T,ac$";

    @Test
    @Timeout(5)
    public void test_1_1(){
        LL1CFG l = new LL1CFG(c1);
        assertEquals(derivation1_1, l.parse(input1_1));
    }
    @Test
    @Timeout(5)
    public void test_1_2(){
        LL1CFG l = new LL1CFG(c1);
        assertEquals(derivation1_2, l.parse(input1_2));
    }

    // private final String cfg2 = "S,TA;A,pTA,e;T,FB;B,mFB,e;F,lSr,i";
    // private final String table2 = "A,$,e;A,p,pTA;A,r,e;B,$,e;B,m,mFB;B,p,e;B,r,e;F,i,i;F,l,lSr;S,i,TA;S,l,TA;T,i,FB;T,l,FB";
    private final String input2_1 = "imlipir";
    private final String derivation2_1 = "S,TA,FBA,iBA,imFBA,imlSrBA,imlTArBA,imlFBArBA,imliBArBA,imliArBA,imlipTArBA,imlipFBArBA,imlipiBArBA,imlipiArBA,imlipirBA,imlipirA,imlipir";
    private final String input2_2 = "imlipirl";
    private final String derivation2_2 = "S,TA,FBA,iBA,imFBA,imlSrBA,imlTArBA,imlFBArBA,imliBArBA,imliArBA,imlipTArBA,imlipFBArBA,imlipiBArBA,imlipiArBA,imlipirBA,ERROR";
    private final String c2 = "S,TA;A,pTA,e;T,FB;B,mFB,e;F,lSr,i#S,il;A,p,e;T,li;B,m,e;F,l,i#S,r$;A,r$;T,pr$;B,pr$;F,mpr$";
    @Test
    @Timeout(5)
    public void test_2_1(){
        LL1CFG l = new LL1CFG(c2);
        assertEquals(derivation2_1, l.parse(input2_1));
    }
    @Test
    @Timeout(5)
    public void test_2_2(){
        LL1CFG l = new LL1CFG(c2);
        assertEquals(derivation2_2, l.parse(input2_2));
    }

    // private final String cfg3 = "S,zToS,e;T,zTo,e";
    // private final String table3 = "S,$,e;S,z,zToS;T,o,e;T,z,zTo";
    private final String input3_1 = "zzoozo";
    private final String derivation3_1 = "S,zToS,zzTooS,zzooS,zzoozToS,zzoozoS,zzoozo";
    private final String input3_2 = "zoz";
    private final String derivation3_2 = "S,zToS,zoS,zozToS,ERROR";
    private final String c3 = "S,zToS,e;T,zTo,e#S,z,e;T,z,e#S,$;T,o";
    @Test
    @Timeout(5)
    public void test_3_1(){
        LL1CFG l = new LL1CFG(c3);
        assertEquals(derivation3_1, l.parse(input3_1));
    }
    @Test
    @Timeout(5)
    public void test_3_2(){
        LL1CFG l = new LL1CFG(c3);
        assertEquals(derivation3_2, l.parse(input3_2));
    }

    // private final String cfg4 = "S,AB;A,iA,n;B,CA;C,zC,o";
    // private final String table4 = "A,i,iA;A,n,n;B,o,CA;B,z,CA;C,o,o;C,z,zC;S,i,AB;S,n,AB";
    private final String input4_1 = "inzon";
    private final String derivation4_1 = "S,AB,iAB,inB,inCA,inzCA,inzoA,inzon";
    private final String input4_2 = "nzin";
    private final String derivation4_2 = "S,AB,nB,nCA,nzCA,ERROR";
    private final String c4 = "S,AB;A,iA,n;B,CA;C,zC,o#S,in;A,i,n;B,oz;C,z,o#S,$;A,oz$;B,$;C,in";
    @Test
    @Timeout(5)
    public void test_4_1(){
        LL1CFG l = new LL1CFG(c4);
        assertEquals(derivation4_1, l.parse(input4_1));
    }
    @Test
    @Timeout(5)
    public void test_4_2(){
        LL1CFG l = new LL1CFG(c4);
        assertEquals(derivation4_2, l.parse(input4_2));
    }

    // private final String cfg5 = "S,lLr,a;L,lLrD,aD;D,cSD,e";
    // private final String table5 = "D,c,cSD;D,r,e;L,a,aD;L,l,lLrD;S,a,a;S,l,lLr";
    private final String input5_1 = "laclacarr";
    private final String derivation5_1 = "S,lLr,laDr,lacSDr,laclLrDr,laclaDrDr,laclacSDrDr,laclacaDrDr,laclacarDr,laclacarr";
    private final String input5_2 = "laclacarl";
    private final String derivation5_2 = "S,lLr,laDr,lacSDr,laclLrDr,laclaDrDr,laclacSDrDr,laclacaDrDr,laclacarDr,ERROR";
    private final String c5 = "S,lLr,a;L,lLrD,aD;D,cSD,e#S,l,a;L,l,a;D,c,e#S,cr$;L,r;D,r";
    @Test
    @Timeout(5)
    public void test_5_1(){
        LL1CFG l = new LL1CFG(c5);
        assertEquals(derivation5_1, l.parse(input5_1));
    }
    @Test
    @Timeout(5)
    public void test_5_2(){
        LL1CFG l = new LL1CFG(c5);
        assertEquals(derivation5_2, l.parse(input5_2));
    }

    // private final String cfg6 = "S,aA;A,SB,e;B,pA,mA";
    // private final String table6 = "A,$,e;A,a,SB;A,m,e;A,p,e;B,m,mA;B,p,pA;S,a,aA";
    private final String input6_1 = "aamaamp";
    private final String derivation6_1 = "S,aA,aSB,aaAB,aaB,aamA,aamSB,aamaAB,aamaSBB,aamaaABB,aamaaBB,aamaamAB,aamaamB,aamaampA,aamaamp";
    private final String input6_2 = "aapaap";
    private final String derivation6_2 = "S,aA,aSB,aaAB,aaB,aapA,aapSB,aapaAB,aapaSBB,aapaaABB,aapaaBB,aapaapAB,aapaapB,ERROR";
    private final String c6 = "S,aA;A,SB,e;B,pA,mA#S,a;A,a,e;B,p,m#S,mp$;A,mp$;B,mp$";
    @Test
    @Timeout(5)
    public void test_6_1(){
        LL1CFG l = new LL1CFG(c6);
        assertEquals(derivation6_1, l.parse(input6_1));
    }
    @Test
    @Timeout(5)
    public void test_6_2(){
        LL1CFG l = new LL1CFG(c6);
        assertEquals(derivation6_2, l.parse(input6_2));
    }

}
