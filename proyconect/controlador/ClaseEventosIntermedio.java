package proyconect.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import proyconect.model.DtoLibros;
import proyconect.vista.DlgIntermedio;
import proyconect.vista.FrmPrincipal;

/**
 *
 * @author Luis Miguel Alamo Hermández
 */
public class ClaseEventosIntermedio implements ActionListener {

    DlgIntermedio intermedio;
    ControllerIntermedio ctrlInter;
    FrmPrincipal frmpri;
    Pattern p = Pattern.compile("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$");
    Matcher m, n;

    public ClaseEventosIntermedio(DlgIntermedio intermedio, ControllerIntermedio ctrlInter) {
        this.intermedio = intermedio;
        this.ctrlInter = ctrlInter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(intermedio.getBtnBuscar())) {
            System.out.println("Buscó");
            try {
                ControllerLibros lib = new ControllerLibros(frmpri, true);
                DtoLibros libro = lib.getLibro();
                intermedio.getCampoCodigo().setText(String.valueOf(libro.getCodigo()));
                intermedio.getCampoTitulo().setText(libro.getTitulo());
                intermedio.getCampoAutor().setText(libro.getAutor());
                intermedio.getCampoEditorial().setText(libro.getEditorial());
                intermedio.getCampoAsignatura().setText(libro.getAsignatura());
                intermedio.getCampoEstado().setText(libro.getEstado());

            } catch (SQLException ex) {
                Logger.getLogger(ControllerIntermedio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource().equals(intermedio.getBtnAceptar())) {
            try {
                if (ctrlInter.getAction() == 0) {
                    m = p.matcher(intermedio.getCampoPrestado().getText());
                    n = p.matcher(intermedio.getCampoDevuelto().getText());

                    if (!m.matches() || !n.matches()) {
                        JOptionPane.showMessageDialog(null, "La fecha no cumple con el formato solicitado, vuelva a introducirla");
                    }else{
                    ctrlInter.agregarPrestamo();
                    intermedio.dispose();    
                    }
                }
                if (ctrlInter.getAction() == 1) {
                    m = p.matcher(intermedio.getCampoPrestado().getText());
                    n = p.matcher(intermedio.getCampoDevuelto().getText());
                    
                    if (!m.matches() || !n.matches()) {
                        JOptionPane.showMessageDialog(null, "La fecha no cumple con el formato solicitado, vuelva a introducirla");
                    }else{
                    ctrlInter.editar();
                    intermedio.dispose();    
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(ControllerIntermedio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource().equals(intermedio.getBtnCancelar())) {
            intermedio.dispose();
        }
    }

}
