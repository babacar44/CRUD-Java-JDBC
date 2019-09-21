package sn.academy.metier;

import java.util.List;

import sn.academysa.entities.Employe;

public interface IEmploye {
	public int add(Employe emp);
	public List<Employe> liste();
	public int update(Employe emp);
	public int remove(Employe emp);
	List<Employe> liste(int service);
}
