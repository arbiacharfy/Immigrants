package ca.immigrants.models;

public class AgeBean {

	int minAge;
	int maxAge;
	int pointsAge;

	public AgeBean() {
		super();
	}

	public AgeBean(int minAge, int maxAge, int pointsAge) {
		super();
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.pointsAge = pointsAge;
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
	

}
