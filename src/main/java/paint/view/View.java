package paint.view;

import paint.draw.CreateJMenuBar;
import paint.draw.DrawingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class View extends JFrame {

    private Image image;
    private Image change;
    private ImageIcon imageIcon;
    private DrawingPanel drawingPanel = new DrawingPanel();
    private CreateJMenuBar createMenuBar = new CreateJMenuBar();

    public View() {
        showPaintView();

    }

    private void showPaintView() {
        JFrame frame = new JFrame("그림판");
        frame.setSize(900, 700);

        //저장 아이콘 1
        JButton saveButton = new JButton();
        saveButton.setBounds(10, 10, 40, 40);

        ImageIcon save = new ImageIcon("src/images/saveIcon.png");
        image = save.getImage();
        change = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(change);

        saveButton.setIcon(imageIcon);
        //saveButton.setBorderPainted(false);
        //saveButton.setFocusPainted(false);

        //지우개 아이콘 2
        JButton clearButton = new JButton();
        clearButton.setBounds(60, 10, 40, 40);

        ImageIcon clear = new ImageIcon("src/images/clearIcon.png");
        image = clear.getImage();
        change = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(change);

        clearButton.setIcon(imageIcon);

        clearButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                drawingPanel.clearLines();
            }
        });

        //텍스트추가 아이콘 3
        JButton textButton = new JButton();
        textButton.setBounds(110, 10, 40, 40);

        ImageIcon text = new ImageIcon("src/images/textIcon.png");
        image = text.getImage();
        change = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(change);

        textButton.setIcon(imageIcon);

        /*//선색상 아이콘 4
        JButton colorButton = new JButton();
        colorButton.setBounds(160, 10, 40, 40);

        ImageIcon color = new ImageIcon("src/images/colorIcon.png");
        image = color.getImage();
        change = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(change);

        colorButton.setIcon(imageIcon);*/

        //선굵기 아이콘 5
        JButton thicknessButton = new JButton();
        thicknessButton.setBounds(160, 10, 40, 40);

        ImageIcon thickness = new ImageIcon("src/images/boldIcon.png");
        image = thickness.getImage();
        change = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(change);

        thicknessButton.setIcon(imageIcon);

        JSlider jSlider = new JSlider();
        jSlider.setBounds(500, 10, 10, 10);
        drawingPanel.add(jSlider);

        //button -> jslider로 변경하기
        thicknessButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });


        //선 색상 변경
        JButton[] jButtons = new JButton[7];

        //red
        JButton red = new JButton("red");
        red.setBounds(550, 15, 25, 25);
        //.setBackground(Color.RED);
        red.setOpaque(true);
        red.setBorderPainted(false);
        red.setFocusPainted(false);

        red.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                drawingPanel.setCurrentColor(Color.RED);
            }
        });

        //orange
        JButton orange = new JButton();

        orange.setBounds(585, 15, 25, 25);
        orange.setBackground(Color.ORANGE);
        orange.setOpaque(true);
        orange.setBorderPainted(false);
        orange.setFocusPainted(false);

        orange.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                drawingPanel.setCurrentColor(Color.ORANGE);
            }
        });

        //yellow
        JButton yellow = new JButton("yellow");

        yellow.setBounds(730, 15, 25, 25);
        //yellow.setBackground(Color.YELLOW);
        yellow.setOpaque(true);
        yellow.setBorderPainted(false);
        yellow.setFocusPainted(false);

        yellow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                drawingPanel.setCurrentColor(Color.YELLOW);
            }
        });

        //green
        JButton green = new JButton("green");
        green.setBounds(770, 15, 25, 25);
        //green.setBackground(Color.GREEN);
        green.setOpaque(true);
        green.setBorderPainted(false);
        green.setFocusPainted(false);

        green.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                drawingPanel.setCurrentColor(Color.GREEN);
            }
        });

        //blue
        JButton blue = new JButton();
        blue.setBounds(800, 15, 25, 25);
        blue.setBackground(Color.BLUE);
        blue.setOpaque(true);
        blue.setBorderPainted(false);
        blue.setFocusPainted(false);

        blue.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                drawingPanel.setCurrentColor(Color.BLUE);
            }
        });

        //purple
        JButton purple = new JButton();
        purple.setBounds(830, 15, 25, 25);
        purple.setBackground(new Color(102, 0, 153));
        purple.setOpaque(true);
        purple.setBorderPainted(false);
        purple.setFocusPainted(false);

        purple.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                drawingPanel.setCurrentColor(new Color(102, 0, 153));
            }
        });

        //black
        JButton black = new JButton();

        black.setBounds(865, 15, 25, 25);
        black.setBackground(Color.BLACK);
        black.setOpaque(true);
        black.setBorderPainted(false);
        black.setFocusPainted(false);

        black.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                drawingPanel.setCurrentColor(Color.BLACK);
            }
        });


        drawingPanel.add(saveButton);
        drawingPanel.add(clearButton);
        drawingPanel.add(textButton);
        drawingPanel.add(thicknessButton);
        //drawingPanel.add(colorButton);

        //선 색상 변경 버튼
        drawingPanel.add(red);
        drawingPanel.add(orange);
        drawingPanel.add(yellow);
        drawingPanel.add(green);
        drawingPanel.add(blue);
        drawingPanel.add(purple);
        drawingPanel.add(black);

        drawingPanel.setBackground(Color.WHITE);

        //프레임에 선긋기 panel 추가
        frame.setContentPane(drawingPanel);


        //왼쪽 파란색 테스트 버튼
        JButton test = new JButton("blue");
        test.setBounds(30, 170, 100, 100);

        frame.setLayout(null);
        frame.add(test);

        test.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                drawingPanel.setCurrentColor(Color.BLUE);
            }
        });


        //프레임에 메뉴바 추가
        frame.setJMenuBar(createMenuBar.createMenuBar());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); //가운데로 창 보여주기
        frame.setVisible(true);

    }
}
