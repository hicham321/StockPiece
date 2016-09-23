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

public class Destockage extends JPanel{
	
	 public  DefaultTableModel dt;
		
		public  JTable listProduitAjoutTable;
		
		private JScrollPane scrolPane;
		//fields labels and buttons
		JTextField numfact = new JTextField(10);
		JLabel labnumfact = new JLabel("رقم الفاتورة");
		JTextField nomFournisseur = new JTextField(10);
		JLabel labNomFour = new JLabel("الزبون");

		JButton annule2 = new JButton("الغاء");
		JButton ok2 = new JButton("موافقة");
		JButton ajoutproduit2 = new JButton("اخراج");
		
		JLabel prixTotalLab = new JLabel("المجموع الكلي");
		JLabel prixTotal = new JLabel("0");

     
	public Destockage() {

		this.setLayout(new GroupLayout(this));
        //JTbale
		
		
		//Text fields buttons alnd labels
		this.add(nomFournisseur);
		this.add(labNomFour);
		this.add(numfact);
		this.add(labnumfact);
		this.add(ok2);
		//this.add(annule);
        this.add(prixTotalLab);
        this.add(ajoutproduit2);
        //this is the total price label
        this.add(prixTotal);
        
		this.setBackground(Color.decode("#CFDBC5"));
		this.setVisible(true);
		this.add(new JSeparator());
		//Jtable
		
		listProduitAjoutTable =new JTable(dt);
		scrolPane= new JScrollPane(listProduitAjoutTable);
		scrolPane.setBounds(50, 70, 1250, 470);
		this.add(scrolPane);
		
		//Text fields buttons and labels
        nomFournisseur.setBounds(200, 20, 100, 20);
        labNomFour.setBounds(310, 20, 100, 20);
        numfact.setBounds(30, 20, 100, 20);
        labnumfact.setBounds(140, 20, 100, 20);
        prixTotalLab.setBounds(1230, 630, 100, 20);
        prixTotal.setBounds(1150, 630, 100, 20);
        annule2.setBounds(1230, 580, 100, 30);
		ok2.setBounds(1100, 580, 100, 30);
		ajoutproduit2.setBounds(500, 20, 100, 20);

	}


}
