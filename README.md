# GeneticAlgorithmJava
A Genetic algorithm library and implementation written in pure java

This library allows for general creation of a genetic algorithm, In use, the 
user needs to define a Generator, Organism and Reproduction class. 
They each are generally straightforward but perform as follows

### Organism
An object containing the genes (Data) of a single organism in a species. Organisms are the 
base in genetic evolution and do most of the interaction and data storage 

### Generator
A generator allows for the creation of a new Organism to be used in the initial generation. 
Most often this is a random process, but Generators can create their organisms through specific parameters

### Reproduce
Allows for the creation of a child organism given one or more parent organism(s), 
the child organism should inherit genes from all the parents, as well as include a mutation
so that the species may evolve past their original state

## Implementation
To create a genetic algorithm simulation is as easy as follows

```java
// Specify the parameters for the simulation
GeneticAlgorithm<String, String> simulation = new GeneticAlgorithm<>(100, new StringGenerator(10), "Hello World");

// set the reproduction method for the simulation
simulation.setReproduction(new StringReproduce());

// Run a generation
simulation.runGeneration();

// Get the best organism in the generation
simulation.getBest();
```

The above example is using an implementation using strings in a genetic algorithm 
that can be found in this repository under [String Evolution](https://github.com/GarrettBurroughs/GeneticAlgorithmJava/tree/master/src/com/garrettAndPeter/stringEvolution)

## Contributers
Garrett Burroughs and Peter Adams

## Resources
Wikipedia article on Genetic Algorithms: [https://en.wikipedia.org/wiki/Genetic_algorithm](https://en.wikipedia.org/wiki/Genetic_algorithm)

[Article on genetic algorithms](https://towardsdatascience.com/introduction-to-genetic-algorithms-including-example-code-e396e98d8bf3?gi=6cfc0b6a5b46)