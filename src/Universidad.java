import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombre;
    private List<MiembroUniversidad> miembros; 

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.miembros = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarMiembro(MiembroUniversidad miembro) {
        if (miembro != null) {
            miembros.add(miembro);
            System.out.println("Miembro agregado: " + miembro.obtenerRol() + " - " + ((Persona)miembro).getNombre());
        }
    }

    public void listarTodosLosMiembros() {
        System.out.println("\n--- Listado de Miembros de la " + nombre + " ---");
        if (miembros.isEmpty()) {
            System.out.println("No hay miembros registrados.");
            return;
        }
        for (MiembroUniversidad miembro : miembros) {
            System.out.println("-> Rol: " + miembro.obtenerRol());
            System.out.println("   Info: " + miembro.obtenerInformacionCompleta());
        }
        System.out.println("----------------------------------------");
    }

    public void buscarPorRol(String rol) {
        System.out.println("\n--- Buscando Miembros con Rol: " + rol + " ---");
        int contador = 0;
        for (MiembroUniversidad miembro : miembros) {
            if (miembro.obtenerRol().equalsIgnoreCase(rol)) {
                System.out.println("   " + miembro.obtenerInformacionCompleta());
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("No se encontraron miembros con el rol '" + rol + "'.");
        }
        System.out.println("----------------------------------------");
    }
    
    // --- Métodos de Ayuda para Algoritmos ---
    private Estudiante[] obtenerEstudiantesArray() {
        List<Estudiante> estudiantesList = new ArrayList<>();
        for (MiembroUniversidad miembro : miembros) {
            if (miembro instanceof Estudiante) {
                estudiantesList.add((Estudiante) miembro);
            }
        }
        return estudiantesList.toArray(new Estudiante[0]);
    }
    
    // --- 2. Contar Estudiantes por Carrera ---
    // Versión Iterativa
    public static int contarEstudiantesIterativo(Estudiante[] estudiantes, String carrera) {
    int contador = 0;
    for (Estudiante e : estudiantes) {
        if (e.getCarrera().equals(carrera)) {
            contador++;
        }
    }
        return contador;
    }

    // Versión Recursiva (Método Estático)
    public static int contarEstudiantesRecursivo(Estudiante[] estudiantes, String carrera, int indice) {
        if (indice >= estudiantes.length) {
            return 0;
        }
        
        int sumaActual = 0;
        if (estudiantes[indice].getCarrera() != null && estudiantes[indice].getCarrera().equalsIgnoreCase(carrera)) {
            sumaActual = 1;
        }
        
        return sumaActual + contarEstudiantesRecursivo(estudiantes, carrera, indice + 1);
    }
    
    public int contarEstudiantesPorCarreraRecursivo(String carrera) {
        Estudiante[] estudiantes = obtenerEstudiantesArray();
        return contarEstudiantesRecursivo(estudiantes, carrera, 0);
    }

    // --- 3. Buscar Estudiante por Documento ---
    // Versión Iterativa
    public Estudiante buscarEstudiantePorDocumentoIterativo(String documento) {
        Estudiante[] estudiantes = obtenerEstudiantesArray();
        for (Estudiante e : estudiantes) {
            if (e.getDocumento() != null && e.getDocumento().equals(documento)) {
                return e;
            }
        }
        return null;
    }

    // Versión Recursiva (Método Estático)
    public static Estudiante buscarEstudianteRecursivo(Estudiante[] estudiantes, String documento, int indice) {
        if (indice >= estudiantes.length) {
            return null;
        }
        if (estudiantes[indice].getDocumento() != null && estudiantes[indice].getDocumento().equals(documento)) {
            return estudiantes[indice];
        }
        return buscarEstudianteRecursivo(estudiantes, documento, indice + 1);
    }
    
    public Estudiante buscarEstudiantePorDocumentoRecursivo(String documento) {
        Estudiante[] estudiantes = obtenerEstudiantesArray();
        return buscarEstudianteRecursivo(estudiantes, documento, 0);
    }

    // Algoritmo de Ordenamiento y Búsqueda
    public static Estudiante[] ordenarEstudiantesPorApellido(Estudiante[] estudiantes) {
        int n = estudiantes.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (estudiantes[j].getApellido().compareTo(estudiantes[indiceMinimo].getApellido()) < 0) {
                    indiceMinimo = j;
                }
            }
            if (indiceMinimo != i) {
                Estudiante temp = estudiantes[i];
                estudiantes[i] = estudiantes[indiceMinimo];
                estudiantes[indiceMinimo] = temp;
            }
        }
        return estudiantes;
    }

    // Busqueda
    public static int busquedaBinariaEstudiantes(Estudiante[] estudiantes, String apellido) {
        int izquierda = 0;
        int derecha = estudiantes.length - 1;
        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            int comparacion = apellido.compareTo(estudiantes[medio].getApellido());
            if (comparacion == 0) {
                return medio;
            } else if (comparacion < 0) {
                derecha = medio - 1;
            } else {
                izquierda = medio + 1;
            }
        }
        return -1;
    }
}