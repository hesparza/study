/**
 * 
 */
package mx.com.itesm.main;

import mx.com.itesm.service.CustomerService;
import mx.com.itesm.service.CustomerServiceImpl;

/**
 * @author hesparza
 *
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Application app =  new Application();
		app.start();
	}
	
	private void start() {
		CustomerService customerService = new CustomerServiceImpl();
		System.out.println("First Name: " + customerService.findAll().get(0).getFirstName() +
				", Last Name: " + customerService.findAll().get(0).getLastName()); 
	}

}
