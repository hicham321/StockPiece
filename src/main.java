import javax.swing.UIManager;
import org.hicham.controller.Controller;
import org.hicham.model.model;
import org.hicham.view.AjoutDonneInterface;
import org.hicham.view.AjoutProdInterface;
import org.hicham.view.ChangePass;
import org.hicham.view.Register;
import org.hicham.view.addingquantity;
import org.hicham.view.mainFrame; 
import  com.seaglasslookandfeel.*;


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
		Controller c = new Controller(frame, m, r,a,ch,ai,pi);
		frame.setVisible(true);
		r.setVisible(true);
		
	}

}
