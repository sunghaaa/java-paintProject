package paint.view;

import paint.draw.CreateJMenuBar;
import paint.draw.PaintCanvas;
import paint.listener.JComboBoxListener;
import paint.listener.JSliderListener;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PaintAppView extends PaintCanvas{
    public int w = 900;
    public int h = 700;
    private Image image;
    private Image change;
    private ImageIcon imageIcon;
    private CreateJMenuBar createMenuBar = new CreateJMenuBar();

    public PaintAppView() {
        run();
    }

    private void run() {
        JFrame frame = new JFrame("그림판");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(w, h);
        frame.setLocationRelativeTo(null);

        PaintCanvas canvas = new PaintCanvas();

        JPanel jPanel = new JPanel();
        frame.getContentPane().add(jPanel, BorderLayout.CENTER);

        JPanel functionPanel = new JPanel();
        frame.getContentPane().add(functionPanel, BorderLayout.NORTH);

        canvas.setPreferredSize(new Dimension(w, h));
        jPanel.add(canvas);

        //텍스트 아이콘
        JButton textButton = new JButton();
        //textButton.setBounds(10, 10, 40, 40);

        ImageIcon text = new ImageIcon("src/images/textIcon.png");
        image = text.getImage();
        change = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(change);

        textButton.setIcon(imageIcon);

        functionPanel.add(textButton);

        //지우개 아이콘
        JButton clearButton = new JButton();
        //clearButton.setBounds(60, 10, 40, 40);

        ImageIcon clear = new ImageIcon("src/images/clearIcon.png");
        image = clear.getImage();
        change = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(change);

        clearButton.setIcon(imageIcon);

        clearButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                canvas.clearImages();

            }
        });

        functionPanel.add(clearButton);

        //선굵기 조정
        JSlider jSlider = new JSlider(1, 50, 1);

        jSlider.addChangeListener(new JSliderListener(canvas));

        functionPanel.add(jSlider);

        //배열로 선 색상 변경
        String[] colors = {"RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "PURPLE", "BLACK"};

        JComboBox jComboBox = new JComboBox(colors);
        jComboBox.addActionListener(new JComboBoxListener(canvas));
        functionPanel.add(jComboBox);

        frame.add(canvas);

        //저장 아이콘
        JButton saveButton = new JButton();

        ImageIcon save = new ImageIcon("src/images/saveIcon.png");
        image = save.getImage();
        change = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(change);

        saveButton.setIcon(imageIcon);

        saveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

        functionPanel.add(saveButton);

        frame.setJMenuBar(createMenuBar.createMenuBar());

        frame.setVisible(true);

    }

}
