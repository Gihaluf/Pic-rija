package Picerija;

public class Pica {
	private boolean gatava, uzvietas;
	private String vards, piedevas, merces, uzkodas, dzeriens;
	private int izmers; 
	private double cena;
	
	public Pica(String vards, boolean gatava, String piedevas,
			int izmers, double cena, String merces, boolean uzvietas, 
			String dzeriens, String uzkodas) {
		this.vards = vards;
		this.gatava = gatava;
		this.piedevas = piedevas;
		this.izmers = izmers;
		this.cena = cena;
		this.merces = merces;
		this.uzvietas = uzvietas;
		this.dzeriens = dzeriens;
		this.uzkodas = uzkodas;
	}
	public String getVards() {
		return vards;
	}
	public String getDzeriens() {
		return dzeriens;
	}
	public String getUzkodas() {
		return uzkodas;
	}
	public boolean getGatava() {
		return gatava;
	}
	public boolean getUzvietas() {
		return uzvietas;
	}
	public String getPiedevas() {
		return piedevas;
	}
	public int getIzmers() {
		return izmers;
	}
	public double getCena() {
		return cena;
	}
	public String getMerces() {
		return merces;
	}
	
	public boolean setGatava(boolean gatava) {
		this.gatava = gatava;
		return gatava;
	}
	
	public String PicasApr() {
		return 	  vards
				+ "\nPicas izmērs: "+izmers+"cm"
				+ "\nPiedevas: "+piedevas
				+ "\nMērces: "+merces
				+ "\nUzkodas: "+uzkodas
				+ "\nDzeriens: "+dzeriens
				+ "\nCena: "+cena+" EUR." 
				+ "\nUz vietas: "+((uzvietas) ? "Jā" : "Nē")
				+ "\nGatava: "+((gatava) ? "Jā" : "Nē");
		
	}
}
