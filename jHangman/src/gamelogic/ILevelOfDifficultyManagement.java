package gamelogic;

public interface ILevelOfDifficultyManagement {
	public void setLevel(int level) throws Exception;
	
	public int getLevel();
	
	public boolean getDisplayMissedShotsSetting();
	
	public boolean getFalseInputMeansLostLifeSetting();
	
	public int getLifePointsSetting();
}
