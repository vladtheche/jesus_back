package gui;

import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.util.TimerTask;

public class ArrowPane extends JPanel{
    double phi;
    int barb;

    public ArrowPane()
    {
        phi = Math.toRadians(20);
        barb = 20;
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        Point sw = new Point(w/8, h*7/8);
        Point ne = new Point(400, 450);
        g2.draw(new Line2D.Double(sw, ne));
        drawArrowHead(g2, ne, sw, Color.black);
    }

    private void drawArrowHead(Graphics2D g2, Point tip, Point tail, Color color)
    {
        g2.setPaint(color);
        double dy = tip.y - tail.y;
        double dx = tip.x - tail.x;
        double theta = Math.atan2(dy, dx);

        //System.out.println("theta = " + Math.toDegrees(theta));
        double x, y, rho = theta + phi;
        Polygon p = new Polygon();
        p.addPoint(tip.x, tip.y);

        for(int j = 0; j < 2; j++)
        {
            x = tip.x - barb * Math.cos(rho);
            y = tip.y - barb * Math.sin(rho);
            p.addPoint((int)x, (int)y);
            rho = theta - phi;
        }
        g2.fill(p);
    }
}
