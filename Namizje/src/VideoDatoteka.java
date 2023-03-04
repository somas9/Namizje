/*
	Ime datoteke:		VideoDatoteka.java
	Avtor:				Samo Špacapan
*/
import java.util.ArrayList;

public class VideoDatoteka extends Datoteka implements LastnostiDatoteke{
	
	//Nove lastnosti
	private int trajanje;
	
	//Privzet konstruktor
	public VideoDatoteka(){
		super();
		trajanje = 0;
	}
	
	//Konstruktor z vsemi parametri, tip datoteke avtomatsko ".mp4"
	public VideoDatoteka(String i, double v, int t){
		super(i, ".mp4", v);
		trajanje = t;
	}
	
	public int getTrajanje(){
		return trajanje;
	}
	
	public void setTrajanje(int t){
		trajanje = t;
	}
	
	//Metoda, ki vrne človeku-prijazen izpis trajanja video datoteke (hh:mm:ss)
	public String berljivoTrajanje(){
		
		//ArrayList za stringe hour, minute, second
		ArrayList<String>hms = new ArrayList<String>();
		
		//String ki hrani izpis
		String izpis = "";
		
		//Začasna spremenljivka za izračune
		int temp = trajanje % 3600;
		
		//Izračunamo in dodamo število ur, minut in sekund v string obliki v arraylist
		hms.add(String.valueOf(trajanje / 3600));
		hms.add(String.valueOf(temp / 60));
		hms.add(String.valueOf(temp % 60));
		
		//Gremo čez arraylist
		for(String s : hms){
			
			//Če ima katerakoli eno ali manj cifro, dodamo pred njo "0", za ohranitev formata hh:mm:ss
			if(s.length() <= 1){
				s = "0" + s;
			}
			
			//Dodamo trenutno vrednost k izpisu
			izpis = izpis + s + ":";
		}
		
		//Odstranimo zadnjo dvopičje
		izpis = izpis.substring(0, izpis.length() - 1);
		
		//Vrnemo izpis
		return izpis;
	}
	
	//Izpis vseh lastnosti
	public String info(){
		
		//Kličem super.info(), da dobim lastnosti od nadrazreda, ker so nastavlene na "private"
		return super.info() + "Trajanje: " + this.berljivoTrajanje() + "\n";
	}
}