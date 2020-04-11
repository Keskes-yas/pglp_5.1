package Prog.gl.DAOpattern;

import java.sql.Connection;

public class PersonnelDAO extends DAO<Personnel> {

	

	public PersonnelDAO(Connection conn) {
		super(conn);
		
	}

	
	public boolean create(Personnel obj) {
		return false;
	}

	@Override
	public boolean delete(Personnel obj) {
		return false;
	}

	@Override
	public boolean update(Personnel obj) {
		return false;
	}

	@Override
	public Personnel find(int id) {
		return null;
	}

}
