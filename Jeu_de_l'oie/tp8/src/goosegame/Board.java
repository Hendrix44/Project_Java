
package goosegame;
import goosegame.cell.*;

/** The board  in the "jeu de l'oie" game */
abstract class Board  {
   /** the number of the cells on the board*/
   protected final int nbOfCells;
   /** the cells on the board is a one dimension table of cells*/
   protected Cell [] theCells;

   /**
    * When created, the board is constituted with a table of cells
    */
   public Board (int nbOfCells) {
      this.nbOfCells = nbOfCells;
      this.theCells = new Cell[this.nbOfCells+1];
      this.initBoard();

   }

    /** create the board */
    protected abstract  void initBoard();

    /** get the cell
    * @param index the index of the cell we want to get
    * @return the cell which has the index
    */
    public Cell getCell(int index) {
        return this.theCells[index];
    }

   /** get the number of cells
    * @return returns the board's number of cells
    */
   public int getNbOfCells() {
      return this.nbOfCells;
   }

   public String toString() {
    return "Game Board / "+nbOfCells+"cell";
   }

}
