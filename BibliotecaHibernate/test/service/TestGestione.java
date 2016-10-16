package service;

import static org.junit.Assert.*;
import model.Biblioteca;
import model.Prestito;


import org.junit.Test;



import dao.BibliotecaDAO;

public class TestGestione {
	
	static Gestione g = new Gestione();
	static BibliotecaDAO bDao = new BibliotecaDAO();
	Biblioteca b = g.aggiungiBiblioteca("Biblioteca Poli");

	@Test
	public void test1_registraUtente() {
		boolean flag = g.registraUtente(b, "Luca", "Umoretto", "MRTLCA90C");
		assertTrue(flag);
	}
	
	@Test
	public void test2_registraLibro(){
		boolean flag = g.registraLibro(b, "Delitto e castigo", "Fedor Dostoevskij", 5);
		assertTrue(flag);
	}
	
	@Test
	public void test3_prestaLibro(){
		Prestito p = g.prestaLibro(b, "Luca", "Umoretto","Delitto e castigo");
		assertNotNull(p);
	}
	
	@Test
	public void test4_restituisciLibro(){
		boolean flag = g.restituisciLibro(b, "Luca", "Umoretto", "Delitto e castigo", 6);
		assertTrue(flag);
	}

}
