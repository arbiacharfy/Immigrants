package ca.immigrants.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AgeBean {
	
	
	private final int MYSQL_PORT=3306; 
	private final String DBHOST="localhost";
	private final String DBNAME="bdimmigrants";
	private final String DBUSER="arbia";
	private final String DBPASSWD="cyclam76";
	private Connection conn=null;
    private Statement stmt = null;
    private ResultSet result = null;

	int minAge;
	int maxAge;
	int pointsAge;
	 private String message="";

	public AgeBean() {
		super();
	}

	public AgeBean(int minAge, int maxAge, int pointsAge) {
		super();
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.pointsAge = pointsAge;
	}
	
	
	 private void loadDriver(){
		 try{
			// Class.forName("../lib/com.mysql.jdbc.Driver").newInstance();
			 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		 }catch(Exception e){
			 System.out.println(e.getMessage());
		 }
	 }
	 
	 
	 public boolean connectToDB(){
		 boolean returnval=false;
		 try{
			 
			this.loadDriver();
			//String conUrl="jdbc:mysql://localhost/inf3005demo?user=demo&password=demo";
			String conUrl="jdbc:mysql://"+this.DBHOST+":"+this.MYSQL_PORT+"/"+this.DBNAME+"?"+
			               "user="+this.DBUSER+"&password="+this.DBPASSWD+"";
			//System.out.println("conurl = "+conUrl);
			this.conn=DriverManager.getConnection(conUrl);
			 returnval=true;
		 }catch(SQLException sex) {
			// handle any errors
			 System.out.println("SQLException: " + sex.getMessage());
			 System.out.println("SQLState: " + sex.getSQLState());
			 System.out.println("SQLState: " + sex.getCause());
		
		 }
		 return(returnval);
	 }
	 
	 
	 
	 //manipulation des donn�es
	 /*
	  * cette methode execute une requette dans la bd
	  */
	 private boolean runQuery(String sqlQuery){
		 boolean returnval=false;
		 try{
			 this.stmt=this.conn.createStatement(); 
			 //this.result=this.stmt.executeQuery(sqlQuery);
			 this.stmt.execute(sqlQuery,this.stmt.RETURN_GENERATED_KEYS);
			// stmt.RETURN_GENERATED_KEYS permet de recuperer id de dernier enregistrement inser�
			 this.result=this.stmt.getResultSet();
			 returnval=true;
		 }catch(Exception e){
			 System.out.println(this.getMaxAge()+ " ; "+ this.getMinAge() +" non execute");
			 //si erreur alors aucun resultat
			 this.result=null;
		 }
		 return returnval;
	 }
	 
	 
	 
	 
	 /*
	  * enregistrement des informations age
	  */
	 public boolean savePersonneInfo(){
		 boolean returnval=false;
		 
		 if(this.getMinAge()>=18 && this.getMaxAge()<=100){
			 try{
				 
				 // INSERT INTO `bdimmigrants`.`age` (`ageMin`, `ageMax`, `pointsAge`) VALUES ('20', '20', '20');
				 String query="INSERT INTO bdimmigrants.age(ageMin,ageMax,pointsAge)";
				 query=query+" VALUES ('"+this.getMinAge()+"','"+this.getMaxAge()+"','"+this.getPointsAge()+"') ";
				 if(this.runQuery(query)){
					 //this.idPersonne=this.result.get
					 ResultSet rsKey=this.stmt.getGeneratedKeys();
//					 if(rsKey.next()){
//					 this.idPersonne=rsKey.getInt(1);//id de la derniere personne
//					this.setMessage("Dernière personne enregistrée avec id = "+this.idPersonne);
//					 }
					returnval=true;
					 }
			 }catch(Exception e){
				 //traitement erreur ignoré
				 System.out.println("Probleme pour enregitsrer");
			 }
		 }
		 return returnval;
	 }
	 
	 //extraction des information d'une personne
	 public boolean nextAgeReady(){
		 boolean returnval=false;
		 try{
			 if(this.result.next()){
				 
				 this.minAge = this.result.getInt("minAge");
				 this.maxAge = this.result.getInt("maxAge");
				 this.pointsAge = this.result.getInt("pointsAge");
				 
//				 this.idPersonne=this.result.getInt("id");
//				 this.nomPersonne=this.result.getString("nom");
//				 this.prenomPersonne=this.result.getString("prenom");
				 returnval=true;
			 }
		 }catch(Exception e){
			 //valeur invalides si on arrive pas a lire
			
			 this.minAge=-1;
			 this.maxAge=-1;
			 this.pointsAge = -1;
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
		setPointsAge(getPointsAge()+10);
	}
	
	 private void setMessage(String mesg){
		 this.message = mesg;
	 }
	 /*
	  * return le message courrant et reinitialise la propriete
	  * Ceci est un choix personnel. On peut g�rer �a autrement!
	  */
	 public String getMessage(){
		 String returnMessage=this.message;
		 this.message="";
		 return returnMessage;
	 }
	

}
