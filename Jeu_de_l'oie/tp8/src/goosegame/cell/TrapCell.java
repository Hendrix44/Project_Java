package goosegame.cell;

public class TrapCell extends Cell{

  public TrapCell(int index){
    super(index);
  }
  /**
* look if player can play
* @return True if player can play, False otherwize
*/
  public boolean playerCanPlay(){
    return false;
  }
  public String toStringC(){
    return "cell "+this.getIndex() +"(trap)";
  }
  /**
* get the type of this cell
* @return the type of this cell
*/
public String getType(){
  return "trap cell";
}
}
