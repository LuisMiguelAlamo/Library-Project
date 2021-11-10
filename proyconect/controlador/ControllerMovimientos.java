package proyconect.controlador;

import proyconect.model.ClaseNegocioPrestamos;
import proyconect.model.ClaseNegocioLibros;
import java.sql.SQLException;
import proyconect.model.ClaseTablaPrestamos;
import proyconect.model.DtoAlumno;
import proyconect.model.DtoLibros;
import proyconect.model.DtoPrestamos;
import proyconect.vista.DlgMovimientos;
import proyconect.vista.DlgIntermedio;
import proyconect.vista.DlgLibros;
import proyconect.vista.FrmPrincipal;

/**
 *
 * @author Luis Miguel
 */
public class ControllerMovimientos {

    DlgMovimientos mov;
    ClaseEventosMovimientos eventomov;
    FrmPrincipal frmpri;
    ClaseTablaPrestamos tab;
    ClaseNegocioPrestamos negPre;
    ClaseNegocioLibros neglibro;
    DtoPrestamos prestamo;
    DlgIntermedio inter;
    DlgLibros lib;
    DtoLibros libro;

    public ControllerMovimientos(FrmPrincipal frmpri) throws SQLException {
        negPre = new ClaseNegocioPrestamos();
        mov = new DlgMovimientos(frmpri);
        eventomov = new ClaseEventosMovimientos(mov, this);
        this.frmpri = frmpri;
        libro = new DtoLibros();
        neglibro = new ClaseNegocioLibros();
        prestamo = new DtoPrestamos();
        iniciarTabla(0);

        mov.getBtnBuscar().addActionListener(eventomov);
        mov.getBtnCerrar().addActionListener(eventomov);
        mov.getBtnMas().addActionListener(eventomov);
        mov.getBtnMenos().addActionListener(eventomov);
        mov.getBtnEditar().addActionListener(eventomov);
        mov.getTablaPrestamos().addMouseListener(eventomov);
        mov.getBtnMas().setEnabled(false);
        mov.getBtnMenos().setEnabled(false);
        mov.getBtnEditar().setEnabled(false);
        mov.setVisible(true);
    }

    public void seleccionarAlumno() throws SQLException {
        ControllerAlumnos alumCtrl = new ControllerAlumnos(frmpri, true);
        DtoAlumno alumno = alumCtrl.getAlumnito();
        mov.getCampoRegistro().setText(String.valueOf(alumno.getNumeroRegistro()));
        mov.getCampoDni().setText(alumno.getDni());
        mov.getCampoNombre().setText(alumno.getNombre());
        mov.getCampoApellido1().setText(alumno.getApellido1());
        mov.getCampoApellido2().setText(alumno.getApellido2());
        iniciarTabla(alumno.getNumeroRegistro());
    }

    private void iniciarTabla(int idAlumno) throws SQLException {
        negPre.realizarConsula(idAlumno);
        tab = new ClaseTablaPrestamos(negPre);
        mov.getTablaPrestamos().setModel(tab);
    }

    public void realizarAltas() throws SQLException {
        ControllerIntermedio inter = new ControllerIntermedio(frmpri, getAlumno(), prestamo, 0);
        iniciarTabla(Integer.parseInt(mov.getCampoRegistro().getText()));
    }
    
    public void editar() throws SQLException{
        ControllerIntermedio inter = new ControllerIntermedio(frmpri, getAlumno(), prestamoSeleccionado(), 1);
        iniciarTabla(Integer.parseInt(mov.getCampoRegistro().getText()));
    }

    public void realizarBajas() throws SQLException {
        prestamoSeleccionado();
        negPre.bajaPrestamo(prestamo);
        iniciarTabla(Integer.parseInt(mov.getCampoRegistro().getText()));
    }

    public DtoPrestamos prestamoSeleccionado() throws SQLException {
        prestamo.setId((int) mov.getTablaPrestamos().getValueAt(mov.getTablaPrestamos().getSelectedRow(), 0));
        prestamo.setTitulo((String) mov.getTablaPrestamos().getValueAt(mov.getTablaPrestamos().getSelectedRow(), 1));
        prestamo.setAutor((String) mov.getTablaPrestamos().getValueAt(mov.getTablaPrestamos().getSelectedRow(), 2));
        prestamo.setFechaPrestamo((String) mov.getTablaPrestamos().getValueAt(mov.getTablaPrestamos().getSelectedRow(), 3));
        prestamo.setFechaDevolucion((String) mov.getTablaPrestamos().getValueAt(mov.getTablaPrestamos().getSelectedRow(), 4));
        prestamo.setEstado((String) mov.getTablaPrestamos().getValueAt(mov.getTablaPrestamos().getSelectedRow(), 5));
        prestamo.setCodLibros((int) mov.getTablaPrestamos().getValueAt(mov.getTablaPrestamos().getSelectedRow(), 6));
        
        neglibro.realizarConsula(prestamo.getCodLibros());
        libro = neglibro.getLibro();
        prestamo.setEditorial(libro.getEditorial());
        prestamo.setAsignatura(libro.getAsignatura());
        prestamo.setEstadoLibro(libro.getEstado());
        
        prestamo.setCodAlumnos(Integer.parseInt(mov.getCampoRegistro().getText()));
        return prestamo;
    }

    public DtoAlumno getAlumno() {
        DtoAlumno alumno = new DtoAlumno();
        alumno.setNumeroRegistro(Integer.parseInt(mov.getCampoRegistro().getText()));
        return alumno;
    }

}
