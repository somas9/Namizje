/*
	Ime datoteke:		Datoteka.java
	Avtor:				Samo Špacapan
*/

//Deklariramo javni razred
public class Datoteka implements LastnostiDatoteke{
	
	//Deklariramo zasebne lastnosti razreda datoteka
	private String ime;
	private String tip;
	private double velikost;
	
	//Javni konstruktor
	public Datoteka(){
		ime = "/";
		tip = "";
		velikost = 0;
	}
	
	//Javni konstruktor z vsemi parametri
	public Datoteka(String i, String t, double v){
		ime = i;
		tip = t;
		velikost = v;
	}
	
	//Getters & setters
	public String getIme(){
		return ime;
	}
	
	public void setIme(String i){
		ime = i;
	}
	
	public String getTip(){
		return tip;
	}
	
	public void setTip(String t){
		tip = t;
	}
	
	public double getVelikost(){
		return velikost;
	}
	
	public void setVelikost(double v){
		velikost = v;
	}
	
	//Metoda, ki da vsem besedam v imenu veliko začetnico
	public void capitalise() throws Exception{
		if(ime == ""){
			//Vržemo izjemo za neuspešno polnjenje
			throw new Exception("Datoteka nima imena!");
		}
		
		//Celotno ime spremenimo v male črke
		ime = ime.toLowerCase();
		
		//Razdelimo po presledkih
		String[] besede = ime.split(" ");
		
		//Spraznimo ime
		ime = "";
		
		//Gremo čez vse besede
		for(String beseda : besede){
			
			//Posameznim besedam spremenimo prvo črko v veliko, vse ostale v male
			beseda = beseda.substring(0,1).toUpperCase() + beseda.substring(1);
			
			//Imenu dodajamo posamezne besede in presledke
			ime += beseda + " ";
		}
		
		//Odstranimo zadnji presledek
		ime = ime.substring(0, ime.length() - 1);
	}
	
	//Metoda, ki vrne nov objekt datoteke z identičnimi lastnostmi
	public Datoteka kopiraj(){
		return new Datoteka(ime, tip, velikost);
	}
	
	//Metoda, ki vrne vse informacije o datoteki
	public String info(){
		return "Datoteka: " + ime + tip + "\nVelikost: " + velikost + " bitov\n";
	}
}