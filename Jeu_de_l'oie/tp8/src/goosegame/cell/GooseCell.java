package goosegame.cell;

public class GooseCell extends Cell{

// reprend le constructeur
  public GooseCell(int index){
    super(index);
  }
/**
 * This function takes an integer as an argument and returns the sum of the integer and the index of
 * the object.
 *
 * @param v the bounce of the cell
 * @return The index where the player arrived
 */
  public int bounce (int v){
    return this.index+v;
  }

  /**
* get the type of this cell
* @return the type of this cell
*/
public String getType(){
  return "goosecell";
}
  public String toStringC(){
    return "cell "+getIndex()+"(goose)";
  }
}
