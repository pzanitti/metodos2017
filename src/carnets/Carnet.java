package carnets;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Objects;

public class Carnet {
    String numero;
    Clase clase;
    LocalDate emision;
    LocalDate expiracion;
    Titular titular;

    public void setNumero (int numero) {
        this.numero = String.format("%9s", numero).replace(' ', '0');
    }

    public String getNumero () {
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

    public Titular getTitular() {
        return titular;
    }

    public Carnet (ArrayList<Carnet> carnets, Clase clase, Integer vigencia, Titular titular)
            throws EsMenorException, EsMenorParaCDEException, CareceBParaCDEException, EsMayorParaCDEException  {
        LocalDate emision = LocalDate.now();
        LocalDate proximoCumpleanios;
        
        boolean agregarAnioExtra;
        
        if (titular.getMesNacimiento() < emision.getMonthValue()) {
            // El cumpleaños ya paso, es el anio que viene
            proximoCumpleanios = titular.getFechaNacimiento().withYear(emision.getYear() + 1);
            agregarAnioExtra = true;
        } else if (titular.getMesNacimiento() == emision.getMonthValue()) {
            // Es el mismo mes, tengo que ver el dia
            if (titular.getDiaNacimiento() < emision.getDayOfMonth()) {
                // El cumpleaños ya paso, es el anio que viene
                proximoCumpleanios = titular.getFechaNacimiento().withYear(emision.getYear() + 1);
            } else {
                // Todavia no fue, el cumpleanios es hoy o va a ser en este mes
                proximoCumpleanios = titular.getFechaNacimiento().withYear(emision.getYear());
            }
        } else {
            // Todavia no fue, el cumpleanios va a ser en este anio
            proximoCumpleanios = titular.getFechaNacimiento().withYear(emision.getYear());
        }

        this.expiracion = proximoCumpleanios.plusYears(vigencia);
        this.emision = emision;
        this.clase = clase;
        this.titular = titular;

        int edad = titular.getFechaNacimiento().until(LocalDate.now()).getYears();

        // No permitir menores de 17
        if (edad < 17) {
            throw new EsMenorException();
        }

        // Si el carnet es profesional, ver si tuvo B por un anio
        if (clase.getEsProfesional()) {
            if (edad < 21) {
                throw new EsMenorParaCDEException();
            }

            // Comprobar si tuvo B por un anio
            Boolean tuvoBPorUnAnio = false;

            for (Carnet unCarnet: carnets) {
                // Ver si este carnet es de esta persona
                if (unCarnet.titular.getTipoDNI() == titular.getTipoDNI()
                    && Objects.equals(unCarnet.titular.getNroDNI(), titular.getNroDNI())) {
                    // Ver si es B
                    if (unCarnet.clase.getLetra().equals("B")) {
                        // Ver si tuvo un anio
                        if (unCarnet.getEmision().isBefore(LocalDate.now().minusYears(1))) {
                            tuvoBPorUnAnio = true;
                        }
                    }
                }
            }

            if (tuvoBPorUnAnio) {
               // Tuvo CDE
               Boolean TuvoCDE = false;
               
               for (Carnet unCarnet: carnets) {
                   switch (unCarnet.getClase().getLetra()) {
                       case "C":
                       case "D":
                       case "E":
                           TuvoCDE = true;
                   }
               }
               
               if (TuvoCDE) {
               } else {
                   throw new EsMayorParaCDEException();
               }
            } else {
                throw new CareceBParaCDEException();
            }
        }
    }
}

class EsMenorException extends Exception {
}

class EsMenorParaCDEException extends Exception {
}

class CareceBParaCDEException extends Exception {
}

class EsMayorParaCDEException extends Exception {
}
