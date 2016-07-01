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
	
	JMenu menusortie = new JMenu("اخراج");
	
    JMenuItem sortiproduit = new JMenuItem("اخراج منتوج");
	
 	JMenu retour = new JMenu("عودة    ");

	
	JMenu menuapropos = new JMenu("?");

	
	
	public menubar (){
		//modify this when changing to a different layout manager
		//this.setLayout(null);
        
      //  this.add(menubar);
        menu.setBounds(0, 0, 1370, 30);
        menu.add(Box.createHorizontalGlue());
        menu.setFont(new Font("sans-serif", Font.PLAIN, 12));

        
        menuouvrir.add(ajoutbase);
        menuouvrir.add(motpass);
        menuouvrir.addSeparator();
        menuouvrir.add(quiter);
        
        
        menuajout.add(ajoutprodui);
        menuajout.add(listproduit);
        
        menusortie.add(sortiproduit);
       
        menu.add(menuapropos);
        menu.add(retour);
        menu.add(menusortie);
        menu.add(menuajout);
        menu.add(menuouvrir);

        //this.setBackground(Color.white);
       // this.setVisible(true);
	
		
	}

}
