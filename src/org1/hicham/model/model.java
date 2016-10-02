package org1.hicham.model;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

	public void insertProd(String designation){

		try {
			String query= "INSERT INTO Produit ( designationProduit,QteGlobal ) VALUES ("+ "'"+ designation+ "'"+","+"'"+ 0+ "'"+")";        	        
			stmt.execute(query);

		} catch (Exception e) {
			System.out.println(e);

		}

	}
	//update product (updating should only allow designation to be modified, Global quantity should be updated automatically)

	public void updateProd(String designation, int ID){

		try {
			String query= "UPDATE Produit SET designationProduit ='"+ designation +"'" + "WHERE IDprod= "+"'"+ ID+"'";

		    stmt.execute(query);

		} catch (Exception e) {
			System.out.println(e);

		}

	}
	//delete product
	public void deleteProd( int ID){
        //change the deleting process so that the products that are deleted aren't erased from the database completely
		//but instead mark every deleted item with a flag and avoid in the searching process 
		//this will beneficial when extracting info for factures that contain products that are already deleted.
		try {
			//this query deletes the entire Lots for the corresponding product id
//			String query2="DELETE FROM Lot WHERE Lot.IDProduit = "+"'"+ ID+"'";
			String query2= "UPDATE Produit SET (Deleted ) ='true' WHERE Produit.IDprod= "+"'"+ ID+"'";
			stmt.execute(query2);
			//delete the Lot from Lot  table
			String query1= "UPDATE Lot SET (Deleted ) ='true' WHERE Lot.IDProduit= "+"'"+ ID+"'";
			stmt.execute(query1);


		} catch (Exception e) {
			e.printStackTrace();
		}

	}



	//insert Lot(ajouté Lot)
	public void insertLot(double prixAchat,double prixVente,int qte ,int idprod){

		try {
			String query= "INSERT INTO Lot ( prixAchat,prixVente,qte,IDProduit) VALUES ("+ "'"+prixAchat + "'"+ "," + "'"+ prixVente +"'"+","+ "'"+ qte +"'"+","+ "'"+idprod+"'"+")";        	        
			this.stmt.execute(query);
			
		

		} catch (Exception e) {
			System.out.println(e);

		}

	}
	//modify Lot 
	public void updateLot(double prixAchat, double prixVente, int idProd, int idLot){

		try {
			String query= "UPDATE Lot SET (prixAchat ) ='"+ prixAchat +"'" +","+"(prixVente)="+"'"+prixVente+"'" + "WHERE Lot.IDProduit= "+"'"+ idProd+"'"+" AND Lot.IDLot="+"'"+idLot+"'";

		    stmt.execute(query);

		} catch (Exception e) {
			System.out.println(e);

		}

	}
	
	//Delete Lot
	public void deleteLot( int idProd, int idLot){

		try {
			//update query for changing Deleted, field in database to true
			//String query= "DELETE FROM Lot WHERE Lot.IDProduit = "+"'"+ idProd+"'"+"AND Lot.IDLot="+"'"+idLot+"'";
			String query= "UPDATE Lot SET (Deleted ) ='true' WHERE Lot.IDProduit= "+"'"+ idProd+"'"+" AND Lot.IDLot="+"'"+idLot+"'";

			stmt.execute(query);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//to add quantity or subtract it from LOT one should write an update query to an already inserted LOt 
	//it should also modify the global quantity accordingly:
	public int getLotQuantity( int idLot)throws SQLException{
		
			String query= "SELECT qte from Lot WHERE Lot.IDLot="+"'"+idLot+"'" ;	         	        
			ResultSet r= this.stmt.executeQuery(query);
			int qte=0;
			while(r.next()){
				qte= r.getInt("qte");
			}
			return qte;		
	}

	public void addQteLot(int qte,int idLot){
		try{
			int changeQte = getLotQuantity(idLot);
			int sumQte= qte+changeQte;
			String query= "UPDATE Lot SET (qte ) = "+ "'"+sumQte +"' WHERE Lot.IDLot="+"'"+idLot+"'";

		    stmt.execute(query);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	//this query is for substracting quantity
	public void substractQteLot(int qte,int idProd, int idLot ){
		try{
			int changeQte = getLotQuantity(idLot);
			int sumQte= qte-changeQte;
			String query= "UPDATE Lot SET (qte ) ="+"'"+ sumQte +"'"  + "WHERE Lot.IDLot="+"'"+idLot+"'";
			ResultSet r= stmt.executeQuery(query);
		}catch(Exception e){
			System.out.println(e);
		}

	}
	public int insertFactureFourniss(String numFact, String nomFourn, String type, String total,String date)throws SQLException{
			String query= "INSERT INTO Facture ( NumFacture,Nomfournis,Type ,Total ,DateFact) VALUES ("+ "'"+numFact +"'"+"," +"'"+ nomFourn+"'"+","+ "'"+ type+"'"+","+ "'"+ total+"'"+"," +"'"+ date+"'"+")";        	        
			int k=stmt.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
	        
		return k;		
	}
	public int insertFactureClient(String numFact, String nomFourn, String type, String total,String date)throws SQLException{
		    String query= "INSERT INTO Facture ( NumFacture,Nomfournis,Type ,Total ,DateFact) VALUES ("+ "'"+numFact +"'"+"," +"'"+ nomFourn+"'"+","+ "'"+ type+"'"+","+ "'"+ total+"'"+"," +"'"+ date+"'"+")";        	        
			int k=stmt.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);


			return k;		
			
	}
	//another ethod for getting the last generated key 
	public int getlastId()throws SQLException{
		String query= "SELECT MAX(IDFac) FROM Facture ";
		ResultSet rs= stmt.executeQuery(query);
		int g= 0;
		if (rs.next()) {
			  g = rs.getInt(1);
			}

		return g;
	}
	//to get the current date of Facture:
	public String getCurrentDate(){
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy MMMM dd");
	    java.util.Date date = new java.util.Date();
		String s= dateFormat.format(date);
		return s;
	}
	
    public void deleteFacture(int idFacture, int idProd, int idLot, String typeFac){
    	try {
    		//deleting facture only means deleting the quantities in that facture
    		//this query deletes Facture for it's corresponding id 
    		String query="DELETE FROM Facture WHERE Facture.IDFac = "+"'"+idFacture+"'";
			stmt.execute(query);
			//conditions to sustract or add quantity
			if ("fournisseur".equals(typeFac)) {
				//adding quatity query
			}
			if ("client".equals(typeFac)) {
				//adding quatity query

			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

    	
    }
    //this is to get the Facture numbers 
    public List<String> getFactureNum()throws SQLException{

    	String query = "SELECT  NumFacture FROM Facture ";
    	ResultSet r= this.stmt.executeQuery(query);
    	List<String> l = new ArrayList<>();
    	String s= "";
    	while (r.next()){
    		s= r.getString("NumFacture");
    		l.add(s);	
    	}
    	return l;
    }
    //this is for comparing between string and list of facture numbers
    public boolean checkNumFacture(String numFact)throws SQLException{
    	List<String>l=getFactureNum();
        boolean equal= false;
    	for (int i = 0; i < l.size(); i++) {
    		if (numFact.equals(l.get(i))) {
                 equal= true;
    		}

    	}
        return equal;

    }
    //this queries are for calculated fields
    //list of idprods to idlots means map where the keys idprod and values lists of lot id
    //we can then 
    public LinkedHashMap<Integer, List<Integer>> mapProdLotIds (List<Integer>liProd)throws SQLException{
    	LinkedHashMap<Integer, List<Integer>> mapProdIdListIdLot= new LinkedHashMap<>();
    	for(int i= 0; i<liProd.size();i++){
    		String query= "SELECT qte from Lot WHERE Lot.IDProduit="+"'"+liProd.get(i)+"'"+ "and Lot.Deleted='false'" ;
    		ResultSet rs= this.stmt.executeQuery(query);
    		List<Integer>l= new ArrayList<>();
    		int s= 0;
    		while (rs.next()) {
    			s=rs.getInt("qte");
    			l.add(s);
    		}
    		mapProdIdListIdLot.put(liProd.get(i), l);
    	}

    	return mapProdIdListIdLot;
    }

    public void UpdateQteGlobaleFromList(LinkedHashMap<Integer, List<Integer>> m)throws SQLException{
    	
    	for(int i: m.keySet()){
    		int sum=0;
    		List<Integer>listLotId=m.get(i);
    		for (int j = 0; j< listLotId.size();j++) {
    			sum= sum+listLotId.get(j);
    		}
    		//update method 
    		String query= "UPDATE  Produit  SET ( QteGlobal ) = ("+ "'"+sum+"'"+") WHERE Produit.IDprod="+"'"+i+"'";  
    		this.stmt.execute(query);
    	}
    }
    public void UpdateQteGlobale(List<Integer>liProd) throws SQLException{
    	LinkedHashMap<Integer, List<Integer>>m=mapProdLotIds(liProd);
    	UpdateQteGlobaleFromList(m);
    }
    
    public void insertChange(int idFact, int idLot, int qteChange)throws SQLException{
    	
    	String query= "INSERT INTO Change ( idFact,IdLot,QteChange ) VALUES ("+"'"+idFact+"'"+","+"'"+idLot+"'"+","+"'"+qteChange+"'"+")";        	        
		stmt.execute(query);
    	
    }
    //this query is for getting Lot info after executing a search via the combobox
	public List<Double> getSelectedLotRow(int  idLot,int idProd ) throws SQLException{

		String query= "SELECT * from Lot WHERE Lot.IDLot="+"'"+idLot+"'"+  "and Lot.IDProduit= "+"'"+idProd+"'" ;	         	        
		ResultSet r= this.stmt.executeQuery(query);
		List<Double> l = new ArrayList<>();
		while (r.next() ) {
			double prixachat = r.getDouble("prixAchat");
			double Prixvente = r.getDouble("prixVente");
			int qte= r.getInt("qte");
			double t= (double) qte;
			l.add(prixachat);
			l.add(Prixvente);
			l.add(t);

		}
		return l;
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
        ResultSet rs = stmt.executeQuery("SELECT * from Produit , Lot WHERE  Produit.IDprod= Lot.IDProduit and Produit.Deleted= false and Lot.Deleted = false");

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
    	
        ResultSet rs = stmt.executeQuery("SELECT designationProduit from Produit WHERE Produit.Deleted= false ");
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
    //method for getting selected product Id from product table
    
    public Map<String, Integer> getIDproductDesignation() throws SQLException{
        ResultSet rs = stmt.executeQuery("SELECT designationProduit,IDprod from Produit WHERE Deleted= 'false' ");
    	Map<String,Integer> l= new HashMap();

        int idprod= 0;
        String desProd="";
        while (rs.next()) {
        	idprod = rs.getInt("IDprod");
        	desProd = rs.getString("designationProduit");
            l.put(desProd, idprod);
		}

    	return l;
    }
    public int getQteGlobalProd(int idProd)throws SQLException{
    	
        ResultSet rs = stmt.executeQuery("SELECT QteGlobal from Produit WHERE Produit.IDprod="+"'"+idProd+"'" );
        int qteGlobal= 0;
        while(rs.next()){
        	qteGlobal= rs.getInt("QteGlobal");
        }
        return qteGlobal;

    }
    
    public List<String> allProducts()throws SQLException{
    	ResultSet rs = stmt.executeQuery("SELECT designationProduit from Produit ");
    	List<String> listOfAllProducts= new ArrayList<>();
    	String product= "";
    	while(rs.next()){
          product= rs.getString("designationProduit");
          listOfAllProducts.add(product);
    	}
    	return listOfAllProducts;
    }
    public boolean checkProdAlreadyInserted(List l,String lookedFor){
    	boolean found= false;
    	for (int i = 0; i < l.size(); i++) {
			if(lookedFor.equals(l.get(i))){
			      found=true;	
			}
			
		}
    	return found;
    }
    public double sumZakat(JTable table, int colNum1, int colNum2 ){
    	double sum=0;
    	int rowCount = table.getRowCount();
    	double produit=0;
    	for(int i=0;i<rowCount;i++){
    		produit=new Double(table.getValueAt(i, colNum1).toString())*new Double(table.getValueAt(i, colNum2).toString());
    		System.out.println("first argument "+new Double(table.getValueAt(i, colNum1).toString()));
    		System.out.println("second argument "+new Double(table.getValueAt(i, colNum2).toString()));
    		sum=sum+ produit;
    	}
    	return sum;
    }

    public DefaultComboBoxModel buildComboModelLot(int idProd) throws SQLException {

    	ResultSet rs = stmt.executeQuery("SELECT prixAchat from Lot WHERE Lot.IDProduit="+"'"+idProd+"'" +"and "+"Lot.Deleted='false'");
    	DefaultComboBoxModel v = new DefaultComboBoxModel<>();
    	String prixAchat="";
    	List<String> listProd= new ArrayList<>();
    	while (rs.next()) {
    		prixAchat = rs.getString("prixAchat");
    		listProd.add(prixAchat);
    	}
    	for (int i = 0; i < listProd.size(); i++) {
    		v.addElement(new MyClass(listProd.get(i)));	
    	}
    	return v;
    }
    //this is for getting lists of lot Ids and Lot prix achat 
    public List<Integer> getIdLot(int idprod) throws SQLException{
        ResultSet rs = stmt.executeQuery("SELECT IDLot from Lot WHERE Lot.IDProduit="+"'"+idprod+"'" +"and "+"Lot.Deleted='false'");
    	List<Integer> l= new ArrayList<>();
    	int idLotdatabase= 0;
    	while (rs.next()) {
    		idLotdatabase= rs.getInt("IDLot");
            l.add(idLotdatabase);
		}
    	
    	return l;
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
	//return the password and user name in the database
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
            System.out.println("update executed");
			String query= "UPDATE Register SET utilisateur= "+"'"+ user+"'"+","+"pass="+"'"+pass+"'"+"WHERE Register.ID=1" ;

			this.stmt.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
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
	//this is method that return tru if a string is numeric(integer or decimal) using Regex
	public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}


	//generation a random number 
	public int generateRandomNumber(){

		return 3;
	}

	public class MyClass{

		private String myName;

		public MyClass(String name){
			this.myName = name;
		}
		@Override
		public String toString(){
			return myName;
		}

	}



}
