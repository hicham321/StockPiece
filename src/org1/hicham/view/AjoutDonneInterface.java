package org1.hicham.view;

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
	private JLabel margeTextlbl= new JLabel("hgg");

	private JButton ok = new JButton("موافقة");
	private JButton annule = new JButton("الغاء");
	private JButton calc= new JButton("%");

	public AjoutDonneInterface(){

		setResizable(true);
		setSize(400,300);        
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.add(annule);
		panel.add(ok);
		panel.add(calc);

		panel.add(prixAchatText);
		panel.add(prixVenteText);
		panel.add(margeText);

		panel.add(prixAchatTextalbl);
		panel.add(prixVenteTextlbl);
		panel.add(margeTextlbl);
		
		this.prixAchatTextalbl.setBounds(310,50,70,20);
		this.prixAchatText.setBounds(200,50,100,20);
		this.prixVenteTextlbl.setBounds(140,50,70,20);
		this.prixVenteText.setBounds(20,50,100,20);
		this.margeTextlbl.setBounds(250,100,70,20);
		this.margeText.setBounds(120,100,100,20);
		
		this.ok.setBounds(110,200,100,20);
		this.annule.setBounds(220,200,100,20);
		this.calc.setBounds(80,100,25,20);


		this.add(panel);


	}

	public void addAjoutDonneInterface (ActionListener listener){
		this.ok.addActionListener(listener);
		this.annule.addActionListener(listener);
		this.calc.addActionListener(listener);
	}
	

	public JButton getOk() {
		return ok;
	}


	public JButton getAnnule() {
		return annule;
	}

	public JTextField getPrixAchatText() {
		return prixAchatText;
	}

	public JTextField getPrixVenteText() {
		return prixVenteText;
	}

	public JTextField getMargeText() {
		return margeText;
	}

	public JButton getCalc() {
		return calc;
	}
	



}
