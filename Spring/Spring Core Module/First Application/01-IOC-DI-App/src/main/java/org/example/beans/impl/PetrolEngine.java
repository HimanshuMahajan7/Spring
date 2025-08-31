package org.example.beans.impl;

import org.example.beans.IEngine;

public class PetrolEngine implements IEngine {

    public PetrolEngine() {
        System.out.println("Petrol Engine: Constructor");
    }

    @Override
    public int start() {
        System.out.println("Petrol Engine Started");
        return 1;
    }
}
