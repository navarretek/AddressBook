package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.address;

public class AddressHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AddressBook");

	public void insertAddress(address address) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(address);
		em.getTransaction().commit();
		em.close();
	}

	public List<address> showAllAddresses() {
		EntityManager em = emfactory.createEntityManager();
		List<address> allAddress = em.createQuery("SELECT a FROM address a").getResultList();
		return allAddress;
	}
	
	public void deleteAddress(address toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<address> typedQuery = em.createQuery("select a from address a where a.addressStreet = :selectedAddressStreet and a.houseNumber = :selectedAddressHouseNumber and a.country = :selectedAddressCountry and a.city = :selectedAddressCity", address.class);
		
		typedQuery.setParameter("selectedAddressStreet", toDelete.getStreet());
		typedQuery.setParameter("selectedAddressHouseNumber", toDelete.getHouseNumber());
		typedQuery.setParameter("selectedAddressCountry", toDelete.getCountry());
		typedQuery.setParameter("selectedAddressCity", toDelete.getCity());

		typedQuery.setMaxResults(1);
		
		address result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public address searchForAddressById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		address found = em.find(address.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateAddress(address  toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<address> searchForAddressByStreet(String street) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<address> typedQuery = em.createQuery("select a from address a where a.street = :selectedAddressStreet", address.class);
		typedQuery.setParameter("selectedAddressStreet", street);
		
		List<address> foundAddress = typedQuery.getResultList();
		em.close();
		return foundAddress;
	}
	
	public List<address> searchForAddressByHouseNumber(String houseNumber) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<address> typedQuery = em.createQuery("select a from address a where a.houseNumber = :selectedAddressHouseNumber", address.class);
		typedQuery.setParameter("selectedAddressHouseNumber", houseNumber);
		
		List<address> foundAddress= typedQuery.getResultList();
		em.close();
		return foundAddress;
	}
	public List<address> searchForAddressByCountry(String country) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<address> typedQuery = em.createQuery("select a from address a where a.country = :selectedAddressCountry", address.class);
		typedQuery.setParameter("selectedAddressCountry", country);
		
		List<address> foundAddress= typedQuery.getResultList();
		em.close();
		return foundAddress;
	}
	public List<address> searchForAddressByCity(String city) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<address> typedQuery = em.createQuery("select a from address a where a.city = :selectedAddressCity", address.class);
		typedQuery.setParameter("selectedAddressCity", city);
		
		List<address> foundAddress= typedQuery.getResultList();
		em.close();
		return foundAddress;
	}
	public void cleanUp() {
		emfactory.close();
	}
}
