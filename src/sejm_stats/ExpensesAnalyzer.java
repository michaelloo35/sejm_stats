package sejm_stats;

public class ExpensesAnalyzer {

	public Double singleMpExpenses(String firstName,String lastName,MpSet mps){
		Double expenses = new Double(0);
		Mp myMp = null;
		for (Mp mp : mps.getMpList()){
			if (mp.getData().getFirstName().equals(firstName) && mp.getData().getLastName().equals(lastName))
				myMp = mp;
		}
		if (myMp == null)
			throw new IllegalArgumentException("nie ma takiego posla");
		
			for (Rocznik rok : myMp.getLayers().getExpenses().getRoczniki())
				for (Double expense : rok.getPola())
					expenses += expense;
		return expenses;
		};
	
	public Double singleMpOfficeExpenses(String firstName,String lastName,MpSet mps){
		Double expenses = new Double(0);
		Mp myMp = null;
		for (Mp mp : mps.getMpList()){
			if (mp.getData().getFirstName().equals(firstName) && mp.getData().getLastName().equals(lastName))
				myMp = mp;
		}
		if (myMp == null)
			throw new IllegalArgumentException("nie ma takiego posla");
		
			for (Rocznik rok : myMp.getLayers().getExpenses().getRoczniki()){
				int i = 0;
				for (Double expense : rok.getPola()){
					if (i == 12)
						expenses += expense;
					i++;					
				}
			}
		return expenses;
		};
	
	public Double averageMpExpenses(MpSet mps){
		Double expenses = new Double(0);
		int counter = 0;
		for (Mp mp : mps.getMpList()){
			counter++;
			for (Rocznik rok : mp.getLayers().getExpenses().getRoczniki())
				for (Double expense : rok.getPola())
					expenses += expense;
		}
		return expenses/counter;
		};
	
}
