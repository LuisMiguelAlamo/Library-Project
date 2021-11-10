
package proyconect.model;

import proyconect.conexiones.ClaseConect;
import proyconect.model.DtoAlumno;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author Luis Miguel Alamo Hernández
 */
public class ClaseNegocioAlumno {

    ClaseConect clcone;
    ResultSet rs;
    String nombre;

    public ClaseNegocioAlumno() {
        clcone = new ClaseConect();
    }

    public DtoAlumno getAlumno() throws SQLException{
        DtoAlumno alumno=new DtoAlumno();
        alumno.setNombre(rs.getString("nombre"));
        alumno.setNumeroRegistro(rs.getInt("registro"));
        alumno.setDni(rs.getString("dni"));
        alumno.setApellido1(rs.getString("apellido1"));
        alumno.setApellido2(rs.getString("apellido2"));
        
        return alumno;
        
    }
    public void realizarConsula() throws SQLException {
        clcone.consultaStatement("select * from alumnos");
        rs = clcone.getRs();
    }
    
    public void hacerConsulta(String campo) throws SQLException {
        String sql = ""+ "dni like '%" + campo + "%'"
                + "OR nombre like '%" + campo + "%'"
                + "OR apellido1 like '%" + campo + "%'"
                + "OR apellido2 like '%" + campo + "%'"
                ;
        clcone.consultaStatement("Select * from alumnos where " + sql + ";");
        rs = clcone.getRs();
    }

    public void realizarAlta(DtoAlumno alumno) throws SQLException {
        clcone.insertarStatement("INSERT INTO alumnos VALUES (null,'"+ alumno.getDni() + "','" + alumno.getNombre() + "','" + alumno.getApellido1() + "','" + alumno.getApellido2() + "');");
    }
    
    public void realizarBaja(DtoAlumno alumno) throws SQLException{
        clcone.insertarStatement("DELETE  FROM alumnos WHERE dni = '"+ alumno.getDni() + "';" );
    }
    
    public void realizarModificacion(DtoAlumno alumno) throws SQLException{
        String sql = "UPDATE alumnos SET dni = '"+alumno.getDni()+"', nombre = '"+alumno.getNombre()+"', apellido1 = '"+alumno.getApellido1()+"', apellido2 = '"+alumno.getApellido2()+"' WHERE registro = '"+ alumno.getNumeroRegistro() +"';";
        clcone.insertarStatement(sql);
    }

    public ResultSet getRes() throws SQLException {
        return rs;
    }

    public int numeroFilas() throws SQLException {
        rs.last();
        return rs.getRow();
    }
    
    public void moverSiguiente(int index) throws SQLException{
        rs.absolute(index);
    }

    public int numeroColumnas() throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        return md.getColumnCount();

    }
    
    
      //<editor-fold defaultstate="collapsed" desc="Uso de PreparedStatement">  

     /* public void ActualizarII() throws Exception {

        if (_buscar.isEmpty()) {

            _cldatos.Ejecutar_Consulta("SELECT * FROM alumnos;");
            //     Alumno=_cldatos.getRs();
        } else {
            // Filtramos por cualquier campo...
            // TODO: Cambiar el filtro para que incluya una condición por cada palabra
            // y que se obtenga los resultados cuando incluya todas las palabras
            PreparedStatement stmt = _cldatos.PrepareSmt("SELECT * FROM alumnos WHERE "
                    + "dni LIKE ? "
                    + "OR nombre LIKE ? "
                    + "OR apellido1 LIKE ? "
                    + "OR apellido2 LIKE ?");

            stmt.setString(1, "%" + _buscar + "%");
            stmt.setString(2, "%" + _buscar + "%");
            stmt.setString(3, "%" + _buscar + "%");
            stmt.setString(4, "%" + _buscar + "%");

            stmt.executeQuery();
        }
        _rs = _cldatos.getRs();
    }

    public int ModificarII(Alumno alumno) throws Exception {
        PreparedStatement stmt = _cldatos.PrepareSmt("UPDATE alumnos SET "
                + "dni = ?, nombre = ?, apellido1 = ?, apellido2 = ? "
                + "WHERE registro = ?;");

        stmt.setString(1, alumno.getDni());
        stmt.setString(2, alumno.getNombre());
        stmt.setString(3, alumno.getApellido1());
        stmt.setString(4, alumno.getApellido2());
        stmt.setInt(5, alumno.getRegistro());

        int fila = stmt.executeUpdate();

        if (fila > 0) {
            ActualizarII();
        }
        return fila;
    }
*/
    public void realizarConsultaPsmt() throws Exception {
            String buscar="";
            PreparedStatement stmt = clcone.PrepareSmt("SELECT * FROM alumnos WHERE "
                    + "dni LIKE ? "
                    + "OR nombre LIKE ? "
                    + "OR apellido1 LIKE ? "
                    + "OR apellido2 LIKE ?");

            stmt.setString(1, "%" + buscar + "%");
            stmt.setString(2, "%" + buscar + "%");
            stmt.setString(3, "%" + buscar + "%");
            stmt.setString(4, "%" + buscar + "%");

            stmt.executeQuery();
        }
        
    
    public int insertarPreparedstatement(DtoAlumno alumno) throws Exception {
        
        PreparedStatement stmt = clcone.PrepareSmtAltas("INSERT INTO alumnos VALUES( null, ?, ?, ?, ? );");
       // stmt.setString(1, alumno.getDni());
        stmt.setString(2, alumno.getNombre());
        //stmt.setString(3, alumno.getApellido1());
        //stmt.setString(4, alumno.getApellido2());

        stmt.executeUpdate();

        ResultSet keys = stmt.getGeneratedKeys();
        int id = -1;
        if (keys.next()) {
            id = keys.getInt(1);
            //System.out.println( "El id generado es : " + id );
        }
        alumno.setNumeroRegistro(id);
        if (id > 0) {
            //actualizar la tabla
        }
        return id;
    }
   
    
   // </editor-fold>
    
}
