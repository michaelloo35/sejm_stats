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
		case "suma wydatk�w pos�a/pos�anki o okre�lonym imieniu i nazwisku" :
		break;
		
		case "wysoko�ci wydatk�w na 'drobne naprawy i remonty biura poselskiego' okre�lonego pos�a/pos�anki" :
		break;
		
		case "�redniej warto�ci sumy wydatk�w wszystkich pos��w" :
		break;
		
		case "pos�a/pos�anki, kt�ry wykona� najwi�cej podr�y zagranicznych" :
		break;
		
		case "pos�a/pos�anki, kt�ry najd�u�ej przebywa� za granic�" :
		break;
		
		case "pos�a/pos�anki, kt�ry odby� najdro�sz� podr� zagraniczn�" :
		break;
		
		case "list� wszystkich pos��w, kt�rzy odwiedzili W�ochy" :
		break;
		
		default :
		throw new IllegalArgumentException("argument error");
		}
		
	}
	
}
