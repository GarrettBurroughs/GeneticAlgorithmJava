package com.garrettAndPeter.lib;

/**
 * A function that allows for the creation of offspring using 2
 * parent organisms
 *
 * @param <T> the organism type
 */
@FunctionalInterface
public interface Reproduce<T> {
    T reproduce(T a, T b);
}
