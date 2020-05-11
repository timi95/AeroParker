package com.example.AeroParker.services;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import com.example.AeroParker.models.Customer;
import com.example.AeroParker.repositories.CustomerRepository;
import com.example.AeroParker.repositories.SiteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;



@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SiteRepository siteRepository;

    public void CustomerRegistration(String site, Model model, HttpServletRequest reqst) {

        Customer customer = new Customer();
        
        customer.setRegistered(LocalDateTime.now());
        customer.setEmail(reqst.getParameter("field1").toLowerCase());
        customer.setTitle(reqst.getParameter("field2"));
        customer.setFirst_name(reqst.getParameter("field3"));
        customer.setLast_name(reqst.getParameter("field4"));
        customer.setAddress_line_one(reqst.getParameter("field5"));
        customer.setAddress_line_two(reqst.getParameter("field6"));
        if ( reqst.getParameter("field7").isEmpty()){
            customer.setCity(site);
            customer.setSite(siteRepository.findByName(site).get());
        } else {
            site = reqst.getParameter("field7");
            customer.setCity(site);
            customer.setSite(siteRepository.findByName(site).get());
        }
        customer.setPostcode(reqst.getParameter("field8"));
        customer.setPhone_number(reqst.getParameter("field9"));
        
        
        customerRepository.save(customer);
        model.addAttribute("customers", customerRepository.findAll());
    }
}