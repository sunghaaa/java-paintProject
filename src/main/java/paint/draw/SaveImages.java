package paint.draw;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class SaveImages implements ActionListener {

    private PaintCanvas paintCanvas;

    public SaveImages(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new FileNameExtensionFilter("*.png", "png"));
        int saveOption = jFileChooser.showSaveDialog(null);

        if (saveOption == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();
            try {
                PaintCanvas saveCanvas = new PaintCanvas();
                ImageIO.write(saveCanvas.bufferedImage, "png", new File(file.getAbsolutePath()));
                System.out.println("이미지 저장 성공했습니다.");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        if (saveOption == JFileChooser.CANCEL_OPTION) {
            System.out.println("이미지 저장 취소했습니다.");
        }
    }
}
