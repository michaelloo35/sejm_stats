package sejm_stats;

import java.io.IOException;
import java.net.MalformedURLException;
import java.lang.IllegalArgumentException;
public class OperatingSystem {	// podaj argumenty w nastepujacym formacie EBNF: "info [imie nazwisko] 7|8" | update

	public static void main(String[] args) throws MalformedURLException, IOException,IllegalArgumentException {
		
		try{	
		StatsViewer main = new StatsViewer();
		
		main.execute(args);
		}
		catch (IOException e) {
			System.out.println(e);
		}
		catch(com.google.gson.JsonSyntaxException e){
			System.out.println("Looks like a data files are corrupted please update first");
		}
		catch(IllegalArgumentException e){
			System.out.println(e);
		}
	}

}
