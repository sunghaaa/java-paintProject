package paint.draw;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class CreateJMenuBar {

    private BufferedImage bufferedImage;
    private PaintCanvas paintCanvas;

    public CreateJMenuBar(PaintCanvas paintCanvas){
        this.paintCanvas = paintCanvas;
    }

    public JMenuBar createMenuBar(){
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("File");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem open = new JMenuItem("Open");

        save.addActionListener(new SaveImages(bufferedImage));
        open.addActionListener(new OpenImages(bufferedImage));

        jMenu.add(save);
        jMenu.add(open);

        jMenuBar.add(jMenu);

        return jMenuBar;
    }
}

