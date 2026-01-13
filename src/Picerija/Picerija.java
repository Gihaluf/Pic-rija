package Picerija;

import java.util.LinkedList;
import java.util.Queue;

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
	public static void main(String[] args) {
		Queue<String> Picas = new LinkedList<>();
		String izvele;
		String[] darbibas = {"Pasūtīt picu", "Apskatīt pasūtījumus", "Apturēt"};
		String[] darbibas1 = {"Gatavās picas", "Pašu taisīta", "Atgriezties"};
		String[] gatavaspicas = {"Studentu", "Pepperoni", "Havaju", "Ferrara"};
		String[] pizm = {"30", "40"};
		String[] atbildes = {"Jā", "Nē"};
		
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
						+ "Pašu taisīta\n"
						+ "Atgriezties","Izvēle", JOptionPane.QUESTION_MESSAGE ,null, darbibas1, darbibas1[0]);
				if(izvele == "Atgriezties")
					break;
				/* uz vietas vai lidzas jaizdoma vel
				 = (String) JOptionPane.showInputDialog(null, 
						":\n"
						+ "Gatavās picas\n"
						+ "Pašu taisīta\n"
						+ "Atgriezties","Izvēle", JOptionPane.QUESTION_MESSAGE ,null, darbibas1, darbibas1[0]);
				*/
				
				switch(izvele) {
				case "Gatavās picas":
					izvele = (String) JOptionPane.showInputDialog(null, 
							"\nStudentu: "
								+ "\nVārīts cūkgaļas šķiņķis, cīsiņi, \n"
								+ "mocarella, picas mērce, eļļas un ķiploku mērce, oregano\n"
							+"\nPepperoni: "
								+ "\nSalami \"Pepperoni\", mocarella, kūpināts kausētais siers, \n"
								+ "\"Taco\" mērce, sīpolu čipsi, rukola, picas mērce, "
								+ "eļļas un ķiploku mērce, oregano\n"
							+"\nHavaju: "
								+ "\nVārīts cūkgaļas šķiņķis, mocarella, konservēti ananasi, \n"
								+ "picas mērce, eļļas un ķiploku mērce, oregano\n"
							+"\nFerrara: "
								+ "\nCīsiņi, mocarella, kūpināts bekons, tomāti, auksti\n"
								+ "kausēts kūpinātais siers, Cēzara mērce, pētersīļi,\n"
								+ "picas mērce, eļļas un ķiploku mērce, oregano\n"
							,"Edienkarte:", JOptionPane.QUESTION_MESSAGE ,null, gatavaspicas, gatavaspicas[0]);
					if(izvele == null)
						izvele = "Atgriezties";
					switch(izvele) {
					case "Studentu":
						Picas.add("Studentu");
						String piedevas = "Vārīts cūkgaļas šķiņķis, cīsiņi, mocarella";
						int izmers = Integer.parseInt((String) JOptionPane.showInputDialog(null, 
								"Izvēlieties picas izmēru:"
								+ "\n30\n42", "Picas izmērs",
								JOptionPane.QUESTION_MESSAGE, null, pizm, pizm[0]));
						String merce = (String) JOptionPane.showInputDialog(null, 
								"Vai vēlaties pievienot kādu papildus mērci?"
								+ "\nĶiploku mērce\nGurķu mērce\nBBQ mērce\nVai nekādu?", 
								"Papildus mērce", JOptionPane.QUESTION_MESSAGE);
						break;
					}
					break;
				case "Pašu taisīta":
					JOptionPane.showMessageDialog(null, 
							"Šī funkcija vēl nav izveidota.", 
							"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
				break;
			}
		}while(!izvele.equals("Apturēt"));
	}

}
