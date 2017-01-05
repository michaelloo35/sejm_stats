package sejm_stats;

import java.util.LinkedList;

import com.google.gson.annotations.SerializedName;

public class MpSet {
	
	@SerializedName("Dataobject")
	private LinkedList<Mp> mpList;
	
	public LinkedList<Mp> getMpList(){
		return this.mpList;
	}
	public void setMpList(LinkedList<Mp> mpList){
		this.mpList = mpList;
	}
	
	public void concatenate(LinkedList<Mp> tmp){
		this.mpList.addAll(tmp);
	}
}
