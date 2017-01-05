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
	
}
