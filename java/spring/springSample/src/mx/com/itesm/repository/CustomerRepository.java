package mx.com.itesm.repository;

import java.util.List;

import mx.com.itesm.model.Customer;

/**
 * 
 * @author hesparza
 *
 */
public interface CustomerRepository {

	public abstract List<Customer> findAll();

}