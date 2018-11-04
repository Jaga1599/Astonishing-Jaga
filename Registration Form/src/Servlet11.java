


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Statement;
import java.sql.*;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet11 extends HttpServlet {

 
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
            if(name.equals("admin") && pass.equals("admin"))
                response.sendRedirect("jsp3.jsp");
            
            PreparedStatement p = con.prepareStatement("select ename,epass from emp where ename=? and epass=?");
            p.setString(1,name);
            p.setString(2, pass);
            
            
            ResultSet rs = p.executeQuery();
            boolean temp=rs.next();
            if(temp)
            {
                String sqlquery= "select * from emp where ename='"+name+"' and epass='"+pass+"'";
           rs= st.executeQuery(sqlquery);
           if(rs.next())
           {
out.println("<html>" +"<head>" +"<title></title>" +"</head>" +"<body>");
out.println("<form action='index.html'>");
out.println("<div style='padding-left:500px;' id='disp'>");
out.println("<img src='person.png' height='250' width='250' style='padding-top: 25px;'>"+"<br><br>");
out.println("Name:      "+rs.getString(4)+"<br><br>");
out.println("Employee ID:       "+rs.getString(5)+"<br><br>");
out.println("Gender:        "+rs.getString(2)+"<br><br>");
out.println("Phone Number:      "+rs.getString(3)+"<br><br>");
out.println("Project ID:        "+rs.getString(6)+"<br><br>");
out.println("Project Name:      "+rs.getString(7)+"<br><br>");
out.println("Salary:       "+rs.getString(8)+"<br><br>");
out.println("       <input type='submit' value ='logout'");
out.println("</div>");
out.println("</body>");
out.println("</form>");
 out.println("</html>");
           }
           
         
}
            
        out.close();
        }
        
        
        catch(Exception e){
            System.err.println(e);
        }
    }

    //con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};Dbq=C:\\Users\\Bruger\\Documents\\Database11.accdb");

}
