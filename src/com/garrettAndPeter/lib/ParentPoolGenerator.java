package com.garrettAndPeter.lib;

import java.util.ArrayList;

/**
 * Outline the generation of the parent pool
 *
 * For simple cases, this can simply be based of the fitnesses of the
 * organisms, but can also include other factors, such a shift in environment,
 * or random death & other factors.
 */
public interface ParentPoolGenerator {
    ArrayList<Organism> getParentPool(ArrayList<Organism<?>> generation);
}
