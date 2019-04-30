package com.garrettAndPeter.stringEvolution;

import com.garrettAndPeter.lib.Generator;
import com.garrettAndPeter.lib.Organism;

/**
 * An organism based off of a string
 *
 * The string organism is implemented to show how words can evolve based on a certain target word.
 *
 * A strings fitness is increased for every character that it has in common with the
 * target string.
 */
public class StringOrganism extends Organism<String> {

    private static StringReproduce reproduction = new StringReproduce();

    public StringOrganism(String d) {
        super(d);
    }

    public StringOrganism(Generator<String> g) {
        super(g);
    }

    public StringOrganism(Organism<String> a, Organism<String> b) {
        super(a, b, reproduction);
    }

    @Override
    public <T> double calculateFitness(T target) {
        String sTarget = (String)target;
        int fitness = 0;
        for(int i = 0; i < sTarget.length(); i++){
            if(sTarget.charAt(i) == getData().charAt(i)){
                fitness += 10;
            }
        }
        return fitness;
    }
}
