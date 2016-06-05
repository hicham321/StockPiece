import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
	
}
