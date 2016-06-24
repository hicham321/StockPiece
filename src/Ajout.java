import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import javafx.geometry.VerticalDirection;
//import net.miginfocom.swing.MigLayout;

public class Ajout extends JPanel {
	//
	JTextField numfact = new JTextField(10);
	JLabel labnumfact = new JLabel("رقم الفاتورة");
	JTextField NomFournisseur = new JTextField(10);
	JLabel labNomFour = new JLabel("الممول");

	JButton annule = new JButton("الغاء");
	JButton ok = new JButton("موافقة");
	JButton ajoutproduit = new JButton();
	
	JLabel prixTotalLab = new JLabel("المجموع الكلي");
	JLabel prixTotal = new JLabel(" ");

     
	public Ajout() {

		this.setLayout(new GroupLayout(this));

		this.add(NomFournisseur);
		this.add(labNomFour);
		this.add(numfact);
		this.add(labnumfact);
		this.add(ok);
		this.add(annule);
        this.add(prixTotalLab);
        this.add(ajoutproduit);
        //this is the total price label
        this.add(prixTotal);
        
		this.setBackground(Color.white);
		this.setVisible(true);
		this.add(new JSeparator());
        NomFournisseur.setBounds(200, 20, 100, 20);
        labNomFour.setBounds(310, 20, 100, 20);
        numfact.setBounds(30, 20, 100, 20);
        labnumfact.setBounds(140, 20, 100, 20);
        prixTotalLab.setBounds(1230, 630, 100, 20);
        prixTotal.setBounds(1150, 630, 100, 20);
        annule.setBounds(1230, 580, 100, 30);
		ok.setBounds(1100, 580, 100, 30);
		ajoutproduit.setBounds(300, 300, 100, 30);

	}
}
