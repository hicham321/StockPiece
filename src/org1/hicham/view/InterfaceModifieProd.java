package org1.hicham.view;


import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterfaceModifieProd extends JFrame{

	private JTextField textProd = new JTextField();
	private JButton ok= new JButton("موافقة");
	private JButton annule= new JButton("الغاء");

	public InterfaceModifieProd(){
		setResizable(true);
		setSize(400,200);        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.add(annule);
		panel.add(ok);
		panel.add(textProd);

		this.ok.setBounds(100, 110, 70, 20);
		this.annule.setBounds(230, 110, 70, 20);
		this.textProd.setBounds(200, 50, 70, 20);


		this.add(panel);


	}
	public void addModifieProdInterfaceListener (ActionListener listner){
		this.ok.addActionListener(listner);
		this.annule.addActionListener(listner);
	}
	public JButton getOk() {
		return ok;
	}


	public JButton getAnnule() {
		return annule;
	}
	
	public JTextField getTextProd() {
		return textProd;
	}
	
	
}
