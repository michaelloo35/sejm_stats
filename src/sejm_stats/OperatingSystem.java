package sejm_stats;

import java.io.IOException;
import java.net.MalformedURLException;

public class OperatingSystem {

	public static void main(String[] args) throws MalformedURLException, IOException {
			
		StatsViewer main = new StatsViewer();
		main.setArgument1("info");
		main.setArgument2("Anna");
		main.setArgument3("Nemœ");
		main.setCadency(7);
		
		main.execute();
		/*ArgumentParser arguments = new ArgumentParser();
		for ( String arg : args){
			arguments.addArgument(arg);			
		}
		arguments.Parse();*/
	}

}
