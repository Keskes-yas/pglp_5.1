package Prog.gl.DAOpattern;

import java.sql.Connection;

public class DAOFactory {
	
	/**
	 * 
	 * @param connect
	 * @return
	 */
	public static DAO<Personnel> getPersonnelDAO(Connection connect){
		
		return new PersonnelDAO(connect);
	}
}
