
package proyconect.conexiones;

/**
 *
 * @author Luis Miguel Alamo Hernández
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClaseConect {

    private ResultSet rs = null;

    public ClaseConect() {
   
    }

    public void consultaStatement(String sql) throws SQLException {
        if (ClaseAbrirConect.abrirConect()) {
            Statement stmt = ClaseAbrirConect.getCone().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            rs.next();
        }

    }
    public void actualizarDatos(String sql) throws SQLException{
        Statement stmt = ClaseAbrirConect.getCone().createStatement();
        int i = stmt.executeUpdate(sql);
    }

    public void insertarStatement(String sql) throws SQLException {
        if (ClaseAbrirConect.abrirConect()) {
        Statement stmt = ClaseAbrirConect.getCone().createStatement();
            System.out.println(sql);
        stmt.executeUpdate(sql);
            }
    }
    
      public PreparedStatement PrepareSmtAltas( String query ) throws Exception
    {
        // Comprobamos la conexión
        if( ClaseAbrirConect.abrirConect() )
        {
            // Es una conexión válida.
            // Creamos el Statement y lo devolvemos
            return ClaseAbrirConect.getCone().prepareStatement( query, Statement.RETURN_GENERATED_KEYS );
        }
        return null;
    }
     public PreparedStatement PrepareSmt( String query ) throws Exception
    {
        // Comprobamos la conexión
        if( ClaseAbrirConect.abrirConect() )
        {
            // Es una conexión válida.
            // Creamos el Statement y lo devolvemos
            return ClaseAbrirConect.getCone().prepareStatement( query );
        }
        return null;
    }
    public Connection getCone() {
        return ClaseAbrirConect.getCone();
    }

    public ResultSet getRs() {
        return rs;
    }

}
