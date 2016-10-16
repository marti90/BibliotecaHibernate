package dao;

import static org.junit.Assert.*;
import model.Libro;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestLibro {

	static LibroDAO lDao = new LibroDAO();
	
	@Test
	public void test1_createLibro() {
		Libro l = new Libro("Cent'anni di solitudine", "Gabriel Garcia Marquez");
		boolean flag = lDao.createLibro(l);
		assertTrue(flag);
	}
	
	@Test
	public void test2_readLibro1() {
		Libro l = new Libro("Cent'anni di solitudine", "Gabriel Garcia Marquez");
		assertEquals(l.getTitolo(), lDao.readLibro("Cent'anni di solitudine").getTitolo());
		assertEquals(l.getAutore(), lDao.readLibro("Cent'anni di solitudine").getAutore());
	}
	
	@Test
	public void test3_readLibro2() {
		Libro l = new Libro("Cent'anni di solitudine", "Gabriel Garcia Marquez");
		assertEquals(l.getTitolo(), lDao.readLibro(1).getTitolo());
		assertEquals(l.getAutore(), lDao.readLibro(1).getAutore());
	}
	
	@Test
	public void test4_updateLibro(){
		Libro l = lDao.readLibro(1);
		l.setAutore("Marquez");
		boolean flag = lDao.updateLibro(l);
		assertTrue(flag);
	}
	
	@Test
	public void test5_deleteLibro(){
		Libro l = lDao.readLibro(1);
		boolean flag = lDao.deleteLibro(l);
		assertTrue(flag);
	}

}
