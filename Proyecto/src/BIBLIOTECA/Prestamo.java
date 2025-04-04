package BIBLIOTECA;

import java.time.LocalDate;
/**
 * Clase que representa un préstamo en la biblioteca.
 * Contiene información sobre el usuario, el libro y la fecha del préstamo.
 */
public class Prestamo {
    /**
     * Usuario que realiza el préstamo.
     */
    private Usuario usuario;
    /**
     * Libro que se presta.
     */
    private Libro libro;
    /**
     * Fecha en la que se realizó el préstamo.
     */
    private LocalDate fechaPrestamo;
    /**
     * Constructor de la clase Prestamo.
     *
     * @param usuario       El usuario que realiza el préstamo.
     * @param libro         El libro que se presta.
     * @param fechaPrestamo La fecha del préstamo.
     */
    public Prestamo(Usuario usuario, Libro libro, LocalDate fechaPrestamo) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
    }
    /**
     * Obtiene el usuario del préstamo.
     *
     * @return El usuario que realiza el préstamo.
     */
    public Usuario getUsuario() {
        return usuario;
    }
    /**
     * Establece el usuario del préstamo.
     *
     * @param usuario El usuario que realiza el préstamo.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    /**
     * Obtiene el libro del préstamo.
     *
     * @return El libro que se presta.
     */
    public Libro getLibro() {
        return libro;
    }
    /**
     * Establece el libro del préstamo.
     *
     * @param libro El libro que se presta.
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    /**
     * Obtiene la fecha del préstamo.
     *
     * @return La fecha en la que se realizó el préstamo.
     */
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }
    /**
     * Establece la fecha del préstamo.
     *
     * @param fechaPrestamo La nueva fecha del préstamo.
     */
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    /**
     * Devuelve una representación en forma de cadena del objeto Prestamo.
     *
     * @return Una cadena con los detalles del préstamo.
     */
    public String toString() {
        return "Préstamo{" +
                "usuario=" + usuario +
                ", libro=" + libro +
                ", fecha de préstamo=" + fechaPrestamo +
                '}';
    }
}