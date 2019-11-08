import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import javax.swing.JMenuBar;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Frame1 {

	private JFrame frame;
	private JTextField textField;
	private JButton btnFinish;
	private JTextField textField_1;
	private JTextField txtItemAndTest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, -22, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBounds(112, 134, 312, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnFinish = new JButton("Finish");
		btnFinish.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnFinish.setBounds(197, 203, 85, 21);
		frame.getContentPane().add(btnFinish);
		
		JLabel lblDataFileLocation = new JLabel("Data File Location:");
		lblDataFileLocation.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDataFileLocation.setBounds(10, 134, 100, 15);
		frame.getContentPane().add(lblDataFileLocation);
		
		JLabel lblKeyFileLocation = new JLabel("Key File Location:");
		lblKeyFileLocation.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKeyFileLocation.setBounds(10, 162, 100, 15);
		frame.getContentPane().add(lblKeyFileLocation);
		
		textField_1 = new JTextField();
		textField_1.setBounds(112, 163, 312, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JTextArea txtrPleaseEnterThe = new JTextArea();
		txtrPleaseEnterThe.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtrPleaseEnterThe.setBackground(SystemColor.control);
		txtrPleaseEnterThe.setLineWrap(true);
		txtrPleaseEnterThe.setText("Please enter the location of your data file and your key file");
		txtrPleaseEnterThe.setBounds(10, 97, 335, 29);
		frame.getContentPane().add(txtrPleaseEnterThe);
		
		txtItemAndTest = new JTextField();
		txtItemAndTest.setBackground(new Color(255, 255, 153));
		txtItemAndTest.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtItemAndTest.setHorizontalAlignment(SwingConstants.CENTER);
		txtItemAndTest.setText("Item and Test Analysis Software ");
		txtItemAndTest.setBounds(10, 10, 414, 65);
		frame.getContentPane().add(txtItemAndTest);
		txtItemAndTest.setColumns(10);
	}
	public JTextField getTextField_1() {
		return textField_1;
	}
	public JTextField getTextField() {
		return textField;
	}
	public JButton getBtnFinish() {
		return btnFinish;
	}

	public JTextField getTxtItemAndTest() {
		return txtItemAndTest;
	}
}
