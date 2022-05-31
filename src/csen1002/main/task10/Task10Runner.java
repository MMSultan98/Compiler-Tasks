package csen1002.main.task10;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Task10Runner {

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

    public static void main(String[] args) {
        System.out.println(btreeCheck("nil"));
        System.out.println(btreeCheck("5"));
        System.out.println(btreeCheck("(3,(4,nil,6),(2,(6,3,4),24))"));
        System.out.println(btreeCheck("(3,(4,6,nil),(2,(6,3,4),24))"));
    }

}
