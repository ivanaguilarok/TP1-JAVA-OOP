import java.util.ArrayList;
import java.util.List;

public class Profesor extends Persona implements MiembroUniversidad {
    private String especialidad;
    private int aniosExperiencia;
    private List<Materia> materiasAsignadas;

    // Constructor
    public Profesor(String nombre, String apellido, int edad, String documento, 
                    String especialidad, int aniosExperiencia) {
        super(nombre, apellido, edad, documento);
        setEspecialidad(especialidad);
        setAniosExperiencia(aniosExperiencia);
        this.materiasAsignadas = new ArrayList<>();
    }
    
    // Constructor por defecto
    public Profesor() {
        super();
        this.materiasAsignadas = new ArrayList<>();
    }

    // Getters y Setters
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        if (especialidad != null && !especialidad.trim().isEmpty()) {
            this.especialidad = especialidad;
        } else {
            System.out.println("La especialidad no puede estar vacía.");
        }
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        if (aniosExperiencia >= 0) {
            this.aniosExperiencia = aniosExperiencia;
        } else {
            System.out.println("Los años de experiencia no pueden ser negativos.");
        }
    }
    
    public List<Materia> getMateriasAsignadas() {
        return materiasAsignadas;
    }

    // Método específico
    public void asignarMateria(Materia materia) {
        if (materia != null && !materiasAsignadas.contains(materia)) {
            materiasAsignadas.add(materia);
            // Opcional: Asignar este profesor a la Materia
            // materia.setProfesor(this);
            System.out.println(getNombre() + " " + getApellido() + " ha sido asignado a la materia.");
        }
    }

    // Método toString()
    @Override
    public String toString() {
        String infoPersona = super.toString();
        return "Profesor: [" + infoPersona + 
               ", Especialidad: " + especialidad + 
               ", Años Experiencia: " + aniosExperiencia + 
               ", Materias Impartidas: " + materiasAsignadas.size() + "]";
    }

    // Interfaz MiembroUniversidad
    @Override
    public String obtenerRol() {
        return "Profesor";
    }
    @Override
    public String obtenerInformacionCompleta() {
        return this.toString();
    }
}