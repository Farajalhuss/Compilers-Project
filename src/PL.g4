grammar PL;

@header {
import backend.*;
}

@members {
}

program returns [Expr expr]
    : block EOF { $expr = $block.blockExpr; }
    ;

block returns [Expr blockExpr]
    : (statements+=statement (';' | NEWLINE)?)+
      { 
        List<Expr> exprList = new ArrayList<Expr>();
        for (StatementContext stmt : $statements) {
            exprList.add(stmt.statementExpr);
        }
        $blockExpr = new Block(exprList);
      }
    ;

statement returns [Expr statementExpr]
    : assignment { $statementExpr = $assignment.assignmentExpr; }
    | funcDecl { $statementExpr = $funcDecl.funcResult; }
    | forLoop {$statementExpr = $forLoop.forLoopExpr; }
    | ifElse {$statementExpr = $ifElse.ifElseExpr; }
    | print { $statementExpr = $print.printExpr; }
    | expression {$statementExpr = $expression.expressionExpr; }
    ;
    
expression returns [Expr expressionExpr]
    : funcInvoke { $expressionExpr = $funcInvoke.invokeResult; }
    | left=expression comparator=compareOp right=expression { $expressionExpr = new Compare($comparator.comparator, $left.expressionExpr, $right.expressionExpr); }
    | stringLiteral { $expressionExpr = $stringLiteral.stringExpr; }
    | intLiteral { $expressionExpr = $intLiteral.intExpr; }
    | left=expression '+' right=expression { $expressionExpr = new Arithmetics(Operator.Add, $left.expressionExpr, $right.expressionExpr); }
    | left=expression '-' right=expression { $expressionExpr = new Arithmetics(Operator.Sub, $left.expressionExpr, $right.expressionExpr); }
    | left=expression '*' right=expression { $expressionExpr = new Arithmetics(Operator.Mul, $left.expressionExpr, $right.expressionExpr); }
    | tuple { $expressionExpr = $tuple.tupleExpr; }
    | tupleAccess { $expressionExpr = $tupleAccess.accessExpr; }
    | list { $expressionExpr = $list.listExpr; }
    | listAccess { $expressionExpr = $listAccess.listAccessExpr; }
    | lenFunction { $expressionExpr = $lenFunction.lenExpr; }
    | left=expression '++' right=expression { $expressionExpr = new StringConcatExpr($left.expressionExpr, $right.expressionExpr); }
    ;

assignment returns [Expr assignmentExpr]
    : ID '=' expression { $assignmentExpr = new Assign($ID.text, $expression.expressionExpr); }
    | listVar=ID '[' index=expression ']' '=' e=expression { $assignmentExpr = new ListAssignment($listVar.text, $index.expressionExpr, $e.expressionExpr); }
    ;

print returns [Expr printExpr]
    : 'print' '(' expression ')' { $printExpr = new PrintExpr($expression.expressionExpr); }
    ;
    
forLoop returns [Expr forLoopExpr]
    : 'for' '(' ID 'in' begin=expression '..' end=expression ')' '{' block '}' 
        { $forLoopExpr = new ForLoop($ID.text, $begin.expressionExpr, $end.expressionExpr, $block.blockExpr); }
    ;
    
ifElse returns [Expr ifElseExpr]
    : 'if' '(' condition=expression ')' '{' trueBlock=block '}' 'else' '{' falseBlock=block '}'
      { $ifElseExpr = new Ifelse($condition.expressionExpr, $trueBlock.blockExpr, $falseBlock.blockExpr); }
    ;

compareOp returns [Comparator comparator]
    : '<' { $comparator = Comparator.LT; }
    | '<=' { $comparator = Comparator.LE; }
    | '>' { $comparator = Comparator.GT; }
    | '>=' { $comparator = Comparator.GE; }
    | '==' { $comparator = Comparator.EQ; }
    | '!=' { $comparator = Comparator.NE; }
    ;

funcDecl returns [Expr funcResult]
    : 'function' funcName=ID '(' params=paramList ')' '{' body=block '}'
      { $funcResult = new Declare($funcName.text, $params.paramsList, $body.blockExpr); }
    ;

funcInvoke returns [Expr invokeResult]
    : funcName=ID '(' args=argList ')'
      { $invokeResult = new Invoke($funcName.text, $args.argsList); }
    ;

paramList returns [List<String> paramsList]
    : id1=ID (',' id2+=ID)* {
        $paramsList = new ArrayList<String>();
        $paramsList.add($id1.text); 
        for (Token t : $id2) {     
            $paramsList.add(t.getText()); 
        }
    }
    ;

argList returns [List<Expr> argsList]
    : e1=expression (',' e2+=expression)* {
        $argsList = new ArrayList<Expr>();
        $argsList.add($e1.expressionExpr);
        for (ExpressionContext e : $e2) { 
            $argsList.add(e.expressionExpr);
        }
      }
    ;

stringLiteral returns [Expr stringExpr]
    : STRING { $stringExpr = new StringLiteral($STRING.text.substring(1, $STRING.text.length() - 1)); }
    | ID { $stringExpr = new Deref($ID.text); }
    // | first=stringLiteral CONCAT second=stringLiteral { $stringExpr = new StringConcatExpr($first.stringExpr, $second.stringExpr); }
    | '(' expression ')' { $stringExpr = $expression.expressionExpr; } 
    | left=stringLiteral '*' right=intLiteral { $stringExpr = new StringRepeatExpr($left.stringExpr, $right.intExpr); }
    ;

intLiteral returns [Expr intExpr]
    : NUMBER { $intExpr = new IntLiteral($NUMBER.text); }
    ;

tuple returns [Expr tupleExpr]
    : '(' exprList=argList ')' { $tupleExpr = new Tuple($exprList.argsList); }
    ;

tupleAccess returns [Expr accessExpr]
    : tupleVar=ID '[' index=expression ']' { $accessExpr = new ElementAccess($tupleVar.text, $index.expressionExpr); }
    ;

lenFunction returns [Expr lenExpr]
    : 'len' '(' expression ')' { $lenExpr = new Length($expression.expressionExpr); }
    ;

list returns [Expr listExpr]
    : '<' exprList=argList '>' { $listExpr = new OurList($exprList.argsList); }
    ;

listAccess returns [Expr listAccessExpr]
    : listVar=ID '[' index=expression ']' { $listAccessExpr = new ElementAccess($listVar.text, $index.expressionExpr); }
    ;

// Lexer rules
CONCAT : '++'; 
STRING : '"' ('\\"' | ~["\\])* '"';
ID     : [a-zA-Z_][a-zA-Z_0-9]* ;
NUMBER : [0-9]+ ;
WHITESPACE : [ \t\r\n] -> skip ;
NEWLINE : '\r'? '\n' ;

LSQUARE : '[' ; 
RSQUARE : ']' ;