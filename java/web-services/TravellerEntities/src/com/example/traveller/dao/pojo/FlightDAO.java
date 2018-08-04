/*
 */

package com.example.traveller.dao.pojo;

import com.example.traveller.model.Airport;
import com.example.traveller.model.Flight;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 * Data Access Object implementation for persistent
 * class {@see com.example.traveller.model.Flight}.
 * @author education@oracle.com
 */
public class FlightDAO extends GenericDAO<Flight> {
  public Flight
  findByNumber(EntityManager em, String number) {
    EntityTransaction tx = null;
    if (em == null) {
      em = getEMF().createEntityManager();
      tx = em.getTransaction();
    }
    Flight result = null;
    if (tx != null) {
      tx.commit();
      em.close();
    }
    return result;
  }
  public Map<Flight,Airport>
  findRoutesFrom(EntityManager em, Airport start) {
    EntityTransaction tx = null;
    if (em == null) {
      em = getEMF().createEntityManager();
      tx = em.getTransaction();
    }
    String sqlQuery =
      "SELECT f FROM Flight f WHERE f.departs = :start";
    TypedQuery<Flight> query = em.createQuery(sqlQuery, returnedClass());
    query.setParameter( "start", start );
    if (tx != null) tx.begin();
    List<Flight> routes = query.getResultList();
    Map<Flight,Airport> result = new HashMap<Flight,Airport>();
    for (Flight f : routes)
      result.put(f, f.getArrives());
    if (tx != null) {
      tx.commit();
      em.close();
    }
    return result;
  }
}
