package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Biblioteca {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_biblioteca;
	
	private String nome;
	
	@ManyToMany
	private Set<Utente> utenti = new HashSet<Utente>();
	
	@ManyToMany
	private Set<Libro> libri = new HashSet<Libro>();
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="biblioteca",cascade=CascadeType.ALL)
	private Set<Prestito> prestitiB = new HashSet<Prestito>();

	public Biblioteca(){
		
	}
	
	public Biblioteca(long id_biblioteca, String nome) {
		this.id_biblioteca = id_biblioteca;
		this.nome = nome;
	}

	public long getId_biblioteca() {
		return id_biblioteca;
	}

	public void setId_biblioteca(long id_biblioteca) {
		this.id_biblioteca = id_biblioteca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(Set<Utente> utenti) {
		this.utenti = utenti;
	}
	
	public Set<Libro> getLibri() {
		return libri;
	}

	public void setLibri(Set<Libro> libri) {
		this.libri = libri;
	}
	
	public Set<Prestito> getPrestitiB() {
		return prestitiB;
	}

	public void setPrestitiB(Set<Prestito> prestitiB) {
		this.prestitiB = prestitiB;
	}

	public void addUtente(Utente u){
		this.utenti.add(u);
	}
	
	public void addLibro(Libro l){
		this.libri.add(l);
	}
	
	public void addPrestito(Prestito p){
		this.prestitiB.add(p);
	}

}
