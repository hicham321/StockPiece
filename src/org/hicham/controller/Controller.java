package org.hicham.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.hicham.model.model;
import org.hicham.view.AjoutDonneInterface;
import org.hicham.view.AjoutProdInterface;
import org.hicham.view.ChangePass;
import org.hicham.view.Register;
import org.hicham.view.addingquantity;
import org.hicham.view.mainFrame;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import net.sf.jasperreports.crosstabs.fill.JRPercentageCalculatorFactory.IntegerPercentageCalculator;

//This is the controller class of the project

public class Controller {

	private mainFrame frame = new mainFrame();

	private model model = new  model();

	private Register register = new Register();

	private File file ;

	private int returnVal;

	private List<Integer> panelList = new ArrayList<>();

	private Map<String,Integer> idDesignationProdList= new HashMap<>();
	
	//this new field is to be debugged intensively later
	private int idProd =0;

	private JFileChooser filechooser = new JFileChooser();

	private addingquantity addingquantity ;

	private ChangePass changePass= new ChangePass();

	private AjoutDonneInterface ajoutDonneInterface= new AjoutDonneInterface();

	private AjoutProdInterface ajoutProdInterface= new AjoutProdInterface();

	public Controller(mainFrame frame, model model,Register register,addingquantity addingquantity,ChangePass changePass,AjoutDonneInterface ajoutDonneInterface, AjoutProdInterface ajoutProdInterface ){

		this.frame= frame;

		this.model= model;

		this.register = register;

		this.addingquantity= addingquantity;

		this.changePass= changePass;

		this.ajoutDonneInterface=ajoutDonneInterface;

		this.register.AddRegisterActionlistner(new RegisterActionListner());

		this.frame.addFrameActionListener( new FrameActionListener());

		this.frame.addFrameMenulistner(new FrameMenuListener());

		this.addingquantity.addajoutlistner(new AjoutActionListner());

		this.addingquantity	.addWindowListnerToAddingquantity(new WindowListenerForAddingquantity());

		this.changePass.addChangePassListener(new ChangePassActionListener());

		this.ajoutDonneInterface.addAjoutDonneInterface(new AjoutDonneInterfaceListner());

		this.ajoutProdInterface.addAjoutProdInterfaceListener(new AjoutProdInterfaceListener());

	}
	//this is the MainFrame action listener it contains listeners for all the panels inside the main frame

