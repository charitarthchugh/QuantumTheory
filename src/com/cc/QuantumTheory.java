package com.cc;
import java.util.Scanner;

public class QuantumTheory {
    static final double C= 3E8;
    static final double H= 6.63E-34;

    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        boolean passthrough=true;
        System.out.println("Hello.\nThis is a program that determines the wavelength, energy, or frequency of a wave of light, given some inputs.");
        do{
            System.out.println("What do you want to calculate?");
            String calculate = scan.nextLine();
            System.out.println("We are now calculating.... " + whatCalc(calculate));
            if (whatCalc(calculate).equalsIgnoreCase("\nIncorrect input. Choose between \"frequency\", \"wavelength\", or \"energy\" ")){
                System.out.println("What do you want to calculate?");
                calculate=scan.nextLine();
            }
            else if (whatCalc(calculate).equals("frequency")){

            }


        }
        while (passthrough);
    }
    // this method determines what the use wants to calculate
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
    //This method determines the wavelength given energy
    public static double waveEnergy(double energy){
        /*
        *Concept-
        * energy=H*(C/wavelength)
        *energy*wavelength=H*C
        * wavelength= (H*C)/energy
        * */
        double wavelength =(H*C)/energy;
        return wavelength;
    }
    //
    public static double frequency(double wavelength){
        /*
        *C=wavelength*frequency
        * C/wavelength=frequency
        * */
        return C/wavelength;
    }

}
