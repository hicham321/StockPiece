package org.hicham.view;


//this contains the Jtable for teh list of products
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ListProduit extends JFrame {
	
	JTable ListProduitTable;
	
    public ListProduit(){
    	JPanel panel = new JPanel();
   	    panel.add(ListProduitTable);
    }
//to keep the Jtable separate from the model you can call the Jtable from the controller once you click the view 
//this 
}