	class FrameActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e)   {
			if(e.getSource()==frame.getAjoutbase()){
				returnVal = filechooser.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION){
					file = filechooser.getSelectedFile();
				}
			}

			if(e.getSource()== frame.getAjoutprodui()){
				showSecondCard();	
				//for navigating through panels 
				panelList.add(2);
			}
			if(e.getSource()==frame.getAjoutproduitButton()) {
				try{
					refreshProductComboBox();
					frame.setEnabled(false);
					addingquantity.setVisible(true);
				}catch(Exception ex ){
					ex.printStackTrace();
				}

			}
			if (e.getSource()==frame.getMotpass()) {
				frame.setEnabled(false);
				changePass.setVisible(true);
			}
			if(e.getSource()== frame.getSortiproduit()){
				showThirdCard();
				panelList.add(3);
			}
			if(e.getSource()==frame.getListproduit()){
				try{
					ResultSet rs= model.listProduitToutResultat();
					DefaultTableModel dtm = model.buildTableModel(rs);
					frame.getListProduitTable().setModel(dtm);
					showFourthCard();
					panelList.add(4);
				}catch(SQLException ex){
					ex.printStackTrace();
				}
			}
			if(e.getSource()==frame.getListFactureEntre()){
				try{
					ResultSet rs= model.listFactureEntre();
					DefaultTableModel dtm = model.buildTableModel(rs);
					frame.getListFactureEntreTable().setModel(dtm);
					showFifthCard();
					panelList.add(5);
				}catch(SQLException ex){
					ex.printStackTrace();
				}	
			}
			if (e.getSource()==frame.getListFactureSortie()) {
				try{
					ResultSet rs= model.listFactureSortie();
					DefaultTableModel dtm = model.buildTableModel(rs);
					frame.getListFactureSortieTable().setModel(dtm);
					showSixthCard();
					panelList.add(6);
				}catch(SQLException ex){
					ex.printStackTrace();
				}

			}
			if (e.getSource()==frame.getZakatCalcButton()) {
				if(Double.parseDouble(frame.getZakatText().getText())<100 && Double.parseDouble(frame.getZakatText().getText())>0 ){
					//calculate zakat total

				}
				else{
					frame.getZakatText().setText("");
					JOptionPane.showMessageDialog(null, "غلط في الفورمة,ادخل رقم ما بين 0 و 100");
				}
			}
			if (e.getSource()==frame.getOkAjout()) {
				//insertion from Jtable code here 

				//settig the JTable to disabled

			}


		}


	}
	//this is MenuLisner class
	class FrameMenuListener implements MenuListener{

		@Override
		public void menuDeselected(MenuEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void menuSelected(MenuEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==frame.getRetour()){
				showFirstCard();
				//for going back and forth between layouts
				panelList.add(1);

			}
			if (e.getSource()==frame.getListFactureTout()) {
				try{
					ResultSet rs= model.listFactureTout();
					DefaultTableModel dtm = model.buildTableModel(rs);
					frame.getListFactureToutTable().setModel(dtm);
					showSeventhCard();
					panelList.add(7);
				}catch(SQLException ex){
					ex.printStackTrace();
				}

			}
			if (e.getSource()==frame.getZakatMenu()) {
				try{
					ResultSet rs= model.listProduitZakat();
					DefaultTableModel dtm = model.buildTableModel(rs);
					frame.getListProduitZakatTable().setModel(dtm);
					//TableColumn tcol = frame.getListProduitZakatTable().getColumnModel().getColumn(0);
					//frame.getListProduitZakatTable().getColumnModel().removeColumn(tcol);
					int[]columnsToBeDeleted= {0,2,2,5};
					model.deleteMultipleColumns(frame.getListProduitZakatTable(),columnsToBeDeleted );
					//frame.getListProduitZakatTable().setAutoCreateColumnsFromModel(false);
					showEighCard();
					panelList.add(8);
				}catch(SQLException ex){
					ex.printStackTrace();
				}

			}
		}

		@Override
		public void menuCanceled(MenuEvent e) {
			// TODO Auto-generated method stub

		}

	}




	//This is a separate actionListner class for register logic 
	class RegisterActionListner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()== register.getOk()){
				try{
					model.connectio("jdbc:ucanaccess://C:/Users/Hicham/ddd.accdb");
					//model.connectio("jdbc:ucanaccess://C:/Users/pc4u/ddd.accdb");
					boolean thereispass= model.checkdatabase();
					System.out.println("database pass "+model.passdatabase().toCharArray());
					System.out.println("database user "+model.usernamedatabase());
					System.out.println("text pass "+register.getPassText());
					System.out.println("text user"+register.getUtilisateurText());
					//the hashing should be done after  adding the interface for changing the password
					if(thereispass){

						if((Arrays.equals(model.passdatabase().toCharArray(), register.getPassText()))&(model.usernamedatabase().equals(register.getUtilisateurText()))){
							register.dispose();
							enableFrame();
							//frame.dispose();
						}	
						else{
							register.setUtiltext("");
							register.setMotpasstext("");
							JOptionPane.showMessageDialog(null, "Mot de pass ou nom d'utilisateur incorrect");

						}

					}
					else{
						//do something if there is no password
						JOptionPane.showMessageDialog(null, "Crie un a utilisateur et un mot de passe");
					}
				}catch(Exception s){
					s.printStackTrace();
				}
			}
			if(e.getSource()== register.getAnnule()){

				register.dispose();
				enableFrame();

			}

		}


	} 

	class AjoutActionListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==addingquantity.getAnnule()) {
				addingquantity.dispose();
				enableFrame();

			}
			if (e.getSource()==addingquantity.getOk()) {
				try{
					addingquantity.dispose();

					//code for Jtable insertions
					DefaultTableModel dtm = new DefaultTableModel();
					frame.getListProduitAjoutTable().setModel(dtm);


					enableFrame();

					//chacking if the input is a number or something else
				}catch(Exception ex){
					ex.printStackTrace();
				}

			}
			if (e.getSource()==addingquantity.getChoixBtn()) {
				//the show method uses the position of a component as a parameter in a gui, here it's used to show the popup menu according to the position of the chouxbtn
				addingquantity.getPopmenu().show(addingquantity.getChoixBtn(), addingquantity.getChoixBtn().getBounds().x-312, addingquantity.getChoixBtn().getBounds().y-65 + addingquantity.getChoixBtn().getBounds().height);
			}
			if (e.getSource()==addingquantity.getChoixBtnDesignation()) {
				addingquantity.getPopmenuProduit().show(addingquantity.getChoixBtnDesignation(), addingquantity.getChoixBtnDesignation().getBounds().x-312, addingquantity.getChoixBtnDesignation().getBounds().y-65 + addingquantity.getChoixBtnDesignation().getBounds().height);
			}

			//adding Lot
			if(e.getSource()==addingquantity.getAjouItem()){

				ajoutDonneInterface.setVisible(true);
				disableAddingQuantity();
			}
			if(e.getSource()==addingquantity.getSupItem()){
				//delete the corresponding lot 
				disableAddingQuantity();
			}
			if(e.getSource()==addingquantity.getModifieItem()){
				//modify he corresponding lot
				disableAddingQuantity();
			}

			//adding product
			if (e.getSource()== addingquantity.getAjouItemProd()) {
				ajoutProdInterface.setVisible(true);
				disableAddingQuantity();
			}
			if (e.getSource()== addingquantity.getModifieItemProd()) {

				ajoutProdInterface.setVisible(true);
				disableAddingQuantity();
			}
			if (e.getSource()== addingquantity.getSupItemProd()) {
				//deleting a product from database
				disableAddingQuantity();
			}

			if(e.getSource()== addingquantity.getAjoutProduitComboBox()){
				try{
					//action when a product gets selected:
					JComboBox comboBox = (JComboBox) e.getSource();
					Object selected = comboBox.getSelectedItem();
					idProd = idDesignationProdList.get(selected.toString());
					DefaultComboBoxModel dcm= model.buildComboModelLot(idProd);
					addingquantity.getAjoutLotComboBox().setModel(dcm);
					//System.out.println(addingquantity.getAjoutProduitComboBox().getSelectedIndex());
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
			if (e.getSource()== addingquantity.getAjoutLotComboBox()) {
				try{
					JComboBox comboBox = (JComboBox) e.getSource();
					int selected = comboBox.getSelectedIndex();
					List<Integer> idLotList= model.getIdLot(idProd);
					System.out.println(selected);
					//setting the labels in the addingquantity view to the actual database values from the lot
					//need to write a query to get the values from db to view
					List<Double>l=model.getSelectedLotRow(idLotList.get(selected),idProd);
					addingquantity.getPrixVente().setText(l.get(1).toString());
					addingquantity.getPrixAchat().setText(l.get(0).toString());
					addingquantity.getQteLot().setText(l.get(2).toString());
					int qteGlobal= model.getQteGlobalProd(idProd);
					addingquantity.getQteGlobal().setText(Integer.toString(qteGlobal));
					//the selected Lot id 
					
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}


		}

	}
	class WindowListenerForAddingquantity implements WindowListener{

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			frame.setEnabled(true);
			System.out.println("this shit executes");

		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			frame.setEnabled(true);
			System.out.println("this shit executes");

		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			frame.setEnabled(true);
			System.out.println("this shit executes");

		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			frame.setEnabled(true);
			System.out.println("this shit executes");

		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			frame.setEnabled(true);
			System.out.println("this shit executes");
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			frame.setEnabled(true);
			System.out.println("this shit executes");

		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			frame.setEnabled(true);
			System.out.println("this shit executes");

		}
	}

	class ChangePassActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource()==changePass.getOk()) {


				changePass.dispose();
				enableFrame();

			}
			if (arg0.getSource()==changePass.getAnnule()) {

				changePass.dispose();
				enableFrame();

			}

		}

	}
	class AjoutDonneInterfaceListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource()==ajoutDonneInterface.getOk()) {
				ajoutDonneInterface.dispose();
				addingquantity.setEnabled(true);
				enableFrame();
			}
			if (e.getSource()==ajoutDonneInterface.getAnnule()) {
				ajoutDonneInterface.dispose();
				addingquantity.setEnabled(true);
				enableFrame();
			}

		}

	}
	class AjoutProdInterfaceListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()== ajoutProdInterface.getOk()){
				try{
					//check if the product exists in the database
					List<String> allProducts= model.allProducts();
					if(model.checkProdAlreadyInserted(allProducts, ajoutProdInterface.getTextProd().getText())){
						JOptionPane.showMessageDialog(null, "هذا المنتوج موجود في لائحة المنتوجات");

					}
					else{
						//adding designation of product to database
						model.insertProd(ajoutProdInterface.getTextProd().getText());
						refreshProductComboBox();
						enableAddingQuantity();
						frame.toFront();
						addingquantity.toFront();
					}
				}catch(Exception ex){
					ex.printStackTrace();
				}

			}
			if(e.getSource()== ajoutProdInterface.getAnnule()){
				enableAddingQuantity();
				frame.toFront();
				addingquantity.toFront();
			}
		}


	}
	//a method for navigating through the panels Uses a list of panel indexes

	public void NavigatePanel(boolean back, boolean forth){

		//forth is only true if back is true at least once 
		int dernierElementList= panelList.get(panelList.size()-1);
		if(back){
			switch (dernierElementList) {
			case 1:
				showFirstCard();
				break;
			case 2:
				showSecondCard();
				break;
			case 3:
				showThirdCard();
				break;


			}
		}
		if(forth){
			switch (dernierElementList) {
			case 1:
				showFirstCard();
				break;
			case 2:
				showSecondCard();
				break;
			case 3:
				showThirdCard();
				break;


			}
		}


	} 
	public void showFirstCard(){
		CardLayout cardLayout = (CardLayout) frame.cards.getLayout();
		cardLayout.show(frame.cards, "Card 1");	
	}

	public void showSecondCard(){
		CardLayout cardLayout = (CardLayout) frame.cards.getLayout();
		cardLayout.show(frame.cards, "Card 2");	
	}
	public void showThirdCard(){
		CardLayout cardLayout = (CardLayout) frame.cards.getLayout();
		cardLayout.show(frame.cards, "Card 3");	
	}
	public void showFourthCard(){
		CardLayout cardLayout = (CardLayout) frame.cards.getLayout();
		cardLayout.show(frame.cards, "Card 4");	
	}
	public void showFifthCard(){
		CardLayout cardLayout = (CardLayout) frame.cards.getLayout();
		cardLayout.show(frame.cards, "Card 5");	
	}
	public void showSixthCard(){
		CardLayout cardLayout = (CardLayout) frame.cards.getLayout();
		cardLayout.show(frame.cards, "Card 6");	
	}
	public void showSeventhCard(){
		CardLayout cardLayout = (CardLayout) frame.cards.getLayout();
		cardLayout.show(frame.cards, "Card 7");	
	}
	public void showEighCard(){
		CardLayout cardLayout = (CardLayout) frame.cards.getLayout();
		cardLayout.show(frame.cards, "Card 8");	
	}

	public void enableFrame(){
		frame.setEnabled(true);
		frame.toFront();
	}
	public void disableAddingQuantity(){
		frame.setEnabled(false);
		addingquantity.setEnabled(false);
	}
	public void enableAddingQuantity(){
		ajoutProdInterface.dispose();
		addingquantity.setEnabled(true);
	}

	//this is to put data from teh database into the combobox
	public void refreshProductComboBox()throws SQLException{
		DefaultComboBoxModel dcm= model.buildComboModel();
		addingquantity.getAjoutProduitComboBox().setModel(dcm);
		idDesignationProdList= model.getIDproductDesignation();
	}

}


