package carnets;

import java.util.ArrayList;

public class TipoDNI {
    private String tipoDNI;
    
    public TipoDNI (String tipoDNI) {
        this.tipoDNI = tipoDNI;
    }
    
    public String getTipoDNI () {
        return this.tipoDNI;
    }
    
    public static ArrayList<TipoDNI> init () {
        ArrayList<TipoDNI> tipoDNIs = new ArrayList<>();
        
        tipoDNIs.add(new TipoDNI("Pasaporte"));
        tipoDNIs.add(new TipoDNI("DNI"));
        
        return tipoDNIs;
    }
}
