package sejm_stats;

import java.util.LinkedList;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
public class Layers {
	@SerializedName("wydatki")
	private Expenses expenses;
	@SerializedName("wyjazdy")
	private JsonElement tmpTrips;	// json array jesli byly json object jesli nieby³o
	
	private LinkedList<Map<String,String>> trips;
	
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
	
	@SuppressWarnings("unchecked")
	public void loadTrips(){
		if (this.tmpTrips.isJsonObject())
			this.trips = new LinkedList<Map<String,String>>();
		else{
			//System.out.print(this.tmpTrips.toString());
			this.trips = new Gson().fromJson(this.tmpTrips, LinkedList.class);
		}
	}
	

}
