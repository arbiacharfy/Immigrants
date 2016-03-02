package ca.immigrants.models;

public class NiveauScolariteBean {
	
	// bd : (id, niveau, points)
	int idNiveauScolarite;
	String niveauScolarite;
	int pointsScolarite;
	
	
	
	
	public NiveauScolariteBean() {
		super();
		
	}
	
	

	public NiveauScolariteBean(String niveauScolarite, int pointsScolarite) {
		super();
		this.niveauScolarite = niveauScolarite;
		this.pointsScolarite = pointsScolarite;
	}



	public int getIdNiveauScolarite() {
		return idNiveauScolarite;
	}

	public String getNiveauScolarite() {
		return niveauScolarite;
	}
	public void setNiveauScolarite(String niveauScolarite) {
		this.niveauScolarite = niveauScolarite;
	}
	public int getPointsScolarite() {
		return pointsScolarite;
	}
	public void setPointsScolarite(int pointsScolarite) {
		this.pointsScolarite = pointsScolarite;
	}
	
	
	

}
