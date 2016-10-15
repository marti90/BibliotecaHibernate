package service;

import model.Utente;
import dao.UtenteDAO;

public class Gestione {
	
	UtenteDAO uDao = new UtenteDAO();
	
	public Utente leggiUtente(long id_utente){
		
		Utente u = uDao.readUtente(id_utente);
		
		return u;
	}
	
	public Utente leggiUtente(String nome, String cognome){
		
		Utente u = uDao.readUtente(nome, cognome);
		
		return u;
	}
	
	public boolean aggiungiUtente(String nome, String cognome, String cf){
		
		boolean res = false;
		
		Utente u = new Utente(nome,cognome,cf);
		res = uDao.createUtente(u);
		
		return res;
	}
	
	public boolean modificaUtente(String nomeVecchio, String cognomeVecchio, String nomeNuovo, String cognomeNuovo, String cf){
		
		boolean res = false;
		
		Utente u = this.leggiUtente(nomeVecchio,cognomeVecchio);
		u.setNome(nomeNuovo);
		u.setCognome(cognomeNuovo);
		u.setCf(cf);
		res = uDao.updateUtente(u);
		
		return res;
	}
	
	public boolean cancellaUtente(String nome, String cognome){
		
        boolean res = false;
		
		Utente u = this.leggiUtente(nome,cognome);
		
		res = uDao.deleteUtente(u);
		
		return res;
	}

}
