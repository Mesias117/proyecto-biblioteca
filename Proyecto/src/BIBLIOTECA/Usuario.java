package BIBLIOTECA;
public class Usuario {
    private String nombre;
    private String identificacion;
    private String tipoUsuario; // Estudiante, Profesor o Ciudadano

    public Usuario(String nombre, String identificacion, String tipoUsuario) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.tipoUsuario = tipoUsuario;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", identificación='" + identificacion + '\'' +
                ", tipo de usuario='" + tipoUsuario + '\'' +
                '}';
    }
}
