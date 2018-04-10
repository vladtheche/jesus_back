package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 650));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Animation panel = new Animation();
        frame.setContentPane(panel);
        frame.getContentPane().setSize(600, 600);
        JButton button = new JButton();
        TextField field = new TextField();
        TextField speed = new TextField();
        field.setSize(new Dimension(50, 30));
        speed.setSize(new Dimension(100, 30));
        button.setText("RUN!");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    panel.throwBall(Double.parseDouble(field.getText()), Integer.parseInt(speed.getText()));
                }
                catch (WrongAngleException | NumberFormatException | WrongSpeedException err){
                    JOptionPane.showMessageDialog(null, err.getMessage(), "ERROR!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.add(new JLabel("Enter Angle here: "));
        frame.add(field);
        frame.add(button);
        frame.add(new JLabel("Enter Speed here: "));
        frame.add(speed);
        frame.pack();
        frame.setVisible(true);
    }
}
