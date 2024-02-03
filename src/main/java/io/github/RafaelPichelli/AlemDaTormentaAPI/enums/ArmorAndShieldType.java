package io.github.RafaelPichelli.AlemDaTormentaAPI.enums;

public enum ArmorAndShieldType {
    ARMADURA_LEVE("Armadura Leve"),
    ARMADURA_PESADA("Armadura Pesada"),
    ESCUDO("Escudo");

    private final String displayName;

    ArmorAndShieldType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static ArmorAndShieldType ofName(String typeName) {
        for (ArmorAndShieldType type : values()) {
            if (type.name().equalsIgnoreCase(typeName)) {
                return type;
            }
        }
        return null;
    }
}

