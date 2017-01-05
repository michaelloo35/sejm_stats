package sejm_stats;

import com.google.gson.annotations.SerializedName;

public class Mp {
	@SerializedName("data")
	private Data data;
	@SerializedName("id")
	private String id;
	@SerializedName("layers")
	private Layers layers;
	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
	
	public Data getData(){
		return this.data;
	}
	public void setData(Data data){
		this.data = data;
	}
	
	public Layers getLayers(){
		return this.layers;
	}
	public void setLayers(Layers layers){
		this.layers = layers;
	}
}
