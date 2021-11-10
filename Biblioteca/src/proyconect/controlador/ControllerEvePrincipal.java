
package proyconect.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import proyconect.vista.FrmPrincipal;

/**
 *
 * @author Luis Miguel Alamo Hernández
 */
public class ControllerEvePrincipal implements ActionListener {

    FrmPrincipal frm;

    public ControllerEvePrincipal(FrmPrincipal frm) {
        this.frm = frm;
        this.frm.getjButtonAlumno().addActionListener(this);
        this.frm.getjButtonLibros().addActionListener(this);
        this.frm.getjButtonMovimiento().addActionListener(this);
        this.frm.getjButtonSalir().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource().equals(this.frm.getjButtonAlumno())) {
            try {
                ControllerAlumnos ctrl = new ControllerAlumnos(frm, false);
            } catch (SQLException ex) {
                System.out.println("No funcionó el botón Alumnos");
            }
        }
        if(ae.getSource().equals(this.frm.getjButtonLibros())){
            try {
                ControllerLibros ctrlib = new ControllerLibros(frm, false);
            } catch (SQLException ex) {
                System.out.println("No funcionó el botón Libros");
            }
        }
        if(ae.getSource().equals(this.frm.getjButtonSalir())){
            System.exit(0);
        }
        if(ae.getSource().equals(this.frm.getjButtonMovimiento())){
            try {
                ControllerMovimientos ctrlmov = new ControllerMovimientos(frm);
            } catch (SQLException ex) {
                System.out.println("No salió Movimientos");
            }
        }
    }

}
