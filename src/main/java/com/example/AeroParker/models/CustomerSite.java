package com.example.AeroParker.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "customer_site")
public class CustomerSite {
    
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Customer customer;


    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Site site;



    public CustomerSite() {
    }

    public CustomerSite(Long id, Customer customer, Site site) {
        this.id = id;
        this.customer = customer;
        this.site = site;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Site getSite() {
        return this.site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public CustomerSite id(Long id) {
        this.id = id;
        return this;
    }

    public CustomerSite customer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public CustomerSite site(Site site) {
        this.site = site;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CustomerSite)) {
            return false;
        }
        CustomerSite customerSite = (CustomerSite) o;
        return Objects.equals(id, customerSite.id) && Objects.equals(customer, customerSite.customer) && Objects.equals(site, customerSite.site);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, site);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", customer='" + getCustomer() + "'" +
            ", site='" + getSite() + "'" +
            "}";
    }
    


}