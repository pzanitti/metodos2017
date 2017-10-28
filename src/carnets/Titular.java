package carnets;

import java.time.LocalDate;

public class Titular {
    private final TipoDNI tipoDNI;
    private final Integer nroDNI;
    private final String apellidos;
    private final String nombres;
    private final LocalDate fechaNacimiento;
    private final String direccion;
    private final GrupoSanguineo grupoSanguineo;
    private final FactorSanguineo factorSanguineo;
    private final Boolean esDonante;
    private final String observaciones;

    public Titular(TipoDNI tipoDNI, Integer nroDNI, String apellidos, String nombres, LocalDate fechaNacimiento, String direccion, GrupoSanguineo grupoSanguineo, FactorSanguineo factorSanguineo, Boolean esDonante, String observaciones) {
        this.tipoDNI = tipoDNI;
        this.nroDNI = nroDNI;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.grupoSanguineo = grupoSanguineo;
        this.factorSanguineo = factorSanguineo;
        this.esDonante = esDonante;
        this.observaciones = observaciones;
    }
    
    public TipoDNI getTipoDNI () {
        return this.tipoDNI;
    }
    
    public Integer getNroDNI () {
        return this.nroDNI;
    }
    
    public String getApellidos () {
        return this.apellidos;
    }
    
    public String getNombres () {
        return this.nombres;
    }
    
    public LocalDate getFechaNacimiento () {
        return this.fechaNacimiento;
    }
    
    public int getDiaNacimiento () {
        return this.fechaNacimiento.getDayOfMonth();
    }
    
    public int getMesNacimiento () {
        return this.fechaNacimiento.getMonthValue();
    }
    
    public String getDireccion () {
        return this.direccion;
    }

    public GrupoSanguineo getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public FactorSanguineo getFactorSanguineo() {
        return factorSanguineo;
    }

    public Boolean getEsDonante() {
        return esDonante;
    }

    public String getObservaciones() {
        return observaciones;
    }
}
