import gui.CustomPane;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CustomPane pane = new CustomPane();
        frame.setPreferredSize(new Dimension(520, 530));
        frame.setContentPane(pane);
        frame.getContentPane().setSize(500, 500);
        pane.moveBall();
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
