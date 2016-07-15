package org.hicham.view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//this is  a view for changing the password
public class ChangePass extends JFrame {
	
	JLabel oldPassTextLabel= new JLabel("كلمة السر القديمة");
	JPasswordField oldPassText= new JPasswordField();

	JLabel oldUserTextLabel= new JLabel("اسم المستعمل القديم");
	JTextField oldUserText= new JTextField();

	JLabel newPassTextLabel= new JLabel("كلمة السر الجديدة ");
	JPasswordField newPassText= new JPasswordField();

	JLabel newUserTextLabel= new JLabel("اسم المستعمل الجديد");
	JTextField newUserText= new JTextField();

	JButton ok= new JButton("موافقة");
	JButton annule= new JButton("الغاء");


	public ChangePass(){
		
		setTitle("تبديل كلمة السر");
		setSize(350, 460);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		oldPassTextLabel.setBounds(200, 50, 120, 20);
		oldPassText.setBounds(50, 50, 120, 20);
		oldUserTextLabel.setBounds(200, 120, 120, 20);
		oldUserText.setBounds(	50, 120, 120, 20);
		newPassTextLabel.setBounds(200, 190, 120, 20);
		newPassText.setBounds(50, 190, 120, 20);
		newUserTextLabel.setBounds(200, 260, 120, 20);
		newUserText.setBounds(50, 260, 120, 20);

		ok.setBounds(200, 350, 120, 20);
		annule.setBounds(30, 350, 120, 20);

		
		panel.add(oldPassTextLabel);
		panel.add(oldPassText);
		
		panel.add(oldUserTextLabel);
		panel.add(oldUserText);
		
		panel.add(newPassTextLabel);
		panel.add(newPassText);
		
		panel.add(newUserTextLabel);
		panel.add(newUserText);
		
		panel.add(ok);
		panel.add(annule);
		
		panel.setBackground(Color.white);
		panel.setLayout(null);

        add(panel);
        
	}
	
	public void addChangePassListener(ActionListener listener){
		annule.addActionListener(listener);
		ok.addActionListener(listener);
	}


	public JPasswordField getOldPassText() {
		return oldPassText;
	}


	public void setOldPassText(JPasswordField oldPassText) {
		this.oldPassText = oldPassText;
	}


	public JTextField getOldUserText() {
		return oldUserText;
	}


	public void setOldUserText(JTextField oldUserText) {
		this.oldUserText = oldUserText;
	}


	public JPasswordField getNewPassText() {
		return newPassText;
	}


	public void setNewPassText(JPasswordField newPassText) {
		this.newPassText = newPassText;
	}


	public JTextField getNewUserText() {
		return newUserText;
	}


	public void setNewUserText(JTextField newUserText) {
		this.newUserText = newUserText;
	}


	public JButton getOk() {
		return ok;
	}


	public JButton getAnnule() {
		return annule;
	}

	

}
