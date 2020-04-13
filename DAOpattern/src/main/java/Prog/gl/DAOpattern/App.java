package Prog.gl.DAOpattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {		Connection C = null;
	try {
		C = DriverManager.getConnection("jdbc:mysql://localhost","root", "root");
	} catch (SQLException e) {
    	
		e.printStackTrace();
	}
    	DAO<Personnel> p = DAOFactory.getPersonnelDAO ( C ) ;
    	System.out.println( "Hello World!" );
    }
}
