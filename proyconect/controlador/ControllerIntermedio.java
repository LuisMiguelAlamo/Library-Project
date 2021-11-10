package proyconect.controlador;

import java.sql.SQLException;
import proyconect.model.ClaseNegocioPrestamos;
import proyconect.model.ClaseTablaPrestamos;
import proyconect.model.DtoPrestamos;
import proyconect.vista.DlgIntermedio;
import proyconect.vista.FrmPrincipal;
import proyconect.model.DtoAlumno;
import proyconect.model.DtoLibros;

/**
 *
 * @author Luis Miguel Alamo Hermández
 */
public class ControllerIntermedio {

    DlgIntermedio inter;
    ControllerMovimientos ctrlMov;

    ClaseEventosIntermedio evenInter;
    FrmPrincipal frmpri;
    ClaseTablaPrestamos tabPres;
    ClaseNegocioPrestamos negPres;
    DtoPrestamos prestamo;
    DtoAlumno alumno;
    DtoLibros libro;
    int action;
    

    public ControllerIntermedio(FrmPrincipal frm, DtoAlumno alumno, DtoPrestamos prestamo, int action) throws SQLException {
        inter = new DlgIntermedio(frm);
        negPres = new ClaseNegocioPrestamos();
        evenInter = new ClaseEventosIntermedio(inter, this);
        this.frmpri = frm;
        this.alumno = alumno;
        this.prestamo = prestamo;
        this.action = action;
        System.out.println(prestamo.getAutor());
        inter.getBtnBuscar().addActionListener(evenInter);
        inter.getBtnAceptar().addActionListener(evenInter);
        inter.getBtnCancelar().addActionListener(evenInter);
        if (action == 1) {
            llenarIntermedio();
        }
        inter.setVisible(true);
        
    }

    public int getAction() {
        return action;
    }

    public void agregarPrestamo() throws SQLException {
        prestamo = new DtoPrestamos();

        prestamo.setCodLibros(Integer.parseInt(inter.getCampoCodigo().getText().isEmpty() ? "" : inter.getCampoCodigo().getText()));
        prestamo.setCodAlumnos(alumno.getNumeroRegistro());
        prestamo.setTitulo(inter.getCampoTitulo().getText().isEmpty() ? "" : inter.getCampoTitulo().getText());
        prestamo.setAutor(inter.getCampoAutor().getText().isEmpty() ? "" : inter.getCampoAutor().getText());
        prestamo.setFechaPrestamo(inter.getCampoPrestado().getText().isEmpty() ? "" : inter.getCampoPrestado().getText());
        prestamo.setFechaDevolucion(inter.getCampoDevuelto().getText().isEmpty() ? "" : inter.getCampoDevuelto().getText());
        prestamo.setEstado(inter.getCampoEstado2().getText().isEmpty() ? "" : inter.getCampoEstado2().getText());

        negPres.altaPrestamo(prestamo);
    }
    
    public void editar() throws SQLException {
        prestamo.setFechaPrestamo(inter.getCampoPrestado().getText().isEmpty() ? "" : inter.getCampoPrestado().getText());
        prestamo.setFechaDevolucion(inter.getCampoDevuelto().getText().isEmpty() ? "" : inter.getCampoDevuelto().getText());
        prestamo.setEstado(inter.getCampoEstado2().getText().isEmpty() ? "" : inter.getCampoEstado2().getText());
        
        negPres.editarPrestamo(prestamo);
    }

    public DtoPrestamos getPrestamo() {
        return prestamo;
    }

    private void llenarIntermedio() {
        inter.getCampoCodigo().setText(String.valueOf(prestamo.getCodLibros()));
        inter.getCampoTitulo().setText(prestamo.getTitulo());
        inter.getCampoAutor().setText(prestamo.getAutor());
        inter.getCampoEditorial().setText(prestamo.getEditorial());
        inter.getCampoAsignatura().setText(prestamo.getAsignatura());
        inter.getCampoEstado().setText(prestamo.getEstadoLibro());
        inter.getCampoPrestado().setText(prestamo.getFechaPrestamo());
        inter.getCampoDevuelto().setText(prestamo.getFechaDevolucion());
        inter.getCampoEstado2().setText(prestamo.getEstado());

    }

    

}
