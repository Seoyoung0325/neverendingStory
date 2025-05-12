package CommentOnText;

import commentpopup.CommentPopup;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.*;

public class CommentMenu {
    public static void attachSelectionMenu(JTextComponent textComponent, JFrame parentFrame) {
        JPopupMenu menu = new JPopupMenu();

        JMenuItem comment = new JMenuItem("댓글");
        menu.add(comment);

        textComponent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                String selected = textComponent.getSelectedText();
                if (selected != null && !selected.trim().isEmpty()) {
                    menu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        comment.addActionListener(e -> {
            new CommentPopup(parentFrame, 300, 200);
        });
    }
}