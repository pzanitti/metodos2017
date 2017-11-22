package carnets;

public enum FactorSanguineo {
    POSITIVO('+'),
    NEGATIVO('-');
    
    final public char signo;
    
    private FactorSanguineo(char signo) {
        this.signo = signo;
    }
    
    public String getFactor() {
        String sin = "";
        return (sin + this.signo);
    }
}
