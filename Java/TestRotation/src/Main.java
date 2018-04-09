import gui.ArrowPane;
import gui.CustomPane;

import javax.swing.*;
import java.awt.*;

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

            ArrowPane pane = new ArrowPane();
            frame.setContentPane(pane);
            frame.getContentPane().setSize(500, 500);
        
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
