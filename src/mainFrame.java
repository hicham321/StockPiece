import java.awt.CardLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class mainFrame extends JFrame {
    JPanel cards ;
    
    
	
	mainPanel card1 = new mainPanel();
	
	Ajout card2= new Ajout();
	
	//ViewAjoutEnf card3= new ViewAjoutEnf();
	
	
	public mainFrame(){
		
        setResizable(true);
        //setSize(400,400); 
        setExtendedState(JFrame.MAXIMIZED_BOTH); 

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cards = new JPanel(new CardLayout());
        
        cards.add(card1, "Card 1");
        cards.add(card2, "Card 2");
//        cards.add(card3, "Card 3");
        
        getContentPane().add(cards); 
	
	}
	//Card1
	public void addFrameActionLisner(ActionListener listner){
		this.card1.ajoutbase.addActionListener(listner);
		this.card1.ajoutprodui.addActionListener(listner);
		this.card1.but.addActionListener(listner);
		this.card1.listproduit.addActionListener(listner);
		this.card1.motpass.addActionListener(listner);
		this.card1.quiter.addActionListener(listner);
		this.card1.sortiproduit.addActionListener(listner);
		
		this.card2.annule.addActionListener(listner);
		this.card2.ok.addActionListener(listner);
		

	}
	
	public JButton getBut() {
		return card1.but;
	}


	public void setBut(JButton but) {
		card1.but = but;
	}


	public JMenuItem getAjoutbase() {
		return card1.ajoutbase;
	}


	public void setAjoutbase(JMenuItem ajoutbase) {
		card1.ajoutbase = ajoutbase;
	}


	public JMenuItem getQuiter() {
		return card1.quiter;
	}


	public void setQuiter(JMenuItem quiter) {
		card1.quiter = quiter;
	}


	public JMenuItem getMotpass() {
		return card1.motpass;
	}


	public void setMotpass(JMenuItem motpass) {
		card1.motpass = motpass;
	}


	public JMenuItem getAjoutprodui() {
		return card1.ajoutprodui;
	}


	public void setAjoutprodui(JMenuItem ajoutprodui) {
		card1.ajoutprodui = ajoutprodui;
	}


	public JMenuItem getListproduit() {
		return card1.listproduit;
	}


	public void setListproduit(JMenuItem listproduit) {
		card1.listproduit = listproduit;
	}


	public JMenuItem getSortiproduit() {
		return card1.sortiproduit;
	}


	public void setSortiproduit(JMenuItem sortiproduit) {
		card1.sortiproduit = sortiproduit;
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
