import java.util.ArrayList;

public class TennisGameScore {
	
	ArrayList <Integer> scoreA;
	ArrayList <Integer> scoreB;
	String scorePattern;
	int lastIndex;
	
	TennisGameScore(String scorePattern) {
		lastIndex= scorePattern.length();
		this.scorePattern = scorePattern;
		scorePatternAnalysis(scorePattern);
	}
	
	
	private void scorePatternAnalysis(String scorepattern) {
		
		int scoreA = 0;
		int scoreB = 0;
		
		this.scoreA = new ArrayList<Integer> ();
		this.scoreB = new ArrayList<Integer> ();
		
		int timeInstance = 0;
		
		for(Character c: scorepattern.toCharArray()) {					
			if(c == 'a')
			{
				scoreA++;
			}
			else
			{
				scoreB++;
			}
			this.scoreA.add(scoreA);
			this.scoreB.add(scoreB);
			
			if(getScoreForGivenInstance(timeInstance).contains("wins")) {
				lastIndex = timeInstance;
				break;
			}
			timeInstance++;
			
		}
	}
	
	public String getScoreForGivenInstance(int n) {
		
		if(n >= this.scoreA.size()) {
			n = this.scoreA.size() - 1;
		}
		
		if(lastIndex<n) {
			return getScoreForGivenInstance(lastIndex);
		}
		
		int scoreA = this.scoreA.get(n);
		int scoreB = this.scoreB.get(n);
		
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
		TennisGameScore tennisGameScore = new TennisGameScore("aabbabbb");
		System.out.println(tennisGameScore.getScoreForGivenInstance(3));
		
	}
}
