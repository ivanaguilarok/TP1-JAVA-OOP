import java.util.Objects;

public class Materia {
    private String nombre;
    private String codigo;
    private int creditos;
    private int calificacion;
    private Profesor profesor;

    public Materia(String nombre, String codigo, int creditos, int calificacion, Profesor profesor) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        setCalificacion(calificacion);
        this.profesor = profesor;
    }
    
    // Constructor auxiliar sin calificacion y sin profesor (si se necesita)
    public Materia(String nombre, String codigo, int creditos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.calificacion = 0;
        this.profesor = null;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        if(calificacion >= 0 && calificacion <= 100) {
            this.calificacion = calificacion;
        } else {
            System.out.println("La calificación debe estar entre 0 y 100.");
        }
    }
    
    // *** Getter y Setter para Profesor ***
    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
    // *** Método toString() ***
    @Override
    public String toString() {
        String nombreProfesor = (profesor != null) ? profesor.getNombre() + " " + profesor.getApellido() : "No asignado";
        return "Materia [" +
               "Nombre: " + nombre + 
               ", Código: " + codigo + 
               ", Créditos: " + creditos + 
               ", Calificación: " + calificacion + 
               ", Profesor Asignado: " + nombreProfesor +
               "]";
    }

    // *** Métodos equals() y hashCode() basados en el atributo único 'codigo' ***
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materia materia = (Materia) o;
        return Objects.equals(codigo, materia.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}