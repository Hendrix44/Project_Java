package goosegame;

public class GameMain {
    public static void main(String[] args){
        if (args.length < 1){
            System.out.println("please give players");
            System.exit(1);
        }
        else{
            MainBoard board = new MainBoard();
            board.initBoard();
            Game g = new Game(board);
            for(int i =0; i<args.length;i++){
                Player player = new Player(args[i]);
                g.addPlayer(player);
            }
            g.play();
        }
    }

}
