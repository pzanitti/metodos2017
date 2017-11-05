/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnets;

import carnets.Clase;
import carnets.Costo;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gabriel
 */
public class CostoTest {
    
    final private List<Costo> costos = Costo.init();
    
    private Costo costo;
    
    static final private int costoFijo = 8;
    
    public CostoTest() {}
    
    @BeforeClass
    public static void setUpClass() {}
    
    @AfterClass
    public static void tearDownClass() {}
    
    @Before
    public void setUp() {}
    
    @After
    public void tearDown() {}

    @Test
    public void testTodasLasClasesYVigenciasTienenCostos() {
        int[] vigencias = {1,3,4,5};
        for(Clase c : Clase.values()) {
            for(int v : vigencias) {
                assert(Costo.calcularCosto(costos, c, v) >= costoFijo);
            }
        }
    }
    
    
    @Test
    public void testCostosClaseA() {
        assertEquals(Costo.calcularCosto(costos, Clase.A, 5), 40 + costoFijo);
        assertEquals(Costo.calcularCosto(costos, Clase.A, 4), 30 + costoFijo);
        assertEquals(Costo.calcularCosto(costos, Clase.A, 3), 25 + costoFijo);
        assertEquals(Costo.calcularCosto(costos, Clase.A, 1), 20 + costoFijo);
    }
    
    @Test
    public void testCostosClaseB() {
        assertEquals(Costo.calcularCosto(costos, Clase.B, 5), 40 + costoFijo);
        assertEquals(Costo.calcularCosto(costos, Clase.B, 4), 30 + costoFijo);
        assertEquals(Costo.calcularCosto(costos, Clase.B, 3), 25 + costoFijo);
        assertEquals(Costo.calcularCosto(costos, Clase.B, 1), 20 + costoFijo);
    }
    
    @Test
    public void testCostosClaseC() {
        assertEquals(Costo.calcularCosto(costos, Clase.C, 5), 47 + costoFijo);
        assertEquals(Costo.calcularCosto(costos, Clase.C, 4), 35 + costoFijo);
        assertEquals(Costo.calcularCosto(costos, Clase.C, 3), 30 + costoFijo);
        assertEquals(Costo.calcularCosto(costos, Clase.C, 1), 23 + costoFijo);
    }
    
    @Test
    public void testCostosClaseD() {
        assertEquals(Costo.calcularCosto(costos, Clase.D, 5), 59 + costoFijo);
        assertEquals(Costo.calcularCosto(costos, Clase.D, 4), 44 + costoFijo);
        assertEquals(Costo.calcularCosto(costos, Clase.D, 3), 39 + costoFijo);
        assertEquals(Costo.calcularCosto(costos, Clase.D, 1), 29 + costoFijo);
    }
    
    @Test
    public void testCostosClaseE() {
        assertEquals(Costo.calcularCosto(costos, Clase.E, 5), 59 + costoFijo);
        assertEquals(Costo.calcularCosto(costos, Clase.E, 4), 44 + costoFijo);
        assertEquals(Costo.calcularCosto(costos, Clase.E, 3), 39 + costoFijo);
        assertEquals(Costo.calcularCosto(costos, Clase.E, 1), 29 + costoFijo);
    }
    
    @Test
    public void testCostosClaseF() {
        assertEquals(Costo.calcularCosto(costos, Clase.F, 5), 40 + costoFijo);
        assertEquals(Costo.calcularCosto(costos, Clase.F, 4), 30 + costoFijo);
        assertEquals(Costo.calcularCosto(costos, Clase.F, 3), 25 + costoFijo);
        assertEquals(Costo.calcularCosto(costos, Clase.F, 1), 20 + costoFijo);
    }
    
    @Test
    public void testCostosClaseG() {
        assertEquals(Costo.calcularCosto(costos, Clase.G, 5), 40 + costoFijo);
        assertEquals(Costo.calcularCosto(costos, Clase.G, 4), 30 + costoFijo);
        assertEquals(Costo.calcularCosto(costos, Clase.G, 3), 25 + costoFijo);
        assertEquals(Costo.calcularCosto(costos, Clase.G, 1), 20 + costoFijo);
    }
}
