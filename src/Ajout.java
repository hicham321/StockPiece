import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import java.awt.LayoutManager;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
//import net.miginfocom.swing.MigLayout;


public class Ajout extends JPanel{
	//
	JTextField numfact       = new JTextField(10);
	JLabel labnumfact        = new JLabel("اسم المنتوج");
	JTextField NomFournisseur = new JTextField(10);
	JLabel labNomFour        = new JLabel("علامة المنتوج");
	
	JButton annule = new JButton("الغاء");
	JButton ok = new JButton("موافقة");
    JButton but = new JButton("dsdffd");

public Ajout(){
   
	
this.setLayout(null);	

this.add(but);


but.setBounds(70,500,70,70);
this.setBackground(Color.white);
this.setVisible(true);

//	this.add(ok);
//	this.add(annule);
//	ok.setBounds(30, 30, 20, 10);
	
	
}



}
