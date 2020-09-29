package com.cc.LOTA.utils;

public class Position {

    private final int x;
    private final int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o){
        if (!(o instanceof Position))
            return false;

        Position oPosition=(Position)o;
        return (getX()==oPosition.getX()&&getY()==oPosition.getY());


    }




}
