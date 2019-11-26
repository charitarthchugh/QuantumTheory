package com.cc;
import java.util.Scanner;

public class QuantumTheory {
    static final double C= 3E8;
    static final double H= 6.63E-34;
    static final char wave = '\u03BB' ;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean passthrough = true;
        System.out.println("Hello.\nThis is a program that determines the wavelength, energy, or frequency of a wave of light, given some inputs.");
        do {
            System.out.println("What do you want to calculate?");
            String calculate = scan.nextLine();
            System.out.println("We are now calculating.... " + whatCalc(calculate));
            if (whatCalc(calculate).equals("\nIncorrect input. Choose between \"frequency\", \"wavelength\", or \"energy\" ")) {
                System.out.println("What do you want to calculate?");
                calculate = scan.nextLine();
            } else if (whatCalc(calculate).equals("quit")) {
                passthrough = false;
            } else if (whatCalc(calculate).equals("frequency")) {
                System.out.println("Now type in known values.If not available, leave field blank");
                String wavelength, energy;
                boolean force = true;
                double waveL,enerG;
                System.out.print(wave + ": ");
                wavelength = scan.nextLine();
                System.out.print("E: ");
                energy = scan.nextLine();
                if (!wavelength.isEmpty() && energy.isEmpty()) {
                    while (force) {
                        try {
                            waveL = Double.parseDouble(wavelength);
                            force = false;
                        } catch (Exception e) {
                            System.out.println("Enter numbers only please");
                            System.out.print(wave + ": ");
                            wavelength = scan.nextLine();
                        }
                    }
                    System.out.println(frequency(waveL));
                }
                else if (!energy.isEmpty() && wavelength.isEmpty()) {
                    while (force) {
                        try {
                            enerG = Double.parseDouble(wavelength);
                            force = false;
                        } catch (Exception e) {
                            System.out.println("Enter numbers other than only please");
                            System.out.print("E: ");
                            energy = scan.nextLine();
                        }
                    }
                    System.out.println(frequentEnergy(enerG));
                }
            }


        }
        while (passthrough);
    }
    // this method determines what the use wants to calculate
    public static String whatCalc(String calc){
        if (calc.trim().equalsIgnoreCase("frequency"))
            return "frequency";
        else if(calc.trim().equalsIgnoreCase("wavelength"))
            return "wavelength";
        else if(calc.trim().equalsIgnoreCase("energy"))
            return "energy";
        else if (calc.trim().equalsIgnoreCase("quit"))
            return "quit";
        else {
            String incorrect = "\nIncorrect input. Choose between \"frequency\", \"wavelength\", \"energy\" or type \"quit\" to exit";
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
    //Method to get frequency from wavelength
    public static double frequency(double wavelength){
        /*
        *C=wavelength*frequency
        * C/wavelength=frequency
         */
        return C/wavelength;
    }
    public static double frequentEnergy(double energy){
        /*
        *Base formula --> Energy= H*frequency;
        * */
        return energy/H;
    }
    public static double energyFrequency(double frequency){
        return H*frequency;
    }
    public static double energyWave(double wavelength){
        return H*frequency(wavelength);
    }
}
