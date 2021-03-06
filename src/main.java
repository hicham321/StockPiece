import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;


import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


import  com.seaglasslookandfeel.*;

import javafx.stage.FileChooser;
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
import org1.hicham.view.addingquantity2;
import org1.hicham.view.mainFrame;
import sun.dc.pr.PathFiller;


public class main {
	
	
	
	public static void  ShowView(String filePath){
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
		addingquantity2 a2= new addingquantity2();
		Controller c = new Controller(frame, m, r,a,ch,ai,pi,mi,ml,sp,sl,a2);
		//set the file path for the conntroller
		c.setFilePath(filePath);
		//show the frames:
		frame.setVisible(true);
		r.setVisible(true);	
	}
	
	public static void writeFile(String someThingToWrite, OutputStream outStreamn) throws IOException, FileNotFoundException{
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(outStreamn, "utf-8"))) {
	   writer.write(someThingToWrite);
	}
	}
	public static String readFile(InputStream fileInputStream ) throws IOException{
		
	    byte[] buffer = new byte[fileInputStream.available()];
	    int length = fileInputStream.read(buffer);
	    fileInputStream.close();
	    return new String(buffer, 0, length, "utf-8");
	}
	public static void SystemLookFeel(){
		try { 
			//This line is for system look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] arguments) throws FileNotFoundException, IOException {
		
		SystemLookFeel();
        model m= new model();
//		//checking if file is not empty
//		if (!(br.readLine() == null)) {
//		    System.out.println("No errors, and file not empty");
//		    FileEmpty= false;
//		}
//		//check if file is empty or not 
		if (m.checkFileEmpty(m.getFileLink())) {
			JOptionPane.showMessageDialog(null, "ااختر قاعدة البيانات");

		    JFileChooser filechooser = new JFileChooser();
			int returnVal = filechooser.showOpenDialog(null);

			if(returnVal == JFileChooser.APPROVE_OPTION){
				
				File Databasefile = filechooser.getSelectedFile();
				//put a condition on the file Name
				if ("stock001.accdb".equals(Databasefile.getName())) {
					//get relative path to set File path
					String filePath=Databasefile.getPath();
					System.out.println(filePath);
					//write to file 
					m.writeDbPathToFile(filePath, m.getFileLink());
					//set the  file path to the controller 
					ShowView(filePath);
				}
				else{
					//writeFile("", classFileInput);
					JOptionPane.showMessageDialog(null, " قاعدة البيانات خاطئة اعد المحاولة.");
				}
				
			}

		}
		else{
			String dbLink=m.readFile(m.getFileLink());
			ShowView(dbLink);

			
		}

	}

}
