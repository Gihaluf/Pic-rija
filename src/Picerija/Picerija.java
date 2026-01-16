package Picerija;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Picerija {
/*
 Izveidot, ka var pasūtīt picas un uzkodas, kā arī dzērienus
 	Picas lielums
 	Piedevas
 	Mērces
 Apskatīt aktīvos / pabeigtos pasūtījumus
 Aprēķināt cenu
 Piegādes cena
 Saglabāt / nolasīt pasūtījumu vēsturi
 Izmantot OOP principus
 Uzglabāt adresi, tālruni, vādu personai
 */
	public static int skaitlaParbaude(String zinojums, double min, double max, String noklusejums) {
		String ievade;
		int skaitlis;
		while(true) {
			ievade = (String)JOptionPane.showInputDialog(null, zinojums, 
					"Datu ievade", JOptionPane.INFORMATION_MESSAGE, null, null, noklusejums); 
			if(ievade == null)
				return -1;
			try {
				skaitlis = Integer.parseInt(ievade);
				if(skaitlis < min || skaitlis > max) {
					JOptionPane.showMessageDialog(null, 
					"Norādīts nederīgs skaitlis", "Nekorekti dati",
					JOptionPane.WARNING_MESSAGE);
					continue;
				}
				
				return skaitlis;
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
					"Netika ievadīts pareizs skaitlis", "Nekorekti dati",
					JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	public static String virknesParbaude(String zinojums, String noklusejums) {
		String virkne;
		do {
			virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
			if(virkne == null)
				return null;
		}while(!Pattern.matches("^[\\p{L} .]+$", virkne));
		return virkne;
	}
	public static void main(String[] args) {
		Queue<String> Picas = new LinkedList<>();
		
		String izvele, vards, piedevas, merce, dzeriens, uzkoda;
		int izmers;
		String[] darbibas = {"Pasūtīt picu", "Apskatīt pasūtījumus", "Apturēt"};
		String[] darbibas1 = {"Gatavās picas","Pašu taisīta", "Atgriezties"};
		String[] gatavaspicas = {"Studentu", "Pepperoni", "Havaju", "Ferrara"};
		String[] pizm = {"30", "42"};
		String[] merces = {"Ķiploku", "Gurķu", "BBQ", "Nekādu"};
		String[] atbildes = {"Jā", "Nē"};
		String[] dzert = {"Coca-Cola", "Fanta", "Sprite", "Ūdens", "Tēja", "Nekādu"};
		String[] uzkodas = {"Šokolādes kūka", "Šokolādes saldējums ar mērci", "Šokolādes saldējuma koktēlis", "Nekādu"};
		double cena = 0;
		boolean uzVietas;
		do {
			izvele = (String) JOptionPane.showInputDialog(null, "Izvēlieties darbību:\n"
					+ "Pasūtīt picu\n"
					+ "Apskatīt pasūtījumus\n"
					+ "Apturēt","Izvēle", JOptionPane.QUESTION_MESSAGE ,null, darbibas, darbibas[0]);
			if(izvele == null) 
				izvele = "Apturēt";
			
			switch(izvele) {
			case "Pasūtīt picu":
				izvele = (String) JOptionPane.showInputDialog(null, 
						"Izvēlieties darbību:\n"
						+ "Gatavās picas\n"
						//+ "Pašu taisīta\n"
						+ "Atgriezties","Izvēle", JOptionPane.QUESTION_MESSAGE ,null, darbibas1, darbibas1[0]);
				if(izvele == "Atgriezties" || izvele == null) {
					izvele = "Atgriezties";
					break;
				}
				piedevas = "";
				izmers = 0;
				merce = "";
				cena = 0;
				uzVietas = JOptionPane.showOptionDialog(null, 
						"Vai pica tiks ēsta uz vietas?"
						+ "\nPiegāde ir 3.50 EUR", 
						"Pasūtījuma veids", 
						JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE, 
						null, atbildes, atbildes[1]) == JOptionPane.YES_OPTION;
				if(!uzVietas) {
					cena += 3.5; 
				}
				vards = virknesParbaude("Lūdzu, ievadiet jūsu vārdu un uzvārdu:", "Jānis Bērziņš");
				switch(izvele) {
				case "Gatavās picas":
					izvele = (String) JOptionPane.showInputDialog(null, 
							"Picas"
							+ "\nStudentu : "
								+ "\nVārīts cūkgaļas šķiņķis, cīsiņi, \n"
								+ "mocarella, picas mērce, \neļļas un ķiploku mērce, oregano\n"
								+ "13.99 EUR 30cm\n"
								+ "17.99 EUR 42cm\n"
								
							+"\nPepperoni: "
								+ "\nSalami \"Pepperoni\", mocarella, kūpināts kausētais siers, \n"
								+ "\"Taco\" mērce, sīpolu čipsi, rukola, picas mērce, "
								+ "\neļļas un ķiploku mērce, oregano\n"
								+ "10.99 EUR 30cm\n"
								+ "14.99 EUR 42cm\n"
								
							+"\nHavaju: "
								+ "\nVārīts cūkgaļas šķiņķis, mocarella, konservēti ananasi, \n"
								+ "picas mērce, eļļas un ķiploku mērce, oregano\n"
								+ "14.99 EUR 30cm\n"
								+ "18.99 EUR 42cm\n"
								
							+"\nFerrara: "
								+ "\nCīsiņi, mocarella, kūpināts bekons, tomāti, auksti\n"
								+ "kausēts kūpinātais siers, Cēzara mērce, pētersīļi,\n"
								+ "picas mērce, eļļas un ķiploku mērce, oregano\n"
								+ "12.99 EUR 30cm\n"
								+ "16.99 EUR 42cm\n"
								
							,"Edienkarte:", JOptionPane.QUESTION_MESSAGE ,null, gatavaspicas, gatavaspicas[0]);
					if(izvele == null)
						izvele = "Atgriezties";
					dzeriens = (String) JOptionPane.showInputDialog(null, 
							"Vai vēlaties pievienot dzērienu jūsu pasūtījumam?"
							+ "\nCoca-Cola 0.5L - 1.70 EUR"
							+ "\nFanta 0.5L - 1.70 EUR"
							+ "\nSprite 0.5L - 1.70 EUR"
							+ "\nŪdens 0.5L - 1.00 EUR"
							+ "\nTēja 0.5L - 1.50 EUR", 
							"Dzērieni", JOptionPane.QUESTION_MESSAGE, null, 
							dzert, dzert[2]);
					switch(dzeriens) {
					case "Coca-Cola":
						cena += 1.70;
						break;
					case "Fanta":
						cena += 1.70;
						break;
					case "Sprite":
						cena += 1.70;
						break;
					case "Ūdens":
						cena += 1.00;
						break;
					case "Tēja":
						cena += 1.50;
						break;
					}
	
					uzkoda = (String) JOptionPane.showInputDialog(null, 
							"Vai vēlaties pievienot uzkodu jūsu pasūtījumam?"
							+ "\nŠokolādes kūka 6.50 EUR"
							+ "\nŠokolādes saldējums ar mērci 2.50 EUR"
							+ "\nŠokolādes saldējuma koktēlis 5.00 EUR", 
							"Uzkodas", JOptionPane.QUESTION_MESSAGE, null, 
							uzkodas, uzkodas[3]);
					switch(uzkoda) {
					case "Šokolādes kūka":
						cena += 6.50;
						break;
					case "Šokolādes saldējums ar mērci":
						cena += 2.50;
						break;
					case "Šokolādes saldējuma koktēlis":
						cena += 5.00;
						break;	
					}
					
					switch(izvele) {
					case "Studentu":
						piedevas = "\nVārīts cūkgaļas šķiņķis, cīsiņi, \n"
								+ "mocarella, picas mērce, \neļļas un ķiploku mērce, oregano\n";
						izmers = Integer.parseInt((String) JOptionPane.showInputDialog(null, 
								"Izvēlieties picas izmēru:"
								+ "\n30\n42", "Picas izmērs",
								JOptionPane.QUESTION_MESSAGE, null, pizm, pizm[0]));
						
						merce = (String) JOptionPane.showInputDialog(null, 
								"Vai vēlaties pievienot kādu papildus mērci?"
							+ "\nĶiploku mērce 0.99 EUR\nGurķu mērce 0.99 EUR\nBBQ mērce 0.99 EUR\nVai nekādu?", 
								"Papildus mērce", JOptionPane.QUESTION_MESSAGE, null, merces, merces[3]);
						if(merce == null)
							merce = "Nekādu";
						cena += (izmers == 30) ? 13.99 : 17.99;
						if(!merce.equals("Nekādu")) {
							cena += 0.99;
						}
						cena = Math.round(cena * 100.0) / 100.0;
						Pica Studentu = new Pica(vards, false, piedevas, izmers, cena, merce, uzVietas, dzeriens, uzkoda);
						JOptionPane.showMessageDialog(null, 
								"Jūsu pasūtījums:\n"+Studentu.PicasApr(), 
								"Pasūtījuma apstiprinājums", JOptionPane.INFORMATION_MESSAGE);
						Picas.add("Studentu");
						break;
						
					case "Pepperoni":
						piedevas = "\nSalami \"Pepperoni\", mocarella, kūpināts kausētais siers, \n"
								+ "\"Taco\" mērce, sīpolu čipsi, rukola, picas mērce, "
								+ "\neļļas un ķiploku mērce, oregano\n";
						izmers = Integer.parseInt((String) JOptionPane.showInputDialog(null, 
								"Izvēlieties picas izmēru:"
								+ "\n30\n42", "Picas izmērs",
								JOptionPane.QUESTION_MESSAGE, null, pizm, pizm[0]));
						
						merce = (String) JOptionPane.showInputDialog(null, 
								"Vai vēlaties pievienot kādu papildus mērci?"
							+ "\nĶiploku mērce 0.99 EUR\nGurķu mērce 0.99 EUR\nBBQ mērce 0.99 EUR\nVai nekādu?", 
								"Papildus mērce", JOptionPane.QUESTION_MESSAGE, null, merces, merces[3]);
						if(merce == null)
							merce = "Nekādu";
						cena += (izmers == 30) ? 10.99 : 14.99;
						if(!merce.equals("Nekādu")) {
							cena += 0.99;
						}
						cena = Math.round(cena * 100.0) / 100.0;
						Pica Pepperoni = new Pica(vards, false, piedevas, izmers, cena, merce, uzVietas, dzeriens, uzkoda);
						JOptionPane.showMessageDialog(null, 
								"Jūsu pasūtījums:\n"+Pepperoni.PicasApr(), 
								"Pasūtījuma apstiprinājums", JOptionPane.INFORMATION_MESSAGE);
						Picas.add("Pepperoni");
						break;
						
					case "Havaju":
						piedevas = "\nVārīts cūkgaļas šķiņķis, mocarella, konservēti ananasi, \n"
								+ "picas mērce, eļļas un ķiploku mērce, oregano\n";
						izmers = Integer.parseInt((String) JOptionPane.showInputDialog(null, 
								"Izvēlieties picas izmēru:"
								+ "\n30\n42", "Picas izmērs",
								JOptionPane.QUESTION_MESSAGE, null, pizm, pizm[0]));
						
						merce = (String) JOptionPane.showInputDialog(null, 
								"Vai vēlaties pievienot kādu papildus mērci?"
							+ "\nĶiploku mērce 0.99 EUR\nGurķu mērce 0.99 EUR\nBBQ mērce 0.99 EUR\nVai nekādu?", 
								"Papildus mērce", JOptionPane.QUESTION_MESSAGE, null, merces, merces[3]);
						if(merce == null)
							merce = "Nekādu";
						cena += (izmers == 30) ? 14.99 : 18.99;
						if(!merce.equals("Nekādu")) {
							cena += 0.99;
						}
						cena = Math.round(cena * 100.0) / 100.0;
						Pica Havaju = new Pica(vards, false, piedevas, izmers, cena, merce, uzVietas, dzeriens, uzkoda);
						JOptionPane.showMessageDialog(null, 
								"Jūsu pasūtījums:\n"+Havaju.PicasApr(), 
								"Pasūtījuma apstiprinājums", JOptionPane.INFORMATION_MESSAGE);
						Picas.add("Havaju");
						break;
						
					case "Ferrara":
						piedevas = "\nCīsiņi, mocarella, kūpināts bekons, tomāti, auksti\n"
								+ "kausēts kūpinātais siers, Cēzara mērce, pētersīļi,\n"
								+ "picas mērce, eļļas un ķiploku mērce, oregano\n";
						izmers = Integer.parseInt((String) JOptionPane.showInputDialog(null, 
								"Izvēlieties picas izmēru:"
								+ "\n30\n42", "Picas izmērs",
								JOptionPane.QUESTION_MESSAGE, null, pizm, pizm[0]));
						
						merce = (String) JOptionPane.showInputDialog(null, 
								"Vai vēlaties pievienot kādu papildus mērci?"
							+ "\nĶiploku mērce 0.99 EUR\nGurķu mērce 0.99 EUR\nBBQ mērce 0.99 EUR\nVai nekādu?", 
								"Papildus mērce", JOptionPane.QUESTION_MESSAGE, null, merces, merces[3]);
						if(merce == null)
							merce = "Nekādu";
						cena += (izmers == 30) ? 12.99 : 16.99;
						if(!merce.equals("Nekādu")) {
							cena += 0.99;
						}
						cena = Math.round(cena * 100.0) / 100.0;
						Pica Ferrara = new Pica(vards, false, piedevas, izmers, cena, merce, uzVietas, dzeriens, uzkoda);
						JOptionPane.showMessageDialog(null, 
								"Jūsu pasūtījums:\n"+Ferrara.PicasApr(), 
								"Pasūtījuma apstiprinājums", JOptionPane.INFORMATION_MESSAGE);
						Picas.add("Ferrara");
						break;
					}
					
					break;
				case "Pašu taisīta":
					izmers = Integer.parseInt((String) JOptionPane.showInputDialog(null, 
							"Izvēlieties picas izmēru:"
							+ "\n30\n42", "Picas izmērs",
							JOptionPane.QUESTION_MESSAGE, null, pizm, pizm[0]));
					do {
						izvele = virknesParbaude("Lūdzu, ievadiet jūsu picai piedevas:"
								+ "\nX, ja vēlaties atgriezties", "Siļķis");
						if(izvele == null) {
							izvele = "x";
							break;
						}
						piedevas += izvele + ", ";
						cena += 0.50;
						
					}while(!izvele.equalsIgnoreCase("x"));
					
					dzeriens = (String) JOptionPane.showInputDialog(null, 
							"Vai vēlaties pievienot dzērienu jūsu pasūtījumam?"
							+ "\nCoca-Cola 0.5L - 1.70 EUR"
							+ "\nFanta 0.5L - 1.70 EUR"
							+ "\nSprite 0.5L - 1.70 EUR"
							+ "\nŪdens 0.5L - 1.00 EUR"
							+ "\nTēja 0.5L - 1.50 EUR", 
							"Dzērieni", JOptionPane.QUESTION_MESSAGE, null, 
							dzert, dzert[2]);
					switch(dzeriens) {
					case "Coca-Cola":
						cena += 1.70;
						break;
					case "Fanta":
						cena += 1.70;
						break;
					case "Sprite":
						cena += 1.70;
						break;
					case "Ūdens":
						cena += 1.00;
						break;
					case "Tēja":
						cena += 1.50;
						break;
					}
	
					uzkoda = (String) JOptionPane.showInputDialog(null, 
							"Vai vēlaties pievienot uzkodu jūsu pasūtījumam?"
							+ "\nŠokolādes kūka 6.50 EUR"
							+ "\nŠokolādes saldējums ar mērci 2.50 EUR"
							+ "\nŠokolādes saldējuma koktēlis 5.00 EUR", 
							"Uzkodas", JOptionPane.QUESTION_MESSAGE, null, 
							uzkodas, uzkodas[3]);
					switch(uzkoda) {
					case "Šokolādes kūka":
						cena += 6.50;
						break;
					case "Šokolādes saldējums ar mērci":
						cena += 2.50;
						break;
					case "Šokolādes saldējuma koktēlis":
						cena += 5.00;
						break;	
					}
					
					merce = (String) JOptionPane.showInputDialog(null, 
							"Vai vēlaties pievienot kādu papildus mērci?"
						+ "\nĶiploku mērce 0.99 EUR\nGurķu mērce 0.99 EUR\nBBQ mērce 0.99 EUR\nVai nekādu?", 
							"Papildus mērce", JOptionPane.QUESTION_MESSAGE, null, merces, merces[3]);
					if(merce == null)
						merce = "Nekādu";
					cena += (izmers == 30) ? 13.99 : 17.99;
					if(!merce.equals("Nekādu")) {
						cena += 0.99;
					}
					cena = Math.round(cena * 100.0) / 100.0;
					Pica pasu = new Pica(vards, false, piedevas, izmers, cena, merce, uzVietas, dzeriens, uzkoda);
					JOptionPane.showMessageDialog(null, 
							"Jūsu pasūtījums:\n"+pasu.PicasApr(), 
							"Pasūtījuma apstiprinājums", JOptionPane.INFORMATION_MESSAGE);
					Picas.add("Pica");
				}
				break;
			}
		}while(!izvele.equals("Apturēt"));
	}

}
