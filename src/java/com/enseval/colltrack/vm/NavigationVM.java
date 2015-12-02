/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enseval.colltrack.vm;

import com.enseval.colltrack.util.AuthenticationServiceImpl;
import java.util.HashMap;
import java.util.Map;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;

/**
 *
 * @author Reza Elborneo
 */
public class NavigationVM {
    

    @Command
    public void changePage(@BindingParam("page") String page) {
//        Executions.getCurrent().sendRedirect(page);       
        Map map = new HashMap();
        map.put("page", page);
        BindUtils.postGlobalCommand(null, null, "doChangePage", map);
    }

    @Command
    public void logout() {
        new AuthenticationServiceImpl().logout();
        Executions.sendRedirect("/login.zul");
    }

}
