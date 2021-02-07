package logic.engineeringclasses.bean.managemenu;

public class BeanDishWeb {

	private String nomePiatto;
	private String nomeRistorante;
	private String contenutoRicetta;
	private boolean perVegano;
	private boolean perCeliaco;
	private double prezzo;
	private int tipoModificaPiatto; //0 -> aggiungo piatto		1 -> modifico piatto 		2 -> elimino piatto
	
	public BeanDishWeb(String piatto, String ristorante,String contenuto,boolean vegano, boolean celiaco, double prezzo,int tipoModifica) {
		this.nomePiatto = piatto;
		this.nomeRistorante= ristorante;
		this.contenutoRicetta = contenuto;
		this.perVegano = vegano;
		this.perCeliaco = celiaco;
		this.prezzo = prezzo;
		this.tipoModificaPiatto = tipoModifica;
		
	}
	
	public String getPiatto() {
		return nomePiatto;
	}

	public void setPiatto(String piatto) {
		this.nomePiatto= piatto;
	}

	public String getRistorante() {
		return nomeRistorante;
	}

	public void setRistorante(String ristorante) {
		this.nomeRistorante = ristorante;
	}

	public String getContenuto() {
		return contenutoRicetta;
	}

	public void setContenuto(String contenuto) {
		this.contenutoRicetta = contenuto;
	}

	public boolean isVegano() {
		return perVegano;
	}

	public void setVegano(boolean vegano) {
		this.perVegano = vegano;
	}

	public boolean isCeliaco() {
		return perCeliaco;
	}

	public void setCeliaco(boolean celiaco) {
		this.perCeliaco = celiaco;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getTipoModifica() {
		return tipoModificaPiatto;
	}

	public void setTipoModifica(int tipoModifica) {
		this.tipoModificaPiatto = tipoModifica;
	}
}
