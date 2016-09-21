package org1.hicham.view;
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
	
	private ListFactureTout card7= new ListFactureTout();
	
	private Zakat card8= new Zakat();

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
		cards.add(card7, "Card 7");
		cards.add(card8, "Card 8");


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
		
		//card8(zakat)	
		this.card8.zakatCalcButton.addActionListener(listner);
	}
	//this is a menu listner for menus with no menu items
	public void addFrameMenulistner(MenuListener menListner){

		this.menu.retour.addMenuListener(menListner);
		this.menu.listFactureTout.addMenuListener(menListner);
		this.menu.zakatMenu.addMenuListener(menListner);
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
	
	public JMenu getListFactureTout() {
		return menu.listFactureTout;
	}

	public JMenu getZakatMenu() {
		return menu.zakatMenu;
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

	public JTextField getNumFact() {
		return card2.numfact;
	}


	public void setNumFact(JTextField nom) {
		card2.numfact = nom;
	}


	public JTextField getNomFournisseur() {
		return card2.nomFournisseur;
	}


	public void setNomFournisseur(JTextField referance) {
		card2.nomFournisseur = referance;
	}
	public JLabel getPrixTotallab() {
		return card2.prixTotal;
	}

	//this is the total price for the products 
	public void setPrixTotalLab(JLabel prixTotalLab) {
		this.card2.prixTotal = prixTotalLab;
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

	public JButton getAnnuleAjout() {
		return card2.annule;
	}

	public JButton getOkAjout() {
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
	//card7

	public JTable getListFactureToutTable() {
		return card7.listFactureToutTable;
	} 
    //card8
	public JTable getListProduitZakatTable() {
		return card8.listProduitZakatTable;
	}
	public JTextField getZakatText() {
		return card8.zakatText;
	}

	public JLabel getZakatTotal() {
		return card8.zakatTotal;
	}

	public JLabel getZakatFinal() {
		return card8.zakatFinal;
	}
	public void setZakatFinal(JLabel zakatFinal) {
		card8.zakatFinal = zakatFinal;
	}
	public JButton getZakatCalcButton() {
		return card8.zakatCalcButton;
	}
}
