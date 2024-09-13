public enum Cor {
    PRETO(0),
    MARROM(1),
    VERMELHO(2),
    LARANJA(3),
    AMARELO(4),
    VERDE(5),
    AZUL(6),
    VIOLETA(7),
    CINZA(8),
    BRANCO(9),
    DOURADO(10);

    private final int codigo;

    Cor(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static Cor fromCodigo(int codigo) {
        for (Cor cor : Cor.values()) {
            if (cor.getCodigo() == codigo) {
                return cor;
            }
        }
        throw new IllegalArgumentException("Código de cor inválido: " + codigo);
    }


}
