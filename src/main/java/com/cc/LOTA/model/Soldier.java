package com.cc.LOTA.model;

import com.cc.LOTA.AntColony;
import com.cc.LOTA.utils.Direction;
import com.cc.LOTA.utils.Position;

public class Soldier extends Ant {
    Direction newDirection= Direction.WEST;

    public Soldier(Position position, AntColony colony) {
        super(position, 'S', colony);
    }

    public void move(){
        changePosition(newDirection);

        switch (newDirection){
            case WEST: newDirection=Direction.SOUTH; break;
            case SOUTH: newDirection=Direction.EAST; break;
            case EAST: newDirection=Direction.NORTH; break;
            case NORTH: newDirection=Direction.WEST; break;
        }
    }
}
