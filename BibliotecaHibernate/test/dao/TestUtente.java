package dao;

import static org.junit.Assert.*;
import model.Utente;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestUtente {

    static UtenteDAO uDao = new UtenteDAO();
	
	@Test
	public void test1_createUtente() {
		Utente u = new Utente("Martina", "Debernardi", "DBRMTN90A");
		boolean flag = uDao.createUtente(u);
		assertTrue(flag);
	}
	
	@Test
	public void test2_readUtente1() {
		Utente u = new Utente("Martina", "Debernardi", "DBRMTN90A");
		assertEquals(u.getNome(), uDao.readUtente("Martina", "Debernardi").getNome());
		assertEquals(u.getCognome(), uDao.readUtente("Martina", "Debernardi").getCognome());
	}
	
	@Test
	public void test3_readUtente2() {
		Utente u = new Utente("Martina", "Debernardi", "DBRMTN90A");
		assertEquals(u.getNome(), uDao.readUtente(1).getNome());
		assertEquals(u.getCognome(), uDao.readUtente(1).getCognome());
	}
	
	@Test
	public void test4_updateUtente(){
		Utente u = uDao.readUtente(1);
		u.setNome("Marti");
		boolean flag = uDao.updateUtente(u);
		assertTrue(flag);
	}
	
	@Test
	public void test5_deleteUtente(){
		Utente u = uDao.readUtente(1);
		boolean flag = uDao.deleteUtente(u);
		assertTrue(flag);
	}

}
