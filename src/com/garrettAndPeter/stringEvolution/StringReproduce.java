package com.garrettAndPeter.stringEvolution;

import com.garrettAndPeter.lib.Organism;
import com.garrettAndPeter.lib.Reproduce;

/**
 * A class that contains the reproduction implementation for a string organism
 *
 * The a StringReproduce object should be used in conjunction with some sort
 * of Organism class to create a working simulation involving Strings.
 *
 * The StringReproduce class is an implementation of the Reproduce interface,
 * which means that it allows for the creation of a child organism with the input
 * of two parent organisms.
 *
 * In the case of the StringReproduction, this means sequentially randomly
 * selecting a character from either parent (given a 50/50 probability for each),
 * and adding that character to the new child organism.
 *
 * The reproduction also includes a chance for Mutation, allowing for traits
 * that were not found in the parent population or in an organisms specific
 * parents to be evident in that organism.
 *
 * @see com.garrettAndPeter.lib.Reproduce
 * @version 0.1
 * @author Garrett Burroughs and Peter Adams
 */
public class StringReproduce implements Reproduce<Organism<String>> {

    /** A decimal value that indicates the chance of each gene in the child being mutated */
    private double mutationRate = 0.05;

    @Override
    public Organism<String> reproduce(Organism<String> organismA, Organism<String> organismB) {
        String a = organismA.getData();
        String b = organismB.getData();
        StringBuilder s = new StringBuilder();
        // Make sure both strings are the same length
        // This should not be a huge problem as long as the strings are from the same generator, but is there just in case
        if(a.length() != b.length()){
            throw new RuntimeException("Strings do not have the same length \n"
                    + a + " | length: " + a.length() + "\n"
                    + b + " | length: " + b.length()
            );
        }
        int length = a.length();

        // Construct the child string based off the two parent strings
        for(int i = 0; i < length; i++){
            char addedChar;

            // 50/50 chance that each character is from either parent string
            if(Math.random() > .5){
                addedChar = a.charAt(i);
            }else{
                addedChar = b.charAt(i);
            }

            // Include the chance for mutation
            if(Math.random() < mutationRate){
                addedChar = StringGenerator.generateChar();
            }
            s.append(addedChar);
        }
        return new StringOrganism(s.toString());
    }

    public void setMutationRate(double rate){
        mutationRate = rate;
    }
}
