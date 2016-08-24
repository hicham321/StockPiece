package org.hicham.view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;


public class mainPanel extends JPanel {



	JButton but = new JButton("dsdffd");

	private BufferedImage image;

	public mainPanel(){
		try { 
			//modify this when changing to a different layout manager
			this.setLayout(null);
			this.add(but);


			but.setBounds(70,500,70,70);


			this.setBackground(Color.white);
			//this.setBounds(0, 0, 400, 400);
			this.setVisible(true);

			image = ImageIO.read(this.getClass().getResource("Circadian-Rythms.png"));
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
