package sejm_stats;

import java.util.LinkedList;

import com.google.gson.annotations.SerializedName;

public class Rocznik {
	@SerializedName("pola")
	private LinkedList<String> pola;
	@SerializedName("rok")
	private String rok;
	
	public void setRok(String rok){
		this.rok = rok;
	}
	public String getRok(){
		return this.rok;
	}
	public void setPola(LinkedList<String> pola){
		this.pola = pola;
	}
	public LinkedList<String> getPola(){
		return this.pola;
	}
}
