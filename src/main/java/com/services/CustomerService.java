package com.services;

import java.util.List;

import com.dto.CustomerDTO;
import com.repository.Customer;

public interface CustomerService {

	void saveCustomer(CustomerDTO customerDTO);

	List<CustomerDTO> findAllCum();

	

	void deleteByIdCustomer(long id);

	void saveCustomer(Customer customer);

}
