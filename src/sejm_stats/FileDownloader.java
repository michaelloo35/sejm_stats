package sejm_stats;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;

public class FileDownloader {
	
	public MpSet mps;
	private boolean update;
	
	public FileDownloader(){
		this.update = false;
	}
	
    public void initializeMpSet() throws MalformedURLException, IOException{	// update as a flag there no need for writing separate method cause it'd look the same
    	File SDir = new File ("./Sources");							// creating directory for neccessery source files as Mp's list if doesn't exist yet
    	if(!SDir.exists())
    		SDir.mkdir();
   
    	URL src = new URL("https://api-v3.mojepanstwo.pl/dane/poslowie.json");	// first 50 envoys list and default data values
    	int i = 0; 
    	File mpList = new File("./Sources/MpList" + " " + i + ".json");
    	if(!mpList.exists() || this.update == true)
    		FileUtils.copyURLToFile(src, mpList);
    	Gson gson = new Gson();
    	this.mps = gson.fromJson(new FileReader(mpList), MpSet.class); // loads first 50 mps	
    	Links links = gson.fromJson(new FileReader(mpList), Links.class); // loads the links obj from json file
    	
    	MpSet tmp;
    	while(links.getLink("last") != null){		// loop for downloading all the envoys
    		i++;
    		src = new URL(links.getLink("next"));
        	mpList = new File("./Sources/MpList" + " " + i + ".json");
        	if (!mpList.exists() || this.update == true)
        		FileUtils.copyURLToFile(src, mpList);
        	tmp = gson.fromJson(new FileReader(mpList), MpSet.class);
        	links = gson.fromJson(new FileReader(mpList), Links.class);
        	this.mps.concatenate(tmp.getMpList());
    	}
    	this.fullfillMpSet();
    	System.out.print("");
    }
    
    private void fullfillMpSet()throws MalformedURLException, IOException{
    	File SDir = new File ("./Sources/Details");							// creating directory for detailed mp data
    	if(!SDir.exists())
    		SDir.mkdir();
    	Mp tmp;
    	for (Mp mp : this.mps.getMpList()){
    		URL src = new URL("https://api-v3.mojepanstwo.pl/dane/poslowie/" + mp.getId() + ".json?layers[]=wyjazdy&layers[]=wydatki");
    		File mpDetails = new File("./Sources/Details/" + mp.getId() + ".json");
    		if (!mpDetails.exists() || this.update == true)
    			FileUtils.copyURLToFile(src, mpDetails);
        	Gson gson = new Gson();
        	tmp = gson.fromJson(new FileReader(mpDetails), Mp.class);
        	mp.getData().loadCadencies();
        	mp.setLayers(tmp.getLayers());
        	mp.getLayers().loadTrips();
    	}
    }
    
    public void updateMpSet()throws MalformedURLException, IOException{		// updates the files
    	this.update = true;
    	this.initializeMpSet();
    	this.update = false;
    }
    
}