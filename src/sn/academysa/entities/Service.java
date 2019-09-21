package sn.academysa.entities;

public class Service {
	private int id;
	private String libelle;
	
	
	public Service(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	public Service() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void lister() {
		Service s = new Service();
		System.out.println("service " + s.getLibelle());
	}
	
	
}
