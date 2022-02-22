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
        String webAppName = "pokedex";

        Tomcat server = new Tomcat();
        server.setBaseDir(System.getProperty("java.io.tmpdir"));
        //server.setPort(0);
        server.getConnector();
        server.addContext(webAppName, null);

        server.addServlet(webAppName, "defaultServlet", new DefaultServlet()).addMapping("/*");
        server.addServlet(webAppName, "dexServlet", dexService).addMapping("/pokemon");
        server.addServlet(webAppName, "searchFormServlet", sfService).addMapping("/search");
        try {
            server.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
