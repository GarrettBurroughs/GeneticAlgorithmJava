package com.garrettAndPeter.stringEvolution;

import com.garrettAndPeter.lib.Generator;
import com.garrettAndPeter.lib.Organism;

public class StringOrganism extends Organism<String> {

    private static StringReproduce reproduction = new StringReproduce();
    private static StringGenerator generator = new StringGenerator(10);

    public StringOrganism(String d) {
        super(d);
    }

    public StringOrganism(Generator<String> g) {
        super(g);
    }

    public StringOrganism(Organism<String> a, Organism<String> b) {
        super(a, b, reproduction);
    }

    public static void setLength(int length){
       generator.setLength(length);
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
