package com.cc.LOTA.model;

import com.cc.LOTA.AntColony;
import com.cc.LOTA.utils.Direction;
import com.cc.LOTA.utils.Position;

public class Worker extends Ant {
    public Worker(Position position, AntColony colony) {
        super(position, 'W', colony);
    }

    public void move(){
        Direction dir= Direction.getRandomDirection();
        changePosition(dir);
    }


}
