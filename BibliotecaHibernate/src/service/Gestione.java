package service;

import model.Utente;
import dao.UtenteDAO;

public class Gestione {
	
	UtenteDAO uDao = new UtenteDAO();
	
	public Utente leggiUtente(long id_utente){
		
		Utente u = uDao.readUtente(id_utente);
		
		return u;
	}
	
	public boolean aggiungiUtente(String nome, String cognome, String cf){
		
		boolean res = false;
		
		Utente u = new Utente(nome,cognome,cf);
		res = uDao.createUtente(u);
		
		return res;
	}
	
	

}
