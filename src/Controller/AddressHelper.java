package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.Address;

public class AddressHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AddressBook");

	public void insertAddress(Address address) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(address);
		em.getTransaction().commit();
		em.close();
	}

	public List<Address> showAllAddresses() {
		EntityManager em = emfactory.createEntityManager();
		List<Address> allAddress = em.createQuery("SELECT a FROM address a").getResultList();
		return allAddress;
	}
	
	public void deleteAddress(Address toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Address> typedQuery = em.createQuery("select a from address a where a.addressStreet = :selectedAddressStreet and a.houseNumber = :selectedAddressHouseNumber and a.country = :selectedAddressCountry and a.city = :selectedAddressCity", Address.class);
		
		typedQuery.setParameter("selectedAddressStreet", toDelete.getStreet());
		typedQuery.setParameter("selectedAddressHouseNumber", toDelete.getHouseNumber());
		typedQuery.setParameter("selectedAddressCountry", toDelete.getCountry());
		typedQuery.setParameter("selectedAddressCity", toDelete.getCity());

		typedQuery.setMaxResults(1);
		
		Address result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Address searchForAddressById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Address found = em.find(Address.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateAddress(Address  toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Address> searchForAddressByStreet(String street) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Address> typedQuery = em.createQuery("select a from address a where a.street = :selectedAddressStreet", Address.class);
		typedQuery.setParameter("selectedAddressStreet", street);
		
		List<Address> foundAddress = typedQuery.getResultList();
		em.close();
		return foundAddress;
	}
	
	public List<Address> searchForAddressByHouseNumber(String houseNumber) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Address> typedQuery = em.createQuery("select a from address a where a.houseNumber = :selectedAddressHouseNumber", Address.class);
		typedQuery.setParameter("selectedAddressHouseNumber", houseNumber);
		
		List<Address> foundAddress= typedQuery.getResultList();
		em.close();
		return foundAddress;
	}
	public List<Address> searchForAddressByCountry(String country) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Address> typedQuery = em.createQuery("select a from address a where a.country = :selectedAddressCountry", Address.class);
		typedQuery.setParameter("selectedAddressCountry", country);
		
		List<Address> foundAddress= typedQuery.getResultList();
		em.close();
		return foundAddress;
	}
	public List<Address> searchForAddressByCity(String city) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Address> typedQuery = em.createQuery("select a from address a where a.city = :selectedAddressCity", Address.class);
		typedQuery.setParameter("selectedAddressCity", city);
		
		List<Address> foundAddress= typedQuery.getResultList();
		em.close();
		return foundAddress;
	}
	public void cleanUp() {
		emfactory.close();
	}
}
