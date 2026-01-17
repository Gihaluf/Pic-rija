package Picerija;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;



public class Teksts {
	static String failaN = "Pasutijumi.txt";

	static void Ieraksta(Pica pica) {
		try {
			FileWriter fw = new FileWriter(failaN, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(pica.PicasApr());
			pw.println("-------------------------------------------");
			pw.close();
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Nesaglabā failā", "Kļūda",
					JOptionPane.WARNING_MESSAGE);
		}
	}
	static void nolasit() {
		String teksts, str = "";
		try {
			FileReader fr = new FileReader(failaN);
			BufferedReader br = new BufferedReader (fr);
			while((teksts = br.readLine()) != null) {
				str += teksts+"\n";
			}
			br.close();
			
			JTextArea ta = new JTextArea (str, 10, 40);
			ta.setEditable(false);
			JScrollPane sp = new JScrollPane(ta);
			sp.setVerticalScrollBarPolicy(
					ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			JOptionPane.showMessageDialog(ta, sp, "Atzīmes",
					JOptionPane.PLAIN_MESSAGE);
			
		}catch(IOException e){
			JOptionPane.showMessageDialog(null,
				"Kļūda nolasot failu!", "Kļūda",
				JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
