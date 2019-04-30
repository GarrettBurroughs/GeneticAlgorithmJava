package com.garrettAndPeter.lib;

import java.util.ArrayList;

/**
 * A simulation of natural selection using a genetic algorithm
 *
 * The Genetic Algorithm class houses the interactions of all the different
 * organisms within an "Environment".
 *
 * When a generation is run, a parent pool is generated, and a new
 * population is created based on that parent pool
 *
 * @param <Data> The data that the organisms use
 * @param <T> The type of the target the organisms will be tested against
 */
public class GeneticAlgorithm<Data, T> {
    /** The current population of organisms */
    private ArrayList<Organism<?>> organisms;

    /** The "Goal" of the organisms */
    private T target;

    /**
     *  An object that generates a new parent pool based on the fitnesses of the current population, as well as
     * any other random or environmental factors
     */
    private ParentPoolGenerator parentGenerator = new ProportionalGenerator();

    /** An object that dictates how the organisms produce offspring */
    private Reproduce<Organism> reproduction;

    /** Number of members in the population */
    private int populationSize;

    /**
     * Create a new Genetic Algorithm Simulation
     *
     * @param populationSize Number of members in each generation
     * @param generator On object that dictates how the organisms produce offspring
     * @param target The goal of the organisms. (used in determining fitness)
     */
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

    /** Specify the way the organisms produce offspring */
    public void setReproduction(Reproduce r){
        this.reproduction = r;
    }

}
