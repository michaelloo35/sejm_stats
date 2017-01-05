package sejm_stats;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;

public class FileDownloader {
	
	
    public void initializeMpList() throws MalformedURLException, IOException{
    	File SDir = new File ("./Sources");							// creating directory for neccessery source files as Mp's list if doesn't exist yet
    	if(!SDir.exists())
    		SDir.mkdir();
    																// loop for downloading all the envoys
    	int i = 0;
    	
    	
    	URL src = new URL("https://api-v3.mojepanstwo.pl/dane/poslowie.json");	// first envoy and default data values
    	File mpList = new File("./Sources/MpList" + " " + i + ".json");
    	FileUtils.copyURLToFile(src, mpList);
    	Gson gson = new Gson();
    	MpSet mps = gson.fromJson(new FileReader(mpList), MpSet.class);
    	
    	MpSet tmp;
    	Links links = gson.fromJson(new FileReader(mpList), Links.class); // loads the links contained in json file
    	while(links.getLink("last") != null){
    		i++;
    		src = new URL(links.getLink("next"));
        	mpList = new File("./Sources/MpList" + " " + i + ".json");
        	FileUtils.copyURLToFile(src, mpList);
        	tmp = gson.fromJson(new FileReader(mpList), MpSet.class);
        	links = gson.fromJson(new FileReader(mpList), Links.class);
        	mps.concatenate(tmp.getMpList());
    	}
    	
    	int j = 1;
    	for (Mp mp : mps.getMpList()){
    		System.out.println(mp.getId() + " : " +mp.getData().getFirstName() + " " + mp.getData().getLastName() + " : " + j);
    		j++;
    	}
    	System.out.println(i);
    }
    public void updateFiles(){
    	
    }
}