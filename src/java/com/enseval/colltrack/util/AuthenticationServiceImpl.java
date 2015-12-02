/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enseval.colltrack.util;

import com.avaje.ebean.Ebean;
import com.enseval.colltrack.model.User;
import java.io.Serializable;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

/**
 *
 * @author Reza Elborneo
 */
public class AuthenticationServiceImpl implements AuthenticationService, Serializable {

    private static final long serialVersionUID = 1L;

    public AuthenticationServiceImpl() {

    }

    @Override
    public UserCredential getUserCredential() {
        Session sess = Sessions.getCurrent();
        UserCredential cre = (UserCredential) sess.getAttribute("userCredential");
        if (cre == null) {
            cre = new UserCredential();//new a anonymous user and set to session
            sess.setAttribute("userCredential", cre);
        }
        return cre;
    }

    @Override
    public boolean login(String username, String password) {

        User userlogin = Ebean.find(User.class).where("username = '" + username + "' and password = '" + password + "'").findUnique();

        if (userlogin == null) {

            return false;
        }

        Session sess = Sessions.getCurrent();
        UserCredential cre = new UserCredential(userlogin.getUsername(), userlogin.getNama(), userlogin);

//        if (cre.isAnonymous()) {
//            return false;
//        }
        cre.setRoles(userlogin.getAkses());
        sess.setAttribute("userCredential", cre);

        return true;
    }

    @Override
    public void logout() {
        Session sess = Sessions.getCurrent();
        sess.removeAttribute("userCredential");
    }
}
