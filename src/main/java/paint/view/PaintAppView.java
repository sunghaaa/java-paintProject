package paint.view;

import paint.draw.CreateJMenuBar;
import paint.draw.PaintCanvas;
import paint.draw.SaveImages;
import paint.listener.JComboBoxListener;
import paint.listener.JSliderListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaintAppView extends PaintCanvas {

    public static int width = 900;
    public static int height = 700;
    private PaintCanvas paintCanvas = new PaintCanvas();

    public PaintAppView() {
        run();
    }

    private void run() {
        JFrame frame = new JFrame("그림판");

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(bufferedImage != null){
                    int select = JOptionPane.showConfirmDialog(paintCanvas, "저장하시겠습니까?", null ,JOptionPane.YES_NO_OPTION);
                    if(select == JOptionPane.YES_OPTION){
                        SaveImages saveImages = new SaveImages(bufferedImage);
                        saveImages.actionPerformed(e);
                    }
                    if(select == JOptionPane.NO_OPTION){
                        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    }
                }
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            }
        });

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);

        JPanel jPanel = new JPanel();
        frame.getContentPane().add(jPanel, BorderLayout.CENTER);

        JPanel functionPanel = new JPanel();
        frame.getContentPane().add(functionPanel, BorderLayout.NORTH);

        setPreferredSize(new Dimension(width, height));
        jPanel.add(this);

        setIconButton(functionPanel, "src/images/textIcon.png", new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                String inputText = JOptionPane.showInputDialog(null, "입력하고 싶은 텍스트를 입력하세요.");

                insertText(inputText);
            }
        });

        setIconButton(functionPanel, "src/images/clearIcon.png",  new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clearImages();
            }
        });

        JSlider jSlider = new JSlider(JSlider.HORIZONTAL, 1, 3, 2);
        jSlider.setPaintTicks(true);
        jSlider.setMajorTickSpacing(1);
        jSlider.addChangeListener(new JSliderListener(PaintAppView.this));
        functionPanel.add(jSlider);

        String[] colors = {"RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "PURPLE", "BLACK"};
        JComboBox<String> jComboBox = new JComboBox<>(colors);
        jComboBox.setSelectedIndex(6);
        jComboBox.addActionListener(new JComboBoxListener(PaintAppView.this));
        functionPanel.add(jComboBox);

        setSaveIcon(functionPanel, "src/images/saveIcon.png",  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveImages saveImages = new SaveImages(bufferedImage);
                saveImages.actionPerformed(e);
            }
        });

        CreateJMenuBar createJMenuBar = new CreateJMenuBar(paintCanvas);
        frame.setJMenuBar(createJMenuBar.createMenuBar());

        frame.add(this);
        frame.setVisible(true);
    }

    private void setIconButton(JPanel jPanel, String iconPath, MouseAdapter adapter) {
        JButton jButton = new JButton();
        ImageIcon icon = new ImageIcon(iconPath);
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        jButton.setIcon(scaledIcon);
        jButton.addMouseListener(adapter);
        jPanel.add(jButton);
    }

    private void setSaveIcon(JPanel jPanel, String iconPath, ActionListener listener) {
        JButton jButton = new JButton();
        ImageIcon icon = new ImageIcon(iconPath);
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        jButton.setIcon(scaledIcon);
        jButton.addActionListener(listener);
        jPanel.add(jButton);
    }

    private void askToSaveAndExit(ActionEvent e) {
        if (bufferedImage != null) {
            int select = JOptionPane.showConfirmDialog(paintCanvas, "저장하시겠습니까?", null, JOptionPane.YES_NO_OPTION);
            if (select == JOptionPane.YES_OPTION) {
                saveAndExit(e);
            }
        }
        exit();
    }

    private void saveAndExit(ActionEvent e) {
        SaveImages saveImages = new SaveImages(bufferedImage);
        saveImages.actionPerformed(e);
        exit();
    }

    private void exit() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


}
