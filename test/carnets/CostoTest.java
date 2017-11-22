/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnets;

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
    
    static final private int COSTO_FIJO = 8;
    
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
        for(Clase c : Clase.values()) {
            for(Vigencia v : Vigencia.values()) {
                assert(Costo.calcularCosto(costos, c, v) >= COSTO_FIJO);
            }
        }
    }
    
    
    @Test
    public void testCostosClaseA() {
        assertEquals(Costo.calcularCosto(costos, Clase.A, Vigencia.CINCO_ANOS), 40 + COSTO_FIJO);
        assertEquals(Costo.calcularCosto(costos, Clase.A, Vigencia.CUATRO_ANOS), 30 + COSTO_FIJO);
        assertEquals(Costo.calcularCosto(costos, Clase.A, Vigencia.TRES_ANOS), 25 + COSTO_FIJO);
        assertEquals(Costo.calcularCosto(costos, Clase.A, Vigencia.UN_ANO), 20 + COSTO_FIJO);
    }
    
    @Test
    public void testCostosClaseB() {
        assertEquals(Costo.calcularCosto(costos, Clase.B, Vigencia.CINCO_ANOS), 40 + COSTO_FIJO);
        assertEquals(Costo.calcularCosto(costos, Clase.B, Vigencia.CUATRO_ANOS), 30 + COSTO_FIJO);
        assertEquals(Costo.calcularCosto(costos, Clase.B, Vigencia.TRES_ANOS), 25 + COSTO_FIJO);
        assertEquals(Costo.calcularCosto(costos, Clase.B, Vigencia.UN_ANO), 20 + COSTO_FIJO);
    }
    
    @Test
    public void testCostosClaseC() {
        assertEquals(Costo.calcularCosto(costos, Clase.C, Vigencia.CINCO_ANOS), 47 + COSTO_FIJO);
        assertEquals(Costo.calcularCosto(costos, Clase.C, Vigencia.CUATRO_ANOS), 35 + COSTO_FIJO);
        assertEquals(Costo.calcularCosto(costos, Clase.C, Vigencia.TRES_ANOS), 30 + COSTO_FIJO);
        assertEquals(Costo.calcularCosto(costos, Clase.C, Vigencia.UN_ANO), 23 + COSTO_FIJO);
    }
    
    @Test
    public void testCostosClaseD() {
        assertEquals(Costo.calcularCosto(costos, Clase.D, Vigencia.CINCO_ANOS), 59 + COSTO_FIJO);
        assertEquals(Costo.calcularCosto(costos, Clase.D, Vigencia.CUATRO_ANOS), 44 + COSTO_FIJO);
        assertEquals(Costo.calcularCosto(costos, Clase.D, Vigencia.TRES_ANOS), 39 + COSTO_FIJO);
        assertEquals(Costo.calcularCosto(costos, Clase.D, Vigencia.UN_ANO), 29 + COSTO_FIJO);
    }
    
    @Test
    public void testCostosClaseE() {
        assertEquals(Costo.calcularCosto(costos, Clase.E, Vigencia.CINCO_ANOS), 59 + COSTO_FIJO);
        assertEquals(Costo.calcularCosto(costos, Clase.E, Vigencia.CUATRO_ANOS), 44 + COSTO_FIJO);
        assertEquals(Costo.calcularCosto(costos, Clase.E, Vigencia.TRES_ANOS), 39 + COSTO_FIJO);
        assertEquals(Costo.calcularCosto(costos, Clase.E, Vigencia.UN_ANO), 29 + COSTO_FIJO);
    }
    
    @Test
    public void testCostosClaseF() {
        assertEquals(Costo.calcularCosto(costos, Clase.F, Vigencia.CINCO_ANOS), 40 + COSTO_FIJO);
        assertEquals(Costo.calcularCosto(costos, Clase.F, Vigencia.CUATRO_ANOS), 30 + COSTO_FIJO);
        assertEquals(Costo.calcularCosto(costos, Clase.F, Vigencia.TRES_ANOS), 25 + COSTO_FIJO);
        assertEquals(Costo.calcularCosto(costos, Clase.F, Vigencia.UN_ANO), 20 + COSTO_FIJO);
    }
    
    @Test
    public void testCostosClaseG() {
        assertEquals(Costo.calcularCosto(costos, Clase.G, Vigencia.CINCO_ANOS), 40 + COSTO_FIJO);
        assertEquals(Costo.calcularCosto(costos, Clase.G, Vigencia.CUATRO_ANOS), 30 + COSTO_FIJO);
        assertEquals(Costo.calcularCosto(costos, Clase.G, Vigencia.TRES_ANOS), 25 + COSTO_FIJO);
        assertEquals(Costo.calcularCosto(costos, Clase.G, Vigencia.UN_ANO), 20 + COSTO_FIJO);
    }
}
