package paint.listener;

import paint.draw.PaintCanvas;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JComboBoxListener implements ActionListener {

    private PaintCanvas paintCanvas;

    public JComboBoxListener(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox source = (JComboBox) e.getSource();
        String color = (String) source.getSelectedItem();

        this.paintCanvas.setColor(color);
    }
}
