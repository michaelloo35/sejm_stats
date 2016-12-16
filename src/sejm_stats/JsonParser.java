package sejm_stats;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {
	private JSONObject obj;
	
	public JsonParser(String url){
		try {
			this.obj = JsonDownloader.readJsonFromUrl(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	
}
