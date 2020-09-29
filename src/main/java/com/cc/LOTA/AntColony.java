package com.cc.LOTA;

import com.cc.LOTA.model.*;
import com.cc.LOTA.utils.Position;

import java.util.ArrayList;
import java.util.List;

public class AntColony {
    private List<Ant> ants=new ArrayList<>();
    private Queen queen;
    private int width;
    public static int NUMBEROFDRONES=5;
    public static int NUMBEROFWORKERS=5;
    public static int NUMBEROFSOLDIERS=5;

    public AntColony(int width) {
        this.width = width;
        generateAnts(NUMBEROFWORKERS,NUMBEROFSOLDIERS,NUMBEROFDRONES);
        queen=new Queen(new Position(getWidth()/2,getWidth()/2),this);
    }

    private void generateAnts(int numberofworkers, int numberofsoldiers, int numberofdrones) {
        for (int i = 0; i < numberofdrones; i++)
            ants.add(new Drone(getRandomPosition(),this));
        for (int i = 0; i < numberofworkers; i++)
            ants.add(new Worker(getRandomPosition(),this));
        for (int i = 0; i < numberofsoldiers; i++)
            ants.add(new Soldier(getRandomPosition(),this));
    }

    private Position getRandomPosition(){
        int x=(int)(Math.random()*getWidth());
        int y=(int)(Math.random()*getWidth());
        return new Position(x,y);
    }

    public boolean isPositionValid(Position newPosition) {
        return (newPosition.getX()>=0&&newPosition.getX()<getWidth()&&newPosition.getY()>=0&&newPosition.getY()<getWidth());
    }

    public int getWidth() {
        return width;
    }

    public Position getQueenPosition() {
        return queen.getPosition();
    }

    public boolean isQueenInMood() {
        return queen.isInMood();
    }

    public void mate(Drone drone) {
        queen.mate();
        drone.mate();
    }

    public void display(){
        String[][] board=new String[width][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j]="";

            }
        }
        board[queen.getPosition().getY()][queen.getPosition().getX()]+=queen.getIdentifier();
        for (Ant ant: ants) {
            board[ant.getPosition().getY()][ant.getPosition().getX()]+=ant.getIdentifier();
        }


        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("----");
            }
            System.out.println("-");
            for (int j = 0; j < width; j++) {
                String symbol="";
                if (board[i][j].length()==1)
                    symbol=" "+board[i][j]+" ";
                else if (board[i][j].length()==2)
                    symbol=" "+board[i][j];
                else if (board[i][j].length()==3)
                    symbol=board[i][j];
                else if (board[i][j].length()==0)
                    symbol="   ";
                System.out.print("|"+symbol);
            }
            System.out.println("|");
        }
        for (int j = 0; j < width; j++) {
            System.out.print("----");
        }
        System.out.println("-");



    }

    private void update() {
        for (Ant ant:ants)
            ant.move();
        queen.move();
    }


    public static void main(String args[]){
        AntColony a=new AntColony(10);
        a.display();
        for (int i = 0; i < 30; i++) {
            a.update();
            a.display();
        }

    }




}
