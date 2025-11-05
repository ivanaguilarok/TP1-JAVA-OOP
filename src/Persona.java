import java.util.Objects;

public class Persona { 
    private String nombre;
    private String apellido;
    private int edad;
    private String documento;

    // Constructor que inicializa todos los atributos
    public Persona(String nombre, String apellido, int edad, String documento) {
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
        setDocumento(documento);
    }

    // Constructor sin argumentos
    public Persona() {
        // Inicialización por defecto si es necesaria
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            System.out.println("El nombre no puede estar vacío.");
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido != null && !apellido.trim().isEmpty()) {
            this.apellido = apellido;
        } else {
            System.out.println("El apellido no puede estar vacío.");
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad > 0) {
            this.edad = edad;
        } else {
            System.out.println("La edad debe ser un número positivo.");
        }
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        if (documento != null && !documento.trim().isEmpty()) {
            this.documento = documento;
        } else {
            System.out.println("El documento no puede estar vacío.");
        }
    }

    // Método toString()
    @Override
    public String toString() {
        return "Nombre: " + nombre + " " + apellido +
               ", Edad: " + edad +
               ", Documento: " + documento;
    }

    // Métodos equals() y hashCode() basados en el atributo único 'documento'
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(documento, persona.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }
}
