package model.entities.controllers;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import model.entities.Fabricante;

public class ControladorFabricante {

	private static ControladorFabricante instance = null;
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("TutorialJavaCochesJPA"); 
	
	/**
	 * 
	 * @return
	 */
	public static ControladorFabricante getInstance () {
		if (instance == null) {
			instance = new ControladorFabricante();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public ControladorFabricante() {
	}
	
	
	public Fabricante find(int id) {
		Fabricante fab = null;
		EntityManager em = factory.createEntityManager();
		fab = (Fabricante) em.find(Fabricante.class, id);
		em.close();
		return fab;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Fabricante findPrimero () {
		Fabricante fab = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.fabricante order by id limit 1", Fabricante.class);
		fab = (Fabricante) q.getSingleResult();
		em.close();
		
		return fab;
	}
	

	/**
	 * 
	 * @return
	 */
	public Fabricante findUltimo () {
		Fabricante fab = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.fabricante order by id desc limit 1", Fabricante.class);
		fab = (Fabricante) q.getSingleResult();
		em.close();
		
		return fab;
	}
	

	/**
	 * 
	 * @return
	 */
	public Fabricante findSiguiente (int idActual) {
		Fabricante fab = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.fabricante where id > ? order by id limit 1", Fabricante.class);
		q.setParameter(1, idActual);
		fab = (Fabricante) q.getSingleResult();
		em.close();
		
		return fab;
	}
	

	/**
	 * 
	 * @return
	 */
	public Fabricante findAnterior (int idActual) {
		Fabricante fab = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.fabricante where id < ? order by id desc limit 1", Fabricante.class);
		q.setParameter(1, idActual);
		fab = (Fabricante) q.getSingleResult();
		em.close();
		
		return fab;		
	}
	

	
	/**
	 * 
	 * @return
	 */
	public boolean guardar (Fabricante fab) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (fab.getId() == 0) {
				em.persist(fab);
			}
			else {
				em.merge(fab);
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


	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public void borrar(Fabricante fab) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.remove(fab);
		em.getTransaction().commit();
		em.close();
	}

	
	/**
	 * 
	 * @return
	 */
	public List<Fabricante> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM fabricante", Fabricante.class);
		
		List<Fabricante> list = (List<Fabricante>) q.getResultList();
		em.close();
		return list;
	}
	

}

