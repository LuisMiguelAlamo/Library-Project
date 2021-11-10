
package proyconect.model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luis Miguel
 */
public class ClaseTablaPrestamos extends AbstractTableModel{
    
    Object o;
    String [] columnas = {"Id", "Titulo", "Autor", "Fecha_Prestamo", "Fecha_Devolucion", "Estado", "codLibros"};
    ClaseNegocioPrestamos negPre;
    DtoPrestamos prestamo;

    public ClaseTablaPrestamos(ClaseNegocioPrestamos negocio) {
        this.negPre = negocio;
        prestamo = new DtoPrestamos();
    }
    
    

    @Override
    public int getRowCount() {
        int fila = 0;
        try {
            fila = negPre.numeroFilas();
        } catch (SQLException ex) {
            //Logger.getLogger(ClaseTablaAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fila;
    }

    @Override
    public int getColumnCount() {
        int columna = 0;
        try {
            columna = negPre.numeroColumnas();
            System.out.println(columna);
        } catch (SQLException ex) {
//            Logger.getLogger(ClaseTablaAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return columna;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            try {
                negPre.moverSiguiente(rowIndex + 1);
                prestamo = negPre.getPrestamo();
            } catch (SQLException ex) {
               // Logger.getLogger(ClaseTablaAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return prestamo.getId();
        }
        if (columnIndex == 1) {

            return prestamo.getTitulo();
        }
        if (columnIndex == 2) {
            return prestamo.getAutor();
        }
        if(columnIndex == 3){
            return prestamo.getFechaPrestamo();
        }
        if(columnIndex == 4){
            return prestamo.getFechaDevolucion();
        }
        if(columnIndex == 5){
            return prestamo.getEstado();
        } 
        if(columnIndex == 6){
            return prestamo.getCodLibros();
        } 
        
        return o;
    }
    
    @Override
    public String getColumnName(int i) {
        return columnas[i];
    }
    
}
