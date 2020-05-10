package com.example.AeroParker.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "site")
public class Site {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column
    private String name;


    @JsonIgnore
    @OneToMany(mappedBy = "site", fetch = FetchType.EAGER)
    private Set<Customer> customers;


    public Site() {
    }

    public Site(Long id, String name, Set<Customer> customers) {
        this.id = id;
        this.name = name;
        this.customers = customers;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Customer> getCustomers() {
        return this.customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Site id(Long id) {
        this.id = id;
        return this;
    }

    public Site name(String name) {
        this.name = name;
        return this;
    }

    public Site customers(Set<Customer> customers) {
        this.customers = customers;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Site)) {
            return false;
        }
        Site site = (Site) o;
        return Objects.equals(id, site.id) && Objects.equals(name, site.name) && Objects.equals(customers, site.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, customers);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", customers='" + getCustomers() + "'" +
            "}";
    }
   

   

}