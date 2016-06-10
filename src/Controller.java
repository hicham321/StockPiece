import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class Controller {
	
    private mainFrame frame = new mainFrame();
	
	private model model = new  model();
	
	private Register register = new Register();
	
	private File file ;
	
	private int returnVal;
	
	private JFileChooser filechooser = new JFileChooser();

	
 public Controller(mainFrame frame, model model,Register register){
	 
	 this.frame= frame;
	 
	 this.model= model;
	 
	 this.register = register;
	 
	 this.register.AddRegisterActionlistner(new RegisterActionListner());
	 
	 this.frame.addFrameActionLisner( new FrameAtionListner());
	 
 }
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
		
	}
	 
	 
 }
 class RegisterActionListner implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== register.getOk()){
			 try{
			     model.connectio("jdbc:ucanaccess://C:/Users/Hicham/ddd.accdb");
			     boolean thereispass= model.checkdatabase();
			     System.out.println("b oolean :"+thereispass );
			     System.out.println("database pass "+model.passdatabase());
			     System.out.println("database user"+model.usernamedatabase());
			     System.out.println("text pass "+register.getPassText());
			     System.out.println("text user"+register.getUtilisateurText());

			     if(thereispass){
				    if((model.passdatabase().equals(register.getPassText()))&(model.usernamedatabase().equals(register.getUtilisateurText()))){
					       register.dispose();
					       frame.dispose();
				    }	
				    else{
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
		 }
		
	}
		
		
	} 
 }


