package com.version1.skippy;


public class Main {

    public static void main(String[] args) {
        Grid grid = new Grid();
        grid.executeInteractively();
        Kangaroo k1 = new Kangaroo();
        k1.initiate();
        boolean home = false;
        int tries = 0;
        while (!home )
        {
            Dice.Directions direction = Dice.Directions.getRandomDirection();
            k1.hop(direction,k1.position.getX(),k1.position.getY(), grid.getBorder() );
            home = k1.at_home(grid.getBorder());
            tries++;
        }
        System.out.println("You have try "+tries);
        k1.report(tries);

    }
}
