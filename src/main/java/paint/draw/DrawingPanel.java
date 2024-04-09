package paint.draw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.Vector;

public class DrawingPanel extends JPanel{
    private Vector<Point> startPoint = new Vector<>();
    private Vector<Point> endPoint = new Vector<>();
    //private Vector<Point> lines = new Vector<Point>();
    private Color currentColor;
    private Color previousColor;
    private ArrayList<Point> lines = new ArrayList<>();

    public int defaultStroke = 1;

    private ArrayList<DrawingLine> drawingLines;


    public DrawingPanel() {

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                lines.add(e.getPoint());
                repaint();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lines.add(null);
                lines.add(e.getPoint());
            }
        });

    }


    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        for (int i = 1; i < lines.size(); i++) {

            if (lines.get(i - 1) == null) {
                continue;
            } else if (lines.get(i) == null) {
                continue;
            } else {
                g.setColor(getPreviousColor());

                g.drawLine((int) lines.get(i - 1).getX(), (int) lines.get(i - 1).getY(),
                        (int) lines.get(i).getX(), (int) lines.get(i).getY());

                g.setColor(getCurrentColor());

            }
        }
    }

    public void clearLines() {
        lines.clear();
        repaint();
        setCurrentColor(null);
        setCurrentStroke(defaultStroke);
    }

    public void setCurrentColor(Color currentColor) {

        previousColor = currentColor;

        if (currentColor == null) {
            this.currentColor = Color.BLACK;
        } else {
            this.currentColor = currentColor;
        }
    }

    private Color getCurrentColor() {
        return currentColor;
    }

    private Color getPreviousColor() {
        return previousColor;
    }

    public void setCurrentStroke(int currentStroke) {

        this.defaultStroke = currentStroke;

    }

}
