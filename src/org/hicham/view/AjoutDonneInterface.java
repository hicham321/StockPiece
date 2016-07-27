package org.hicham.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AjoutDonneInterface extends JFrame {

	private JTextField prixAchatText = new JTextField();
	private JTextField prixVenteText = new JTextField();
	private JTextField margeText = new JTextField();

	private JLabel prixAchatTextalbl= new JLabel("ثمن الشراء");
	private JLabel prixVenteTextlbl= new JLabel("ثمن البيع");
	private JLabel margeTextlbl= new JLabel("");

	private JButton ok = new JButton("موافقة");
	private JButton annule = new JButton("الغاء");

	public AjoutDonneInterface(){

		setResizable(true);
		setSize(400,200);        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.add(annule);
		panel.add(ok);

		panel.add(prixAchatText);
		panel.add(prixVenteText);
		panel.add(margeText);

		panel.add(prixAchatTextalbl);
		panel.add(prixAchatTextalbl);
		panel.add(prixAchatTextalbl);

		this.add(panel);


	}

	public void addAjoutDonneInterface (ActionListener listner){
		this.ok.addActionListener(listner);
		this.annule.addActionListener(listner);
	}
	

	public JButton getOk() {
		return ok;
	}


	public JButton getAnnule() {
		return annule;
	}



}
