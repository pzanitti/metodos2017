package carnets;

import java.util.ArrayList;
import java.util.List;

public class Costo {
    private Clase clase;
    private Vigencia vigencia;
    private int precio;
    
    public Costo (Clase clase, Vigencia vigencia, int precio) {
        this.clase = clase;
        this.vigencia = vigencia;
        this.precio = precio;
    }

    public Clase getClase() {
        return clase;
    }

    public Vigencia getVigencia() {
        return vigencia;
    }

    public int getPrecio() {
        return precio;
    }
    
    public static List<Costo> init () {
        List<Costo> costos = new ArrayList<>();
        
        costos.add(new Costo(Clase.A, Vigencia.UN_ANO, 20));
        costos.add(new Costo(Clase.A, Vigencia.TRES_ANOS, 25));
        costos.add(new Costo(Clase.A, Vigencia.CUATRO_ANOS, 30));
        costos.add(new Costo(Clase.A, Vigencia.CINCO_ANOS, 40));
        costos.add(new Costo(Clase.B, Vigencia.UN_ANO, 20));
        costos.add(new Costo(Clase.B, Vigencia.TRES_ANOS, 25));
        costos.add(new Costo(Clase.B, Vigencia.CUATRO_ANOS, 30));
        costos.add(new Costo(Clase.B, Vigencia.CINCO_ANOS, 40));
        costos.add(new Costo(Clase.C, Vigencia.UN_ANO, 23));
        costos.add(new Costo(Clase.C, Vigencia.TRES_ANOS, 30));
        costos.add(new Costo(Clase.C, Vigencia.CUATRO_ANOS, 35));
        costos.add(new Costo(Clase.C, Vigencia.CINCO_ANOS, 47));
        costos.add(new Costo(Clase.D, Vigencia.UN_ANO, 29));
        costos.add(new Costo(Clase.D, Vigencia.TRES_ANOS, 39));
        costos.add(new Costo(Clase.D, Vigencia.CUATRO_ANOS, 44));
        costos.add(new Costo(Clase.D, Vigencia.CINCO_ANOS, 59));
        costos.add(new Costo(Clase.E, Vigencia.UN_ANO, 29));
        costos.add(new Costo(Clase.E, Vigencia.TRES_ANOS, 39));
        costos.add(new Costo(Clase.E, Vigencia.CUATRO_ANOS, 44));
        costos.add(new Costo(Clase.E, Vigencia.CINCO_ANOS, 59));
        costos.add(new Costo(Clase.F, Vigencia.UN_ANO, 20));
        costos.add(new Costo(Clase.F, Vigencia.TRES_ANOS, 25));
        costos.add(new Costo(Clase.F, Vigencia.CUATRO_ANOS, 30));
        costos.add(new Costo(Clase.F, Vigencia.CINCO_ANOS, 40));
        costos.add(new Costo(Clase.G, Vigencia.UN_ANO, 20));
        costos.add(new Costo(Clase.G, Vigencia.TRES_ANOS, 25));
        costos.add(new Costo(Clase.G, Vigencia.CUATRO_ANOS, 30));
        costos.add(new Costo(Clase.G, Vigencia.CINCO_ANOS, 40));
        
        return costos;
    }
    
    public static int calcularCosto(List<Costo> costos, Clase clase, Vigencia vigencia) {
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
