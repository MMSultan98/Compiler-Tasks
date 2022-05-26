/**
 * @name Mohammad Marwan Sultan
 * @id 43-3275
 * @labNumber 12
 */

grammar Task9;

@members {
	/**
	 * Compares two integer numbers
	 *
	 * @param x the first number to compare
	 * @param y the second number to compare
	 * @return 1 if x is equal to y, and 0 otherwise
	 */
	public static int equals(int x, int y) {
	    return x == y ? 1 : 0;
	}
}


// Parser rules

s returns [int check]
	: a c b { $check = equals($a.n, $b.n) * equals($a.n, $c.n); }
;

a returns [int n]
	: A a { $n = $a.n + 1; }
	| { $n = 0; }
;

b returns [int n]
	: B b { $n = $b.n + 1; }
	| { $n = 0; }
;

c returns [int n]
	: C c { $n = $c.n + 1; }
	| { $n = 0; }
;


// Lexer rules

A : 'a' ;
B : 'b' ;
C : 'c' ;
