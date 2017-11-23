package carnets;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public class Carnet {
    
    final private Optional<Integer> numero;
    final private Clase clase;
    final private LocalDate emision;
    final private LocalDate expiracion;
    final private String observaciones;
    final private Titular titular;

    public Optional<Integer> getNumero () {
        return numero;
    }

    public Clase getClase() {
        return clase;
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
    
    public boolean isExpirado() {
        return expiracion.isBefore(LocalDate.now());
    }
    
    public String getObservaciones() {
        return observaciones;
    }

    public Titular getTitular() {
        return titular;
    }

    public Carnet(Optional<Carnet> carnetAnterior, Clase clase, String observaciones, Titular titular)
            throws EmisionException  {
        
        Objects.requireNonNull(carnetAnterior);
        Objects.requireNonNull(clase);
        Objects.requireNonNull(clase);
        Objects.requireNonNull(titular);
        if(carnetAnterior.isPresent() && !carnetAnterior.get().getTitular().equals(titular)) throw new CarnetAnteriorInvalidoException();
        
        this.numero = Optional.empty();
        this.emision = LocalDate.now();
        this.clase = clase;
        this.observaciones = observaciones;
        this.titular = titular;
        
        int edad = titular.getEdad();
        
        Vigencia vigenciaMax;
        
        if(!clase.isProfesional) {
            if (edad < 17) throw new EsMenorException();
            
            boolean tuvoCarnetMismaClase = carnetAnterior.map(ca -> ca.getClase() == clase).orElse(false);
            vigenciaMax = vigenciaMaximaNoProfesional(edad, tuvoCarnetMismaClase);
            
        }
        else { //if clase.isProfesional
            if(edad < 21) throw new EsMenorParaProfesionalException();
            
            if(!carnetAnterior.isPresent()) throw new CarnetAnteriorRequeridoException();
            
            boolean primeraVezProfesional;
            if(carnetAnterior.get().getClase().isProfesional == true) primeraVezProfesional = false;
            else if(carnetAnterior.get().getClase() == Clase.B && carnetAnterior.get().getAntiguedad() >= 1) primeraVezProfesional = true;
            else throw new CarnetAnteriorInvalidoException();
            
            if(primeraVezProfesional && edad > 65) throw new EsMayorParaPrimerProfesionalException();
            
            vigenciaMax = vigenciaMaximaProfesional(edad);
        }

        this.expiracion = calcularExpiracion(emision, titular.getFechaNacimiento(), vigenciaMax);
    }
    
    Carnet(int numero, Clase clase, LocalDate emision, LocalDate expiracion, String observaciones, Titular titular)
    {
        Objects.requireNonNull(clase);
        Objects.requireNonNull(emision);
        Objects.requireNonNull(expiracion);
        Objects.requireNonNull(titular);
        if(emision.isAfter(LocalDate.now())) throw new IllegalArgumentException("emision no puede ser en el futuro");
        if(expiracion.isBefore(emision)) throw new IllegalArgumentException("expiracion no puede ser anterior a emision");
        
        this.numero = Optional.of(numero);
        this.clase = clase;
        this.emision = emision;
        this.expiracion = expiracion;
        this.observaciones = observaciones;
        this.titular = titular;     
    }
    
    static private LocalDate calcularExpiracion(LocalDate emision, LocalDate nacimiento, Vigencia vigencia)
    {
        LocalDate cumpleaniosEsteAnio = nacimiento.withYear(emision.getYear());
        
        if (emision.isAfter(cumpleaniosEsteAnio)) {
            return cumpleaniosEsteAnio.plusYears(1 + vigencia.anos);
        } else {
            return cumpleaniosEsteAnio.plusYears(vigencia.anos);
        }
    }

    static public Vigencia vigenciaMaximaNoProfesional(int edad, boolean tuvoCarnet)
        throws EsMenorException
    {
        if(edad < 17) throw new EsMenorException();
        if(edad < 21) {
            if(tuvoCarnet) return Vigencia.TRES_ANOS;
            else return Vigencia.UN_ANO;
        }
        if(edad <= 46) return Vigencia.CINCO_ANOS;
        if(edad <= 60) return Vigencia.CUATRO_ANOS;
        if(edad <= 70) return Vigencia.TRES_ANOS;
        else return Vigencia.UN_ANO;
    }
    
    static public Vigencia vigenciaMaximaProfesional(int edad)
        throws EsMenorParaProfesionalException
    {
        if(edad < 21) throw new EsMenorParaProfesionalException();
        if(edad <= 46) return Vigencia.CINCO_ANOS;
        if(edad <= 60) return Vigencia.CUATRO_ANOS;
        if(edad <= 70) return Vigencia.TRES_ANOS;
        else return Vigencia.UN_ANO;
    }
    
    static public Optional<Carnet> getCarnetAnteriorMasUtil(Collection<Carnet> carnets)
   {
       Optional<Carnet> profesional = carnets.stream().filter(c -> c.getClase().isProfesional).findAny();
       
       if(profesional.isPresent()) return profesional;
       
       Optional<Carnet> bAntiguedadUnAno = carnets.stream().filter(c -> c.getClase() == Clase.B && c.getAntiguedad() >= 1).findAny();
       
       if(bAntiguedadUnAno.isPresent()) return bAntiguedadUnAno;
       
       return carnets.stream().findAny();
   }
    
    static public class EmisionException extends Exception {};
    
    static public class EsMenorException extends EmisionException {}

    static public class EsMenorParaProfesionalException extends EmisionException {}

    static public class EsMayorParaPrimerProfesionalException extends EmisionException {}

    static public class CarnetAnteriorRequeridoException extends EmisionException {}

    static public class CarnetAnteriorInvalidoException extends EmisionException {}
}
