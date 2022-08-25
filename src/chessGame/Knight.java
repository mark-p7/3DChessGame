package chessGame;

public class Knight extends Piece{
    Color Color;
    Pieces piece = Pieces.Knight;
    Knight(Color Color){
        this.Color = Color;
    }
    public boolean move(int curXPos, int curYPos, int curZPos, int xPos, int yPos, int zPos) {
        if (curXPos == xPos+2 && curYPos == yPos+1 || curXPos == xPos+2 && curYPos == yPos-1) {
            return true;
        } else if (curXPos == xPos-2 && curYPos == yPos-1 || curXPos == xPos-2 && curYPos == yPos+1) {
            return true;
        } else if (curXPos == xPos+1 && curYPos == yPos+2 || curXPos == xPos-1 && curYPos == yPos+2) {
            return true;
        } else if (curXPos == xPos+1 && curYPos == yPos-2 || curXPos == xPos-1 && curYPos == yPos-2) {
            return true;
        }
        else{
            return false;
        }
    }
    public void display() {
        System.out.print("Knight");
    }
    protected String getPieceString() {
        if (Color == Color.BLACK) {
            return "BKnight";
        } else {
            return "WKnight";
        }
    }
    public Color getColor() {
        return Color;
    }
    public Pieces getType() {
        return piece;
    }
}
