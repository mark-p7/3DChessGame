package chessGame;

public class Queen extends Piece{
    Color Color;
    Pieces piece = Pieces.Queen;
    Queen(Color Color){
        this.Color = Color;
    }
    public boolean move(int curXPos, int curYPos, int curZPos, int xPos, int yPos, int zPos) {
        int x = Math.abs(curXPos - xPos);
        int y = Math.abs(curYPos - yPos);
        if (x == y) {
            return true;
        } else if (curXPos==xPos || curYPos == yPos) {
            return true;
        } else{
            return false;
        }
    }
    public void display() {
        System.out.print("Queen");
    }
    protected String getPieceString() {
        if (Color == Color.BLACK) {
            return "BQueen";
        } else {
            return "WQueen";
        }
    }
    public Color getColor() {
        return Color;
    }
    public Pieces getType() {
        return piece;
    }
}

