import model.Utente;
import service.Gestione;


public class MainEsempio {

	public static void main(String[] args) {
		
		Gestione g = new Gestione();
		
		//System.out.println("L'utente è stato aggiunto? "+g.aggiungiUtente("Martina", "Debernardi", "DBRMTN90A"));
		
		Utente u = g.leggiUtente(2);
		
		System.out.print(u.getNome()+" "+u.getCognome());

	}

}
