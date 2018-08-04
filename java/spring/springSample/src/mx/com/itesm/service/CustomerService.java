package mx.com.itesm.service;

import java.util.List;

import mx.com.itesm.model.Customer;

public interface CustomerService {

	public abstract List<Customer> findAll();

}