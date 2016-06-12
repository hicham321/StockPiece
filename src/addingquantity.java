import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class addingquantity extends JFrame{
	
		
		    private JButton ajoutlot = new JButton("ajout");
			
			private JButton modifieLot = new JButton("modifie");
			
			final DefaultComboBoxModel fruitsName = new DefaultComboBoxModel();
			
			final JComboBox ajoutproduit = new JComboBox(fruitsName);    
			
		    private JScrollPane fruitListScrollPane = new JScrollPane(ajoutproduit); 
			
			private JTextField utiltext = new JTextField(10);
			
			private JTextField motpasstext = new JTextField(10);
			
			//showing path to the database
			
			private JLabel cheminlab ;
		public addingquantity(){
				
				setResizable(true);
		        setSize(400,400);        
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    fruitCombo.setSelectedIndex(0);

		        JPanel panel = new JPanel();
		        
		        /*panel.add(bienvenu);
		        panel.add(saisielabel);
		        panel.add(utilisateurlab);
		        panel.add(utiltext);
		        panel.add(motpasslab);
		        panel.add(motpasstext);
		        panel.add(ok);
		        panel.add(annule);*/
		        
		        this.add(panel);
		        
				
			}
		    public void platformLook(){
			 try { 
				    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
				    e.printStackTrace();
				}
		    }
			
			public void setCheminLabel (String cheminlabel){
				
				this.cheminlab.setText(cheminlabel);
			}
			public void AddRegisterActionlistner (ActionListener listner ){
				this.ok.addActionListener(listner);
				this.annule.addActionListener(listner);
				
			}

			public JButton getOk() {
				return ok;
			}
			public JButton getAnnule() {
				return annule;
			}

			public void setUtiltext(JTextField utiltext) {
				this.utiltext = utiltext;
			}

			public void setMotpasstext(JTextField motpasstext) {
				this.motpasstext = motpasstext;
			}
			public String getPassText(){
				return this.motpasstext.getText();
			}
			public String getUtilisateurText(){
				return this.utiltext.getText();
			}

		}


