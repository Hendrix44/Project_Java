package goosegame.cell;

public class TeleportationCell extends Cell{
  /** index of teleportation cell */
  protected int telIndex;

  public TeleportationCell(int index,int telIndex){
    super(index);
    this.telIndex=telIndex;
  }
  /** get the index Teleportation of the cell
   */
  public int getTeleportIndex(){
    return this.telIndex;
  }
  /**
  * get the index of the bounce cell , bounce cell index is tpIndex
  * @param v the value of the roll of the dice
  * @return the index of the bounce cell
  */
  public int bounce(int dice){
    return this.telIndex;
  }

  /**
  * get the type of this cell
  * @return the type of this cell
  */
  public String getType(){
    return "teleportation cell";
  }

/**
* check if it's a teleportation cell 
* @param o object to check
* @return True if type is good, False otherwize
*/
  public boolean equals(Object o){
      if(!(o instanceof TeleportationCell)){
          return false;
      }
      else{
          TeleportationCell other =(TeleportationCell) o;
          return this.index==other.index && this.telIndex==other.telIndex;

      }
  }

}
