package dev.carlosmoran.lepokedex.model;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;

import dev.carlosmoran.lepokedex.R;

public enum TipoPokemon {
    ELECTRICO("Electrico", R.color.type_electrico),
    FUEGO("Fuego", R.color.type_fuego),
    TIERRA("Tierra", R.color.type_tierra),
    AGUA("Agua", R.color.type_agua),
    TODO("Todos", 0);

    public final String label;
    @ColorRes
    public final int color;

    TipoPokemon(String label, @ColorRes int color) {
        this.label = label;
        this.color = color;
    }

    public String getLabel() {
        return label;
    }

    @ColorRes
    public int getColor() {
        return color;
    }

    @NonNull
    @Override
    public String toString() {
        return label;
    }
}
