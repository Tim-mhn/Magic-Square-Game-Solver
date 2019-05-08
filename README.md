# Magic-Square-Game-Solver
Magic Square Game is a solo 'game' where the player needs to fill in all the cells of a board using specific movement rules (jump 2 cells horizontally or vertically, jump 1 cell in diagonale). You can't jump to a cell already explored. This is a programm to solve this 'game' using Java

# Running the solver

Type on the main function. You can choose a size bigger than 5. The size correspond to the height / length of the board. There's thus size² cells in total.

```java

public static void main(String[] args){
  Solver s = new Solver(5);
  s.explore();
  
```
