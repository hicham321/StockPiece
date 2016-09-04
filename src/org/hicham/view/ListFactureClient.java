package org.hicham.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListFactureClient extends JPanel {
	

		
	public  DefaultTableModel dt;
		
		public  JTable listFactureClient;
		
		private JScrollPane scrolPane;
		    
		public ListFactureClient(){
			
			listFactureClient =new JTable(dt);
	        
			this.setLayout(new GroupLayout(this));
			this.setBackground(Color.decode("#CFDBC5"));
			
			listFactureClient.setPreferredScrollableViewportSize(new Dimension(500,50));
			listFactureClient.setFillsViewportHeight(true);
			
			scrolPane= new JScrollPane(listFactureClient);
			scrolPane.setBounds(100, 100, 500, 500);
			this.add(scrolPane);
			
			this.setVisible(true);


		} 


	}


