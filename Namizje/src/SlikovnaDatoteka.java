/*
	Ime datoteke:		SlikovnaDatoteka.java
	Avtor:				Samo Špacapan
*/
public class SlikovnaDatoteka extends Datoteka implements LastnostiDatoteke{
	
	//Nove lastnosti
	private int sirina;
	private int dolzina;
	
	//Privzeti konstruktor
	public SlikovnaDatoteka(){
		super();
		sirina = 0;
		dolzina = 0;
	}
	
	//Konstruktor z vsemi parametri, tip datoteke se samodejno nastavi na ".png"
	public SlikovnaDatoteka(String i, double v, int s, int d){
		super(i, ".png", v);
		sirina = s;
		dolzina = d;
	}
	
	//Getters & setters
	public int getSirina(){
		return sirina;
	}
	
	public void setSirina(int s){
		sirina = s;
	}
	
	public int getDolzina(){
		return dolzina;
	}
	
	public void setDolzina(int d){
		dolzina = d;
	}
	
	//Spremeni sirino glede na podan int, odšteje enako vrednost od dolžina, da ohrani razmerje med širino in dolžino
	public void spremeniSirinoInOhraniRazmerje(int novaSirina) throws Exception{
		int razlika = sirina - novaSirina;
		
		if(sirina-razlika <= 0 || dolzina-razlika <= 0){
			throw new Exception("Neustrezna nova sirina - sirina ali visina bosta nic ali manj!");
		}
		
		sirina = novaSirina;
		dolzina-= razlika;
	}
	
	//Izpis vseh lastnosti
	public String info(){
		
		//Kličem super.info(), da dobim lastnosti od nadrazreda, ker so nastavlene na "private"
		return super.info() + "Sirina: " + sirina + "px\nDolzina: " + dolzina + "px\n";
	}
}