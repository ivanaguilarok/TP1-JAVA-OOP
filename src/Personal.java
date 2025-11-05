import java.time.LocalDate;
/* import java.util.Objects; */

public class Personal extends Persona implements MiembroUniversidad {
    private String departamento;
    private String puesto;
    private LocalDate fechaIngreso;

    // Constructor
    public Personal(String nombre, String apellido, int edad, String documento,
                    String departamento, String puesto, LocalDate fechaIngreso) {
        super(nombre, apellido, edad, documento);
        setDepartamento(departamento);
        setPuesto(puesto);
        setFechaIngreso(fechaIngreso);
    }
    
    // Constructor por defecto
    public Personal() {
        super();
        this.fechaIngreso = LocalDate.now();
    }

    // Getters y Setters
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        if (departamento != null && !departamento.trim().isEmpty()) {
            this.departamento = departamento;
        } else {
            System.out.println("El departamento no puede estar vacío.");
        }
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        if (puesto != null && !puesto.trim().isEmpty()) {
            this.puesto = puesto;
        } else {
            System.out.println("El puesto no puede estar vacío.");
        }
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    // Método toString()
    @Override
    public String toString() {
        String infoPersona = super.toString();
        return "Personal: [" + infoPersona + 
               ", Departamento: " + departamento + 
               ", Puesto: " + puesto + 
               ", Fecha Ingreso: " + fechaIngreso.toString() + "]";
    }

    // Interfaz MiembroUniversidad
    @Override
    public String obtenerRol() {
        return "Personal Administrativo";
    }
    @Override
    public String obtenerInformacionCompleta() {
        return this.toString();
    }
}