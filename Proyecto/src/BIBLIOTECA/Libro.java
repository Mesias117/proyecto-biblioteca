package BIBLIOTECA;

/**
 * Clase que representa un libro en la biblioteca.
 * Contiene información sobre el título, autor, año de publicación, ISBN y número de ejemplares disponibles.
 */
public class Libro {
    /**
     * Título del libro.
     */
    private String titulo;
    /**
     * Autor del libro.
     */
    private String autor;
    /**
     * Año de publicación del libro.
     */
    private int añoPublicacion;
    /**
     * ISBN del libro.
     */
    private String isbn;
    /**
     * Número de ejemplares disponibles del libro.
     */
    private int ejemplaresDisponibles;
    /**
     * Constructor de la clase Libro.
     *
     * @param titulo               Título del libro.
     * @param autor                Autor del libro.
     * @param añoPublicacion       Año de publicación del libro.
     * @param isbn                 ISBN del libro.
     * @param ejemplaresDisponibles Número de ejemplares disponibles del libro.
     */
    public Libro(String titulo, String autor, int añoPublicacion, String isbn, int ejemplaresDisponibles) {
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.isbn = isbn;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }
    /**
     * Obtiene el título del libro.
     *
     * @return El título del libro.
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     * Establece el título del libro.
     *
     * @param titulo El nuevo título del libro.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * Obtiene el autor del libro.
     *
     * @return El autor del libro.
     */
    public String getAutor() {
        return autor;
    }
    /**
     * Establece el autor del libro.
     *
     * @param autor El nuevo autor del libro.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }
    /**
     * Obtiene el año de publicación del libro.
     *
     * @return El año de publicación del libro.
     */
    public int getAnioPublicacion() {
        return añoPublicacion;
    }
    /**
     * Establece el año de publicación del libro.
     *
     * @param anioPublicacion El nuevo año de publicación del libro.
     */
    public void setAnioPublicacion(int anioPublicacion) {
        this.añoPublicacion = anioPublicacion;
    }
    /**
     * Obtiene el ISBN del libro.
     *
     * @return El ISBN del libro.
     */
    public String getIsbn() {
        return isbn;
    }
    /**
     * Establece el ISBN del libro.
     *
     * @param isbn El nuevo ISBN del libro.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    /**
     * Obtiene el número de ejemplares disponibles del libro.
     *
     * @return El número de ejemplares disponibles del libro.
     */
    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }
    /**
     * Establece el número de ejemplares disponibles del libro.
     *
     * @param ejemplaresDisponibles El nuevo número de ejemplares disponibles del libro.
     */
    public void setEjemplaresDisponibles(int ejemplaresDisponibles) {
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }
    /**
     * Disminuye el número de ejemplares disponibles en uno, si hay ejemplares disponibles.
     */
    public void disminuirEjemplares() {
        if (ejemplaresDisponibles > 0) {
            ejemplaresDisponibles--;
        }
    }
    /**
     * Aumenta el número de ejemplares disponibles en uno.
     */
    public void aumentarEjemplares() {
        ejemplaresDisponibles++;
    }
    /**
     * Devuelve una representación en forma de cadena del objeto Libro.
     *
     * @return Una cadena con los detalles del libro.
     */
    public String toString() {
        return "Libro:" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", año de publicación=" + añoPublicacion +
                ", ISBN='" + isbn + '\'' +
                ", ejemplares disponibles=" + ejemplaresDisponibles;
    }
}
