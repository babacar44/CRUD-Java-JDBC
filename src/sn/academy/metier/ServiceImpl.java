package sn.academy.metier;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sn.academysa.entities.Service;

public class ServiceImpl implements IService {

		//appel connection
	private DB db = new DB();
	private ResultSet rs;
	private int ok;
	
	@Override
	public int add(Service s) {
		
		String sql = "INSERT INTO service VALUES (NULL,?)";
		
		try {
			db.initPrepar(sql);
			db.getPstm().setString(1, s.getLibelle());
			
			//execution
			ok = db.executeMaj();
			db.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok;
	}

	public List<Service> liste() {
		List<Service> listservice = new ArrayList<Service>();
		
		String sql = "SELECT * FROM service";
		
		try {
			db.initPrepar(sql);
			rs = db.executeSelect();
			System.out.println("La Liste des services");

			while(rs.next()){
				Service s = new Service();
				s.setId(rs.getInt(1));
				s.setLibelle(rs.getString(2));
				listservice.add(s);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listservice;
	}

}
