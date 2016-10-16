package dao;

import model.Libro;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utility.HibernateUtility;

public class LibroDAO {
	
    public Libro readLibro(long id_libro){
		
		Libro l = null;
		
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			l = session.get(Libro.class, id_libro);
			
			tx.commit();
			
		}catch(Exception ex){
			tx.rollback();
			
		}finally{
			session.close();
			
		}
		
		return l;
	}
	
	public Libro readLibro(String titolo){
		
		Libro l = null;
		
		Session session = HibernateUtility.openSession();
        Transaction tx = null;
        Query query = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			query = session.createQuery("from Libro where titolo =:titoloInserito");
			query.setString("titoloInserito", titolo);
			l = (Libro) query.uniqueResult();
			
			tx.commit();
			
		}catch(Exception ex){
			tx.rollback();
			
		}finally{
			session.close();
			
		}
		
		return l;
	}
	
	public boolean createLibro(Libro l){
		
		boolean res = false;
		
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			session.persist(l);
			res= true;
			
			tx.commit();
			
		}catch(Exception ex){
			tx.rollback();
			
		}finally{
			session.close();
			
		}
		
		return res;
	}
	
	public boolean updateLibro(Libro l){

		boolean res = false;
		
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			session.update(l);
			res= true;
			
			tx.commit();
			
		}catch(Exception ex){
			tx.rollback();
			
		}finally{
			session.close();
			
		}
		
		return res;
		
	}
	
	public boolean deleteLibro(Libro l){
        
		boolean res = false;
		
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			session.delete(l);
			res= true;
			
			tx.commit();
			
		}catch(Exception ex){
			tx.rollback();
			
		}finally{
			session.close();
			
		}
		
		return res;
		
	}


}
