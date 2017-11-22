package carnets;

import java.util.Arrays;

public enum TipoDocumento {
    DNI("DNI"),
    PASAPORTE("Pasaporte");
    
    public final String nombre;
    
    private TipoDocumento(String nombre) {
        this.nombre = nombre;
    }
    
    static public TipoDocumento fromNombre(String nombre)
    {
        return Arrays.stream(TipoDocumento.values())
                .filter(t -> t.nombre.equals(nombre))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("No such value for this enum"));
    }
}
