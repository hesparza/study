/*
 */

package Model.dao.pojo;

import Model.Item;
import Model.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 * Data Access Object implementation for persistent
 * class {@see Model.Item}.
 * @author education@oracle.com
 */
public class UserDAO extends GenericDAO<User> {

  /**
   * Adds a new User to the persistent store.
   * If <code>em</code> is not <code>null</code>, the function
   * assumes that the caller has already begun a transaction, and that the
   * caller will commit/rollback as appropriate.
   * @param em EntityManager associated to the persistence context to use
   * or null if this is an atomic operation.
   * @param username username for new User
   * @param email email for new User
   * @return newly created persistent User.
   * If the function had to create its own persistence context, the
   * return instance will be detached, as its persistence context will
   * have disappeared by the time the function returns.
   */
  public
  User add(EntityManager em,
           String username, String email) {
    return add( em, new User( username, email ) );
  }

  /**
   * Returns a list of all users currently in the persistent store.
   * @param em EntityManager associated to the persistence context to use
   * or null if this is an atomic operation.
   * @return list of Users in the persistent store.
   */
  public List<User> getAll(EntityManager em) {
    EntityTransaction tx = null;
    if (em == null) {
      em = getEMF().createEntityManager();
      tx = em.getTransaction();
    }
    if (tx != null) tx.begin();
    String sqlQuery = "SELECT u from User u";
    TypedQuery<User> query =
      em.createQuery(sqlQuery, User.class);
    List<User> results = query.getResultList();
    if (tx != null) {
      tx.commit();
      em.close();
    }
    return results;
  }
}
