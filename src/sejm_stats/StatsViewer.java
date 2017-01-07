package sejm_stats;

import java.io.IOException;
import java.net.MalformedURLException;

public class StatsViewer {
	private FileDownloader sources;
	StatsViewer () throws MalformedURLException, IOException{
		this.sources = new FileDownloader();
		this.sources.initializeMpSet();
	}
	
	public void execute(String []args) throws MalformedURLException, IOException{
		Parser tmp = new Parser();
		tmp.parse(args);
		switch(tmp.getArgument1()){
		case "info" :
		case "infobez" :
			ExpensesAnalyzer expenses = new ExpensesAnalyzer();
			if (tmp.getArgument1().equals("info")){
				System.out.println("suma wydatków " + tmp.getArgument2() + " " + tmp.getArgument3() + " sprawuj¹cego/sprawuj¹cej mandat w " + tmp.getCadency() + " kadencji: " + expenses.singleMpExpenses(tmp.getArgument2(), tmp.getArgument3(), sources.mps, tmp.getCadency()));
				System.out.println("suma wydatków na drobne naprawy i remonty biura poselskiego " + tmp.getArgument2() + " " + tmp.getArgument3() + " sprawuj¹cego/sprawuj¹cej mandat w " + tmp.getCadency() + " kadencji: " + expenses.singleMpOfficeExpenses(tmp.getArgument2(), tmp.getArgument3(), sources.mps, tmp.getCadency()));
			System.out.println("srednia wydatkow z " + tmp.getCadency() + " kadencji: " + expenses.averageMpExpenses(sources.mps, tmp.getCadency()));
			}
			AbroadsAnalyzer abroads = new AbroadsAnalyzer();
			System.out.println("najwiecej podrozy zagranicznych z " + tmp.getCadency() + " kadencji odbyl: " + abroads.biggestTraveler(sources.mps, tmp.getCadency()));
			System.out.println("najdluzej zagranic¹ z " + tmp.getCadency() + " kadencji byl: " + abroads.longestAbroad(sources.mps, tmp.getCadency()));
			System.out.println("najdrozsza podró¿ zagraniczn¹ z poslow " + tmp.getCadency() + " kadencji odby³: " + abroads.mostExpensiveSingleTravel(sources.mps, tmp.getCadency()));
			System.out.println("W³ochy w " + tmp.getCadency() + " odwiedzili: ");
			for (Mp mp : abroads.mpsThatVisitedItaly(sources.mps, tmp.getCadency()))
				System.out.print(mp.getData().getFirstName() + " " + mp.getData().getLastName() + ",");
			
		break;
		
		case "update" :
			this.sources.updateMpSet();
		break;
		
		default :
		throw new IllegalArgumentException("argument error");
		}
		
	}
	
}
