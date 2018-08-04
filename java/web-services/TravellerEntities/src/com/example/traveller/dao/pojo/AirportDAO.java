/*
 */

package com.example.traveller.dao.pojo;

import com.example.traveller.model.Airport;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 * Data Access Object implementation for persistent
 * class {@see com.example.traveller.model.Airport}.
 * @author education@oracle.com
 */
public class AirportDAO extends GenericDAO<Airport> {

  /**
   * Adds a new Airport to the persistent store.
   * If <code>em</code> is not <code>null</code>, the function
   * assumes that the caller has already begun a transaction, and that the
   * caller will commit/rollback as appropriate.
   * @param em EntityManager associated to the persistence context to use
   * @param code airport code for new Airport
   * @param name airport name for new Airport
   * @return newly created persistent Airport.
   * If the function had to create its own persistence context, the
   * return instance will be detached, as its persistence context will
   * have disappeared by the time the function returns.
   */
  public 
  Airport add(EntityManager em,String code,String name) {
    return add( em, new Airport( code, name ) );
  }

  /**
   * Find a persistent Airport instance by its airport code.
   * If <code>em</code> is not <code>null</code>, the function
   * assumes that the caller has already begun a transaction, and that the
   * caller will commit/rollback as appropriate.
   * @param em EntityManager associated to the persistence context to use
   * @param code airport code for Airport to be found
   * @return persistent Airport by given code.
   * If the function had to create its own persistence context, the
   * return instance will be detached, as its persistence context will
   * have disappeared by the time the function returns.
   */
  public Airport findByCode(EntityManager em, String code) {
    EntityTransaction tx = null;
    if (em == null) {
      em = getEMF().createEntityManager();
      tx = em.getTransaction();
    }
    if (tx != null) tx.begin();
    String sqlQuery =
      "SELECT a from Airport a WHERE a.code = :code";
    TypedQuery<Airport> query =
      em.createQuery(sqlQuery, Airport.class);
    query.setParameter( "code", code );
    List<Airport> results = query.getResultList();
    if (tx != null) {
      tx.commit();
      em.close();
    }
    if (results.size() != 1)
      throw new QueryException();
    return results.get(0);
  }

  public Airport[] findByName( EntityManager em, String name ) {
    EntityTransaction tx = null;
    if (em == null) {
      em = getEMF().createEntityManager();
      tx = em.getTransaction();
    }
    if (tx != null) tx.begin();
    TypedQuery<Airport> query =
      em.createQuery( "SELECT a FROM Airport a WHERE a.name LIKE :name", Airport.class );
    query.setParameter( "name", "%" + name + "%" );
    List<Airport> results = query.getResultList();
    if (tx != null) {
      tx.commit();
      em.close();
    }
    return results.toArray( new Airport[0] );
  }

  /**
   * Removes the persistent Airport instance by the given code.
   * If <code>em</code> is not <code>null</code>, the function
   * assumes that the caller has already begun a transaction, and that the
   * caller will commit/rollback as appropriate.
   * @param em EntityManager associated to the persistence context to use
   * @param code airport code for persistent Airport instance to remove
   */
  public void removeByCode(EntityManager em, String code) {
    EntityTransaction tx = null;
    if (em == null) {
      em = getEMF().createEntityManager();
      tx = em.getTransaction();
    }
    if (tx != null) tx.begin();
    remove( em, findByCode(em, code));
    if (tx != null) {
      tx.commit();
      em.close();
    }
  }

  public Airport[] findNeighbors( EntityManager em, String code ) {
    EntityTransaction tx = null;
    if (em == null) {
      em = getEMF().createEntityManager();
      tx = em.getTransaction();
    }
    String sqlQuery =
      "SELECT DISTINCT f.arrives FROM Flight f WHERE f.departs.code = :source";
    TypedQuery<Airport> query = em.createQuery( sqlQuery, returnedClass() );
    query.setParameter( "source", code );
    if (tx != null) tx.begin();
    List<Airport> neighbors = query.getResultList();
    if (tx != null) {
      tx.commit();
      em.close();
    }
    return neighbors.toArray( new Airport[0] );
  }

  /**
   * Retrieves all airport codes known.
   * @param em - EntityManager to use for operation, if known
   * @return list of airport codes known, as Strings
   */
  public List<String> getAllCodes( EntityManager em ) {
    EntityTransaction tx = null;
    if (em == null) {
      em = getEMF().createEntityManager();
      tx = em.getTransaction();
    }
    String sqlQuery =
      "SELECT DISTINCT a.code FROM Airport a";
    TypedQuery<String> query = em.createQuery( sqlQuery, String.class );
    if (tx != null) tx.begin();
    List<String> codes = query.getResultList();
    if (tx != null) {
      tx.commit();
      em.close();
    }
    return codes;
  }

  /**
   * Retrieves all airports known.
   * @param em - EntityManager to use for operation, if known
   * @return list of airports known.
   */
  public List<Airport> list( EntityManager em ) {
    EntityTransaction tx = null;
    if (em == null) {
      em = getEMF().createEntityManager();
      tx = em.getTransaction();
    }
    String sqlQuery = "SELECT a FROM Airport a";
    TypedQuery<Airport> query = em.createQuery( sqlQuery, Airport.class );
    if (tx != null) tx.begin();
    List<Airport> as = query.getResultList();
    if (tx != null) {
      tx.commit();
      em.close();
    }
    return as;
  }
}
