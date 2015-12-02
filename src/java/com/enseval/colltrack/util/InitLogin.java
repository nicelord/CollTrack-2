/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enseval.colltrack.util;

import java.util.Map;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.util.Initiator;

/**
 *
 * @author Reza Elborneo
 */
public class InitLogin implements Initiator {

    AuthenticationService authService = new AuthenticationServiceImpl();

    @Override
    public void doInit(Page page, Map<String, Object> map) throws Exception {
        UserCredential cre = authService.getUserCredential();
        if (!cre.isAnonymous()) {
            Executions.sendRedirect("/home.zul");
        }
    }

}
