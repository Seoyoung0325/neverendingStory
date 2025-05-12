package CommentOnText;

import javax.swing.border.Border;
import java.awt.*;

public class RoundedBorder implements Border {
    private int r;

    public RoundedBorder(int radius) {
        this.r = radius;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(r, r, r, r);
    }

    public boolean isBorderOpaque() {
        return false;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawRoundRect(x, y, w - 1, h - 1, r * 2, r * 2);
    }
}