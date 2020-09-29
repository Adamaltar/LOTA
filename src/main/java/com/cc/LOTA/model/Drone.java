package com.cc.LOTA.model;

import com.cc.LOTA.AntColony;
import com.cc.LOTA.utils.Direction;
import com.cc.LOTA.utils.Position;

public class Drone extends Mater {
    private static int MAXCOUNTER=10;
    private int counter=0;


    public Drone(Position position, AntColony colony) {
        super(position, 'D', colony);
    }


    public void kickAway(){
        int kickOnX=(int)(Math.random()*(colony.getWidth()/2+1));
        int kickOnY=(colony.getWidth()/2)-kickOnX;
        int multiplierX=(Math.random()<0.5)?1:-1;
        int multiplierY=(Math.random()<0.5)?1:-1;

        Position newPosition=new Position(getPosition().getX()+multiplierX*kickOnX,getPosition().getY()+multiplierY*kickOnY);

        while (!colony.isPositionValid(newPosition)){
            kickOnX=(int)(Math.random()*(colony.getWidth()/2+1));
            kickOnY=(colony.getWidth()/2)-kickOnX;
            multiplierX=(Math.random()<0.5)?1:-1;
            multiplierY=(Math.random()<0.5)?1:-1;
            newPosition=new Position(getPosition().getX()+multiplierX*kickOnX,getPosition().getY()+multiplierY*kickOnY);
        }
        //System.out.println(newPosition.getX()+" "+newPosition.getY());
        position=newPosition;

    }

    @Override
    public void mate() {
        counter = MAXCOUNTER;
        System.out.println("Queen is mating, counter set to: "+counter);
    }

    public void move(){

        if (counter>0){
            counter--;
            System.out.println("counter: "+counter);
            if (counter==0){
                kickAway();
            }
            return;
        }


        Position queenPosition=colony.getQueenPosition();

        Direction dir=null;
        if (queenPosition.getX()<getPosition().getX())
            dir=Direction.WEST;
        else if (queenPosition.getX()>getPosition().getX())
            dir=Direction.EAST;
        else if (queenPosition.getY()<getPosition().getY())
            dir=Direction.NORTH;
        else if (queenPosition.getY()>getPosition().getY())
            dir=Direction.SOUTH;
       // System.out.println(getPosition().getX()+" "+getPosition().getY());
        changePosition(dir);

        if (queenPosition.equals(getPosition()))
            if (colony.isQueenInMood())
                colony.mate(this);
            else
                kickAway();
    }



}
