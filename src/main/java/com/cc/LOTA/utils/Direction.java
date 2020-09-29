package com.cc.LOTA.utils;

public enum Direction {

    NORTH(0,-1),SOUTH(0,1),EAST(1,0),WEST(-1,0);

    private final int xDir;
    private final int yDir;

    public int getXDir() {
        return xDir;
    }

    public int getYDir() {
        return yDir;
    }

    private Direction(int x, int y) {
        this.xDir = x;
        this.yDir = y;
    }


    public static Direction getRandomDirection(){
        int rand=(int)(Math.random()*Direction.values().length);
        for (Direction dir : Direction.values())
            if (dir.ordinal()==rand)
                return dir;
         return null;
    }
}
