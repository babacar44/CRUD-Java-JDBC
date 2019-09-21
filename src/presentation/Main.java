package presentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.ServiceController;
import sn.academy.metier.EmployeImpl;
import sn.academy.metier.IEmploye;
import sn.academy.metier.IService;
import sn.academy.metier.ServiceImpl;
import sn.academysa.entities.Employe;
import sn.academysa.entities.Service;

public class Main {

	public static void main(String[] args) throws ParseException {

//		Service s = new Service();
//		ServiceController addService = new ServiceController();
//		IService iService = new ServiceImpl();
//		
//		s = addService.saisir();
//		iService.add(s);
//		
//		System.out.println("service bien ajouté");
		Scanner sc = new Scanner(System.in);
		IService iService = new ServiceImpl();
		Service s = new Service();
		IEmploye repo = new EmployeImpl();
		Employe em = new Employe();
		ServiceImpl serveImp = new ServiceImpl();
		List<Service> services = serveImp.liste();
		
		
		
		
		System.out.println("Gestion Des Employés");
		System.out.println("veuillez choisir une option du menu suivant");
		System.out.println("1:creer un service");
		System.out.println("2:Lister Service");
		System.out.println("3:Ajouter Employe");
		System.out.println("4:lister tous les Empolye d'un service");
//		System.out.println("6:quitter");
		
		int choix = sc.nextInt();
		sc.nextLine();
		switch (choix) {
		case 1:
			
			ServiceController addService = new ServiceController();
			
			s = addService.saisir();
			iService.add(s);
			
			System.out.println("service bien ajouté");
			break;

		case 2:
		
			
			
//			
//			for (int i = 0; i < services.size(); i++) {
//				System.out.print(services.get(i).getId()+"\t");
//				System.out.print(services.get(i).getLibelle()+"\n");
//			}
			for (Service i : services) {
			      System.out.println(i.getId()+ " " +i.getLibelle()+"\n");
			    }
			break;

		case 3:
			 
			ServiceController addEmploye = new ServiceController();
			em = addEmploye.plusEmploye();
			repo.add(em);
			
			break;
			
		case 4:
			System.out.println("choisir la liste des Employe d'un service");

			for (Service i : services) {
			      System.out.println(i.getId()+ " " +i.getLibelle()+"\n");
			    }
			EmployeImpl employees = new EmployeImpl();
			List<Employe> empl = employees.liste(sc.nextInt());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			for (Employe e : empl) {
			      System.out.println(e.getMatricule()+ " " +e.getNom()+ " "+sdf.format(e.getDatenaiss())+ " "+ 
			    		  e.getSalaire()+ " " +e.getTel()+"\n");
			    }
			break;
			
		default:
			break;
		}
	}

}
