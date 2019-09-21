package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import sn.academy.metier.EmployeImpl;
import sn.academy.metier.IService;
import sn.academy.metier.ServiceImpl;
import sn.academysa.entities.Employe;
import sn.academysa.entities.Service;

public class ServiceController {
	Scanner sc = new Scanner(System.in);
	
	Service s = new Service();
	
	Employe em = new Employe();
	//EmployeImpl repo = new EmployeImpl();
	
	public Service saisir () {
		System.out.println("saisir le libellé");
		s.setLibelle(sc.next());
		
		return s;
	}
	
	public Employe plusEmploye() throws ParseException {
		System.out.println("Saisir mat");
		em.setMatricule(sc.next());
		System.out.println("Saisir Nom Complet");
		em.setNom(sc.next());
		System.out.println("Saisir Date de Naissance");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		em.setDatenaiss(sdf.parse(sc.next()));	
		System.out.println("Saisir Salaire");
		em.setSalaire(sc.nextInt());
		System.out.println("Saisir Telephone");
		em.setTel(sc.next());
		
		System.out.println("Choisir votre Service");
		ServiceImpl serveImp = new ServiceImpl();
		List<Service> services = serveImp.liste();
		for (Service i : services) {
		      System.out.println(i.getId()+ " " +i.getLibelle()+"\n");
		    }
		em.setIdSerive(sc.nextInt());
		
		return em;
		
	}
}
