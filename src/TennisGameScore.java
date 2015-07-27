import java.util.ArrayList;

public class TennisGameScore {
	
	ArrayList <Integer> scoreA;
	ArrayList <Integer> scoreB;
	String scorePattern;
	int endOfGame;
	
	int currentScoreA;
	int currentScoreB;
	
	
	TennisGameScore(String scorePattern) {
		
		this.scoreA = new ArrayList<Integer> ();
		this.scoreB = new ArrayList<Integer> ();
		
		endOfGame = 0;
		currentScoreA = 0;
		currentScoreB = 0;
		
		this.scorePattern = scorePattern;
		this.scoreA.add(0);
		this.scoreB.add(0);
		scorePatternAnalysis(scorePattern);
	}
		
	private void updateScore(char winner)
	{
		if(winner=='a')
		{
			currentScoreA++;
		}
		else
		{
			currentScoreB++;
		}
	}
	private String getScore()
	{
		String score = null;
		if (Math.abs(currentScoreA - currentScoreB) >=2 && (currentScoreA >= 4 || currentScoreB >= 4)) {
			if(currentScoreA > currentScoreB)
			{
				score += "A";
			}
			else
			{
				score += "B";
			}
			
			score+= " wins";
		}
		else if (currentScoreA < 3 || currentScoreB < 3) {
			score += getPlayerScore(currentScoreA) + "-" + getPlayerScore(currentScoreB);
		}
		else if (currentScoreA == currentScoreB) {
			score += "Deuce";
		}
		else {
			score+= "Advantage ";
			if (currentScoreA > currentScoreB)
				score += "A";
			else
				score += "B";
		}
		
		return score;
	}
	
	private void scorePatternAnalysis(String scorepattern) {
		
		int scoreA = 0;
		int scoreB = 0;

		this.scoreA = new ArrayList<Integer> ();
		this.scoreB = new ArrayList<Integer> ();
		this.scoreA.add(scoreA);
		this.scoreB.add(scoreB);

		for(Character serviceResult: scorepattern.toCharArray()) {					
			if(serviceResult == 'a')
			{
				scoreA++;
			}
			else
			{
				scoreB++;
			}
			this.scoreA.add(scoreA);
			this.scoreB.add(scoreB);
			if(getScoreForGivenInstance(endOfGame).contains("wins"))
			{
				break;
			}
			endOfGame++;
			
		}
	}
	
	
	public String getScoreForGivenInstance(int time)
	{
		String result = "";
		if(time<=endOfGame)
		{
			return getScore(time);
		}
		else
		{
			return (getScore(endOfGame)+" "+getScore(endOfGame-1));
		}
		
		
	}
	
	
	public String getScore(int time) {
		
		if(time >= this.scoreA.size()) {
			time = this.scoreA.size() - 1;
		}
		
	
		int scoreA = this.scoreA.get(time);
		int scoreB = this.scoreB.get(time);
		
		String score = new String();
		
		if (Math.abs(scoreA - scoreB) >=2 && (scoreA >= 4 || scoreB >= 4)) {
			if(scoreA > scoreB)
			{
				score += "A";
			}
			else
			{
				score += "B";
			}
			
			score+= " wins";
		}
		else if (scoreA < 3 || scoreB < 3) {
			score += getPlayerScore(scoreA) + "-" + getPlayerScore(scoreB);
		}
		else if (scoreA == scoreB) {
			score += "Deuce";
		}
		else {
			score+= "Advantage ";
			if (scoreA > scoreB)
				score += "A";
			else
				score += "B";
		}
		return score;
		
	}
	
	private String getPlayerScore(int x) {
		final String[] score = {"0", "15", "30", "40"};
		return score[x];
	}
	
	public static void main (String[] args) {
		TennisGameScore tennisGameScore = new TennisGameScore("aaaba");
		System.out.println(tennisGameScore.getScoreForGivenInstance(4));
		
	}
}
