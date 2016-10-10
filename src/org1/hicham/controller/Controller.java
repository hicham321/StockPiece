package org1.hicham.controller;

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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import net.sf.jasperreports.crosstabs.fill.JRPercentageCalculatorFactory.IntegerPercentageCalculator;
import org1.hicham.model.model;
import org1.hicham.view.AjoutDonneInterface;
import org1.hicham.view.AjoutProdInterface;
import org1.hicham.view.ChangePass;
import org1.hicham.view.InterfaceModifieLot;
import org1.hicham.view.InterfaceModifieProd;
import org1.hicham.view.InterfaceSuppLot;
import org1.hicham.view.InterfaceSuppProd;
import org1.hicham.view.Register;
import org1.hicham.view.addingquantity;
import org1.hicham.view.addingquantity2;
import org1.hicham.view.mainFrame;

import org.apache.commons.lang3.math.NumberUtils;


//This is the controller class of the project

public class Controller {

	private mainFrame frame = new mainFrame();

	private model model = new  model();

	private Register register = new Register();

	private File file ;
	
	String filePath="";

	private int returnVal;

	private List<Integer> panelList = new ArrayList<>();

	private Map<String,Integer> idDesignationProdList= new HashMap<>();
	
	private LinkedHashMap<Integer,Integer> insertedIdLotIdProd= new LinkedHashMap();
	
	double totalAchat=0;

	
	//this new field is to be debugged intensively later
	private int idProd =0;
	
	private int idLot=0;
	
	private List<Integer>insertedIdProdList= new ArrayList<>();
	
	private List<Integer>insertedIdLotList= new ArrayList<>();
	
	private List<Integer> idLotList= new ArrayList<>();

	private JFileChooser filechooser = new JFileChooser();

	private addingquantity addingquantity ;

	private ChangePass changePass= new ChangePass();

	private AjoutDonneInterface ajoutDonneInterface= new AjoutDonneInterface();

	private AjoutProdInterface ajoutProdInterface= new AjoutProdInterface();
	
	private InterfaceModifieProd interfaceModifieProd= new InterfaceModifieProd();
	
	private InterfaceModifieLot interfaceModifieLot= new InterfaceModifieLot();
	
	private InterfaceSuppProd  interfaceSuppProd= new InterfaceSuppProd();
	
	private InterfaceSuppLot interfaceSuppLot= new InterfaceSuppLot();
	
	private DefaultTableModel tableModelForInsertions= new DefaultTableModel();
	

	
	
	//field for destockage
	private addingquantity2 addingquantity2;
	
    private Map<String,Integer> idDesignationProdList2= new HashMap<>();
	
	private LinkedHashMap<Integer,Integer> insertedIdLotIdProd2= new LinkedHashMap();
	
	double totalAchat2=0;
	
    private int idProd2 =0;
	
	private int idLot2=0;
	
	private List<Integer>insertedIdProdList2= new ArrayList<>();
	
	private List<Integer>insertedIdLotList2= new ArrayList<>();
	
	private List<Integer> idLotList2= new ArrayList<>();

	private DefaultTableModel tableModelForInsertions2= new DefaultTableModel();


