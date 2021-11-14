package io.github.michaelsixtyfour.materials.utils;

public enum MiningLevel {
    WOOD(0),
    STONE(1),
    IRON(2),
    DIAMOND(3);

    public final int intLevel;

    MiningLevel(int intLevel) {
        this.intLevel = intLevel;
    }
}
