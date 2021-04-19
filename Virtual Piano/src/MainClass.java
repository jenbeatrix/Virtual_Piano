import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;

public class MainClass extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private JPanel panel_main;
	private JTextField fld_key1, fld_key2, fld_key3, fld_frq1, fld_frq2, fld_frq3, fld_lmd1, fld_lmd2, fld_lmd3;
	private JButton btn_analyze, btn_clear;
	private double n;
	
	private String[] array_notes = {"C4","C#4","D4","D#4","E4","F4","F#4","G4","G#4","A4","A#4","B4","C5",
									"C#5","D5","D#5","E5","F5","F#5","G5","G#5","A5","A#5","B5","C6"};
	private double[] array_n = {40,41,42,43,44,45,46,47,48,49,
								50,51,52,53,54,55,56,57,58,59,
								60,61,62,63,64};
	private JTextField fld_Chord;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClass app = new MainClass();
					app.frame.setVisible(true);
				} catch (Exception x) {
					JOptionPane.showMessageDialog(null, x.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	public void EnableThis( boolean x) {
		frame.setVisible(x);
	}
	public void CheckInput1() {
		String given1 = fld_key1.getText();
		
		boolean found = false;
		for (String element : array_notes) {
		    if (given1.equals(element)) {
		        found = true;
		        CheckInput2();
		        break;
		    }
		} if (!found) {
			JOptionPane.showMessageDialog(null, "Invalid input 1.");
		}
	}
	
	public void CheckInput2() {
		String given2 = fld_key2.getText();
		
		boolean found = false;
		for (String element : array_notes) {
		    if (given2.equals(element)) {
		        found = true;
		        CheckInput3();
		        break;
		    }
		} if (!found) {
			JOptionPane.showMessageDialog(null, "Invalid input 2.");
		}
	}
	
	public void CheckInput3() {
		String given3 = fld_key3.getText();
		
		boolean found = false;
		for (String element : array_notes) {
		    if (given3.equals(element)) {
		        found = true;
		        EnterInfo();
		        break;
		    }
		} if (!found) {
			JOptionPane.showMessageDialog(null, "Invalid input 3.");
		}
	}
	
	public void EnterInfo() {
		String note1 = fld_key1.getText();
		String note2 = fld_key2.getText();
		String note3 = fld_key3.getText();
		
		if (note1.equals(array_notes[0])) {
			n=array_n[0];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note1.equals(array_notes[1])) {
			n=array_n[1];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note1.equals(array_notes[2])) {
			n=array_n[2];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note1.equals(array_notes[3])) {
			n=array_n[3];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note1.equals(array_notes[4])) {
			n=array_n[4];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note1.equals(array_notes[5])) {
			n=array_n[5];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note1.equals(array_notes[6])) {
			n=array_n[6];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note1.equals(array_notes[7])) {
			n=array_n[7];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note1.equals(array_notes[8])) {
			n=array_n[8];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note1.equals(array_notes[9])) {
			n=array_n[9];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note1.equals(array_notes[10])) {
			n=array_n[10];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note1.equals(array_notes[11])) {
			n=array_n[11];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note1.equals(array_notes[12])) {
			n=array_n[12];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note1.equals(array_notes[13])) {
			n=array_n[13];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note1.equals(array_notes[14])) {
			n=array_n[14];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note1.equals(array_notes[15])) {
			n=array_n[15];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note1.equals(array_notes[16])) {
			n=array_n[16];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note1.equals(array_notes[17])) {
			n=array_n[17];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note1.equals(array_notes[18])) {
			n=array_n[18];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note1.equals(array_notes[19])) {
			n=array_n[19];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note1.equals(array_notes[20])) {
			n=array_n[20];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note1.equals(array_notes[21])) {
			n=array_n[21];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note1.equals(array_notes[22])) {
			n=array_n[22];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note1.equals(array_notes[23])) {
			n=array_n[23];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note1.equals(array_notes[24])) {
			n=array_n[24];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq1.setText(Double.toString(frequency)); fld_lmd1.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[0])) {
			n=array_n[0];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[1])) {
			n=array_n[1];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[2])) {
			n=array_n[2];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[3])) {
			n=array_n[3];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[4])) {
			n=array_n[4];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[5])) {
			n=array_n[5];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[6])) {
			n=array_n[6];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[7])) {
			n=array_n[7];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[8])) {
			n=array_n[8];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[9])) {
			n=array_n[9];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[10])) {
			n=array_n[10];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[11])) {
			n=array_n[11];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[12])) {
			n=array_n[12];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[13])) {
			n=array_n[13];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[14])) {
			n=array_n[14];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[15])) {
			n=array_n[15];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[16])) {
			n=array_n[16];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[17])) {
			n=array_n[17];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[18])) {
			n=array_n[18];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[19])) {
			n=array_n[19];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[20])) {
			n=array_n[20];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[21])) {
			n=array_n[21];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[22])) {
			n=array_n[22];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[23])) {
			n=array_n[23];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note2.equals(array_notes[24])) {
			n=array_n[24];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq2.setText(Double.toString(frequency)); fld_lmd2.setText(Double.toString(wavelength));
		} if (note3.equals(array_notes[0])) {
			n=array_n[0];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		} if (note3.equals(array_notes[1])) {
			n=array_n[1];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		} if (note3.equals(array_notes[2])) {
			n=array_n[2];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		} if (note3.equals(array_notes[3])) {
			n=array_n[3];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		} if (note3.equals(array_notes[4])) {
			n=array_n[4];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		} if (note3.equals(array_notes[5])) {
			n=array_n[5];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		} if (note3.equals(array_notes[6])) {
			n=array_n[6];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		} if (note3.equals(array_notes[7])) {
			n=array_n[7];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		} if (note3.equals(array_notes[8])) {
			n=array_n[8];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		} if (note3.equals(array_notes[9])) {
			n=array_n[9];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		} if (note3.equals(array_notes[10])) {
			n=array_n[10];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		} if (note3.equals(array_notes[11])) {
			n=array_n[11];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		} if (note3.equals(array_notes[12])) {
			n=array_n[12];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		} if (note3.equals(array_notes[13])) {
			n=array_n[13];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		} if (note3.equals(array_notes[14])) {
			n=array_n[14];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		} if (note3.equals(array_notes[15])) {
			n=array_n[15];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		} if (note3.equals(array_notes[16])) {
			n=array_n[16];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		} if (note3.equals(array_notes[17])) {
			n=array_n[17];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		} if (note3.equals(array_notes[18])) {
			n=array_n[18];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		} if (note3.equals(array_notes[19])) {
			n=array_n[19];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		} if (note3.equals(array_notes[20])) {
			n=array_n[20];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		} if (note3.equals(array_notes[21])) {
			n=array_n[21];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		} if (note3.equals(array_notes[22])) {
			n=array_n[22];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		} if (note3.equals(array_notes[23])) {
			n=array_n[23];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		} if (note3.equals(array_notes[24])) {
			n=array_n[24];
			double frequency = FrequencyEquation(n); double wavelength = WavelengthEquation(n);
			fld_frq3.setText(Double.toString(frequency)); fld_lmd3.setText(Double.toString(wavelength));
			ChordVerification();
		}
	}
	
	public double FrequencyEquation(double n) {
		double frequency = 27.5*Math.pow(2.71828182, (n-1)/17.31234049);
		return frequency;
	}
	
	public double WavelengthEquation(double n) {
		double wavelength = 12.734*Math.pow(2.71828182, (1-n)/17.31234049);
		return wavelength;
	}
	
	public void ChordVerification() {
		String freq1_string = fld_frq1.getText(); String freq2_string = fld_frq2.getText(); String freq3_string = fld_frq3.getText();
		double freq1 = Double.parseDouble(freq1_string); double freq2 = Double.parseDouble(freq2_string); double freq3 = Double.parseDouble(freq3_string);
		double ratio1 = freq1/freq2; double ratio2 = freq2/freq3;
		
		if ((freq1 == freq2) && (freq1 == freq3)) {
			JOptionPane.showMessageDialog(null, "Inputs given are identical");
		} else {
			if (((ratio1 <= 0.83) && (ratio1 >= 0.78)) && ((ratio2 <= 0.85) && (ratio2 >= 0.81))) {
				fld_Chord.setText("");
				fld_Chord.setText("Major");
			} else {
				if (((ratio1 <= 0.85) && (ratio1 >= 0.81)) && ((ratio2 <= 0.83) && ( ratio2 >= 0.78))) {
					fld_Chord.setText("");
					fld_Chord.setText("Minor");
				} else {
					JOptionPane.showMessageDialog(null, "Given exceeds algorithm bounds.");
				}
			}
		}
	}
	
	public void ClearAllFields() {
		fld_key1.setText("");fld_frq1.setText("");fld_lmd1.setText("");
		fld_key2.setText("");fld_frq2.setText("");fld_lmd2.setText("");
		fld_key3.setText("");fld_frq3.setText("");fld_lmd3.setText("");
		fld_Chord.setText("");
	}
	
	public void EnterData() {
		String key1_data = fld_key1.getText();
		String key2_data = fld_key2.getText();
		String key3_data = fld_key3.getText();
		if (key1_data.equals("")||key1_data.equals(null)) {
			
		} if (key2_data.equals("")||key2_data.equals(null)) {
			
		} if (key3_data.equals("")||key3_data.equals(null)) {
			
		} else {
			JOptionPane.showMessageDialog(null, "All fields are already filled. Press CLEAR to reset.", "Input Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public MainClass() {
		frame = new JFrame();
		frame.setTitle("Major-Minor Chord Analyzer");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(500, 270, 611, 300);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
		panel_main = new JPanel();
		panel_main.setForeground(Color.BLACK);
		panel_main.setBackground(SystemColor.activeCaptionBorder);
		panel_main.setBounds(0, 0, 100, 100);
		panel_main.setLayout(null);
		frame.getContentPane().add(panel_main);
		
		fld_key1 = new JTextField();
		fld_key1.setFont(new Font("Tahoma", Font.BOLD, 13));
		fld_key1.setBounds(152, 77, 128, 24);
		panel_main.add(fld_key1);
		fld_key1.setColumns(10);
		
		fld_frq1 = new JTextField();
		fld_frq1.setFont(new Font("Tahoma", Font.BOLD, 13));
		fld_frq1.setEditable(false);
		fld_frq1.setColumns(10);
		fld_frq1.setBounds(292, 77, 128, 24);
		panel_main.add(fld_frq1);
		
		fld_key2 = new JTextField();
		fld_key2.setFont(new Font("Tahoma", Font.BOLD, 13));
		fld_key2.setColumns(10);
		fld_key2.setBounds(152, 114, 128, 24);
		panel_main.add(fld_key2);
		
		fld_frq2 = new JTextField();
		fld_frq2.setFont(new Font("Tahoma", Font.BOLD, 13));
		fld_frq2.setEditable(false);
		fld_frq2.setColumns(10);
		fld_frq2.setBounds(292, 114, 128, 24);
		panel_main.add(fld_frq2);
		
		fld_key3 = new JTextField();
		fld_key3.setFont(new Font("Tahoma", Font.BOLD, 13));
		fld_key3.setColumns(10);
		fld_key3.setBounds(152, 151, 128, 24);
		panel_main.add(fld_key3);
		
		fld_frq3 = new JTextField();
		fld_frq3.setFont(new Font("Tahoma", Font.BOLD, 13));
		fld_frq3.setEditable(false);
		fld_frq3.setColumns(10);
		fld_frq3.setBounds(292, 151, 128, 24);
		panel_main.add(fld_frq3);
		
		fld_lmd1 = new JTextField();
		fld_lmd1.setFont(new Font("Tahoma", Font.BOLD, 13));
		fld_lmd1.setEditable(false);
		fld_lmd1.setColumns(10);
		fld_lmd1.setBounds(432, 77, 161, 24);
		panel_main.add(fld_lmd1);
		
		fld_lmd2 = new JTextField();
		fld_lmd2.setFont(new Font("Tahoma", Font.BOLD, 13));
		fld_lmd2.setEditable(false);
		fld_lmd2.setColumns(10);
		fld_lmd2.setBounds(432, 114, 161, 24);
		panel_main.add(fld_lmd2);
		
		fld_lmd3 = new JTextField();
		fld_lmd3.setFont(new Font("Tahoma", Font.BOLD, 13));
		fld_lmd3.setEditable(false);
		fld_lmd3.setColumns(10);
		fld_lmd3.setBounds(432, 151, 161, 24);
		panel_main.add(fld_lmd3);
		
		btn_analyze = new JButton("Analyze");
		btn_analyze.setFont(new Font("Vineta BT", Font.PLAIN, 15));
		btn_analyze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckInput1();
			}
		});
		btn_analyze.setBounds(292, 188, 147, 64);
		panel_main.add(btn_analyze);
		
		btn_clear = new JButton("Clear");
		btn_clear.setFont(new Font("Vineta BT", Font.PLAIN, 15));
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClearAllFields();
			}
		});
		btn_clear.setBounds(465, 188, 128, 64);
		panel_main.add(btn_clear);
		
		JLabel lbl_lambda = new JLabel("Wavelength (m)");
		lbl_lambda.setFont(new Font("Vineta BT", Font.PLAIN, 13));
		lbl_lambda.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_lambda.setBounds(432, 17, 161, 24);
		panel_main.add(lbl_lambda);
		
		JLabel lbl_note = new JLabel("Note");
		lbl_note.setFont(new Font("Vineta BT", Font.PLAIN, 13));
		lbl_note.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_note.setBounds(152, 17, 128, 24);
		panel_main.add(lbl_note);
		
		JLabel lbl_freq = new JLabel("Frequency (Hz)");
		lbl_freq.setFont(new Font("Vineta BT", Font.PLAIN, 13));
		lbl_freq.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_freq.setBounds(271, 17, 161, 24);
		panel_main.add(lbl_freq);
		
		JLabel lbl_key1 = new JLabel("Key # 1");
		lbl_key1.setFont(new Font("Vineta BT", Font.PLAIN, 13));
		lbl_key1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_key1.setBounds(12, 77, 128, 24);
		panel_main.add(lbl_key1);
		
		JLabel lbl_key2 = new JLabel("Key # 2");
		lbl_key2.setFont(new Font("Vineta BT", Font.PLAIN, 13));
		lbl_key2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_key2.setBounds(12, 114, 128, 24);
		panel_main.add(lbl_key2);
		
		JLabel lbl_key3 = new JLabel("Key # 3");
		lbl_key3.setFont(new Font("Vineta BT", Font.PLAIN, 13));
		lbl_key3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_key3.setBounds(12, 151, 128, 24);
		panel_main.add(lbl_key3);
		
		JLabel lbl_chordtype = new JLabel("Key # 3");
		lbl_chordtype.setFont(new Font("Vineta BT", Font.PLAIN, 13));
		lbl_chordtype.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_chordtype.setBounds(12, 212, 128, 24);
		panel_main.add(lbl_chordtype);
		
		fld_Chord = new JTextField();
		fld_Chord.setFont(new Font("Tahoma", Font.BOLD, 13));
		fld_Chord.setColumns(10);
		fld_Chord.setBounds(152, 209, 128, 24);
		panel_main.add(fld_Chord);
	}
}
