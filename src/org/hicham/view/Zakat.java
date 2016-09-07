package org.hicham.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Zakat extends JPanel {
	
	public  DefaultTableModel dt;

	public  JTable listProduitZakatTable;

	private JScrollPane scrolPane;
	
	//labels buttons and fields
	
	JLabel zakatProduitLab = new JLabel("المنتوجات المزكى عليها");

	JLabel zakatLabel= new JLabel("ادخل نسبة الزكاة");
	
	JTextField zakatText = new JTextField();
	
	JLabel zakatTotalLab= new JLabel("االمجموع المزكى عليه");
	
	JLabel zakatTotal= new JLabel("");
	
	JLabel zakatFinalLab= new JLabel("مبلغ الزكاة");
	
	JLabel zakatFinal= new JLabel("");

	

	public Zakat() {

		listProduitZakatTable =new JTable(dt);

		this.setLayout(new GroupLayout(this));
		this.setBackground(Color.decode("#CFDBC5"));

		listProduitZakatTable.setPreferredScrollableViewportSize(new Dimension(500,50));
		listProduitZakatTable.setFillsViewportHeight(true);

		scrolPane= new JScrollPane(listProduitZakatTable);
		scrolPane.setBounds(100, 100, 500, 500);
		this.add(scrolPane);
		
		this.add(zakatFinal);
		this.add(zakatFinalLab);
		this.add(zakatLabel);
		this.add(zakatProduitLab);
		this.add(zakatText);
		this.add(zakatTotalLab);
		this.add(zakatTotal);



		this.setVisible(true);

	}
	

}
