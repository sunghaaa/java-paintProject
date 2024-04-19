package paint.draw;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

public class InsertTextFiled extends JTextField implements ActionListener, FocusListener, MouseListener, DocumentListener {

    public InsertTextFiled() {
        new TextField(10);
        setOpaque(true); //일단 보이게
        addActionListener(this);
        addFocusListener(this);
        addMouseListener(this);
    }

    public void create(){

    }


    @Override
    public void actionPerformed(ActionEvent e) {


    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            setEditable(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void insertUpdate(DocumentEvent e) {
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }

}
