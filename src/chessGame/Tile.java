package chessGame;

public class Tile{
    Piece piece;
    int xpos;
    int ypos;
    int zpos;
    Tile(int xpos, int ypos, int zpos, Piece piece){
        this.xpos = xpos;
        this.ypos = ypos;
        this.piece = piece;
        this.zpos = zpos;
    }
}
