package com.cc.LOTA.model;

import com.cc.LOTA.AntColony;
import com.cc.LOTA.utils.Position;

public abstract class Mater extends Ant{
    public abstract void mate();

    public Mater(Position position, char identifier, AntColony colony) {
        super(position, identifier, colony);
    }
}
