package dao;

import model.Biblioteca;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utility.HibernateUtility;

public class BibliotecaDAO {
	
    public Biblioteca readBiblioteca(long id_biblioteca){
		
		Biblioteca b = null;
		
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			b = session.get(Biblioteca.class, id_biblioteca);
			
			tx.commit();
			
		}catch(Exception ex){
			tx.rollback();
			
		}finally{
			session.close();
			
		}
		
		return b;
	}
	
	public Biblioteca readBiblioteca(String nome){
		
		Biblioteca b = null;
		
		Session session = HibernateUtility.openSession();
        Transaction tx = null;
        Query query = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			query = session.createQuery("from Biblioteca where nome =:nomeInserito");
			query.setString("nomeInserito", nome);
			b = (Biblioteca) query.uniqueResult();
			
			tx.commit();
			
		}catch(Exception ex){
			tx.rollback();
			
		}finally{
			session.close();
			
		}
		
		return b;
	}
	
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
	
    public boolean deleteBiblioteca(Biblioteca b){
        
		boolean res = false;
		
		Session session = HibernateUtility.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			session.delete(b);
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
