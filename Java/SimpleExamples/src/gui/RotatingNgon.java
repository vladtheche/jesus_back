package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RotatingNgon extends JPanel implements ActionListener {

    Timer timer;
    private double angle = 0;
    private double delta = 0.01;
    Polygon p = new Polygon();
    private int sides;

    public RotatingNgon(int n) {
        this.sides = n;
        timer = new Timer(10, this);
        timer.start();

        // FILLING N-a-gon with points. change size and sides to see difference
        int size = 100;
        for (int i = 0; i < sides; i++)
            p.addPoint((int) (size  * Math.cos(i * 2 * Math.PI / sides)),
                    (int) (size * Math.sin(i * 2 * Math.PI / sides)));
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
        g2d.fill(p);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        angle += delta;
        repaint();
    }
}
