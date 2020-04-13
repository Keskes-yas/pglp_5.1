package Prog.gl.DAOpattern;

import java.sql.Connection;

import org.junit.Test;

public class CRUDTest {
	Connection c;
	PersonnelDAO pdao;
	Personnel p ;
	/*init*/
	
	@Test(expected = NullPointerException.class )
	public void createTest() {
		pdao.create(p);
	}
	
	@Test(expected = NullPointerException.class )
	public void deleteTest() {
		pdao.delete(p);
	}
	
	@Test(expected = NullPointerException.class )
	public void updateTest() {
		pdao.update(p);
	}
	
	@Test(expected = NullPointerException.class )
	public void findTest() {
		pdao.find(1234);
	}
}
