package chessGame;

public class Board {
    Tile[][][] chessBoard = new Tile[8][8][3];
    final Color b = Color.BLACK;
    final Color w = Color.WHITE;
    public Board(){
        init();
        for (int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if (chessBoard[i][j][0] != null) {
                    chessBoard[i][j][0].piece.display();
                    System.out.print("  ");
                } else {
                    System.out.print("empty  ");
                }
            }
            System.out.println("");
        }
    }

    void printBoard() {
        for (int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if (chessBoard[i][j][0] != null) {
                    chessBoard[i][j][0].piece.display();
                    System.out.print("  ");
                } else {
                    System.out.print("empty  ");
                }
            }
            System.out.println("");
        }
    }
    
    String checkIfPieceIsHere(int xPos, int yPos, int zPos){
        if (chessBoard[xPos][yPos][zPos] != null) {
            return chessBoard[xPos][yPos][zPos].piece.getPieceString();
        } else {
            return null;
        }
    }

    public Tile[][][] getBoard(){
        return chessBoard;
    }

    boolean checkIfMoveValid(int xPos, int yPos, int zPos) {
        if (chessBoard[xPos][yPos][zPos] == null) {
            return true;
        } else {
            return false;
        }
    }

    Tile setPieceObject(int curXPos, int curYPos, int curZpos, int xPos, int yPos, int zPos) {
        Tile temp = chessBoard[curXPos][curYPos][curZpos];
        chessBoard[curXPos][curYPos][curZpos] = null;
        chessBoard[xPos][yPos][zPos] = temp;
        return temp;
    }
    Boolean isMoveValid(int curXPos, int curYPos,int curZPos, int xPos, int yPos, int zPos) {
        boolean Dimension = true;
        System.out.println("z Positions: " + curZPos + " " + zPos);
        if (curZPos == zPos) {
            Dimension = true;
        } else if (zPos == curZPos + 1 || zPos == curZPos - 1){
            System.out.println("Move up or down 1");
            if (xPos > curXPos+1 || xPos < curXPos-1) {
                Dimension = false;
            }
            if (yPos > curYPos+1 || yPos < curYPos-1) {
                Dimension = false;
            }
        } else if (zPos == curZPos + 2 || zPos == curZPos - 2) {
            System.out.println("Move up or down 2");
            if (xPos > curXPos+2 || xPos < curXPos-2 || xPos == curXPos +1 || xPos == curXPos -1) {
                Dimension = false;
            }
            if (yPos > curYPos+2 || yPos < curYPos-2 || yPos == curYPos+1 || yPos == curYPos-1) {
                Dimension = false;
            }
        }
        System.out.println(Dimension);
        
        boolean isValid = chessBoard[curXPos][curYPos][curZPos].piece.move(curXPos, curYPos, curZPos, xPos, yPos, zPos);
        if (isValid == true && Dimension == true) {
            return true;
        } else {
            return false;
        }
    }
    void init() {
        //black pieces
        chessBoard[0][0][0] = new Tile(0, 0, 0, new Rook(b));
        chessBoard[0][1][0] = new Tile(0, 1, 0, new Knight(b));
        chessBoard[0][2][0] = new Tile(0, 2, 0, new Bishop(b));
        chessBoard[0][3][0] = new Tile(0, 3, 0, new Queen(b));
        chessBoard[0][4][0] = new Tile(0, 4, 0, new King(b));
        chessBoard[0][5][0] = new Tile(0, 5, 0, new Bishop(b));
        chessBoard[0][6][0] = new Tile(0, 6, 0, new Knight(b));
        chessBoard[0][7][0] = new Tile(0, 7, 0, new Rook(b));

        chessBoard[1][0][0] = new Tile(1, 0, 0, new Pawn(b));
        chessBoard[1][1][0] = new Tile(1, 1, 0, new Pawn(b));
        chessBoard[1][2][0] = new Tile(1, 2, 0, new Pawn(b));
        chessBoard[1][3][0] = new Tile(1, 3, 0, new Pawn(b));
        chessBoard[1][4][0] = new Tile(1, 4, 0, new Pawn(b));
        chessBoard[1][5][0] = new Tile(1, 5, 0, new Pawn(b));
        chessBoard[1][6][0] = new Tile(1, 6, 0, new Pawn(b));
        chessBoard[1][7][0] = new Tile(1, 7, 0, new Pawn(b));

        //white pieces
        chessBoard[7][0][0] = new Tile(7, 0, 0, new Rook(w));
        chessBoard[7][1][0] = new Tile(7, 1, 0, new Knight(w));
        chessBoard[7][2][0] = new Tile(7, 2, 0, new Bishop(w));
        chessBoard[7][3][0] = new Tile(7, 3, 0, new Queen(w));
        chessBoard[7][4][0] = new Tile(7, 4, 0, new King(w));
        chessBoard[7][5][0] = new Tile(7, 5, 0, new Bishop(w));
        chessBoard[7][6][0] = new Tile(7, 6, 0, new Knight(w));
        chessBoard[7][7][0] = new Tile(7, 7, 0, new Rook(w));

        chessBoard[6][0][0] = new Tile(6, 0, 0, new Pawn(w));
        chessBoard[6][1][0] = new Tile(6, 1, 0, new Pawn(w));
        chessBoard[6][2][0] = new Tile(6, 2, 0, new Pawn(w));
        chessBoard[6][3][0] = new Tile(6, 3, 0, new Pawn(w));
        chessBoard[6][4][0] = new Tile(6, 4, 0, new Pawn(w));
        chessBoard[6][5][0] = new Tile(6, 5, 0, new Pawn(w));
        chessBoard[6][6][0] = new Tile(6, 6, 0, new Pawn(w));
        chessBoard[6][7][0] = new Tile(6, 7, 0, new Pawn(w));

    }

    public Color getColor(int newPosY, int newPosX, int newPosZ) {
        return chessBoard[newPosY][newPosX][newPosZ].piece.getColor();
    }

    public boolean checkForPiece(int x, int y, int z) {
        if (chessBoard[y][x][z] == null) {
            return false;
        } else {
            return true;
        }
    }
    public String whatPiece(int x, int y, int z) {
        if (chessBoard[y][x][z] == null) {
            return null;
        } else {
            return chessBoard[y][x][z].piece.getPieceString();
        }
    }
    public boolean isPathValid(int curPosY, int curPosX, int curPosZ, int newPosY,
            int newPosX, int newPosZ) {
        if (checkIfPieceIsHere(newPosY, newPosX, newPosZ) != null) {
            Color currentPiecePatchColor = chessBoard[curPosY][curPosX][curPosZ].piece.getColor();
            Color newPiecePathColor = chessBoard[newPosY][newPosX][newPosZ].piece.getColor();
            if (currentPiecePatchColor == newPiecePathColor ) {
                return false;
            }
        }
        int Zdiff = Math.abs(curPosZ - newPosZ);
        if (Zdiff == 2) {
            Zdiff = 1;
        } else if (Zdiff == 1) {
            Zdiff = 0;
        }
        System.out.println(Zdiff);
        int spacesBetweenX = Math.abs(curPosX - newPosX);
        int spacesBetweenY = Math.abs(curPosY - newPosY);
        System.out.println(curPosX + " " + curPosY);
        System.out.println(newPosX + " " + newPosY);
        // moving up
        if (curPosX == newPosX && curPosY > newPosY) {
            for (int i = 1; i < spacesBetweenY; i++) {
                System.out.println(whatPiece(curPosX, curPosY - i, Zdiff));
                if(checkForPiece(curPosX, curPosY - i, Zdiff) == true) {
                    return false;
                }
            }
        }
        // moving down
        if (curPosX == newPosX && curPosY < newPosY) {
            for (int i = 1; i < spacesBetweenY; i++) {
                System.out.println(whatPiece(curPosX, curPosY + i, Zdiff));
                if(checkForPiece(curPosX, curPosY + i, Zdiff) == true) {
                    return false;
                }
            }
        }
        // moving right
        if (curPosX < newPosX && curPosY == newPosY) {
            for (int i = 1; i < spacesBetweenX; i++) {
                System.out.println(whatPiece(curPosX + i, curPosY, Zdiff));
                if(checkForPiece(curPosX + i, curPosY, Zdiff) == true) {
                    return false;
                }
            }
        }
        // moving left
        if (curPosX > newPosX && curPosY == newPosY) {
            for (int i = 1; i < spacesBetweenX; i++) {
                System.out.println(whatPiece(curPosX - i, curPosY, Zdiff));
                if(checkForPiece(curPosX - i, curPosY, Zdiff) == true) {
                    return false;
                }
            }
        }
        
        //moving up right
        if (curPosX < newPosX && curPosY > newPosY) {
            for (int i = 1; i < spacesBetweenX; i++) {
                System.out.println(whatPiece(curPosX + i, curPosY - i, 0));
                if(checkForPiece(curPosX + i, curPosY - i, Zdiff) == true) {
                    return false;
                }
            }
        }
        //moving up left
        if (curPosX > newPosX && curPosY > newPosY) {
            for (int i = 1; i < spacesBetweenX; i++) {
                System.out.println(whatPiece(curPosX - i, curPosY - i, 0));
                if(checkForPiece(curPosX - i, curPosY - i, Zdiff) == true) {
                    return false;
                }
            }
        }
        //moving down right
        if (curPosX < newPosX && curPosY < newPosY) {
            for (int i = 1; i < spacesBetweenX; i++) {
                System.out.println(whatPiece(curPosX + i, curPosY + i, 0));
                if(checkForPiece(curPosX + i, curPosY + i, Zdiff) == true) {
                    return false;
                }
            }
        }
        //moving down right
        if (curPosX > newPosX && curPosY < newPosY) {
            for (int i = 1; i < spacesBetweenX; i++) {
                System.out.println(whatPiece(curPosX - i, curPosY + i, 0));
                if(checkForPiece(curPosX - i, curPosY + i, Zdiff) == true) {
                    return false;
                }
            }
        }

        return true;
    }
}
