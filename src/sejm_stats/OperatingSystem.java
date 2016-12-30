package sejm_stats;

import java.io.IOException;
import java.net.MalformedURLException;

public class OperatingSystem {

	public static void main(String[] args) throws MalformedURLException, IOException {
			
		FileDownloader Initiate = new FileDownloader();
		Initiate.initializeMpList();
		
		/*ArgumentParser arguments = new ArgumentParser();
		for ( String arg : args){
			arguments.addArgument(arg);			
		}
		arguments.Parse();*/
	}

}
