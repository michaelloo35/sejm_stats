package sejm_stats;

import java.io.IOException;
import java.net.MalformedURLException;

public class StatsViewer {
	private String argument1;
	private String argument2;
	private String argument3;
	private int cadency;
	private FileDownloader sources;
	StatsViewer () throws MalformedURLException, IOException{
		this.sources = new FileDownloader();
		this.sources.initializeMpSet();
	}
	

	public void execute() throws MalformedURLException, IOException{
		switch(this.argument1){
		case "info" :
			ExpensesAnalyzer expenses = new ExpensesAnalyzer();
			System.out.println("suma wydatków " + argument2 + " " + argument3 + " sprawuj¹cego/sprawuj¹cej mandat w " + cadency + " kadencji: " + expenses.singleMpExpenses(argument2, argument3, sources.mps, cadency));
			System.out.println("suma wydatków na drobne naprawy i remonty biura poselskiego " + argument2 + " " + argument3 + " sprawuj¹cego/sprawuj¹cej mandat w " + cadency + " kadencji: " + expenses.singleMpOfficeExpenses(argument2, argument3, sources.mps, cadency));
			System.out.println("srednia wydatkow z " + cadency + " kadencji: " + expenses.averageMpExpenses(sources.mps, cadency));
			AbroadsAnalyzer abroads = new AbroadsAnalyzer();
			System.out.println("najwiecej podrozy zagranicznych z " + cadency + " kadencji odbyl: " + abroads.biggestTraveler(sources.mps, cadency));
			System.out.println("najdluzej zagranic¹ z " + cadency + " kadencji byl: " + abroads.longestAbroad(sources.mps, cadency));
			System.out.println("najdrozsza podró¿ zagraniczn¹ z poslow " + cadency + " kadencji odby³: " + abroads.mostExpensiveSingleTravel(sources.mps, cadency));
			System.out.println("W³ochy w " + cadency + " odwiedzili: ");
			for (Mp mp : abroads.mpsThatVisitedItaly(sources.mps, cadency))
				System.out.print(mp.getData().getFirstName() + " " + mp.getData().getLastName() + ",");
			
		break;
		
		case "update" :
			this.sources.updateMpSet();
		break;
		
		default :
		throw new IllegalArgumentException("argument error");
		}
		
	}
	public String getArg(){
		return argument1;
	}
	public void setArg(String newArg){
		argument1 = newArg;
	}
	
	public String getArgument1() {
		return argument1;
	}

	public void setArgument1(String argument1) {
		this.argument1 = argument1;
	}

	public String getArgument2() {
		return argument2;
	}

	public void setArgument2(String argument2) {
		this.argument2 = argument2;
	}

	public String getArgument3() {
		return argument3;
	}

	public void setArgument3(String argument3) {
		this.argument3 = argument3;
	}

	public int getCadency() {
		return cadency;
	}

	public void setCadency(int cadency) {
		this.cadency = cadency;
	}

	
}
