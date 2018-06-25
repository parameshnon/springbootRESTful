package com.example.ws.rest;

import java.util.Collection;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ServiceException;
import com.example.model.Customer;
import com.example.service.CustomerServiceIF;

@RestController

@RequestMapping(value="/customer")
public class CustomerRESTfulService {
	private static final Logger logger=LoggerFactory.getLogger(CustomerRESTfulService.class);
	@Autowired
	private CustomerServiceIF customerService;
	@RequestMapping(value="getCustomers",method=RequestMethod.GET)
	public HashMap<Integer, Customer> getCustomers() throws ServiceException{
		
		logger.debug("Start ::: getCustomers");
		HashMap<Integer, Customer> customerList=customerService.retrieveCustomers();
		logger.debug("End ::: getCustomers ");
		return customerList;
	}
	
@RequestMapping(value="retrieveCustomers",method=RequestMethod.GET ,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Customer>> retrieveCustomers() throws ServiceException{
		
		logger.debug("Start ::: retrieveCustomers");
		HashMap<Integer, Customer> customerList=customerService.retrieveCustomers();
		Collection<Customer> customerCollection=customerList.values();
		ResponseEntity<Collection<Customer>> customers=new ResponseEntity<Collection<Customer>>(customerCollection, HttpStatus.OK);
		logger.debug("End ::: retrieveCustomers ");
		
		return customers;
		
	}
	
@RequestMapping(value="getCustomer",method=RequestMethod.GET ,produces=MediaType.APPLICATION_JSON_VALUE)
public @ResponseBody Customer getCutomer(@RequestParam(value="id")int id) throws ServiceException{
	
	logger.debug("Start ::: getCutomer");
	Customer customer=customerService.retrieveCustomer(id);
	
	
	logger.debug("End ::: getCutomer");
	
	return customer;
	
}

@RequestMapping(value="retrieveCustomer",method=RequestMethod.GET ,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Customer> retrieveCustomer(@RequestParam(value="id")int id) throws ServiceException{
	
	logger.debug("Start ::: retrieveCustomer");
	Customer customer=customerService.retrieveCustomer(id);
	
	ResponseEntity<Customer> customerResponse=new ResponseEntity<Customer>(customer, HttpStatus.OK);
	logger.debug("End ::: retrieveCustomer");
	
	return customerResponse;
	
}

@RequestMapping(value="createCustomer",method=RequestMethod.PUT ,produces=MediaType.APPLICATION_JSON_VALUE)
public @ResponseBody Customer createCustomer(@RequestBody Customer customer) throws ServiceException{
	
	logger.debug("Start ::: createCustomer");
	customerService.createCustomer(customer);
	
	
	logger.debug("End ::: createCustomer");
	
	return customer;
	
}



}
