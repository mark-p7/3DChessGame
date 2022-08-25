package chessGame;

public class Pawn extends Piece{
    Color Color;
    Pieces piece = Pieces.Pawn;
    boolean firstMove = true;
    Pawn(Color Color){
        this.Color = Color;
    }
    public boolean move(int curXPos, int curYPos, int curZPos, int xPos, int yPos, int zPos) {
        if (Color == Color.WHITE) {
            if (curXPos == xPos+1 && yPos == curYPos) {
                firstMove = false;
                return true;
            } else if(firstMove == true && curXPos == xPos+2 && yPos == curYPos) {
                firstMove = false;
                return true;
            }else{
                return false;
            }
        } else {
            if (curXPos == xPos-1 && yPos == curYPos) {
                firstMove = false;
                return true;
            } else if(firstMove == true && curXPos == xPos-2 && yPos == curYPos) {
                firstMove = false;
                return true;
            }else{
                return false;
            }
        }
    }
    public void display() {
        System.out.print("Pawn");
    }
    protected String getPieceString() {
        if (Color == Color.BLACK) {
            return "BPawn";
        } else {
            return "WPawn";
        }
    }
    public Color getColor() {
        return Color;
    }
    public Pieces getType() {
        return piece;
    }
}
