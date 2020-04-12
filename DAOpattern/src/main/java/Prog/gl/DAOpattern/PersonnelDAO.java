package Prog.gl.DAOpattern;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class PersonnelDAO extends DAO<Personnel> {

	

	public PersonnelDAO(Connection conn) {
		super(conn);
		
	}



	public boolean create(Personnel p) {
		boolean bool = false ;
		int res = 0 ;
		
		PreparedStatement ps;
		try {
			ps = connect.prepareStatement("INSERT INTO personnel VALUES (?, ?, ?, ?, ?, ?)");
			ps.setLong(1, p.getId());
			ps.setString(2, p.getNom());
			ps.setString(3, p.getPrenom());
			ps.setDate(4, p.getDateNaissance());
			ps.setString(5, p.getNumeroTel());
			ps.setString(6, p.getFonction());
			res = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
			
		if(res == 1)
			bool = true ;
		
		return bool;
	}

	
	public boolean delete(Personnel p) {
		boolean bool = false ; 
		int res = 0 ;
		
		PreparedStatement ps;
		try {
			ps = connect.prepareStatement("DELETE FROM personnel WHERE ID = ? ");
			ps.setLong(1, p.getId());
			res = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
			
		if(res == 1)
			bool = true ;
		
		return bool;
		
	}

	
	public boolean update(Personnel p) {
		boolean bool = false ;
		int res = 0 ;
		PreparedStatement ps;
		try {
			ps = connect.prepareStatement("UPDATE personnel SET nom = ?, prenom = ?, dateNaissance = ?, numeroTel = ?, fonction = ? WHERE ID = ? ");
			ps.setLong(1, p.getId());
			res = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
			
		if(res == 1)
			bool = true ;
		
		return bool;
	}

	
	public Personnel find(int id) {
		Personnel per = null ;
		
		
		PreparedStatement ps;
		try {
			ps = connect.prepareStatement("SELECT FROM personnel  WHERE ID = ? ");
			ResultSet res = ps.executeQuery();
			if(res.first()) {
				String nom = res.getString("nom");
				String prenom = res.getString("prenom");
				Date naissance = res.getDate("dateNaissance");
				String tel = res.getString("tel");
				String fonction = res.getString("fonction");
				per = new Personnel(id,nom, prenom,  (java.sql.Date) naissance, tel, fonction);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		
		return per;
	}

}
