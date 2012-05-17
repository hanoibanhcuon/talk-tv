package com.hr.fer.asc;

public class Emisija {

	private int redniBroj;
	private int vrijemePocetka;
	private int vrijemeKraja;	
	private String imeEmisije;
	private String strVrijemePocetka;
	private String strVrijemeKraja;
	public Emisija(int redniBroj, String vrijemePocetka, String vrijemeKraja,
			String imeEmisije) {
		super();
		this.redniBroj = redniBroj;
		this.vrijemePocetka = Integer.parseInt(vrijemePocetka.replaceAll(":", ""));
		this.vrijemeKraja = Integer.parseInt(vrijemeKraja.replaceAll(":", ""));
		this.imeEmisije = imeEmisije;
		this.strVrijemePocetka=vrijemePocetka;
		this.strVrijemeKraja=vrijemeKraja;
		
	}
	public int getRedniBroj() {
		return redniBroj;
	}
	public void setRedniBroj(int redniBroj) {
		this.redniBroj = redniBroj;
	}
	public int getVrijemePocetka() {
		return vrijemePocetka;
	}
	public void setVrijemePocetka(int vrijemePocetka) {
		this.vrijemePocetka = vrijemePocetka;
	}
	public int getVrijemeKraja() {
		return vrijemeKraja;
	}
	public void setVrijemeKraja(int vrijemeKraja) {
		this.vrijemeKraja = vrijemeKraja;
	}
	public String getImeEmisije() {
		return imeEmisije;
	}
	public void setImeEmisije(String imeEmisije) {
		this.imeEmisije = imeEmisije;
	}
	public String getStrVrijemePocetka() {
		return strVrijemePocetka;
	}
	public void setStrVrijemePocetka(String strVrijemePocetka) {
		this.strVrijemePocetka = strVrijemePocetka;
	}
	public String getStrVrijemeKraja() {
		return strVrijemeKraja;
	}
	public void setStrVrijemeKraja(String strVrijemeKraja) {
		this.strVrijemeKraja = strVrijemeKraja;
	}

	
	
	
	
	
}
