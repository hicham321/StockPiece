package org1.hicham.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.View;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class addingquantity extends JFrame{

	//for the name of the product 
	private JButton ajoutlot = new JButton("ajout");

	private JButton modifieLot = new JButton("modifie");

	private JButton supprimLot = new JButton("supprimé");


	private JTextField qte = new JTextField(10);

	private JLabel labqte = new JLabel("الكمية");

	private JButton annule = new JButton("الغاء");

	private JButton ok = new JButton("موافقة");

	//lower end of jpanel will contain labels for Lot quantity, global quantity and price
	private JLabel labQteLot = new JLabel("الكمية الجزئية");
	private JLabel labQteGlobal = new JLabel("الكمية الكلية");
	private JLabel labprixAchat = new JLabel("ثمن الشراء");
	private JLabel labprixVente = new JLabel("ثمن البيع");

	//these are modified labels to be set to the buy and sell prices and qte Lot and qte globale
	private JLabel prixAchat = new JLabel("");
	private JLabel prixVente = new JLabel("0");
	private JLabel qteLot  = new JLabel("");
	private JLabel qteGlobal = new JLabel("");

	//for the reference of the product
	//the model's only job is to hold information
	final DefaultComboBoxModel ajoutprodmodel = new DefaultComboBoxModel();


	final JComboBox ajoutProduitComboBox  = new JComboBox(ajoutprodmodel);    

	private JScrollPane ajoutProduitListScrol = new JScrollPane(ajoutProduitComboBox); 

	//this is for the product type
	final DefaultComboBoxModel ajoutLotmodel = new DefaultComboBoxModel();

	final JComboBox ajoutLotComboBox  = new JComboBox(ajoutLotmodel);    

	private JScrollPane ajoutRefListScrol = new JScrollPane(ajoutLotComboBox); 
	
	//adding popup menu for lot
	
	private JButton choixBtn = new JButton();
	
	private JPopupMenu  popmenu= new JPopupMenu();
	
	JMenuItem ajouItem = new JMenuItem("اضافة");
	
	JMenuItem modifieItem = new JMenuItem("تغيير");

	JMenuItem supItem = new JMenuItem("الغاء");
	
	//adding popup menu for lot

	private JButton choixBtnDesignation = new JButton();

	private JPopupMenu  popmenuProduit= new JPopupMenu();

	private JMenuItem ajouItemProd = new JMenuItem("اضافة");

	private JMenuItem modifieItemProd = new JMenuItem("تغيير");

	private JMenuItem supItemProd = new JMenuItem("الغاء");


	public addingquantity(){
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setBounds(0,0,screenSize.width, screenSize.height);
	    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(true);
		setTitle("ادخال منتوج");
		setSize(400,400);        
		setLocationRelativeTo(null);
		this.ajoutprodmodel.addElement("");

		AutoCompleteDecorator.decorate(ajoutProduitComboBox);
		ajoutProduitComboBox.setSelectedIndex(0);

		this.ajoutLotmodel.addElement("");
		
		AutoCompleteDecorator.decorate(ajoutLotComboBox);
		ajoutLotComboBox.setSelectedIndex(0);


		JPanel panel = new JPanel();
		panel.setLayout(null);

		panel.setBackground(Color.decode("#d2fdf9"));
		panel.add(qte);
		panel.add(labqte);
		panel.add(labQteLot);
		panel.add(labQteGlobal);
		panel.add(labprixAchat);
		panel.add(labprixVente);
		panel.add(prixAchat);
		panel.add(prixVente);
		panel.add(qteGlobal);
		panel.add(qteLot);


		panel.add(ok);
		panel.add(annule);
		panel.add(ajoutProduitComboBox);
		panel.add(ajoutLotComboBox);

		//adding popupmenu for Lot
		panel.add(choixBtn);
		this.popmenu.add(ajouItem);
		this.popmenu.add(modifieItem);
		this.popmenu.add(supItem);
		// adding popupmenu for product
        panel.add(choixBtnDesignation);
        this.popmenuProduit.add(ajouItemProd);
        this.popmenuProduit.add(modifieItemProd);
        this.popmenuProduit.add(supItemProd);

		
		qte.setBounds(30, 100, 90, 20);
		qte.setText("0");
		labqte.setBounds(130, 100, 90, 20);
		labQteLot.setBounds(300, 250, 90, 20);
		labQteGlobal.setBounds(300, 280, 90, 20);
		labprixAchat.setBounds(110, 250, 90, 20);
		labprixVente.setBounds(110, 280, 90, 20);
		prixAchat.setBounds(70, 250, 90, 20);
		prixVente.setBounds(70, 280, 90, 20);
		qteGlobal.setBounds(250, 280, 90, 20);
		qteLot.setBounds(250, 250, 90, 20);
		ok.setBounds(120, 330, 90, 20);
		annule.setBounds(230, 330, 90, 20);
		ajoutProduitComboBox.setBounds(100, 20, 180, 20);
		ajoutLotComboBox.setBounds(100, 50, 180, 20);
		choixBtn.setBounds(330, 50, 20, 20);
		choixBtnDesignation.setBounds(330, 20, 20, 20);


		this.add(panel);

	}
	public void addajoutlistner(ActionListener listner){
		this.ok.addActionListener(listner);
		this.annule.addActionListener(listner);
        this.choixBtn.addActionListener(listner);
        this.choixBtnDesignation.addActionListener(listner);
        //lot
        this.ajouItem.addActionListener(listner);
        this.modifieItem.addActionListener(listner);
        this.supItem.addActionListener(listner);
        //produit
        this.ajouItemProd.addActionListener(listner);
        this.modifieItemProd.addActionListener(listner);
        this.supItemProd.addActionListener(listner);
        this.ajoutProduitComboBox.addActionListener(listner);
        this.ajoutLotComboBox.addActionListener(listner);


	}



	public JButton getAjoutlot() {
		return ajoutlot;
	}
	public void setAjoutlot(JButton ajoutlot) {
		this.ajoutlot = ajoutlot;
	}
	public JButton getModifieLot() {
		return modifieLot;
	}
	public void setModifieLot(JButton modifieLot) {
		this.modifieLot = modifieLot;
	}
	

	public JButton getAnnule() {
		return annule;
	}

	public JButton getOk() {
		return ok;
	}
	
	public JTextField getQte() {
		return qte;
	}
	public void setPrixAchat(JLabel prixAchat) {
		this.prixAchat = prixAchat;
	}
	
    public JLabel getPrixAchat(){
    	return this.prixAchat; 
    }
    
	public void setPrixVente(JLabel prixVente) {
		this.prixVente = prixVente;
	}
     
	public JLabel getPrixVente() {
		return prixVente;
	}
	public JLabel getQteLot() {
		return this.qteLot;
	}

	public JLabel getQteGlobal( ) {
		return this.qteGlobal ;
	}
	
	
	public JButton getChoixBtn() {
		return this.choixBtn;
	}
	
	public JPopupMenu getPopmenu() {
		return this.popmenu;
	}
	public JButton getChoixBtnDesignation() {
		return choixBtnDesignation;
	}
	
	public JPopupMenu getPopmenuProduit() {
		return popmenuProduit;
	}
	//
	public JMenuItem getAjouItem() {
		return ajouItem;
	}
	
	public JMenuItem getModifieItem() {
		return modifieItem;
	}
	
	public JMenuItem getSupItem() {
		return supItem;
	}
	
	public JMenuItem getAjouItemProd() {
		return ajouItemProd;
	}
	
	public JMenuItem getModifieItemProd() {
		return modifieItemProd;
	}
	
	public JMenuItem getSupItemProd() {
		return supItemProd;
	}
    //window listners
	public void addWindowListnerToAddingquantity(WindowListener winddowListner){
		
	}
	public JComboBox getAjoutProduitComboBox() {
		return ajoutProduitComboBox;
	}
	public JComboBox getAjoutLotComboBox() {
		return ajoutLotComboBox;
	}
	
	
}


			