package com.garrettAndPeter.lib;

public abstract class Organism<Data> {
    private Data d;
    private double fitness;

    public Organism(Data d){
        this.d = d;
    }

    public Organism(Generator<Data> g){
        this.d = g.createRandom();
    }

    public Organism(Organism<Data> a, Organism<Data> b, Reproduce<Organism<Data>> r){
        this.d = (r.reproduce(a, b).getData());
    }

    public Data getData(){
        return d;
    }

    public abstract <T> double  calculateFitness(T target);

    public <T> void generateFitness(T target){
        this.fitness = calculateFitness(target);
    }

    public double getFitness(){
        return fitness;
    }
}
