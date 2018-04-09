package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

public class SquareOnClick extends JPanel {

    int X;
    int Y;

    public SquareOnClick(){
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    X = e.getX();
                    Y = e.getY();
                }
            });
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(X != 0 && Y != 0)
            g.fillRect(X, Y, 20, 20);
        repaint();

    }

}
