package proyconect.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import proyconect.conexiones.ClaseConect;
import proyconect.model.DtoPrestamos;

/**
 *
 * @author Luis Miguel
 */
public class ClaseNegocioPrestamos {

    ClaseConect clcone;
    ResultSet rs;
    String nombre;

    public ClaseNegocioPrestamos() {
        clcone = new ClaseConect();
    }

    public DtoPrestamos getPrestamo() throws SQLException {
        DtoPrestamos prestamo = new DtoPrestamos();
        prestamo.setId(rs.getInt("id"));
        prestamo.setFechaPrestamo(rs.getString("FechaPrestamo"));
        prestamo.setFechaDevolucion(rs.getString("FechaDevolucion"));
        prestamo.setEstado(rs.getString("estado"));
        prestamo.setTitulo(rs.getString("titulo"));
        prestamo.setAutor(rs.getString("autor"));
        prestamo.setAsignatura(rs.getString("Asignatura"));
        prestamo.setEditorial(rs.getString("Editorial"));
        prestamo.setEstadoLibro(rs.getString("estadoLibro"));
        prestamo.setCodLibros(rs.getInt("codLibros"));

        return prestamo;

    }

    public void realizarConsula(int codAlumno) throws SQLException {
        clcone.consultaStatement("SELECT prestamos.id, libros.Titulo,libros.Autor, libros.Editorial, libros.Asignatura, \n"
                + " libros.estado as estadoLibro, prestamos.FechaPrestamo, prestamos.FechaDevolucion, prestamos.estado, prestamos.codLibros\n"
                + "FROM prestamos\n"
                + "JOIN libros\n"
                + "ON prestamos.codLibros = libros.codigo\n"
                + "WHERE prestamos.codAlumno =" + codAlumno);
        rs = clcone.getRs();
    }
    
    public void consultaGeneral() throws SQLException{
        clcone.consultaStatement("SELECT * FROM prestamos");
        rs = clcone.getRs();
    }

    public void altaPrestamo(DtoPrestamos prestamo) throws SQLException {
        String sql = "INSERT INTO prestamos VALUES (NULL, '" + prestamo.getCodAlumnos() + "',' \n"
                + "" + prestamo.getCodLibros() + "','\n"
                + prestamo.getFechaPrestamo() + "',' \n"
                + prestamo.getFechaDevolucion() + prestamo.getEstado() + "';";
        System.out.println(sql);
        clcone.insertarStatement("INSERT INTO prestamos VALUES (NULL, '" + prestamo.getCodAlumnos() + "',' \n"
                + "" + prestamo.getCodLibros() + "',' \n"
                + "" + prestamo.getFechaPrestamo() + "',' \n"
                + prestamo.getFechaDevolucion() + "',' \n"
                + prestamo.getEstado() + "');");
    }

    public void bajaPrestamo(DtoPrestamos prestamo) throws SQLException {
        clcone.insertarStatement("DELETE  FROM prestamos  WHERE id = '" + prestamo.getId() + "';");
    }

    public void editarPrestamo(DtoPrestamos prestamo) throws SQLException {
        clcone.insertarStatement("UPDATE prestamos SET FechaPrestamo = '" + prestamo.getFechaPrestamo() + "', FechaDevolucion = ' \n"
                + "" + prestamo.getFechaDevolucion() + "', estado = '" + prestamo.getEstado()+ "' WHERE id = '" + prestamo.getId() + "';");
    }

    public ResultSet getRes() throws SQLException {
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
        return md.getColumnCount()-3;

    }
}
