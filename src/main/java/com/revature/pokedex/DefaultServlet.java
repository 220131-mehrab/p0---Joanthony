package com.revature.pokedex;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class DefaultServlet extends HttpServlet {
    @Override
    //get the file from the path
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getPathInfo().replaceFirst("/","");
        //if filename is blank, well send the client to a defualt webpage "index.html"
        if (fileName.equals(""))
            fileName = "index.html";

        //then load it
        InputStream file = getClass().getClassLoader().getResourceAsStream(fileName);

        if (file == null) {
            resp.setStatus(404);
            resp.getWriter().println("File Not Found");
            return;
        }
        //copy that file from the input stream into the output stream
        IOUtils.copy(file, resp.getOutputStream());
    }
}
