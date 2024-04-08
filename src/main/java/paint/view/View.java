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

        //선색상 아이콘 4
        JButton colorButton = new JButton();
        colorButton.setBounds(160, 10, 40, 40);

        ImageIcon color = new ImageIcon("src/images/colorIcon.png");
        image = color.getImage();
        change = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(change);

        colorButton.setIcon(imageIcon);

        //선굵기 아이콘 5
        JButton thicknessButton = new JButton();
        thicknessButton.setBounds(210, 10, 40, 40);

        ImageIcon thickness = new ImageIcon("src/images/boldIcon.png");
        image = thickness.getImage();
        change = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(change);

        thicknessButton.setIcon(imageIcon);

        //선 색상 변경 버튼
        JButton red = new JButton("red");
        red.setBounds(250, 10, 50, 50);

        red.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                drawingPanel.setCurrentColor(Color.RED);
            }
        });

        JButton orange = new JButton("orange");
        orange.setBounds(290, 10, 100, 100);

        orange.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                drawingPanel.setCurrentColor(Color.ORANGE);
            }
        });

        drawingPanel.add(saveButton);
        drawingPanel.add(clearButton);
        drawingPanel.add(textButton);
        drawingPanel.add(thicknessButton);
        drawingPanel.add(colorButton);

        //선 색상 변경 버튼
        drawingPanel.add(red);
        drawingPanel.add(orange);

        drawingPanel.setBackground(Color.WHITE);

        //프레임에 선긋기 panel 추가
        frame.setContentPane(drawingPanel);

        //프레임에 메뉴바 추가
        frame.setJMenuBar(createMenuBar.createMenuBar());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); //가운데로 창 보여주기
        frame.setVisible(true);

    }
}
