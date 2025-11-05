import java.util.ArrayList;
import java.util.List;
/* import java.util.Objects; */

public class Estudiante extends Persona implements MiembroUniversidad {
    private String carrera;
    private double promedio;
    private List<Materia> materias;

    // Constructor Default
    public Estudiante() {
        super();
        this.materias = new ArrayList<>();
    }

    // Constructor que usa el constructor de la clase base (Persona)
    public Estudiante(String nombre, String apellido, int edad, String documento, String carrera) {
        super(nombre, apellido, edad, documento);
        setCarrera(carrera);
        this.materias = new ArrayList<>();
    }

    // Getters y Setters específicos
    @Override
    public void setEdad(int edad) {
        if(edad > 17) {
            super.setEdad(edad);
        } else {
            System.out.println("La edad debe ser mayor de 17 para ser Estudiante.");
        }
    }
    
    public String getCarrera() {
        return carrera;
    }
    public void setCarrera(String carrera) {
        if(carrera != null && !carrera.trim().isEmpty()) {
            this.carrera = carrera;
        } else {
            System.out.println("La carrera no puede estar vacía.");
        }
    }

    public double getPromedio() {
        return promedio;
    }
    public void setPromedio(double promedio) {
        if(promedio >= 0.0 && promedio <= 10.0) {
            this.promedio = promedio;
        } else {
            System.out.println("El promedio debe estar entre 0.0 y 10.0.");
        }
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    // Métodos
    public void agregarMateria(Materia materia) {
        materias.add(materia);
    }

    // 1. Versión Iterativa para calcular el promedio
    public double calcularPromedioIterativo() {
        if(materias.isEmpty()) {
            this.promedio = 0;
            return 0.0;
        } else {
            double suma = 0.0;
            for(Materia m : materias) {
                suma += m.getCalificacion(); 
            }
            double nuevoPromedio = suma / materias.size();
            this.promedio = nuevoPromedio;
            return nuevoPromedio;
        }
    }
    
    public void calcularPromedio() {
        this.calcularPromedioIterativo();
    }


    // 2. Versión Recursiva para calcular la SUMA de calificaciones
    public static double calcularPromedioRecursivo(Materia[] materias, int indice) {
        if (indice >= materias.length) {
            return 0.0;
        }
        return materias[indice].getCalificacion() + calcularPromedioRecursivo(materias, indice + 1);
    }
    
    // 3. Método Auxiliar que usa la recursividad y actualiza el promedio del Estudiante
    public double obtenerPromedioRecursivo() {
        if (this.getMaterias().isEmpty()) {
            this.promedio = 0;
            return 0.0;
        }
        Materia[] materiasArray = this.getMaterias().toArray(new Materia[0]);
        double sumaTotal = calcularPromedioRecursivo(materiasArray, 0);
        
        // Calcula y actualiza el promedio final
        double nuevoPromedio = sumaTotal / materiasArray.length;
        this.promedio = nuevoPromedio;
        
        return nuevoPromedio;
    }

    // Método toString() mejorado
    @Override
    public String toString() {
        String infoPersona = super.toString();
        return "Estudiante: [" + infoPersona + 
               ", Carrera: " + carrera + 
               ", Promedio: " + String.format("%.2f", promedio) + 
               ", Total Materias: " + materias.size() + "]";
    }

    // Interfaz de MiembroUniversidad
    @Override
    public String obtenerRol() {
        return "Estudiante";
    }
    @Override
    public String obtenerInformacionCompleta() {
        return this.toString(); 
    }
}