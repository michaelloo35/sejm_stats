package sejm_stats;

import java.io.IOException;

import org.json.JSONException;

public class OperatingSystem {

	public static void main(String[] args) {
		
		try {
			System.out.println(JsonDownloader.readJsonFromUrl("https://api-v3.mojepanstwo.pl/dane/poslowie.json").toString());
		} catch (IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArgumentParser arguments = new ArgumentParser();
		for ( String arg : args){
			arguments.addArgument(arg);			
		}
		arguments.Parse();
	}

}
