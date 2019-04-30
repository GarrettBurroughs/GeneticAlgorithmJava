package com.garrettAndPeter.lib;

/**
 * A function
 *
 * @param <T> the organism type
 */
@FunctionalInterface
public interface Reproduce<T> {
    T reproduce(T a, T b);
}
