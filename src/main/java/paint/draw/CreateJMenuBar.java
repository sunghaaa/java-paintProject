package paint.draw;

import paint.view.PaintAppView;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class CreateJMenuBar{

    private BufferedImage bufferedImage;
    private PaintAppView paintAppView;

     public CreateJMenuBar(PaintAppView paintAppView, BufferedImage bufferedImage){
         this.paintAppView = paintAppView;
        this.bufferedImage = bufferedImage;
    }

    public JMenuBar createMenuBar() {
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

