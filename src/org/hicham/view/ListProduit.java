package org.hicham.view;


import java.awt.Color;

import javax.swing.GroupLayout;
//this contains the Jtable for teh list of products
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ListProduit extends JFrame {

	JTable ListProduitTable;

	public ListProduit(){
		this.setLayout(null);
		this.setBackground(Color.decode("#CFDBC5"));
		this.add(ListProduitTable);
		this.setVisible(true);

	} 
	//set and get for ListProduitTable
	public JTable getListProduitTable() {
		return ListProduitTable;
	}

	public void setListProduitTable(JTable listProduitTable) {
		ListProduitTable = listProduitTable;
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
