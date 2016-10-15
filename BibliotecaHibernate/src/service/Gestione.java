package service;

import model.Libro;
import model.Utente;
import dao.LibroDAO;
import dao.UtenteDAO;

public class Gestione {
	
	UtenteDAO uDao = new UtenteDAO();
	LibroDAO lDao = new LibroDAO();
	
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
	
    public Libro leggiLibro(long id_libro){
		
		Libro l = lDao.readLibro(id_libro);
		
		return l;
	}
	
	public Libro leggiLibro(String titolo){
		
		Libro l = lDao.readLibro(titolo);
		
		return l;
	}
	
	public boolean aggiungiLibro(String titolo, String autore){
		
		boolean res = false;
		
		Libro l = new Libro(titolo,autore);
		res = lDao.createLibro(l);
		
		return res;
	}
	
	public boolean modificaLibro(String titoloVecchio,String titoloNuovo, String autoreNuovo){
		
		boolean res = false;
		
		Libro l = this.leggiLibro(titoloVecchio);
		l.setTitolo(titoloNuovo);
		l.setAutore(autoreNuovo);
		res = lDao.updateLibro(l);
		
		return res;
	}
	
	public boolean cancellaLibro(String titolo){
		
        boolean res = false;
		
		Libro l = this.leggiLibro(titolo);
		
		res = lDao.deleteLibro(l);
		
		return res;
	}


}
