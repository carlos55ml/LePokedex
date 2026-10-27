package dev.carlosmoran.lepokedex.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.util.List;

import dev.carlosmoran.lepokedex.R;
import dev.carlosmoran.lepokedex.model.Pokemon;

public class PokemonAdapter extends ArrayAdapter<Pokemon> {

    private List<Pokemon> mPokemons;
    private Context mContext;


    public PokemonAdapter(@NonNull Context context, int resource, @NonNull List<Pokemon> objects) {
        super(context, resource, objects);
        this.mPokemons = objects;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pokemon p = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_pokemon, null);
        }
        TextView itemPokemonName = convertView.findViewById(R.id.itemPokemonName);
        TextView itemPokemonHp = convertView.findViewById(R.id.itemPokemonHP);
        TextView itemPokemonAttack = convertView.findViewById(R.id.itemPokemonAttack);
        TextView itemPokemonDefense = convertView.findViewById(R.id.itemPokemonDefense);
        TextView itemPokemonSpeed = convertView.findViewById(R.id.itemPokemonSpeed);

        itemPokemonName.setText(p.getNombre());
        itemPokemonHp.setText(String.valueOf(p.getHp()));
        itemPokemonAttack.setText(String.valueOf(p.getAtaque()));
        itemPokemonDefense.setText(String.valueOf(p.getDefensa()));
        itemPokemonSpeed.setText(String.valueOf(p.getVelocidad()));

        convertView.setBackgroundColor(
                ContextCompat.getColor(mContext, p.getTipo().getColor()));
        return convertView;
    }
}
