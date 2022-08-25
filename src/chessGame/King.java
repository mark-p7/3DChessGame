package chessGame;

public class King extends Piece{
    Color Color;
    Pieces piece = Pieces.King;
    King(Color Color){
        this.Color = Color;
    }
    public boolean move(int curXPos, int curYPos, int curZPos, int xPos, int yPos, int zPos) {
        if ((curXPos == xPos+1 || curXPos == xPos-1 || curXPos == xPos) && (curYPos == yPos+1 || curYPos == yPos-1 || curYPos == yPos)) {
            return true;
        } else {
            return false;
        }
    }
    public void display() {
        System.out.print("King");
    }
    protected String getPieceString() {
        if (Color == Color.BLACK) {
            return "BKing";
        } else {
            return "WKing";
        }
    }
    public Color getColor() {
        return Color;
    }
    public Pieces getType() {
        return piece;
    }
}
