import java.awt.CardLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.MenuListener;


public class mainFrame extends JFrame {
    JPanel cards ;
    
    menubar menu= new menubar();
	
	mainPanel card1 = new mainPanel();
	
	Ajout card2= new Ajout();
	
	//ViewAjoutEnf card3= new ViewAjoutEnf();
	
	
	public mainFrame(){
		
        setResizable(true);
        //setSize(400,400); 
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.add(menu);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cards = new JPanel(new CardLayout());
        
        cards.add(card1, "Card 1");
        cards.add(card2, "Card 2");
//        cards.add(card3, "Card 3");
        
        getContentPane().add(cards); 
	
	}
	//Card1
	public void addFrameActionLisner(ActionListener listner){
		this.menu.ajoutbase.addActionListener(listner);
		this.menu.ajoutprodui.addActionListener(listner);
		this.card1.but.addActionListener(listner);
		this.menu.listproduit.addActionListener(listner);
		this.menu.motpass.addActionListener(listner);
		this.menu.quiter.addActionListener(listner);
		this.menu.sortiproduit.addActionListener(listner);
		//this.menu.retour.addActionListener(listner);
		
		this.card2.annule.addActionListener(listner);
		this.card2.ok.addActionListener(listner);
		

	}
	//this is a menu listner for menus with no menu items
	public void addFrameMenulistner(MenuListener menListner){
		
		this.menu.retour.addMenuListener(menListner);
	}
	
	public JButton getBut() {
		return card1.but;
	}


	public void setBut(JButton but) {
		card1.but = but;
	}


	public JMenuItem getAjoutbase() {
		return menu.ajoutbase;
	}


	public void setAjoutbase(JMenuItem ajoutbase) {
		menu.ajoutbase = ajoutbase;
	}
	
	public JMenu getRetour() {
		return menu.retour;
	}
    

	public JMenuItem getQuiter() {
		return menu.quiter;
	}


	public void setQuiter(JMenuItem quiter) {
		menu.quiter = quiter;
	}


	public JMenuItem getMotpass() {
		return menu.motpass;
	}


	public void setMotpass(JMenuItem motpass) {
		menu.motpass = motpass;
	}


	public JMenuItem getAjoutprodui() {
		return menu.ajoutprodui;
	}


	public void setAjoutprodui(JMenuItem ajoutprodui) {
		menu.ajoutprodui = ajoutprodui;
	}


	public JMenuItem getListproduit() {
		return menu.listproduit;
	}


	public void setListproduit(JMenuItem listproduit) {
		menu.listproduit = listproduit;
	}


	public JMenuItem getSortiproduit() {
		return menu.sortiproduit;
	}


	public void setSortiproduit(JMenuItem sortiproduit) {
		menu.sortiproduit = sortiproduit;
	}	
	
	//card2
	
	public JTextField getNom() {
		return card2.nom;
	}


	public void setNom(JTextField nom) {
		card2.nom = nom;
	}


	public JTextField getReferance() {
		return card2.referance;
	}


	public void setReferance(JTextField referance) {
		card2.referance = referance;
	}


	public JTextField getPrixAchat() {
		return card2.prixAchat;
	}


	public void setPrixAchat(JTextField prixAchat) {
		card2.prixAchat = prixAchat;
	}


	public JTextField getPrixvente() {
		return card2.prixvente;
	}


	public void setPrixvente(JTextField prixvente) {
		card2.prixvente = prixvente;
	}


	public JTextField getQte() {
		return card2.qte;
	}


	public void setQte(JTextField qte) {
		card2.qte = qte;
	}


	public JTextField getDate() {
		return card2.date;
	}


	public void setDate(JTextField date) {
		card2.date = date;
	}


	public JButton getAnnule() {
		return card2.annule;
	}

	public JButton getOk() {
		return card2.ok;
	}


}
