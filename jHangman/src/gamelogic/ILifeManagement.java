package gamelogic;

public interface ILifeManagement {
	public void loseALife();
	
	public boolean isStillAlive();
	
	public int getCurrentLifePoints();
	
	public int getMaxLifePoints();
	
	public String toString();
}
