/**
 * @name Mohammad Marwan Sultan
 * @id 43-3275
 * @labNumber 12
 */

grammar BTree;


// Parser rules

btree returns [boolean val]
    : t { $val = $t.val; }
;

t returns [int sum, boolean val]
	: NIL { $sum = 0; $val = true; }
	| Number { $sum = $Number.int; $val = true; }
    | LP Number C t1=t C t2=t RP { $sum = $t1.sum + $t2.sum + $Number.int; $val = $t1.val && $t2.val && ($t1.sum <= $t2.sum); }
;


// Lexer rules

Number : '0' | Non_Zero_Digit Digit* ;
NIL : 'nil' ;
LP : '(' ;
RP : ')' ;
C : ',' ;


// Fragments

fragment Digit : [0-9] ;
fragment Non_Zero_Digit : [1-9] ;
