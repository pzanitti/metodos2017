package carnets;

import java.util.ArrayList;

public class Clase {
    private int id;
    private String letra;
    private String descripcion;
    private Boolean esProfesional;

    public Clase (int id, String letra, String descripcion, Boolean esProfesional) {
        this.id = id;
        this.letra = letra;
        this.descripcion = descripcion;
        this.esProfesional = esProfesional;
    }

    public int getId() {
        return id;
    }
    
    public String getLetra () {
        return this.letra;
    }
    
    public String getDescripcion () {
        return this.descripcion;
    }
    
    public Boolean getEsProfesional () {
        return this.esProfesional;
    }
    
    public static ArrayList<Clase> init () {
        ArrayList<Clase> clases = new ArrayList<>();

        clases.add(new Clase(0, "A", "Ciclomotores, motocicletas y triciclos motorizados.", false));
        clases.add(new Clase(1, "B", "Automóviles y camionetas con acoplado.", false));
        clases.add(new Clase(2, "C", "Camiones sin acoplado y los comprendidos en la clase B.", false));
        clases.add(new Clase(3, "D", "Servicio de transporte de pasajeros, emergencia, seguridad y los comprendidos en la clase B o C, según el caso.", false));
        clases.add(new Clase(4, "E", "Camiones articulados o con acoplado, maquinaria especial no agrícola y los comprendidos en la clase B y C.", false));
        clases.add(new Clase(5, "F", "Automotores especialmente adaptados para discapacitados.", false));
        clases.add(new Clase(6,"G", "Tractores agrícolas y maquinaria especial agrícola.", false));

        return clases;
    }
}
