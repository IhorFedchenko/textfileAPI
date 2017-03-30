package com.fedchenko.edu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class TextServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext ctx = null;
        PrintWriter out = response.getWriter();
        out.print("hello servlet");
        // out.print("getAbsolute " + init.getAbsolutePath()+"<br>");
        // out.print("getCanon "+init.getCanonicalPath()+"<br>");
        // out.print(init.getPath()+"<br>");
//		out.println(ctx.getContextPath());
        // classpath:com/myapp/config.xml
		/*try(InputStream inStream =  ctx.getResourceAsStream("classpath:com/fedchenko/edu/textfileAPIv2/WEB-INF/testfile.txt"))
		{
            System.out.println("Размер файла: " + inStream.available() + " байт(а)");

            int i=-1;
            while((i=inStream.read())!=-1){

                out.print((char)i);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        } */





    }

}
