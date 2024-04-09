package paint.draw;

import java.awt.*;

public class DrawingLine{
    private Point point;
    private Color color;

    public DrawingLine (Point point, Color color) {
        this.point = point;
        this.color = color;
    }

    DrawingLine () {
        point = new Point(0,0);
        color = Color.BLACK;
    }

    public Point getPoint(){
        return point;
    }

    public Color getColor() {
        return color;
    }

}
