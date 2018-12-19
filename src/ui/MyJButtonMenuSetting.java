package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class MyJButtonMenuSetting extends JButton {

    public MyJButtonMenuSetting() {
        setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/menu-01.png")));
        setContentAreaFilled(false);
        setBorder(null);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            }

            public void mouseExited(MouseEvent e) {
                setBorder(null);
            }
        });
    }

}