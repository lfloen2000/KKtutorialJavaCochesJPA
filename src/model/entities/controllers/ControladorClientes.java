package model.entities.controllers;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Cliente;

public class ControladorClientes {
	
	private static ControladorClientes instance = null;
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("TutorialJavaCochesJPA");
	
	/**
	 * 
	 * @return
	 */
	public static ControladorClientes getInstance () {
		if (instance == null) {
			instance = new ControladorClientes();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public ControladorClientes() {
		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = (Connection) DriverManager.getConnection ("jdbc:mysql://localhost/tutorialjavacoches?serverTimezone=UTC","java", "1234");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		   

	}
	
	
	/**
	 * 
	 * @return
	 */
	public Cliente findPrimero () {
		Cliente cli = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.cliente order by id limit 1", Cliente.class);
		cli = (Cliente) q.getSingleResult();
		em.close();
		
		return cli;
	}
	

	/**
	 * 
	 * @return
	 */
	public Cliente findUltimo () {
		Cliente cli = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.cliente order by id desc limit 1", Cliente.class);
		cli = (Cliente) q.getSingleResult();
		em.close();
		
		return cli;
	}
	

	/**
	 * 
	 * @return
	 */
	public Cliente findSiguiente (int idActual) {
		Cliente cli = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.cliente where id > ? order by id limit 1", Cliente.class);
		q.setParameter(1, idActual);
		cli = (Cliente) q.getSingleResult();
		em.close();
		
		return cli;
	}
	

	/**
	 * 
	 * @return
	 */
	public Cliente findAnterior (int idActual) {
		Cliente cli = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.cliente where id < ? order by id desc limit 1", Cliente.class);
		q.setParameter(1, idActual);
		cli = (Cliente) q.getSingleResult();
		em.close();
		
		return cli;		
	}
	

	
	/**
	 * 
	 * @return
	 */
	public boolean guardar (Cliente cli) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (cli.getId() == 0) {
				em.persist(cli);
			}
			else {
				em.merge(cli);
			}
			em.getTransaction().commit();
			em.close();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

}
