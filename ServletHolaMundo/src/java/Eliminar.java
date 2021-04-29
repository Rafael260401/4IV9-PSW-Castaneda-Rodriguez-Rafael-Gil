import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.ServletConfig;
public class Eliminar extends HttpServlet {
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Eliminar</title>");            
            out.println("</head>");
            out.println("<body>");
            
            int id;
            
            id = Integer.parseInt(request.getParameter("ideliminar"));
            /*
            la sentencia para eliminar un dato de la bd
            delete from nombretabla where atributo = valor
            */
            String q = "delete from mregistro where id_usu = "+id;
            
            try{
                set.executeUpdate(q);
                out.println("<h1>Usuario Eliminado</h1>");
                System.out.println("Registro eliminado");
            
            }catch(Exception e){
                
                out.println("<h1>Usuario No Eliminado, ocurrio un error</h1>");
                System.out.println("Error al eliminar el registro");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            
            }
            
            out.println("<h1>Usuario Eliminado</h1>"
                    + "<br>"
                    + "<a href='index.html' >Regresar al Menu Principal</a>"
                    + "<br>"
                    + "<a href='index.html' >Nuevo Registro</a>"
                    + "<br>"
                    + "<a href='Consultar' >Consultar Tabla General de Usuarios</a>");
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
