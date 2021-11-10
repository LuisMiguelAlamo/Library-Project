
package proyconect.model;

import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luis Miguel
 */
public class ClaseTablaLibros extends AbstractTableModel{
    
    Object o;
    String [] columnas = {"codigo", "titulo", "autor", "editorial", "asignatura", "estado"};
    ClaseNegocioLibros negLib;
    DtoLibros libro;

    public ClaseTablaLibros(ClaseNegocioLibros negLib) {
        this.negLib = negLib;
        libro = new DtoLibros();
    }
    
    

    @Override
    public int getRowCount() {
        int fila = 0;
        try {
            fila = negLib.numeroFilas();
        } catch (SQLException ex) {
            System.out.println("Algo salió mal con las filas");
        }
        return fila;
    }

    @Override
    public int getColumnCount() {
        int columna = 0;
        try {
            columna = negLib.numeroColumnas();
        } catch (SQLException ex) {
            System.out.println("Algo salió mal con las columnas");
        }
        return columna;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            try {
                negLib.moverSiguiente(rowIndex + 1);
                libro = negLib.getLibro();
            } catch (SQLException ex) {
               System.out.println("Algo salió mal con la obtención del valor de la celda");
            }
            return libro.getCodigo();
        }
        if (columnIndex == 1) {

            return libro.getTitulo();
        }
        if (columnIndex == 2) {
            return libro.getAutor();
        }
        if(columnIndex == 3){
            return libro.getEditorial();
        }
        if(columnIndex == 4){
            return libro.getAsignatura();
        }     
        if(columnIndex == 5){
            return libro.getEstado();
        } 
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return o;
    }

    @Override
    public String getColumnName(int i) {
        return columnas[i];
    }
    
    
    
}
