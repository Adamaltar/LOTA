package com.cc.LOTA.model;

import com.cc.LOTA.AntColony;
import com.cc.LOTA.utils.Position;

public class Queen extends Mater {
    private int counter = 0;
    public static int MINIMUMCOUNTER = 50;
    public static int COUNTERRANGE = 50;


    public Queen(Position position, AntColony colony) {
        super(position, 'Q', colony);
    }
    public boolean isInMood() {
        return counter == 0;
    }

    public void mate() {
        counter = (int) (Math.random() * (COUNTERRANGE + 1) + MINIMUMCOUNTER);
        System.out.println("Queen is mating, counter set to: "+counter);
    }

    public void move() {
        if (counter>0)
            counter--;
    }

}
