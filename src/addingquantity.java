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
			
		//	final JComboBox ajoutref = new JComboBox();    

			
		    private JScrollPane fruitListScrollPane = new JScrollPane(ajoutproduit); 
			
			private JTextField utiltext = new JTextField(10);
			
			private JTextField motpasstext = new JTextField(10);
			
			//showing path to the database
			
			private JLabel cheminlab ;
		public addingquantity(){
				
				setResizable(true);
		        setSize(400,400);        
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        ajoutproduit.setSelectedIndex(0);

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
		
		public void addajoutlistner(ActionListener listner){
			
		
		}
		
		
		    public void platformLook(){
			 try { 
				    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
				    e.printStackTrace();
				}
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
			public JScrollPane getFruitListScrollPane() {
				return fruitListScrollPane;
			}
			public void setFruitListScrollPane(JScrollPane fruitListScrollPane) {
				this.fruitListScrollPane = fruitListScrollPane;
			}
			public DefaultComboBoxModel getFruitsName() {
				return fruitsName;
			}
			public JComboBox getAjoutproduit() {
				return ajoutproduit;
			}
		    
		    
		    
}
		    
			
			