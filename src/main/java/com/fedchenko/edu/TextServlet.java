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
import java.util.ArrayList;

@WebServlet("/")
public class TextServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;
    //    integer which represents max number of chars in text that API should return.
    int limit;
    //    string which represents text to search in file
    String q = new String();
    int length;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            limit = Integer.parseInt(request.getParameter("limit"));
        } catch (Exception ex) {
            //default limit
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

            String allText = new String(streamToString(inputstrm));
            out.print(allText);
//            out.print("LIMIT: " + limit + " ");
//            out.print("QUERY: " + q + " ");
//            out.print("LENGTH: " + length + " ");


        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }

    protected String streamToString(InputStream input) {


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
    protected ArrayList<String> preJsonData(String input,int limit, String q, int length ){
        ArrayList<String> result = new ArrayList<String>();
        limit = this.limit;
        length = this.length;
        q = this.q;
        return result;
    }
    protected String JSONbuilder(ArrayList<String> input) {
        String result = new String();
        String prefix = new String("{\n \"text\": [\n ");
        String suffix = new String ("\n]}");
        return result;
    }

}