	public Controller(mainFrame frame, model model,Register register,addingquantity addingquantity,ChangePass changePass,AjoutDonneInterface ajoutDonneInterface, AjoutProdInterface ajoutProdInterface,InterfaceModifieProd interfaceModifieProd,InterfaceModifieLot interfaceModifieLot,InterfaceSuppProd  InterfaceSuppProd,InterfaceSuppLot interfaceSuppLot,addingquantity2 addingquantity2 ){

		this.frame= frame;

		this.model= model;

		this.register = register;

		this.addingquantity= addingquantity;
		
		this.addingquantity2= addingquantity2;

		this.changePass= changePass;

		this.ajoutDonneInterface=ajoutDonneInterface;
		
		this.interfaceModifieProd=interfaceModifieProd;
		
		this.interfaceModifieLot= interfaceModifieLot;
		
		this.interfaceSuppProd= InterfaceSuppProd;
		
		this.interfaceSuppLot =interfaceSuppLot;

		this.register.AddRegisterActionlistner(new RegisterActionListner());

		this.frame.addFrameActionListener( new FrameActionListener());

		this.frame.addFrameMenulistner(new FrameMenuListener());

		this.addingquantity.addajoutlistner(new AjoutActionListner());

		this.addingquantity	.addWindowListnerToAddingquantity(new WindowListenerForAddingquantity());

		this.changePass.addChangePassListener(new ChangePassActionListener());

		this.ajoutDonneInterface.addAjoutDonneInterface(new AjoutDonneInterfaceListner());

		this.ajoutProdInterface.addAjoutProdInterfaceListener(new AjoutProdInterfaceListener());
		
		this.interfaceModifieProd.addModifieProdInterfaceListener(new ModifieProdInterfaceListener());
		
		this.interfaceModifieLot.addInterfaceModifieLotListener(new modifieLotInterfaceListener());
		
		this.interfaceSuppProd.addSuppProdInterfaceListener(new SuppProdInterfaceListener());
		
		this.interfaceSuppLot.addSuppLotInterfaceListener(new SuppLotInterfaceListener() );
		
		this.addingquantity2.addajoutlistner2(new AjoutActionListner2());

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
				frame.getRootPane().setDefaultButton(frame.getAjoutproduitButton());
				addingquantity.getRootPane().setDefaultButton(addingquantity.getOk());
				try{

					tableModelForInsertions = new DefaultTableModel(){ 
						String[] columns = {"نسبة الربح","مجموع البيع", "مجموع الشراء","ثمن البيع",
								"ثمن الشراء","الكمية","المنتوج"}; 

						@Override 
						public int getColumnCount() { 
							return columns.length; 
						} 

						@Override 
						public String getColumnName(int index) { 
							return columns[index]; 
						} 
					}; 
					frame.getListProduitAjoutTable().setModel(tableModelForInsertions);
					//refresh and setting textfields to empty
					resetFactureComponents();
					clearinsertedids();                    
                    enableFactureComponents();
					refreshProductComboBox();
					refreshLotComboBox();
					showSecondCard();	

					//for navigating through panels 
					panelList.add(2);
				}catch(Exception ex){

				}
			}
			
			
			
