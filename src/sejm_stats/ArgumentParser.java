package sejm_stats;

import java.util.LinkedList;

public class ArgumentParser {
	
	LinkedList<String> arguments = new LinkedList<>();
	public ArgumentParser(){
		arguments = null;
	}
	
	public void addArgument (String argument){
		this.arguments.add(argument);
		
	}
	public void Parse(){
		LinkedList<String> parsedArgs = new LinkedList<>();
		arguments = parsedArgs;
 	}
	
	
	
}
