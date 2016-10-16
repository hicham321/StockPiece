package org1.hicham.view;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FactureHistorique extends JPanel {
	
	    public  DefaultTableModel dt3;
		
		public  JTable listProduitAjoutTable3;
		
		private JScrollPane scrolPane3;
		//fields labels and buttons
		JTextField numfact3 = new JTextField(10);
		JLabel labnumfact3 = new JLabel("رقم الفاتورة");
		JTextField nomFournisseur3 = new JTextField(10);
		JLabel labNomFour3 = new JLabel("الممول");

		JButton annule3 = new JButton("الغاء");
		JButton ok3 = new JButton("موافقة");
		JButton ajoutproduit3 = new JButton("ادخال");
		
		JLabel prixTotalLab3 = new JLabel("المجموع الكلي");
		JLabel prixTotal3 = new JLabel("0");
		
		JLabel creditLab3= new JLabel("الديون");
	    JTextField creditText3= new JTextField();
	    
	    
	    public FactureHistorique() {

			this.setLayout(new GroupLayout(this));
	        //JTbale
			
			
			//Text fields buttons alnd labels
			this.add(nomFournisseur3);
			this.add(labNomFour3);
			this.add(numfact3);
			this.add(labnumfact3);
			this.add(ok3);
			this.add(annule3);
			
	        this.add(prixTotalLab3);
	        this.add(ajoutproduit3);
	        //this is the total price label
	        this.add(prixTotal3);
	        
	        this.add(creditLab3);
	        this.add(creditText3);
	        this.creditText3.setText("0");

			this.setBackground(Color.white);
			this.setVisible(true);
			this.add(new JSeparator());
			//Jtable
			
			listProduitAjoutTable3 =new JTable(dt3);
			scrolPane3= new JScrollPane(listProduitAjoutTable3);
			scrolPane3.setBounds(50, 70, 1250, 470);
			this.add(scrolPane3);
			
			//Text fields buttons and labels
	        nomFournisseur3.setBounds(200, 20, 100, 20);
	        labNomFour3.setBounds(310, 20, 100, 20);
	        numfact3.setBounds(30, 20, 100, 20);
	        labnumfact3.setBounds(140, 20, 100, 20);
	        prixTotalLab3.setBounds(1230, 630, 100, 20);
	        prixTotal3.setBounds(1150, 630, 100, 20);
	        annule3.setBounds(1230, 580, 100, 30);
			ok3.setBounds(1100, 580, 100, 30);
			ajoutproduit3.setBounds(500, 20, 100, 20);
			
			creditLab3.setBounds(140,630 ,100 ,20 );
			creditText3.setBounds(30, 630, 100, 20);

		}

		


}
