package sejm_stats;

import java.util.LinkedList;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class Layers {
	@SerializedName("wydatki")
	private Expenses wydatki;
	@SerializedName("wyjazdy")
	private LinkedList<Map<String,String>> wyjazdy;
	
	public void setWydatki(Expenses wydatki){
		this.wydatki = wydatki;
	}
	public Expenses getRok(){
		return this.wydatki;
	}
	public void setWyjazdy(LinkedList<Map<String,String>> wyjazdy){
		this.wyjazdy = wyjazdy;
	}
	public LinkedList<Map<String,String>> getWyjazdy(){
		return this.wyjazdy;
	}

}
