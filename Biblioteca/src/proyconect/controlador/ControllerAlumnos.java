package proyconect.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import proyconect.model.DtoAlumno;
import proyconect.vista.*;
import java.sql.SQLException;
import javax.swing.Timer;
import proyconect.model.ClaseNegocioAlumno;
import proyconect.model.ClaseTablaAlumnos;

/**
 *
 * @author Luis Miguel Alamo Hernández
 */
public class ControllerAlumnos {

    DlgAlumnos frm;
    ClaseNegocioAlumno clnegocio;
    ClaseEventosAlumnos claseeventoalumno;
    ClaseTablaAlumnos claseTabla;
    private static final int TIEMPO_BUSCAR = 300;
    private Timer timer_buscar;
    DtoAlumno alumno;
    boolean condicion;

    public ControllerAlumnos(FrmPrincipal frmpri, boolean condicion) throws SQLException {

        clnegocio = new ClaseNegocioAlumno();
        frm = new DlgAlumnos(frmpri);
        claseeventoalumno = new ClaseEventosAlumnos(frm, this);
        this.condicion = condicion;
        if(condicion){
            frm.getBtnSeleccionar().setEnabled(true);
            frm.getBtnAltas().setEnabled(false);
            frm.getBtnBajas().setEnabled(false);
            frm.getBtnModificaciones().setEnabled(false);
        }else{
            frm.getBtnSeleccionar().setEnabled(false);
        }
        clnegocio.realizarConsula();

        claseTabla = new ClaseTablaAlumnos(clnegocio);

        alumno = new DtoAlumno();
        alumno = clnegocio.getAlumno();

        frm.getCampoFiltro().getDocument().addDocumentListener(claseeventoalumno);
        frm.getTablaAlumnos().setModel(claseTabla);
        frm.getBtnAltas().addActionListener(claseeventoalumno);
        frm.getBtnBajas().addActionListener(claseeventoalumno);
        frm.getBtnModificaciones().addActionListener(claseeventoalumno);
        frm.getBtnSeleccionar().addActionListener(claseeventoalumno);
        frm.getBtnSalir().addActionListener(claseeventoalumno);
        frm.getTablaAlumnos().addMouseListener(claseeventoalumno);
        frm.setVisible(true);

    }

    public void realizarAltas() throws SQLException {
        alumno.setDni(frm.getTxtDni().getText().isEmpty() ? "" : frm.getTxtDni().getText());
        alumno.setNombre(frm.getTxtNombre().getText().isEmpty() ? "" : frm.getTxtNombre().getText());
        alumno.setApellido1(frm.getTxtApellido1().getText().isEmpty() ? "" : frm.getTxtApellido1().getText());
        alumno.setApellido2(frm.getTxtApellido2().getText().isEmpty() ? "" : frm.getTxtApellido2().getText());
        System.out.println(frm.getTxtDni().getText().isEmpty() ? "" : frm.getTxtDni().getText());
        clnegocio.realizarAlta(alumno);
        actualizaTabla();
        limpiaCampos();
    }

    public void realizarBajas() throws SQLException {
        alumno.setDni(frm.getTxtDni().getText());
        clnegocio.realizarBaja(alumno);
        actualizaTabla();
        limpiaCampos();
    }

    public void realizarModificaciones() throws SQLException {
        System.out.println("Modificó");
        alumno.setDni(frm.getTxtDni().getText().isEmpty() ? "" : frm.getTxtDni().getText());
        alumno.setNumeroRegistro(Integer.parseInt(frm.getTxtRegistro().getText()));
        alumno.setNombre(frm.getTxtNombre().getText().isEmpty() ? "" : frm.getTxtNombre().getText());
        alumno.setApellido1(frm.getTxtApellido1().getText().isEmpty() ? "" : frm.getTxtApellido1().getText());
        alumno.setApellido2(frm.getTxtApellido2().getText().isEmpty() ? "" : frm.getTxtApellido2().getText());
        System.out.println(frm.getTxtDni().getText().isEmpty() ? "" : frm.getTxtDni().getText());
        clnegocio.realizarModificacion(alumno);
        actualizaTabla();
        limpiaCampos();

    }

    public void realizarSeleccion() {
        alumno = new DtoAlumno();

        alumno.setDni(frm.getTxtDni().getText().isEmpty() ? "" : frm.getTxtDni().getText());
        alumno.setNumeroRegistro(Integer.parseInt(frm.getTxtRegistro().getText()));
        alumno.setNombre(frm.getTxtNombre().getText().isEmpty() ? "" : frm.getTxtNombre().getText());
        alumno.setApellido1(frm.getTxtApellido1().getText().isEmpty() ? "" : frm.getTxtApellido1().getText());
        alumno.setApellido2(frm.getTxtApellido2().getText().isEmpty() ? "" : frm.getTxtApellido2().getText());

        frm.setVisible(false);
    }

    public DtoAlumno getAlumnito() {
        return alumno;
    }

    public void salir() throws SQLException {
        System.out.println("Salió");
        frm.dispose();
    }

    public void ponerTabla() {
        frm.getTxtRegistro().setText(String.valueOf(frm.getTablaAlumnos().getValueAt(frm.getTablaAlumnos().getSelectedRow(), 0)));
        frm.getTxtDni().setText(String.valueOf(frm.getTablaAlumnos().getValueAt(frm.getTablaAlumnos().getSelectedRow(), 1)));
        frm.getTxtNombre().setText(String.valueOf(frm.getTablaAlumnos().getValueAt(frm.getTablaAlumnos().getSelectedRow(), 2)));
        frm.getTxtApellido1().setText(String.valueOf(frm.getTablaAlumnos().getValueAt(frm.getTablaAlumnos().getSelectedRow(), 3)));
        frm.getTxtApellido2().setText(String.valueOf(frm.getTablaAlumnos().getValueAt(frm.getTablaAlumnos().getSelectedRow(), 4)));

    }

    public void activarTimer() {
        if ((timer_buscar != null) && timer_buscar.isRunning()) {
            timer_buscar.restart();
        } else {
            timer_buscar = new Timer(TIEMPO_BUSCAR, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    timer_buscar = null;
                    try {
                        clnegocio.hacerConsulta(frm.getCampoFiltro().getText());
                        claseTabla.fireTableDataChanged();
                    } catch (SQLException e) {
                        System.out.println("Salió mal");
                    }
                }
            });
            timer_buscar.setRepeats(false);
            timer_buscar.start();
        }
    }
    
    private void actualizaTabla() throws SQLException{
        clnegocio.realizarConsula();
        claseTabla = new ClaseTablaAlumnos(clnegocio);
        frm.getTablaAlumnos().setModel(claseTabla);
    }

    private void limpiaCampos() {
        frm.getTxtRegistro().setText("");
        frm.getTxtDni().setText("");
        frm.getTxtNombre().setText("");
        frm.getTxtApellido1().setText("");
        frm.getTxtApellido2().setText("");
    }
}
