package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MenuSetting extends JDialog {
	JSlider sldTimeSpeed;
	JPanel pnMain, pnTitle, pnTimeSpeed, pnReset;
	JLabel lblTitle, lblTimeSpeed, lblX, lblReset;
	JButton btnDispose, btnOK, btnReset;
	JTextField txtTimeSpeed;

	public MenuSetting() {
		addControls();
		addEvents();
	}

	public void addControls() {
		Container con = getContentPane();
		con.setLayout(null);

		pnMain = new JPanel(null);
		pnMain.setBounds(0, 30, 600, 500);
		pnMain.setBackground(new Color(253, 247, 221));

		pnTitle = new JPanel(null);
		pnTitle.setBounds(0, 0, 600, 20);
		pnTitle.setBackground(new Color(215, 172, 116));
		pnMain.add(pnTitle);
		lblTitle = new JLabel("Menu Setting");
		lblTitle.setBounds(250, 0, 125, 15);
		pnTitle.add(lblTitle);
		btnDispose = new JButton(new ImageIcon(getClass().getResource("/Image/xButton.PNG")));
		btnDispose.setBounds(580, 0, 20, 20);
		pnTitle.add(btnDispose);

		//Time Speed setting;
		pnTimeSpeed = new JPanel(null);
		pnTimeSpeed.setBounds(0, 50, 600, 50);
		pnTimeSpeed.setBackground(new Color(251, 232, 193));
		pnMain.add(pnTimeSpeed);
		lblTimeSpeed = new JLabel("Time Speed");
		lblTimeSpeed.setBounds(50, 15, 90, 20);
		pnTimeSpeed.add(lblTimeSpeed);
		lblX = new JLabel("x");
		lblX.setBounds(490, 15, 90, 20);
		pnTimeSpeed.add(lblX);
		
		
		sldTimeSpeed = new JSlider(1, 100);
		sldTimeSpeed.setBounds(180, 15, 300, 20);
		sldTimeSpeed.setBackground(new Color(251, 232, 193));
		pnTimeSpeed.add(sldTimeSpeed);
		txtTimeSpeed = new JTextField(10);
		txtTimeSpeed.setBounds(500, 15, 40, 20);
		pnTimeSpeed.add(txtTimeSpeed);

		// Reset Setting
		pnReset = new JPanel(null);
		pnReset.setBounds(0, 125, 600, 50);
		pnReset.setBackground(new Color(251, 232, 193));
		pnMain.add(pnReset);
		lblReset = new JLabel("Reset");
		lblReset.setBounds(50, 15, 90, 20);
		pnReset.add(lblReset);
		btnReset = new JButton("OK");
		btnReset.setBounds(190, 10, 70, 30);
		btnReset.setBackground(new Color(248, 222, 164));
		pnReset.add(btnReset);
		
		
		// Button Ok
		btnOK = new JButton("OK");
		btnOK.setBounds(240, 450, 110, 30);
		btnOK.setBackground(new Color(248, 222, 164));
		pnMain.add(btnOK);

		con.add(pnMain);

	}

	public void addEvents() {
		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent evt) {
				sldTimeSpeed.setValue(IsLandUI.timeSpeed);
			}
		});
		btnDispose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		sldTimeSpeed.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				txtTimeSpeed.setText(String.valueOf(sldTimeSpeed.getValue()));
			}
		});

		txtTimeSpeed.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				String StringVal = txtTimeSpeed.getText();
				Integer IntVal = 0;
				try {
					IntVal = Integer.valueOf(StringVal);
				} catch (NumberFormatException e) {
					txtTimeSpeed.setText("1");
				}
				if (IntVal < 1) {
					txtTimeSpeed.setText("1");
				} else if (IntVal >= 100) {
					txtTimeSpeed.setText("100");
				}
				sldTimeSpeed.setValue(Integer.valueOf(txtTimeSpeed.getText()));
			}
		});

		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IsLandUI.timeSpeed = Integer.parseInt(txtTimeSpeed.getText());
				dispose();
			}
		});
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IsLandUI.resetIsLand();
				dispose();
			}
		});
	}

	public void showWindow() {
		this.setSize(600, 530);
		setUndecorated(true);
		this.setBackground(new Color(0, 0, 0, 0));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setVisible(true);
	}

}
