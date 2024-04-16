package paint.listener;

import paint.draw.PaintCanvas;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JSliderListener implements ChangeListener {

    private PaintCanvas paintCanvas;

    public JSliderListener(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        int thickness = source.getValue();

        this.paintCanvas.setStroke(thickness);
    }

}
