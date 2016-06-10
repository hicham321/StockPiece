import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.lang.UnhandledException;


public class model {
private Connection con ;
	
	private Statement stmt;
	
	
	
	
	
	public void connectio ( String path ){
		
		
		
	    try {
	        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

	        this.con = DriverManager.getConnection(path, "", "");

	        this.stmt = con.createStatement();

	        /*// Returns a ResultSet that contains the data produced by the query;
	        // never null
	        String query= "insert query here";
	        ResultSet rs = stmt.executeQuery(query);


	        while (rs.next()) {
	            String fName = rs.getString("Field1");
	           String lName = rs.getString("LastName");
	            int age = rs.getInt("ID");
	        }

	        stmt.close();

	        con.close();*/
	    } catch (SQLException ex) {
	        System.err.println("SQLException: " + ex.getMessage());
	    } 
	      catch (ClassNotFoundException e) {
	    	  
		    System.err.println("classnotfoundException: " + e.getMessage());

	    	  
	    }
	}
	
	//SQL pour insirer un enfant dans la base
	public void InsirerEnfant (String Nom , String Prenom,int age, Date naissance,Date joindre, double prixconv, double prixpaye, Date datepay){
		
		try{
        String query= "INSERT INTO Enfant (Nom,Prenom ,age, Naissance,Date Joindre,Prix Conventioné,Prix Paye, Date Payment) VALUES("+ "'"+Nom +"'"+","+ "'"+Prenom +"'"+"," + "'"+ age+"'" +","+ "'"+naissance+"'"+ ","+"'"+joindre+ "'"+","+"'"+ prixconv+"'"+","+ "'"+prixpaye+"'" + "," +"'"+datepay +"'" +")" ;
        
        ResultSet r= this.stmt.executeQuery(query);
		}catch ( SQLException e) {
			System.out.println("sql exception : "+ e);
		}
        

		
		
	}
	
	//SQL pour insirer un employe dans la base 
	public void InsirerEmploye(String nom , String prenom , boolean payment , double prix ){
		
		try{
	        String query= "INSERT INTO Employe ( Nom , Prenom , Payement , Prix ) VALUES ("+ "'"+ nom+ "'"+ "," + "'"+prenom +"'"+","+ "'"+payment +"'"+","+ "'"+prix +"'"+")";
	        
	        ResultSet r= this.stmt.executeQuery(query);
			}catch ( SQLException e) {
				System.out.println("sql exception : "+ e);
			}
		
		
	}
	public void rechEmployer(String nom , String prenom){
		try {
			String query= "SELECT * from  WHERE Mot= '" +nom +"'" +" and "+"Prenom"+"'"+prenom+"'" ;	         	        
	         ResultSet r= this.stmt.executeQuery(query);
	         
	         while (r.next() ) {
		            String Nom = r.getString("Nom");
		            String Prenom = r.getString("Prenom");
		            String Payement = r.getString("Payement");
		            String Prix = r.getString("Prix");

	        	}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			
		}
		
	}
	//Search product
	// used with combobox 
	public void searchLot(){
		
		
	}
	//insert product 

		public void insertLo(String designation ,String Referance,double prixachat,double Prixvente,int qteglobal, Date date){
		
				try {
					String query= "INSERT INTO Lot ( Nom , reference , prixachat , Prixvent , qte , date) VALUES ("+ "'"+ designation+ "'"+ "," + "'"+Referance +"'"+","+ "'"+prixachat +"'"+","+ "'"+Prixvente +"'"+ "'"+qteglobal +"'"+ "'"+date +"'"+")";        	        
			         ResultSet r= this.stmt.executeQuery(query);
			         
			         while (r.next() ) {
				            designation = r.getString("Nom");
				            Referance = r.getString("Referance");
				            prixachat = r.getDouble("Prixachat");
				            Prixvente = r.getDouble("Prixvent");
				            qteglobal= r.getInt("qte");
				            date = r.getDate("date");
				            
			        	}
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
					
				}
				
			}
	
