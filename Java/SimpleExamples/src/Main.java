import gui.*;

import javax.swing.*;
import java.awt.*;


   /*######################
   ########################
   *********USAGE**********

   1. Build project, check Java version
   2. Uncomment section in main
   3. Run
   4. ...
   5. Profit

   ########################
   ######################*/


public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(520, 530));

        // MOVING BALLS HERE
        /*
            CustomPane pane = new CustomPane();
            frame.setContentPane(pane);
            frame.getContentPane().setSize(500, 500);
            pane.moveBall();
        */

        // DRAWING ARROWS HERE
        /*
            ArrowPane pane = new ArrowPane();
            frame.setContentPane(pane);
            frame.getContentPane().setSize(500, 500);
        */

        // ROTATING SQUARE
        /*
            frame.setContentPane(new RotatingSquare());
            frame.getContentPane().setSize(500, 500);
        */

        //ROTATING N-GON
        /*
            frame.setContentPane(new RotatingNgon(10));
            frame.getContentPane().setSize(500, 500);
        */

        // CLICK FOR SQUARE
        /*
            frame.setContentPane(new SquareOnClick());
            frame.getContentPane().setSize(500, 500);
        */

        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
