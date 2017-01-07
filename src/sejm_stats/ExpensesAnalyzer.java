package sejm_stats;

public class ExpensesAnalyzer {

	public Double singleMpExpenses(String firstName,String lastName,MpSet mps,int cadency){ 	//suma wydatk�w pos�a/pos�anki o okre�lonym imieniu i nazwisku
		
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
	
	public Double singleMpOfficeExpenses(String firstName,String lastName,MpSet mps,int cadency){			//wysoko�ci wydatk�w na 'drobne naprawy i remonty biura poselskiego' okre�lonego pos�a/pos�anki
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
	
	public Double averageMpExpenses(MpSet mps,int cadency){				// �redniej warto�ci sumy wydatk�w wszystkich pos��w
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
