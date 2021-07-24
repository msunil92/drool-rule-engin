package com.learn.ruleengine.service;

import com.learn.ruleengine.model.Customer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunil
 * @project drool-rule-engine
 * @created 2021/07/24 2:08 PM
 */

@Service
public class CustomerService {

    @Autowired
    KieSession ksession;

    public Customer getCustomer() {
        Customer customer = new Customer();
        customer.setBond(7);
        customer.setName("Rohit");
        customer.setType(Customer.CustomerType.GOLD);
        ksession.insert(customer);
        ksession.fireAllRules();

        return customer;
    }

    public Customer updateCustomerFromRules(Customer customer) {
        ksession.insert(customer);
        ksession.fireAllRules();
        return customer;
    }
}
