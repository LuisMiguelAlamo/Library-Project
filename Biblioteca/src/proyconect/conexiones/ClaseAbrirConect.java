
package proyconect.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luis Miguel Alamo Hernández
 */
public class ClaseAbrirConect {

    private static Connection cone = null;

    public static Connection getCone() {
        return cone;
    }

    public ClaseAbrirConect() {
    }

    public static boolean abrirConect() throws SQLException {
        if (cone != null && cone.isValid(2000)) {
            return true;
        }
        try {
            String url = "jdbc:mysql://localhost:3306/libros" + "?useServerPrepStmts=true";
            cone = DriverManager.getConnection(url, "root", "");
            System.out.println("Conectado");
            return true;

        } catch (SQLException ex) {
            // Logger.getLogger(caca.class.getName()).log(Level.SEVERE, null, ex);
            if (cone != null) {
                cone.close();
                cone = null;
            }

            System.out.println("Se ha producido un error");
            return false;
        }
    }

}
