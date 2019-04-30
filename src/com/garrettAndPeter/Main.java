package com.garrettAndPeter;

import com.garrettAndPeter.lib.GeneticAlgorithm;
import com.garrettAndPeter.stringEvolution.StringGenerator;
import com.garrettAndPeter.stringEvolution.StringReproduce;

public class Main {
    public static void main(String[] args) {
        String target = "Hello World";

        // Specify the parameters for the simulation
        GeneticAlgorithm<String, String> simulation = new GeneticAlgorithm<>(100, new StringGenerator(target.length()), target);

        // set the reproduction method for the simulation
        simulation.setReproduction(new StringReproduce());

        // Run the simulation
        while(!simulation.getBest().getData().equals(target)){
            simulation.runGeneration();
            System.out.println(simulation.getBest().getData());
        }

    }
}
