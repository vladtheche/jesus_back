package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animation extends JPanel implements ActionListener{
        Timer timer;
        private int X;
        private int Y;
        private int startSpeed;
        private int speedX0;
        private int speedY0;
        private double angle;
        private double t;

        public Animation(){
                timer = new Timer(16, this);
                angle = 60.0;
                startSpeed = 10;
                t = 0;
                this.X = 0;
                this.Y = this.getHeight()-20;
                this.speedX0 = (int) (this.startSpeed * Math.cos(Math.toRadians(angle)));
                this.speedY0 = (int) (this.startSpeed * Math.sin(Math.toRadians(angle)));
        }

        @Override
        protected void paintComponent(Graphics g){
                super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.fillOval(this.X, this.Y, 20, 20);
        }
        public void throwBall(double an, int sp){
                if(an < 10 || an > 90)
                        throw new WrongAngleException();
                if(sp < 0)
                        throw new WrongSpeedException();
                angle = an;
                startSpeed = sp;
                t = 0;
                this.X = 0;
                this.Y = this.getHeight()-20;
                this.speedX0 = (int) (this.startSpeed * Math.cos(Math.toRadians(angle)));
                this.speedY0 = (int) (this.startSpeed * Math.sin(Math.toRadians(angle)));
                timer.start();
        }
        @Override
        public void actionPerformed(ActionEvent e) {
                double speedY = this.speedY0 - 9.8*t;
                t += 0.016;
                this.X += this.speedX0;
                this.Y -= speedY;
                if(this.Y >= this.getHeight()-20)
                        timer.stop();
                System.out.println(speedY);
                repaint();
        }
}
