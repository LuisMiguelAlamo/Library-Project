package proyconect.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import proyconect.model.DtoLibros;
import proyconect.vista.*;
import java.sql.SQLException;
import javax.swing.Timer;
import proyconect.model.ClaseNegocioLibros;
import proyconect.model.ClaseTablaLibros;

/**
 *
 * @author Luis Miguel Alamo Hernández
 */
public class ControllerLibros {

    DlgLibros li;
    ClaseEventosLibros eventoLibro;
    ClaseNegocioLibros negLibro;
    ClaseTablaLibros tablaLib;
    DtoLibros libro;
    private static final int TIEMPO_BUSCAR = 300;
    private Timer timer_buscar;
    boolean condicion;



    public ControllerLibros(FrmPrincipal frep, boolean condicion) throws SQLException {
        negLibro = new ClaseNegocioLibros();
        li = new DlgLibros(frep);
        eventoLibro = new ClaseEventosLibros(li, this);
        this.condicion = condicion;
        if(condicion){
            li.getBtnSeleccionar().setEnabled(true);
            li.getBtnAltas().setEnabled(false);
            li.getBtnBajas().setEnabled(false);
            li.getBtnModificar().setEnabled(false);
        }else{
            li.getBtnSeleccionar().setEnabled(false);
        }
        negLibro.realizarConsula();

        tablaLib = new ClaseTablaLibros(negLibro);
        
        libro = new DtoLibros();
        libro = negLibro.getLibro();
        
        li.getCampoFiltro().getDocument().addDocumentListener(eventoLibro);
        li.getBtnAltas().addActionListener(eventoLibro);
        li.getBtnBajas().addActionListener(eventoLibro);
        li.getBtnModificar().addActionListener(eventoLibro);
        li.getBtnSeleccionar().addActionListener(eventoLibro);
        li.getBtnCerrar().addActionListener(eventoLibro);
        li.getTablaLibros().addMouseListener(eventoLibro);
        li.getTablaLibros().setModel(tablaLib);
        li.setVisible(true);
    }

    public void realizarAltas() throws SQLException {
        DtoLibros libro = new DtoLibros();
        
        libro.setTitulo(li.getCampoTitulo().getText().isEmpty() ? "" : li.getCampoTitulo().getText());
        libro.setAutor(li.getCampoAutor().getText().isEmpty() ? "" : li.getCampoAutor().getText());
        libro.setEditorial(li.getCampoEditorial().getText().isEmpty() ? "" : li.getCampoEditorial().getText());
        libro.setAsignatura(li.getCampoAsignatura().getText().isEmpty() ? "" : li.getCampoAsignatura().getText());
        libro.setEstado(li.getCampoEstado().getText().isEmpty() ? "" : li.getCampoEstado().getText());
        negLibro.realizarAlta(libro);
        
        actualizarTabla();

        limpiarCampos();
    }

    public void realizarBajas() throws SQLException {
        DtoLibros libro = new DtoLibros();
        libro.setCodigo(Integer.parseInt(li.getCampoCodigo().getText()));
        negLibro.realizarBaja(libro);
        actualizarTabla();
        limpiarCampos();
    }

    public void realizarModificaciones() throws SQLException {
        DtoLibros libro = new DtoLibros();
        
        libro.setCodigo(Integer.parseInt(li.getCampoCodigo().getText().isEmpty() ? "" : li.getCampoCodigo().getText()));
        libro.setTitulo(li.getCampoTitulo().getText().isEmpty() ? "" : li.getCampoTitulo().getText());
        libro.setAutor(li.getCampoAutor().getText().isEmpty() ? "" : li.getCampoAutor().getText());
        libro.setEditorial(li.getCampoEditorial().getText().isEmpty() ? "" : li.getCampoEditorial().getText());
        libro.setAsignatura(li.getCampoAsignatura().getText().isEmpty() ? "" : li.getCampoAsignatura().getText());
        libro.setEstado(li.getCampoEstado().getText().isEmpty() ? "" : li.getCampoEstado().getText());
        negLibro.realizarModificacion(libro);
        actualizarTabla();
        limpiarCampos();
    }

    public void realizarSeleccion() throws SQLException {
        libro = new DtoLibros();
        
        libro.setCodigo(Integer.parseInt(li.getCampoCodigo().getText().isEmpty() ? "" : li.getCampoCodigo().getText()));
        libro.setTitulo(li.getCampoTitulo().getText().isEmpty() ? "" : li.getCampoTitulo().getText());
        libro.setAutor(li.getCampoAutor().getText().isEmpty() ? "" : li.getCampoAutor().getText());
        libro.setEditorial(li.getCampoEditorial().getText().isEmpty() ? "" : li.getCampoEditorial().getText());
        libro.setAsignatura(li.getCampoAsignatura().getText().isEmpty() ? "" : li.getCampoAsignatura().getText());
        libro.setEstado(li.getCampoEstado().getText().isEmpty() ? "" : li.getCampoEstado().getText());
        System.out.println(li.getCampoCodigo().getText().isEmpty() ? "" : li.getCampoCodigo().getText());
        
        li.setVisible(false);
    }

    public void cerrar() throws SQLException {
        li.dispose();
    }
    
    public DtoLibros getLibro(){
        return libro;
    }
    
    public void ponerTablaLibros() {
        System.out.println("Puso la tabla no?");
        li.getCampoCodigo().setText(String.valueOf(li.getTablaLibros().getValueAt(li.getTablaLibros().getSelectedRow(), 0)));
        li.getCampoTitulo().setText(String.valueOf(li.getTablaLibros().getValueAt(li.getTablaLibros().getSelectedRow(), 1)));
        li.getCampoAutor().setText(String.valueOf(li.getTablaLibros().getValueAt(li.getTablaLibros().getSelectedRow(), 2)));
        li.getCampoEditorial().setText(String.valueOf(li.getTablaLibros().getValueAt(li.getTablaLibros().getSelectedRow(), 3)));
        li.getCampoAsignatura().setText(String.valueOf(li.getTablaLibros().getValueAt(li.getTablaLibros().getSelectedRow(), 4)));
        li.getCampoEstado().setText(String.valueOf(li.getTablaLibros().getValueAt(li.getTablaLibros().getSelectedRow(), 5)));

    }
    
    
    public void activarTimer(){
        if((timer_buscar != null)&&timer_buscar.isRunning()){
            timer_buscar.restart();
        }else{
            timer_buscar = new Timer(TIEMPO_BUSCAR, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    timer_buscar = null;
                    try{
                        negLibro.hacerConsulta(li.getCampoFiltro().getText());
                        tablaLib.fireTableDataChanged();
                    }catch(SQLException e){
                        System.out.println("Salió mal");
                    }
                }
            });
            timer_buscar.setRepeats(false);
            timer_buscar.start();
        }
    }
    
    private void limpiarCampos(){
        li.getCampoCodigo().setText("");
        li.getCampoTitulo().setText("");
        li.getCampoAutor().setText("");
        li.getCampoEditorial().setText("");
        li.getCampoAsignatura().setText("");
        li.getCampoEstado().setText("");
    }
  
    private void actualizarTabla() throws SQLException{
        negLibro.realizarConsula();
        tablaLib = new ClaseTablaLibros(negLibro);
        li.getTablaLibros().setModel(tablaLib);
    }


}
