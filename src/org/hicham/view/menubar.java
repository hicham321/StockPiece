package org.hicham.view;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class menubar {

	JMenuBar menu = new JMenuBar();

	JMenu menuouvrir = new JMenu("ملف");

	JMenuItem ajoutbase = new JMenuItem("فتح");

	JMenuItem quiter = new JMenuItem("خروج ");

	JMenuItem motpass = new JMenuItem("تبديل كلمة السر");

	JMenu menuajout = new JMenu("ادخال ");

	JMenuItem ajoutprodui = new JMenuItem("ادخال منتوج");

	JMenuItem listproduit = new JMenuItem("لائحة المنتوجات");
	
	JMenuItem listFactureEntre = new JMenuItem("فاتورات الممولين");

	JMenu menusortie = new JMenu("اخراج");

	JMenuItem sortiproduit = new JMenuItem("اخراج منتوج");
	
	JMenuItem listFactureSortie = new JMenuItem("فاتورات االزبائن");
	
	JMenu listFactureTout = new JMenu("فاتورات  ");
	
	JMenu zakatMenu = new JMenu("اياربرب");

	JMenu retour = new JMenu("الرئيسية    ");


	JMenu menuapropos = new JMenu("?");



	public menubar (){
		//modify this when changing to a different layout manager
		//this.setLayout(null);

		//  this.add(menubar);
		menu.setBounds(0, 0, 1370, 30);
		//this adds the property of righting the menubar
		menu.add(Box.createHorizontalGlue());
		menu.setFont(new Font("sans-serif", Font.PLAIN, 12));


		menuouvrir.add(ajoutbase);
		menuouvrir.add(motpass);
		menuouvrir.addSeparator();
		menuouvrir.add(quiter);


		menuajout.add(ajoutprodui);
		menuajout.add(listproduit);
		menuajout.add(listFactureEntre);

		menusortie.add(sortiproduit);
		menusortie.add(listFactureSortie);

		menu.add(menuapropos);
		menu.add(retour);
		menu.add(zakatMenu);
		menu.add(listFactureTout);
		menu.add(menusortie);
		menu.add(menuajout);
		menu.add(menuouvrir);

		//this.setBackground(Color.white);
		// this.setVisible(true);
	}

}
