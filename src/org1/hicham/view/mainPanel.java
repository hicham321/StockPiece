package org1.hicham.view;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class mainPanel extends JPanel {



	//JButton but = new JButton("dsdffd");

	private BufferedImage image;
	
	JLabel labForAjoutProduit= new JLabel("ادخال منتوج");
	JLabel labForDestockProduit= new JLabel( "اخراج منتوج");
	JLabel labForListProduit= new JLabel("لائحة المنتوجات");


	public mainPanel(){
		try { 
			//modify this when changing to a different layout manager
			this.setLayout(null);
			//this.add(but);


			//but.setBounds(70,500,70,70);
            this.add(labForAjoutProduit);
            this.add(labForDestockProduit);
            this.add(labForListProduit);
            
            labForAjoutProduit.setBounds(600,150 , 100,20 );
            labForDestockProduit.setBounds(600, 190, 100, 20);
            labForListProduit.setBounds(600, 230, 100, 20);
            
            labForAjoutProduit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            labForDestockProduit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            labForListProduit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));



            

			this.setBackground(Color.white);
			//this.setBounds(0, 0, 400, 400);
			this.setVisible(true);

			image = ImageIO.read(this.getClass().getResource("engine-wallpaper-4.jpg"));
		} catch (IOException ex) {
			// handle exception...
		}


	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0,0, this); // see javadoc for more info on the parameters            
	}





}
