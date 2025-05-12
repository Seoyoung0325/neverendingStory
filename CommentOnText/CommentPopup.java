package CommentOnText;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class CommentPopup extends JDialog {

    public CommentPopup(JFrame parent, int x, int y) {
        super(parent, true);
        setUndecorated(true);
        setSize(900, 650);
		setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.decode("#F4F4F4"));
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.decode("#F4F4F4")));
		

		Font font = new Font("Noto Sans KR", Font.PLAIN, 16);

        JLabel title = new JLabel("텍스트 댓글");
        title.setFont(font.deriveFont(23f));
        title.setBounds(18, 18, 300, 30);
        add(title);
		
		
		//종료버튼
        JButton close = new JButton("X");
		close.setFont(font.deriveFont(35f));
        close.setBounds(852, 15, 30, 30);
        close.setFocusPainted(false);
        close.setBackground(Color.decode("#F4F4F4"));
		close.setBorder(null);
        close.addActionListener(e -> dispose());
        add(close);
		
		
		//입력창
		JTextArea textArea = new JTextArea("댓글을 남겨주세요.");
		textArea.setFont(font.deriveFont(17f));
		textArea.setForeground(Color.GRAY);
		textArea.setBackground(Color.decode("#F4F4F4"));
		textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		textArea.setBorder(new RoundedBorder(30));
		textArea.setBounds(52, 60, 600, 400);


		//입력창 placeholder
		textArea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textArea.getText().equals("댓글을 남겨주세요.")) {
					textArea.setText("");
					textArea.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textArea.getText().trim().isEmpty()) {
					textArea.setText("댓글을 남겨주세요.");
					textArea.setForeground(Color.GRAY);
				}
			}
		});
		textArea.setBounds(48, 80, 800, 480);
        add(textArea);
		
		
		//저장버튼
        JButton save = new JButton("저장");
        save.setFont(font.deriveFont(17f));
        save.setBounds(600, 580, 250, 50);
        save.setFocusPainted(false);
        save.setBackground(Color.decode("#F4F4F4"));
        save.setBorder(new RoundedBorder(15));
        save.addActionListener(e -> dispose());
        add(save);
		
        setVisible(true);
    }
}