package sejm_stats;

import java.util.Map;

public class Links {
	
	private Map <String,String> Links;
	
	public void setValue(String key, String value){
		this.Links.replace(key, value);
	}
	public String getValue(String key){
		return this.Links.get(key);
	}
	
	
}
