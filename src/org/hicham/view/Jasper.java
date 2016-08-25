package org.hicham.view;
import java.util.HashMap;
import net.sf.jasperreports.engine.*;
public class Jasper {
	
	public void JasperMethod(){
		try{
	    System.out.println("Generating PDF...");             
        JasperReport jasperReport = JasperCompileManager.compileReport("Jasperfile.jrxml");      
        JasperPrint jasperPrint =JasperFillManager.fillReport(jasperReport, new HashMap(), new JREmptyDataSource());      
        JasperExportManager.exportReportToPdfFile(jasperPrint, "HelloJasper.pdf");
                        
        System.out.println("HelloJasper.pdf has been generated!");
    }
    catch (JRException e){
        e.printStackTrace();
    }
	}

	public static void main(String[] args) {
           Jasper jasper= new Jasper();
           jasper.JasperMethod();
	}

}
