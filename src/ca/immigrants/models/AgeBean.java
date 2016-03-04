package ca.immigrants.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AgeBean {

	private final int MYSQL_PORT = 3306; // 8889 ATTENTION par defaut mysql est
											// sur 3306
	private final String DBHOST = "localhost";
	private final String DBNAME = "bdimmigrants";
	private final String DBUSER = "lina";
	private final String DBPASSWD = "";
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet result = null;

	int minAge = 0;
	int maxAge = 0;
	int pointsAge = 0;
	private String message = "";

	public AgeBean() {
		super();
	}

	public AgeBean(int maxAge, int minAge, int pointsAge) {
		super();
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.pointsAge = pointsAge;
	}

	private void loadDriver() {
		try {
			// Class.forName("../lib/com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean connectToDB() {
		boolean returnval = false;
		try {

			this.loadDriver();
			// String
			// conUrl="jdbc:mysql://localhost/inf3005demo?user=demo&password=demo";
			String conUrl = "jdbc:mysql://" + this.DBHOST + ":" + this.MYSQL_PORT + "/" + this.DBNAME + "?" + "user="
					+ this.DBUSER + "&password=" + this.DBPASSWD + "";
			// System.out.println("conurl = "+conUrl);
			this.conn = DriverManager.getConnection(conUrl);
			returnval = true;
		} catch (SQLException sex) {
			// handle any errors
			System.out.println("SQLException: " + sex.getMessage());
			System.out.println("SQLState: " + sex.getSQLState());
			System.out.println("SQLState: " + sex.getCause());
			// traitment cas erreur
			// returnval=true;
		}
		return (returnval);
	}

	/*
	 * cette methode execute une requette dans la bd
	 */
	private boolean runQuery(String sqlQuery) {
		boolean returnval = false;
		try {
			this.stmt = this.conn.createStatement();
			this.result=this.stmt.executeQuery(sqlQuery);
			this.result = this.stmt.getResultSet();
			returnval = true;
			System.out.println("Run Query : " + this.result.getFetchSize());
					
		} catch (Exception e) {
			System.out.println("min : " + this.minAge + " and this max: " + this.maxAge + " non execute");
			this.result = null;
		}
		return returnval;
	}

	/*
	 * enregistrement des informations d'une personne
	 */
	public boolean savePersonneInfo() {
		boolean returnval = false;

		if (this.getMinAge() > 0 && this.getMaxAge() <= 999) {
			try {
				String query = "INSERT INTO age(ageMax,ageMin,pointsAge) ";
				query = query + " VALUES ('" + this.getMaxAge() + "','" + this.getMinAge() + "','" + this.getPointsAge()
						+ "')";
				//String query2 = "INSERT INTO age (ageMin, ageMax, pointsAge) VALUES ('"+ +"', '20', '30');";
				
				if (this.runQuery(query)) {
					this.setMessage("Ajout succees ");
					returnval = true;
				}
			} catch (Exception e) {
				// traitement erreur ignoré
				System.out.println("Probleme pour enregitsrer");
			}
		}
		return returnval;
	}

	// extraction des information d'une personne
	public boolean nextPersonneReady() {
		boolean returnval = false;
		try {
			if (this.result.next()) {
				System.out.println("Yes");
				this.maxAge = this.result.getInt("ageMax");
				this.minAge = this.result.getInt("ageMin");
				this.pointsAge = this.result.getInt("pointsAge");
				
				
				returnval = true;
			}
		} catch (Exception e) {
			// valeur invalides si on arrive pas a lire
			this.minAge = -1;
			this.maxAge = -1;
			this.pointsAge = -1;
		}
		return returnval;
	}
	
	
	//charge les information des toutes les personnes de la BD 
	 public boolean loadAllPersonnesInfo(){
		 boolean returnval=false;
		 try{
		 String query="SELECT * FROM age";
		 if(this.runQuery(query)){
			   returnval=true;
			 }
		 }catch(Exception e){
			 System.out.println("Probleme dans la methode loadAllPersonnesInfo");
		 }
		 return returnval;
	 }
	 
	 
	 //mettre Ã  jour le nom
	 public boolean updateNomPersonne(){
		 boolean returnval=false;
//		 if(this.nomPersonne.length()>1 && this.idPersonne>0){
//			 try{
//				 String query="UPDATE personnes SET nom = '"+this.nomPersonne+"' ";
//				 query=query+" WHERE id="+this.idPersonne+" ";
//				 if(this.runQuery(query)){
//					 returnval=true;
//					 }
//			 }catch(Exception e){
//				 //traitement erreur ignorÃ©
//			 }
//		 }
		 return returnval;
	 }
	 
	//mettre Ã  jour le prÃ©nom
	 public boolean updatePrenomPersonne(){
		 boolean returnval=false;
//		 if(this.prenomPersonne.length()>1 && this.idPersonne>0){
//			 try{
//				 String query="UPDATE personnes SET prenom = '"+this.prenomPersonne+"' ";
//				 query=query+" WHERE id="+this.idPersonne+" ";
//				 if(this.runQuery(query)){
//					 returnval=true;
//					 }
//			 }catch(Exception e){
//				 //traitement erreur ignorÃ©
//			 }
//		 }
		 return returnval;
	 }
	 
	 //mettre ajour nom et prenom
	 public boolean updateNomPrenomPersonne(){
		 boolean returnval=false;
//		 if(this.nomPersonne.length()>1 && this.idPersonne>0){
//			 try{
//				 String query="UPDATE personnes SET nom = '"+this.nomPersonne+"' ";
//				 query=query+" prenom = '"+this.prenomPersonne+"' ";
//				 query=query+" WHERE id="+this.idPersonne+" ";
//				 if(this.runQuery(query)){
//				 returnval=true;
//				 }
//			 }catch(Exception e){
//				 //traitement erreur ignorÃ©
//			 }
//		 }
		 return returnval;
	 }

	 
	 //charge les information d'une personne par Id de la BD
	 public boolean loadPersonneInfoById(int pId){
		 boolean returnval=false;
		 try{
		 String query="SELECT * FROM personnes WHERE id= "+pId+" ";
		 if(this.runQuery(query)){
			 returnval=true;
			 }
		 }catch(Exception e){
			 //
		 }
		 return returnval;
	 }

	 
	 

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public int getPointsAge() {
		return pointsAge;
	}

	public void setPointsAge(int pointsAge) {
		this.pointsAge = pointsAge;
	}

	public void ChangerPoints() {
		setPointsAge(getPointsAge() + 10);
	}

	private void setMessage(String mesg) {
		this.message = mesg;
	}

	/*
	 * return le message courrant et reinitialise la propriete Ceci est un choix
	 * personnel. On peut g�rer �a autrement!
	 */
	public String getMessage() {
		String returnMessage = this.message;
		this.message = "";
		return returnMessage;
	}

}
