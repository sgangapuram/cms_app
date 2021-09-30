package com.srione.cms.service;

import com.srione.cms.model.Customer;
import com.srione.cms.response.CustomerResponse;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

@Component
public class CustomerAssembler {

    public CustomerResponse mapCustomerToResponse(Customer customer, CustomerResponse customerResponse) {
        customerResponse.setCustId(customer.getId());
        customerResponse.setCustomerEmail(customer.getCustomerEmail());
        customerResponse.setCustomerFname(customer.getCustomerFirstName());
        customerResponse.setCustomerLname(customer.getCustomerLastName());
        try {
            JAXBContext.newInstance(CustomerResponse.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return customerResponse;
    }
}
