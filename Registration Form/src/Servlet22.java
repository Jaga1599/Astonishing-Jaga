


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Statement;
import java.sql.*;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet22 extends HttpServlet {

 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        try{
            
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        String path="G:\\ooad project\\software.accdb";
        String urll="jdbc:ucanaccess://"+path;
        Connection con = DriverManager.getConnection(urll);
           Statement st = con.createStatement();
            String name=request.getParameter("uname");
            String pass=request.getParameter("upass");
            String idd=request.getParameter("eid");
            String gen=request.getParameter("egen");
            String no=request.getParameter("ephn");
            String quer="insert into emp(ename,eid,epass,egen,ephno)values('"+name+"','"+idd+"','"+pass+"','"+gen+"','"+no+"')";
            st.execute(quer);
            out.println("Registration Successfull");
            response.sendRedirect("index.html");
        out.close();
        }
        catch(Exception e){
            System.err.println(e);
        }
    }

    

}
