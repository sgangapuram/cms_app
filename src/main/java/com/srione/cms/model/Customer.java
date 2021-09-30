package com.srione.cms.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @Column(name = "custId", length = 7)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private int id;
    @JsonProperty("firstName")
    @Column(name = "custFName", length = 10)
    private String customerFirstName;
    @JsonProperty("lastName")
    @Column(name = "custLName", length = 10)
    private String customerLastName;
    @JsonProperty("email")
    @Column(name = "custEmail", length = 25)
    private String customerEmail;

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

}
