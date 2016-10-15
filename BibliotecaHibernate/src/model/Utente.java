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
public class Utente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_utente;
	
	private String nome;
	private String cognome;
	private String cf;
	
	@ManyToMany(mappedBy="utenti",cascade=CascadeType.ALL)
	private Set<Biblioteca> bibliotecheU = new HashSet<Biblioteca>();
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="utente",cascade=CascadeType.ALL)
	private Set<Prestito> prestitiU = new HashSet<Prestito>();
	
	public Utente(){
		
	}
	
	public Utente(String nome, String cognome, String cf) {
		this.nome = nome;
		this.cognome = cognome;
		this.cf = cf;
	}

	public long getId_utente() {
		return id_utente;
	}

	public void setId_utente(long id_utente) {
		this.id_utente = id_utente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}
	
	public Set<Biblioteca> getBibliotecheU() {
		return bibliotecheU;
	}

	public void setBibliotecheU(Set<Biblioteca> bibliotecheU) {
		this.bibliotecheU = bibliotecheU;
	}

	public Set<Prestito> getPrestitiU() {
		return prestitiU;
	}

	public void setPrestitiU(Set<Prestito> prestitiU) {
		this.prestitiU = prestitiU;
	}

	public void addBiblioteca(Biblioteca b){
		this.bibliotecheU.add(b);
	}
	
	public void addPrestito(Prestito p){
		this.prestitiU.add(p);
	}

}
