package com.srione.cms.service;

import com.srione.cms.dao.CustomerDAO;
import com.srione.cms.exception.CustomerNotFoundException;
import com.srione.cms.model.Customer;
import com.srione.cms.model.User;
import com.srione.cms.repository.CustomerRepository;
import com.srione.cms.repository.UserRepository;
import com.srione.cms.response.CustomerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerService {

    @Autowired
    public CustomerDAO customerDAO;
    @Autowired
    public CustomerAssembler customerAssembler;
    @Autowired
    public CustomerRepository customerRepository;
    @Autowired
    public UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(CustomerService.class);

    public Customer addCustomer(Customer customer){
        logger.info("Added customer successfully with Id-" +customer.getId());
        return customerDAO.save(customer);
    }

    public User addUser(User user){
        logger.info("Added User successfully with Id-" +user.getId());
        return userRepository.create(user);
    }

    public List<Customer> getCustomerList(){
        logger.info("Retrieved customers successfully");
        return customerRepository.findAll();
    }

    public User getUserById(int id){
        logger.info("Retrieved customers successfully");
        return userRepository.findUserById(id);
    }

    public List<Customer> getCustomerListByCustomerFName(String customerFName){
        logger.info("Retrieved customers successfully");
        return customerRepository.findByCustomerFirstName(customerFName);
    }

    public List<Customer> getCustomerListByCustomerLName(String customerLName){
        logger.info("Retrieved customers successfully");
        return customerRepository.findByCustomerLastName(customerLName);
    }

    public List<User> getAllUsers(){
        logger.info("Retrieved All users successfully");
        return userRepository.findAll();
    }

    public List<Customer> getCustomerListByCustomerEmail(String customerEmail){
        logger.info("Retrieved customers successfully");
        return customerRepository.findByCustomerEmail(customerEmail);
    }


    public CustomerResponse getCustomer(int customerId){
        logger.info("Retrieved individual customer successfully with id-" +customerId);
        if(!customerDAO.existsById(customerId)) {
            throw new CustomerNotFoundException("Customer doesn't exist, please try again..");
        }
        Customer customer = customerDAO.findById(customerId).get();
         CustomerResponse customerResponse= new CustomerResponse();
        return customerAssembler.mapCustomerToResponse(customer, customerResponse);
    }

    public Customer updateCustomer(int customerId, Customer customer){

        if(customerId>0) {
            logger.info("Updated customer successfully with id-" + customerId);
            customer.setId(customerId);
        }
         else
            logger.info("added customer successfully with id-" +customerId);
        return customerDAO.save(customer);
    }

    public void deleteCustomer(int customerId){
        customerDAO.deleteById(customerId);
        logger.info("Deleted the customer successfully with id-" +customerId);
    }

}
