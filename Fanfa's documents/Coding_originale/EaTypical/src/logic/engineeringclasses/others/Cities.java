package logic.engineeringclasses.others;

public enum Cities {
	torino("Torino"),
	aosta("Aosta"),
	genova("Genova"),
	milano("Milano"),
	trento("Trento"),
	trieste("Trieste"),
	venezia("Venezia"),
	bologna("Bologna"),
	firenze("Firenze"),
	ancona("Ancona"),
	perugia("Perugia"),
	roma("Roma"),
	aquila("L'Aquila"),
	campobasso("Campobasso"),
	napoli("Napoli"),
	bari("Bari"),
	potenza("Potenza"),
	catanzaro("Catanzaro"),
	palermo("Palermo"),
	cagliari("Cagliari");
	public final String nome;
	private Cities(String nome)
	{
		this.nome=nome;
	}
}
