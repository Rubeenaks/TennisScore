import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class TestTennisGameScorer {

	@Test
	public void TestScoreAtBeginning()
	{
		TennisGameScore tennisGameScore = new TennisGameScore("aaaba");
		assertEquals("0-0",tennisGameScore.getScoreForGivenInstance(0));
	}
	
	@Test
	public void TestGameScoreAtMiddle()
	{
		TennisGameScore tennisGameScore = new TennisGameScore("aaaba");
		assertEquals("30-0",tennisGameScore.getScoreForGivenInstance(2));
	}
	
	@Test
	public void TestGameScoreAtEnd()
	{
		TennisGameScore tennisGameScore = new TennisGameScore("aaaba");
		assertEquals("A wins",tennisGameScore.getScoreForGivenInstance(5));
	}
	
	@Test
	public void TestGameScoreAfterWinning()
	{
		TennisGameScore tennisGameScore = new TennisGameScore("aaaba");
		assertEquals("A wins 40-15",tennisGameScore.getScoreForGivenInstance(6));
	}
	
	@Test
	public void TestGameScoreWhenAdvantage()
	{
		TennisGameScore tennisGameScore = new TennisGameScore("bbbaaab");
		assertEquals("Advantage B",tennisGameScore.getScoreForGivenInstance(7));
	}
	
	@Test
	public void TestGameScoreWhenDeuce()
	{
		TennisGameScore tennisGameScore = new TennisGameScore("aaabbb");
		assertEquals("Deuce",tennisGameScore.getScoreForGivenInstance(6));
	}
}
