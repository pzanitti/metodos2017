package carnets;

import java.time.LocalDate;
import java.util.Objects;

public class Titular {
    private final TipoDocumento tipoDocumento;
    private final String numeroDocumento;
    private final String apellidos;
    private final String nombres;
    private final LocalDate fechaNacimiento;
    private final String direccion;
    private final GrupoSanguineo grupoSanguineo;
    private final FactorSanguineo factorSanguineo;
    private final boolean esDonante;

    public Titular(TipoDocumento tipoDocumento, String numeroDocumento, String apellidos, String nombres, LocalDate fechaNacimiento, String direccion, GrupoSanguineo grupoSanguineo, FactorSanguineo factorSanguineo, boolean esDonante) {
        Objects.requireNonNull(tipoDocumento);
        Objects.requireNonNull(apellidos);
        if(apellidos.isEmpty()) throw new IllegalArgumentException();
        Objects.requireNonNull(nombres);
        if(nombres.isEmpty()) throw new IllegalArgumentException();
        Objects.requireNonNull(fechaNacimiento);
        if(fechaNacimiento.isAfter(LocalDate.now())) throw new IllegalArgumentException("fechaNacimiento no puede ser posterior a la fecha actual");
        Objects.requireNonNull(direccion);
        Objects.requireNonNull(grupoSanguineo);
        Objects.requireNonNull(factorSanguineo);

        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.grupoSanguineo = grupoSanguineo;
        this.factorSanguineo = factorSanguineo;
        this.esDonante = esDonante;
    }
    
    public TipoDocumento getTipoDocumento () {
        return this.tipoDocumento;
    }
    
    public String getNumeroDocumento () {
        return this.numeroDocumento;
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
    
    public int getEdad() {
        return fechaNacimiento.until(LocalDate.now()).getYears();
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

    public boolean isDonante() {
        return esDonante;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.tipoDocumento);
        hash = 47 * hash + Objects.hashCode(this.numeroDocumento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Titular other = (Titular) obj;
        if (!Objects.equals(this.numeroDocumento, other.numeroDocumento)) {
            return false;
        }
        if (this.tipoDocumento != other.tipoDocumento) {
            return false;
        }
        return true;
    }
}
