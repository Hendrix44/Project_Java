package goosegame.cell;
import goosegame.*;


public class WaitingCell extends Cell{
  /**  rounds to wait */
  protected int nbRounds;
  /** counter of left rounds */
  protected int cpt;

  public WaitingCell(int index, int nbRounds){
    super(index);
    this.nbRounds=nbRounds;
    this.cpt=nbRounds;
  }

    /**
    * get the number of rounds to wait
    * @return the number to wait
    */
    public int getNbRounds(){
      return this.nbRounds;
    }
  /**
  * get the number of left rounds to wait
  * @return the number of left rounds to wait
  */
  public int getCpt(){
    return this.cpt;
  }

  /**
  * get the nb of round to wait for
  * @return the number of round to wait for
  */
  public String getWaitingTime(){
    return this.cpt+" rounds to wait";
  }

  /**
  * look if player can play, always can play in a basic cell
  * @return True if player can play, False otherwize
  */
  public boolean playerCanPlay(){
    if(this.cpt==0)
      return true;
    else
      this.cpt=this.cpt-1;
    return false;
  }

  /**
  * put a player on a cell
  * @param the player we want to put on the cell
  */
  public void putPlayer(Player p){
      super.putplayer(p);
      this.cpt=this.nbRounds;
  }

  /**
  * get the type of this cell
  * @return the type of this cell
  */
  public String getType(){
    return "waiting cell";
  }

}
