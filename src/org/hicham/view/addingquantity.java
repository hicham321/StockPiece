package org.hicham.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
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
	private JLabel prixVente = new JLabel("");
	private JLabel qteLot  = new JLabel("");
	private JLabel qteGlobal = new JLabel("");

	//for the reference of the product
	//the model's only job is to hold information
	final DefaultComboBoxModel ajoutprodmodel = new DefaultComboBoxModel();


	final JComboBox ajoutProduitComboBox  = new JComboBox(ajoutprodmodel);    

	private JScrollPane ajoutProduitListScrol = new JScrollPane(ajoutProduitComboBox); 

	//this is for the product type
	final DefaultComboBoxModel ajoutRefmodel = new DefaultComboBoxModel();

	final JComboBox ajoutRefComboBox  = new JComboBox(ajoutRefmodel);    

	private JScrollPane ajoutRefListScrol = new JScrollPane(ajoutRefComboBox); 
	
	//adding popup menu for lot
	
	private JButton choixBtn = new JButton();
	
	private JPopupMenu  popmenu= new JPopupMenu();
	
	JMenuItem ajouItem = new JMenuItem("اضافة");
	
	JMenuItem modifieItem = new JMenuItem("تغيير");

	JMenuItem supItem = new JMenuItem("الغاء");
	
	//adding popup menu for lot

	private JButton choixBtnDesignation = new JButton();

	private JPopupMenu  popmenuProduit= new JPopupMenu();

	JMenuItem ajouItemProd = new JMenuItem("اضافة");

	JMenuItem modifieItemProd = new JMenuItem("تغيير");

	JMenuItem supItemProd = new JMenuItem("الغاء");


	public addingquantity(){
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setBounds(0,0,screenSize.width, screenSize.height);
		setResizable(true);
		setTitle("ادخال منتوج");
		setSize(400,400);        
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		this.ajoutprodmodel.addElement("dcd");
		this.ajoutprodmodel.addElement("fgfg");
		this.ajoutprodmodel.addElement("dfcvbbcd");
		this.ajoutprodmodel.addElement("qsdqsd");
		this.ajoutprodmodel.addElement("klmkjlm");
		this.ajoutprodmodel.addElement("uioio");
		this.ajoutprodmodel.addElement("azee");
		this.ajoutprodmodel.addElement("xwxcxw");

		AutoCompleteDecorator.decorate(ajoutProduitComboBox);
		ajoutProduitComboBox.setSelectedIndex(0);

		this.ajoutRefmodel.addElement("34");
		this.ajoutRefmodel.addElement("84784");
		this.ajoutRefmodel.addElement("8747");
		this.ajoutRefmodel.addElement("12132");
		this.ajoutRefmodel.addElement("1200998");
		this.ajoutRefmodel.addElement("3626");
		this.ajoutRefmodel.addElement("5343");
		this.ajoutRefmodel.addElement("2346544");

		AutoCompleteDecorator.decorate(ajoutRefComboBox);
		ajoutRefComboBox.setSelectedIndex(0);


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
		panel.add(ajoutRefComboBox);

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
		ajoutRefComboBox.setBounds(100, 50, 180, 20);
		choixBtn.setBounds(330, 50, 20, 20);
		choixBtnDesignation.setBounds(330, 20, 20, 20);


		this.add(panel);

	}
	public void addajoutlistner(ActionListener listner){
		this.ok.addActionListener(listner);
		this.annule.addActionListener(listner);
        this.choixBtn.addActionListener(listner);
        this.choixBtnDesignation.addActionListener(listner);

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

	public void setPrixAchat(JLabel prixAchat) {
		this.prixAchat = prixAchat;
	}

	public void setPrixVente(JLabel prixVente) {
		this.prixVente = prixVente;
	}

	public void setQteLot(JLabel qteLot) {
		this.qteLot = qteLot;
	}

	public void setQteGlobal(JLabel qteGlobal) {
		this.qteGlobal = qteGlobal;
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
	
    


}


			