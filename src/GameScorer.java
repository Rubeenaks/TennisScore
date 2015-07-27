import java.util.ArrayList;

public class GameScorer {
	
	ArrayList <Integer> scoreA;
	ArrayList <Integer> scoreB;
	String gamePattern;
	int lastIndex;
	
	GameScorer()
	{
		lastIndex=0;
		gamePattern=null;
	}
	
	GameScorer(String gamePattern)
	{
		lastIndex= gamePattern.length();
		this.gamePattern = gamePattern;
		resultAnalysis(gamePattern);
	}
	
	
	String resultAnalysis(String scorepattern) {
		
		int scoreA = 0;
		int scoreB = 0;
		
		String resultofGame = null;
		
		this.scoreA = new ArrayList<Integer> ();
		this.scoreB = new ArrayList<Integer> ();
		
		int countScore = 0;
		int step =0;
		for(Character c: scorepattern.toCharArray()) {
			
			
			if(c == 'a')
				scoreA++;
			else
				scoreB++;
			
			this.scoreA.add(scoreA);
			this.scoreB.add(scoreB);
			
			System.out.println(getScore(countScore++));
			
			if(getScore(step).contains("wins"))
			{
				lastIndex = step;
				break;
			}
			step++;
			
		}
		
		return resultofGame;
	}
	
	String getPlayerScore(int x) {
		final String[] arr = {"0", "15", "30", "40"};
		return arr[x];
	}
	
	public String getScore(int n) {
		
		if(n >= this.scoreA.size())
			n = this.scoreA.size() - 1;
		
		if(lastIndex<n)
		{
			return getScore(lastIndex);
		}
		
		int scoreA = this.scoreA.get(n);
		int scoreB = this.scoreB.get(n);
		
		String score = new String();
		
		if (Math.abs(scoreA - scoreB) >=2 && (scoreA >= 4 || scoreB >= 4)) 
		{
			if(scoreA > scoreB)
				score += "A";
			else
				score += "B";
			
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
	
	public static void main (String[] args) {
		GameScorer gs = new GameScorer("abaaabbbbbbb");
		
	}
}
