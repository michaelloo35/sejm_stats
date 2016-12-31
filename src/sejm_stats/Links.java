package sejm_stats;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class Links {

	@SerializedName("Links")
	private Map <String,String> Links;
	
	public void setLinks(String key, String value){
		this.Links.replace(key, value);
	}
	public String getLinks(String key){
		return this.Links.get(key);
	}
	
	
}
