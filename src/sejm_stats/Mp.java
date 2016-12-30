package sejm_stats;

import java.util.LinkedList;

import com.google.gson.annotations.SerializedName;

public class Mp {
	@SerializedName("id")
	private String id;
	@SerializedName("ludzie.nazwa")
	private String ludzie_nazwa;
	@SerializedName("poslowie.kadencja")
	LinkedList<String> kadencje;	
	@SerializedName("wyjazdy")
	LinkedList<Trip> wyjazdy;
	public String getId(){
		return this.id;
	}
}
