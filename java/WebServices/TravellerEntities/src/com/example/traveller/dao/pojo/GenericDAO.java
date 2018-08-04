/*
 */

package com.example.traveller.dao.pojo;

import com.example.traveller.model.DomainEntity;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Generic DAO implementation which supports basic operations for
 * classes derived from com.example.traveller.model.DomainEntity.
 * The implementation used only supports classes that are direct
 * children of this class (see {@see #returnedClass} for an explanation).
 * @param <PersistentClass> type of DomainEntity to be supported in
 * a given child class.
 * @author education@oracle.com
 */
public abstract
class GenericDAO<PersistentClass extends DomainEntity> {

  private static final EntityManagerFactory emf =
    Persistence.createEntityManagerFactory( "TravellerEntitiesPU" );

  /**
   * Returns global singleton EntityManagerFactory for persistent unit
   * named "TravellerEntitiesPU".
   * @return singleton EntityManagerFactory
   */
  public static EntityManagerFactory getEMF() {
    return emf;
  }

  /**
   * Inserts instance into persistent store.
   * If <code>em</code> is <code>null</code>, the call will create its own
   * local <code>EntityManager</code> and persistent context, and will
   * use a local transaction to perform the insert.
   * If <code>em</code> is not <code>null</code>, the function
   * assumes that the caller has already begun a transaction, and that the
   * caller will commit/rollback as appropriate.
   * @param em EntityManager associated with persistent context to use
   * @param newObj instance to insert into persistent store
   * @return the instance inserted into persistent store
   */
  public PersistentClass add(EntityManager em,
                                  PersistentClass newObj) {
    EntityTransaction tx = null;
    if (em == null) {
      em = getEMF().createEntityManager();
      tx = em.getTransaction();
    }
    if (tx != null) tx.begin();
    em.persist( newObj );
    if (tx != null) {
      tx.commit();
      em.close();
    }
    return newObj;
  }

  /**
   * Updates the persistent store representation of the instance provided.
   * If <code>em</code> is <code>null</code>, the call will create its own
   * local <code>EntityManager</code> and persistent context, and will
   * use a local transaction to perform the insert.
   * The instance to update must be one of:
   * <ul>
   *   <li> a persistent instance in the current persistence context
   *        (in which case the call is redundant)
   *   <li> a detached instance, with a valid id and updated values
   *   <li> a transient instance, with a valid id and updated values
   * </ul>
   * If the instance provided is persistent in the current persistence
   * context, it is returned.  Otherwise, a new persistent instance
   * with updated values is returned.
   * If <code>em</code> is not <code>null</code>, the function
   * assumes that the caller has already begun a transaction, and that the
   * caller will commit/rollback as appropriate.
   * If the function had to create its own persistence context, the
   * return instance will be detached, as its persistence context will
   * have disappeared by the time the function returns.
   * @param em EntityManager associated with persistent context to use
   * @param instance instance to update.
   * @return an updated persistent instance
   */
  public PersistentClass update( EntityManager em,
                                 PersistentClass instance ) {
    EntityTransaction tx = null;
    if (em == null) {
      em = getEMF().createEntityManager();
      tx = em.getTransaction();
    }
    if (tx != null) tx.begin();
    PersistentClass result = em.merge( instance );
    if (tx != null) {
      tx.commit();
      em.close();
    }
    return result;
  }

  /**
   * Finds a persistent instance, given its unique id.
   * If <code>em</code> is <code>null</code>, the call will create its own
   * local <code>EntityManager</code> and persistent context, and will
   * use a local transaction to perform the insert.
   * If <code>em</code> is not <code>null</code>, the function
   * assumes that the caller has already begun a transaction, and that the
   * caller will commit/rollback as appropriate.
   * If the function had to create its own persistence context, the
   * return instance will be detached, as its persistence context will
   * have disappeared by the time the function returns.   
   * @param em EntityManager associated with persistent context to use
   * @param id unique id for instance to return
   * @return persistent instance identified by id provided
   */
  public PersistentClass find( EntityManager em, long id ) {
    EntityTransaction tx = null;
    if (em == null) {
      em = getEMF().createEntityManager();
      tx = em.getTransaction();
    }
    if (tx != null) tx.begin();
    PersistentClass result = em.find( returnedClass(), id );
    if (tx != null) {
      tx.commit();
      em.close();
    }
    return result;
  }

  /**
   * Finds all persistent instances that match the query provided.
   * If <code>em</code> is <code>null</code>, the call will create its own
   * local <code>EntityManager</code> and persistent context, and will
   * use a local transaction to perform the insert.
   * If <code>em</code> is not <code>null</code>, the function
   * assumes that the caller has already begun a transaction, and that the
   * caller will commit/rollback as appropriate.
   * If the function had to create its own persistence context, the
   * return value will consist of detached instances, as their persistence
   * context will have disappeared by the time the function returns.
   * @param em EntityManager associated with persistent context to use
   * @param jpaQL JPA QL query to execute
   * @return list of persistent instances that match the query provided
   */
  public List<PersistentClass> query( EntityManager em, String jpaQL ) {
    EntityTransaction tx = null;
    if (em == null) {
      em = getEMF().createEntityManager();
      tx = em.getTransaction();
    }
    if (tx != null) tx.begin();
    TypedQuery<PersistentClass> query =
            em.createQuery( jpaQL, returnedClass() );
    List<PersistentClass> result = query.getResultList();
    if (tx != null) {
      tx.commit();
      em.close();
    }
    return result;
  }

  /**
   * Removes an instance from the persistent store, given its unique it.
   * If <code>em</code> is <code>null</code>, the call will create its own
   * local <code>EntityManager</code> and persistent context, and will
   * use a local transaction to perform the insert.
   * If <code>em</code> is not <code>null</code>, the function
   * assumes that the caller has already begun a transaction, and that the
   * caller will commit/rollback as appropriate.  
   * @param em EntityManager associated with persistent context to use
   * @param id unique id of persistent instance to remove
   */
  public void remove( EntityManager em, long id ) {
    EntityTransaction tx = null;
    if (em == null) {
      em = getEMF().createEntityManager();
      tx = em.getTransaction();
    }
    if (tx != null) tx.begin();
    em.remove( em.getReference( returnedClass(), id ));
    if (tx != null) {
      tx.commit();
      em.close();
    }
  }

  /**
   * Removes the instance provided from the persistent store.
   * If <code>em</code> is <code>null</code>, the call will create its own
   * local <code>EntityManager</code> and persistent context, and will
   * use a local transaction to perform the insert.
   * If <code>em</code> is not <code>null</code>, the function
   * assumes that the caller has already begun a transaction, and that the
   * caller will commit/rollback as appropriate.  
   * @param em EntityManager associated with persistent context to use
   * @param instance to remove
   */
  public void remove( EntityManager em, PersistentClass instance ) {
    EntityTransaction tx = null;
    if (em == null) {
      em = getEMF().createEntityManager();
      tx = em.getTransaction();
    }
    if (tx != null) tx.begin();
    em.remove( instance );
    if (tx != null) {
      tx.commit();
      em.close();
    }
  }

  /**
   * Returns the parameterized type used when extending directly from
   * this generic class, as an instance of class Class.  This return
   * value can be used when such an instance is needed by Java API methods,
   * such as those in javax.persistance.EntityManager.
   * The trick used here will only work when the child class directly
   * extends this one.  A complete discussion of this trick can be found
   * here:
   * http://www.artima.com/weblogs/viewpost.jsp?thread=208860
   * @return parameterized type used to instance class, as an instance of
   * class Class.
   */
  @SuppressWarnings("unchecked")
  protected Class<PersistentClass> returnedClass() {
      ParameterizedType parameterizedType =
        (ParameterizedType) getClass().getGenericSuperclass();
     return (Class<PersistentClass>)
             (parameterizedType.getActualTypeArguments()[0]);
    }

  /**
   *
   */
  public static class QueryException extends RuntimeException {
    private static final long serialVersionUID = 0L;
  }

}
