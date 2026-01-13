package Picerija;

public class Pica {
	private boolean gatava;
	private String piedevas, merces;
	private int izmers; 
	private double cena;
	
	public Pica(boolean gatava, String piedevas,
			int izmers, double cena, String merces) {
		this.gatava = gatava;
		this.piedevas = piedevas;
		this.izmers = izmers;
		this.cena = cena;
		this.merces = merces;
	}
	public boolean getGatava() {
		return gatava;
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

}
