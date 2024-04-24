package paint.draw;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OpenImages implements ActionListener {

    public BufferedImage bufferedImage;
    private PaintCanvas paintCanvas;

    public OpenImages(BufferedImage bufferedImage, PaintCanvas paintCanvas){
        this.bufferedImage = bufferedImage;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jFileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG", "jpeg", "jpg", "png");
        jFileChooser.addChoosableFileFilter(filter);

        int loadOption = jFileChooser.showOpenDialog(null);

        if (loadOption == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jFileChooser.getSelectedFile();

            try {
                paintCanvas.bufferedImage = ImageIO.read(selectedFile);
                System.out.println("이미지 열기 성공했습니다." + selectedFile.getAbsolutePath());

                paintCanvas.repaint();

            } catch (IOException ioException) {
                System.out.println("이미지 열기 실패했습니다.");
                ioException.printStackTrace();
            }
        }
        if(loadOption == JFileChooser.CANCEL_OPTION){
            System.out.println("이미지 열기 취소했습니다.");
        }
    }
}
