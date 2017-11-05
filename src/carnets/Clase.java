package carnets;

public enum Clase {
    A('A', "Ciclomotores, motocicletas y triciclos motorizados.", false),
    B('B', "Automóviles y camionetas con acoplado.", false),
    C('C', "Camiones sin acoplado y los comprendidos en la clase B.", true),
    D('D', "Servicio de transporte de pasajeros, emergencia, seguridad y los comprendidos en la clase B o C, según el caso.", true),
    E('E', "Camiones articulados o con acoplado, maquinaria especial no agrícola y los comprendidos en la clase B y C.", true),
    F('F', "Automotores especialmente adaptados para discapacitados.", false),
    G('G', "Tractores agrícolas y maquinaria especial agrícola.", false);
    
    final public char letra;
    final public String descripcion;
    final public boolean isProfesional;
    
    private Clase (char letra, String descripcion, boolean isProfesional) {
        this.letra = letra;
        this.descripcion = descripcion;
        this.isProfesional = isProfesional;
    }
    
    public static Clase fromLetra(char letra) {
    for (Clase clase : Clase.values()) {
      if (clase.letra == letra) {
        return clase;
      }
    }
    return null;
  }
}