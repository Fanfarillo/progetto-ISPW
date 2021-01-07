package logic.engineeringclasses.others;

public enum Cities {
	Torino("Torino"),
	Aosta("Aosta"),
	Genova("Genova"),
	Milano("Milano"),
	Trento("Trento"),
	Trieste("Trieste"),
	Venezia("Venezia"),
	Bologna("Bologna"),
	Firenze("Firenze"),
	Ancona("Ancona"),
	Perugia("Perugia"),
	Roma("Roma"),
	Aquila("L'Aquila"),
	Campobasso("Campobasso"),
	Napoli("Napoli"),
	Bari("Bari"),
	Potenza("Potenza"),
	Catanzaro("Catanzaro"),
	Palermo("Palermo"),
	Cagliari("Cagliari");
	public final String nome;
	private Cities(String nome)
	{
		this.nome=nome;
	}
}
