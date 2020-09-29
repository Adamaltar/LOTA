package com.cc.LOTA.model;

import com.cc.LOTA.AntColony;
import com.cc.LOTA.utils.Direction;
import com.cc.LOTA.utils.Position;

public abstract class Ant {

    protected Position position;
    private char identifier;
    protected AntColony colony;

    public Ant(Position position, char identifier, AntColony colony) {
        this.position = position;
        this.identifier = identifier;
        this.colony = colony;
    }

    public Position getPosition() {
        return position;
    }

    public char getIdentifier() {
        return identifier;
    }

    public boolean changePosition(Direction dir){

        Position newPosition=new Position(getPosition().getX()+dir.getXDir(),getPosition().getY()+dir.getYDir());
        if (colony.isPositionValid(newPosition)){
            position=newPosition;
            return true;
        } else
            return false;

    }

    public abstract void move();

}
