package org.hicham.view;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;


public class mainFrame extends JFrame {

	public JPanel cards ;

	private menubar menu= new menubar();

	private mainPanel card1 = new mainPanel();

	private Ajout card2= new Ajout();
	
	private Destockage card3= new Destockage();
	
	private ListProduit card4= new ListProduit();
	
	private ListeFactureFournis card5= new ListeFactureFournis();
	
	private ListFactureClient card6= new ListFactureClient();



	//ViewAjoutEnf card3= new ViewAjoutEnf();


	public mainFrame(){
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setBounds(0,0,screenSize.width, screenSize.height);
     
		setResizable(true);
		//setSize(400,400); 
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//this.add(menu);
		this.setJMenuBar(menu.menu);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cards = new JPanel(new CardLayout());

		cards.add(card1, "Card 1");
		cards.add(card2, "Card 2");
		cards.add(card3, "Card 3");
		cards.add(card4, "Card 4");
		cards.add(card5, "Card 5");
		cards.add(card6, "Card 6");


		getContentPane().add(cards); 
        setEnabled(false);
	}
	//Card1
	public void addFrameActionListener(ActionListener listner){
		this.menu.ajoutbase.addActionListener(listner);
		this.menu.ajoutprodui.addActionListener(listner);
		this.card1.but.addActionListener(listner);
		this.menu.listproduit.addActionListener(listner);
		this.menu.motpass.addActionListener(listner);
		this.menu.quiter.addActionListener(listner);
		this.menu.sortiproduit.addActionListener(listner);
		this.menu.listFactureEntre.addActionListener(listner);
		this.menu.listFactureSortie.addActionListener(listner);

		//this.menu.retour.addActionListener(listner);
		this.card2.ajoutproduit.addActionListener(listner);
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


	public JMenuItem getListFactureEntre() {
		return menu.listFactureEntre;
	}


	public JMenuItem getListFactureSortie() {
		return menu.listFactureSortie;
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


	public JMenuItem getSortiproduit() {
		return menu.sortiproduit;
	}

	public void setSortiproduit(JMenuItem sortiproduit) {
		menu.sortiproduit = sortiproduit;
	}	

	//card2

	public JTextField getNom() {
		return card2.numfact;
	}


	public void setNom(JTextField nom) {
		card2.numfact = nom;
	}


	public JTextField getReferance() {
		return card2.nomFournisseur;
	}


	public void setReferance(JTextField referance) {
		card2.nomFournisseur = referance;
	}
	public JLabel getPrixTotalLab() {
		return card2.prixTotalLab;
	}

	//this is the total price for the products 
	public void setPrixTotalLab(JLabel prixTotalLab) {
		this.card2.prixTotalLab = prixTotalLab;
	}


	/*public JTextField getPrixAchat() {
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
	 */

	public JButton getAnnule() {
		return card2.annule;
	}

	public JButton getOk() {
		return card2.ok;
	}

	public JButton getAjoutproduitButton() {
		return card2.ajoutproduit;
	}


	public JTable getListProduitAjoutTable() {
		return card2.listProduitAjoutTable;
	}

	
	//card4
	//set and get for ListProduitTable
	//to  set JTable for a new Table model there is embedded method (setModel()) for this
	
	public JTable getListProduitTable() {
		return card4.listProduitTable;
	}
	//card5
	public JTable getListFactureEntreTable() {
		return card5.listFactureFournis;
	}
	//card6
	public JTable getListFactureSortieTable() {
		return card6.listFactureClient;
	}
	
	
	
	


}
