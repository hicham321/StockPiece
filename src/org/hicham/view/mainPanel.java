package org.hicham.view;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;


public class mainPanel extends JPanel {
	
	
	
       JButton but = new JButton("dsdffd");

		
		public mainPanel(){
			
			//modify this when changing to a different layout manager
			    this.setLayout(null);
			    this.add(but);
			    
			    
		        but.setBounds(70,500,70,70);
		        

		        this.setBackground(Color.white);
		        //this.setBounds(0, 0, 400, 400);
		        this.setVisible(true);
			
			
		}


		
		

}
