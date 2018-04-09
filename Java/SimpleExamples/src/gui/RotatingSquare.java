package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.Calendar;

public class RotatingSquare extends JPanel implements ActionListener {

    Timer timer;
    private double angle = 0;
    private double delta = 0.01;
    Rectangle.Float r = new Rectangle.Float(-100, -100, 200, 200);

    public RotatingSquare() {
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        int h = getHeight();
        int w = getWidth();
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.translate(w/2, h/2);
        g2d.rotate(angle);
        g2d.fill(r);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        angle += delta;
        repaint();
    }
}

