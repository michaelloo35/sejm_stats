package sejm_stats;

import java.io.IOException;

public class Parser {

	private String argument1;
	private String argument2;
	private String argument3;
	private int cadency;
	public void parse(String[] args) {
		try {
			if (args.length > 4 || args.length == 0)
				throw new IOException("nie poprawna liczba argumentów b¹dz format argumentów jest niepoprawny podaj argumenty w nastepujacym formacie EBNF: info|update [imie nazwisko] 7|8");
			if (!args[0].equals("info") && !args[0].equals("update"))
				throw new IOException("program nie obsluguje takiego trybu b¹dz format argumentów jest niepoprawny podaj argumenty w nastepujacym formacie EBNF: info|update [imie nazwisko] 7|8");
			if (args[0].equals("info") && args.length == 2 ){
				this.argument1 = "infobez";
				this.cadency = Integer.parseInt(args[1]);
			}
			else if(args.length == 4){
			this.argument1 = args[0];
			this.argument2 = args[1];
			this.argument3 = args[2];
			this.cadency = Integer.parseInt(args[3]);
			}
			else
				throw new IOException ("cos poszlo nie tak przy parsowaniu argumentów podaj argumenty w nastepujacym formacie EBNF: info|update [imie nazwisko] 7|8");
		} catch (IOException e) {
			System.out.println(e);
		}

	}
	public String getArgument1() {
		return argument1;
	}
	public void setArgument1(String argument1) {
		this.argument1 = argument1;
	}
	public String getArgument2() {
		return argument2;
	}
	public void setArgument2(String argument2) {
		this.argument2 = argument2;
	}
	public String getArgument3() {
		return argument3;
	}
	public void setArgument3(String argument3) {
		this.argument3 = argument3;
	}
	public int getCadency() {
		return cadency;
	}
	public void setCadency(int cadency) {
		this.cadency = cadency;
	}

}

// rozne klasy zwracajace pliki w odpowiednich strukturach
