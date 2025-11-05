import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private String nombreCarrera;
    private List<Estudiante> estudiantes;

    public Carrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
        estudiantes = new ArrayList<>();
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }
    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void mostrarEstudiantes() {
        for (Estudiante est : estudiantes) {
            System.out.println(
                "Nombre: " + est.getNombre() + 
                " " + est.getApellido() + 
                ", Edad: " + est.getEdad() + 
                ", Promedio: " + est.getPromedio()
            );
        }
    }

    public Estudiante buscarEstudiante(String nombre) {
        for (Estudiante est : estudiantes) {
            if (est.getNombre().equalsIgnoreCase(nombre)) {
                return est;
            }
        }
        return null;
    }
}
