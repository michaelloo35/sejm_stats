package sejm_stats;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Parser {
	
	private JsonObject obj;
	

	public static JsonObject convertFileToJSON (String fileName){

        // Read from File to String
        JsonObject jsonObject = new JsonObject();
        
        try {
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(new FileReader(fileName));
            jsonObject = jsonElement.getAsJsonObject();
        } catch (FileNotFoundException e) {
           
        } catch (IOException ioe){
        
        }
        
        
        return jsonObject;
    }

}
	
	
	
	// rozne klasy zwracajace pliki w odpowiednich strukturach
	
}
