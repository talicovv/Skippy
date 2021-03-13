package com.version1.skippy;
import java.util.Random;
public class Dice {
      int values;

      public enum Directions {
        NORTH,
        SOUTH,
        EAST,
        WEST;

        public static Directions getRandomDirection() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }

    public Dice() {
    }
}
