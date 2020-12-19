package gamelogic;

public class LifeManagement {
	private final int maxLifePoints;
	private int currentLifePoints;
	
	LifeManagement(int maxLifePoints){
		this.maxLifePoints = maxLifePoints;
		this.currentLifePoints = maxLifePoints;
	}
	
	public void loseALife() {
		--this.currentLifePoints;
		System.out.println(	"You lost a life point! " 
							+ this.getCurrentLifePoints() + "/" 
							+ this.getMaxLifePoints() );
	}
	
	public boolean isStillAlive() {
		return (this.currentLifePoints > 0);
	}
	
	public int getCurrentLifePoints() {
		return this.currentLifePoints;
	}
	
	public int getMaxLifePoints() {
		return this.maxLifePoints;
	}
	
	public String toString() {
		String hearts = new String();
		for(int i = 0; i < this.currentLifePoints; ++i) {
			hearts += "♥";
		}
		for(int i = 0; i < (this.maxLifePoints - this.currentLifePoints); ++i) {
			hearts += "♡";
		}
		return hearts;
	}
}
