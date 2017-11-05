/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnets;

import carnets.Carnet;
import carnets.Carnet.CarnetAnteriorInvalidoException;
import carnets.Carnet.CarnetAnteriorRequeridoException;
import carnets.Carnet.EmisionException;
import carnets.Carnet.EsMenorException;
import carnets.Clase;
import carnets.FactorSanguineo;
import carnets.GrupoSanguineo;
import carnets.TipoDocumento;
import carnets.Titular;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CarnetTest {
    
    static final private TipoDocumento t = TipoDocumento.DNI;
    static final private GrupoSanguineo gs = GrupoSanguineo.O;
    static final private FactorSanguineo rh = FactorSanguineo.POSITIVO;
    
    static final private LocalDate edad17 = LocalDate.now().minusYears(17);
    static final private LocalDate edad16 = edad17.plusDays(1);
    
    static final private LocalDate edad21 = LocalDate.now().minusYears(21);
    static final private LocalDate edad20 = edad21.plusDays(1);
    
    static final private LocalDate edad47 = LocalDate.now().minusYears(47);
    static final private LocalDate edad46 = edad47.plusDays(1);
    
    static final private LocalDate edad61 = LocalDate.now().minusYears(61);
    static final private LocalDate edad60 = edad61.plusDays(1);
    
    static final private LocalDate edad71 = LocalDate.now().minusYears(71);
    static final private LocalDate edad70 = edad71.plusDays(1);
   
    static final private Titular tit16 = new Titular(t, "16161616", "PÃ©rez", "Juan", edad16, "Alberdi 1616", gs, rh, false, "");
    static final private Titular tit17 = new Titular(t, "17171717", "PÃ©rez", "Juan", edad17, "Alberdi 1717", gs, rh, false, "");
    static final private Titular tit20 = new Titular(t, "20202020", "PÃ©rez", "Juan", edad20, "Alberdi 2020", gs, rh, false, "");
    static final private Titular tit21 = new Titular(t, "21212121", "PÃ©rez", "Juan", edad21, "Alberdi 2121", gs, rh, false, "");
    static final private Titular tit46 = new Titular(t, "46464646", "PÃ©rez", "Juan", edad46, "Alberdi 4646", gs, rh, false, "");
    static final private Titular tit47 = new Titular(t, "47474747", "PÃ©rez", "Juan", edad47, "Alberdi 4747", gs, rh, false, "");
    static final private Titular tit60 = new Titular(t, "60606060", "PÃ©rez", "Juan", edad60, "Alberdi 6060", gs, rh, false, "");
    static final private Titular tit61 = new Titular(t, "61616161", "PÃ©rez", "Juan", edad61, "Alberdi 6161", gs, rh, false, "");
    static final private Titular tit70 = new Titular(t, "70707070", "PÃ©rez", "Juan", edad70, "Alberdi 7070", gs, rh, false, "");
    static final private Titular tit71 = new Titular(t, "71717171", "PÃ©rez", "Juan", edad71, "Alberdi 7171", gs, rh, false, "");
    
    public CarnetTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        assertEquals(16, tit16.getEdad());
        assertEquals(17, tit17.getEdad());
        assertEquals(20, tit20.getEdad());
        assertEquals(21, tit21.getEdad());
        assertEquals(46, tit46.getEdad());
        assertEquals(47, tit47.getEdad());
        assertEquals(60, tit60.getEdad());
        assertEquals(61, tit61.getEdad());
        assertEquals(70, tit70.getEdad());
        assertEquals(71, tit71.getEdad());
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testEmitirNoProfesionalEdad17() throws EmisionException {
        for(Clase c : Clase.values()) {
            if(c.isProfesional) continue;
            new Carnet(Optional.empty(), c, 1, tit17);
        }
    }
    
    @Test
    public void testEmitirNoProfesionalEdad21() throws EmisionException {
        for(Clase c : Clase.values()) {
            if(c.isProfesional) continue;
            new Carnet(Optional.empty(), c, 5, tit21);
        }
    }
    
    @Test
    public void testEmitirNoProfesionalEdad46() throws EmisionException {
        for(Clase c : Clase.values()) {
            if(c.isProfesional) continue;
            new Carnet(Optional.empty(), c, 5, tit46);
        }
    }
    
    @Test
    public void testEmitirNoProfesionalEdad47() throws EmisionException {
        for(Clase c : Clase.values()) {
            if(c.isProfesional) continue;
            new Carnet(Optional.empty(), c, 4, tit47);
        }
    }
    
    @Test
    public void testEmitirNoProfesionalEdad60() throws EmisionException {
        for(Clase c : Clase.values()) {
            if(c.isProfesional) continue;
            new Carnet(Optional.empty(), c, 4, tit60);
        }
    }
    
    @Test
    public void testEmitirNoProfesionalEdad61() throws EmisionException {
        for(Clase c : Clase.values()) {
            if(c.isProfesional) continue;
            new Carnet(Optional.empty(), c, 3, tit61);
        }
    }
    
    @Test
    public void testEmitirNoProfesionalEdad70() throws EmisionException {
        for(Clase c : Clase.values()) {
            if(c.isProfesional) continue;
            new Carnet(Optional.empty(), c, 3, tit70);
        }
    }
    
    @Test
    public void testEmitirNoProfesionalEdad71() throws EmisionException {
        for(Clase c : Clase.values()) {
            if(c.isProfesional) continue;
            new Carnet(Optional.empty(), c, 1, tit71);
        }
    }
  
    @Test(expected = EsMenorException.class)
    public void testEmitirAMenorDe17() throws EmisionException {
        new Carnet(Optional.empty(), Clase.A, 1, tit16);
    }
    
    @Test(expected = EsMenorException.class)
    public void testEmitirBMenorDe17() throws EmisionException {
        new Carnet(Optional.empty(), Clase.B, 1, tit16);
    }
    
    @Test(expected = EsMenorException.class)
    public void testEmitirFMenorDe17() throws EmisionException {
        new Carnet(Optional.empty(), Clase.F, 1, tit16);
    }
        
    @Test(expected = EsMenorException.class)
    public void testEmitirGMenorDe17() throws EmisionException {
        new Carnet(Optional.empty(), Clase.G, 1, tit16);
    }
    
    @Test(expected = CarnetAnteriorRequeridoException.class)
    public void testEmitirCSinPresentarOtroCarnet() throws EmisionException {
        new Carnet(Optional.empty(), Clase.C, 5, tit21);
    }
    
    @Test(expected = CarnetAnteriorInvalidoException.class)
    public void testEmitirCPresentandoBNuevo() throws EmisionException {
        new Carnet(Optional.of(new Carnet(Optional.empty(), Clase.B, 5, tit21)),
                Clase.C, 5, tit21);
    }
    
    @Test(expected = CarnetAnteriorRequeridoException.class)
    public void testEmitirDSinPresentarOtroCarnet() throws EmisionException {
        new Carnet(Optional.empty(), Clase.D, 5, tit21);
    }
    
    @Test(expected = CarnetAnteriorInvalidoException.class)
    public void testEmitirDPresentandoBNuevo() throws EmisionException {
        new Carnet(Optional.of(new Carnet(Optional.empty(), Clase.B, 5, tit21)),
                Clase.D, 5, tit21);
    }
    
    @Test(expected = CarnetAnteriorRequeridoException.class)
    public void testEmitirESinPresentarOtroCarnet() throws EmisionException {
        new Carnet(Optional.empty(), Clase.E, 5, tit21);
    }
    
    @Test(expected = CarnetAnteriorInvalidoException.class)
    public void testEmitirEPresentandoBNuevo() throws EmisionException {
        new Carnet(Optional.of(new Carnet(Optional.empty(), Clase.B, 5, tit21)),
                Clase.E, 5, tit21);
    }

    @Test
    public void testGetTitular() throws EmisionException {
        Carnet instance = new Carnet(Optional.empty(), Clase.B, 5, tit21);
        Titular expResult = tit21;
        Titular result = instance.getTitular();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetClase() throws EmisionException {
        Carnet instance = new Carnet(Optional.empty(), Clase.B, 5, tit21);
        Clase expResult = Clase.B;
        Clase result = instance.getClase();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetEmision() throws EmisionException {
        Carnet instance = new Carnet(Optional.empty(), Clase.B, 5, tit21);
        LocalDate expResult = LocalDate.now();
        LocalDate result = instance.getEmision();
        assertEquals(expResult, result);
    }
    
}
