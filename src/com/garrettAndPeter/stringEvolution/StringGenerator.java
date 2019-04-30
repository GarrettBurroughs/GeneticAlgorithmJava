package com.garrettAndPeter.stringEvolution;

import com.garrettAndPeter.lib.Generator;
import com.garrettAndPeter.lib.Organism;


public class StringGenerator implements Generator<Organism<String>> {
    //public static Random r = new Random();

    private int length;
    public StringGenerator(int length){
        this.length = length;
    }

    @Override
    public Organism<String> createRandom() {
        StringBuilder s = new StringBuilder();

        for(int i = 0; i < length; i++){
            s.append(generateChar());
        }
        return new StringOrganism(s.toString());
    }

    public void setLength(int length){
        this.length = length;
    }

    public static char generateChar(){
        // 32 - 122
        return (char)((int)(Math.random() * (122 - 32) + 32));
    }
}
