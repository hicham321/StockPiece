package org.hicham.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Zakat extends JPanel {
	
	public  DefaultTableModel dt;

	public  JTable listProduitZakatTable;

	private JScrollPane scrolPane;

	public Zakat() {

		listProduitZakatTable =new JTable(dt);

		this.setLayout(new GroupLayout(this));
		this.setBackground(Color.decode("#CFDBC5"));

		listProduitZakatTable.setPreferredScrollableViewportSize(new Dimension(500,50));
		listProduitZakatTable.setFillsViewportHeight(true);

		scrolPane= new JScrollPane(listProduitZakatTable);
		scrolPane.setBounds(100, 100, 500, 500);
		this.add(scrolPane);

		this.setVisible(true);

	}

}
