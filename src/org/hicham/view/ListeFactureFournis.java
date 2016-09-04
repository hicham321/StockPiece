package org.hicham.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListeFactureFournis extends JPanel {
	
public  DefaultTableModel dt;
	
	public  JTable ListFactureFournis;
	
	private JScrollPane scrolPane;
	    
	public ListeFactureFournis(){
		
		ListFactureFournis =new JTable(dt);
        
		this.setLayout(new GroupLayout(this));
		this.setBackground(Color.decode("#CFDBC5"));
		
		ListFactureFournis.setPreferredScrollableViewportSize(new Dimension(500,50));
		ListFactureFournis.setFillsViewportHeight(true);
		
		scrolPane= new JScrollPane(ListFactureFournis);
		scrolPane.setBounds(100, 100, 500, 500);
		this.add(scrolPane);
		
		this.setVisible(true);


	} 


}
