package com.learn.ruleengine.service;

import com.learn.ruleengine.model.Customer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author sunil
 * @project drool-rule-engine
 * @created 2021/07/24 2:08 PM
 */

@Service
public class CustomerService {

    @Qualifier("excel")
    @Autowired
    KieSession ksession_excel;

    @Qualifier("drl")
    @Autowired
    KieSession ksession_drl;

    public Customer getCustomerExcel() {
        Customer customer = new Customer();
        customer.setBond(7);
        customer.setName("Rohit");
        customer.setType(Customer.CustomerType.GOLD);
        ksession_excel.insert(customer);
        ksession_excel.fireAllRules();

        return customer;
    }

    public Customer getCustomerDrl() {
        Customer customer = new Customer();
        customer.setBond(7);
        customer.setName("Rohit");
        customer.setType(Customer.CustomerType.GOLD);
        ksession_drl.insert(customer);
        ksession_drl.fireAllRules();

        return customer;
    }

    public Customer updateCustomerFromExcelRules(Customer customer) {
        ksession_excel.insert(customer);
        ksession_excel.fireAllRules();
        return customer;
    }

    public Customer updateCustomerFromDrlRules(Customer customer) {
        ksession_drl.insert(customer);
        ksession_drl.fireAllRules();
        return customer;
    }
}
