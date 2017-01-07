package sejm_stats;

public class ExpensesAnalyzer {

	public Double singleMpExpenses(String firstName,String lastName,MpSet mps,int cadency){ 	//suma wydatków pos³a/pos³anki o okreœlonym imieniu i nazwisku
		
		boolean is7thCadency = false;
		if(cadency != 7 && cadency != 8)
			throw new IllegalArgumentException("nie obsluguje takiej kadencji");
		else if (cadency == 7)
			is7thCadency = true;
																// at this point if cadency == 7 then it's true if cadency == 8 then it's false otherwise illegal argument exception
		Double expenses = new Double(0);
		Mp myMp = null;
		for (Mp mp : mps.getMpList()){
			if (mp.getData().getFirstName().equals(firstName) 
					&& mp.getData().getLastName().equals(lastName) 
					&& (mp.getData().isCadency7() == is7thCadency || mp.getData().isCadency8() == !is7thCadency))
				myMp = mp;
		}
		if (myMp == null)
			throw new IllegalArgumentException("nie ma takiego posla w danej kadencji");
		
			for (Rocznik rok : myMp.getLayers().getExpenses().getRoczniki())
				for (Double expense : rok.getPola())
					expenses += expense;
		return expenses;
		};
	
	public Double singleMpOfficeExpenses(String firstName,String lastName,MpSet mps,int cadency){			//wysokoœci wydatków na 'drobne naprawy i remonty biura poselskiego' okreœlonego pos³a/pos³anki
		boolean is7thCadency = false;
		if(cadency != 7 && cadency != 8)
			throw new IllegalArgumentException("nie obsluguje takiej kadencji");
		else if (cadency == 7)
			is7thCadency = true;
		Double expenses = new Double(0);
		Mp myMp = null;
		for (Mp mp : mps.getMpList()){
			if (mp.getData().getFirstName().equals(firstName) 
					&& mp.getData().getLastName().equals(lastName)
					&& (mp.getData().isCadency7() == is7thCadency || mp.getData().isCadency8() == !is7thCadency))
				myMp = mp;
		}
		if (myMp == null)
			throw new IllegalArgumentException("nie ma takiego posla w danej kadencji");
		
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
	
	public Double averageMpExpenses(MpSet mps,int cadency){				// œredniej wartoœci sumy wydatków wszystkich pos³ów
		boolean is7thCadency = false;
		if(cadency != 7 && cadency != 8)
			throw new IllegalArgumentException("nie obsluguje takiej kadencji");
		else if (cadency == 7)
			is7thCadency = true;
		Double expenses = new Double(0);
		int counter = 0;
		for (Mp mp : mps.getMpList())
			if((mp.getData().isCadency7() == is7thCadency || mp.getData().isCadency8() == !is7thCadency)){
				counter++;
				for (Rocznik rok : mp.getLayers().getExpenses().getRoczniki())
					for (Double expense : rok.getPola())
						expenses += expense;
			}
		return expenses/counter;
	};

}
