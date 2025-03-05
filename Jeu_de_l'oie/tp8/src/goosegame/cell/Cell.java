package goosegame.cell;

import goosegame.*;

public class Cell{
  protected int index ;
  protected Player player ;

  // une cellule
  public Cell(int index ){
    this.index= index ;
  }
  /**
* get the index of the cell
* @return the index of the cell
*/
  public int getIndex(){
    return this.index;
  }
  /**
* get the player of the cell if he exists
* @return the player of the cell
*/
  public Player getPlayer(){
    return this.player;
  }
  /**
* get the type of this cell
* @return the type of this cell
*/
public String getType(){
  return "normal cell";
}

  /**
  * look if player can play, always can play in a basic cell
  * @return True if player can play, False otherwize
  */

  public boolean playerCanPlay(){
    return true;
  }
/**
* get the index of the bounce cell , nothing append on basic cell
* @param v the value of the roll of the dice
* @return the index of the bounce cell
*/
  public int bounce(int index){
    return this.index;
  }
/**
* look if the cell is empty
* @return True if the cell is empty, False otherwize
*/
  public boolean isEmpty(){
    return this.player == null;
  }
/**
* put a player in a cell
* @param p the player we want to put into the cell
*/
  public void putplayer(Player p){
    this.player = p;
  }

/**
* get the String of this cell
* @return this cell as a string
*/
  public String toStringC() {
    return "cell "+ this.getIndex();
  }

/**
* check if it's a Cell
* @param o object to check
* @return True if type is good, False otherwize
*/
  public boolean equals(Object o){
      if(!(o instanceof Cell)){
          return false;
      }
      else{
          Cell other =(Cell) o;
          return this.getIndex()== other.getIndex();

      }
  }
}
