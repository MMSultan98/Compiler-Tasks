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

s returns [int check]
	: a1 = a c1 = c b1 = b { $check = equals($a1.n, $b1.n) * equals($a1.n, $c1.n); }
;

a returns [int n]
	: 'a' a1 = a { $n = $a1.n + 1; }
	| { $n = 0; }
;

b returns [int n]
	: 'b' b1 = b { $n = $b1.n + 1; }
	| { $n = 0; }
;

c returns [int n]
	: 'c' c1 = c { $n = $c1.n + 1; }
	| { $n = 0; }
;
