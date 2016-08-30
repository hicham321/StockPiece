package org.hicham.view;


import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JButton;
//this contains the Jtable for teh list of products
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ListProduit extends JPanel{
	
	JTable ListProduitTable=new JTable();
    JButton buttt = new JButton("dsdfdf");
    
	public ListProduit(){
		
		this.setLayout(new GroupLayout(this));
		this.setBackground(Color.decode("#CFDBC5"));
		this.add(buttt);
		this.add(ListProduitTable);
		//this.ListProduitTable.setBounds(20,60 , 400, 400);
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
