
package proyconect.controlador;

import proyconect.vista.DlgAlumnos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Luis Miguel Alamo Hernández
 */
public class ClaseEventosAlumnos implements ActionListener, MouseListener, DocumentListener {

    DlgAlumnos frm;
    ControllerAlumnos ctrl;

    public ClaseEventosAlumnos(DlgAlumnos frm, ControllerAlumnos ctrl) {
        this.frm = frm;
        this.ctrl = ctrl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(frm.getBtnAltas())) {
            try {
                System.out.println("clicked");
                ctrl.realizarAltas();
            } catch (SQLException ex) {
                // Logger.getLogger(ClaseEventosAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (e.getSource().equals(frm.getBtnBajas())) {
            try {
                System.out.println("clicked");
                ctrl.realizarBajas();
            } catch (SQLException ex) {
                // Logger.getLogger(ClaseEventosAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (e.getSource().equals(frm.getBtnModificaciones())) {
                try {
                    System.out.println("clicked");
                    ctrl.realizarModificaciones();
                } catch (SQLException ex) {
                    Logger.getLogger(ClaseEventosAlumnos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        if (e.getSource().equals(frm.getBtnSalir())) {
                try {
                    System.out.println("clicked");
                    ctrl.salir();
                } catch (SQLException ex) {
                    //Logger.getLogger(ClaseEventosAlumnos.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        if (e.getSource().equals(frm.getBtnSeleccionar())) {
                
                    System.out.println("clicked");
                    ctrl.realizarSeleccion();

            }

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        ctrl.ponerTabla();
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
        ctrl.activarTimer();
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        ctrl.activarTimer();
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        ctrl.activarTimer();
    }
}
