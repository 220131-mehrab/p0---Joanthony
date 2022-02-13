package com.revature.pokedex;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//this program will call the text and display the list
public class DexService extends HttpServlet {
    private DexRepository dexRepository;

    public DexService(DexRepository dexRepository) {
        this.dexRepository = dexRepository;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (String pokemon : dexRepository.getPocketMonsters()) {
            resp.getWriter().println(pokemon);
        }
    }



}
