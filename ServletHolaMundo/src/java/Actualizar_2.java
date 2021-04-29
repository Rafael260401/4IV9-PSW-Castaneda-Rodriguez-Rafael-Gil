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

public class Actualizar_2 extends HttpServlet {
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ya se actualizo c: </h1>");
            out.println("</body>");
            
            
            int id_act = Integer.parseInt(request.getParameter("id_modificar"));
             String nom_act = request.getParameter("nom_modificar");
             String appat_act = request.getParameter("appat_modificar");
             String apmat_act = request.getParameter("apmat_modificar");
             int edad_act;
             edad_act = Integer.parseInt(request.getParameter("edad_modificar"));
             String cooreo_act = request.getParameter("correo_modificar");
             
                     String qq = "UPDATE mregistro SET nom_usu = '"+nom_act+"', appat_usu = '"+appat_act+"', apmat_usu = '"+apmat_act+"', edad_usu = '"+edad_act+"', email_usu = '"+cooreo_act+"' where id_usu = "+id_act+"";
                     
                    try {
                        set = con.createStatement();
                        set.executeUpdate(qq);
                        out.println("<h1></h1>");
                        System.out.println("Registro Modificado");
                         out.println("<h1>Modificado</h1>"
                    + "<br>"
                    + "<a href='index.html' >Regresar al Menu Principal</a>"
                    + "<br>"
                    + "<a href='Registro' >Nuevo Registro</a>"
                    + "<br>"
                    + "<a href='Consultar' >Consultar Tabla General de Usuarios</a>");
                out.println("</body>");
                out.println("</html>");
                    } catch (Exception e) {
                        out.println("<h1>Usuario No Modificado, ocurrio un error</h1>"
                        + "<br>"
                    + "<a href='index.html' >Regresar al Menu Principal</a>"
                    + "<br>"
                    + "<a href='Registro' >Nuevo Registro</a>"
                    + "<br>"
                    + "<a href='Consultar' >Consultar Tabla General de Usuarios</a>");
                        System.out.println("Error al modificar el registro");
                        System.out.println(e.getMessage());
                        System.out.println(e.getStackTrace());
                    }
                    
                }
               
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}