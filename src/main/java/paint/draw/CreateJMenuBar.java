package paint.draw;

import paint.view.PaintAppView;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class CreateJMenuBar{

    private BufferedImage bufferedImage;
    private PaintAppView paintAppView;
    private PaintCanvas paintCanvas;

    public CreateJMenuBar(PaintAppView paintAppView, PaintCanvas paintCanvas){
        this.paintAppView = paintAppView;
        this.paintCanvas = paintCanvas;
    }

    public JMenuBar createMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("File");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem open = new JMenuItem("Open");

        save.addActionListener(new SaveImages(bufferedImage));
        open.addActionListener(new OpenImages(bufferedImage, paintCanvas));

        jMenu.add(save);
        jMenu.add(open);

        jMenuBar.add(jMenu);

        return jMenuBar;
    }
}

