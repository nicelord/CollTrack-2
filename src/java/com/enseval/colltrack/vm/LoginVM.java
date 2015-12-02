/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enseval.colltrack.vm;

import com.enseval.colltrack.util.AuthenticationService;
import com.enseval.colltrack.util.AuthenticationServiceImpl;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;

/**
 *
 * @author Reza Elborneo
 */
public class LoginVM {

    AuthenticationService authService = new AuthenticationServiceImpl();
    String username;
    String password;
    String msg;
    String akses;
    String browser;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getAkses() {
        return akses;
    }

    public void setAkses(String akses) {
        this.akses = akses;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    
    
    @AfterCompose
    @NotifyChange("browser")
    public void initSetup(@ContextParam(ContextType.VIEW) Component view) {

        Selectors.wireComponents(view, this, false);

        setBrowser(Executions.getCurrent().getBrowser());

        if (!(browser.equals("webkit") | browser.equals("gecko"))) {
            Executions.sendRedirect("chromeDownload.zul");
        }

    }


    @Command
    @NotifyChange({"username", "password", "msg", "akses"})
    public void doLogin() {

        if (!authService.login(username, password)) {
            msg = "Username atau password salah.";
            return;
        }

        Executions.sendRedirect("/home.zul");

    }

}
