package com.srione.cms.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomerResponse {

    protected String customerFname;
    protected String customerLname;
    protected String customerEmail;
    protected int custId;

    public String getCustomerFname() {
        return customerFname;
    }
    @XmlElement
    public void setCustomerFname(String value) {
        this.customerFname = value;
    }

    public String getCustomerLname() {
        return customerLname;
    }
    @XmlElement
    public void setCustomerLname(String value) {
        this.customerLname = value;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }
    @XmlElement
    public void setCustomerEmail(String value) {
        this.customerEmail = value;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int value) {
        this.custId = value;
    }

}
