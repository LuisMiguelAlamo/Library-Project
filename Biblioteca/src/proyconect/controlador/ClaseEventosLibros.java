package proyconect.controlador;

import proyconect.controlador.ControllerLibros;
import proyconect.vista.DlgLibros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Luis Miguel
 */
public class ClaseEventosLibros implements ActionListener, MouseListener, DocumentListener {

    DlgLibros lib;
    ControllerLibros ctrlib;
    
   

    public ClaseEventosLibros(DlgLibros lib, ControllerLibros ctrlib) {
        this.lib = lib;
        this.ctrlib = ctrlib;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(lib.getBtnAltas())) {
            try {
                System.out.println("clicked");
                ctrlib.realizarAltas();
            } catch (SQLException ex) {
                System.out.println("No ejecutó la acción el botón Altas");
            }
        }
        if (e.getSource().equals(lib.getBtnBajas())) {
            try {
                System.out.println("clicked");
                ctrlib.realizarBajas();
            } catch (SQLException ex) {
                System.out.println("No ejecutó la acción el botón Bajas");
            }
        }
        if (e.getSource().equals(lib.getBtnModificar())) {
            try {
                System.out.println("clicked");
                ctrlib.realizarModificaciones();
            } catch (SQLException ex) {
                System.out.println("No ejecutó la acción el botón Modificar");
            }
        }
        if (e.getSource().equals(lib.getBtnSeleccionar())) {
            try {
                System.out.println("clicked");
                ctrlib.realizarSeleccion();
            } catch (SQLException ex) {
                System.out.println("No ejecutó la acción el botón Seleccionar");
            }
        }
        if (e.getSource().equals(lib.getBtnCerrar())) {
            try {
                System.out.println("Cerró Libros");
                ctrlib.cerrar();
            } catch (SQLException ex) {
                System.out.println("No ejecutó la acción el botón Cerrar");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.println("el botón funciona");
        ctrlib.ponerTablaLibros();
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }


    @Override
    public void insertUpdate(DocumentEvent de) {
        ctrlib.activarTimer();
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        ctrlib.activarTimer();
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        ctrlib.activarTimer();
    }

}
