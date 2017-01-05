package sejm_stats;

import java.util.LinkedList;

import com.google.gson.annotations.SerializedName;

public class MpSet {
	
	@SerializedName("Dataobject")
	public LinkedList<Mp> mplist;
	
	public LinkedList<Mp> getMpList(){
		return this.mplist;
	}
	public void setMpList(LinkedList<Mp> mplist){
		this.mplist = mplist;
	}
	
	public void concatenate(LinkedList<Mp> tmp){
		this.mplist.addAll(tmp);
	}
}
