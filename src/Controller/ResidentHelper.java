package Controller;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.Resident;


public class ResidentHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AddressBook");

	public void insertResident(Resident res) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(res);
		em.getTransaction().commit();
		em.close();
	}

	public List<Resident> showAllResidents() {
		EntityManager em = emfactory.createEntityManager();
		List<Resident> allResidents = em.createQuery("SELECT r FROM resident r").getResultList();
		return allResidents;
	}
	
	public void deleteResident(Resident toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Resident> typedQuery = em.createQuery("select r from resident r where r.residentName = :selectedResidentName and r.dateOfBirth = :selectedDateOfBirth ", Resident.class);
		
		typedQuery.setParameter("selectedResidentName", toDelete.getName());
		typedQuery.setParameter("selectedDateOfBirth", toDelete.getDob());

		typedQuery.setMaxResults(1);
		
		Resident result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Resident searchForResidentById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Resident found = em.find(Resident.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateResident(Resident  toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Resident> searchForResidentByName(String name) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Resident> typedQuery = em.createQuery("select r from resident r where r.residentName = :selectedResidentName", Resident.class);
		typedQuery.setParameter("selectedResidentName", name);
		
		List<Resident> foundResidents = typedQuery.getResultList();
		em.close();
		return foundResidents;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
