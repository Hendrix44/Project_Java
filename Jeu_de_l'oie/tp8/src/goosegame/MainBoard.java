package goosegame;

import goosegame.cell.*;

/** The classical board in the game */
public class MainBoard extends Board{

/** creation of classicalBoard */
  public MainBoard () {
  super(63);
  }

  public void initBoard() {
    for(int i=1; i<this.nbOfCells+1; i++){
      this.theCells[i] = new Cell(i);
    }
    /** creation of cells */

    this.theCells[9] = new GooseCell(9);
    this.theCells[18] = new GooseCell(18);
    this.theCells[27] = new GooseCell(27);
    this.theCells[36] = new GooseCell(36);
    this.theCells[45] = new GooseCell(45);
    this.theCells[54] = new GooseCell(54);


    this.theCells[31] = new TrapCell(31);
    this.theCells[52] = new TrapCell(52);


    this.theCells[19] = new WaitingCell(19, 3);


    this.theCells[6] = new TeleportationCell(6, 12);
    this.theCells[42] = new TeleportationCell(42, 30);
    this.theCells[58] = new TeleportationCell(58, 1);
    }

    /**
    * get the cell
    * @param index the index of the cell we want to get
    * @return the cell which has the index
    */
  public Cell getCell(int index) {
      return this.theCells[index];
  }

  public String toString() {
    return "Game Board / "+nbOfCells+"cell";
  }

  /**
  * @return returns the board's number of cells
  */
  public int getNbOfCells() {
    return this.nbOfCells;
  }
}