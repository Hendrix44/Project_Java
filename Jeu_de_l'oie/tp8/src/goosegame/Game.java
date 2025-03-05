package goosegame;
import java.util.*;
import goosegame.cell.*;
import java.util.Random;

public class Game {
  protected Board board;
  protected List<Player> thePlayers;
  protected Player currentPlayer;
  private static final Random RAND = new Random();

   /**the iterator so we can know the nextplayer who will play */
   protected Iterator<Player> it;

  public Game(Board board){
    this.thePlayers = new ArrayList<Player>();
    this.board = board;
  }

  /**
   * If the value is less than or equal to 63, return the value. Otherwise, return the value minus
   * twice 63
   *
   * @param v the value to be validated
   * @return The value of v if it is less than or equal to 63, otherwise the value of 63*2 - v.
   */
   public int valid(int i){
    if (i <= 63){
      return i;
    }
    else {
      return (63*2) - i;
    }
}

  /**
   * The function takes a player and a number as input, and moves the player to the cell corresponding
   * to the number
   *
   * @param p the player
   * @param v the number of cells the player will move
   */

  public void movePLayer(Player p, int v){
    Cell currentCell = p.getCell();
    int currentIndex = currentCell.getIndex();
    int nextIndex = this.valid(currentIndex + v);
    Cell nextCell = this.board.getCell(nextIndex);
    int bounceIndex = this.valid(nextCell.bounce(v));
    Cell bouncedCell = this.board.getCell(bounceIndex);
    System.out.println(p.toString() + " is on the cell " + currentIndex+ ", throws " + v +" and reaches "+ nextCell.getIndex());
    if(nextCell.getType() != "normal cell "){
      System.out.println(p.toString()+" is on a "+nextCell.getType()+" and so jumps to "+bouncedCell.getIndex());
    }

    if (!bouncedCell.isEmpty()){
      Player otherPlayer = bouncedCell.getPlayer();
      currentCell.putplayer(otherPlayer);
      otherPlayer.changeCell(currentCell);
      bouncedCell.putplayer(p);
      p.changeCell(bouncedCell);
      System.out.println("cell is busy, "+otherPlayer.toString()+" is sent to cell "+ currentCell.getIndex()+"\n \n");
    }
    else{
      System.out.println("");
      bouncedCell.putplayer(p);
      p.changeCell(bouncedCell);
    }
  }

  /**
   * This function adds a player to the game
   *
   * @param p the player to add
   */
  public void addPlayer(Player p) {
        this.thePlayers.add(p);
        Cell c = new Cell(0);
        p.changeCell(c);
        c.putplayer(p);
    }

/**
*allow to know if the game is finished or not
*@return true if it is and false if not
*/
protected boolean isFinished(){
  Cell finalcell = this.board.getCell(this.board.getNbOfCells());
  if (finalcell.isEmpty()){
      return false;
  }else{
      return true;
  }

}
public void play(){
  this.it=this.thePlayers.iterator();
  while(!this.isFinished()){
    Player player=this.nextPlayer();
    Cell c =player.getCell();
    if(c.playerCanPlay()){
        int entier = twoDiceThrow();
        this.movePLayer(player,entier);
    }
    else{
        String answer = player.toString() + " is in "+ c.toStringC()+", "+player.toString() + " cannot play \n";
        System.out.println(answer);
    }
  }
  Player p = this.board.getCell(63).getPlayer();
  System.out.println(p.toString()+" has won ");
}

private Player nextPlayer() {
  if(this.it.hasNext()){
    return this.it.next();
  }
  else {
    this.it=this.thePlayers.iterator();
    return this.it.next();
  }
}
  /**
  * result of a 1d6 throw
  * 
  * @return random result of a 1d6 throw
  */
  private int oneDieThrow() {
    return RAND.nextInt(6) + 1;
}

  /**
  * result of a 2d6 throw
  * 
  * @return random result of a 2d6 throw
  */
  public int twoDiceThrow() {
    int result = oneDieThrow() + oneDieThrow();
    return result;
  }
}