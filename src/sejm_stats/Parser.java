package sejm_stats;

import java.io.IOException;

public class Parser {

	private String argument1;
	private String argument2;
	private String argument3;
	private int cadency;
	public void parse(String[] args)throws IOException {
		
			
			if (args.length > 4 || args.length == 0)
				throw new IOException("nie poprawna liczba argument�w b�dz format argument�w jest niepoprawny podaj argumenty w nastepujacym formacie EBNF: \"info [imie nazwisko] 7|8\" | \"update\"");
			if (!args[0].equals("info") && !args[0].equals("update"))
				throw new IOException("program nie obsluguje takiego trybu b�dz format argument�w jest niepoprawny podaj argumenty w nastepujacym formacie EBNF: \"info [imie nazwisko] 7|8\" | \"update\"");
			if (args[0].equals("info") && args.length == 2 ){
				this.argument1 = "infobez";
				if(!args[1].equals("7") && !args[1].equals("8"))
					throw new IOException("niepoprawny numer kadencji podaj argumenty w nastepujacym formacie EBNF: \"info [imie nazwisko] 7|8\" | \"update\"");
				this.cadency = Integer.parseInt(args[1]);
			}
			else if(args.length == 4 && !args[0].equals("update")){
				if (!args[3].equals("7") && !args[3].equals("8"))
					throw new IOException ("niepoprawny numer kadencji podaj argumenty w nastepujacym formacie EBNF: \"info [imie nazwisko] 7|8\" | \"update\"");
			this.argument1 = args[0];
			this.argument2 = args[1];
			this.argument3 = args[2];
			this.cadency = Integer.parseInt(args[3]);
			}
			else if (args.length == 1)
				if (args[0].equals("update"))
					this.argument1 = args[0];
				else
					throw new IOException("nie poprawna liczba argument�w b�dz format argument�w jest niepoprawny podaj argumenty w nastepujacym formacie EBNF: \"info [imie nazwisko] 7|8\" | \"update\"");
			else
				throw new IOException ("cos poszlo nie tak przy parsowaniu argument�w podaj argumenty w nastepujacym formacie EBNF: \"info [imie nazwisko] 7|8\" | \"update\"");
		

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
