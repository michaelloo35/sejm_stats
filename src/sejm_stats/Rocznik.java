package sejm_stats;

import java.util.LinkedList;

import com.google.gson.annotations.SerializedName;

public class Rocznik {
	@SerializedName("pola")
	private LinkedList<Double> pola;
	@SerializedName("rok")
	private String rok;
	
	public void setRok(String rok){
		this.rok = rok;
	}
	public String getRok(){
		return this.rok;
	}
	public void setPola(LinkedList<Double> pola){
		this.pola = pola;
	}
	public LinkedList<Double> getPola(){
		return this.pola;
	}
}
