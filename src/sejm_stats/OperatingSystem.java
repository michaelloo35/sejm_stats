package sejm_stats;

import java.io.IOException;
import java.net.MalformedURLException;

public class OperatingSystem {	// podaj argumenty w nastepujacym formacie EBNF: info|update [imie nazwisko] 7|8

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		try{	
		String[] arg = new String[]{"info","Ewa"};
		StatsViewer main = new StatsViewer();
		
		main.execute(arg);
		}
		catch (IOException e) {
			System.out.println(e);
		}
		catch(com.google.gson.JsonSyntaxException e){
			System.out.println("Looks like a data files are corrupted please update first");
		}
	}

}
