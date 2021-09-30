package com.srione.cms.api;

import com.srione.cms.model.Customer;
import com.srione.cms.model.User;
import com.srione.cms.response.CustomerResponse;
import com.srione.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @PostMapping(value = "/addUser")
    public User addUser(@RequestBody User user){
        return customerService.addUser(user);
    }

    @GetMapping
    public List<Customer> getCustomers(){
       return customerService.getCustomerList();
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return customerService.getAllUsers();
    }

    @GetMapping(value = "/users/{userId}")
    public User getUserById(@PathVariable("userId")  int userId){
        return customerService.getUserById(userId);
    }

    @RequestMapping(value =  "/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable("customerId")  int customerId){
       return ResponseEntity.ok(customerService.getCustomer(customerId));
    }

    @RequestMapping(value =  "/custFName/{customerFName}", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getCustomerByFirstName(@PathVariable("customerFName")  String customerFName){
        return ResponseEntity.ok(customerService.getCustomerListByCustomerFName(customerFName));
    }

    @RequestMapping(value =  "/custLName/{customerLName}", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getCustomerByLastName(@PathVariable("customerLName")  String customerLName){
        return ResponseEntity.ok(customerService.getCustomerListByCustomerLName(customerLName));
    }

    @RequestMapping(value =  "/custEmail/{customerEmail}", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getCustomerByEmail(@PathVariable("customerEmail")  String customerEmail){
        return ResponseEntity.ok(customerService.getCustomerListByCustomerEmail(customerEmail));
    }

    @PutMapping(value = "/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") int customerId,@RequestBody Customer customer){
       return customerService.updateCustomer(customerId, customer);
    }

    @DeleteMapping(value = "/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int customerId){
         customerService.deleteCustomer(customerId);
    }

}
