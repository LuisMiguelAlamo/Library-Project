
package proyconect.model;

/**
 *
 * @author Luis Miguel
 */
public class DtoPrestamos {
    
    int id;
    int codAlumnos;
    int codLibros;
    String fechaPrestamo;
    String fechaDevolucion;
    String estado;
    String titulo;
    String autor;
    String editorial;
    String asignatura;
    String estadoLibro;
    
    
    
    public DtoPrestamos(){
        
    }

    public DtoPrestamos(int id, int codAlumnos, int codLibros,String titulo, String autor, String fechaPrestamo, String fechaDevolucion, String estado, String editorial, String asignatura, String estadoLibro) {
        this.id = id;
        this.codAlumnos = codAlumnos;
        this.codLibros = codLibros;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
        this.titulo = titulo;
        this.autor = autor;
        this.asignatura = asignatura;
        this.editorial = editorial;
        this.estadoLibro = estadoLibro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodAlumnos() {
        return codAlumnos;
    }

    public void setCodAlumnos(int codAlumnos) {
        this.codAlumnos = codAlumnos;
    }

    public int getCodLibros() {
        return codLibros;
    }

    public void setCodLibros(int codLibros) {
        this.codLibros = codLibros;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getEstadoLibro() {
        return estadoLibro;
    }

    public void setEstadoLibro(String estadoLibro) {
        this.estadoLibro = estadoLibro;
    }
    
    
    
    
}
