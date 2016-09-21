package org1.hicham.view;



import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterfaceSuppProd extends JFrame{
    private JLabel suppLabel= new JLabel("هل انت متاكد من حذف هذا المنتوج?");
	private JButton ok= new JButton("موافقة");
	private JButton annule= new JButton("الغاء");

	public InterfaceSuppProd(){
		setResizable(true);
		setSize(400,200); 
		setTitle("Suuprimer prod");
	    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.add(annule);
		panel.add(ok);
		panel.add(suppLabel);

		this.ok.setBounds(100, 110, 70, 20);
		this.annule.setBounds(230, 110, 70, 20);
		this.suppLabel.setBounds(50, 40, 200, 20);


		this.add(panel);


	}
	public void addSuppProdInterfaceListener (ActionListener listner){
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
