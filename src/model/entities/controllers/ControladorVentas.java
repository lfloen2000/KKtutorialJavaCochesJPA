package model.entities.controllers;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import model.entities.Venta;


public class ControladorVentas {

	private static ControladorVentas instance = null;
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("TutorialJavaCochesJPA");
	
	/**
	 * 
	 * @return
	 */
	public static ControladorVentas getInstance () {
		if (instance == null) {
			instance = new ControladorVentas();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public ControladorVentas() {
		
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
	public Venta findPrimero () {
		Venta v = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.venta order by id limit 1", Venta.class);
		v = (Venta) q.getSingleResult();
		em.close();
		
		return v;
	}
	

	/**
	 * 
	 * @return
	 */
	public Venta findUltimo () {
		Venta v = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.venta order by id desc limit 1", Venta.class);
		v = (Venta) q.getSingleResult();
		em.close();
		
		return v;
	}
	

	/**
	 * 
	 * @return
	 */
	public Venta findSiguiente (int idActual) {
		Venta c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.venta where id > ? order by id limit 1", Venta.class);
		q.setParameter(1, idActual);
		c = (Venta) q.getSingleResult();
		em.close();
		
		return c;
	}
	

	/**
	 * 
	 * @return
	 */
	public Venta findAnterior (int idActual) {
		Venta c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.venta where id < ? order by id desc limit 1", Venta.class);
		q.setParameter(1, idActual);
		c = (Venta) q.getSingleResult();
		em.close();
		
		return c;		
	}
	

	
	/**
	 * 
	 * @return
	 */
	public boolean guardar (Venta v) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (v.getId() == 0) {
				em.persist(v);
			}
			else {
				em.merge(v);
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
	public void borrar(Venta v) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.remove(v);
		em.getTransaction().commit();
		em.close();
	}
}
