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
	
	public  JTable listFactureFournis;
	
	private JScrollPane scrolPane;
	    
	public ListeFactureFournis(){
		
		listFactureFournis =new JTable(dt);
        
		this.setLayout(new GroupLayout(this));
		this.setBackground(Color.decode("#CFDBC5"));
		
		listFactureFournis.setPreferredScrollableViewportSize(new Dimension(500,50));
		listFactureFournis.setFillsViewportHeight(true);
		
		scrolPane= new JScrollPane(listFactureFournis);
		scrolPane.setBounds(100, 100, 500, 500);
		this.add(scrolPane);
		
		this.setVisible(true);


	} 


}
