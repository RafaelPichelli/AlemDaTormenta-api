package io.github.RafaelPichelli.AlemDaTormentaAPI.enums;

public enum SpellCircle {
    PRIMEIRO(1),
    SEGUNDO(2),
    TERCEIRO(3),
    QUARTO(4),
    QUINTO(5);

    private final int valor;

    SpellCircle(int valor){
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
