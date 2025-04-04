package BIBLIOTECA;
import java.util.ArrayList;
import java.time.LocalDate;
/**
 * Clase que representa una biblioteca, gestionando libros, usuarios y préstamos.
 */
public class Biblioteca {

    /**
     * Lista de libros en la biblioteca.
     */
    private ArrayList<Libro> libros = new ArrayList<>();

    /**
     * Lista de usuarios registrados en la biblioteca.
     */
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    /**
     * Lista de préstamos realizados en la biblioteca.
     */
    private ArrayList<Prestamo> prestamos = new ArrayList<>();
    /**
     * Registra un nuevo libro en la biblioteca.
     *
     * @param libro El libro a registrar.
     */
    public void registrarLibro(Libro libro) { 
    	libros.add(libro); 
    }
    /**
     * Muestra la información de todos los libros en la biblioteca.
     */
    public void mostrarLibros() { for (Libro libro : libros) { 
    	System.out.println(libro); 
    	}
    }
    /**
     * Busca libros por título.
     *
     * @param titulo El título del libro a buscar (puede ser parcial).
     * @return Una lista de libros que coinciden con el título buscado.
     */
    public ArrayList<Libro> buscarLibroPorTitulo(String titulo) {
        ArrayList<Libro> librosEncontrados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;
    }
    /**
     * Busca libros por autor.
     *
     * @param autor El autor del libro a buscar (puede ser parcial).
     * @return Una lista de libros que coinciden con el autor buscado.
     */
    public ArrayList<Libro> buscarLibroPorAutor(String autor) {
        ArrayList<Libro> librosEncontrados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;
    }
    /**
     * Busca un libro por su ISBN.
     *
     * @param isbn El ISBN del libro a buscar.
     * @return El libro encontrado, o null si no se encuentra.
     */
    public Libro buscarLibroPorISBN(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }
    /**
     * Elimina un libro de la biblioteca por su ISBN.
     *
     * @param isbn El ISBN del libro a eliminar.
     */
    public void eliminarLibroPorISBN(String isbn) {
        libros.removeIf(libro -> libro.getIsbn().equals(isbn));
    }
    /**
     * Actualiza la información de un libro existente.
     *
     * @param isbn      El ISBN del libro a actualizar.
     * @param nuevoLibro El nuevo objeto Libro con la información actualizada.
     */
    public void actualizarInformacionLibro(String isbn, Libro nuevoLibro) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getIsbn().equals(isbn)) {
                libros.set(i, nuevoLibro);
                break;
            }
        }
    }
    /**
     * Obtiene la lista de libros en la biblioteca.
     *
     * @return La lista de libros.
     */
    public ArrayList<Libro> getLibros() { 
    	return libros; 
    	}
    /**
     * Registra un nuevo usuario en la biblioteca.
     *
     * @param usuario El usuario a registrar.
     */
    public void registrarUsuario(Usuario usuario) { 
    	usuarios.add(usuario); 
    	}
    /**
     * Busca un usuario por su identificación.
     *
     * @param id La identificación del usuario a buscar.
     * @return El usuario encontrado, o null si no se encuentra.
     */
    public Usuario buscarUsuarioPorIdentificacion(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdentificacion().equals(id)) {
                return usuario;
            }
        }
        return null;
    }
    /**
     * Elimina un usuario de la biblioteca por su identificación.
     *
     * @param id La identificación del usuario a eliminar.
     */
    public void eliminarUsuarioPorIdentificacion(String id) {
        usuarios.removeIf(usuario -> usuario.getIdentificacion().equals(id));
    }
    /**
     * Obtiene la lista de usuarios registrados en la biblioteca.
     *
     * @return La lista de usuarios.
     */
    public ArrayList<Usuario> getUsuarios() { 
    	return usuarios; 
    	}
    /**
     * Realiza un préstamo de un libro a un usuario.
     *
     * @param usuario     El usuario que realiza el préstamo.
     * @param tituloLibro El título del libro a prestar.
     */
    public void realizarPrestamo(Usuario usuario, String tituloLibro) {
        ArrayList<Libro> librosEncontrados = buscarLibroPorTitulo(tituloLibro);
        if (librosEncontrados.isEmpty()) {
            System.out.println("No se encontró ningún libro con ese título.");
            return;
        }
        
        Libro libro = librosEncontrados.get(0); // Tomamos el primer libro encontrado
        if (libro.getEjemplaresDisponibles() > 0) {
            LocalDate fechaPrestamo = LocalDate.now();
            Prestamo prestamo = new Prestamo(usuario, libro, fechaPrestamo);
            prestamos.add(prestamo);
            libro.disminuirEjemplares();
            System.out.println("Préstamo realizado con éxito.");
        } else {
            System.out.println("No hay ejemplares disponibles para prestar.");
        }
    }
    /**
     * Registra un préstamo en la biblioteca.
     *
     * @param prestamo El préstamo a registrar.
     */
    public void registrarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }
}
