/*
 PLANTILLA BASE PARA CREACION DE ESCENARIOS.
 */
package Ejercicio0;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    int x;
    int yref;

    public Board() {
        this.timer = new Timer(1, this);
        this.x = 400;
        this.yref = 100;
        this.timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int y = 400;
        int x1[] = {x + 10, x + 20, x + 30, x + 40};
        int y1[] = {y - 20, y - 30, y - 30, y - 20};

        //rectangulode carro
        g.drawRect(x, y - 30, 50, 30);

        //carro
        g.drawRect(x, y - 20, 50, 10);
        g.drawOval(x + 10, y - 10, 10, 10);
        g.drawOval(x + 30, y - 10, 10, 10);
        g.drawPolygon(x1, y1, 4);
        g.drawLine(0, y, 3000, y);
        Rectangle carro = new Rectangle(x, y - 30, 50, 30);
        //Rectanguloquecae
        g.drawRect(100, yref, 20, 20);

        //Circulo que cae
        g.drawOval(x, yref, 30, 30);
        Rectangle oval = new Rectangle(x, yref, 10, 10);

        if (carro.intersects(oval)) {
            this.timer.stop();
        }

    }

    private void dibujarEscenario(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        //the first two parameters are the position (x,y) and after comes the width and the height
        g2d.fillOval(0, 0, 30, 30);
        g2d.drawOval(0, 50, 30, 30);

        g2d.fillRect(50, 0, 30, 30);
        g2d.drawRect(50, 50, 30, 30);

        g2d.drawString("Puntaje del Juego", 100, 100);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (x < 1000) {
            this.x++;
        } else {
            x = 0;
        }
        if (yref > 600) {
            this.yref = -200;
        } else {
            yref++;
        }
        repaint();
    }
}
