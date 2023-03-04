/*
	Ime datoteke:		DatotekaTableModel.java
	Avtor:				Samo Špacapan
*/
import javax.swing.table.*;

public class DatotekaTableModel extends DefaultTableModel{
	//Konstruktor
	public DatotekaTableModel(){
		
		//Kliče konstruktor nadrazreda
		super();
		
		//V tabelo dodamo stolpce
		addColumn("Datoteka");
		addColumn("Velikost (b)");
		addColumn("Dolžina");
		addColumn("Širina");
		addColumn("Trajanje");
		
		//Dodamo naslovno vrstico
		//Ustvarimo statičen seznam objektov
		Object[] vrstica = new Object[] {"Datoteka", "Velikost (b)", "Dolžina (px)", "Širina (px)", "Trajanje"};
	
		//Dodamo vrstico v tabelo
		addRow(vrstica);
	}
	
	//Vhodni parametri: d - Datoteka
	//Potek/opis: Metoda, ki doda datoteko na seznam in v tabelo
	//Vrne vrednost: /
	public void addDatoteka(Datoteka d){
		
		//Ustvarimo statičen seznam objektov
		Object[] vrstica = new Object[] {d.getIme() + d.getTip(), d.getVelikost(), "-", "-", "-"};
	
		//Dodamo vrstico v tabelo
		addRow(vrstica);
	}
	
	//Vhodni parametri: sd - SlikovnaDatoteka
	//Potek/opis: Metoda, ki doda slikovno datoteko na seznam in v tabelo
	//Vrne vrednost: /
	public void addSlikovnaDatoteka(SlikovnaDatoteka sd){
		
		//Ustvarimo statičen seznam objektov
		Object[] vrstica = new Object[] {sd.getIme() + sd.getTip(), sd.getVelikost(), sd.getDolzina(), sd.getSirina(), "-"};
	
		//Dodamo vrstico v tabelo
		addRow(vrstica);
	}
	
	//Vhodni parametri: vd - VideoDatoteka
	//Potek/opis: Metoda, ki doda video datoteko na seznam in v tabelo
	//Vrne vrednost: /
	public void addVideoDatoteka(VideoDatoteka vd){
		
		//Ustvarimo statičen seznam objektov
		Object[] vrstica = new Object[] {vd.getIme() + vd.getTip(), vd.getVelikost(), "-", "-", vd.berljivoTrajanje()};
	
		//Dodamo vrstico v tabelo
		addRow(vrstica);
	}
}