package model.entities.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Concesionario;

public class ControladorConcesionario {

	private static ControladorConcesionario instance = null;
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("TutorialJavaCochesJPA");
	
	/**
	 * 
	 * @return
	 */
	public static ControladorConcesionario getInstance () {
		
		if (instance == null) {
			instance = new ControladorConcesionario();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public ControladorConcesionario() {
		
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
	public Concesionario findPrimero () {
		Concesionario con = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.concesionario order by id limit 1", Concesionario.class);
		con = (Concesionario) q.getSingleResult();
		em.close();
		
		return con;
	}
	

	/**
	 * 
	 * @return
	 */
	public Concesionario findUltimo () {
		Concesionario con = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.concesionario order by id desc limit 1", Concesionario.class);
		con = (Concesionario) q.getSingleResult();
		em.close();
		
		return con;
	}
	

	/**
	 * 
	 * @return
	 */
	public Concesionario findSiguiente (int idActual) {
		Concesionario con = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.concesionario where id > ? order by id limit 1", Concesionario.class);
		q.setParameter(1, idActual);
		con = (Concesionario) q.getSingleResult();
		em.close();
		
		return con;
	}
	

	/**
	 * 
	 * @return
	 */
	public Concesionario findAnterior (int idActual) {
		Concesionario con = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.concesionario where id < ? order by id desc limit 1", Concesionario.class);
		q.setParameter(1, idActual);
		con = (Concesionario) q.getSingleResult();
		em.close();
		
		return con;		
	}
	

	
	/**
	 * 
	 * @return
	 */
	public boolean guardar (Concesionario con) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (con.getId() == 0) {
				em.persist(con);
			}
			else {
				em.merge(con);
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
