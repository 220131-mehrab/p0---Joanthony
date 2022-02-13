package com.revature.pokedex;

public class App {
    //location where we do business logic and gather content.
    public static void main(String[] args) {
        //object graph or dependency injection = tree structure of program being called
        // DexService depends on DexRepository, DexServer depends on DexService.

        DexRepository dexRepository = new DexRepository("pokedex.csv");
        DexService dexService = new DexService(dexRepository);
        DexServer dexServer = new DexServer(dexService);

    }
}
