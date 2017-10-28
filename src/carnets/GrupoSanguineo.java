package carnets;

import java.util.ArrayList;

public class GrupoSanguineo {
    private String grupoSanguineo;
    
    public GrupoSanguineo (String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }
    
    public String getGrupoSanguineo () {
        return this.grupoSanguineo;
    }
    
    public static ArrayList<GrupoSanguineo> init () {
        ArrayList<GrupoSanguineo> grupoSanguineos = new ArrayList<>();
        
        grupoSanguineos.add(new GrupoSanguineo("0"));
        grupoSanguineos.add(new GrupoSanguineo("A"));
        grupoSanguineos.add(new GrupoSanguineo("B"));
        grupoSanguineos.add(new GrupoSanguineo("AB"));
        
        return grupoSanguineos;
    }
}
