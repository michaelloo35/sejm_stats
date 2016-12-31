package sejm_stats;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class Data {
	@SerializedName("ludzie.nazwa")
	private String ludzie_nazwa;
	@SerializedName("poslowie.kadencja")
	private Map<String,String> kadencje; // spr. pola mapy mo¿e byæ 1 lub 2 np [(0,7),(1,8)](klucz,wartosc)
	
	public void setLudzie_nazwa(String ludzie_nazwa){
		this.ludzie_nazwa = ludzie_nazwa;
	}
	public String getLudzie_nazwa(){
		return this.ludzie_nazwa;
	}
	
	public void setKadencje(Map<String,String> kadencje){
		this.kadencje = kadencje;
	}
	public Map<String,String> getKadencje(){
		return this.kadencje;
	}
	
}
