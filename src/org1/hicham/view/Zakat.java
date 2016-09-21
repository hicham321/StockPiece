package org1.hicham.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Zakat extends JPanel {
	
	public  DefaultTableModel dt;

	public  JTable listProduitZakatTable;

	private JScrollPane scrolPane;
	
	//labels buttons and fields
	
	JLabel zakatProduitLab = new JLabel(":المنتوجات المزكى عليها");

	JLabel zakatLabel= new JLabel("ادخل نسبة الزكاة");
	
	JTextField zakatText = new JTextField();
	
	JLabel zakatTotalLab= new JLabel("االمجموع المزكى عليه");
	
	JLabel zakatTotal= new JLabel("0");
	
	JLabel zakatFinalLab= new JLabel("مبلغ الزكاة");
	
	JLabel zakatFinal= new JLabel("0");
	
	JButton zakatCalcButton= new JButton("احسب");

	

	public Zakat() {

		listProduitZakatTable =new JTable(dt);

		this.setLayout(new GroupLayout(this));
		this.setBackground(Color.decode("#CFDBC5"));

		listProduitZakatTable.setPreferredScrollableViewportSize(new Dimension(500,50));
		listProduitZakatTable.setFillsViewportHeight(true);
		//listProduitZakatTable.setAutoCreateColumnsFromModel(false);

		scrolPane= new JScrollPane(listProduitZakatTable);
		scrolPane.setBounds(50, 70, 1250, 470);
		this.add(scrolPane);
		
		this.add(zakatFinal);
		this.add(zakatFinalLab);
		this.add(zakatLabel);
		this.add(zakatProduitLab);
		this.add(zakatText);
		this.add(zakatTotalLab);
		this.add(zakatTotal);
		this.add(zakatCalcButton);
		
		this.zakatProduitLab.setBounds(1250,30,190,20);
		//this.zakatProduitLab.setFont(new Font("",Font.BOLD, 100));
		this.zakatLabel.setBounds(1250,550,190,20);
		this.zakatText.setBounds(1120,550,120,20);
		this.zakatCalcButton.setBounds(1000, 550, 70, 20);
		this.zakatCalcButton.addMouseListener(new MouseAdapter(){

			public void mouseEntered(MouseEvent mEvt) {
				zakatCalcButton.setToolTipText("lakshman");

			}

		});
		//this.zakatCalcButton.setToolTipText("ادخل نسبة الزكاة هنا");
		this.zakatTotalLab.setBounds(1250,600,190,20);
		this.zakatTotal.setBounds(1000,600,190,20);
		this.zakatFinalLab.setBounds(1250,650,190,20);
		this.zakatTotal.setBounds(1000,650,190,20);

		this.setVisible(true);

	}



	
	


}
