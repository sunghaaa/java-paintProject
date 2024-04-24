package paint.view;

import paint.draw.*;
import paint.listener.JComboBoxListener;
import paint.listener.JSliderListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaintAppView {

    public static int width = 900;
    public static int height = 700;

    public PaintAppView() {
        run();
    }

    private void run() {
        JFrame frame = new JFrame("그림판");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);

        PaintCanvas paintCanvas = new PaintCanvas();

        JPanel functionPanel = new JPanel();
        frame.add(functionPanel, BorderLayout.NORTH);

        frame.add(paintCanvas);

        setIconButton(functionPanel, "src/images/textIcon.png", new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("텍스트아이콘");
                JTextArea jTextArea = new JTextArea();

                Point point = e.getPoint();
                jTextArea.setBounds((int) point.getX(), (int) point.getY(), 100, 100);
                jTextArea.setOpaque(false);
                jTextArea.setVisible(true);
                paintCanvas.add(jTextArea);

            }
        });

        setIconButton(functionPanel, "src/images/clearIcon.png", new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                paintCanvas.clearImages();
            }
        });

        JSlider jSlider = new JSlider(JSlider.HORIZONTAL, 1, 3, 2);
        jSlider.setPaintTicks(true);
        jSlider.setMajorTickSpacing(1);
        jSlider.addChangeListener(new JSliderListener(paintCanvas));
        functionPanel.add(jSlider);

        String[] colors = {"RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "PURPLE", "BLACK"};
        JComboBox<String> jComboBox = new JComboBox<>(colors);
        jComboBox.setSelectedIndex(6);
        jComboBox.addActionListener(new JComboBoxListener(paintCanvas));
        functionPanel.add(jComboBox);

        setSaveIcon(functionPanel, "src/images/saveIcon.png", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveImages saveImages = new SaveImages(paintCanvas);
                saveImages.actionPerformed(e);
            }
        });

        CreateJMenuBar createJMenuBar = new CreateJMenuBar(paintCanvas);
        frame.setJMenuBar(createJMenuBar.createMenuBar());

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
}
