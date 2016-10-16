package dao;

import model.Prestito;

import org.hibernate.Session;
import org.hibernate.Transaction;

import utility.HibernateUtility;

public class PrestitoDAO {
	
    public Prestito readPrestito(long id_prestito){
		
    	Prestito p = null;
		
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			p = session.get(Prestito.class, id_prestito);
			
			tx.commit();
			
		}catch(Exception ex){
			tx.rollback();
			
		}finally{
			session.close();
			
		}
		
		return p;
	}
	
	public boolean createPrestito(Prestito p){
		
		boolean res = false;
		
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			session.persist(p);
			res= true;
			
			tx.commit();
			
		}catch(Exception ex){
			tx.rollback();
			
		}finally{
			session.close();
			
		}
		
		return res;
	}
    
	public boolean updatePrestito(Prestito p){

		boolean res = false;
		
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			session.update(p);
			res= true;
			
			tx.commit();
			
		}catch(Exception ex){
			tx.rollback();
			
		}finally{
			session.close();
			
		}
		
		return res;
		
	}
	
    public boolean deletePrestito(Prestito p){
        
		boolean res = false;
		
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			session.delete(p);
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
