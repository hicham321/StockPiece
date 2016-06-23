import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

public Ajout(){
   
	
this.setLayout(new GroupLayout(this));	


this.add(NomFournisseur);
this.add(labNomFour);
this.add(numfact);
this.add(labnumfact);
this.add(ok);
this.add(annule);


this.setBackground(Color.blue);
this.setVisible(true);

//	this.add(ok);
//	this.add(annule);
	ok.setBounds(30, 30, 100, 30);
	
	
}



}
