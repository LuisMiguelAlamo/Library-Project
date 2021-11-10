
package proyconect;

import java.sql.SQLException;
import proyconect.controlador.ControladorPrincipal;
import proyconect.conexiones.ClaseAbrirConect;

/**
 *
 * @author Luis Miguel Alamo Hernández
 */
public class ProyConect {


    public static void main(String[] args) throws SQLException{

        ClaseAbrirConect.abrirConect();
        ControladorPrincipal ctrlpri = new ControladorPrincipal();

    }

}
