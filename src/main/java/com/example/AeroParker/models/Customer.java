package com.example.AeroParker.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "customer")
public class Customer {
    
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private DateTime registered;

    @NotNull
    @Column
    private String email;

    @NotNull
    @Column
    private String title;

    @NotNull
    @Column
    private String first_name;

    @NotNull
    @Column
    private String last_name;

    @NotNull
    @Column
    private String address_line_one;

    @Column
    private String address_line_two;

    @Column
    private String city;

    @NotNull
    @Column
    private String postcode;

    @NotNull
    @Column
    private String phone_number;
    

    public Customer(){

    }

    public Customer(Long id, DateTime registered, String email, String title, String first_name, String last_name, String address_line_one, String address_line_two, String city, String postcode, String phone_number) {
        this.id = id;
        this.registered = registered;
        this.email = email;
        this.title = title;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address_line_one = address_line_one;
        this.address_line_two = address_line_two;
        this.city = city;
        this.postcode = postcode;
        this.phone_number = phone_number;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateTime getRegistered() {
        return this.registered;
    }

    public void setRegistered(DateTime registered) {
        this.registered = registered;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress_line_one() {
        return this.address_line_one;
    }

    public void setAddress_line_one(String address_line_one) {
        this.address_line_one = address_line_one;
    }

    public String getAddress_line_two() {
        return this.address_line_two;
    }

    public void setAddress_line_two(String address_line_two) {
        this.address_line_two = address_line_two;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhone_number() {
        return this.phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Customer id(Long id) {
        this.id = id;
        return this;
    }

    public Customer registered(DateTime registered) {
        this.registered = registered;
        return this;
    }

    public Customer email(String email) {
        this.email = email;
        return this;
    }

    public Customer title(String title) {
        this.title = title;
        return this;
    }

    public Customer first_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public Customer last_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public Customer address_line_one(String address_line_one) {
        this.address_line_one = address_line_one;
        return this;
    }

    public Customer address_line_two(String address_line_two) {
        this.address_line_two = address_line_two;
        return this;
    }

    public Customer city(String city) {
        this.city = city;
        return this;
    }

    public Customer postcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public Customer phone_number(String phone_number) {
        this.phone_number = phone_number;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(registered, customer.registered) && Objects.equals(email, customer.email) && Objects.equals(title, customer.title) && Objects.equals(first_name, customer.first_name) && Objects.equals(last_name, customer.last_name) && Objects.equals(address_line_one, customer.address_line_one) && Objects.equals(address_line_two, customer.address_line_two) && Objects.equals(city, customer.city) && Objects.equals(postcode, customer.postcode) && Objects.equals(phone_number, customer.phone_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, registered, email, title, first_name, last_name, address_line_one, address_line_two, city, postcode, phone_number);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", registered='" + getRegistered() + "'" +
            ", email='" + getEmail() + "'" +
            ", title='" + getTitle() + "'" +
            ", first_name='" + getFirst_name() + "'" +
            ", last_name='" + getLast_name() + "'" +
            ", address_line_one='" + getAddress_line_one() + "'" +
            ", address_line_two='" + getAddress_line_two() + "'" +
            ", city='" + getCity() + "'" +
            ", postcode='" + getPostcode() + "'" +
            ", phone_number='" + getPhone_number() + "'" +
            "}";
    }

}