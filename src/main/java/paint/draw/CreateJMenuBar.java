package paint.draw;

import javax.swing.*;

public class CreateJMenuBar {
    private PaintCanvas paintCanvas;

    public CreateJMenuBar(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public JMenuBar createMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("File");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem open = new JMenuItem("Open");

        save.addActionListener(new SaveImages(paintCanvas.bufferedImage, paintCanvas));
        open.addActionListener(new OpenImages(paintCanvas.bufferedImage, paintCanvas));

        jMenu.add(save);
        jMenu.add(open);

        jMenuBar.add(jMenu);

        return jMenuBar;
    }
}
