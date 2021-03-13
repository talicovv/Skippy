package com.version1.skippy;

import java.util.Scanner;

public class Grid {

    int border;

    public int getBorder() {
        return border;
    }

    public void setBorder( int x) {
        border = (x -1);
    }
    public static boolean lies_outside(int x, int y, int b){
        if (x < 0 || y < 0 )
                return true;
        if (x > b || y > b)
                return true;
         return false;
    }

    public void executeInteractively() {
        System.out.println("Enter the size of grid :");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");

        if (parts.length == 1) {
            int value =Integer.parseInt(parts[0]);
            if (value <= 1) {
                System.out.println("Please provide a numeric great than 1");
            }else{
                setBorder(value);
                System.out.println("The address of home is: ("+border+" , "+border+" )");
            }

        } else{
            System.out.println("Please provide a numeric value for the size of the grid");
        }

    }


    public Grid() {

    }
}
