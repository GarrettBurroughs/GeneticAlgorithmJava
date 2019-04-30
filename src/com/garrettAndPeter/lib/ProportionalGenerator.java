package com.garrettAndPeter.lib;

import java.util.ArrayList;

public class ProportionalGenerator implements ParentPoolGenerator {
    @Override
    public ArrayList<Organism> getParentPool(ArrayList<Organism<?>> generation) {
        ArrayList<Organism> output = new ArrayList<>();
        for(Organism o : generation){
            for(int i = 0; i < o.getFitness() + 1; i++){
                output.add(o);
            }
        }
        return output;
    }
}
