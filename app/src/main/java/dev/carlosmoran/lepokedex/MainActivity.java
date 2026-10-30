package dev.carlosmoran.lepokedex;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import dev.carlosmoran.lepokedex.adapter.PokemonAdapter;
import dev.carlosmoran.lepokedex.model.Pokemon;
import dev.carlosmoran.lepokedex.model.TipoPokemon;
import dev.carlosmoran.lepokedex.repository.PokemonRepository;

public class MainActivity extends AppCompatActivity {

    ListView listaPokemons;
    List<Pokemon> arrayPokemons;

    PokemonAdapter pokemonAdapter;
    ArrayAdapter<TipoPokemon> filterSelectorAdapter;

    Spinner filterSelector;
    Button buttonFilter;
    Button buttonCrearPokemon;

    PokemonRepository pokemonRepository = PokemonRepository.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // asignacion de elementos de la vista
        listaPokemons = findViewById(R.id.listaPokemons);
        filterSelector = findViewById(R.id.filterSelector);
        buttonFilter = findViewById(R.id.buttonFilter);

        // popular repositorios
        arrayPokemons = new ArrayList<>(pokemonRepository.getAll());

        // crear adapters
        pokemonAdapter = new PokemonAdapter(this, R.layout.item_pokemon, arrayPokemons);
        filterSelectorAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                TipoPokemon.values());
        filterSelectorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // asignar adapters
        listaPokemons.setAdapter(pokemonAdapter);
        filterSelector.setAdapter(filterSelectorAdapter);

        // listeners
        buttonFilter.setOnClickListener(v -> {
            TipoPokemon tipoSeleccionado = (TipoPokemon) filterSelector.getSelectedItem();

            List<Pokemon> resultado = (tipoSeleccionado == TipoPokemon.TODO)
                    ? pokemonRepository.getAll()
                    : pokemonRepository.getByTipo(tipoSeleccionado);

            pokemonAdapter.clear();
            pokemonAdapter.addAll(resultado);   // addAll ya llama a notifyDataSetChanged()
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        pokemonAdapter.clear();
        pokemonAdapter.addAll(pokemonRepository.getAll());
    }
}