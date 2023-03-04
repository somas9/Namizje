/*
	Ime datoteke:		Namizje.java
	Avtor:				Samo Špacapan
	Opis:				Aplikacija z grafičnim uporabniškim vmesnikom
	Vhodni podatki:		/
	Izhodni podatki:	Okno grafičnega uporabniškega vmesnika
*/

//Uvozimo pakete za delo z GUI
import javax.swing.*;

//Uvozimo paket za delo z dogodki
import java.awt.event.*;

//Deklariramo javni razred
public class Namizje extends JFrame implements ActionListener{
	
	//Deklariramo zasebne lastnosti
	private JPanel povrsina;
	private JButton dodajJButton;
	private JTextField imePolje, velikostPolje;
	private JComboBox<String> vrstaDatoteke;
	private JTextField tipPolje;
	private JTextField sirinaPolje;
	private JTextField dolzinaPolje;
	private JTextField trajanjePolje;
	private JTable tabela;
	private DatotekaTableModel modelTabele;
	
	
	//Deklariramo javno statično metodo, ki se izvede ob zagonu programa
	//Vhodni parametri: vhodni parametri iz konzole
	//Potek/opis: ustvari novo okno
	//Vrne vrednost: /
	public static void main(String[] args){
		
		Namizje n = new Namizje("Namizje z datotekami");
		
	}
	
	//Javni konstruktor
	//Vhodni parametri: ime - naslov okna
	//Potek/opis: vrne objekt tipa Namizje
	//Vrne vrednost: vrne objekt tipa Namizje
	public Namizje(String ime){
		
		//Kličemo konstruktor nadrazreda
		super(ime);
		
		//Inicializiramo lastnosti
		povrsina = new JPanel();
		dodajJButton = new JButton("Dodaj datoteko");
		imePolje = new JTextField(32);
		tipPolje = new JTextField(8);
		velikostPolje = new JTextField(8);
		sirinaPolje = new JTextField(4);
		dolzinaPolje = new JTextField(4);
		trajanjePolje = new JTextField(4);
		modelTabele = new DatotekaTableModel();
		tabela = new JTable(modelTabele);
		String[] vrsteDatotek = {"Datoteka", "Slikovna Datoteka", "Video Datoteka"};
		vrstaDatoteke = new JComboBox<>(vrsteDatotek);
		
		//Površino dodamo na namizje
		add(povrsina);
		
		//Gumbu za dodajanje dodamo action listener
		dodajJButton.addActionListener(this);
		
		//Dodamo gumb, vnosna polja, combo box in tabelo na površino
		povrsina.add(new JLabel("Vrsta datoteke:"));
		povrsina.add(vrstaDatoteke);
		povrsina.add(new JLabel("Ime:"));
		povrsina.add(imePolje);
		povrsina.add(new JLabel("Tip:"));
		povrsina.add(tipPolje);
		povrsina.add(new JLabel("Velikost:"));
		povrsina.add(velikostPolje);
		povrsina.add(new JLabel("Sirina:"));
		povrsina.add(sirinaPolje);
		povrsina.add(new JLabel("Dolžina:"));
		povrsina.add(dolzinaPolje);
		povrsina.add(new JLabel("Trajanje:"));
		povrsina.add(trajanjePolje);
		povrsina.add(dodajJButton);
		povrsina.add(tabela);
		
		//Pokažemo okno
		setVisible(true);
		
		//Nastavimo velikost
		setSize(800, 600);
		
		//Nastavimo obnašanje križca (x) - da koča aplikacijo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		System.out.println("Ustvarjam objekt Namizje");
	}
	
	//Metoda, ki jo predpisuje vmesnik ActionListener
	//Vhodni parametri: ae - dogodek
	//Potek/opis: doda datoteko na seznam - v tabelo
	//Vrne vrednost: /
	public void actionPerformed(ActionEvent ae){
		
		System.out.println("Dodajam datoteko ...");
		
		//Spremenljivki za lastnosti, ki se uporabijo v vsakem primeru
		String i = imePolje.getText();
		double v = Double.parseDouble(velikostPolje.getText());
		
		//Switch stavek za določitev izbrane vrste datoteke, v vsakem primeru ustvarimo nov objekt datoteke in ga dodamo v seznam
		switch(vrstaDatoteke.getSelectedItem().toString()){
			case "Datoteka":{
				Datoteka nova = new Datoteka(i, tipPolje.getText(), v);
				//Dodamo objekt v seznam
				modelTabele.addDatoteka(nova);
				break;
			}
			case "Slikovna Datoteka":{
				SlikovnaDatoteka nova = new SlikovnaDatoteka(i, v, Integer.parseInt(sirinaPolje.getText()), Integer.parseInt(dolzinaPolje.getText()));
				modelTabele.addSlikovnaDatoteka(nova);
				break;
			}
			case "Video Datoteka":{
				VideoDatoteka nova = new VideoDatoteka(i, v, Integer.parseInt(trajanjePolje.getText()));
				modelTabele.addVideoDatoteka(nova);
				break;
			}
			default:{
				break;
			}
		}
	}
	
}