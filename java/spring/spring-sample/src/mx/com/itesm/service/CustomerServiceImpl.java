package mx.com.itesm.service;

import java.util.List;

import mx.com.itesm.model.Customer;
import mx.com.itesm.repository.CustomerRepository;
import mx.com.itesm.repository.HibernateCustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {
	private CustomerRepository customerRepository = new HibernateCustomerRepositoryImpl();
	
	/* (non-Javadoc)
	 * @see mx.com.itesm.service.CustomerService#findAll()
	 */
	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}
