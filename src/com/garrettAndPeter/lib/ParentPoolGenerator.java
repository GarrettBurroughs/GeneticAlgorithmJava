package com.garrettAndPeter.lib;

import java.util.ArrayList;

public interface ParentPoolGenerator {
    ArrayList<Organism> getParentPool(ArrayList<Organism<?>> generation);
}
