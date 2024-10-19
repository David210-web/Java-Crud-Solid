
package servicios;

import java.sql.Connection;
import javax.swing.JOptionPane;
import repositorios.conexionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author cdavi
 */
public class ConexionSQLServer implements conexionDB{
    private static final String user = "david210";
    private static final String pass = "1234";
    private static final String url = "jdbc:sqlserver://DESKTOP-M6TI5RF;Database=crudJava;Encrypt=true;trustServerCertificate=true";
    Connection conexion = null;
    @Override
    public Connection conectar() {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection(url,user,pass);
            //JOptionPane.showMessageDialog(null, "Conexion establecida");
        }catch(ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "EL jdbc no fue encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return conexion;
    }

    @Override
    public void desconectar() {
        try
        {
            if(conexion != null && !conexion.isClosed())
            {
                conexion.close();
            }
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error: " + e);

        }
    }
    
}
