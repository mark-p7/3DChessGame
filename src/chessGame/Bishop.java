package chessGame;

public class Bishop extends Piece{
    private Color Color;
    Pieces piece = Pieces.Bishop;
    Bishop(Color Color){
        this.Color = Color;
    }
    public boolean move(int curXPos, int curYPos, int curZPos, int xPos, int yPos, int zPos) {
        int x = Math.abs(curXPos - xPos);
        int y = Math.abs(curYPos - yPos);
        if (x == y) {
            return true;
        } else{
            return false;
        }
    }
    public void display() {
        System.out.print("Bishop");
    }
    protected String getPieceString() {
        if (Color == Color.BLACK) {
            return "BBishop";
        } else {
            return "WBishop";
        }
    }
    public Color getColor() {
        return Color;
    }
    public Pieces getType() {
        return piece;
    }
}
