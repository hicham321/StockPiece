package org.hicham.view;


import java.awt.Color;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
//this contains the Jtable for teh list of products
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hicham.model.model;


public class ListProduit extends JPanel{
	
	
	private DefaultTableModel dt= new DefaultTableModel();
	
	private JTable ListProduitTable=new JTable(dt);
	
	private JScrollPane scrolPane;
	
    private JButton buttt = new JButton("dsdfdf");
    
	public ListProduit(){
		//try{
		

//	    Vector rowData = new Vector<String>();
//	    rowData.addElement("sdds");
//	    dtm.addRow(rowData);

        //this.ListProduitTable = new JTable(dtm);
        
		this.setLayout(new GroupLayout(this));
		this.setBackground(Color.decode("#CFDBC5"));
		this.add(buttt);
		ListProduitTable.setPreferredScrollableViewportSize(new Dimension(500,50));
		ListProduitTable.setFillsViewportHeight(true);
		ListProduitTable.setFillsViewportHeight( true );
		scrolPane= new JScrollPane(ListProduitTable);
		scrolPane.setBounds(100, 100, 500, 500);
        this.add(scrolPane);	
		this.setVisible(true);
//		}catch(SQLException ex){
//			ex.printStackTrace();
//		}

	} 
//This here should be the setter for the table model to relate this view dynamically to the	model class
	
	
	
	
	
	
	
	
	
	
	
	
	
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
