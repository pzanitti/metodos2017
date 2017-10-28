package carnets;

import java.util.ArrayList;

public class FactorSanguineo {
    private String factorSanguineo;
    
    public FactorSanguineo (String factorSanguineo) {
        this.factorSanguineo = factorSanguineo;
    }
    
    public String getFactorSanguineo () {
        return this.factorSanguineo;
    }
    
    public static ArrayList<FactorSanguineo> init () {
        ArrayList<FactorSanguineo> factorSanguineos = new ArrayList<>();
        
        factorSanguineos.add(new FactorSanguineo("-"));
        factorSanguineos.add(new FactorSanguineo("+"));
        
        return factorSanguineos;
    }
}
