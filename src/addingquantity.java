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
	
		//for the name of the product 
		    private JButton ajoutlot = new JButton("ajout");
			
			private JButton modifieLot = new JButton("modifie");
			
			private JButton supprimLot = new JButton("supprimé");
			
			final DefaultComboBoxModel ajoutprodnom = new DefaultComboBoxModel();
			
			final JComboBox ajoutproduit = new JComboBox(ajoutprodnom); 
			
		//	final JComboBox ajoutref = new JComboBox();    

			
		    private JScrollPane ProduitNomListScrollPane = new JScrollPane(ajoutproduit); 
		    			
			private JTextField QTE = new JTextField(10);
			
		    private JLabel labqte = new JLabel("الكمية");
			
			private JTextField motpasstext = new JTextField(10);
			
			//for the reference of the product
            final DefaultComboBoxModel ajoutprodref = new DefaultComboBoxModel();
			
			final JComboBox ajoutRef = new JComboBox(ajoutprodref); 
			
		    private JScrollPane reflistListScrol = new JScrollPane(ajoutRef); 

			
		public addingquantity(){
				
				setResizable(true);
		        setSize(400,400);        
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        setLocationRelativeTo(null);

		        ajoutproduit.setSelectedIndex(0);
                ajoutRef.setSelectedIndex(0);
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
				return ProduitNomListScrollPane;
			}
			public void setFruitListScrollPane(JScrollPane fruitListScrollPane) {
				this.ProduitNomListScrollPane = fruitListScrollPane;
			}
			public DefaultComboBoxModel getFruitsName() {
				return ajoutprodnom;
			}
			public JComboBox getAjoutproduit() {
				return ajoutproduit;
			}
		    
		    
		    
}
		    
			
			