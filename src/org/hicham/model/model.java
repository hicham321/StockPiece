package org.hicham.model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.apache.commons.codec.binary.Base64;
import org.hsqldb.Tokens;




public class model {

	private Connection con ;

	private Statement stmt;

	//fields for hashing the password
	private static final int iterations = 20*1000;
	private static final int saltLen = 32;
	private static final int desiredKeyLen = 256;


	public void connectio ( String path ){

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			this.con = DriverManager.getConnection(path, "", "");

			this.stmt = con.createStatement();

		} catch (SQLException ex) {

			System.err.println("SQLException: " + ex.getMessage());
		} catch (ClassNotFoundException e) {

			System.err.println("classnotfoundException: " + e.getMessage());
		}
	}	


	//Search product
	// used with combobox 
	public void searchLot(){


	}
	//insert product 

	public void insertProd(String designation,int qteglobal){

		try {
			String query= "INSERT INTO Lot ( designationProduit , QteGlobal) VALUES ("+ "'"+ designation+ "'"+ "," + "'"+qteglobal +"'"+")";        	        
			ResultSet r= this.stmt.executeQuery(query);

			while (r.next() ) {
				designation = r.getString("designationProduit");
				qteglobal= r.getInt("qte");

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);

		}

	}
	//update product (updating should only allow designation to be modified, Global quantity should be updated automatically)

	public void updateProd(String designation, int ID){

		try {
			String query= "UPDATE Produit SET designationProduit ='"+ designation +"'" + "WHERE IDprod= "+"'"+ ID+"'";

			ResultSet r= this.stmt.executeQuery(query);

			/*while (r.next() ) {
				designation = r.getString("designationProduit");

			}*/

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);

		}

	}
	//delete product
	public void deleteProd( int ID){

		try {
			String query= "DELETE FROM Produit WHERE IDprod = "+"'"+ ID+"'";

			ResultSet r= this.stmt.executeQuery(query);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);

		}

	}



	//insert Lot(ajouté Lot)
	public void insertLot(String nom,String Referance,double prixachat,double Prixvente,int qte){

		try {
			String query= "INSERT INTO Lot ( Nom , reference , prixachat , Prixvent , qte ) VALUES ("+ "'"+ nom+ "'"+ "," + "'"+Referance +"'"+","+ "'"+prixachat +"'"+","+ "'"+Prixvente +"'"+ "'"+qte +"'"+")";        	        
			ResultSet r= this.stmt.executeQuery(query);

			while (r.next() ) {
				nom = r.getString("Nom");
				Referance = r.getString("Referance");
				prixachat = r.getDouble("Prixachat");
				Prixvente = r.getDouble("Prixvent");
				qte= r.getInt("qte");

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);

		}

	}
	//to add quantity or subtract it from LOT one should write an update query to an already inserted LOt 
	//it should also modify the global quantity accordingly:
	public void addQteLot(int qte, int idLot){
		try{
			String query= "UPDATE Lot SET qte =qte + '"+ qte +"'" + "WHERE IDLot= "+"'"+ idLot+"'";
			ResultSet r= stmt.executeQuery(query);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	//this query is for substracting quantity
	public void substractQteLot(int qte, int idLot ){
		try{
			String query= "UPDATE Lot SET qte =qte - '"+ qte +"'" + "WHERE IDLot= "+"'"+ idLot+"'";
			ResultSet r= stmt.executeQuery(query);
		}catch(Exception e){
			System.out.println(e);
		}

	}
	//this query is for getting Lot info after executing a search via the combobox
	public void RechLot(String Nom ){
		try {
			String query= "SELECT * from Lot WHERE Mot= '" +Nom +"'" +" and "+"Prenom"+"'"+"'" ;	         	        
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
	//this method is to create a table model for the Jtables
	public static DefaultTableModel buildTableModel(ResultSet rs)
			throws SQLException {

		ResultSetMetaData metaData = rs.getMetaData();

		// names of columns
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			columnNames.add(metaData.getColumnName(column));
		}

		// data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				vector.add(rs.getObject(columnIndex));
			}
			data.add(vector);
		}

		return new DefaultTableModel(data, columnNames);

	}
	//quries to execute for Jtable model listProduit
    public ResultSet listProduitToutResultat()throws SQLException{
    	//connectio("jdbc:ucanaccess://C:/Users/Hicham/ddd.accdb");
        ResultSet rs = stmt.executeQuery("SELECT * from Lot");

    	return rs;
    }
    
    public ResultSet listProduitDisponibleResultat()throws SQLException{
    	
        ResultSet rs = stmt.executeQuery("SELECT * from Lot Where lot.qte > 0");

    	return rs;
    }
    public ResultSet listFactureSortie()throws SQLException{
    	//connectio("jdbc:ucanaccess://C:/Users/Hicham/ddd.accdb");
        ResultSet rs = stmt.executeQuery("SELECT * from Facture WHERE Facture.Type= 'client'");

    	return rs;
    }
    public ResultSet listFactureEntre()throws SQLException{
    	//connectio("jdbc:ucanaccess://C:/Users/Hicham/ddd.accdb");
        ResultSet rs = stmt.executeQuery("SELECT * from Facture WHERE Facture.Type= 'fournisseur'");

    	return rs;
    }
    public ResultSet listFactureTout()throws SQLException{
    	//connectio("jdbc:ucanaccess://C:/Users/Hicham/ddd.accdb");
        ResultSet rs = stmt.executeQuery("SELECT * from Facture ");

    	return rs;
    }
    public ResultSet listProduitZakat()throws SQLException{
    	//connectio("jdbc:ucanaccess://C:/Users/Hicham/ddd.accdb");
        ResultSet rs = stmt.executeQuery("SELECT * from Produit,Lot WHERE Produit.IDprod= Lot.IDProduit and  Lot.qte > 0 ");

    	return rs;
    }
    //delete multiple columns from Jtable
    public void deleteMultipleColumns(JTable table, int[] columnArray){

    	for(int i=0;i <columnArray.length;i++){
    		TableColumn tcol = table.getColumnModel().getColumn(columnArray[i]);
    		table.getColumnModel().removeColumn(tcol);
    	}
    }
    
    
    //this part if for the JCombobox Model
    
    //this should return a mode that contains each product designation:
    public DefaultComboBoxModel buildComboModel() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT designationProduit from Produit ");
    	DefaultComboBoxModel v = new DefaultComboBoxModel<>();
        String designationProd="";
        List<String> listProd= new ArrayList<>();
        while (rs.next()) {
        	designationProd = rs.getString("designationProduit");
            listProd.add(designationProd);
		}
    	for (int i = 0; i < listProd.size(); i++) {
		       v.addElement(listProd.get(i));	
		}
    	return v;
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
	//this method reads the paths textfile and returns the current utilised database
	public String loadcurrentdatabase( File f) throws FileNotFoundException,UnsupportedEncodingException,IOException{

		//the file should always have one line representing the database path

		FileInputStream fichierTextStopWord = new FileInputStream(f);

		InputStreamReader LecteurFichierStopWord = new InputStreamReader(fichierTextStopWord, "UTF-8");
		BufferedReader br = new BufferedReader(LecteurFichierStopWord);

		ArrayList<String> ListeDesStopWord = new ArrayList<String>();

		String ligne = null;
		String appending = "";
		while( (ligne = br.readLine())!= null ){
			// \\s+ means any number of whitespaces between tokens
			String [] tokens = ligne.split("\\s+");
			appending=tokens[0];
		}
		return appending;

	}
	//this will write the chosen db path in a textfile for the next execution  

	public void writdatabasepath(String dbpath, File f){
		FileOutputStream stream = null;
		PrintStream out = null;
		try {

			stream = new FileOutputStream(f); 
			out = new PrintStream(stream);
			out.print(dbpath);                  //This will overwrite existing contents

		} catch (Exception ex) {
			//do something
		} finally {
			try {
				if(stream!=null) stream.close();
				if(out!=null) out.close();
			} catch (Exception ex) {
				//do something
			}
		}	

	}
	//this empties the file that contains the db path
	public void emptyFile (File f) throws FileNotFoundException{

		PrintWriter pw = new PrintWriter(f);
		pw.close();
	}

	//this is for hashing the db passwords

	/** Computes a salted PBKDF2 hash of given plaintext password
    suitable for storing in a database. 
    Empty passwords are not supported. */
	public static String getSaltedHash(String password) throws Exception {
		byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLen);
		// store the salt with the password
		return Base64.encodeBase64String(salt) + "$" + hash(password, salt);
	}
	/** Checks whether given plaintext password corresponds 
to a stored salted hash of the password. */
	public static boolean check(String password, String stored) throws Exception{
		String[] saltAndPass = stored.split("\\$");
		if (saltAndPass.length != 2) {
			throw new IllegalStateException(
					"The stored password have the form 'salt$hash'");
		}
		String hashOfInput = hash(password, Base64.decodeBase64(saltAndPass[0]));
		return hashOfInput.equals(saltAndPass[1]);
	}
	// using PBKDF2 from Sun, an alternative is https://github.com/wg/scrypt
	// cf. http://www.unlimitednovelty.com/2012/03/dont-use-bcrypt.html
	private static String hash(String password, byte[] salt) throws Exception {
		if (password == null || password.length() == 0)
			throw new IllegalArgumentException("Empty passwords are not supported.");
		SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		SecretKey key = f.generateSecret(new PBEKeySpec(
				password.toCharArray(), salt, iterations, desiredKeyLen)
				);
		return Base64.encodeBase64String(key.getEncoded());
	}
	//is Integer method **checks if a given String is an Integer** 
	public static boolean isInteger(String str) {
		if (str == null) {
			return false;
		}
		int length = str.length();
		if (length == 0) {
			return false;
		}
		int i = 0;
		if (str.charAt(0) == '-') {
			if (length == 1) {
				return false;
			}
			i = 1;
		}
		for (; i < length; i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}


	//generation a random number 
	public int generateRandomNumber(){

		return 3;
	}



}
