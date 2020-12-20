package gamelogic;

public class LevelOfDifficultyManagement implements ILevelOfDifficultyManagement {

	private int level;
	private int lifePoints;
	private boolean displayMissedShots = false;
	private boolean falseInputMeansLostLife = false;
	
	@Override
	public void setLevel(int level) throws Exception {
		try {
			if(level != 0 && level != 1 && level != 2) throw new Exception("Illegal Level selected. Choose from [0-2]!");
			this.level = level;
			this.adjustValues();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void adjustValues() {
		switch(this.level) {
			default:
				this.lifePoints = 9;
				this.displayMissedShots = true;
				break;
				
			case 1:
				this.lifePoints = 7;
			  	break;
		  
			case 2:
				this.lifePoints = 5;
			  	this.falseInputMeansLostLife = true;
			  	break;
		}
	}

	@Override
	public boolean getDisplayMissedShotsSetting() {
		return this.displayMissedShots;
	}

	@Override
	public boolean getFalseInputMeansLostLifeSetting() {
		return this.falseInputMeansLostLife;
	}

	@Override
	public int getLifePointsSetting() {
		return this.lifePoints;
	}

	@Override
	public int getLevel() {
		return this.level;
	}

	
}
