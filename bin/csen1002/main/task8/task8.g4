grammar task8;

// Parser Rules
start: (Q2 | Q3 | Q4) + EOF ;

// Lexer Rules
Q2:  Q0 '00' ;
Q3:  Q0 ('000' | E '0') ;
Q4:  Q0 E ;

// Fragments
fragment E: ('001' | '0001') ('01' | '1')* ;
fragment Q0: ('1' | '01' | '0000' | E '00')* ;
