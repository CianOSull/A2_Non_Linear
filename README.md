# A2_Non_Linear
 Assigment 2 for non linear data structures and algrorithms where dynamic programming and backtracking was used.

## Project specifiction:<br />
**PaperRollCuttingBottomUp.java**:<br />
Background.<br />
Consider that you are working for a paper rolls company. You have to implement a program that given a paper roll of length n computes the best revenue of cutting the roll on several roll pieces. <br />
There are ONLY 4 possible lengths of roll-pieces:
- Roll-piece of length 1 with price 1.2€
- Roll-piece of length 2 with price 3€
- Roll-piece of length 3 with price 5.8€
- Roll-piece of length 5 with price 10.1€2. Goal of the Assignment.

Goal of the Assignment.<br />
Implement the dynamic programming bottom-up (iterative) approach in Java of the rod cutting problem that we studied in the lectures. The name of your Java file must be: 
PaperRollCuttingBottomUp.java. For any length n of a paper roll, the Java file has to print  on the screen the best revenue in € and how many roll-pieces of each type were cut for obtaining such revenue.

**RobotMoving.java**:<br />
Background.<br />
You are working for a company that creates robots and you have to code the software for solving the problem of moving the robot until the finish point by consuming the minimum cost of energy for the robot. Please, look the picture below. The robot can ONLY move to the right, down and diagonal-down. As input there is a parameter n, which indicates the matrix of nxn that represents the space. Note that the robot is originally placed in the left-up part of the matrix and the finish point is in the right-down part of the matrix. <br />
The energy costs of the robot moving are: (according to the first letter of your surname):<br />
Movement | [A-M] | N-Z] 
--- | --- | --- 
Right | 1.1 | 1.5 
Down | 1.3 | 1.2
Right-Down | 2.5 | 2.3 

Goal of the Assignment.<br />
Implement the dynamic programming bottom-up or top-down approach (as you prefer) in Java of the robot moving until reaching the finish point. The name of your Java file must be: RobotMoving.java. For any size of the matrix n, the Java file has to print on the screen the minimum cost of reaching the finish point and the movements done by the robot until reaching such point (e.g right, down, right-down, right, down, down, down, etc.)

**Bishops.java**:<br />
Goal of the Assignment.<br />
Implement the backtracking algorithm of the bishops chess problem for any number n of bishops. In this problem you have to assign n bishops to a chess board (n x n) so that they are not killing each other. Remember that the bishops only kill in diagonal movements. Print ALL the solutions on the screen as chess boards (n x n) in which in every cell there is the symbol * where there is no bishop and the symbol B where there is bishop. <br />
