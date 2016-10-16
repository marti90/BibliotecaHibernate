package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Prestito {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_prestito;
	
	private Date dataPrestito;
	
	@ManyToOne
	private Utente utente;
	
	@ManyToOne
	private Biblioteca biblioteca;
	
	@ManyToOne
	private Libro libro;

	public Prestito(){
		
	}
	
	public Prestito(Date dataPrestito) {
		this.dataPrestito = dataPrestito;
	}

	public long getId_prestito() {
		return id_prestito;
	}

	public void setId_prestito(long id_prestito) {
		this.id_prestito = id_prestito;
	}

	public Date getDataPrestito() {
		return dataPrestito;
	}

	public void setDataPrestito(Date dataPrestito) {
		this.dataPrestito = dataPrestito;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setU(Utente utente) {
		this.utente = utente;
	}

	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	

}
