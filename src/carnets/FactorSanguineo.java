package carnets;

public enum FactorSanguineo {
    POSITIVO('+'),
    NEGATIVO('-');
    
    final public char signo;
    
    private FactorSanguineo(char signo) {
        this.signo = signo;
    }
}
