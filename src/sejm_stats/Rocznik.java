package sejm_stats;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class Rocznik {
	@SerializedName("pola")
	Map<String,String> pola;
	@SerializedName("rok")
	String rok;
	
	public void setRok(String rok){
		this.rok = rok;
	}
	public String getRok(){
		return this.rok;
	}
	public void setPola(Map<String,String> pola){
		this.pola = pola;
	}
	public Map<String,String> getPola(){
		return this.pola;
	}
}
