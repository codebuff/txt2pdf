package net.codebuff.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.codebuff.FileUtil;

/**********************************
 * @author Deepankar Tyagi
 **********************************/

public class Main {

	private JFrame frmPdfMakeronly;
	private JPanel panel;
	private JTextField txtTypeYourName;
	private JTextField txtTypeYourRoll;
	private JButton btnOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmPdfMakeronly.pack();
					window.frmPdfMakeronly.setBounds(500, 200, 250, 150);
					window.frmPdfMakeronly.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPdfMakeronly = new JFrame();
		frmPdfMakeronly.setType(Type.UTILITY);
		frmPdfMakeronly.setFont(new Font("Cambria", Font.PLAIN, 12));
		frmPdfMakeronly.setTitle("Pdf maker (only for .java files )");
		frmPdfMakeronly.setBounds(400, 400, 450, 310);
		frmPdfMakeronly.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPdfMakeronly.getContentPane().setLayout(
				new BoxLayout(frmPdfMakeronly.getContentPane(),
						BoxLayout.X_AXIS));

		panel = new JPanel();
		frmPdfMakeronly.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 5, 5));

		txtTypeYourName = new JTextField();
		txtTypeYourName.setText("Enter  your name");
		txtTypeYourName.setToolTipText("type your name here");
		panel.add(txtTypeYourName);
		txtTypeYourName.setColumns(5);

		txtTypeYourRoll = new JTextField();
		txtTypeYourRoll.setText("Enter your roll no");
		txtTypeYourRoll.setToolTipText("type your roll no here");
		panel.add(txtTypeYourRoll);
		txtTypeYourRoll.setColumns(5);

		btnOk = new JButton("create PDF");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileUtil.name = txtTypeYourName.getText();
				FileUtil.rollno = txtTypeYourRoll.getText();
				new FileUtil();
			}
		});
		panel.add(btnOk);
	}

}
