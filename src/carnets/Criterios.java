/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnets;

import java.util.Objects;
import java.util.Optional;

/**
 *
 * @author Gabriel
 */
public class Criterios {
    
    public Criterios(Optional<String> apellidos,
                     Optional<String> nombres,
                     Optional<GrupoSanguineo> grupoSanguineo,
                     Optional<FactorSanguineo> factorSanguineo,
                     Optional<Boolean> donante) {
        
        Objects.requireNonNull(apellidos);
        Objects.requireNonNull(nombres);
        Objects.requireNonNull(grupoSanguineo);
        Objects.requireNonNull(factorSanguineo);
        Objects.requireNonNull(donante);
        
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.grupoSanguineo = grupoSanguineo;
        this.factorSanguineo = factorSanguineo;
        this.donante = donante;
    }
    
    final public Optional<String> apellidos;
    final public Optional<String> nombres;
    final public Optional<GrupoSanguineo> grupoSanguineo;
    final public Optional<FactorSanguineo> factorSanguineo;
    final public Optional<Boolean> donante;

    public boolean coinciden(Titular titular) {
        
        if(apellidos.isPresent() && !apellidos.get().equals(titular.getApellidos())) return false;
        if(nombres.isPresent() && !nombres.get().equals(titular.getNombres())) return false;
        if(grupoSanguineo.isPresent() && grupoSanguineo.get() != titular.getGrupoSanguineo()) return false;
        if(factorSanguineo.isPresent() && factorSanguineo.get() != titular.getFactorSanguineo()) return false;
        if(donante.isPresent() && donante.get() != titular.isDonante()) return false;
        
        return true;
    }
    
}
