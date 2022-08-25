package chessGame;

public abstract class Piece {
    public abstract boolean move(int curXPos, int curYPos, int curZpos, int xPos, int yPos, int zPos);
    public abstract void display();
    protected abstract String getPieceString();
    public abstract Color getColor();
    public abstract Pieces getType();
}
