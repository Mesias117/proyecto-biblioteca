package BIBLIOTECA;
import java.util.Scanner;
import java.time.*;
import java.util.ArrayList;
/*
 * @author Andres Rojas
 * 
 */
/**
 * Clase principal de la aplicación de gestión de biblioteca.
 * Permite interactuar con la biblioteca a través de un menú en la consola.
 */
public class App {

    /**
     * Método principal que ejecuta la aplicación.
     *
     * 
     */
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de gestión de la biblioteca.");
        
        while (true) {
            System.out.println("|Menú:                                            |");
            System.out.println("|1. Registrar un libro                            |");
            System.out.println("|2. Mostrar todos los libros                      |");
            System.out.println("|3. Realizar un préstamo                          |");
            System.out.println("|4. Registrar un usuario                          |");
            System.out.println("|5. Buscar un usuario por identificación          |");
            System.out.println("|6. Eliminar un usuario por identificación        |");
            System.out.println("|7. Buscar libro por título                       |");
            System.out.println("|8. Buscar libro por autor                        |");
            System.out.println("|9. Buscar libro por ISBN                         |");
            System.out.println("|10. Eliminar libro por ISBN                      |");
            System.out.println("|11. Salir                                        |");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
            /**
             * Caso para registrar un nuevo libro en la biblioteca.
             * Solicita al usuario los datos del libro y lo registra en la biblioteca.
             */
                case 1:
                    System.out.println("Ingrese el título del libro:");
                    String titulo = scanner.nextLine();
                    System.out.println("Ingrese el autor del libro:");
                    String autor = scanner.nextLine();
                    System.out.println("Ingrese el año de publicación:");
                    int anioPublicacion = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el ISBN:");
                    String isbn = scanner.nextLine();
                    System.out.println("Ingrese el número de ejemplares disponibles:");
                    int ejemplaresDisponibles = scanner.nextInt();

                    biblioteca.registrarLibro(new Libro(titulo, autor, anioPublicacion, isbn, ejemplaresDisponibles));
                    System.out.println("¡Libro registrado exitosamente!");
                    break;
                    /**
                     * Caso para mostrar todos los libros disponibles en la biblioteca.
                     * Muestra un mensaje si no hay libros disponibles.
                     */
                case 2:
                    if (biblioteca.getLibros().isEmpty()) {
                        System.out.println("No hay libros disponibles en la biblioteca.");
                    } else {
                        biblioteca.mostrarLibros();
                    }
                    break;
                    /**
                     * Caso para realizar un préstamo de un libro a un usuario.
                     * Solicita la identificación del usuario y el título del libro.
                     */
                case 3:
                    System.out.println("Ingrese la identificación del usuario:");
                    String idUsuario = scanner.nextLine();
                    Usuario usuario = biblioteca.buscarUsuarioPorIdentificacion(idUsuario);
                    if (usuario == null) {
                        System.out.println("Usuario no encontrado.");
                        break;
                    }
                    System.out.println("Ingrese el título del libro a prestar:");
                    String tituloLibro = scanner.nextLine();
                    biblioteca.realizarPrestamo(usuario, tituloLibro);
                    break;
                    /**
                     * Caso para registrar un nuevo usuario en la biblioteca.
                     * Solicita los datos del usuario y lo registra.
                     */
                case 4:
                    System.out.println("Ingrese el nombre del usuario:");
                    String nombreUsuario = scanner.nextLine();
                    System.out.println("Ingrese la identificación del usuario:");
                    String identificacionUsuario = scanner.nextLine();
                    System.out.println("Ingrese el tipo de usuario (Estudiante, Profesor, Ciudadano):");
                    String tipoUsuario = scanner.nextLine();
                
                    Usuario nuevoUsuario = new Usuario(nombreUsuario, identificacionUsuario, tipoUsuario);
                    biblioteca.registrarUsuario(nuevoUsuario);
                
                    System.out.println("¡Usuario registrado exitosamente!");
                    break;
                    /**
                     * Caso para buscar un usuario por su identificación.
                     * Muestra la información del usuario si se encuentra.
                     */
                case 5:
                    System.out.println("Ingrese la identificación del usuario a buscar:");
                    String buscarIdUsuario = scanner.nextLine();
                    Usuario usuarioEncontrado = biblioteca.buscarUsuarioPorIdentificacion(buscarIdUsuario);
                    if (usuarioEncontrado != null) {
                        System.out.println(usuarioEncontrado);
                    } else {
                        System.out.println("No se encontró ningún usuario con esa identificación.");
                    }
                    break;
                    /**
                     * Caso para eliminar un usuario por su identificación.
                     */
                case 6:
                    System.out.println("Ingrese la identificación del usuario a eliminar:");
                    String idUsuarioEliminar = scanner.nextLine();
                    biblioteca.eliminarUsuarioPorIdentificacion(idUsuarioEliminar);
                    System.out.println("Usuario eliminado exitosamente.");
                    break;
                    /**
                     * Caso para buscar libros por título.
                     * Muestra los libros encontrados con el título especificado.
                     */
                case 7:
                    System.out.println("Ingrese el título del libro a buscar:");
                    String tituloBuscar = scanner.nextLine();
                    ArrayList<Libro> librosPorTitulo = biblioteca.buscarLibroPorTitulo(tituloBuscar);
                    if (librosPorTitulo.isEmpty()) {
                        System.out.println("No se encontraron libros con ese título.");
                    } else {
                        System.out.println("Libros encontrados:");
                        for (Libro libro : librosPorTitulo) {
                            System.out.println(libro);
                        }
                    }
                    break;
                    /**
                     * Caso para buscar libros por autor.
                     * Muestra los libros encontrados del autor especificado.
                     */
                case 8:
                    System.out.println("Ingrese el autor del libro a buscar:");
                    String autorBuscar = scanner.nextLine();
                    ArrayList<Libro> librosPorAutor = biblioteca.buscarLibroPorAutor(autorBuscar);
                    if (librosPorAutor.isEmpty()) {
                        System.out.println("No se encontraron libros con ese autor.");
                    } else {
                        System.out.println("Libros encontrados:");
                        for (Libro libro : librosPorAutor) {
                            System.out.println(libro);
                        }
                    }
                    break;
                    /**
                     * Caso para buscar un libro por ISBN.
                     * Muestra la información del libro si se encuentra.
                     */
                case 9:
                    System.out.println("Ingrese el ISBN del libro a buscar:");
                    String buscarISBN = scanner.nextLine();
                    Libro libroEncontrado = biblioteca.buscarLibroPorISBN(buscarISBN);
                    if (libroEncontrado != null) {
                        System.out.println(libroEncontrado);
                    } else {
                        System.out.println("No se encontró ningún libro con ese ISBN.");
                    }
                    break;
                    /**
                     * Caso para eliminar un libro por ISBN.
                     */
                case 10:
                    System.out.println("Ingrese el ISBN del libro a eliminar:");
                    String isbnEliminar = scanner.nextLine();
                    biblioteca.eliminarLibroPorISBN(isbnEliminar);
                    System.out.println("Libro eliminado exitosamente.");
                    break;
                    /**
                     * Caso para salir del programa.
                     */
                case 11:
                    System.out.println("Saliendo...");
                    return;
                    /**
                     * Caso por defecto para manejar opciones inválidas.
                     */
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
