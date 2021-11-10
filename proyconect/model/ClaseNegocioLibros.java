package proyconect.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import proyconect.conexiones.ClaseConect;
import proyconect.model.DtoLibros;

/**
 *
 * @author Luis Miguel Alamo Hernández
 */
public class ClaseNegocioLibros {

    ClaseConect clcone;
    ResultSet rs;

    public ClaseNegocioLibros() {
        clcone = new ClaseConect();
    }

    public DtoLibros getLibro() throws SQLException {
        DtoLibros libro = new DtoLibros();
        libro.setCodigo(rs.getInt("codigo"));
        libro.setTitulo(rs.getString("titulo"));
        libro.setAutor(rs.getString("autor"));
        libro.setEditorial(rs.getString("editorial"));
        libro.setAsignatura(rs.getString("asignatura"));
        libro.setEstado(rs.getString("estado"));
        return libro;
    }

    public void realizarConsula(int codlibro) throws SQLException {
        System.out.println("Consulta");
        clcone.consultaStatement("select * from libros WHERE  codigo = " + codlibro);
        rs = clcone.getRs();
    }
    
    public void realizarConsula() throws SQLException {
        System.out.println("Consulta");
        clcone.consultaStatement("select * from libros");
        rs = clcone.getRs();
    }
    
    public void hacerConsulta(String campo) throws SQLException {
        System.out.println("Consulta busqueda");
        String sql = ""+ "titulo like '%" + campo + "%'"
                + "OR autor like '%" + campo + "%'"
                + "OR editorial like '%" + campo + "%'"
                + "OR asignatura like '%" + campo + "%'"
                + "OR estado like '%" + campo + "%'"
                ;
        clcone.consultaStatement("Select * from libros where " + sql + ";");
        rs = clcone.getRs();
    }
    
    public void atrapaLibro(int codLibro) throws SQLException {
        clcone.consultaStatement("Select * from libros where codigo =" + codLibro + ";");
        rs = clcone.getRs();
    }

    public void realizarAlta(DtoLibros libro) throws SQLException {
        clcone.insertarStatement("INSERT INTO libros VALUES ( null,'" + libro.getTitulo() + "','" + libro.getAutor() + "','" + libro.getEditorial() + "','" + libro.getAsignatura() + "','" + libro.getEstado() + "');");
    }

    public void realizarBaja(DtoLibros libro) throws SQLException {
        clcone.insertarStatement("DELETE  FROM libros WHERE codigo = '" + libro.getCodigo() + "';");
    }

    public void realizarModificacion(DtoLibros libro) throws SQLException {
        String sql = "UPDATE libros SET titulo = '" + libro.getTitulo() + "', autor = '" + libro.getAutor() + "', editorial = '" + libro.getEditorial() + "', asignatura = '" + libro.getAsignatura() + "', estado = '" + libro.getEstado() + "' WHERE codigo = '" + libro.getCodigo() + "';";
        clcone.insertarStatement(sql);
    }

    public ResultSet getRs() {
        return rs;
    }

    public int numeroFilas() throws SQLException {
        rs.last();
        return rs.getRow();
    }

    public void moverSiguiente(int index) throws SQLException {
        rs.absolute(index);
    }

    public int numeroColumnas() throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        return md.getColumnCount();

    }


}
