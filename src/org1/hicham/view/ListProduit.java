package org1.hicham.view;


import java.awt.Color;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
//this contains the Jtable for teh list of products
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org1.hicham.model.model;


public class ListProduit extends JPanel{


	public  DefaultTableModel dt;

	public  JTable listProduitTable;

	private JScrollPane scrolPane;

	JLabel listProduitLabel = new JLabel("لائحة المنتوجات");

    public JButton excelBut= new JButton("excel");
    
	public ListProduit(){


		this.setLayout(new GroupLayout(this));
		this.setBackground(Color.decode("#CFDBC5"));

		listProduitTable= new JTable();
		listProduitTable.setPreferredScrollableViewportSize(new Dimension(500,50));
		listProduitTable.setFillsViewportHeight(true);
		this.add(listProduitLabel);
		this.listProduitLabel.setBounds(1250,30,190,20);
        
		this.add(excelBut);
		this.excelBut.setBounds(200, 590, 100, 20);
		
		listProduitTable =new JTable(dt);
		scrolPane= new JScrollPane(listProduitTable);
		scrolPane.setBounds(50, 70, 1250, 470);
		this.add(scrolPane);

		this.setVisible(true);


	}
	

	//to keep the Jtable separate from the model you can call the Jtable from the controller once you click the view 
	/*this is how to sort a Jtable (without needing to create other queries)
JTable table = new JTable(tableModel);
TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
table.setRowSorter(sorter);

List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
sortKeys.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));
sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
sorter.setSortKeys(sortKeys);*/
}
