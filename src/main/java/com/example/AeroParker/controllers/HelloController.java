package com.example.AeroParker.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.example.AeroParker.models.Customer;
import com.example.AeroParker.models.Site;
import com.example.AeroParker.repositories.CustomerRepository;
import com.example.AeroParker.repositories.SiteRepository;
import com.example.AeroParker.services.CustomerService;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @Autowired
    SiteRepository siteRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @GetMapping({"/", "/hello"})
    public String hello(
        Model model, 
        @RequestParam(value="name", required=false, defaultValue="User") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping("/customer")
    public String customer( HttpServletRequest reqst, HttpServletResponse respns,
        @ModelAttribute("customer") Customer customer,
        BindingResult result, ModelMap model ) {
        
        return "customer";
    }

    @RequestMapping("/register")
    public String register( 
        @RequestParam(name = "site", defaultValue = "Avalon City") String site,
        Model model, HttpServletRequest reqst) {

            try {
                customerService.CustomerRegistration(site, model, reqst);
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        return "register";
    }

    @GetMapping("/sites")
    public String sites(Model model, HttpServletRequest req) {
        List<Site> sites = siteRepository.findAll();
        model.addAttribute("site", sites);

        return "sites";
    }

    @PostMapping ("/email_exists/{email}")
    public ResponseEntity emailVerify( @PathVariable String email) {
        try {
            return ResponseEntity.ok(customerRepository.findByEmail(email).isPresent());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
