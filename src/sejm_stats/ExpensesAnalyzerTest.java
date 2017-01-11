package sejm_stats;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;

public class ExpensesAnalyzerTest {

	private FileDownloader sources = new FileDownloader();
	
	@Test
	public void test() throws MalformedURLException, IOException {
		ExpensesAnalyzer tmp = new ExpensesAnalyzer();
		this.sources.initializeMpSet();
		Double singleMpExpenses = tmp.singleMpExpenses("Anna", "Nemœ", this.sources.mps, 8);
		Double singleMpOfficeExpenses = tmp.singleMpOfficeExpenses("Anna", "Nemœ", this.sources.mps, 8);
		Double averageMpExpenses = tmp.averageMpExpenses(this.sources.mps, 7);
		this.sources.updateMpSet();
		Double singleMpExpenses2 = tmp.singleMpExpenses("Anna", "Nemœ", this.sources.mps, 8);
		Double singleMpOfficeExpenses2 = tmp.singleMpOfficeExpenses("Anna", "Nemœ", this.sources.mps, 8);
		Double averageMpExpenses2 = tmp.averageMpExpenses(this.sources.mps, 7);
		assertEquals(singleMpExpenses,singleMpExpenses2);
		assertEquals(singleMpOfficeExpenses,singleMpOfficeExpenses2);
		assertEquals(averageMpExpenses,averageMpExpenses2);
	}

}
