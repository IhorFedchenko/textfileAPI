package com.fedchenko.edu;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/")
public class TextServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;

    int limit;
    String q = new String();
    int length;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            limit = Integer.parseInt(request.getParameter("limit"));
        } catch (Exception ex) {
            limit = 10000;
            ex.printStackTrace();

        }
        try {
            length = Integer.parseInt(request.getParameter("length"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

       String q = request.getParameter("q");
        ServletContext ctx = getServletContext();
        PrintWriter out = response.getWriter();

        try (InputStream inputstrm = ctx.getResourceAsStream("/WEB-INF/testfile.txt")) {
//            out.print("HashCode of stream: " + inputstrm.hashCode() + " ");
            String allText = new String(streamToString(inputstrm));
            out.print(allText);


        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

//        out.print("LIMIT: " + limit + " ");
//        out.print("QUERY: " + q + " ");
//        out.print("LENGTH: " + length + " ");

    }

    protected String streamToString(InputStream input) {
        int limit = this.limit;
        int count = 0;
        try {
            try (ByteArrayOutputStream result = new ByteArrayOutputStream()) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = input.read(buffer)) != -1) {
                    result.write(buffer, 0, length);
                }
                return result.toString("UTF-8");
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
