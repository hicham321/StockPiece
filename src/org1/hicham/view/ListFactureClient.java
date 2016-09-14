package org1.hicham.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListFactureClient extends JPanel {



	public  DefaultTableModel dt;

	public  JTable listFactureClient;

	private JScrollPane scrolPane;

	JLabel listFactureClientLabel = new JLabel("لائحة فواتير الزبائن");


	public ListFactureClient(){

		listFactureClient =new JTable(dt);

		this.setLayout(new GroupLayout(this));
		this.setBackground(Color.decode("#CFDBC5"));

		listFactureClient.setPreferredScrollableViewportSize(new Dimension(500,50));
		listFactureClient.setFillsViewportHeight(true);

		this.add(listFactureClientLabel);
		this.listFactureClientLabel.setBounds(1250,30,190,20);

		scrolPane= new JScrollPane(listFactureClient);
		scrolPane.setBounds(50, 70, 1250, 470);
		this.add(scrolPane);

		this.setVisible(true);


	} 


}


