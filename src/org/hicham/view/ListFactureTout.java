package org.hicham.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListFactureTout extends JPanel {

	public  DefaultTableModel dt;

	public  JTable listFactureToutTable;

	private JScrollPane scrolPane;

	public ListFactureTout() {
		// TODO Auto-generated constructor stub


		listFactureToutTable =new JTable(dt);

		this.setLayout(new GroupLayout(this));
		this.setBackground(Color.decode("#CFDBC5"));

		listFactureToutTable.setPreferredScrollableViewportSize(new Dimension(500,50));
		listFactureToutTable.setFillsViewportHeight(true);

		scrolPane= new JScrollPane(listFactureToutTable);
		scrolPane.setBounds(100, 100, 500, 500);
		this.add(scrolPane);

		this.setVisible(true);


	}


}
