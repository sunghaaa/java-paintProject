package paint.draw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class DrawingPanel extends JPanel {
    private Vector<Point> startPoint = new Vector<>();
    private Vector<Point> endPoint = new Vector<>();

    public DrawingPanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point startP = e.getPoint();
                startPoint.add(startP);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Point endP = e.getPoint();
                endPoint.add(endP);
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.setColor(Color.BLACK);

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.BLACK);
        //graphics2D.setStroke(new BasicStroke(3));

        for (int i = 0; i < startPoint.size(); i++) {
            Point start = startPoint.get(i);
            Point end = endPoint.get(i);

            g.drawLine((int) start.getX(), (int) start.getY(), (int) end.getX(), (int) end.getY());

        }

    }

}
