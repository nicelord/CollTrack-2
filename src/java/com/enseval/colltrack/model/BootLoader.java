/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.enseval.colltrack.model;

import com.avaje.ebean.Ebean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.avaje.agentloader.AgentLoader;

/**
 *
 * @author Reza Elborneo
 */
public class BootLoader extends HttpServlet{
    @Override
    public void init() throws ServletException {
        AgentLoader.loadAgentFromClasspath("avaje-ebeanorm-agent", "debug=1");
        System.out.println("----------");
        System.out.println("---------- BootLoader Servlet Initialized successfully ----------");
        System.out.println("----------");
        
//        Divisi d1 = new Divisi();
//        d1.setId(new Long(1111));
//        d1.setNama("CHD");
//        Ebean.save(d1);
//        
//        
//        User u1 = new User();
//        u1.setUsername("CHD01");
//        u1.setPassword("CHD01");
//        u1.setDivisi(d1);
//        Ebean.save(u1);
//    
//        
//        
//        
//        TTSS t = new TTSS();
//        t.setNomor(new Long(150201001));
//        t.setNamaPenyerah("RIZA");
//        t.setNilai(new Long(10000));
//        t.setUserLogin(u1);
//        Ebean.save(t);
        
      
    }
}
