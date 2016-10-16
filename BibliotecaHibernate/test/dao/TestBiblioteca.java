package dao;

import static org.junit.Assert.*;
import model.Biblioteca;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestBiblioteca {

    static BibliotecaDAO bDao = new BibliotecaDAO();
	
	@Test
	public void test1_createBiblioteca() {
		Biblioteca b = new Biblioteca("Biblioteca Politecnico");
		boolean flag = bDao.createBiblioteca(b);
		assertTrue(flag);
	}
	
	@Test
	public void test2_readBiblioteca1() {
		Biblioteca b = new Biblioteca("Biblioteca Politecnico");
		assertEquals(b.getNome(), bDao.readBiblioteca("Biblioteca Politecnico").getNome());
	}
	
	@Test
	public void test3_readBiblioteca2() {
		Biblioteca b = new Biblioteca("Biblioteca Politecnico");
		assertEquals(b.getNome(), bDao.readBiblioteca(1).getNome());
		
	}
	
	@Test
	public void test4_updateBiblioteca(){
		Biblioteca b = bDao.readBiblioteca(1);
		b.setNome("Biblioteca Ciriè");
		boolean flag = bDao.updateBiblioteca(b);
		assertTrue(flag);
	}
	
	@Test
	public void test5_deleteBiblioteca(){
		Biblioteca b = bDao.readBiblioteca(1);
		boolean flag = bDao.deleteBiblioteca(b);
		assertTrue(flag);
	}

}
