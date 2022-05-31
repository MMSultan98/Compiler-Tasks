package csen1002.tests.task10;

import csen1002.main.task10.BTreeLexer;
import csen1002.main.task10.BTreeParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task10TestsV0 {
    /**
     * Parses a provided string using Task 10's grammar
     * and gets the value of the attribute "val" of the variable "tree'
     *
     * @param input a string representing a Binary Tree
     * @return the value of the attribute "val" of the variable "tree'
     */
    public static boolean btreeCheck(String input) {
        BTreeLexer lexer = new BTreeLexer(CharStreams.fromString(input));
        BTreeParser parser = new BTreeParser(new CommonTokenStream(lexer));
        return parser.btree().val;
    }

    @Test
    public void testInput01() {
        assertTrue(btreeCheck("(31,(7,nil,(60,nil,(55,7,42))),(76,(7,28,(62,nil,60)),(92,63,90)))"));
    }

    @Test
    public void testInput02() {
        assertFalse(btreeCheck("(29,(79,(11,(30,73,59),(33,nil,33)),(45,(47,nil,62),(76,nil,65))),(74,(45,(81,74,nil),(58,nil,4)),(48,60,(61,44,nil))))"));
    }

    @Test
    public void testInput03() {
        assertTrue(btreeCheck("nil"));
    }

    @Test
    public void testInput04() {
        assertTrue(btreeCheck("80"));
    }

    @Test
    public void testInput05() {
        assertFalse(btreeCheck("(8,(46,(65,(62,nil,56),(31,nil,22)),(83,(48,33,nil),(40,32,73))),(56,(73,69,(10,8,nil)),(45,(58,nil,53),(96,nil,92))))"));
    }

    @Test
    public void testInput06() {
        assertTrue(btreeCheck("(13,(18,9,(2,nil,16)),(42,(4,nil,45),86))"));
    }

    @Test
    public void testInput07() {
        assertTrue(btreeCheck("(3,(11,nil,nil),(18,nil,(30,nil,30)))"));
    }

    @Test
    public void testInput08() {
        assertFalse(btreeCheck("(20,(44,(39,61,nil),(38,nil,38)),(74,(55,28,1),71))"));
    }

    @Test
    public void testInput09() {
        assertFalse(btreeCheck("(34,(5,32,(59,67,nil)),(32,nil,(90,94,nil)))"));
    }

    @Test
    public void testInput10() {
        assertTrue(btreeCheck("(91,(72,nil,(41,nil,34)),(94,(54,nil,(6,nil,5)),(18,(21,nil,2),47)))"));
    }
}
