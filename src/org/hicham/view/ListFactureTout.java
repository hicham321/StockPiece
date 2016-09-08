package org.hicham.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListFactureTout extends JPanel {

	public  DefaultTableModel dt;

	public  JTable listFactureToutTable;

	private JScrollPane scrolPane;

	JLabel listFactureToutLabel = new JLabel("لائحة جميع الفواتير");


	public ListFactureTout() {


		listFactureToutTable =new JTable(dt);

		this.setLayout(new GroupLayout(this));
		this.setBackground(Color.decode("#CFDBC5"));

		listFactureToutTable.setPreferredScrollableViewportSize(new Dimension(500,50));
		listFactureToutTable.setFillsViewportHeight(true);

		this.add(listFactureToutLabel);
		this.listFactureToutLabel.setBounds(1250,30,190,20);

		scrolPane= new JScrollPane(listFactureToutTable);
		scrolPane.setBounds(100, 100, 500, 500);
		this.add(scrolPane);

		this.setVisible(true);


	}


}
