package proyconect.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyconect.vista.DlgMovimientos;
import proyconect.vista.FrmPrincipal;

/**
 *
 * @author Luis Miguel Alamo Hernández
 */
public class ClaseEventosMovimientos implements ActionListener, MouseListener {

    DlgMovimientos mov;
    ControllerMovimientos ctrlmov;
    FrmPrincipal frmpri;

    public ClaseEventosMovimientos(DlgMovimientos mov, ControllerMovimientos ctrl) {
        this.mov = mov;
        this.ctrlmov = ctrl;
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(mov.getBtnBuscar())) {
            try {
                ctrlmov.seleccionarAlumno();
                mov.getBtnMas().setEnabled(true);
                mov.getBtnMenos().setEnabled(true);
            } catch (SQLException ex) {
                Logger.getLogger(ClaseEventosMovimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(mov.getBtnCerrar())) {
            mov.dispose();
        }
        if (e.getSource().equals(mov.getBtnEditar())) {
            try {
                ctrlmov.editar();
            } catch (SQLException ex) {
                Logger.getLogger(ClaseEventosMovimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(mov.getBtnMas())) {
            try {
                ctrlmov.realizarAltas();
            } catch (SQLException ex) {
                Logger.getLogger(ClaseEventosMovimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(mov.getBtnMenos())) {
            try {
                ctrlmov.realizarBajas();
            } catch (SQLException ex) {
                Logger.getLogger(ClaseEventosMovimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        try {
            mov.getBtnEditar().setEnabled(true);
            ctrlmov.prestamoSeleccionado();
        } catch (SQLException ex) {
            Logger.getLogger(ClaseEventosMovimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
