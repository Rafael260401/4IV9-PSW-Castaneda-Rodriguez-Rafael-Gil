import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Actualizar extends HttpServlet {
    private Connection con;
    private Statement set;
    private ResultSet rs;
    public void init(ServletConfig cfg) throws ServletException{
        String url = "jdbc:mysql:3306//localhost/registro4iv9"; 
        String userName = "root";
        String password = "lol26lol";
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://localhost/registro4iv9";
            con = DriverManager.getConnection(url, userName, password);
            set = con.createStatement();
            System.out.println("Conexion exitosa");
        }catch(Exception e){
            System.out.println("Conexion no exitosa");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        
        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Modificar</title>");            
            out.println("</head>");
            out.println("<body>");
             out.println("<h1>Tabla del Registro de Usuarios</h1>"
                    + "<table border='2'>"
                    + "<thead>"
                        + "<tr>"
                        + "<th>ID</th>"
                        + "<th>Nombre Completo</th>"
                        + "<th>Edad</th>"
                        + "<th>Correo</th>"
                        + "</tr>"
                    + "<thead>"
                    + "<tbody>");
            String nom, appat, apmat, correo, q, qq;
            int edad, id;
            id = Integer.parseInt(request.getParameter("idmodificar"));
            q = "select * from mregistro where id_usu = "+id;
             try{
                set = con.createStatement();
                rs = set.executeQuery(q);
                while(rs.next()){
                    id = rs.getInt("id_usu");
                    nom = rs.getString("nom_usu");
                    appat = rs.getString("appat_usu");
                    apmat = rs.getString("apmat_usu");
                    edad = rs.getInt("edad_usu");
                    correo = rs.getString("email_usu");
                    out.println("<tr>"
                                + "<td>"+id+"</td>"
                                + "<td>"+nom+" "+appat+" "+apmat+"</td>"
                                + "<td>"+edad+"</td>"
                                + "<td>"+correo+"</td>"
                            + "</tr>"
                            +"<br>");
                    out.println("</tbody>"
                    + "</table>"
                    + "<br>"
                            +"<form name='formularioModificar' method='post' action='Actualizar_2'>"
                            +"<h2>Modifique los datos</h2>"
                            +"<h2>ID</h2>"
                     +"<input type='text' value='"+id+"' name ='id_modificar'>"
                             +"<br>"
                            +"<h2>Nombre</h2>"
                     +"<input type='text' value='"+nom+"' name ='nom_modificar'>"
                             +"<br>"
                              +"<h2>Apellido Paterno</h2>"
                     +"<input type='text' value='"+appat+"' name ='appat_modificar'>"
                             +"<br>"
                              +"<h2>Apellido Materno</h2>"
                     +"<input type='text' value='"+apmat+"' name ='apmat_modificar'>"
                             +"<br>"
                              +"<h2>Edad</h2>"
                     +"<input type='text' value='"+edad+"' name ='edad_modificar'>"
                             +"<br>"
                              +"<h2>Correo</h2>"
                     +"<input type='text' value='"+correo+"' name ='correo_modificar'>"
                             +"<br>"
                             +"<br>"
                             +"<input type='submit' value='Modificar Registro'>"
                             +"<br>"
                             +"</form>"
                    + "<a href='index.html' >Regresar al Menu Principal</a>"
                    + "<br>");
                }
                System.out.println("Modificacion exitosa");
                rs.close();
                set.close();
            }catch(Exception e){
                System.out.println("Error al realizar la modificacion");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
    public void destroy(){
        try{
            con.close();
        }catch(Exception e){
            super.destroy();
        }
    }    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}