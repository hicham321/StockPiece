import java.awt.Color;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class mainPanel extends JPanel {
	
	 JMenuBar menubar = new JMenuBar();
		
		JButton but = new JButton("sdf");
		
		JMenu menuouvrir = new JMenu("ملف");
		
		JMenuItem ajoutbase = new JMenuItem("فتح");
		
		JMenuItem quiter = new JMenuItem("خروج ");
		
		JMenuItem motpass = new JMenuItem("Changer le mot de passe");

		JMenu menuajout = new JMenu("ادخال ");
		
		JMenuItem ajoutprodui = new JMenuItem("ادخال منتوج");
		
		JMenuItem listproduit = new JMenuItem("لائحة المنتوجات");
		
		JMenu menusortie = new JMenu("اخراج");
		
	     JMenuItem sortiproduit = new JMenuItem("اخراج منتوج");
		
		
		JMenu menuapropos = new JMenu("?");

		
		public mainPanel(){
			
			//modify this when changing to a different layout manager
			    this.setLayout(null);
			    
			    this.add(but);
			    
		        but.setBounds(70,70,70,70);
		        
		        this.add(menubar);
		        menubar.setBounds(0, 0, 1370, 30);
		        menubar.add(Box.createHorizontalGlue());
		        menubar.setFont(new Font("sans-serif", Font.PLAIN, 12));

		        
		        menuouvrir.add(ajoutbase);
		        menuouvrir.add(motpass);
		        menuouvrir.addSeparator();
		        menuouvrir.add(quiter);
		        
		        
		        menuajout.add(ajoutprodui);
		        menuajout.add(listproduit);
		        
		        menusortie.add(sortiproduit);
		       
		        menubar.add(menuapropos);
		        menubar.add(menusortie);
		        menubar.add(menuajout);
		        menubar.add(menuouvrir);

		        this.setBackground(Color.white);
		        this.setBounds(0, 0, 400, 400);
		        this.setVisible(true);
			
			
		}


		
		

}
