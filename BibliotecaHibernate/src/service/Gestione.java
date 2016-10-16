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
	
	//Trova l'Utente nella tabella Utente del Database attraverso il suo id
	public Utente trovaUtente(long id_utente){
		
		Utente u = uDao.readUtente(id_utente);
		
		return u;
	}
	
	//Trova l'Utente nella tabella Utente del Database attraverso il suo nome e cognome
	public Utente trovaUtente(String nome, String cognome){
		
		Utente u = uDao.readUtente(nome, cognome);
		
		return u;
	}
	
	//Registra un Utente ad una determinata Biblioteca, quindi aggiunge la Biblioteca alla lista biblioteche dell'Utente, 
	//e aggiunge l'Utente alla lista utenti della Biblioteca
	public boolean registraUtente(Biblioteca b, String nome, String cognome, String cf){
		
		boolean res = false;
		
		Utente u = new Utente(nome,cognome,cf);
		res = uDao.createUtente(u);
		u.addBiblioteca(b);
		b.addUtente(u);
		bDao.updateBiblioteca(b);
		
		return res;
	}
	
	//Modifica i dati dell'Utente
	public boolean modificaUtente(String nomeVecchio, String cognomeVecchio, String nomeNuovo, String cognomeNuovo, String cf){
		
		boolean res = false;
		
		Utente u = this.trovaUtente(nomeVecchio,cognomeVecchio);
		u.setNome(nomeNuovo);
		u.setCognome(cognomeNuovo);
		u.setCf(cf);
		res = uDao.updateUtente(u);
		
		return res;
	}
	
	//Cancella l'Utente dalla lista utenti della Biblioteca
	public boolean cancellaUtente(Biblioteca b, String nome, String cognome){
		
        boolean res = false;
		
		Utente u = this.trovaUtente(nome,cognome);
		res = uDao.deleteUtente(u);
		b.deleteUtente(u);
		bDao.updateBiblioteca(b);
		
		return res;
	}
	
	//Trova il Libro nella tabella Libro del Database attraverso il suo id
    public Libro trovaLibro(long id_libro){
		
		Libro l = lDao.readLibro(id_libro);
		
		return l;
	}
	
    //Trova il libro nella tabella Libro del Database attraverso il suo titolo
	public Libro trovaLibro(String titolo){
		
		Libro l = lDao.readLibro(titolo);
		
		return l;
	}
	
	//Registra un Libro ad una determinata Biblioteca, se il Libro esiste già nella Biblioteca allora aggiorna le sue copie totali e disponibili,
	//altrimenti crea l'oggetto Libro, setta le copie totali e disponibili al numero di copie da registrare ed aggiunge il Libro alla lista dei libri 
	//della Biblioteca e la Biblioteca alla lista delle biblioteche del Libro
	public boolean registraLibro(Biblioteca b, String titolo, String autore, int copieDaRegistrare){
		
		boolean res = false;
		
		if(this.trovaLibro(titolo) != null){
			this.trovaLibro(titolo).setCopieTotali(this.trovaLibro(titolo).getCopieTotali()+copieDaRegistrare);
			this.trovaLibro(titolo).setCopieDisponibili(this.trovaLibro(titolo).getCopieDisponibili()+copieDaRegistrare);
			res = true;
		} else {
			Libro l = new Libro(titolo,autore);
			l.setCopieTotali(copieDaRegistrare);
			l.setCopieDisponibili(copieDaRegistrare);
			res = lDao.createLibro(l);
			l.addBiblioteca(b);
			b.addLibro(l);
			bDao.updateBiblioteca(b);
		}
		
		return res;
	}
	
	//Modifica i dati del Libro
	public boolean modificaLibro(String titoloVecchio,String titoloNuovo, String autoreNuovo){
		
		boolean res = false;
		
		Libro l = this.trovaLibro(titoloVecchio);
		l.setTitolo(titoloNuovo);
		l.setAutore(autoreNuovo);
		res = lDao.updateLibro(l);
		
		return res;
	}
	
	//Cancella il Libro dalla lista libri della Biblioteca
	public boolean cancellaLibro(Biblioteca b, String titolo){
		
        boolean res = false;
		
		Libro l = this.trovaLibro(titolo);
		res = lDao.deleteLibro(l);
		b.deleteLibro(l);
		bDao.updateBiblioteca(b);
		
		return res;
	}
	
	//Aggiunge al Database una Biblioteca
	public Biblioteca aggiungiBiblioteca(String nome){
		
		Biblioteca b = new Biblioteca(nome);
		bDao.createBiblioteca(b);
		
		return b;
	}
	
	//Trova la Biblioteca all'interno della tabella Biblioteca del Database attraverso il suo id
	public Biblioteca trovaBiblioteca(long id_biblioteca){
		
		Biblioteca b = bDao.readBiblioteca(id_biblioteca);
		
		return b;
	}
	
	//Trova la Biblioteca all'interno della tabella Biblioteca del Database attraverso il suo nome
	public Biblioteca trovaBiblioteca(String nome){
		
		Biblioteca b = bDao.readBiblioteca(nome);
		
		return b;
	}
	
	//Modifica i dati della Biblioteca
	public boolean modificaBiblioteca(String nomeVecchio, String nomeNuovo){
		
		boolean res = false;
		Biblioteca b = this.trovaBiblioteca(nomeVecchio);
		b.setNome(nomeNuovo);
		res = bDao.updateBiblioteca(b);
		
		return res;
	}
	
	//Cancella la Biblioteca dalla tabella Biblioteca del Database
	public boolean cancellaBiblioteca(String nome){
		
		boolean res = false;
		Biblioteca b = this.trovaBiblioteca(nome);
		res = bDao.deleteBiblioteca(b);
		
		return res;
	}
	
	//Controlla che l'Utente e il Libro passati come parametri siano effettivamente registrati nella Biblioteca. In caso siano registrati allora
	//crea un oggetto Prestito e setta la data di inizio prestito alla data attuale. Inoltre aggiunge il Prestito alla lista pèrestiti del Libro, dell'Utente
	//e della Biblioteca, e setta all'interno dell'oggetto Prestito il Libro, l'Utente e la Biblioteca corrispondenti
	public Prestito prestaLibro(Biblioteca b, String nome, String cognome, String titolo){
		
		Utente u = uDao.readUtente(nome, cognome);
		Libro l = lDao.readLibro(titolo);
		Prestito p = null;
		
		if(u != null && l != null && l.getCopieDisponibili()>0){
			Date d = new Date();
			java.sql.Date dSql = new java.sql.Date(d.getTime());
			p = new Prestito (dSql);
			p.setBiblioteca(b);
			p.setU(u);
			p.setLibro(l);
			b.addPrestito(p);
			u.addPrestito(p);
			l.addPrestito(p);
			l.setCopieDisponibili(l.getCopieDisponibili()-1);
			uDao.updateUtente(u);
			lDao.updateLibro(l);
			bDao.updateBiblioteca(b);
		}
		
		return p;
	}
	
	//Controlla che l'Utente, il Libro e il Prestito passati come parametri effettivamente esistano. In caso affermativo setta la data di restituzione prestito
	//alla data attuale e cancella l'oggetto Prestito dalle liste prestiti di Utente, Libro e Biblioteca.
	public boolean restituisciLibro(Biblioteca b, String nome, String cognome, String titolo, long id_prestito){
		
		boolean res = false;
		Utente u = uDao.readUtente(nome, cognome);
		Libro l = lDao.readLibro(titolo);
		Prestito p = pDao.readPrestito(id_prestito);
		
		if(u != null && l != null && p!= null){
			Date d = new Date();
			java.sql.Date dSql = new java.sql.Date(d.getTime());
			p.setDataRestituzione(dSql);
			b.deletePrestito(p);
			u.deletePrestito(p);
			l.deletePrestito(p);
			l.setCopieDisponibili(l.getCopieDisponibili()+1);
			uDao.updateUtente(u);
			lDao.updateLibro(l);
			bDao.updateBiblioteca(b);
			pDao.updatePrestito(p);
			res = true;
		}
		
		return res;
	}

}
