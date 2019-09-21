package sn.academysa.entities;

import java.util.Date;


public class Employe {
	private int id;
	private String matricule;
	private String nom;
	private String tel;
	private Date datenaiss;
	private int salaire;
	private int idSerive;
	
	public Employe() {}
	
	public Employe(int id, String matricule, String nom, String tel, Date datenaiss, int salaire, int idSerive) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.nom = nom;
		this.tel = tel;
		this.datenaiss = datenaiss;
		this.salaire = salaire;
		this.idSerive = idSerive;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getDatenaiss() {
		return datenaiss;
	}
	public void setDatenaiss(Date date) {
		this.datenaiss = date;
	}
	public int getSalaire() {
		return salaire;
	}
	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}
	public int getIdSerive() {
		return idSerive;
	}
	public void setIdSerive(int idSerive) {
		this.idSerive = idSerive;
	}
	
	
	
}
