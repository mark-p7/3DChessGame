package chessGame;

import java.awt.*;
import javax.swing.BorderFactory;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;


public class SwingDisplayer implements MouseListener{
    Board board;
    int curPosX;
    int curPosY;
    int curPosZ;
    boolean isClicked = false;
    MouseEvent oldE;
    chessGame.Color turn = chessGame.Color.BLACK;
    public void displayBoard(final Board board) {
        final DisplayerFrame frame;
        this.board = board;
        frame = new DisplayerFrame();
        int index = 0;
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 8; j++) {
                JButton panel=new JButton();  
                panel.setBounds(i*76,j*76,75,75);   
                if (index == 0 || index % 2 == 0) {
                    panel.setBackground(Color.WHITE); 
                    frame.add(panel);
                    String pieceName;
                    if (i < 8 && j < 8) {
                        pieceName = this.board.checkIfPieceIsHere(j, i, 0);
                    } else {
                        pieceName = null;
                    }
                    if (pieceName != null) {   

                        panel.setText(pieceName);
                    }
                } 
                if (index % 2 != 0){
                    if (i >= 0 && i <= 7) {
                        panel.setBackground(Color.GRAY); 
                    } else if (i >= 8 && i <= 15){
                        panel.setBackground(Color.RED); 
                    } else if (i >= 16 && i <= 23) {
                        panel.setBackground(Color.ORANGE); 
                    }
                    frame.add(panel);
                    String p;
                    if (i < 8 && j < 8) {
                        p = this.board.checkIfPieceIsHere(j, i, 0);
                    } else {
                        p = null;
                    }
                    if (p != null) {
                        panel.setText(p);
                    }
                }
                index++;
                panel.addMouseListener(this);

            }
            index++;
        }
        frame.setSize(1840, 647);  
        frame.setLayout(null);    
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int newPosX = e.getComponent().getX()/76;
        int newPosY = e.getComponent().getY()/76;
        int newPosZ = 0;
        if (newPosX > 7 && newPosX < 16) {
            newPosX = newPosX-8;
            newPosZ = 1;
        } else if (newPosX > 15 && newPosX <= 23) {
            newPosX = newPosX-16;
            newPosZ = 2;
        }
//        System.out.println("X: " + newPosX + "\nY: " + newPosY + "\nZ: " + newPosZ);
        boolean p = board.checkIfMoveValid(newPosY, newPosX, newPosZ);
        if (board.checkIfPieceIsHere(newPosY, newPosX, newPosZ) != null && !isClicked) {
            chessGame.Color colorOfPieceClicked = board.getColor(newPosY, newPosX, newPosZ);
            // check first if its white or blacks turn

            if (colorOfPieceClicked == turn) {
                oldE = e;
                curPosX = e.getComponent().getX()/76;
                curPosY = e.getComponent().getY()/76;
                curPosZ = 0;
                if (curPosX > 7 && curPosX < 16) {
                    curPosX = curPosX-8;
                    curPosZ = 1;
                } else if (curPosX > 15 && curPosX <= 23) {
                    curPosX = curPosX-16;
                    curPosZ = 2;
                }
                isClicked = true;
                JButton j = (JButton) e.getComponent();
                j.setBorder(BorderFactory.createLineBorder(Color.RED));   
            }

        } else if ((newPosX != curPosX || newPosY != curPosY) && isClicked) {
            boolean isMoveValid = board.isMoveValid(curPosY, curPosX, curPosZ, newPosY, newPosX, newPosZ);
            boolean isPathValid = board.isPathValid(curPosY, curPosX, curPosZ, newPosY, newPosX, newPosZ);
            if (isMoveValid && isPathValid){
                Tile piece = board.setPieceObject(curPosY, curPosX, curPosZ, newPosY, newPosX, newPosZ);
                JButton x = (JButton) e.getComponent();
                x.getText();
                JButton y = (JButton) oldE.getComponent();
                y.setText(" ");
                x.setText(piece.piece.getPieceString());
                JButton j = (JButton) oldE.getComponent();
                j.setBorder(BorderFactory.createLineBorder(null));
                isClicked = false;
                oldE = null;
                curPosX = 999;
                curPosY = 999;
                if (turn == chessGame.Color.BLACK) {
                    turn = chessGame.Color.WHITE;
                } else {
                    turn = chessGame.Color.BLACK;
                }
                board.printBoard();
            } else {
                System.out.println("invalid move");
                board.printBoard();
            }

        } else if (oldE != null){
            isClicked = false;
            JButton j = (JButton) oldE.getComponent();
            j.setBorder(BorderFactory.createLineBorder(null));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
