import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;

public class Virtual_piano extends JFrame implements KeyListener {
	
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private JPanel panel_main;
	private JButton btn_c4, btn_d4;
	private JTextField text_freq;
	private double noteID = 0;
	private String noteName;
	private JButton btn_cs4, btn_ds4, btn_e4, btn_f4, btn_fs4, btn_g4, btn_gs4, btn_a4, btn_as4, btn_as5, btn_b4;
	private JButton btn_c5, btn_cs5, btn_d5, btn_ds5, btn_e5, btn_f5, btn_fs5, btn_g5, btn_gs5, btn_b5, btn_c6;
	private JButton btn_a5;
	private JButton btn_pianoplayer;
	private JButton btn_buzzersound;
	private JTextField text_wavlength;
	private JButton btn_chordanalyzer;
	private JButton btn_minueting;
	
	private static MainClass MC = new MainClass();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Virtual_piano app = new Virtual_piano();
					app.frame.setVisible(true);
				} catch (Exception x) {
					JOptionPane.showMessageDialog(null, x.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	
	public double FrequencyEquation (double n) {
		double frequency = 27.5*Math.pow(2.71828182, (n-1)/17.31234049);
		return frequency;
	}
	
	public double WavelengthEquation (double n) {
		double wavelength = 12.374*Math.pow(2.71828182, (1-n)/17.31234049);
		return wavelength;
	}
	
	
	
	public Virtual_piano() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.controlShadow);
		frame.setTitle("VIRTUAL KEYBOARD");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setBounds(500, 270, 1182, 768);
		frame.addKeyListener(this);
		frame.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e) {
	                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	                if (choice == JOptionPane.YES_OPTION) {
	                	System.exit(0);	                	
	                } else if (choice == JOptionPane.NO_OPTION) {	                	
	                }      
	        }
		});
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
		panel_main = new JPanel();
		panel_main.setForeground(SystemColor.textInactiveText);
		panel_main.setBackground(SystemColor.textInactiveText);
		panel_main.setBounds(-557, -246, 100, 100);
		panel_main.setLayout(null);
		frame.getContentPane().add(panel_main);
		panel_main.addKeyListener(this);
		
		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.activeCaptionText);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(12, 387, 444, 333);
		panel_main.add(panel);
		panel.setLayout(null);
		
		btn_c4 = new JButton("C4");
		btn_c4.setHorizontalAlignment(SwingConstants.LEFT);
		btn_c4.setBounds(0, 174, 62, 159);
		panel.add(btn_c4);
		btn_c4.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_c4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				text_freq.setText("Fs = 261.63 Hz");
				text_wavlength.setText("131.87 cm");
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\C3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		btn_c4.setBackground(Color.WHITE);
		btn_c4.setForeground(Color.BLACK);
		
		btn_cs4 = new JButton("C#");
		btn_cs4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try{
						text_freq.setText("Fs = 277.18 Hz");
						text_wavlength.setText("124.47 cm");
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\C3#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		btn_cs4.setBounds(35, 0, 47, 172);
		panel.add(btn_cs4);
		btn_cs4.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btn_cs4.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_cs4.setForeground(Color.WHITE);
		btn_cs4.setBackground(Color.BLACK);
		
		btn_d4 = new JButton("D4");
		btn_d4.setBounds(63, 174, 62, 159);
		panel.add(btn_d4);
		btn_d4.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_d4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_freq.setText("Fs = 293.66 Hz");
				text_wavlength.setText("117.48 cm");
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\D3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					}	
			}
		});
		btn_d4.setBackground(Color.WHITE);
		btn_d4.setForeground(Color.BLACK);
		
		btn_ds4 = new JButton("D#");
		btn_ds4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_freq.setText("Fs = 311.13 Hz");
				text_wavlength.setText("110.89 cm");
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\D3#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		btn_ds4.setBounds(104, 0, 47, 172);
		panel.add(btn_ds4);
		btn_ds4.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_ds4.setForeground(Color.WHITE);
		btn_ds4.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btn_ds4.setBackground(Color.BLACK);
		
		btn_e4 = new JButton("E4");
		btn_e4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_freq.setText("Fs = 329.63 Hz");
				text_wavlength.setText("104.66 cm");
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\E3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		btn_e4.setBounds(126, 174, 62, 159);
		panel.add(btn_e4);
		btn_e4.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_e4.setForeground(Color.BLACK);
		btn_e4.setBackground(Color.WHITE);
		
		btn_f4 = new JButton("F4");
		btn_f4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_freq.setText("Fs = 349.23 Hz");
				text_wavlength.setText("98.79 cm");
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\F3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}catch(Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		btn_f4.setBounds(189, 174, 62, 159);
		panel.add(btn_f4);
		btn_f4.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_f4.setForeground(Color.BLACK);
		btn_f4.setBackground(Color.WHITE);
		
		btn_fs4 = new JButton("F#");
		btn_fs4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_freq.setText("Fs = 369.99 Hz");
				text_wavlength.setText("93.24 cm");
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\F3#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					}	
			}
		});
		btn_fs4.setBounds(228, 0, 47, 172);
		panel.add(btn_fs4);
		btn_fs4.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_fs4.setForeground(Color.WHITE);
		btn_fs4.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btn_fs4.setBackground(Color.BLACK);
		
		btn_g4 = new JButton("G4");
		btn_g4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_freq.setText("Fs = 392 Hz");
				text_wavlength.setText("88.01 cm");
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\G3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();		
				}catch(Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		btn_g4.setBounds(251, 174, 62, 159);
		panel.add(btn_g4);
		btn_g4.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_g4.setForeground(Color.BLACK);
		btn_g4.setBackground(Color.WHITE);
		
		btn_gs4 = new JButton("G#");
		btn_gs4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_freq.setText("Fs = 425.30 Hz");
				text_wavlength.setText("83.07 cm");
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\G3#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}catch(Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		btn_gs4.setBounds(287, 0, 47, 172);
		panel.add(btn_gs4);
		btn_gs4.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_gs4.setForeground(Color.WHITE);
		btn_gs4.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btn_gs4.setBackground(Color.BLACK);
		
		btn_a4 = new JButton("A4");
		btn_a4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_freq.setText("Fs = 440 Hz");
				text_wavlength.setText("78.41 cm");
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\A3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}catch(Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		btn_a4.setBounds(315, 174, 62, 159);
		panel.add(btn_a4);
		btn_a4.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_a4.setForeground(Color.BLACK);
		btn_a4.setBackground(Color.WHITE);
		
		btn_as4 = new JButton("A#");
		btn_as4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_freq.setText("Fs = 466.16 Hz");
				text_wavlength.setText("74.01 cm");
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\A3#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		btn_as4.setBounds(346, 0, 47, 172);
		panel.add(btn_as4);
		btn_as4.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_as4.setForeground(Color.WHITE);
		btn_as4.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btn_as4.setBackground(Color.BLACK);
		
		btn_b4 = new JButton("B4");
		btn_b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_freq.setText("Fs = 493.88");
				text_wavlength.setText("69.85 cm");
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\B3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					}	
			}
		});
		btn_b4.setBounds(380, 174, 62, 159);
		panel.add(btn_b4);
		btn_b4.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_b4.setForeground(Color.BLACK);
		btn_b4.setBackground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(SystemColor.activeCaptionText);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setLayout(null);
		panel_1.setBounds(456, 387, 506, 333);
		panel_main.add(panel_1);
		
		btn_c5 = new JButton("C5");
		btn_c5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_freq.setText("Fs = 523.25 Hz");
				text_wavlength.setText("65.93 cm");
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\C4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					}	
			}
		});
		btn_c5.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_c5.setForeground(Color.BLACK);
		btn_c5.setBackground(Color.WHITE);
		btn_c5.setBounds(0, 174, 62, 159);
		panel_1.add(btn_c5);
		
		btn_cs5 = new JButton("C#");
		btn_cs5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_freq.setText("Fs = 554.37 Hz");
				text_wavlength.setText("62.23 cm");
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\C4#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		btn_cs5.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_cs5.setForeground(Color.WHITE);
		btn_cs5.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btn_cs5.setBackground(Color.BLACK);
		btn_cs5.setBounds(35, 0, 47, 172);
		panel_1.add(btn_cs5);
		
		btn_d5 = new JButton("D5");
		btn_d5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_freq.setText("Fs = 587.33 Hz");
				text_wavlength.setText("58.74 cm");
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\D4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					}	
			}
		});
		btn_d5.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_d5.setForeground(Color.BLACK);
		btn_d5.setBackground(Color.WHITE);
		btn_d5.setBounds(63, 174, 62, 159);
		panel_1.add(btn_d5);
		
		btn_ds5 = new JButton("D#");
		btn_ds5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_freq.setText("Fs = 622.25 Hz");
				text_wavlength.setText("55.44 cm");
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\D4#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}catch(Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		btn_ds5.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_ds5.setForeground(Color.WHITE);
		btn_ds5.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btn_ds5.setBackground(Color.BLACK);
		btn_ds5.setBounds(104, 0, 47, 172);
		panel_1.add(btn_ds5);
		
		btn_e5 = new JButton("E5");
		btn_e5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_freq.setText("Fs = 659.25 Hz");
				text_wavlength.setText("52.33 cm");
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\E4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		btn_e5.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_e5.setForeground(Color.BLACK);
		btn_e5.setBackground(Color.WHITE);
		btn_e5.setBounds(126, 174, 62, 159);
		panel_1.add(btn_e5);
		
		btn_f5 = new JButton("F5");
		btn_f5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_freq.setText("Fs = 698.46 Hz");
				text_wavlength.setText("49.39 cm");
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\F4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		btn_f5.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_f5.setForeground(Color.BLACK);
		btn_f5.setBackground(Color.WHITE);
		btn_f5.setBounds(189, 174, 62, 159);
		panel_1.add(btn_f5);
		
		btn_fs5 = new JButton("F#");
		btn_fs5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_freq.setText("Fs = 739.99 Hz");
				text_wavlength.setText("46.62 cm");
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\F4#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}catch(Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		btn_fs5.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_fs5.setForeground(Color.WHITE);
		btn_fs5.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btn_fs5.setBackground(Color.BLACK);
		btn_fs5.setBounds(228, 0, 47, 172);
		panel_1.add(btn_fs5);
		
		btn_g5 = new JButton("G5");
		btn_g5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_freq.setText("Fs = 783.99 Hz");
				text_wavlength.setText("44.01 cm");
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\G4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					}	
			}
		});
		btn_g5.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_g5.setForeground(Color.BLACK);
		btn_g5.setBackground(Color.WHITE);
		btn_g5.setBounds(251, 174, 62, 159);
		panel_1.add(btn_g5);
		
		btn_gs5 = new JButton("G#");
		btn_gs5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_freq.setText("Fs = 830.61 Hz");
				text_wavlength.setText("41.54 cm");
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\G4#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		btn_gs5.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_gs5.setForeground(Color.WHITE);
		btn_gs5.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btn_gs5.setBackground(Color.BLACK);
		btn_gs5.setBounds(287, 0, 47, 172);
		panel_1.add(btn_gs5);
		
		btn_a5 = new JButton("A5");
		btn_a5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_freq.setText("Fs = 880 Hz");
				text_wavlength.setText("139.20 cm");
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\A4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		btn_a5.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_a5.setForeground(Color.BLACK);
		btn_a5.setBackground(Color.WHITE);
		btn_a5.setBounds(315, 174, 62, 159);
		panel_1.add(btn_a5);
		
		btn_as5 = new JButton("A#");
		btn_as5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_freq.setText("Fs = 932.33 Hz");
				text_wavlength.setText("37 cm");
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\A4#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		btn_as5.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_as5.setForeground(Color.WHITE);
		btn_as5.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btn_as5.setBackground(Color.BLACK);
		btn_as5.setBounds(346, 0, 47, 172);
		panel_1.add(btn_as5);
		
		btn_b5 = new JButton("B5");
		btn_b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_freq.setText("Fs = 987.77 Hz");
				text_wavlength.setText("34.93 cm");
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\B4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}catch(Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		btn_b5.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_b5.setForeground(Color.BLACK);
		btn_b5.setBackground(Color.WHITE);
		btn_b5.setBounds(380, 174, 62, 159);
		panel_1.add(btn_b5);
		
		btn_c6 = new JButton("C6");
		btn_c6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_freq.setText("Fs = 1046.50 Hz");
				text_wavlength.setText("32.97 cm");
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\C5.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		btn_c6.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_c6.setForeground(Color.BLACK);
		btn_c6.setBackground(Color.WHITE);
		btn_c6.setBounds(444, 174, 62, 159);
		panel_1.add(btn_c6);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 75, 1152, 283);
		panel_main.add(tabbedPane);
		
		JPanel panel_assist1 = new JPanel();
		panel_assist1.setBackground(SystemColor.activeCaptionBorder);
		tabbedPane.addTab("GUIDE", null, panel_assist1, null);
		panel_assist1.setLayout(null);
		
		final JComboBox combobox_chords = new JComboBox();
		combobox_chords.setFont(new Font("Vineta BT", Font.PLAIN, 16));
		combobox_chords.setModel(new DefaultComboBoxModel(new String[] {"C MAJOR", "C MINOR", "C# MAJOR", "C# MINOR", "D MAJOR", "D MINOR", "D# MAJOR", "D# MINOR", "E MAJOR ", "E MINOR", "F MAJOR", "F MINOR", "F# MAJOR", "F# MINOR", "G MAJOR", "G MINOR", "G# MAJOR", "G# MINOR", "A MAJOR", "A MINOR", "A# MAJOR", "A# MINOR", "B MAJOR", "B MINOR"}));
		combobox_chords.setBounds(38, 71, 165, 43);
		panel_assist1.add(combobox_chords);
		
		JLabel lblMajorChords = new JLabel("MAJOR CHORDS");
		lblMajorChords.setHorizontalAlignment(SwingConstants.CENTER);
		lblMajorChords.setFont(new Font("Vineta BT", Font.BOLD, 15));
		lblMajorChords.setBounds(12, 13, 242, 64);
		panel_assist1.add(lblMajorChords);
		
		JButton btn_showkey = new JButton("SHOW KEY");
		btn_showkey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (combobox_chords.getSelectedItem().equals("C MAJOR") ) {
					btn_c4.setBackground(Color.YELLOW);
					btn_e4.setBackground(Color.YELLOW);
					btn_g4.setBackground(Color.YELLOW);
				}
				if (combobox_chords.getSelectedItem().equals("C MINOR") ) {
					btn_c4.setBackground(Color.YELLOW);
					btn_ds4.setBackground(Color.YELLOW);
					btn_g4.setBackground(Color.YELLOW);
				}
				if (combobox_chords.getSelectedItem().equals("C# MAJOR") ) {
					btn_cs4.setBackground(Color.YELLOW);
					btn_f4.setBackground(Color.YELLOW);
					btn_gs4.setBackground(Color.YELLOW);
				}
				if (combobox_chords.getSelectedItem().equals("C# MINOR") ) {
					btn_cs4.setBackground(Color.YELLOW);
					btn_e4.setBackground(Color.YELLOW);
					btn_gs4.setBackground(Color.YELLOW);
			}
				if (combobox_chords.getSelectedItem().equals("D MAJOR") ) {
					btn_d4.setBackground(Color.YELLOW);
					btn_fs4.setBackground(Color.YELLOW);
					btn_a4.setBackground(Color.YELLOW);
			}
				if (combobox_chords.getSelectedItem().equals("D MINOR") ) {
					btn_d4.setBackground(Color.YELLOW);
					btn_f4.setBackground(Color.YELLOW);
					btn_a4.setBackground(Color.YELLOW);
			}
				if (combobox_chords.getSelectedItem().equals("D# MAJOR") ) {
					btn_ds4.setBackground(Color.YELLOW);
					btn_g4.setBackground(Color.YELLOW);
					btn_as4.setBackground(Color.YELLOW);
			} 
				if (combobox_chords.getSelectedItem().equals("D# MINOR") ) {
					btn_ds4.setBackground(Color.YELLOW);
					btn_fs4.setBackground(Color.YELLOW);
					btn_as4.setBackground(Color.YELLOW);
			}
				if (combobox_chords.getSelectedItem().equals("E MAJOR") ) {
					btn_e4.setBackground(Color.YELLOW);
					btn_gs4.setBackground(Color.YELLOW);
					btn_b4.setBackground(Color.YELLOW);
			}
				if (combobox_chords.getSelectedItem().equals("E MINOR") ) {
					btn_e4.setBackground(Color.YELLOW);
					btn_g4.setBackground(Color.YELLOW);
					btn_b4.setBackground(Color.YELLOW);
			}
				if (combobox_chords.getSelectedItem().equals("G MAJOR") ) {
					btn_g4.setBackground(Color.YELLOW);
					btn_b4.setBackground(Color.YELLOW);
					btn_d5.setBackground(Color.YELLOW);
			}
				if (combobox_chords.getSelectedItem().equals("G MINOR") ) {
					btn_g4.setBackground(Color.YELLOW);
					btn_as4.setBackground(Color.YELLOW);
					btn_d5.setBackground(Color.YELLOW);
			}
				if (combobox_chords.getSelectedItem().equals("G# MAJOR") ) {
					btn_gs4.setBackground(Color.YELLOW);
					btn_c5.setBackground(Color.YELLOW);
					btn_ds5.setBackground(Color.YELLOW);
			}
				if (combobox_chords.getSelectedItem().equals("A MAJOR") ) {
					btn_a4.setBackground(Color.YELLOW);
					btn_cs5.setBackground(Color.YELLOW);
					btn_e5.setBackground(Color.YELLOW);
				}
				if (combobox_chords.getSelectedItem().equals("A MINOR") ) {
					btn_a4.setBackground(Color.YELLOW);
					btn_c5.setBackground(Color.YELLOW);
					btn_e5.setBackground(Color.YELLOW);
				}
				if (combobox_chords.getSelectedItem().equals("A# MAJOR") ) {
					btn_as4.setBackground(Color.YELLOW);
					btn_d5.setBackground(Color.YELLOW);
					btn_f5.setBackground(Color.YELLOW);
				}
				if (combobox_chords.getSelectedItem().equals("A# MINOR") ) {
					btn_as4.setBackground(Color.YELLOW);
					btn_cs5.setBackground(Color.YELLOW);
					btn_f5.setBackground(Color.YELLOW);
				}
				if (combobox_chords.getSelectedItem().equals("B MAJOR") ) {
					btn_b4.setBackground(Color.YELLOW);
					btn_ds5.setBackground(Color.YELLOW);
					btn_fs5.setBackground(Color.YELLOW);
				}
				if (combobox_chords.getSelectedItem().equals("B MINOR") ) {
					btn_b4.setBackground(Color.YELLOW);
					btn_d5.setBackground(Color.YELLOW);
					btn_fs5.setBackground(Color.YELLOW);
				}
			}
		});
		btn_showkey.setFont(new Font("Vineta BT", Font.PLAIN, 13));
		btn_showkey.setBounds(38, 141, 165, 25);
		panel_assist1.add(btn_showkey);
		
		JButton btn_normalkey = new JButton("SET KEY TO NORMAL COLOR");
		btn_normalkey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn_c4.setBackground(Color.WHITE);
				btn_d4.setBackground(Color.WHITE);
				btn_c6.setBackground(Color.WHITE);
				btn_cs4.setBackground(Color.BLACK);
				btn_ds4.setBackground(Color.BLACK);
				btn_e4.setBackground(Color.WHITE);
				btn_f4.setBackground(Color.WHITE);
				btn_fs4.setBackground(Color.BLACK);
				btn_g4.setBackground(Color.WHITE);
				btn_gs4.setBackground(Color.BLACK);
				btn_a4.setBackground(Color.WHITE);
				btn_as4.setBackground(Color.BLACK);
				btn_b4.setBackground(Color.WHITE);
				btn_c5.setBackground(Color.WHITE);
				btn_cs5.setBackground(Color.BLACK);
				btn_d5.setBackground(Color.WHITE);
				btn_ds5.setBackground(Color.BLACK);
				btn_e5.setBackground(Color.WHITE);
				btn_f5.setBackground(Color.WHITE);
				btn_fs5.setBackground(Color.BLACK);
				btn_g5.setBackground(Color.WHITE);
				btn_gs5.setBackground(Color.BLACK);
				btn_a5.setBackground(Color.WHITE);
				btn_as5.setBackground(Color.BLACK);
				btn_b5.setBackground(Color.WHITE);
				btn_c6.setBackground(Color.WHITE);
			}
		});
		btn_normalkey.setFont(new Font("Vineta BT", Font.PLAIN, 13));
		btn_normalkey.setBounds(38, 187, 362, 25);
		panel_assist1.add(btn_normalkey);
		
		JButton btn_keybrd = new JButton("SHOW KEYBOARD KEYS");
		btn_keybrd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn_c4.setText("Q");
				btn_d4.setText("W");
				btn_c6.setText("Q");
				btn_cs4.setText("2");
				btn_ds4.setText("3");
				btn_e4.setText("E");
				btn_f4.setText("R");
				btn_fs4.setText("5");
				btn_g4.setText("T");
				btn_gs4.setText("6");
				btn_a4.setText("Y");
				btn_as4.setText("7");
				btn_b4.setText("U");
				btn_c5.setText("I/C");
				btn_cs5.setText("F");
				btn_d5.setText("V");
				btn_ds5.setText("G");
				btn_e5.setText("B");
				btn_f5.setText("N");
				btn_fs5.setText("J");
				btn_g5.setText("M");
				btn_gs5.setText("K");
				btn_a5.setText(",");
				btn_as5.setText("L");
				btn_b5.setText(".");
				btn_c6.setText("/");
			}
		});
		btn_keybrd.setFont(new Font("Vineta BT", Font.PLAIN, 13));
		btn_keybrd.setBounds(733, 80, 325, 25);
		panel_assist1.add(btn_keybrd);
		
		JButton btnShowPianoKeys = new JButton("SHOW PIANO KEYS");
		btnShowPianoKeys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn_c4.setText("C4");
				btn_d4.setText("D4");
				btn_cs4.setText("C#");
				btn_ds4.setText("D#");
				btn_e4.setText("E4");
				btn_f4.setText("F4");
				btn_fs4.setText("F#");
				btn_g4.setText("G4");
				btn_gs4.setText("G#");
				btn_a4.setText("A4");
				btn_as4.setText("A#");
				btn_b4.setText("B4");
				btn_c5.setText("C5");
				btn_cs5.setText("C#");
				btn_d5.setText("D5");
				btn_ds5.setText("D#");
				btn_e5.setText("E5");
				btn_f5.setText("F5");
				btn_fs5.setText("F#");
				btn_g5.setText("G5");
				btn_gs5.setText("G#");
				btn_a5.setText("A5");
				btn_as5.setText("A#");
				btn_b5.setText("B5");
				btn_c6.setText("C6");
			}
		});
		btnShowPianoKeys.setFont(new Font("Vineta BT", Font.PLAIN, 13));
		btnShowPianoKeys.setBounds(760, 118, 257, 25);
		panel_assist1.add(btnShowPianoKeys);
		
		JLabel lbl_keybrd = new JLabel("KEY-GUIDER");
		lbl_keybrd.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_keybrd.setFont(new Font("Vineta BT", Font.BOLD, 15));
		lbl_keybrd.setBounds(775, 13, 242, 64);
		panel_assist1.add(lbl_keybrd);
		
		JButton btnKeyboardLayout = new JButton("KEYBOARD LAYOUT");
		btnKeyboardLayout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				keyboard_layout a = new keyboard_layout();
				a.setVisible(true);
			}
		});
		btnKeyboardLayout.setFont(new Font("Vineta BT", Font.PLAIN, 13));
		btnKeyboardLayout.setBounds(747, 215, 311, 25);
		panel_assist1.add(btnKeyboardLayout);
		
		JLabel lblKeyboardLayout = new JLabel("KEYBOARD LAYOUT");
		lblKeyboardLayout.setHorizontalAlignment(SwingConstants.CENTER);
		lblKeyboardLayout.setFont(new Font("Vineta BT", Font.BOLD, 15));
		lblKeyboardLayout.setBounds(760, 148, 281, 64);
		panel_assist1.add(lblKeyboardLayout);
		
		btn_pianoplayer = new JButton("PIANO PLAYER");
		btn_pianoplayer.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				//C4
				if (e.getKeyCode() == KeyEvent.VK_Q) {
					noteID = 40;
					noteName = "C4";
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\C3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
				
				//C#4
				if (e.getKeyCode() == KeyEvent.VK_2) {
					noteID = 41;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\C3#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				} 
				
				//D4
				if (e.getKeyCode() == KeyEvent.VK_W) {
					noteID = 42;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\D3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//D#4	
				if (e.getKeyCode() == KeyEvent.VK_3) {
					noteID = 43;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\D3#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();		
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				} 
				
				//E4
				if (e.getKeyCode() == KeyEvent.VK_E) {
					noteID = 44;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\E3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();		
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//F4
				if (e.getKeyCode() == KeyEvent.VK_R) {
					noteID = 45;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\F3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//F#4
				if (e.getKeyCode() == KeyEvent.VK_5) {
					noteID = 46;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\F3#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();		
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
				
				//G4
				if (e.getKeyCode() == KeyEvent.VK_6) {
					noteID = 47;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\G3#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
				
				//G#4
				if (e.getKeyCode() == KeyEvent.VK_T) {
					noteID = 48;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\G3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//A4
				if (e.getKeyCode() == KeyEvent.VK_Y) {
					noteID = 49;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\A3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 	
				}
				
				//A#4
				if (e.getKeyCode() == KeyEvent.VK_7) {
					noteID = 50;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\A3#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}
					
				}
				
				//B4
				if (e.getKeyCode() == KeyEvent.VK_U) {
					noteID = 51;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\B3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//C5
				if (e.getKeyCode() == KeyEvent.VK_I) {
					noteID = 52;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\C4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//C#5
				if (e.getKeyCode() == KeyEvent.VK_C) {
					noteID = 52;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\C4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//D5
				if (e.getKeyCode() == KeyEvent.VK_V) {
					noteID = 54;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\D4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//D#5
				if (e.getKeyCode() == KeyEvent.VK_B) {
					noteID = 56;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\E4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//E5
				if (e.getKeyCode() == KeyEvent.VK_N) {
					noteID = 57;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\F4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//F5
				if (e.getKeyCode() == KeyEvent.VK_M) {
					noteID = 59;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\G4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//F#5
				if (e.getKeyCode() == KeyEvent.VK_COMMA) {
					noteID = 61;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\A4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//G5
				if (e.getKeyCode() == KeyEvent.VK_PERIOD) {
					noteID = 63;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\B4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//G#5
				if (e.getKeyCode() == KeyEvent.VK_SLASH) {
					noteID = 64;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\C5.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 	
				}
					//A5
					if (e.getKeyCode() == KeyEvent.VK_F) {
						noteID = 53;
						try{
							AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\C4#.wav"));
							Clip clip = AudioSystem.getClip();
							clip.open(audioInputStream);
							clip.start();	
					}
						catch(Exception ex) {
							ex.printStackTrace();
						} 
					}
					
					//A#5
						if (e.getKeyCode() == KeyEvent.VK_G) {
							noteID = 55;
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\D4#.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
						}
							catch(Exception ex) {
								ex.printStackTrace();
							}  
						}
						
						//B5
							if (e.getKeyCode() == KeyEvent.VK_J) {
								noteID = 58;
								try{
									AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\F4#.wav"));
									Clip clip = AudioSystem.getClip();
									clip.open(audioInputStream);
									clip.start();	
							}
								catch(Exception ex) {
									ex.printStackTrace();
								} 
							}
							
							//C6
							if (e.getKeyCode() == KeyEvent.VK_K) {
								noteID = 60;
									try{
										AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\G4#.wav"));
										Clip clip = AudioSystem.getClip();
										clip.open(audioInputStream);
										clip.start();
										
										
								}
									catch(Exception ex) {
										ex.printStackTrace();
									}
									}
									if (e.getKeyCode() == KeyEvent.VK_L) {
										noteID = 62;
										try{
											AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\A4#.wav"));
											Clip clip = AudioSystem.getClip();
											clip.open(audioInputStream);
											clip.start();
											
											
									}
										catch(Exception ex) {
											ex.printStackTrace();
										} 
					
					
									}
				}
			
		});
		btn_pianoplayer.setFont(new Font("Vineta BT", Font.PLAIN, 13));
		btn_pianoplayer.setBounds(307, 79, 325, 25);
		panel_assist1.add(btn_pianoplayer);
		
		btn_chordanalyzer = new JButton("CHORD ANALYZER");
		btn_chordanalyzer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MC.EnableThis(true);
			}
		});
		btn_chordanalyzer.setFont(new Font("Vineta BT", Font.PLAIN, 13));
		btn_chordanalyzer.setBounds(38, 225, 325, 25);
		panel_assist1.add(btn_chordanalyzer);
		
		btn_minueting = new JButton("MINUET IN G ");
		btn_minueting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try{
						text_freq.setText("Fs = 90000 Hz");
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Minuet in G.wav"));
						Clip clip = AudioSystem.getClip();								
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		btn_minueting.setFont(new Font("Vineta BT", Font.PLAIN, 13));
		btn_minueting.setBounds(307, 118, 325, 25);
		panel_assist1.add(btn_minueting);
		
		JPanel panel_assist2 = new JPanel();
		panel_assist2.setBackground(SystemColor.activeCaptionBorder);
		tabbedPane.addTab("DUAL", null, panel_assist2, null);
		panel_assist2.setLayout(null);
		
		JLabel lblthOctave = new JLabel("4TH OCTAVE");
		lblthOctave.setHorizontalAlignment(SwingConstants.CENTER);
		lblthOctave.setFont(new Font("Vineta BT", Font.BOLD, 15));
		lblthOctave.setBounds(57, 31, 242, 64);
		panel_assist2.add(lblthOctave);
		
		JLabel lblthOctave_1 = new JLabel("5TH OCTAVE");
		lblthOctave_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblthOctave_1.setFont(new Font("Vineta BT", Font.BOLD, 15));
		lblthOctave_1.setBounds(780, 31, 242, 64);
		panel_assist2.add(lblthOctave_1);
		
		JButton btn_buzz4th = new JButton("BUZZER SOUND");
		btn_buzz4th.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_C) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\C4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				if (e.getKeyCode() == KeyEvent.VK_V) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\D4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				if (e.getKeyCode() == KeyEvent.VK_B) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\E4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}catch(Exception ex) {
						ex.printStackTrace();
					} 
					
				} if (e.getKeyCode() == KeyEvent.VK_N) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\F4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				if (e.getKeyCode() == KeyEvent.VK_M) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\G4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				if (e.getKeyCode() == KeyEvent.VK_COMMA) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\A4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				if (e.getKeyCode() == KeyEvent.VK_PERIOD) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\B4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}catch(Exception ex) {
						ex.printStackTrace();
					} 	
				}
				if (e.getKeyCode() == KeyEvent.VK_SLASH) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\C5.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}catch(Exception ex) {
						ex.printStackTrace();
					}  
				}
					if (e.getKeyCode() == KeyEvent.VK_F) {
						try{
							AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\C4#.wav"));
							Clip clip = AudioSystem.getClip();
							clip.open(audioInputStream);
							clip.start();	
					}catch(Exception ex) {
							ex.printStackTrace();
						} 
					}
						if (e.getKeyCode() == KeyEvent.VK_G) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\D4#.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}  
						}
							if (e.getKeyCode() == KeyEvent.VK_J) {
								try{
									AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\F4#.wav"));
									Clip clip = AudioSystem.getClip();
									clip.open(audioInputStream);
									clip.start();		
							}catch(Exception ex) {
									ex.printStackTrace();
								} 
							} if (e.getKeyCode() == KeyEvent.VK_K) {
									try{
										AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\G4#.wav"));
										Clip clip = AudioSystem.getClip();
										clip.open(audioInputStream);
										clip.start();		
								}catch(Exception ex) {
										ex.printStackTrace();
									} }
									if (e.getKeyCode() == KeyEvent.VK_L) {
										try{
											AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\A4#.wav"));
											Clip clip = AudioSystem.getClip();
											clip.open(audioInputStream);
											clip.start();		
									}
										catch(Exception ex) {
											ex.printStackTrace();
										} 
										
										
									}
				if (e.getKeyCode() == KeyEvent.VK_Q) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octave\\c4buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_W) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octave\\d4buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_E) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octave\\e4buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				} if (e.getKeyCode() == KeyEvent.VK_R) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octave\\f4buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				
				if (e.getKeyCode() == KeyEvent.VK_T) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octave\\g4buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_Y) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octave\\a4buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_U) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octave\\b4buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_I) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\c5buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}  
					
				}if (e.getKeyCode() == KeyEvent.VK_2) {
						try{
							AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octaveshp\\c4#buzz.wav"));
							Clip clip = AudioSystem.getClip();
							clip.open(audioInputStream);
							clip.start();
							
							
					}
						catch(Exception ex) {
							ex.printStackTrace();
						} 
					}
						if (e.getKeyCode() == KeyEvent.VK_3) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octaveshp\\d4#buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
								
								
						}
							catch(Exception ex) {
								ex.printStackTrace();
							}  
						}
							if (e.getKeyCode() == KeyEvent.VK_5) {
								try{
									AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octaveshp\\f4#buzz.wav"));
									Clip clip = AudioSystem.getClip();
									clip.open(audioInputStream);
									clip.start();
									
									
							}
								catch(Exception ex) {
									ex.printStackTrace();
								} 
							} if (e.getKeyCode() == KeyEvent.VK_6) {
									try{
										AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octaveshp\\g4#buzz.wav"));
										Clip clip = AudioSystem.getClip();
										clip.open(audioInputStream);
										clip.start();
										
										
								}
									catch(Exception ex) {
										ex.printStackTrace();
									} }
									if (e.getKeyCode() == KeyEvent.VK_7) {
										try{
											AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octaveshp\\a4#buzz.wav"));
											Clip clip = AudioSystem.getClip();
											clip.open(audioInputStream);
											clip.start();
											
											
									}
										catch(Exception ex) {
											ex.printStackTrace();
										} 
									}
				}
			
		});
		btn_buzz4th.setFont(new Font("Vineta BT", Font.PLAIN, 13));
		btn_buzz4th.setBounds(34, 104, 325, 25);
		panel_assist2.add(btn_buzz4th);
		
		JButton btn_buzz5th = new JButton("BUZZER SOUND");
		btn_buzz5th.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_Q) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\C3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}
					
				}if (e.getKeyCode() == KeyEvent.VK_2) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\C3#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}
					
				} if (e.getKeyCode() == KeyEvent.VK_W) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\D3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}if (e.getKeyCode() == KeyEvent.VK_3) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\D3#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}
					
				} if (e.getKeyCode() == KeyEvent.VK_E) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\E3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_R) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\F3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_5) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\F3#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}
					
				} if (e.getKeyCode() == KeyEvent.VK_6) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\G3#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}
					
				} if (e.getKeyCode() == KeyEvent.VK_T) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\G3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_Y) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\A3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				} if (e.getKeyCode() == KeyEvent.VK_7) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\A3#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}
					
				}
				if (e.getKeyCode() == KeyEvent.VK_U) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\B3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_I) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\C4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				} 
				if (e.getKeyCode() == KeyEvent.VK_C) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\c5buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_V) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\d5buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_B) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\e5buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				} if (e.getKeyCode() == KeyEvent.VK_N) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\f5buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				
				if (e.getKeyCode() == KeyEvent.VK_M) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\g5buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_COMMA) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\a5buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_PERIOD) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\b5buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_SLASH) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\c6buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}  
					
				}if (e.getKeyCode() == KeyEvent.VK_F) {
						try{
							AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\c5#buzz.wav"));
							Clip clip = AudioSystem.getClip();
							clip.open(audioInputStream);
							clip.start();
							
							
					}
						catch(Exception ex) {
							ex.printStackTrace();
						} 
					}
						if (e.getKeyCode() == KeyEvent.VK_G) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\d5#buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
								
								
						}
							catch(Exception ex) {
								ex.printStackTrace();
							}  
						}
							if (e.getKeyCode() == KeyEvent.VK_J) {
								try{
									AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\f5#buzz.wav"));
									Clip clip = AudioSystem.getClip();
									clip.open(audioInputStream);
									clip.start();
									
									
							}
								catch(Exception ex) {
									ex.printStackTrace();
								} 
							} if (e.getKeyCode() == KeyEvent.VK_K) {
									try{
										AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\g5#buzz.wav"));
										Clip clip = AudioSystem.getClip();
										clip.open(audioInputStream);
										clip.start();
										
										
								}
									catch(Exception ex) {
										ex.printStackTrace();
									} }
									if (e.getKeyCode() == KeyEvent.VK_L) {
										try{
											AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\a5#buzz.wav"));
											Clip clip = AudioSystem.getClip();
											clip.open(audioInputStream);
											clip.start();
											
											
									}
										catch(Exception ex) {
											ex.printStackTrace();
										} 
									}
				}
			
		});
		btn_buzz5th.setFont(new Font("Vineta BT", Font.PLAIN, 13));
		btn_buzz5th.setBounds(744, 104, 325, 25);
		panel_assist2.add(btn_buzz5th);
		
		JButton btnNormalPianoSound = new JButton("FULL PIANO SOUND");
		btnNormalPianoSound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn_c4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\C3.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});

		btn_cs4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\C3#.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_d4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\D3.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}	
					}
				});
		btn_ds4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\D3#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		btn_e4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\E3.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_f4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\F3.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_fs4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\F3#.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}	
					}
				});
		btn_g4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\G3.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();		
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_gs4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\G3#.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_a4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\A3.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_as4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\A3#.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
						}
							catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_b4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\B3.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}	
					}
				});
		btn_c5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\C4.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}	
					}
				});
		btn_cs5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\C4#.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_d5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\D4.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}	
					}
				});
		btn_ds5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\D4#.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_e5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\E4.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_f5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\F4.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_fs5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\F4#.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_g5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\G4.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}	
					}
				});
		btn_gs5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\G4#.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}
							catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_a5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\A4.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_as5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\A4#.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
						}
							catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_b5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\B4.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_c6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th Octave\\C5.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
			}
		});
		btnNormalPianoSound.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				//C4
				if (e.getKeyCode() == KeyEvent.VK_Q) {
					noteID = 40;
					noteName = "C4";
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\C3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
				
				//C#4
				if (e.getKeyCode() == KeyEvent.VK_2) {
					noteID = 41;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\C3#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				} 
				
				//D4
				if (e.getKeyCode() == KeyEvent.VK_W) {
					noteID = 42;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\D3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//D#4	
				if (e.getKeyCode() == KeyEvent.VK_3) {
					noteID = 43;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\D3#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();		
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				} 
				
				//E4
				if (e.getKeyCode() == KeyEvent.VK_E) {
					noteID = 44;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\E3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();		
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//F4
				if (e.getKeyCode() == KeyEvent.VK_R) {
					noteID = 45;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\F3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//F#4
				if (e.getKeyCode() == KeyEvent.VK_5) {
					noteID = 46;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\F3#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();		
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
				
				//G4
				if (e.getKeyCode() == KeyEvent.VK_6) {
					noteID = 47;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\G3#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
				
				//G#4
				if (e.getKeyCode() == KeyEvent.VK_T) {
					noteID = 48;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\G3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//A4
				if (e.getKeyCode() == KeyEvent.VK_Y) {
					noteID = 49;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\A3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 	
				}
				
				//A#4
				if (e.getKeyCode() == KeyEvent.VK_7) {
					noteID = 50;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\A3#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}
					
				}
				
				//B4
				if (e.getKeyCode() == KeyEvent.VK_U) {
					noteID = 51;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\B3.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//C5
				if (e.getKeyCode() == KeyEvent.VK_I) {
					noteID = 52;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\C4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//C#5
				if (e.getKeyCode() == KeyEvent.VK_C) {
					noteID = 52;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\C4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//D5
				if (e.getKeyCode() == KeyEvent.VK_V) {
					noteID = 54;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\D4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//D#5
				if (e.getKeyCode() == KeyEvent.VK_B) {
					noteID = 56;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\E4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//E5
				if (e.getKeyCode() == KeyEvent.VK_N) {
					noteID = 57;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\F4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//F5
				if (e.getKeyCode() == KeyEvent.VK_M) {
					noteID = 59;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\G4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//F#5
				if (e.getKeyCode() == KeyEvent.VK_COMMA) {
					noteID = 61;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\A4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//G5
				if (e.getKeyCode() == KeyEvent.VK_PERIOD) {
					noteID = 63;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\B4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//G#5
				if (e.getKeyCode() == KeyEvent.VK_SLASH) {
					noteID = 64;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\C5.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 	
				}
					//A5
					if (e.getKeyCode() == KeyEvent.VK_F) {
						noteID = 53;
						try{
							AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\C4#.wav"));
							Clip clip = AudioSystem.getClip();
							clip.open(audioInputStream);
							clip.start();	
					}
						catch(Exception ex) {
							ex.printStackTrace();
						} 
					}
					
					//A#5
						if (e.getKeyCode() == KeyEvent.VK_G) {
							noteID = 55;
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\D4#.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
						}
							catch(Exception ex) {
								ex.printStackTrace();
							}  
						}
						
						//B5
							if (e.getKeyCode() == KeyEvent.VK_J) {
								noteID = 58;
								try{
									AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\F4#.wav"));
									Clip clip = AudioSystem.getClip();
									clip.open(audioInputStream);
									clip.start();	
							}
								catch(Exception ex) {
									ex.printStackTrace();
								} 
							}
							
							//C6
							if (e.getKeyCode() == KeyEvent.VK_K) {
								noteID = 60;
									try{
										AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\G4#.wav"));
										Clip clip = AudioSystem.getClip();
										clip.open(audioInputStream);
										clip.start();
										
										
								}
									catch(Exception ex) {
										ex.printStackTrace();
									}
									}
									if (e.getKeyCode() == KeyEvent.VK_L) {
										noteID = 62;
										try{
											AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\A4#.wav"));
											Clip clip = AudioSystem.getClip();
											clip.open(audioInputStream);
											clip.start();
											
											
									}
										catch(Exception ex) {
											ex.printStackTrace();
										} 
					
					
									}
				}
			
		});
		btnNormalPianoSound.setFont(new Font("Vineta BT", Font.PLAIN, 13));
		btnNormalPianoSound.setBounds(386, 164, 325, 25);
		panel_assist2.add(btnNormalPianoSound);
		
		btn_buzzersound = new JButton("FULL BUZZER SOUND");
		btn_buzzersound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn_c4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octave\\c4buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});

		btn_cs4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octaveshp\\c4#buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_d4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octave\\d4buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}	
					}
				});
		btn_ds4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octaveshp\\d4#buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		btn_e4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octave\\e4buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_f4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octave\\f4buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_fs4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octaveshp\\f4#buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}	
					}
				});
		btn_g4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octave\\g4buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();		
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_gs4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octaveshp\\g4#buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_a4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octave\\a4buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_as4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octaveshp\\a4#buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
						}
							catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_b4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octave\\b4buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}	
					}
				});
		btn_c5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\c5buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}	
					}
				});
		btn_cs5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\c5#buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_d5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\d5buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}	
					}
				});
		btn_ds5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\d5#buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_e5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\e5buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_f5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\f5buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_fs5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\f5#buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_g5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\g5buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}	
					}
				});
		btn_gs5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\g5#buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}
							catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_a5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\a5buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_as5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\a5#buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
						}
							catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_b5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\b5buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
		btn_c6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\c6buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}
					}
				});
			}
		});
		btn_buzzersound.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_Q) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octave\\c4buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_W) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octave\\d4buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_E) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octave\\e4buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				} if (e.getKeyCode() == KeyEvent.VK_R) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octave\\f4buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				
				if (e.getKeyCode() == KeyEvent.VK_T) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octave\\g4buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_Y) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octave\\a4buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_U) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octave\\b4buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_I) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\c5buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}  
					
				}if (e.getKeyCode() == KeyEvent.VK_2) {
						try{
							AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octaveshp\\c4#buzz.wav"));
							Clip clip = AudioSystem.getClip();
							clip.open(audioInputStream);
							clip.start();
							
							
					}
						catch(Exception ex) {
							ex.printStackTrace();
						} 
					}
						if (e.getKeyCode() == KeyEvent.VK_3) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octaveshp\\d4#buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
								
								
						}
							catch(Exception ex) {
								ex.printStackTrace();
							}  
						}
							if (e.getKeyCode() == KeyEvent.VK_5) {
								try{
									AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octaveshp\\f4#buzz.wav"));
									Clip clip = AudioSystem.getClip();
									clip.open(audioInputStream);
									clip.start();
									
									
							}
								catch(Exception ex) {
									ex.printStackTrace();
								} 
							} if (e.getKeyCode() == KeyEvent.VK_6) {
									try{
										AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octaveshp\\g4#buzz.wav"));
										Clip clip = AudioSystem.getClip();
										clip.open(audioInputStream);
										clip.start();
										
										
								}
									catch(Exception ex) {
										ex.printStackTrace();
									} }
									if (e.getKeyCode() == KeyEvent.VK_7) {
										try{
											AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 4th Octaveshp\\a4#buzz.wav"));
											Clip clip = AudioSystem.getClip();
											clip.open(audioInputStream);
											clip.start();
											
											
									}
										catch(Exception ex) {
											ex.printStackTrace();
										} 
									}
				if (e.getKeyCode() == KeyEvent.VK_C) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\c5buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_V) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\d5buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_B) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\e5buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				} if (e.getKeyCode() == KeyEvent.VK_N) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\f5buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				
				if (e.getKeyCode() == KeyEvent.VK_M) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\g5buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_COMMA) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\a5buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_PERIOD) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\b5buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_SLASH) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\c6buzz.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}  
					
				}if (e.getKeyCode() == KeyEvent.VK_F) {
						try{
							AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\c5#buzz.wav"));
							Clip clip = AudioSystem.getClip();
							clip.open(audioInputStream);
							clip.start();
							
							
					}
						catch(Exception ex) {
							ex.printStackTrace();
						} 
					}
						if (e.getKeyCode() == KeyEvent.VK_G) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\d5#buzz.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
								
								
						}
							catch(Exception ex) {
								ex.printStackTrace();
							}  
						}
							if (e.getKeyCode() == KeyEvent.VK_J) {
								try{
									AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\f5#buzz.wav"));
									Clip clip = AudioSystem.getClip();
									clip.open(audioInputStream);
									clip.start();
									
									
							}
								catch(Exception ex) {
									ex.printStackTrace();
								} 
							} if (e.getKeyCode() == KeyEvent.VK_K) {
									try{
										AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\g5#buzz.wav"));
										Clip clip = AudioSystem.getClip();
										clip.open(audioInputStream);
										clip.start();
										
										
								}
									catch(Exception ex) {
										ex.printStackTrace();
									} }
									if (e.getKeyCode() == KeyEvent.VK_L) {
										try{
											AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Users\\Asus\\Documents\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Buzz 5th Octave\\a5#buzz.wav"));
											Clip clip = AudioSystem.getClip();
											clip.open(audioInputStream);
											clip.start();
											
											
									}
										catch(Exception ex) {
											ex.printStackTrace();
										} 
									}
				}
			
		});
		btn_buzzersound.setFont(new Font("Vineta BT", Font.PLAIN, 13));
		btn_buzzersound.setBounds(386, 50, 325, 25);
		panel_assist2.add(btn_buzzersound);
		
		JButton btn_steeldrums = new JButton("STEEL DRUMS");
		btn_steeldrums.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_C) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\C4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				if (e.getKeyCode() == KeyEvent.VK_V) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\D4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				if (e.getKeyCode() == KeyEvent.VK_B) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\E4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}catch(Exception ex) {
						ex.printStackTrace();
					} 
					
				} if (e.getKeyCode() == KeyEvent.VK_N) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\F4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				if (e.getKeyCode() == KeyEvent.VK_M) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\G4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				if (e.getKeyCode() == KeyEvent.VK_COMMA) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\A4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				if (e.getKeyCode() == KeyEvent.VK_PERIOD) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\B4.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}catch(Exception ex) {
						ex.printStackTrace();
					} 	
				}
				if (e.getKeyCode() == KeyEvent.VK_SLASH) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\C5.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
				}catch(Exception ex) {
						ex.printStackTrace();
					}  
				}
					if (e.getKeyCode() == KeyEvent.VK_F) {
						try{
							AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\C4#.wav"));
							Clip clip = AudioSystem.getClip();
							clip.open(audioInputStream);
							clip.start();	
					}catch(Exception ex) {
							ex.printStackTrace();
						} 
					}
						if (e.getKeyCode() == KeyEvent.VK_G) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\D4#.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}catch(Exception ex) {
								ex.printStackTrace();
							}  
						}
							if (e.getKeyCode() == KeyEvent.VK_J) {
								try{
									AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\F4#.wav"));
									Clip clip = AudioSystem.getClip();
									clip.open(audioInputStream);
									clip.start();		
							}catch(Exception ex) {
									ex.printStackTrace();
								} 
							} if (e.getKeyCode() == KeyEvent.VK_K) {
									try{
										AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\G4#.wav"));
										Clip clip = AudioSystem.getClip();
										clip.open(audioInputStream);
										clip.start();		
								}catch(Exception ex) {
										ex.printStackTrace();
									} }
									if (e.getKeyCode() == KeyEvent.VK_L) {
										try{
											AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\A4#.wav"));
											Clip clip = AudioSystem.getClip();
											clip.open(audioInputStream);
											clip.start();		
									}
										catch(Exception ex) {
											ex.printStackTrace();
										} 
										
										
									}
				if (e.getKeyCode() == KeyEvent.VK_Q) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Drums\\C_Drum.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_W) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Drums\\D_Drum.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_E) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Drums\\E_Drum.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				} if (e.getKeyCode() == KeyEvent.VK_R) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Drums\\F_Drum.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				
				if (e.getKeyCode() == KeyEvent.VK_T) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Drums\\G_Drum.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_Y) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Drums\\A_Drum.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_U) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Drums\\B_Drum.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
					
					
				}
				if (e.getKeyCode() == KeyEvent.VK_I) {
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Drums\\C1_Drum.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
						
						
				}
					catch(Exception ex) {
						ex.printStackTrace();
					}  
					
				}if (e.getKeyCode() == KeyEvent.VK_2) {
						try{
							AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Drums\\Cq_Drum.wav"));
							Clip clip = AudioSystem.getClip();
							clip.open(audioInputStream);
							clip.start();
							
							
					}
						catch(Exception ex) {
							ex.printStackTrace();
						} 
					}
						if (e.getKeyCode() == KeyEvent.VK_3) {
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Drums\\Dq_Drum.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
								
								
						}
							catch(Exception ex) {
								ex.printStackTrace();
							}  
						}
							if (e.getKeyCode() == KeyEvent.VK_5) {
								try{
									AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Drums\\Fq_Drum.wav"));
									Clip clip = AudioSystem.getClip();
									clip.open(audioInputStream);
									clip.start();
									
									
							}
								catch(Exception ex) {
									ex.printStackTrace();
								} 
							} if (e.getKeyCode() == KeyEvent.VK_6) {
									try{
										AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Drums\\Gq_Drum.wav"));
										Clip clip = AudioSystem.getClip();
										clip.open(audioInputStream);
										clip.start();
										
										
								}
									catch(Exception ex) {
										ex.printStackTrace();
									} }
									
				}
			
		});
		btn_steeldrums.setFont(new Font("Vineta BT", Font.PLAIN, 13));
		btn_steeldrums.setBounds(34, 142, 325, 25);
		panel_assist2.add(btn_steeldrums);
		Image img2 = new ImageIcon(this.getClass().getResource("Keyboard position.png")).getImage();
		
		JLabel lblVirtualKeyboard = new JLabel("VIRTUAL KEYBOARD");
		lblVirtualKeyboard.setFont(new Font("Vineta BT", Font.BOLD, 25));
		lblVirtualKeyboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblVirtualKeyboard.setBounds(313, 13, 472, 64);
		panel_main.add(lblVirtualKeyboard);
		
		text_freq = new JTextField();
		text_freq.setFont(new Font("Vineta BT", Font.BOLD, 15));
		text_freq.setEditable(false);
		text_freq.setBounds(974, 438, 190, 43);
		panel_main.add(text_freq);
		text_freq.setColumns(10);
		
		JLabel lblPianoFrequency = new JLabel("Piano Frequency");
		lblPianoFrequency.setHorizontalAlignment(SwingConstants.CENTER);
		lblPianoFrequency.setFont(new Font("Vineta BT", Font.PLAIN, 13));
		lblPianoFrequency.setBounds(974, 387, 177, 54);
		panel_main.add(lblPianoFrequency);
		
		JLabel lbl_wavlength = new JLabel("Wavelength");
		lbl_wavlength.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_wavlength.setFont(new Font("Vineta BT", Font.PLAIN, 13));
		lbl_wavlength.setBounds(974, 497, 177, 54);
		panel_main.add(lbl_wavlength);
		
		text_wavlength = new JTextField();
		text_wavlength.setFont(new Font("Vineta BT", Font.BOLD, 15));
		text_wavlength.setEditable(false);
		text_wavlength.setColumns(10);
		text_wavlength.setBounds(974, 548, 177, 43);
		panel_main.add(text_wavlength);
		
		btn_d4.addKeyListener(this);
		btn_c6.addKeyListener(this);
		btn_cs4.addKeyListener(this);
		btn_ds4.addKeyListener(this);
		btn_e4.addKeyListener(this);
		btn_f4.addKeyListener(this);
		btn_fs4.addKeyListener(this);
		btn_g4.addKeyListener(this);
		btn_gs4.addKeyListener(this);
		btn_a4.addKeyListener(this);
		btn_as4.addKeyListener(this);
		btn_b4.addKeyListener(this);
		btn_c5.addKeyListener(this);
		btn_cs5.addKeyListener(this);
		btn_d5.addKeyListener(this);
		btn_ds5.addKeyListener(this);
		btn_e5.addKeyListener(this);
		btn_f5.addKeyListener(this);
		btn_fs5.addKeyListener(this);
		btn_g5.addKeyListener(this);
		btn_gs5.addKeyListener(this);
		btn_a5.addKeyListener(this);
		btn_as5.addKeyListener(this);
		btn_b5.addKeyListener(this);
		btn_c6.addKeyListener(this);
	
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			//C4
			if (e.getKeyCode() == KeyEvent.VK_Q) {
				noteID = 40;
				noteName = "C4";
				try{
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\C3.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
			}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
			
			//C#4
			if (e.getKeyCode() == KeyEvent.VK_2) {
				noteID = 41;
				try{
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\C3#.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();	
			}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			} 
			
			//D4
			if (e.getKeyCode() == KeyEvent.VK_W) {
				noteID = 42;
				try{
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\D3.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();	
			}
				catch(Exception ex) {
					ex.printStackTrace();
				} 
			}
			
			//D#4	
			if (e.getKeyCode() == KeyEvent.VK_3) {
				noteID = 43;
				try{
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\D3#.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();		
			}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			} 
			
			//E4
			if (e.getKeyCode() == KeyEvent.VK_E) {
				noteID = 44;
				try{
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\E3.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();		
			}
				catch(Exception ex) {
					ex.printStackTrace();
				} 
			}
			
			//F4
			if (e.getKeyCode() == KeyEvent.VK_R) {
				noteID = 45;
				try{
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\F3.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();	
			}
				catch(Exception ex) {
					ex.printStackTrace();
				} 
			}
			
			//F#4
			if (e.getKeyCode() == KeyEvent.VK_5) {
				noteID = 46;
				try{
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\F3#.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();		
			}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
			
			//G4
			if (e.getKeyCode() == KeyEvent.VK_6) {
				noteID = 47;
				try{
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\G3#.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
			}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
			
			//G#4
			if (e.getKeyCode() == KeyEvent.VK_T) {
				noteID = 48;
				try{
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\G3.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();	
			}
				catch(Exception ex) {
					ex.printStackTrace();
				} 
			}
			
			//A4
			if (e.getKeyCode() == KeyEvent.VK_Y) {
				noteID = 49;
				try{
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\A3.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();	
			}
				catch(Exception ex) {
					ex.printStackTrace();
				} 	
			}
			
			//A#4
			if (e.getKeyCode() == KeyEvent.VK_7) {
				noteID = 50;
				try{
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\A3#.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();	
			}
				catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
			
			//B4
			if (e.getKeyCode() == KeyEvent.VK_U) {
				noteID = 51;
				try{
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 3rd octave\\B3.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
			}
				catch(Exception ex) {
					ex.printStackTrace();
				} 
			}
			
			//C5
			if (e.getKeyCode() == KeyEvent.VK_I) {
				noteID = 52;
				try{
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\C4.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();	
			}
				catch(Exception ex) {
					ex.printStackTrace();
				} 
			}
			
			//C#5
			if (e.getKeyCode() == KeyEvent.VK_C) {
				noteID = 52;
				try{
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\C4.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();	
			}
				catch(Exception ex) {
					ex.printStackTrace();
				} 
			}
			
			//D5
			if (e.getKeyCode() == KeyEvent.VK_V) {
				noteID = 54;
				try{
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\D4.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
			}
				catch(Exception ex) {
					ex.printStackTrace();
				} 
			}
			
			//D#5
			if (e.getKeyCode() == KeyEvent.VK_B) {
				noteID = 56;
				try{
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\E4.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();	
			}
				catch(Exception ex) {
					ex.printStackTrace();
				} 
			}
			
			//E5
			if (e.getKeyCode() == KeyEvent.VK_N) {
				noteID = 57;
				try{
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\F4.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
			}
				catch(Exception ex) {
					ex.printStackTrace();
				} 
			}
			
			//F5
			if (e.getKeyCode() == KeyEvent.VK_M) {
				noteID = 59;
				try{
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\G4.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();	
			}
				catch(Exception ex) {
					ex.printStackTrace();
				} 
			}
			
			//F#5
			if (e.getKeyCode() == KeyEvent.VK_COMMA) {
				noteID = 61;
				try{
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\A4.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();	
			}
				catch(Exception ex) {
					ex.printStackTrace();
				} 
			}
			
			//G5
			if (e.getKeyCode() == KeyEvent.VK_PERIOD) {
				noteID = 63;
				try{
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\B4.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
			}
				catch(Exception ex) {
					ex.printStackTrace();
				} 
			}
			
			//G#5
			if (e.getKeyCode() == KeyEvent.VK_SLASH) {
				noteID = 64;
				try{
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\C5.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();	
			}
				catch(Exception ex) {
					ex.printStackTrace();
				} 	
			}
				//A5
				if (e.getKeyCode() == KeyEvent.VK_F) {
					noteID = 53;
					try{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\C4#.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();	
				}
					catch(Exception ex) {
						ex.printStackTrace();
					} 
				}
				
				//A#5
					if (e.getKeyCode() == KeyEvent.VK_G) {
						noteID = 55;
						try{
							AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\D4#.wav"));
							Clip clip = AudioSystem.getClip();
							clip.open(audioInputStream);
							clip.start();
					}
						catch(Exception ex) {
							ex.printStackTrace();
						}  
					}
					
					//B5
						if (e.getKeyCode() == KeyEvent.VK_J) {
							noteID = 58;
							try{
								AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\F4#.wav"));
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();	
						}
							catch(Exception ex) {
								ex.printStackTrace();
							} 
						}
						
						//C6
						if (e.getKeyCode() == KeyEvent.VK_K) {
							noteID = 60;
								try{
									AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\G4#.wav"));
									Clip clip = AudioSystem.getClip();
									clip.open(audioInputStream);
									clip.start();
									
									
							}
								catch(Exception ex) {
									ex.printStackTrace();
								}
								}
								if (e.getKeyCode() == KeyEvent.VK_L) {
									noteID = 62;
									try{
										AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:\\Jenny's files\\2nd year\\Programming\\Signals\\Music_Note\\Piano 4th octave\\A4#.wav"));
										Clip clip = AudioSystem.getClip();
										clip.open(audioInputStream);
										clip.start();
										
										
								}
									catch(Exception ex) {
										ex.printStackTrace();
									} 
				
				
								}
			}
		


	
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
}


