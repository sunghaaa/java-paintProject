package paint.view;

import javax.swing.*;
import java.awt.*;

public class View {

    private Image image;
    private Image change;
    private ImageIcon imageIcon;

    public View() {
        showPaintView();
    }

    private void showPaintView() {
        JFrame frame = new JFrame("그림판");
        frame.setSize(900, 700);
        frame.setLayout(null);

        //버튼
        //저장 지우개 텍스트추가 선색상 선굵기

        //저장 아이콘 1
        JButton saveButton = new JButton();
        saveButton.setBounds(10, 10, 40, 40);

        ImageIcon save = new ImageIcon("src/images/saveIcon.png");
        image = save.getImage();
        change = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(change);

        saveButton.setIcon(imageIcon);
        frame.add(saveButton);

        //지우개 아이콘 2
        JButton clearButton = new JButton();
        clearButton.setBounds(60, 10, 40, 40);

        ImageIcon clear = new ImageIcon("src/images/clearIcon.png");
        image = clear.getImage();
        change = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(change);

        clearButton.setIcon(imageIcon);
        frame.add(clearButton);

        //텍스트추가 아이콘 3
        JButton textButton = new JButton();
        textButton.setBounds(110, 10, 40, 40);

        ImageIcon text = new ImageIcon("src/images/textIcon.png");
        image = text.getImage();
        change = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(change);

        textButton.setIcon(imageIcon);
        frame.add(textButton);

        //선색상 아이콘 4
        JButton colorButton = new JButton();
        colorButton.setBounds(160, 10, 40, 40);

        ImageIcon color = new ImageIcon("src/images/colorIcon.png");
        image = color.getImage();
        change = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(change);

        colorButton.setIcon(imageIcon);
        frame.add(colorButton);

        //선굵기 아이콘 5
        JButton thicknessButton = new JButton();
        thicknessButton.setBounds(210, 10, 40, 40);

        ImageIcon thickness = new ImageIcon("src/images/boldIcon.png");
        image = thickness.getImage();
        change = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(change);

        thicknessButton.setIcon(imageIcon);
        frame.add(thicknessButton);



        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.add(saveButton);
        panel.add(clearButton);

        frame.setJMenuBar(createMenu());
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); //가운데로 창 보여주기
        frame.setVisible(true);

    }

    private JMenuBar createMenu() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("파일");
        JMenuItem save = new JMenuItem("저장");
        JMenuItem load = new JMenuItem("열기");

        jMenu.add(save);
        jMenu.add(load);
        jMenuBar.add(jMenu);
        jMenuBar.add(jMenu);
        return jMenuBar;
    }


}