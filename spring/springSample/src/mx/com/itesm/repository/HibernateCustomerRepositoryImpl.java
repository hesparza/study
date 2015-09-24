package mx.com.itesm.repository;

import java.util.ArrayList;
import java.util.List;

import mx.com.itesm.model.Customer;

/**
 * 
 * @author hesparza
 *
 */
public class HibernateCustomerRepositoryImpl implements CustomerRepository {

	/* (non-Javadoc)
	 * @see mx.com.itesm.repository.CustomerRepository#findAll()
	 */
	@Override
	public List<Customer> findAll() {
		List<Customer> customers = new ArrayList<>();
		
		Customer customer = new Customer();
		
		customer.setFirstName("Hiram");
		customer.setLastName("Esparza");
		
		customers.add(customer);
		
		return customers;
	}
}
