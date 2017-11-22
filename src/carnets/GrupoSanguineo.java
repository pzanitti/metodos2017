package carnets;

public enum GrupoSanguineo {
    O("O"),
    A("A"),
    B("B"),
    AB("AB");
  
    final public String nombre;
    
    private GrupoSanguineo(String nombre) {
        this.nombre = nombre;
    }
    
    public String getGrupoSanguineo() {
        return this.nombre;
    }
}
