import javax.swing.UIManager;

import org.hicham.controller.Controller;
import org.hicham.model.model;
import org.hicham.view.AjoutDonneInterface;
import org.hicham.view.ChangePass;
import org.hicham.view.Register;
import org.hicham.view.addingquantity;
import org.hicham.view.mainFrame;


public class main {
	public static void main(String[] arguments) {
		try { 
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		mainFrame frame = new mainFrame();
		model m = new model();
		Register r = new Register();
		addingquantity a= new addingquantity();
		ChangePass ch= new ChangePass();
		AjoutDonneInterface ai= new AjoutDonneInterface();
		Controller c = new Controller(frame, m, r,a,ch,ai);
		frame.setVisible(true);
		r.setVisible(true);

	}

}
