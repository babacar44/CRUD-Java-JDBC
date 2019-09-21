package sn.academy.metier;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import sn.academysa.entities.Employe;

public class EmployeImpl implements IEmploye{
	
	private DB db = new DB();
	private ResultSet rs;
	private int ok;

	@Override
	public int add(Employe emp) {
		//mise en place de la requete
		String sql = "INSERT INTO employe VALUES (NULL,?,?,?,?,?,?)";
		
		try {
			//appel de la connexion et la pstm
			db.initPrepar(sql);
			db.getPstm().setString(1, emp.getMatricule());
			db.getPstm().setString(2, emp.getNom());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			db.getPstm().setString(3, sdf.format(emp.getDatenaiss()));
			db.getPstm().setInt(4, emp.getSalaire());
			db.getPstm().setString(5, emp.getTel());
			db.getPstm().setInt(6, emp.getIdSerive());
			
			//execution 
			ok = db.executeMaj();
			db.closeConnection();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		return 0;
	}

	@Override
	public List<Employe> liste(int service) {
		List<Employe> listEmp = new ArrayList<Employe>();
		
		String sql = "SELECT * FROM employe WHERE id_service=?";
		
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, service);
			rs = db.executeSelect();
			
			
			while (rs.next()) {	
				Employe em = new Employe();
				em.setMatricule(rs.getString(2));
				em.setNom(rs.getString(3));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				em.setDatenaiss(sdf.parse(rs.getString(4)));
				em.setSalaire(rs.getInt(5));
				em.setTel(rs.getString(6));
				listEmp.add(em);

			}

			db.closeConnection();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listEmp;
	}

	@Override
	public int update(Employe emp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(Employe emp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Employe> liste() {
		// TODO Auto-generated method stub
		return null;
	}

}
