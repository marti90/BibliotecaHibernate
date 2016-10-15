package service;

import model.Biblioteca;
import model.Libro;
import model.Utente;
import dao.BibliotecaDAO;
import dao.LibroDAO;
import dao.UtenteDAO;

public class Gestione {
	
	UtenteDAO uDao = new UtenteDAO();
	LibroDAO lDao = new LibroDAO();
	BibliotecaDAO bDao = new BibliotecaDAO();
	
	public Utente leggiUtente(long id_utente){
		
		Utente u = uDao.readUtente(id_utente);
		
		return u;
	}
	
	public Utente leggiUtente(String nome, String cognome){
		
		Utente u = uDao.readUtente(nome, cognome);
		
		return u;
	}
	
	public boolean aggiungiUtente(Biblioteca b, String nome, String cognome, String cf){
		
		boolean res = false;
		
		Utente u = new Utente(nome,cognome,cf);
		res = uDao.createUtente(u);
		u.addBiblioteca(b);
		b.addUtente(u);
		bDao.updateBiblioteca(b);
		
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
	
	public boolean cancellaUtente(Biblioteca b, String nome, String cognome){
		
        boolean res = false;
		
		Utente u = this.leggiUtente(nome,cognome);
		res = uDao.deleteUtente(u);
		b.deleteUtente(u);
		bDao.updateBiblioteca(b);
		
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
	
	public boolean aggiungiLibro(Biblioteca b, String titolo, String autore){
		
		boolean res = false;
		
		Libro l = new Libro(titolo,autore);
		res = lDao.createLibro(l);
		l.addBiblioteca(b);
		b.addLibro(l);
		bDao.updateBiblioteca(b);
		
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
	
	public boolean cancellaLibro(Biblioteca b, String titolo){
		
        boolean res = false;
		
		Libro l = this.leggiLibro(titolo);
		res = lDao.deleteLibro(l);
		b.deleteLibro(l);
		bDao.updateBiblioteca(b);
		
		return res;
	}
	
	public Biblioteca aggiungiBiblioteca(String nome){
		
		Biblioteca b = new Biblioteca(nome);
		bDao.createBiblioteca(b);
		
		return b;
	}


}
