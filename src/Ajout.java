import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;


public class Ajout extends JPanel{
	JTextField nom       = new JTextField(10);
	JLabel labnom        = new JLabel("اسم المنتوج");
	JTextField referance = new JTextField(10);
	JLabel labref        = new JLabel("علامة المنتوج");
	JTextField prixAchat = new JTextField(10);
	JLabel labachat      = new JLabel("ثمن الشراء");
	JTextField prixvente = new JTextField(10);
	JLabel labvente      = new JLabel("ثمن البيع");
	JTextField qte       = new JTextField(10);
	JLabel labqte        = new JLabel("الكمية ");
	JTextField date      = new JTextField(10);
	JLabel labdate       = new JLabel("التاريخ ");
	JButton annule = new JButton("الغاء");
	JButton ok = new JButton("موافقة");

	
public Ajout(){
	
	this.setLayout(new MigLayout());
	
	this.add(nom);
	this.add(labnom);

	this.add(referance);
	this.add(labref);

	this.add(prixAchat);
	this.add(labachat);

	this.add(prixvente);
	this.add(labvente);

	this.add(qte);
	this.add(labqte);

	this.add(date);
	this.add(labdate);

	this.add(ok);
	this.add(annule);
	
	
}



}
