/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enseval.colltrack.util;

import com.enseval.colltrack.model.User;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Reza Elborneo
 */
public class UserCredential implements Serializable {

    private static final long serialVersionUID = 1L;

    String account;
    String name;
    User user;
    
    String roles = "anon";

    public UserCredential(String account, String name, User user) {
        this.name = name;
        this.account = account;
        this.user = user;
    }

    public UserCredential() {
        this.account = "anonymous";
        roles = "anon";
    }

    public boolean isAnonymous() {
        return getRoles().equals("anon") || "anonymous".equals(account);
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }


    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    

}
