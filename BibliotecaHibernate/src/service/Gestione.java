package service;

import java.util.Date;

import model.Biblioteca;
import model.Libro;
import model.Prestito;
import model.Utente;
import dao.BibliotecaDAO;
import dao.LibroDAO;
import dao.PrestitoDAO;
import dao.UtenteDAO;

public class Gestione {
	
	UtenteDAO uDao = new UtenteDAO();
	LibroDAO lDao = new LibroDAO();
	BibliotecaDAO bDao = new BibliotecaDAO();
	PrestitoDAO pDao = new PrestitoDAO();
	
	public Utente trovaUtente(long id_utente){
		
		Utente u = uDao.readUtente(id_utente);
		
		return u;
	}
	
	public Utente trovaUtente(String nome, String cognome){
		
		Utente u = uDao.readUtente(nome, cognome);
		
		return u;
	}
	
	public boolean registraUtente(Biblioteca b, String nome, String cognome, String cf){
		
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
		
		Utente u = this.trovaUtente(nomeVecchio,cognomeVecchio);
		u.setNome(nomeNuovo);
		u.setCognome(cognomeNuovo);
		u.setCf(cf);
		res = uDao.updateUtente(u);
		
		return res;
	}
	
	public boolean cancellaUtente(Biblioteca b, String nome, String cognome){
		
        boolean res = false;
		
		Utente u = this.trovaUtente(nome,cognome);
		res = uDao.deleteUtente(u);
		b.deleteUtente(u);
		bDao.updateBiblioteca(b);
		
		return res;
	}
	
    public Libro trovaLibro(long id_libro){
		
		Libro l = lDao.readLibro(id_libro);
		
		return l;
	}
	
	public Libro trovaLibro(String titolo){
		
		Libro l = lDao.readLibro(titolo);
		
		return l;
	}
	
	public boolean registraLibro(Biblioteca b, String titolo, String autore, int copieDaRegistrare){
		
		boolean res = false;
		
		if(this.trovaLibro(titolo) != null){
			this.trovaLibro(titolo).setCopieTotali(this.trovaLibro(titolo).getCopieTotali()+copieDaRegistrare);
			this.trovaLibro(titolo).setCopieDisponibili(this.trovaLibro(titolo).getCopieDisponibili()+copieDaRegistrare);
			res = true;
		} else {
			Libro l = new Libro(titolo,autore);
			res = lDao.createLibro(l);
			l.addBiblioteca(b);
			b.addLibro(l);
			bDao.updateBiblioteca(b);
		}
		
		return res;
	}
	
	public boolean modificaLibro(String titoloVecchio,String titoloNuovo, String autoreNuovo){
		
		boolean res = false;
		
		Libro l = this.trovaLibro(titoloVecchio);
		l.setTitolo(titoloNuovo);
		l.setAutore(autoreNuovo);
		res = lDao.updateLibro(l);
		
		return res;
	}
	
	public boolean cancellaLibro(Biblioteca b, String titolo){
		
        boolean res = false;
		
		Libro l = this.trovaLibro(titolo);
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
	
	public Biblioteca trovaBiblioteca(long id_biblioteca){
		
		Biblioteca b = bDao.readBiblioteca(id_biblioteca);
		
		return b;
	}
	
	public Biblioteca trovaBiblioteca(String nome){
		
		Biblioteca b = bDao.readBiblioteca(nome);
		
		return b;
	}
	
	public boolean modificaBiblioteca(String nomeVecchio, String nomeNuovo){
		
		boolean res = false;
		Biblioteca b = this.trovaBiblioteca(nomeVecchio);
		b.setNome(nomeNuovo);
		res = bDao.updateBiblioteca(b);
		
		return res;
	}
	
	public boolean cancellaBiblioteca(String nome){
		
		boolean res = false;
		Biblioteca b = this.trovaBiblioteca(nome);
		res = bDao.deleteBiblioteca(b);
		
		return res;
	}
	
	public boolean prestaLibro(Biblioteca b, String nome, String cognome, String titolo){
		
		boolean res = false;
		Utente u = uDao.readUtente(nome, cognome);
		Libro l = lDao.readLibro(titolo);
		
		if(u != null && l != null && l.getCopieDisponibili()>0){
			Date d = new Date();
			java.sql.Date dSql = new java.sql.Date(d.getTime());
			Prestito p = new Prestito (dSql);
			p.setBiblioteca(b);
			p.setU(u);
			p.setLibro(l);
			b.addPrestito(p);
			u.addPrestito(p);
			l.addPrestito(p);
			l.setCopieDisponibili(l.getCopieDisponibili()-1);
			bDao.updateBiblioteca(b);
			res = true;
		}
		
		return res;
	}
	
	


}
