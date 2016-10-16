package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utility.HibernateUtility;
import model.Utente;

public class UtenteDAO {
	
	//CREATE
	public boolean createUtente(Utente u){
			
		boolean res = false;
			
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
			
		try{
			tx = session.getTransaction();
			tx.begin();
				
			session.persist(u);
			
			tx.commit();
			res= true;
			
		}catch(Exception ex){
			tx.rollback();
				
		}finally{
			session.close();
				
		}
			
		return res;
	}
		
	//READ con id
	public Utente readUtente(long id_utente){
		
		Utente u = null;
		
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			u = session.get(Utente.class, id_utente);
			
			tx.commit();
			
		}catch(Exception ex){
			tx.rollback();
			
		}finally{
			session.close();
			
		}
		
		return u;
	}
	
	//READ con nome e cognome
	public Utente readUtente(String nome, String cognome){
		
		Utente u = null;
		
		Session session = HibernateUtility.openSession();
        Transaction tx = null;
        Query query = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			query = session.createQuery("from Utente where nome =:nomeInserito and cognome =:cognomeInserito");
			query.setString("nomeInserito", nome);
			query.setString("cognomeInserito", cognome);
			u = (Utente) query.uniqueResult();
			
			tx.commit();
			
		}catch(Exception ex){
			tx.rollback();
			
		}finally{
			session.close();
			
		}
		
		return u;
	}
	
	//UPDATE
	public boolean updateUtente(Utente u){

		boolean res = false;
		
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			session.update(u);
			
			tx.commit();
			res= true;
			
			
		}catch(Exception ex){
			tx.rollback();
			
		}finally{
			session.close();
			
		}
		
		return res;
		
	}
	
	//DELETE
	public boolean deleteUtente(Utente u){
        
		boolean res = false;
		
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			session.delete(u);
			
			tx.commit();
			res= true;
			
		}catch(Exception ex){
			tx.rollback();
			
		}finally{
			session.close();
			
		}
		
		return res;
		
	}

}
