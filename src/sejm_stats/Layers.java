package sejm_stats;

import java.util.LinkedList;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class Layers {
	@SerializedName("wydatki")
	private Expenses expenses;
	@SerializedName("wyjazdy")
	private LinkedList<Map<String,String>> trips;	// null jesli nie bylo zadnych wyjazdow
	
	public void setExpenses(Expenses expenses){
		this.expenses = expenses;
	}
	public Expenses getExpenses(){
		return this.expenses;
	}
	public void setTrips(LinkedList<Map<String,String>> trips){
		this.trips = trips;
	}
	public LinkedList<Map<String,String>> getTrips(){
		return this.trips;
	}

}
