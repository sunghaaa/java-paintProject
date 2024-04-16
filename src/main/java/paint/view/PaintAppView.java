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
    private PaintCanvas paintCanvas;

    public PaintAppView() {
        run();
    }

    private void run() {
        JFrame frame = new JFrame("그림판");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

        setIconButton(functionPanel, "src/images/clearIcon.png",  new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clearImages();
            }
        });

        JSlider jSlider = new JSlider(JSlider.HORIZONTAL, 1, 3, 1);
        jSlider.setPaintTicks(true);
        jSlider.setMajorTickSpacing(1);
        jSlider.addChangeListener(new JSliderListener(PaintAppView.this));
        functionPanel.add(jSlider);

        String[] colors = {"RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "PURPLE", "BLACK"};
        JComboBox<String> jComboBox = new JComboBox<>(colors);
        jComboBox.addActionListener(new JComboBoxListener(PaintAppView.this));
        functionPanel.add(jComboBox);

        setSaveIcon(functionPanel, "src/images/saveIcon.png",  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveImages saveImages = new SaveImages(paintCanvas);
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

}
