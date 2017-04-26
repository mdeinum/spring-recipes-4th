package com.apress.springrecipes.court.web;

import org.springframework.hateoas.ResourceSupport;

public class MemberResource extends ResourceSupport {

    public String name;
    public String phone;
    public String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
