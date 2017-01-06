package sejm_stats;

import java.util.LinkedList;

import com.google.gson.annotations.SerializedName;

public class Data {
	@SerializedName("poslowie.imie_pierwsze")
	private String firstName;
	@SerializedName("poslowie.kadencja")
	private LinkedList<String> kadencje; // lista kadencji
	@SerializedName("poslowie.nazwisko")
	private String lastName;
	
	private boolean cadency7 = false;
	private boolean cadency8 = false;
	
	public boolean isCadency7() {
		return cadency7;
	}
	public void setCadency7(boolean cadency7) {
		this.cadency7 = cadency7;
	}
	public boolean isCadency8() {
		return cadency8;
	}
	public void setCadency8(boolean cadency8) {
		this.cadency8 = cadency8;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public String getFirstName(){
		return this.firstName;
	}
	public void setKadencje(LinkedList<String> kadencje){
		this.kadencje = kadencje;
	}
	public LinkedList<String> getKadencje(){
		return this.kadencje;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public String getLastName(){
		return this.lastName;
	}
	
	public void loadCadencies(){
		for (String cadency : this.kadencje){
			if (cadency.equals("7"))
				this.cadency7 = true;
			if (cadency.equals("8"))
				this.cadency8 = true;
		}
		
	}
	
}
