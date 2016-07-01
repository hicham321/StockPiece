package org.hicham.view;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class Register extends JFrame{
	
private JButton ok = new JButton("موافقة");
	
	private JButton annule = new JButton("الغاء");
	
	private JLabel bienvenu= new JLabel("!اهلا ");
	
	private JLabel saisielabel= new JLabel("ادخل كلمة السر والمستعمل");
	
	private JLabel utilisateurlab = new JLabel("المستعمل ");
	
	private JLabel motpasslab = new JLabel("كلمة السر ");
	
	private JTextField utiltext = new JTextField(10);
	
	private JPasswordField  motpasstext = new JPasswordField (10);
	
	//showing path to the database
	
	private JLabel cheminlab ;
	
	
    public Register(){
		
		setResizable(true);
        setSize(400,200);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        bienvenu.setBounds(180, 10, 100, 20);
        saisielabel.setBounds(130, 20, 150, 20);
        utilisateurlab.setBounds(300, 45, 100, 20);
        utiltext.setBounds(100, 50, 170, 20);
        motpasslab.setBounds(300, 75, 100, 20);
        motpasstext.setBounds(100, 75, 170, 20);
        ok.setBounds(80, 120, 100, 20);
        annule.setBounds(200, 120, 100, 20);

        panel.add(bienvenu);
        panel.add(saisielabel);
        
        panel.add(utilisateurlab);
        panel.add(utiltext);
        
        panel.add(motpasslab);
        panel.add(motpasstext);
        
        panel.add(ok);
        panel.add(annule);
        
        this.add(panel);
        
		
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

	public void setMotpasstext(JPasswordField  motpasstext) {
		this.motpasstext = motpasstext;
	}
	public char[] getPassText(){
		return this.motpasstext.getPassword();
	}
	public String getUtilisateurText(){
		return this.utiltext.getText();
	}

}
