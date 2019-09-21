package sn.academy.metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author babacar
 *
 */
public class DB {
		//pour la connexion on a besoin d objet de type connexion qui sont dans java.sql
	
		private Connection cnx;
		//pour les resultats des requetes de types SELECT 
		private ResultSet rs;
		
		//pour les requetes prepaprés
		private PreparedStatement pstm;
		//pour les resultats des requetes de types MAJ(INSERT, UPDATE, DELETE)
		//il retourne tjrs un entier
		private int ok;
		
		private void getConnnection() {
			
			String url = "jdbc:mysql://localhost:3306/GestionEmploye?useSSL=false";
			String user = "root";
			String password = "aller@44";
			try {
				//install du driver
				Class.forName("com.mysql.jdbc.Driver");
				cnx = (Connection) DriverManager.getConnection(url,user,password);
				System.out.println("okkk");
			} catch (Exception e) {
				
				e.printStackTrace();	
				}
		}

		//initialisation de req sql
		
		public void initPrepar(String sql) { //son role est de preparer les req sql en se basant sur la connection
			try {
				getConnnection();
				// pour preparer req sql
				pstm = ((java.sql.Connection) cnx).prepareStatement(sql);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public ResultSet executeSelect() {
			getConnnection();
			try {
				//execution des req select
				rs = pstm.executeQuery();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return rs;
		}
		public int executeMaj() {
			try {
				//execution des req Maj
				ok = pstm.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ok;
		}
		
		//close connexion 
		
		public void closeConnection() {
			try {
				//si la connexion on la ferme
				if (cnx != null) {
					cnx.close(); 
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//qui permet de preparer nos req avant de les executer
		public PreparedStatement getPstm() {
			return pstm;
		}

		public void setPstm(PreparedStatement pstm) {
			this.pstm = pstm;
		}
		
}
