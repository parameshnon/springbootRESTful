package com.example.service;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.exception.ServiceException;
import com.example.model.Customer;
@Component
public class CustomerService implements CustomerServiceIF {
	private static final Logger logger=LoggerFactory.getLogger(CustomerService.class);

	@Override
	public HashMap<Integer, Customer> retrieveCustomers() throws ServiceException {
		logger.debug("Start :::retrieveCustomers:::");
		
		HashMap<Integer, Customer> customerList=constructCustomerList();
		logger.debug("End :: RetrieveCustomers");
		return customerList;
	}

	@Override
	public Customer retrieveCustomer(int id) throws ServiceException {
		logger.debug("Start :retrieveCustomer");
		
		Customer customer =new Customer();
		
		customer.setId(id);
		customer.setName("Testing");
		
		logger.debug("End :RetrieveCustomer");
		return customer;
		
	}
	
	
	
	
	@Override
	public int createCustomer(Customer customer) throws ServiceException {
		
		logger.debug("Start ::: Save");
		
		logger.debug("End :: Customer");
		return customer.getId();
	}

	private HashMap<Integer, Customer> constructCustomerList(){
		
HashMap<Integer, Customer> customerList =new HashMap<Integer,Customer>();
		
		Customer customer=new Customer();
		
		customer.setId(1);
		customer.setName("First");
		customerList.put(new Integer(1), customer);
		customer=new Customer();
		
		customer.setId(2);
		customer.setName("Second");
		customerList.put(new Integer(2), customer);
		customer=new Customer();
		
		customer.setId(3);
		customer.setName("Third");
		customerList.put(new Integer(3), customer);
		return customerList;
	}
	

}
