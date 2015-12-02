/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enseval.colltrack.util;

/**
 *
 * @author Reza Elborneo
 */
public interface AuthenticationService {

    /**
     * login with account and password*
     * @param username
     * @param password
     * @return 
     */
    public boolean login(String username, String password);

    /**
     * logout current user*
     */
    public void logout();

    /**
     * get current user credential*
     * @return 
     */
    public UserCredential getUserCredential();

}
