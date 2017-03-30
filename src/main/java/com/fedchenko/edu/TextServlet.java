package com.fedchenko.edu;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/")
public class TextServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        ServletContext ctx = null;
        try (InputStream inputstrm = ctx.getResourceAsStream("/WEB-INF/testfile.txt")) {
            out.print(inputstrm.hashCode());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }
}