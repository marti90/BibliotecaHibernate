import model.Utente;
import service.Gestione;


public class MainEsempio {

	public static void main(String[] args) {
		
		Gestione g = new Gestione();
		
		//System.out.println("L'utente è stato aggiunto? "+g.aggiungiUtente("Martina", "Debernardi", "DBRMTN90A"));
		
		Utente u = g.leggiUtente("Marti", "Debe");
		
		System.out.print(u.getCf());
		
		//g.modificaUtente(1, "Marti", "Debe", "MRTDB");
		
		System.out.println("L'utente è stato cancellato? "+g.cancellaUtente("Marti", "Debe"));
		
		

	}

}
