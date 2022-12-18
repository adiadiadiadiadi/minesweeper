package Key;
import Key.Board;

public class Main {
    public static void main(String[] args) {
        Board.randomMines();
        Board.boardValues();
        Board.drawBoard();
        
        Board.play();
    }

}