			if(e.getSource()== frame.getSortiproduit()){
				frame.getRootPane().setDefaultButton(frame.getAjoutproduit2());
				addingquantity2.getRootPane().setDefaultButton(addingquantity2.getOk2());

				try{

					tableModelForInsertions2 = new DefaultTableModel(){ 
						String[] columns = {"نسبة الربح","مجموع البيع", "مجموع الشراء","ثمن البيع",
								"ثمن الشراء","الكمية","المنتوج"}; 

						@Override 
						public int getColumnCount() { 
							return columns.length; 
						} 

						@Override 
						public String getColumnName(int index) { 
							return columns[index]; 
						} 
					}; 
					frame.getListProduitAjoutTable2().setModel(tableModelForInsertions2);
					
					//refresh and setting textfields to empty
					resetFactureComponents2();
                    clearinsertedids2();
                    enableFactureComponents2();
					refreshProductComboBox2();
					refreshLotComboBox2();
					showThirdCard();	
					//for navigating through panels 
					panelList.add(2);
				}catch(Exception ex){

				}
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
			if(e.getSource()==frame.getAjoutproduit2()) {
				try{
					refreshProductComboBox2();
					frame.setEnabled(false);
					addingquantity2.setVisible(true);
				}catch(Exception ex ){
					ex.printStackTrace();
				}

			}
			
			
			
			
			
			if (e.getSource()==frame.getMotpass()) {
				frame.setEnabled(false);
				changePass.setVisible(true);
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
			if(e.getSource()== frame.getExcelBut()){
				try{
					File file = new File("excel");
					model.exportTable(frame.getListProduitTable(), file);
					//HSSFSheet worksheet = workbook.createSheet("POI Worksheet");

				}catch(Exception ex){
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
				if("".equals(frame.getZakatText().getText())){
					JOptionPane.showMessageDialog(null, "غلط في الفورمة,ادخل نسبة الزكاة ما بين 0 و 100");

				}
				if(Double.parseDouble(frame.getZakatText().getText())<100 && Double.parseDouble(frame.getZakatText().getText())>0 ){
					//calculate zakat total
					double total=Double.parseDouble(frame.getZakatTotal().getText());
					double percentageZakat= Double.parseDouble(frame.getZakatText().getText());
					double totalZakat= (total*percentageZakat)/100;
					System.out.println(totalZakat);
					frame.getZakatFinal().setText(String.valueOf(totalZakat));
				}
				else{
					frame.getZakatText().setText("");
					JOptionPane.showMessageDialog(null, "غلط في الفورمة,ادخل رقم ما بين 0 و 100");
				}
				}
			
			if (e.getSource()==frame.getOkAjout()) {
				try{
					if (model.checkNumFacture(frame.getNumFact().getText())) {
						JOptionPane.showMessageDialog(null, "هذا الرقم موجود ادخل رقما اخر");
					}
					else{
					if("".equals(frame.getNomFournisseur().getText()) || "".equals(frame.getNumFact().getText())){
						JOptionPane.showMessageDialog(null, "ادخل اسم الممول و رقم الفاتورة");
					}
					else{
				           System.out.println(insertedIdLotList);

					//insertion into Facture code here
				    String date=model.getCurrentDate();       
				    model.insertFactureFourniss(frame.getNumFact().getText(), frame.getNomFournisseur().getText(), "fournisseur", frame.getPrixTotallab().getText(),date,Double.parseDouble(frame.getCreditText().getText())); 
				    int idFacture= model.getlastId();
				    for(int i=0;i<insertedIdLotList.size();i++){
				    	//5 is the index of the column in the ListProduitAjoutTable that contains qte
			           int qteChange =Integer.valueOf((String) frame.getListProduitAjoutTable().getModel().getValueAt(i, 5));	
			           //add quantity to Lot table
			           int insertedLot= insertedIdLotList.get(i);
			           model.addQteLot(qteChange, insertedLot);
			           //insert change quantity to change table
			           model.insertChange(idFacture, insertedLot, qteChange);
			           
				    }
                    //update quantity globale
				    model.UpdateQteGlobale( insertedIdProdList);
					//Setting the JTable to disabled and ok button in ajout view to disabled
				    disableFactureComponents();
					}
				}
				}catch(Exception ex){
					ex.printStackTrace();
				}

			}
			if (e.getSource()==frame.getOk2()) {
				try{
					if (model.checkNumFacture(frame.getNumfact2().getText())) {
						JOptionPane.showMessageDialog(null, "هذا الرقم موجود ادخل رقما اخر");
					}
					if("".equals(frame.getNomFournisseur2().getText()) || "".equals(frame.getNumfact2().getText())){
						JOptionPane.showMessageDialog(null, "ادخل اسم الممول و رقم الفاتورة");
					}
					else{
				           System.out.println(insertedIdLotList2);

					//insertion into Facture code here
				    String date=model.getCurrentDate();       
				    model.insertFactureClient(frame.getNumfact2().getText(), frame.getNomFournisseur2().getText(), "client", frame.getPrixTotal2().getText(),date,Double.parseDouble(frame.getCreditText2().getText())); 
				    int idFacture= model.getlastId();
				    System.out.println(frame.getPrixTotal2().getText());
				    for(int i=0;i<insertedIdLotList2.size();i++){
				    	//5 is the index of the column in the ListProduitAjoutTable that contains qte
			           int qteChange =Integer.valueOf((String) frame.getListProduitAjoutTable2().getModel().getValueAt(i, 5));	
			           //add quantity to Lot table
			           int insertedLot= insertedIdLotList2.get(i);          
			           model.addQteLot(-qteChange, insertedLot);
			           //insert change quantity to change table
			           model.insertChange(idFacture, insertedLot, -qteChange);
			           
				    }
                    //update quantity globale
				    model.UpdateQteGlobale( insertedIdProdList2);
					//Setting the JTable to disabled and ok button in ajout view to disabled
				    frame.getOk2().setEnabled(false);
				    frame.getNomFournisseur2().setEnabled(false);
				    frame.getNumfact2().setEnabled(false);
				    frame.getAjoutproduit2().setEnabled(false);
				    frame.getCreditText2().setEnabled(false);

					}
				}catch(Exception ex){
					ex.printStackTrace();
				}

			}


		}


	}
	//this is MenuLisner class
	class FrameMenuListener implements MenuListener{

		@Override
		public void menuDeselected(MenuEvent e) {

		}

		@Override
		public void menuSelected(MenuEvent e) {
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
					double somme=model.sumZakat(frame.getListProduitZakatTable(),4,6);
					System.out.println(somme);
					int[]columnsToBeDeleted= {0,1,1,2};
					frame.getZakatTotal().setText(String.valueOf(somme));
					
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
		}

	}




	//This is a separate actionListner class for register logic 
	class RegisterActionListner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()== register.getOk()){
				try{
					//read file here
					//model.connectio("jdbc:ucanaccess://C:/Users/Hicham/ddd.accdb");
					model.connectio("jdbc:ucanaccess://"+filePath);
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
                closeAddinQuantity();
				enableFrame();

			}
			if (e.getSource()==addingquantity.getOk()) {
				try{
					String qteText= addingquantity.getQte().getText();
					//this code is for the case when we subtract quantity
					//					if (qteText==""||model.getLotQuantity(idProd, idLot)-Integer.parseInt(qteText)<0 ) {
					//						JOptionPane.showMessageDialog(null, "Mot de pass ou nom d'utilisateur incorrect");
					//					}

					if (! model.isInteger(qteText) || Integer.parseInt(qteText)<=0 ||addingquantity.getAjoutLotComboBox().getItemCount()==0||addingquantity.getAjoutProduitComboBox().getItemCount()==0|| addingquantity.getAjoutProduitComboBox().getSelectedIndex()==-1 ||addingquantity.getAjoutLotComboBox().getSelectedIndex()==-1) {
						JOptionPane.showMessageDialog(null, "ادخل الكمية , ادخل المنتوج و وضعيته ");
					}
					                  
					else{

						//code for JTable insertions
						List<Double>l=model.getSelectedLotRow(idLot,idProd);
						addingquantity.getPrixVente().setText(l.get(1).toString());
						addingquantity.getPrixAchat().setText(l.get(0).toString());
						double achatSum= Double.parseDouble(l.get(0).toString())*Integer.parseInt(addingquantity.getQte().getText()); 
					    double venteSum= Double.parseDouble(l.get(1).toString())*Integer.parseInt(addingquantity.getQte().getText());
					    totalAchat= totalAchat+achatSum;
					    frame.getPrixTotallab().setText(String.valueOf(totalAchat));
		                String marge= "%"+ (100-(100*(achatSum/venteSum)));
						Vector row = new Vector<>();
						row.addElement(marge); 
						row.addElement(venteSum); 
						row.addElement(achatSum); 
						row.addElement(l.get(1).toString()); 
						row.addElement(l.get(0).toString());
						row.addElement(addingquantity.getQte().getText());
						row.addElement(addingquantity.getAjoutProduitComboBox().getSelectedItem().toString());
						//check if quantity subtracted is lower than actual quantity when subtracting

						tableModelForInsertions.addRow(row);
						tableModelForInsertions.fireTableDataChanged();
						//setting the addquantity view components back to default values
						addingquantity.getQte().setText("0");
						refreshLotComboBox();
						refreshProductComboBox();
						closeAddinQuantity();
						enableFrame();
			//YOU MUST ADD THE CODE TO GET THE IDPRODUIT AND IDLOT FOR ACTUAL INSERTED VALUES FOR THE JTABLE
						//Hashmap for inserted products and lots for updating qte in lot
						insertedIdLotIdProd.put(idProd, idLot);
						//for updating global quatntity
						insertedIdLotList.add(idLot);
						insertedIdProdList.add(idProd);
						
					}
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
				interfaceSuppLot.setVisible(true);
				disableAddingQuantity();
			}
			if(e.getSource()==addingquantity.getModifieItem()){
				try{
				//modify he corresponding lot
				List<Double>l=model.getSelectedLotRow(idLot,idProd);
				
			    interfaceModifieLot.getPrixAchatText().setText(l.get(0).toString());
			    interfaceModifieLot.getPrixVenteText().setText(l.get(1).toString());
			    interfaceModifieLot.setVisible(true);
				disableAddingQuantity();
				}catch (Exception ex){
					ex.printStackTrace();
				}
								
			}

			//adding product
			if (e.getSource()== addingquantity.getAjouItemProd()) {
				ajoutProdInterface.setVisible(true);
				disableAddingQuantity();
			}
			if (e.getSource()== addingquantity.getModifieItemProd()) {
                interfaceModifieProd.getTextProd().setText(addingquantity.getAjoutProduitComboBox().getSelectedItem().toString());
				interfaceModifieProd.setVisible(true);
				disableAddingQuantity();
			}
			if (e.getSource()== addingquantity.getSupItemProd()) {
				//deleting a product from database			
				interfaceSuppProd.setVisible(true);
				disableAddingQuantity();
			}

			if(e.getSource()== addingquantity.getAjoutProduitComboBox()){
				try{
					//action when a product gets selected:
					JComboBox comboBox = (JComboBox) e.getSource();
					Object selected = comboBox.getSelectedItem();
					idProd = idDesignationProdList.get(selected.toString());
					refreshLotComboBox();
					//System.out.println(addingquantity.getAjoutProduitComboBox().getSelectedIndex());
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
			if (e.getSource()== addingquantity.getAjoutLotComboBox()) {
				try{
					JComboBox comboBox = (JComboBox) e.getSource();
					int selected = comboBox.getSelectedIndex();
				    idLotList= model.getIdLot(idProd);
					//setting the labels in the addingquantity view to the actual database values from the lot
					idLot=idLotList.get(selected);
					List<Double>l=model.getSelectedLotRow(idLot,idProd);
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
	class AjoutActionListner2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==addingquantity2.getAnnule2()) {
                closeAddinQuantity2();
				enableFrame();

			}
			if (e.getSource()==addingquantity2.getOk2()) {
				try{
					String qteText= addingquantity2.getQte2().getText();
					

					if (! model.isInteger(qteText) || Integer.parseInt(qteText)<=0 ||addingquantity2.getAjoutLotComboBox2().getItemCount()==0||addingquantity2.getAjoutProduitComboBox2().getItemCount()==0|| addingquantity2.getAjoutProduitComboBox2().getSelectedIndex()==-1 ||addingquantity2.getAjoutLotComboBox2().getSelectedIndex()==-1) {
						JOptionPane.showMessageDialog(null, "دخل وضعية المنتوج, ادخل المنتوج و وضعيت" )  ;
					}
					//this code is for the case when we subtract quantity
					if (model.getLotQuantity(idLot2)-Integer.parseInt(qteText)<0 ) {
						JOptionPane.showMessageDialog(null, "االكمية خاطئة");
					}
					                  
					else{

						//code for JTable insertions
						List<Double>l=model.getSelectedLotRow(idLot2,idProd2);
						addingquantity2.getPrixVente2().setText(l.get(1).toString());
						addingquantity2.getPrixAchat2().setText(l.get(0).toString());
						double achatSum= Double.parseDouble(l.get(0).toString())*Integer.parseInt(addingquantity2.getQte2().getText()); 
					    double venteSum= Double.parseDouble(l.get(1).toString())*Integer.parseInt(addingquantity2.getQte2().getText());
					    totalAchat2= totalAchat2+achatSum;
					    frame.getPrixTotal2().setText(String.valueOf(totalAchat2));
		                String marge= "%"+ (100-(100*(achatSum/venteSum)));
						Vector row = new Vector<>();
						row.addElement(marge); 
						row.addElement(venteSum); 
						row.addElement(achatSum); 
						row.addElement(l.get(1).toString()); 
						row.addElement(l.get(0).toString());
						row.addElement(addingquantity2.getQte2().getText());
						row.addElement(addingquantity2.getAjoutProduitComboBox2().getSelectedItem().toString());
						//check if quantity subtracted is lower than actual quantity when subtracting

						tableModelForInsertions2.addRow(row);
						tableModelForInsertions2.fireTableDataChanged();
						//setting the addquantity view components back to default values
						addingquantity2.getQte2().setText("0");
						refreshLotComboBox2();
						refreshProductComboBox2();
						closeAddinQuantity2();
						enableFrame();
			//YOU MUST ADD THE CODE TO GET THE IDPRODUIT AND IDLOT FOR ACTUAL INSERTED VALUES FOR THE JTABLE
						//Hashmap for inserted products and lots for updating qte in lot
						insertedIdLotIdProd2.put(idProd2, idLot2);
						//for updating global quatntity
						insertedIdLotList2.add(idLot2);
						insertedIdProdList2.add(idProd2);
						
					}
				}catch(Exception ex){
					ex.printStackTrace();
				}

			}
				

			if(e.getSource()== addingquantity2.getAjoutProduitComboBox2()){
				try{
					//action when a product gets selected:
					JComboBox comboBox = (JComboBox) e.getSource();
					Object selected = comboBox.getSelectedItem();
					idProd2 = idDesignationProdList2.get(selected.toString());
					refreshLotComboBox2();
					//System.out.println(addingquantity.getAjoutProduitComboBox().getSelectedIndex());
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
			if (e.getSource()== addingquantity2.getAjoutLotComboBox2()) {
				try{
					JComboBox comboBox = (JComboBox) e.getSource();
					int selected = comboBox.getSelectedIndex();
				    idLotList2= model.getIdLot(idProd2);
					//setting the labels in the addingquantity view to the actual database values from the lot
					idLot2=idLotList2.get(selected);
					List<Double>l=model.getSelectedLotRow(idLot2,idProd2);
					addingquantity2.getPrixVente2().setText(l.get(1).toString());
					addingquantity2.getPrixAchat2().setText(l.get(0).toString());
					addingquantity2.getQteLot2().setText(l.get(2).toString());
					int qteGlobal= model.getQteGlobalProd(idProd2);
					addingquantity2.getQteGlobal2().setText(Integer.toString(qteGlobal));
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
			frame.setEnabled(true);
			System.out.println("this shit executes");

		}

		@Override
		public void windowClosed(WindowEvent e) {
			frame.setEnabled(true);
			System.out.println("this shit executes");

		}

		@Override
		public void windowClosing(WindowEvent e) {
			frame.setEnabled(true);
			System.out.println("this shit executes");

		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			frame.setEnabled(true);
			System.out.println("this shit executes");

		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			frame.setEnabled(true);
			System.out.println("this shit executes");
		}

		@Override
		public void windowIconified(WindowEvent e) {
			frame.setEnabled(true);
			System.out.println("this shit executes");

		}

		@Override
		public void windowOpened(WindowEvent e) {
			frame.setEnabled(true);
			System.out.println("this shit executes");

		}
	}

	class ChangePassActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource()==changePass.getOk()) {
                //check if the pa
				String oldUser= changePass.getOldUserText().getText();
				String oldPass= String.valueOf(changePass.getOldPassText().getPassword());
				String newUser= changePass.getNewUserText().getText();
				String newPass= String.valueOf(changePass.getNewPassText().getPassword());
				//checking
				if("".equals(oldUser) || "".equals(oldPass)) {
					//message
					JOptionPane.showMessageDialog(null, "ادخل كلمة السر و اسم المستعمل ");
				}
				if (oldUser.equals(model.usernamedatabase())&& oldPass.equals(model.passdatabase())) {
				    //update queries
					model.changepassuser(newUser, newPass);
					changePass.getOldPassText().setText("");
					changePass.getNewPassText().setText("");
					changePass.getOldUserText().setText("");
					changePass.getNewUserText().setText("");
					
				}
				else{
					JOptionPane.showMessageDialog(null, "اكلمة السر او اسم المستعمل خاطئ ");
					

				}

				changePass.dispose();
				enableFrame();

			}
			if (arg0.getSource()==changePass.getAnnule()) {
				changePass.getOldPassText().setText("");
				changePass.getNewPassText().setText("");
				changePass.getOldUserText().setText("");
				changePass.getNewUserText().setText("");

				changePass.dispose();
				enableFrame();

			}

		}

	}
	
	class AjoutDonneInterfaceListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==ajoutDonneInterface.getOk()) {
				try{
					//case checks
					if(!(model.isNumeric(ajoutDonneInterface.getPrixAchatText().getText())& (model.isNumeric(ajoutDonneInterface.getPrixVenteText().getText()))&(model.isNumeric(ajoutDonneInterface.getMargeText().getText())))){
						JOptionPane.showMessageDialog(null, "ادخل ارقام");
					}
					else{
						//insertion code 
						System.out.println(Double.parseDouble(ajoutDonneInterface.getPrixAchatText().getText()));
						model.insertLot(Double.parseDouble(ajoutDonneInterface.getPrixAchatText().getText()), 
								Double.parseDouble(ajoutDonneInterface.getPrixVenteText().getText()), 0,idProd);
						//closing and housekeeping
						ajoutDonneInterface.dispose();
						addingquantity.setEnabled(true);
						refreshLotComboBox();
						enableFrame();
						FrontAddQuanAndFrame();
					}
				}catch(Exception ex ){
					ex.printStackTrace();
				}

			}
			if (e.getSource()==ajoutDonneInterface.getAnnule()) {
				ajoutDonneInterface.dispose();
				addingquantity.setEnabled(true);
				enableFrame();
				FrontAddQuanAndFrame();
			}

		}

	}
	class modifieLotInterfaceListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==interfaceModifieLot.getOk()) {
				try{
					//case checks
					if(!(model.isNumeric(interfaceModifieLot.getPrixAchatText().getText())& (model.isNumeric(interfaceModifieLot.getPrixVenteText().getText()))&(model.isNumeric(interfaceModifieLot.getMargeText().getText())))){
						JOptionPane.showMessageDialog(null, "ادخل ارقام");
					}
					else{
						//update code 
						model.updateLot(Double.parseDouble(interfaceModifieLot.getPrixAchatText().getText()), Double.parseDouble(interfaceModifieLot.getPrixVenteText().getText()), idProd, idLot);
						//closing and housekeeping
						interfaceModifieLot.dispose();
						addingquantity.setEnabled(true);
						refreshLotComboBox();
						enableFrame();
						FrontAddQuanAndFrame();
					}
				}catch(Exception ex ){
					ex.printStackTrace();
				}

			}
			if (e.getSource()==interfaceModifieLot.getAnnule()) {
				interfaceModifieLot.dispose();
				addingquantity.setEnabled(true);
				enableFrame();
				FrontAddQuanAndFrame();
			}

		}

	}
	class SuppLotInterfaceListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {

			if(e.getSource()== interfaceSuppLot.getOk()){
				try{

					//delete selected Lot from database
					model.deleteLot(idProd, idLot);
					//updating global quangtity of a product when deleting
					List<Integer> li= new ArrayList<>();
					li.add(idProd);
					model.UpdateQteGlobale(li);
					refreshLotComboBox();
					enableAddingQuantityFromSuppLot();
					FrontAddQuanAndFrame();

				}catch(Exception ex){
					ex.printStackTrace();
				}

			}
			if(e.getSource()== interfaceSuppLot.getAnnule()){
				enableAddingQuantityFromSuppLot();
				FrontAddQuanAndFrame();
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
						enableAddingQuantityFromAjout();
						FrontAddQuanAndFrame();
					}
				}catch(Exception ex){
					ex.printStackTrace();
				}

			}
			if(e.getSource()== ajoutProdInterface.getAnnule()){
				enableAddingQuantityFromAjout();
				FrontAddQuanAndFrame();
			}
		}


	}
	class ModifieProdInterfaceListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {

			if(e.getSource()== interfaceModifieProd.getOk()){
				try{

					//modifying designation of product to database
					model.updateProd(interfaceModifieProd.getTextProd().getText(), idProd);
					refreshProductComboBox();
					addingquantity.getAjoutProduitComboBox().setSelectedIndex(idProd-1);
					enableAddingQuantityFromAjout();
					FrontAddQuanAndFrame();

				}catch(Exception ex){
					ex.printStackTrace();
				}

			}
			if(e.getSource()== interfaceModifieProd.getAnnule()){
				enableAddingQuantityFromAjout();
				FrontAddQuanAndFrame();
			}
		}
	}
	class SuppProdInterfaceListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {

			if(e.getSource()== interfaceSuppProd.getOk()){
				try{

					model.deleteProd(idProd);
					refreshProductComboBox();
					enableAddingQuantityFromSupp();
					FrontAddQuanAndFrame();

				}catch(Exception ex){
					ex.printStackTrace();
				}

			}
			if(e.getSource()== interfaceSuppProd.getAnnule()){
				enableAddingQuantityFromSupp();
				FrontAddQuanAndFrame();
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
	public void disableAddingQuantity2(){
		frame.setEnabled(false);
		addingquantity2.setEnabled(false);
	}
	
	public void closeAddinQuantity2(){
		addingquantity2.dispose();
		//addingquantity.getOk().setEnabled(false);
	}
	public void FrontAddQuanAndFrame2(){
		frame.toFront();
		addingquantity2.toFront();
	}

	//this is to put data from the database into the combobox
	public void refreshProductComboBox2()throws SQLException{
		DefaultComboBoxModel dcm= model.buildComboModel();
		addingquantity2.getAjoutProduitComboBox2().setModel(dcm);
		idDesignationProdList2= model.getIDproductDesignation();
	}
	public void refreshLotComboBox2()throws SQLException{
		DefaultComboBoxModel dcm= model.buildComboModelLot(idProd2);
		addingquantity2.getAjoutLotComboBox2().setModel(dcm);
	}
	public void enableFactureComponents2(){
		frame.getOk2().setEnabled(true);
        frame.getNomFournisseur2().setEnabled(true);
        frame.getNumfact2().setEnabled(true);
        frame.getAjoutproduit2().setEnabled(true);
        frame.getCreditText2().setEnabled(true);
	}
	public void clearinsertedids2(){
		insertedIdLotIdProd2.clear();
        insertedIdLotList2.clear();
        insertedIdProdList2.clear();
	}
	public void resetFactureComponents2(){
		frame.getNomFournisseur2().setText("");
		frame.getNumfact2().setText("");
		frame.getPrixTotal2().setText("0");
		frame.getCreditText2().setText("0");
	}
	
	
	public void disableAddingQuantity(){
		frame.setEnabled(false);
		addingquantity.setEnabled(false);
	}


	public void enableAddingQuantityFromAjout(){
		ajoutProdInterface.dispose();
		addingquantity.setEnabled(true);
	}
	public void enableAddingQuantityFromModifie(){
		interfaceModifieProd.dispose();
		addingquantity.setEnabled(true);
	}
	public void enableAddingQuantityFromSupp(){
		interfaceSuppProd.dispose();
		addingquantity.setEnabled(true);
	}
	public void enableAddingQuantityFromSuppLot(){
		interfaceSuppLot.dispose();
		addingquantity.setEnabled(true);
	}
	
	public void closeAddinQuantity(){
		addingquantity.dispose();
		//addingquantity.getOk().setEnabled(false);
	}
	public void FrontAddQuanAndFrame(){
		frame.toFront();
		addingquantity.toFront();
	}

	//this is to put data from the database into the combobox
	public void refreshProductComboBox()throws SQLException{
		DefaultComboBoxModel dcm= model.buildComboModel();
		addingquantity.getAjoutProduitComboBox().setModel(dcm);
		idDesignationProdList= model.getIDproductDesignation();
	}
	public void refreshLotComboBox()throws SQLException{
		DefaultComboBoxModel dcm= model.buildComboModelLot(idProd);
		addingquantity.getAjoutLotComboBox().setModel(dcm);
	}
	public void enableFactureComponents(){
		frame.getOkAjout().setEnabled(true);
        frame.getNomFournisseur().setEnabled(true);
        frame.getNumFact().setEnabled(true);
        frame.getAjoutproduitButton().setEnabled(true);
        frame.getCreditText().setEnabled(true);
	}
	public void disableFactureComponents(){
		    frame.getOkAjout().setEnabled(false);
		    frame.getNomFournisseur().setEnabled(false);
		    frame.getNumFact().setEnabled(false);
		    frame.getAjoutproduitButton().setEnabled(false);
		    frame.getCreditText().setEnabled(false);
	}
	public void clearinsertedids(){
		insertedIdLotIdProd.clear();
        insertedIdLotList.clear();
        insertedIdProdList.clear();
	}
	public void resetFactureComponents(){
		frame.getNomFournisseur().setText("");
		frame.getNumFact().setText("");
		frame.getPrixTotallab().setText("0");
		frame.getCreditText().setText("0");
		
	}
	public void setFilePath(String filePath){
		this.filePath= filePath;
	}

}


