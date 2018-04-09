package gui;

import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.TimerTask;

public class CustomPane extends JPanel{


    private int X = 0;
    private int Y = 100;
    private int dirX = 3;
    private int dirY = 2;
    private int width;
    private int heigh;

    public CustomPane(){
        this.setSize(500, 500);
        this.setBackground(Color.lightGray);
        this.width = this.getWidth();
        this.heigh = this.getHeight();
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.fillOval(X, Y, 20, 20);
    }

    public void moveBall(){
        new Timer(3, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(X > width-20 || X < 0)
                    dirX = -dirX;
                else if (Y > heigh-20 || Y < 0)
                    dirY = -dirY;
                X += dirX;
                Y += dirY;
                repaint();
            }
        }).start();
    }
}
