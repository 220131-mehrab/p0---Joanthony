package com.revature.pokedex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PokemonTest {
    @Test
    public void constructorTest() {
        String name = "Bulbasaur";
        Pokemon pokemon = new Pokemon(name);
    }
}
