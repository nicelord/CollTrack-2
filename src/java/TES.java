

import com.avaje.ebean.Ebean;
import com.enseval.colltrack.model.User;
import org.avaje.agentloader.AgentLoader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Reza Elborneo
 */
public class TES {

    public static void main(String args[]) {
        AgentLoader.loadAgentFromClasspath("avaje-ebeanorm-agent", "debug=1");
        User u = new User();
        u.setUsername("admin");
        u.setPassword("admin");
        u.setAkses("administrator");
        Ebean.save(u);


    }

}
