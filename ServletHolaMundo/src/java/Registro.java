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
public class Registro extends HttpServlet {
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
    

    
    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String nom, appat, apmat, correo, ip, ipr;
            int edad, puerto, puertor;
            
            nom = request.getParameter("nombre");
            appat = request.getParameter("appat");
            apmat = request.getParameter("apmat");
            edad = Integer.parseInt(request.getParameter("edad"));
            correo = request.getParameter("correo");
            
            ip = request.getLocalAddr();
            puerto = request.getLocalPort();
            
            ipr = request.getRemoteAddr();
            puertor = request.getRemotePort();
            try{                
                String q = "insert into mregistro "
                        + "(nom_usu, appat_usu, apmat_usu, edad_usu, email_usu) "
                        + "values "
                        + "('"+nom+"', '"+appat+"', '"+apmat+"', "+edad+", '"+correo+"')";
                
                set.executeUpdate(q);
                System.out.println("Registro exitoso en la tabla");
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registro</title>");  
            out.println("</head>");
            out.println("<body>"
                    + "<br>"
                    + "Tu nombre es: "+nom
                    + "<br>"
                    + "Tu apellido paterno es: "+appat
                    + "<br>"
                    + "Tu apellido materno es: "+apmat
                    + "<br>"
                    + "Tu edad es: "+edad
                    + "<br>"
                    + "Tu email es: "+correo
                    + "<br>"
                    + "IP Local: "+ip
                    + "<br>"
                    + "Puerto Local: "+puerto
                    + "<br>"
                    + "IP Remota: "+ipr
                    + "<br>"
                    + "Puerto Remoto: "+puertor
                    + "<br>");
            out.println("<h1>Registro Exitoso</h1>"
                    + "<a href='index.html' >Regresar al Menu Principal</a>"
                    + "<br>"
                    + "<a href='Consultar' >Consultar Tabla General de Usuarios</a>");
            out.println("</body>");
            out.println("</html>");
            set.close();
            
            }catch(Exception e){
                System.out.println("Error al registrar en la tabla");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
                
                
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registro</title>");            
            out.println("</head>");
            out.println("<body>"
            + "<br>");
            out.println("<h1>Registro No Exitoso, ocurrio un error</h1>"
                    + "<a href='index.html' >Regresar al Menu Principal</a>"
                    + "<br>"
                    + "<a href='Consultar' >Consultar Tabla General de Usuarios</a>");
            out.println("</body>");
            out.println("</html>");
                    
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
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