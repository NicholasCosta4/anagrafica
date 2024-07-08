//package it.exolab.login.dao;
//
//import java.util.List;
//
//import org.bson.Document;
//import org.bson.types.ObjectId;
//
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//
//import factory.EntityManagerProvider;
//import io.quarkus.mongodb.panache.PanacheMongoRepository;
//import it.exolab.login.models.Utente;
//import jakarta.persistence.NoResultException;
//import jakarta.persistence.TypedQuery;
//
//public class UtenteMongoDao implements PanacheMongoRepository<Utente> {
//
//	private MongoClient mongoClient = MongoClients
//			.create(System.getProperty("mongodb://localhost:27017/anagrafica?authSource = admin"));
//	private MongoDatabase sampleTrainingDB = mongoClient.getDatabase("anagrafica");
//	private MongoCollection<Document> gradesCollection = sampleTrainingDB.getCollection("utente");
//
//	public List<Utente> findAllUtentiMongo() throws Exception {
//		System.out.println("\tsono nel crud di findAllUtenti");
//
//		try {
//
//			return EntityManagerProvider.getEntityManager()
//					.createQuery("SELECT u FROM Utente u WHERE u.idRuolo = :idRuolo", Utente.class)
//					.setParameter("idRuolo", 2).getResultList();
//
//		} catch (Exception e) {
//
//			System.out.println("Eccezione Nel Crud Utente ");
//			e.printStackTrace();
//			throw new Exception();
//		}
//	}
//
//	public Utente insertUtenteMongo(Utente utente) throws Exception {
//
//		Document utenteDaInserire = new Document("_id", new ObjectId());
//		utenteDaInserire.append("nome", utente.getNome()).append("cognome", utente.getCognome())
//				.append("email", utente.getEmail()).append("password", utente.getPassword());
//		gradesCollection.insertOne(utenteDaInserire);
//
//		return utente;
//
//	}
//
//	public Utente findByEmailAndPasswordMongo(Utente utente) throws Exception {
//		System.out.println("\tsono nel crud di findByEmailAndPassword");
//
//		Utente utenteDaRestituire = new Utente();
//		try {
//			TypedQuery<Utente> query = EntityManagerProvider.getEntityManager()
//					.createQuery("SELECT u FROM Utente u WHERE u.email = :email AND u.password = :password",
//							Utente.class)
//					.setParameter("email", utente.getEmail()).setParameter("password", utente.getPassword());
//			return utenteDaRestituire = query.getSingleResult();
//
//		} catch (NoResultException ex) {
//			return utenteDaRestituire;
//
//		} catch (Exception e) {
//			System.out.println("Eccezione Nel Crud Utente ");
//			e.printStackTrace();
//			throw new Exception();
//		}
//	}
//
//	public Utente updateUtenteMongo(Utente utente) throws Exception {
//		System.out.println("\tsono nel crud di updateUtente");
//
//		try {
//			if (null == utente.getIdUtente()) {
//
//				return utente = null;
//			} else {
//
//				utente = EntityManagerProvider.getEntityManager().merge(utente);
//				return utente;
//			}
//		} catch (Exception e) {
//
//			e.printStackTrace();
//			System.out.println("Errore nel Crud Utente");
//			throw new Exception();
//		}
//	}
//
//	public Utente findByIdMongo(Integer id) {
//		System.out.println("\tsono nel crud di findById");
//
//		try {
//
//			return (Utente) EntityManagerProvider.getEntityManager()
//					.createQuery("SELECT u From Utente u WHERE u.idUtente = :id").setParameter("id", id)
//					.getSingleResult();
//
//		} catch (NoResultException e) {
//
//			return new Utente();
//		}
//	}
//
//}
