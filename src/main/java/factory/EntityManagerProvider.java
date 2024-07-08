package factory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EntityManagerProvider {


	private static final String PERSISTENCE_UNIT_NAME = "ExobancaStageMODELS";
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);


	private static EntityManager entityManager;

	private static EntityTransaction entityTransaction;

	private static boolean transactionIsOpen;

	private EntityManagerProvider() {

	}

	public static EntityManager getEntityManager() {
		if(entityManager == null || !entityManager.isOpen()) {
			entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
			transactionIsOpen = false;
		}
		return entityManager;
	}

	public static void beginTransaction() throws Exception {
		if(!transactionIsOpen) {
			entityTransaction = getEntityManager().getTransaction();
			entityTransaction.begin();
			transactionIsOpen = true;
		}
	}

	public static void commitTransaction() {
		if(entityTransaction != null && transactionIsOpen) {
			entityTransaction.commit();
			transactionIsOpen = false;
		}
	}

	public static void rollbackTransaction() {
		if(entityTransaction != null && transactionIsOpen) {
			entityTransaction.rollback();
			transactionIsOpen = false;
		}
	}

	public static boolean isTransactionOpen() {
		return transactionIsOpen;
	}
}