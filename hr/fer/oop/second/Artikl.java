package hr.fer.oop.lab4.second;

public class Artikl implements Comparable<Artikl> {

	private String naziv;
	private String cijena;
	
	public Artikl(String naziv, String cijena) {
		this.naziv = naziv;
		this.cijena = cijena;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public String getCijena() {
		return cijena;
	}
	
	@Override
	public boolean equals(Object artikl) {
		return this.naziv.equals(naziv);
	}
	
	@Override
	public int hashCode() {
		return this.naziv.hashCode();
	}

	@Override
	public int compareTo(Artikl o) {
		return this.naziv.compareTo(o.getNaziv());
	}
}
