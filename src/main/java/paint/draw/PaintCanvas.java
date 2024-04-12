package paint.draw;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class PaintCanvas extends Canvas implements MouseListener, MouseMotionListener {

    private int width = 900;
    private int height = 700;

    //그려진 이미지 BufferedImage를 사용해 저장
    private BufferedImage bufferedImage = null;
    private Graphics2D graphics2D;

    //그리는 선 초기좌표 필드
    private int x, y, xx, yy;

    //선을 그리거나 지우거나 타입을 설정
    private int type;

    //처음에 선 굵기는 1로 설정
    public int thickness = 1;

    //처음 선의 색상
    public Color color = Color.BLACK;

    public PaintCanvas() {

        x = -1;
        y = -1;
        xx = -1;
        yy = -1;
        type = 0;

        addMouseListener(this);
        addMouseMotionListener(this);

        setBackground(Color.WHITE);

        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, width, height);

        repaint();

    }

    public void clearImages() {
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, width, height);
        repaint();
    }

    public void setStroke(int thickness) {
        this.thickness = thickness;
    }

    public void setColorCombo(String color) {
        if (color.equals("RED")) {
            this.color = Color.RED;
        } else if (color.equals("ORANGE")) {
            this.color = Color.ORANGE;
        } else if (color.equals("YELLOW")) {
            this.color = Color.YELLOW;
        } else if (color.equals("GREEN")) {
            this.color = Color.GREEN;
        } else if (color.equals("BLUE")) {
            this.color = Color.BLUE;
        } else if (color.equals("PURPLE")) {
            this.color = (new Color(102, 0, 153));
        } else if (color.equals("BLACK")) {
            this.color = Color.BLACK;
        }

    }

    @Override
    public void paint(Graphics g) {
        if (type == 1) {
            if (x >= 0 && y >= 0 && xx >= 0 && yy >= 0) {
                BasicStroke stroke = new BasicStroke(thickness);
                graphics2D.setStroke(stroke);
                graphics2D.setColor(color);
                graphics2D.drawLine(xx, yy, x, y);
            }
        } else if (type == 2) { // 지우개 기능
            if (x >= 0 && y >= 0 && xx >= 0 && yy >= 0) {
                BasicStroke stroke = new BasicStroke();

                graphics2D.setStroke(stroke);
                graphics2D.setColor(Color.WHITE);
                graphics2D.drawLine(xx, yy, x, y);
            }
        }

        //그린 그림을 캔버스에 적용
        g.drawImage(bufferedImage, 0, 0, null);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        int button = e.getButton();
        if(button == MouseEvent.BUTTON1){
            type = 1;
        }else if(button == MouseEvent.BUTTON2){
            type = 2;
        }

        //그려진 선(이미지)의 좌표를 필드에 넘김
        xx = x;
        yy = y;

        //새로운 선의 좌표를 예전 좌표로 넘김
        Point point = e.getPoint();
        x = point.x;
        y = point.y;

        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //선 그리기가 끝나면 다시 초기화
        x = -1;
        y = -1;
        xx = -1;
        yy = -1;
        type = 0;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point point = e.getPoint();
        x = point.x;
        y = point.y;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point point = e.getPoint();
        x = point.x;
        y = point.y;
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
