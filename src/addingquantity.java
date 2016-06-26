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

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class addingquantity extends JFrame{
	
		//for the name of the product 
		    private JButton ajoutlot = new JButton("ajout");
			
			private JButton modifieLot = new JButton("modifie");
			
			private JButton supprimLot = new JButton("supprimé");
			
			final DefaultComboBoxModel ajoutprodnom = new DefaultComboBoxModel();
			
			final JComboBox ajoutproduit = new JComboBox(ajoutprodnom); 
			
		//	final JComboBox ajoutref = new JComboBox();    

			
		    private JScrollPane ProduitNomListScrollPane = new JScrollPane(ajoutproduit); 
		    			
			private JTextField qte = new JTextField(10);
			
		    private JLabel labqte = new JLabel("الكمية");
			
			private JTextField motpasstext = new JTextField(10);
			
			private JButton annule = new JButton("الغاء");
			
			private JButton ok = new JButton("موافقة");
			
			//lower end of jpanel will contain labels for Lot quantity, global quantity and price
		    private JLabel labQteLot = new JLabel("الكمية الجزئية");
		    private JLabel labQteGlobal = new JLabel("الكمية الكلية");
		    private JLabel labprixAchat = new JLabel("ثمن الشراء");
		    private JLabel labprixVente = new JLabel("ثمن البيع");
		    //these are modified labels to be set to the buy and sell prices
		    private JLabel prixAchat = new JLabel(" ");
		    private JLabel prixVente = new JLabel(" ");



			
			//for the reference of the product
			//the model's only job is to hold information
            final DefaultComboBoxModel ajoutprodmodel = new DefaultComboBoxModel();
            
            
        	final JComboBox ajoutProduitComboBox  = new JComboBox(ajoutprodmodel);    
						
		    private JScrollPane ajoutProduitListScrol = new JScrollPane(ajoutProduitComboBox); 
		    
		    //this is for the product type
            final DefaultComboBoxModel ajoutRefmodel = new DefaultComboBoxModel();
            
            
        	final JComboBox ajoutRefComboBox  = new JComboBox(ajoutRefmodel);    
						
		    private JScrollPane ajoutRefListScrol = new JScrollPane(ajoutRefComboBox); 

			
		public addingquantity(){
				
				setResizable(true);
		        setSize(400,400);        
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		        
		        panel.add(qte);
		        panel.add(labqte);
		        panel.add(ok);
		        panel.add(annule);
		        panel.add(ajoutProduitComboBox);
		        panel.add(ajoutRefComboBox);
		        this.add(panel);
		        
				
			}
		
		public void addajoutlistner(ActionListener listner){
			
		
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

			public JButton getAnnule() {
				return annule;
			}


			public JButton getOk() {
				return ok;
			}

			
		    
		    
		    
}
		    
			
			