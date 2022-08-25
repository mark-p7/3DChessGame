package chessGame;

public class Rook extends Piece{
    Color Color;
    Pieces piece = Pieces.Knight;
    Rook(Color Color){
        this.Color = Color;
    }
    public boolean move(int curXPos, int curYPos, int curZPos, int xPos, int yPos, int zPos) {
        if (curXPos==xPos || curYPos == yPos) {
            return true;
        } else{
            return false;
        }
    }
    public void display() {
        System.out.print("Rook");
    }
    protected String getPieceString() {
        if (Color == Color.BLACK) {
            return "BRook";
        } else {
            return "WRook";
        }
    }
    public Color getColor() {
        return Color;
    }
    public Pieces getType() {
        return piece;
    }
}
