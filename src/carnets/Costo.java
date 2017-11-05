package carnets;

import java.util.ArrayList;
import java.util.List;

public class Costo {
    private Clase clase;
    private int vigencia;
    private int precio;
    
    public Costo (Clase clase, int vigencia, int precio) {
        this.clase = clase;
        this.vigencia = vigencia;
        this.precio = precio;
    }

    public Clase getClase() {
        return clase;
    }

    public int getVigencia() {
        return vigencia;
    }

    public int getPrecio() {
        return precio;
    }
    
    public static List<Costo> init () {
        List<Costo> costos = new ArrayList<>();
        
        costos.add(new Costo(Clase.A, 1, 20));
        costos.add(new Costo(Clase.A, 3, 25));
        costos.add(new Costo(Clase.A, 4, 30));
        costos.add(new Costo(Clase.A, 5, 40));
        costos.add(new Costo(Clase.B, 1, 20));
        costos.add(new Costo(Clase.B, 3, 25));
        costos.add(new Costo(Clase.B, 4, 30));
        costos.add(new Costo(Clase.B, 5, 40));
        costos.add(new Costo(Clase.C, 1, 23));
        costos.add(new Costo(Clase.C, 3, 30));
        costos.add(new Costo(Clase.C, 4, 35));
        costos.add(new Costo(Clase.C, 5, 47));
        costos.add(new Costo(Clase.D, 1, 29));
        costos.add(new Costo(Clase.D, 3, 39));
        costos.add(new Costo(Clase.D, 4, 44));
        costos.add(new Costo(Clase.D, 5, 59));
        costos.add(new Costo(Clase.E, 1, 29));
        costos.add(new Costo(Clase.E, 3, 39));
        costos.add(new Costo(Clase.E, 4, 44));
        costos.add(new Costo(Clase.E, 5, 59));
        costos.add(new Costo(Clase.F, 1, 20));
        costos.add(new Costo(Clase.F, 3, 25));
        costos.add(new Costo(Clase.F, 4, 30));
        costos.add(new Costo(Clase.F, 5, 40));
        costos.add(new Costo(Clase.G, 1, 20));
        costos.add(new Costo(Clase.G, 3, 25));
        costos.add(new Costo(Clase.G, 4, 30));
        costos.add(new Costo(Clase.G, 5, 40));
        
        return costos;
    }
    
    public static int calcularCosto(List<Costo> costos, Clase clase, int vigencia) {
        final int precioFijo = 8;
        int costo = 0;
        
        for (Costo unCosto: costos) {
            if (unCosto.getClase() == clase && unCosto.getVigencia() == vigencia) {
                costo = unCosto.getPrecio();
            }
        }

        return costo + precioFijo;
    }
}
