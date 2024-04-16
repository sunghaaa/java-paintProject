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

    public PaintCanvas paintCanvas = new PaintCanvas();
    private JFileChooser jFileChooser = new JFileChooser();
    public BufferedImage bufferedImage;

    public OpenImages(BufferedImage bufferedImage){
        this.bufferedImage = bufferedImage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG", "jpeg", "jpg", "png");
        jFileChooser.addChoosableFileFilter(filter);

        int loadOption = jFileChooser.showOpenDialog(null);

        if (loadOption == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jFileChooser.getSelectedFile();

            try {
                paintCanvas.bufferedImage = ImageIO.read(new File(selectedFile.getAbsolutePath()));
                System.out.println("이미지 열기 성공했습니다.");

                paintCanvas.repaint();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }
        if (loadOption == JFileChooser.CANCEL_OPTION) {
            System.out.println("이미지 열기 취소했습니다.");
        }
    }
}
