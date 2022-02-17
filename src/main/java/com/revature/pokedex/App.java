package com.revature.pokedex;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App {
    //location where we do business logic and gather content.
    public static void main(String[] args) {
        //object graph or dependency injection = tree structure of program being called
        // DexService depends on DexRepository, DexServer depends on DexService.

        DexRepository dexRepository = new DexRepository("pokedex.csv");
        DexService dexService = new DexService(dexRepository);
        SearchForService sfService = new SearchForService();

        Tomcat server = new Tomcat();
        server.setBaseDir(System.getProperty("java.io.tmpdir"));
        //server.setPort(0);
        server.getConnector();
        server.addContext("", null);
        server.addServlet("", "dexServlet", dexService).addMapping("/pokemon");
        server.addServlet("", "searchFormServlet", sfService).addMapping("/search");
        try {
            server.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
