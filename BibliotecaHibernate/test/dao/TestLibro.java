package dao;

import static org.junit.Assert.*;
import model.Libro;

import org.junit.Test;

public class TestLibro {

	static LibroDAO lDao = new LibroDAO();
	
	@Test
	public void test1_createLibro() {
		Libro l = new Libro("Cent'anni di solitudine", "Gabriel Garcia Marquez");
		boolean flag = lDao.createLibro(l);
		assertTrue(flag);
	}

}
