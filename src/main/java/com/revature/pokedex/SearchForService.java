package com.revature.pokedex;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SearchForService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String HTMLForm = "<Html>\n" +
                "<Head>\n" +
                "    <Title>Search Pokedex\"" +
                "</Title>\n" +
                "</Head>\n" +
                "<Body>\n" +
                "   <h1>Pokedex Search</h1>\n" +
                "   <form action='/pokemon' method='get'>\n" +
                "       <input type= 'name' name='searchName'/>\n" +
                "       <input type='submit' value='Search' />\n" +
                "   " +
                "   <a href='pokemon'>See Full Pokedex</a>\n" +
                "</form>\n" +
                "</Body>\n" +
                "</Html>\n";
        resp.getWriter().println(HTMLForm);

    }
}
