package paint.draw;

import paint.view.PaintAppView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class PaintCanvas extends JPanel implements MouseListener, MouseMotionListener {

    private Graphics2D graphics2D;
    private int startX;
    private int startY;
    private int reStartX;
    private int reStartY;
    private int thickness = 2;
    public Color color = Color.BLACK;
    private HashMap<String, Color> colorMap;
    public BufferedImage bufferedImage;

    public PaintCanvas() {

        addMouseListener(this);
        addMouseMotionListener(this);

        setBackground(Color.WHITE);

        bufferedImage = new BufferedImage(PaintAppView.width, PaintAppView.height, BufferedImage.TYPE_INT_RGB);
        graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, PaintAppView.width, PaintAppView.height);

        colorMap = new HashMap<>();

        initColor();
        repaint();

    }

    private void initColor() {
        colorMap.put("RED", Color.RED);
        colorMap.put("ORANGE", Color.ORANGE);
        colorMap.put("YELLOW", Color.YELLOW);
        colorMap.put("GREEN", Color.GREEN);
        colorMap.put("BLUE", Color.BLUE);
        colorMap.put("PURPLE", new Color(102, 0, 153));
        colorMap.put("BLACK", Color.BLACK);
    }

    public void setColor(String colorName) {
        color = colorMap.getOrDefault(colorName, Color.BLACK);
    }

    public void clearImages() {
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, PaintAppView.width, PaintAppView.height);
        repaint();
    }

    public void setStroke(int thickness) {
        this.thickness = thickness;
    }

    public void drawImages() {
        if (startX >= 0 && startY >= 0 && reStartX >= 0 && reStartY >= 0) {
            BasicStroke stroke = new BasicStroke(thickness);
            graphics2D.setStroke(stroke);
            graphics2D.setColor(color);
            graphics2D.drawLine(startX, startY, reStartX, reStartY);
        }
    }


    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(bufferedImage, 0,0, null);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (e.getID() == MouseEvent.MOUSE_DRAGGED) {

            drawImages();

            reStartX = startX;
            reStartY = startY;

            Point point = e.getPoint();

            startX = point.x;
            startY = point.y;

            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        startX = -1;
        startY = -1;
        reStartX = -1;
        reStartY = -1;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point point = e.getPoint();
        startX = point.x;
        startY = point.y;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point point = e.getPoint();
        startX = point.x;
        startY = point.y;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
