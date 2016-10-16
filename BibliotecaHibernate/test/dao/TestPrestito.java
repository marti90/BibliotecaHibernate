package dao;

import static org.junit.Assert.*;

import java.util.Date;

import model.Prestito;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestPrestito {

    static PrestitoDAO pDao = new PrestitoDAO();
	
	@Test
	public void test1_createPrestito() {
		Date d = new Date();
		java.sql.Date dSql = new java.sql.Date(d.getTime());
		Prestito p = new Prestito(dSql);
		boolean flag = pDao.createPrestito(p);
		assertTrue(flag);
	}
	
	@Test
	public void test2_readPrestito() {
		Date d = new Date();
		java.sql.Date dSql = new java.sql.Date(d.getTime());
		assertEquals(dSql , pDao.readPrestito(1).getDataPrestito());
	}
	
	@Test
	public void test5_deletePrestito(){
		Prestito p = pDao.readPrestito(1);
		boolean flag = pDao.deletePrestito(p);
		assertTrue(flag);
	}

}
