import model.Biblioteca;
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
		
		//System.out.println("L'utente è stato cancellato? "+g.cancellaUtente(b, "Marti", "Debe"));
		
		g.aggiungiUtente(b, "Martina", "Debernardi", "DBRMTN90A");
		g.aggiungiUtente(b, "Luca", "Umoretto", "MRTLCA90C");
		g.aggiungiUtente(b, "Irene", "Aimone", "MNERNE90B");
		
		g.aggiungiLibro(b, "Cent'anni di solitudine", "Gabriel Garcia Marquez");
		g.aggiungiLibro(b, "Delitto e castigo", "Fedor Dostoevskij");
		g.aggiungiLibro(b, "Anna Karenina", "Lev Tolstoj");
		g.aggiungiLibro(b, "Il processo", "Franz Kafka");

	}

}
