package com.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.CustomerDTO;
import com.repository.Customer;
import com.repository.CustomerRepository;



@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRespository;
	

	@Override
	public void saveCustomer(CustomerDTO customerDTO) {		
		
		Customer customer =new Customer();//create a blank entity object
		BeanUtils.copyProperties(customerDTO, customer);		
		customerRespository.save(customer);
		
		
	}

	@Override
	public List<CustomerDTO> findAllCum() {
		List<Customer> listofcustomer = customerRespository.findAll();
		List<CustomerDTO> listofcustomerDTO = new ArrayList<>();
		for(Customer customer : listofcustomer) {
			CustomerDTO customerDTO = new CustomerDTO();
			BeanUtils.copyProperties(customer, customerDTO);
			listofcustomerDTO.add(customerDTO);
		}
		
		return listofcustomerDTO;
	}

	@Override
	public void deleteByIdCustomer(long id) {
		customerRespository.deleteById(id);
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerRespository.save(customer);
		
	}

//	@Override
//	public void saveCustomer(Customer customer) {
//		Optional<Customer > optional=customerRespository.findById(id);
//		if(optional.isPresent()){
//			Customer customer=optional.get();
//			customer.setEmail(null);//dirty checking
//			return customer;
//		}
//		
//		
//		return null;
//	}


}
