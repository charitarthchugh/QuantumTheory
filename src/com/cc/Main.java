package com.cc;
import java.util.Scanner;

public class Main {
    final int C=3*10^8;

    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        boolean passthrough=true;
        System.out.println("Hello.\nThis is a program that determines the wavelength, energy, or frequency of a wave of light, given some inputs.");
        do{
            System.out.println("What do you want to calculate?");
            String calculate = scan.nextLine();
            System.out.println("We are now calculating.... " + whatCalc(calculate));
        }
        while (passthrough);
    }
    public static String whatCalc (String calc){
        if (calc.equalsIgnoreCase("frequency"))
            return "frequency";
        else if(calc.equalsIgnoreCase("wavelength"))
            return "wavelength";
        else if(calc.equalsIgnoreCase("energy"))
            return "energy";
        else {
            String incorrect = "\nIncorrect input. Choose between \"frequency\", \"wavelength\", or \"energy\" ";
            return incorrect;
        }

    }
}
