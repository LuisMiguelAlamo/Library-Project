
package proyconect.model;

import proyconect.model.DtoAlumno;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luis Miguel Alamo Hernández
 */
public class ClaseTablaAlumnos extends AbstractTableModel {

    Object o;
    String [] columnas = {"registro", "dni", "nombre", "apellido1", "apellido2"};
    ClaseNegocioAlumno clnegocio;
    DtoAlumno alumno;

    public ClaseTablaAlumnos(ClaseNegocioAlumno clnegocio) {
        this.clnegocio = clnegocio;
        alumno = new DtoAlumno();
    }

    @Override
    public int getRowCount() {
        int fila = 0;
        try {
            fila = clnegocio.numeroFilas();
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(ClaseTablaAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fila;
    }

    @Override
    public int getColumnCount() {
        int columna = 0;
        try {
            columna = clnegocio.numeroColumnas();

            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
//            Logger.getLogger(ClaseTablaAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return columna;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        if (columnIndex == 0) {
            try {
                clnegocio.moverSiguiente(rowIndex + 1);
                alumno = clnegocio.getAlumno();
            } catch (SQLException ex) {
               // Logger.getLogger(ClaseTablaAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return alumno.getNumeroRegistro();
        }
        if (columnIndex == 1) {

            return alumno.getDni();
        }
        if (columnIndex == 2) {
            return alumno.getNombre();
        }
        if(columnIndex == 3){
            return alumno.getApellido1();
        }
        if(columnIndex == 4){
            return alumno.getApellido2();
        }        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return o;
    }

    @Override
    public String getColumnName(int i) {
        return columnas[i];
    }
    
    

}
