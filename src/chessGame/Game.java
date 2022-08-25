package chessGame;

public class Game {
    Game(){
        Board chessBoard = new Board();
        SwingDisplayer display = new SwingDisplayer();
        display.displayBoard(chessBoard);
    }
}
