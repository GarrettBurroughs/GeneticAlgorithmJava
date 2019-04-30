package com.garrettAndPeter.lib;

/**
 * The main actors within a genetic algorithm
 *
 * Organisms interact and produce offspring with other
 * organisms in order to improve the species
 *
 * @param <Data> The type of data (DNA) the Organisms contain
 */
public abstract class Organism<Data> {
    /** The organisms genetic code (DNA) */
    private Data d;

    /** How fit the organism is based of a certain target metric, also how likely the organism is to reproduce */
    private double fitness;

    /** Create a copy of an organism using another organisms data */
    public Organism(Data d){
        this.d = d;
    }

    /** Create a new (First generation) organism based of a generator*/
    public Organism(Generator<Data> g){
        this.d = g.createRandom();
    }

    /** Create a new organism based of its two parents and their specifications for producing offspring */
    public Organism(Organism<Data> a, Organism<Data> b, Reproduce<Organism<Data>> r){
        this.d = (r.reproduce(a, b).getData());
    }

    /** @return the data or genetic code of the organism*/
    public Data getData(){
        return d;
    }

    /**
     * Calculate how fit (how likely it is for this organism to reproduce) based on a target. organisms closer
     * to a target should have higher fitness values
     */
    public abstract <T> double  calculateFitness(T target);

    /** calculate and store the fitness of the organism */
    public <T> void generateFitness(T target){
        this.fitness = calculateFitness(target);
    }

    /** @return  the fitness (How likely the organism is to reproduce) of the organism */
    public double getFitness(){
        return fitness;
    }
}
