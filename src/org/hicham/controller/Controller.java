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
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;

import org.hicham.model.model;
import org.hicham.view.AjoutDonneInterface;
import org.hicham.view.ChangePass;
import org.hicham.view.Register;
import org.hicham.view.addingquantity;
import org.hicham.view.mainFrame;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

//This is the controller class of the project

public class Controller {

	private mainFrame frame = new mainFrame();

	private model model = new  model();

	private Register register = new Register();

	private File file ;

	private int returnVal;

	private List<Integer> panelList = new ArrayList<>();

	private JFileChooser filechooser = new JFileChooser();

	private addingquantity addingquantity ;

	private ChangePass changePass= new ChangePass();

	private AjoutDonneInterface ajoutDonneInterface= new AjoutDonneInterface();

	public Controller(mainFrame frame, model model,Register register,addingquantity addingquantity,ChangePass changePass,AjoutDonneInterface ajoutDonneInterface){

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
			if(e.getSource()==frame.getAjoutproduitButton()){
				frame.setEnabled(false);
				addingquantity.setVisible(true);

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
			if(e.getSource()==addingquantity.getAjouItem()){

				ajoutDonneInterface.setVisible(true);
				frame.setEnabled(false);
				addingquantity.setEnabled(false);

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
	
	public void enableFrame(){
		frame.setEnabled(true);
		frame.toFront();
	}

}


