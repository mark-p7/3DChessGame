package chessGame;

import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridBagConstraints;

public class DisplayerFrame
    extends JFrame
{
    public void init(final Board board)
    {
       setLayout(new GridBagLayout());
       GridBagConstraints c = new GridBagConstraints();
       c.fill = GridBagConstraints.BOTH;
        for(int row = 0; row < 8; row++)
        {
            
//            for(int col = 0; col < 8; col++)
//            {
//                c.gridx = col;
//                c.gridy = row;
//                add(new JButton("tile"), c);
//            }
        }
    }
}