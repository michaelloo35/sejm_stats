package sejm_stats;

import java.util.LinkedList;
import java.util.Map;

public class AbroadsAnalyzer {

	public String biggestTraveler (MpSet mps,int cadency){ //pos�a/pos�anki, kt�ry wykona� najwi�cej podr�y zagranicznych
		boolean is7thCadency = false;
		if(cadency != 7 || cadency != 8)
			throw new IllegalArgumentException("nie obsluguje takiej kadencji");
		else if (cadency == 7)
			is7thCadency = true;
		
		int tripsCounter = 0;
		int tripsMaxCounter = 0;
		Mp myMp = null;
		
		for (Mp mp : mps.getMpList()){
			if((mp.getData().isCadency7() == is7thCadency || mp.getData().isCadency8() == !is7thCadency)){
				for(Map<String,String> trip : mp.getLayers().getTrips())
					if (!trip.get("country_code").equals("PL"))
						tripsCounter++;
			
				if (tripsCounter >= tripsMaxCounter ){
					myMp = mp;
					tripsMaxCounter = tripsCounter;
				}
				tripsCounter = 0;
			}
		}
		return ("najwi�cej podr�y zagranicznych : " + myMp.getData().getFirstName() + " " + myMp.getData().getLastName());

	};
	
	public String longestAbroad(MpSet mps,int cadency) {	//pos�a/pos�anki, kt�ry najd�u�ej przebywa� za granic�
		boolean is7thCadency = false;
		if(cadency != 7 || cadency != 8)
			throw new IllegalArgumentException("nie obsluguje takiej kadencji");
		else if (cadency == 7)
			is7thCadency = true;
		
		int daysCounter = 0;
		int daysMaxCounter = 0;
		Mp myMp = mps.getMpList().getFirst();
		
		for (Mp mp : mps.getMpList())
			if((mp.getData().isCadency7() == is7thCadency || mp.getData().isCadency8() == !is7thCadency)){
				for(Map<String,String> trip : mp.getLayers().getTrips())
					if (!trip.get("country_code").equals("PL"))
						daysCounter += Integer.parseInt(trip.get("liczba_dni"));
			
				if (daysCounter >= daysMaxCounter){
					myMp = mp;
					daysMaxCounter = daysCounter;
				}
				daysCounter = 0;
			}
		return ("najd�u�ej zagranic� : " + myMp.getData().getFirstName() + " " + myMp.getData().getLastName());
		
	};
	
	public String mostExpensiveSingleTravel (MpSet mps,int cadency){			// pos�a/pos�anki, kt�ry odby� najdro�sz� podr� zagraniczn�
		boolean is7thCadency = false;
		if(cadency != 7 || cadency != 8)
			throw new IllegalArgumentException("nie obsluguje takiej kadencji");
		else if (cadency == 7)
			is7thCadency = true;
		Double expenseCounter = new Double(0);
		Double expenseMaxCounter = new Double(0);
		Mp myMp = mps.getMpList().getFirst();
		
		for (Mp mp : mps.getMpList())
			if((mp.getData().isCadency7() == is7thCadency || mp.getData().isCadency8() == !is7thCadency)){
				for(Map<String,String> trip : mp.getLayers().getTrips())
					if (!trip.get("country_code").equals("PL")){
						expenseCounter = Double.parseDouble(trip.get("koszt_suma"));
						if (expenseCounter >= expenseMaxCounter ){
							myMp = mp;
							expenseMaxCounter = expenseCounter;
							expenseCounter = 0.0;
						}
					}
			}
		return ("najdrozsza podr� odby� : " + myMp.getData().getFirstName() + " " + myMp.getData().getLastName() + "jej koszt to : " + expenseMaxCounter.toString());
		
	}
	public LinkedList<Mp> mpsThatVisited (String country,MpSet mps,int cadency){ // list� wszystkich pos��w, kt�rzy odwiedzili kraj w�ochy
		boolean is7thCadency = false;
		if(cadency != 7 || cadency != 8)
			throw new IllegalArgumentException("nie obsluguje takiej kadencji");
		else if (cadency == 7)
			is7thCadency = true;
		LinkedList<Mp> myMps = new LinkedList<>();
		country = "W�ochy";
		for (Mp mp : mps.getMpList())
			if((mp.getData().isCadency7() == is7thCadency || mp.getData().isCadency8() == !is7thCadency)){
				for(Map<String,String> trip : mp.getLayers().getTrips())
					if (trip.get("kraj").equals(country)){
						myMps.add(mp);
						break;
					}
				}
		if (myMps.isEmpty())
			throw new IllegalArgumentException("nikt w podanej kadencji nie wyjechal do w�och");
		return myMps;	
	}
	
	
}
