package sejm_stats;

import java.util.LinkedList;
import java.util.Map;

public class AbroadsAnalyzer {

	public String biggestTraveler (MpSet mps,int cadency){ //pos³a/pos³anki, który wykona³ najwiêcej podró¿y zagranicznych
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
		return ("najwiêcej podró¿y zagranicznych : " + myMp.getData().getFirstName() + " " + myMp.getData().getLastName());

	};
	
	public String longestAbroad(MpSet mps,int cadency) {	//pos³a/pos³anki, który najd³u¿ej przebywa³ za granic¹
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
		return ("najd³u¿ej zagranic¹ : " + myMp.getData().getFirstName() + " " + myMp.getData().getLastName());
		
	};
	
	public String mostExpensiveSingleTravel (MpSet mps,int cadency){			// pos³a/pos³anki, który odby³ najdro¿sz¹ podró¿ zagraniczn¹
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
		return ("najdrozsza podró¿ odby³ : " + myMp.getData().getFirstName() + " " + myMp.getData().getLastName() + "jej koszt to : " + expenseMaxCounter.toString());
		
	}
	public LinkedList<Mp> mpsThatVisited (String country,MpSet mps,int cadency){ // listê wszystkich pos³ów, którzy odwiedzili kraj w³ochy
		boolean is7thCadency = false;
		if(cadency != 7 || cadency != 8)
			throw new IllegalArgumentException("nie obsluguje takiej kadencji");
		else if (cadency == 7)
			is7thCadency = true;
		LinkedList<Mp> myMps = new LinkedList<>();
		country = "W³ochy";
		for (Mp mp : mps.getMpList())
			if((mp.getData().isCadency7() == is7thCadency || mp.getData().isCadency8() == !is7thCadency)){
				for(Map<String,String> trip : mp.getLayers().getTrips())
					if (trip.get("kraj").equals(country)){
						myMps.add(mp);
						break;
					}
				}
		if (myMps.isEmpty())
			throw new IllegalArgumentException("nikt w podanej kadencji nie wyjechal do w³och");
		return myMps;	
	}
	
	
}
