import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void imprimirEstudiantes(String titulo, Estudiante[] estudiantes) {
        System.out.println("--- " + titulo + " ---");
        for (Estudiante e : estudiantes) {
            System.out.println(" |-> " + e.getApellido() + ", " + e.getNombre() + " (" + e.getCarrera() + ")");
        }
    }

    public static void main(String[] args) {
        // --- 1. Inicialización y Herencia ---
        Universidad miUniversidad = new Universidad("Universidad de Levantamiento de Pala");

        Estudiante est1 = new Estudiante("Ana", "Gomez", 20, "45123456", "Ingeniería de Software");
        Estudiante est2 = new Estudiante("Carlos", "Arias", 22, "40000000", "Derecho");
        Estudiante est3 = new Estudiante("Laura", "Zapata", 19, "48765432", "Medicina");
        Estudiante est4 = new Estudiante("Juan", "Díaz", 25, "35987654", "Ingeniería de Software");
        
        Profesor prof1 = new Profesor("Roberto", "Pérez", 45, "15789012", "Física Teórica", 15);
        Personal pers1 = new Personal("Marta", "Juárez", 35, "28345678", "Recursos Humanos", "Analista Senior", LocalDate.of(2018, 5, 10));

        // --- 2. Demostración de Polimorfismo ---
        System.out.println("\n===== 1. DEMOSTRACIÓN DE POLIMORFISMO =====");
        
        miUniversidad.agregarMiembro(est1);
        miUniversidad.agregarMiembro(prof1);
        miUniversidad.agregarMiembro(pers1);
        miUniversidad.agregarMiembro(est2);
        
        miUniversidad.listarTodosLosMiembros();

        // --- 3. Demostración de Algoritmos Recursivos e Iterativos (Estudiante) ---
        System.out.println("\n===== 2. CALCULO DE PROMEDIOS (Recursivo vs. Iterativo) =====");
        
        Materia m1 = new Materia("POO", "PRG101", 6, 85, prof1);
        Materia m2 = new Materia("Bases de Datos", "DB101", 5, 90, prof1);
        Materia m3 = new Materia("Matemática", "MAT101", 7, 70, null);
        
        est1.agregarMateria(m1);
        est1.agregarMateria(m2);
        est1.agregarMateria(m3);

        Materia[] materiasArray = est1.getMaterias().toArray(new Materia[0]);
        double promedioIterativo = est1.calcularPromedioIterativo();
        System.out.println("Promedio de " + est1.getNombre() + " (Iterativo): " + String.format("%.2f", promedioIterativo));
        double sumaRecursiva = Estudiante.calcularPromedioRecursivo(materiasArray, 0);
        double promedioRecursivo = sumaRecursiva / materiasArray.length;
        System.out.println("Promedio de " + est1.getNombre() + " (Recursivo): " + String.format("%.2f", promedioRecursivo));

        // --- 4. Demostración de Algoritmos Recursivos e Iterativos (Universidad) ---
        System.out.println("\n===== 3. CONTEO DE ESTUDIANTES (Recursivo vs. Iterativo) =====");
        
        Estudiante[] estudiantesArray = {est1, est2, est3, est4};
        String carreraBuscar = "Ingeniería de Software";

        int conteoIterativo = Universidad.contarEstudiantesIterativo(estudiantesArray, carreraBuscar);
        System.out.println("Conteo de '" + carreraBuscar + "' (Iterativo): " + conteoIterativo);

        int conteoRecursivo = Universidad.contarEstudiantesRecursivo(estudiantesArray, carreraBuscar, 0);
        System.out.println("Conteo de '" + carreraBuscar + "' (Recursivo): " + conteoRecursivo);

        // --- 5. Búsqueda y Ordenamiento ---
        System.out.println("\n===== 4. ORDENAMIENTO Y BÚSQUEDA BINARIA =====");
        
        // a. Ordenamiento (Selection Sort)
        imprimirEstudiantes("Array Original (Desordenado)", estudiantesArray);
        
        Estudiante[] arrayOrdenado = Universidad.ordenarEstudiantesPorApellido(estudiantesArray);
        
        imprimirEstudiantes("Array Ordenado por Apellido", arrayOrdenado);
        
        // b. Búsqueda Binaria (Requiere array ordenado)
        String apellidoBuscar = "Díaz"; // Juan Díaz
        int indiceEncontrado = Universidad.busquedaBinariaEstudiantes(arrayOrdenado, apellidoBuscar);

        System.out.println("\n--- Búsqueda Binaria de Apellido: " + apellidoBuscar + " ---");
        if (indiceEncontrado != -1) {
            System.out.println("Estudiante '" + apellidoBuscar + "' encontrado en índice: " + indiceEncontrado);
            System.out.println("   Info: " + arrayOrdenado[indiceEncontrado].obtenerInformacionCompleta());
        } else {
            System.out.println("Estudiante con apellido '" + apellidoBuscar + "' no encontrado.");
        }
        
        // Prueba de no encontrado
        String apellidoNoEncontrado = "Ximenes";
        indiceEncontrado = Universidad.busquedaBinariaEstudiantes(arrayOrdenado, apellidoNoEncontrado);
        System.out.println("\n--- Búsqueda Binaria de Apellido: " + apellidoNoEncontrado + " ---");
        System.out.println((indiceEncontrado != -1 ? "Encontrado" : "No encontrado"));
    }
}