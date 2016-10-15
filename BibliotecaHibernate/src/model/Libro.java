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
public class Libro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_libro;
	
	private String titolo;
	private String autore;
	
	@ManyToMany(mappedBy="libri",cascade=CascadeType.ALL)
	private Set<Biblioteca> bibliotecheL = new HashSet<Biblioteca>();
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="libro",cascade=CascadeType.ALL)
	private Set<Prestito> prestitiL = new HashSet<Prestito>();
	
	public Libro(){
		
	}
	
	public Libro(long id_libro, String titolo, String autore) {
		this.id_libro = id_libro;
		this.titolo = titolo;
		this.autore = autore;
	}

	public long getId_libro() {
		return id_libro;
	}

	public void setId_libro(long id_libro) {
		this.id_libro = id_libro;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public Set<Biblioteca> getBibliotecheL() {
		return bibliotecheL;
	}

	public void setBibliotecheL(Set<Biblioteca> bibliotecheL) {
		this.bibliotecheL = bibliotecheL;
	}

	public Set<Prestito> getPrestitiL() {
		return prestitiL;
	}

	public void setPrestitiL(Set<Prestito> prestitiL) {
		this.prestitiL = prestitiL;
	}
	
	public void addBiblioteca(Biblioteca b){
		this.bibliotecheL.add(b);
	}
	
	public void addPrestito(Prestito p){
		this.prestitiL.add(p);
	}

}
