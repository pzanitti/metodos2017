package carnets;

public enum Vigencia {
    UN_ANO(1),
    TRES_ANOS(3),
    CUATRO_ANOS(4),
    CINCO_ANOS(5);
    
    public final int anos;
    
    private Vigencia(int anos) {
        this.anos = anos;
    }
    
    static public Vigencia desdeAnos(int anos) {
        for(Vigencia v : Vigencia.values()) {
            if(v.anos == anos) return v;
        }
        throw new IllegalArgumentException();
    }
    
}
