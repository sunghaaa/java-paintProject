package paint.draw;

import javax.swing.*;

public class CreateJMenuBar {

    public JMenuBar createMenuBar(){
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("파일");
        JMenuItem save = new JMenuItem("저장");
        JMenuItem load = new JMenuItem("열기");
        jMenu.add(save);
        jMenu.add(load);
        jMenuBar.add(jMenu);
        return jMenuBar;

    }

}
