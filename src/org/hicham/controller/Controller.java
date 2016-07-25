package org.hicham.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import org.hicham.model.model;
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

	private JFileChooser filechooser = new JFileChooser();

	private addingquantity addingquantity ;
    
	private ChangePass changePass= new ChangePass();

	public Controller(mainFrame frame, model model,Register register,addingquantity addingquantity,ChangePass changePass){

		this.frame= frame;

		this.model= model;

		this.register = register;

		this.addingquantity= addingquantity;
		
		this.changePass= changePass;

		this.register.AddRegisterActionlistner(new RegisterActionListner());

		this.frame.addFrameActionLisner( new FrameAtionListner());

		this.frame.addFrameMenulistner(new FrameMenuListner());

		this.addingquantity.addajoutlistner(new AjoutActionListner());
		
		this.changePass.addChangePassListener(new ChangePassActionListener());

	}
	//this is the MainFrame action listener it contains listeners for all the panels inside the main frame
	
	class FrameAtionListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==frame.getAjoutbase()){
				returnVal = filechooser.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION){
					file = filechooser.getSelectedFile();
				}
			}

			if(e.getSource()== frame.getAjoutprodui()){
				CardLayout cardLayout = (CardLayout) frame.cards.getLayout();
				cardLayout.show(frame.cards, "Card 2");	
			}
			if(e.getSource()==frame.getAjoutproduitButton()){
				frame.setEnabled(false);
				addingquantity.setVisible(true);

			}
			if (e.getSource()==frame.getMotpass()) {
				frame.setEnabled(false);
				changePass.setVisible(true);
			}


		}


	}
	//this is MenuLisner class
	class FrameMenuListner implements MenuListener{

		@Override
		public void menuDeselected(MenuEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void menuSelected(MenuEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==frame.getRetour()){
				CardLayout cardLayout = (CardLayout) frame.cards.getLayout();
				cardLayout.show(frame.cards, "Card 1");	

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
							frame.setEnabled(true);
							frame.toFront();
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
				frame.setEnabled(true);
				frame.toFront();

			}

		}


	} 

	class AjoutActionListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==addingquantity.getAnnule()) {
				addingquantity.dispose();
				frame.setEnabled(true);
				frame.toFront();

			}
			if (e.getSource()==addingquantity.getOk()) {
				addingquantity.dispose();
				//code for database insertions
				frame.setEnabled(true);
				frame.toFront();

				//chacking if the input is a number or something else

			}
			if (e.getSource()==addingquantity.getChoixBtn()) {
				//the show method uses the position of a component as a parameter in a gui, here it's used to show the popup menu according to the position of the chouxbtn
				addingquantity.getPopmenu().show(addingquantity.getChoixBtn(), addingquantity.getChoixBtn().getBounds().x-312, addingquantity.getChoixBtn().getBounds().y-65 + addingquantity.getChoixBtn().getBounds().height);
			}
			if (e.getSource()==addingquantity.getChoixBtnDesignation()) {
			    addingquantity.getPopmenuProduit().show(addingquantity.getChoixBtnDesignation(), addingquantity.getChoixBtnDesignation().getBounds().x-312, addingquantity.getChoixBtnDesignation().getBounds().y-65 + addingquantity.getChoixBtnDesignation().getBounds().height);
			}

		}

	}

	class ChangePassActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource()==changePass.getOk()) {


				changePass.dispose();
				frame.setEnabled(true);
				frame.toFront();

			}
			if (arg0.getSource()==changePass.getAnnule()) {

				changePass.dispose();
				frame.setEnabled(true);
				frame.toFront();

			}

		}

	}

}


