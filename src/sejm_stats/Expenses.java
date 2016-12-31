package sejm_stats;

import java.util.LinkedList;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class Expenses {
	@SerializedName("punkty")
	private LinkedList<Map<String,String>> punkty;
	@SerializedName("roczniki")
	private LinkedList<Rocznik> roczniki;
	
	public void setPunkty(LinkedList<Map<String,String>> punkty){
		this.punkty = punkty;
	}
	public LinkedList<Map<String,String>> getPunkty(){
		return this.punkty;
	}
	
	public void setRoczniki(LinkedList<Rocznik> roczniki){
		this.roczniki = roczniki;
	}
	public LinkedList<Rocznik> getRoczniki(){
		return this.roczniki;
	}
}
