package paint.draw;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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
                ImageIO.write(paintCanvas.bufferedImage, "png", new File(file.getAbsolutePath()));
                System.out.println("이미지 저장 성공했습니다.");
            } catch (IOException ioException) {
                ioException.printStackTrace();
                System.out.println("이미지 저장 실패했습니다.");
            }
        }
        if (saveOption == JFileChooser.CANCEL_OPTION) {
            System.out.println("이미지 저장 취소했습니다.");
        }
    }
}
