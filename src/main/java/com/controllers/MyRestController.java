package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.CustomerDTO;
import com.dto.ResponseDTO;
import com.repository.Customer;
import com.services.CustomerService;

@RestController
@RequestMapping("/api")

public class MyRestController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/customers")
	public ResponseDTO createUser(@RequestBody CustomerDTO customerDTO) {
		// return this.customerRespository.save(customerDTO);
		customerService.saveCustomer(customerDTO);
		ResponseDTO responseDTO = new ResponseDTO();

		responseDTO.setMessage("customer saved in db");
		responseDTO.setStatus(201);
		return responseDTO;

	}

	@GetMapping("/customers")
	 List<CustomerDTO> findAllCustomers(Model model) {
     List<CustomerDTO> listofcustomer = customerService.findAllCum();
		return listofcustomer;

		
	}
	@DeleteMapping("/customers/{id}")
	ResponseDTO deletecustomer(@PathVariable long id) {
		customerService.deleteByIdCustomer(id);
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setMessage("deleated sucessfully");
		responseDTO.setStatus(200);
		
		return responseDTO;
		
	}
	
	@PutMapping("/customers/{id}")
	ResponseDTO updateDB(@RequestBody Customer customer , @PathVariable long id) {
		customer.setId(id);
		customerService.saveCustomer(customer);
		ResponseDTO responseDTO = new ResponseDTO ();
		responseDTO.setMessage("update done sucessfully");
		responseDTO.setStatus(200);
		
		return responseDTO;
		
	}
	
	
}
