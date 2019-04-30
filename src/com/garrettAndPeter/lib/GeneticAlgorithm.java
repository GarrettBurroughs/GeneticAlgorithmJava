package com.garrettAndPeter.lib;

import java.util.ArrayList;

public class GeneticAlgorithm<Data, T> {
    private ArrayList<Organism<?>> organisms;
    private T target;
    private ParentPoolGenerator parentGenerator = new ProportionalGenerator();
    private Reproduce<Organism> reproduction;
    private int populationSize;

    public GeneticAlgorithm(int populationSize, Generator<Organism<Data>> generator, T target){
        organisms = new ArrayList<>(populationSize);
        for(int i = 0; i < populationSize; i++){
            organisms.add(generator.createRandom());
        }
        this.target = target;
        this.populationSize = populationSize;
    }

    /** returns the most fit organism out of the population based on a target */
    public Organism getBest(T target){
        Organism best = organisms.get(0);
        for (Organism o : organisms){
            if(o.calculateFitness(target) > best.calculateFitness(target)){
                best = o;
            }
        }
        return best;
    }

    /** returns the most fit organism out of the population */
    public Organism getBest(){
        return getBest(target);
    }

    /**
     * The runGeneration will simulate one generation of Natural Selection
     * on the given population and produce a new population
     */
    public void runGeneration(){
        // Calculate and store all fitnesses
        for (Organism o : organisms){
            o.generateFitness(target);
        }
        // Create the parent pool, the parent pool should favor more fit parents
        ArrayList<Organism> parentPool = parentGenerator.getParentPool(organisms);

        // Construct the new generation from randomly selecting from the parent pool
        for(int i = 0; i < populationSize; i++){
            Organism parentA = parentPool.get((int)(Math.random() * parentPool.size()));
            Organism parentB = parentPool.get((int)(Math.random() * parentPool.size()));
            organisms.set(i, reproduction.reproduce(parentA, parentB));
        }
    }

    public void setReproduction(Reproduce r){
        this.reproduction = r;
    }

}
