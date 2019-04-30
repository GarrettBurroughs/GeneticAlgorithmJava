package com.garrettAndPeter.lib;

/**
 * An interface that defines the creation of a new organims
 * of a given type
 *
 * @param <T> the organism the Generator will Generate
 */
public interface Generator<T> {
    /** Create a new (First Generation) organism */
    T createRandom();
}
