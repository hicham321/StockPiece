import javax.swing.UIManager;

import  com.seaglasslookandfeel.*;

import org1.hicham.controller.Controller;
import org1.hicham.model.model;
import org1.hicham.view.AjoutDonneInterface;
import org1.hicham.view.AjoutProdInterface;
import org1.hicham.view.ChangePass;
import org1.hicham.view.InterfaceModifieLot;
import org1.hicham.view.InterfaceModifieProd;
import org1.hicham.view.InterfaceSuppLot;
import org1.hicham.view.InterfaceSuppProd;
import org1.hicham.view.Register;
import org1.hicham.view.addingquantity;
import org1.hicham.view.mainFrame;


public class main {
	public static void main(String[] arguments) {
		try { 
			//This line is for system look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			//this line is for Sea Glass look and feel:
			//UIManager.setLookAndFeel("put class path here");


		} catch (Exception e) {
			e.printStackTrace();
		}
		mainFrame frame = new mainFrame();
		model m = new model();
		Register r = new Register();
		addingquantity a= new addingquantity();
		ChangePass ch= new ChangePass();
		AjoutDonneInterface ai= new AjoutDonneInterface();
		AjoutProdInterface pi= new AjoutProdInterface();
		InterfaceModifieProd mi= new InterfaceModifieProd();
		InterfaceModifieLot ml= new InterfaceModifieLot();
		InterfaceSuppProd sp= new InterfaceSuppProd();
		InterfaceSuppLot sl= new InterfaceSuppLot();
		Controller c = new Controller(frame, m, r,a,ch,ai,pi,mi,ml,sp,sl);
		frame.setVisible(true);
		r.setVisible(true);

	}

}