	//insert Lot
	public void insertLot(String nom,String Referance,double prixachat,double Prixvente,int qte, Date date){
	
			try {
				String query= "INSERT INTO Lot ( Nom , reference , prixachat , Prixvent , qte , date) VALUES ("+ "'"+ nom+ "'"+ "," + "'"+Referance +"'"+","+ "'"+prixachat +"'"+","+ "'"+Prixvente +"'"+ "'"+qte +"'"+ "'"+date +"'"+")";        	        
		         ResultSet r= this.stmt.executeQuery(query);
		         
		         while (r.next() ) {
			            nom = r.getString("Nom");
			            Referance = r.getString("Referance");
			            prixachat = r.getDouble("Prixachat");
			            Prixvente = r.getDouble("Prixvent");
			            qte= r.getInt("qte");
			            date = r.getDate("date");
			            
		        	}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				
			}
			
		}
	
	public void RechLot(String Nom ){
		try {
			String query= "SELECT * from  WHERE Mot= '" +Nom +"'" +" and "+"Prenom"+"'"+"'" ;	         	        
	         ResultSet r= this.stmt.executeQuery(query);
	         
	         while (r.next() ) {
		            String nom = r.getString("Nom");
		            String Referance = r.getString("Referance");
		            double prixachat = r.getDouble("PrixAchat");
		            double Prixvente = r.getDouble("PrixVente");
		            int Date= r.getInt("QTE");
		            Date date = r.getDate("Date");
		            
	        	}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			
		}
		
	}
	//verify if the register table is empty to allow 
	
public boolean checkdatabase (){
		
		try {
			String query= "SELECT COUNT(*) FROM Register" ;	
	         ResultSet r= this.stmt.executeQuery(query);
	         int val=0;
	         while (r.next() ) {
	        	  val =  ((Number) r.getObject(1)).intValue();
	    	    }
			if(val==1){
				return true;
			}
			else{
				return false;
			}
		} catch (Exception e) {
			System.out.println(e);
       return false ;
		}
		
	}
	//return   the password and user name in the database
	public String passdatabase(){
		try{
        String query= "SELECT pass from Register" ;
        
        ResultSet r= this.stmt.executeQuery(query);
        String result ="";
		while (r.next() ) {
            result = r.getString("pass");
   	    }
		
		
		return result;
        }catch(Exception e){
        	
        	return "false";
        }

	}
	public String usernamedatabase(){
		try{
			
        String query= "SELECT utilisateur from Register " ;
        
        ResultSet r= this.stmt.executeQuery(query);
        String result ="";
		while (r.next() ) {
			
            result = r.getString("Utilisateur");
   	    }

		return result;
		
		}
		catch(Exception e){
			
			return "false";
		}
	}
	public void changepassuser(String user, String pass){
		try {
			 String query= "UPDATE Register SET ultilisateur= "+ user+","+"pass="+pass+"WHERE ID=1" ;
		        
		        ResultSet r= this.stmt.executeQuery(query);
		        
		         /*user ="";
		         pass ="";
				while (r.next() ) {
					
		            user = r.getString("Utilisateur");
		   	    }*/
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public boolean showingPassWindow(){
	
	return true;	
	}
	
	public String loadcurrentdatabase( File f) throws FileNotFoundException,UnsupportedEncodingException,IOException{
		
		    
	        FileInputStream fichierTextStopWord = new FileInputStream(f);
			
			InputStreamReader LecteurFichierStopWord = new InputStreamReader(fichierTextStopWord, "UTF-8");
		    BufferedReader br = new BufferedReader(LecteurFichierStopWord);
			
		    ArrayList<String> ListeDesStopWord = new ArrayList<String>();
		    
			String ligne = null;
            String appending = "";
			while( (ligne = br.readLine())!= null ){
			        // \\s+ means any number of whitespaces between tokens
			    String [] tokens = ligne.split("\\s+");
			    }
			return "sd";
		
	}
public InputStreamReader LireStopWordFichier() throws UnsupportedEncodingException ,IOException{
		
		
		// needs a field outside for the stop words ArrayListe
		
		//must insert the direct file path in the FileInputStream
	    File f = new File("");
        FileInputStream fichierTextStopWord = new FileInputStream(f);
		
		InputStreamReader LecteurFichierStopWord = new InputStreamReader(fichierTextStopWord, "UTF-8");
		
		return LecteurFichierStopWord;
		
	}
	
}
