package sejm_stats;

public class StatsViewer {
	private String argument;
	
	public String getArg(){
		return argument;
	}
	public void setArg(String newArg){
		argument = newArg;
	}
	
	public void exec(){
		switch(this.argument){
		case "suma wydatków pos³a/pos³anki o okreœlonym imieniu i nazwisku" :
		break;
		
		case "wysokoœci wydatków na 'drobne naprawy i remonty biura poselskiego' okreœlonego pos³a/pos³anki" :
		break;
		
		case "œredniej wartoœci sumy wydatków wszystkich pos³ów" :
		break;
		
		case "pos³a/pos³anki, który wykona³ najwiêcej podró¿y zagranicznych" :
		break;
		
		case "pos³a/pos³anki, który najd³u¿ej przebywa³ za granic¹" :
		break;
		
		case "pos³a/pos³anki, który odby³ najdro¿sz¹ podró¿ zagraniczn¹" :
		break;
		
		case "listê wszystkich pos³ów, którzy odwiedzili W³ochy" :
		break;
		
		default :
		throw new IllegalArgumentException("argument error");
		}
		
	}
	
}
