package com.version1.skippy;

import java.util.HashMap;
import java.util.Map;

import static com.version1.skippy.Dice.*;

public class Kangaroo  {
    Point position = new Point();


    Map<Directions, Integer> countMap =  new HashMap<>();


    public void initiate(){
        countMap.put(Directions.NORTH,0);
        countMap.put(Directions.SOUTH,0);
        countMap.put(Directions.WEST,0);
        countMap.put(Directions.EAST,0);
    }


    public void hop(Directions direction, int l, int c, int b) {
        int x1 = l;
        int y1 = c;

        switch(direction) {
            case NORTH:
                y1++;
                break;
            case SOUTH:
                y1--;
                break;
            case EAST:
                x1++;
                break;
            case WEST:
                x1--;
                break;
            default:
                System.out.println("default");
        }
        if (Grid.lies_outside(x1 , y1, b)) {
            System.out.println("Oops, hit the boundary - "+direction+" ("+x1+", "+y1+" )");
        }else{
            System.out.println(direction+": Hopping on ("+x1+", "+y1+" )");
            position.setX(x1);
            position.setY(y1);
            countMap.put(direction,countMap.get(direction)+1);
        }

    }
    public boolean at_home(int b){
        if (position.getX()== b && position.getY()==b) {
            System.out.println("You made it!");
            return true;
        }
        return false;
    }

    public void report(int tries){

        String output;
        int sum = 0;

        for ( Directions i : countMap.keySet())
            sum = sum + countMap.get(i);
        System.out.println("You have effectively hopped: "+sum);
        Double result = (double) sum;
        result = (result/tries)*100;
        output = String.format("You were %.2f%% effective",result);
        System.out.println(output);
        for ( Directions i : countMap.keySet()) {
            result = Double.valueOf(countMap.get(i));
            result = ((result/sum)*100);
            output = String.format("%s : %.2f%%",i,result);
            System.out.println(output);
        }
    }

    public Kangaroo() {
    }

}
