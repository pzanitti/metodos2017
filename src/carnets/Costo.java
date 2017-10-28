package carnets;

import java.util.ArrayList;

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
    
    public static ArrayList<Costo> init (ArrayList<Clase> clases) {
        ArrayList<Costo> costos = new ArrayList<>();

        Clase claseA = clases.get(0);
        Clase claseB = clases.get(1);
        Clase claseC = clases.get(2);
        Clase claseD = clases.get(3);
        Clase claseE = clases.get(4);
        Clase claseF = clases.get(5);
        Clase claseG = clases.get(6);
        
        costos.add(new Costo(claseA, 1, 20));
        costos.add(new Costo(claseA, 3, 25));
        costos.add(new Costo(claseA, 4, 30));
        costos.add(new Costo(claseA, 5, 40));
        costos.add(new Costo(claseB, 1, 20));
        costos.add(new Costo(claseB, 3, 25));
        costos.add(new Costo(claseB, 4, 30));
        costos.add(new Costo(claseB, 5, 40));
        costos.add(new Costo(claseC, 1, 23));
        costos.add(new Costo(claseC, 3, 30));
        costos.add(new Costo(claseC, 4, 35));
        costos.add(new Costo(claseC, 5, 47));
        costos.add(new Costo(claseD, 1, 29));
        costos.add(new Costo(claseD, 3, 39));
        costos.add(new Costo(claseD, 4, 44));
        costos.add(new Costo(claseD, 5, 59));
        costos.add(new Costo(claseE, 1, 29));
        costos.add(new Costo(claseE, 3, 39));
        costos.add(new Costo(claseE, 4, 44));
        costos.add(new Costo(claseE, 5, 59));
        costos.add(new Costo(claseF, 1, 20));
        costos.add(new Costo(claseF, 3, 25));
        costos.add(new Costo(claseF, 4, 30));
        costos.add(new Costo(claseF, 5, 40));
        costos.add(new Costo(claseG, 1, 20));
        costos.add(new Costo(claseG, 3, 25));
        costos.add(new Costo(claseG, 4, 30));
        costos.add(new Costo(claseG, 5, 40));
        
        return costos;
    }
    
    public static Integer calcularCosto(ArrayList<Costo> costos, Clase clase, Integer vigencia) {
        final Integer precioFijo = 8;
        Integer costo = 0;
        
        for (Costo unCosto: costos) {
            if (unCosto.getClase() == clase && unCosto.getVigencia() == vigencia) {
                costo = unCosto.getPrecio();
            }
        }

        return costo + precioFijo;
    }
}
