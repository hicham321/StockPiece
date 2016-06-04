import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class menubar extends JMenuBar{
	
	JMenuBar menubar = new JMenuBar();
	
	JButton but = new JButton("sdf");
	
	JMenu menuouvrir = new JMenu("Fichier");
	
	JMenuItem ajoutbase = new JMenuItem("Ouvrir");
	
	JMenuItem quiter = new JMenuItem("Quitter");
	
	JMenuItem motpass = new JMenuItem("Changer le mot de passe");

	JMenu menuenf = new JMenu("Enfant");
	
	JMenuItem ajoutEnf = new JMenuItem("Ajout Enf");
	
	JMenuItem listeEnf = new JMenuItem("Liste Enf");

	JMenuItem explore = new JMenuItem("explore");
	
	JMenu menuemp = new JMenu("Employ�");
	
     JMenuItem ajoutemp = new JMenuItem("Ajout Emp");
	
	JMenuItem listeEmp = new JMenuItem("Liste Emp");
	
	JMenu menuapropos = new JMenu("A Propos");
	
	
	public menubar (){
		//modify this when changing to a different layout manager
	    this.setLayout(null);
	    
	    this.add(but);
	    
        but.setBounds(70,70,70,70);
        
        this.add(menubar);
        menubar.setBounds(0, 0, 400, 30);
        
        menuouvrir.add(ajoutbase);
        menuouvrir.add(motpass);
        menuouvrir.addSeparator();
        menuouvrir.add(quiter);
        
        
        menuenf.add(ajoutEnf);
        menuenf.add(listeEnf);
        menuenf.add(explore);
        
        menuemp.add(ajoutemp);
        menuemp.add(listeEmp);
       
        menubar.add(menuouvrir);
        menubar.add(menuenf);
        menubar.add(menuemp);
        menubar.add(menuapropos);
       
        this.setBackground(Color.white);
        this.setBounds(0, 0, 400, 400);
        this.setVisible(true);	
		
	}

}
