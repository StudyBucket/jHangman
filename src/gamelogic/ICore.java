package gamelogic;

public interface ICore {
	
	public void startRound();
	
	public void endRound();
	
	public boolean isPlaying();
	
	public void shoot(String input);

}
