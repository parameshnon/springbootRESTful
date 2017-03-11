package com.example.service;

import java.util.HashMap;

import com.example.exception.ServiceException;
import com.example.model.Customer;

public interface CustomerServiceIF {
	
	HashMap<Integer, Customer> retrieveCustomers() throws ServiceException;
	
	Customer retrieveCustomer(int id) throws ServiceException;
	
	int createCustomer(Customer customer) throws ServiceException;

}
