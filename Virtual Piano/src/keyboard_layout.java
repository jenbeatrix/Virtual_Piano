import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;

public class keyboard_layout extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					keyboard_layout frame = new keyboard_layout();
					frame.setVisible(true);
					frame.setTitle("Instruction");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public keyboard_layout() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Keyboard position(g).png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1872, 790);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Keyboard position(g).png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.CENTER);
		
		JLabel lbl_keylayout = new JLabel("KEYBOARD LAYOUT");
		lbl_keylayout.setFont(new Font("Vineta BT", Font.BOLD, 30));
		lbl_keylayout.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbl_keylayout, BorderLayout.NORTH);
	}

}
