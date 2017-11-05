package carnets;

public enum TipoDocumento {
    DNI("DNI"),
    PASAPORTE("Pasaporte");
    
    public final String nombre;
    
    private TipoDocumento(String nombre) {
        this.nombre = nombre;
    }
}
