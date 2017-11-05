package carnets;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class Carnet {
    private String numero;
    final private Clase clase;
    private LocalDate emision;
    final private LocalDate expiracion;
    final private Titular titular;

    public void setNumero (int numero) {
        this.numero = String.format("%9s", numero).replace(' ', '0');
    }

    public String getNumero () {
        return numero;
    }

    public Clase getClase() {
        return clase;
    }
    
    public void setEmision (LocalDate emision) {
        this.emision = emision;
    }

    public LocalDate getEmision() {
        return emision;
    }

    public LocalDate getExpiracion() {
        return expiracion;
    }
    
    public int getAntiguedad() {
        return emision.until(LocalDate.now()).getYears();
    }

    public Titular getTitular() {
        return titular;
    }

    public Carnet(Optional<Carnet> carnetAnterior, Clase clase, int vigencia, Titular titular)
            throws EmisionException  {
        
        Objects.requireNonNull(carnetAnterior);
        Objects.requireNonNull(clase);
        Objects.requireNonNull(clase);
        Objects.requireNonNull(titular);
        if(carnetAnterior.isPresent() && !carnetAnterior.get().getTitular().equals(titular)) throw new CarnetAnteriorInvalidoException();
        
        this.emision = LocalDate.now();
        this.clase = clase;
        this.titular = titular;
        
        int edad = titular.getEdad();

        if(!clase.isProfesional) {
            if (edad < 17) throw new EsMenorException();
        } else {
            if(edad < 21) throw new EsMenorParaProfesionalException();
            
            if(!carnetAnterior.isPresent()) throw new CarnetAnteriorRequeridoException();
            
            boolean primeraVezProfesional;
            if(carnetAnterior.get().getClase().isProfesional == true) primeraVezProfesional = false;
            else if(carnetAnterior.get().getClase() == Clase.B && carnetAnterior.get().getAntiguedad() >= 1) primeraVezProfesional = true;
            else throw new CarnetAnteriorInvalidoException();
            
            if(primeraVezProfesional && edad > 65) throw new EsMayorParaPrimerProfesionalException();
        }
        
        this.expiracion = calcularExpiracion(emision, titular.getFechaNacimiento(), vigencia);
    }
    
    static private LocalDate calcularExpiracion(LocalDate emision, LocalDate nacimiento, int vigencia)
    {
        LocalDate cumpleaniosEsteAnio = nacimiento.withYear(emision.getYear());
        
        if (emision.isAfter(cumpleaniosEsteAnio)) {
            return cumpleaniosEsteAnio.plusYears(1 + vigencia);
        } else {
            return cumpleaniosEsteAnio.plusYears(vigencia);
        }
    }
    
    static public Optional<Carnet> getCarnetAnteriorMasUtil(Carnet... carnets)
   {
       Optional<Carnet> profesional = Arrays.stream(carnets).filter(c -> c.getClase().isProfesional).findAny();
       
       if(profesional.isPresent()) return profesional;
       
       Optional<Carnet> bAntiguedadUnAno = Arrays.stream(carnets).filter(c -> c.getClase() == Clase.B && c.getAntiguedad() >= 1).findAny();
       
       if(bAntiguedadUnAno.isPresent()) return bAntiguedadUnAno;
       
       return Arrays.stream(carnets).findAny();
   }
    
    static public class EmisionException extends Exception {};
    
    static public class EsMenorException extends EmisionException {}

    static public class EsMenorParaProfesionalException extends EmisionException {}

    static public class EsMayorParaPrimerProfesionalException extends EmisionException {}

    static public class CarnetAnteriorRequeridoException extends EmisionException {}

    static public class CarnetAnteriorInvalidoException extends EmisionException {}
}
