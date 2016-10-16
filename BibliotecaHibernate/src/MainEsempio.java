

import model.Biblioteca;
import model.Utente;
//import model.Utente;
import service.Gestione;


public class MainEsempio {

	public static void main(String[] args) {
		
		Gestione g = new Gestione();
		
		//System.out.println("L'utente è stato aggiunto? "+g.aggiungiUtente("Martina", "Debernardi", "DBRMTN90A"));
		
		//Utente u = g.leggiUtente("Marti", "Debe");
		
		//System.out.print(u.getCf());
		
		//g.modificaUtente(1, "Marti", "Debe", "MRTDB");
		
		Biblioteca b = g.aggiungiBiblioteca("Biblioteca Politecnico");
		Biblioteca b1 = g.aggiungiBiblioteca("Biblioteca Ciriè");
		
		//System.out.println("L'utente è stato cancellato? "+g.cancellaUtente(b, "Marti", "Debe"));
		
		g.registraUtente(b, "Martina", "Debernardi", "DBRMTN90A");
		g.registraUtente(b, "Luca", "Umoretto", "MRTLCA90C");
		g.registraUtente(b1, "Irene", "Aimone", "MNERNE90B");
		
		g.registraLibro(b, "Cent'anni di solitudine", "Gabriel Garcia Marquez",2);
		g.registraLibro(b, "Delitto e castigo", "Fedor Dostoevskij",5);
		g.registraLibro(b, "Anna Karenina", "Lev Tolstoj",1);
		g.registraLibro(b1, "Il processo", "Franz Kafka",2);
		
		g.prestaLibro(b, "Martina", "Debernardi", "Delitto e castigo");
		
		for(Utente u : b.getUtenti()){
			System.out.println(u.getNome()+" "+u.getCognome());
		}
		
	}

}
