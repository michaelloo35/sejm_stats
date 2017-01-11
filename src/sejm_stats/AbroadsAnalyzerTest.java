package sejm_stats;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.LinkedList;

import org.junit.Test;

public class AbroadsAnalyzerTest {

	private FileDownloader sources = new FileDownloader();
	
	@Test
	public void test() {
		AbroadsAnalyzer tmp = new AbroadsAnalyzer();
		try {
			this.sources.initializeMpSet();
		} catch (IOException e) {
			System.out.println(e);
		}
		
		String biggestTraveler = tmp.biggestTraveler(this.sources.mps,7);
		String longestAbroad = tmp.longestAbroad(this.sources.mps, 8);
		String mostExpensiveSingleTravel = tmp.mostExpensiveSingleTravel(this.sources.mps, 8);
		LinkedList<Mp> mpsThatVisitedItaly = tmp.mpsThatVisitedItaly(this.sources.mps, 7);
		
		try {
			this.sources.updateMpSet();
		} catch (IOException e) {
			System.out.println(e);
		}
		
		String biggestTraveler2 = tmp.biggestTraveler(this.sources.mps,7);
		String longestAbroad2 = tmp.longestAbroad(this.sources.mps, 8);
		String mostExpensiveSingleTravel2 = tmp.mostExpensiveSingleTravel(this.sources.mps, 8);
		LinkedList<Mp> mpsThatVisitedItaly2 = tmp.mpsThatVisitedItaly(this.sources.mps, 7);

		assertEquals(biggestTraveler,biggestTraveler2);
		assertEquals(longestAbroad,longestAbroad2);
		assertEquals(mostExpensiveSingleTravel,mostExpensiveSingleTravel2);
		assertEquals(mpsThatVisitedItaly,mpsThatVisitedItaly2);

	}

}
