package dao;

import model.Biblioteca;

import org.hibernate.Session;
import org.hibernate.Transaction;

import utility.HibernateUtility;

public class BibliotecaDAO {
	
    public boolean createBiblioteca(Biblioteca b){
		
		boolean res = false;
		
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			session.persist(b);
			res= true;
			
			tx.commit();
			
		}catch(Exception ex){
			tx.rollback();
			
		}finally{
			session.close();
			
		}
		
		return res;
	}
    
	public boolean updateBiblioteca(Biblioteca b){

		boolean res = false;
		
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			session.update(b);
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
