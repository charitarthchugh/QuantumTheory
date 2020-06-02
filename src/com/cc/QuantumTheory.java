package com.cc;
import java.util.Scanner;

public class QuantumTheory {
    static final double C= 3E8;
    static final double H= 6.63E-34;
    static final char wave = '\u03BB' ;

    public static void main(String[] args) {
        //declaring all variables and objects
        Scanner scan = new Scanner(System.in);
        boolean passthrough = true,force=true;
        String calculate,wavelength,energy;
        double waveL,enerG,freq;
        System.out.println("Hello.\nThis is a program that determines the wavelength, energy, or frequency of a wave of light, given some inputs.");
        do {
            System.out.println("What do you want to calculate?");
            calculate = scan.nextLine();
            System.out.println("We are now calculating.... " + whatCalc(calculate));
            if (whatCalc(calculate).equals("\nIncorrect input. Choose between \"frequency\", \"wavelength\", or \"energy\" ")) {
                System.out.println("What do you want to calculate?");
                calculate = scan.nextLine();
            } else if (whatCalc(calculate).equals("quit")) {
                passthrough = false;
            } else if (whatCalc(calculate).equals("frequency")) {
                //I need to revise this structure so that it finds what known vars are being entered
                System.out.println("Now type in known values,in meters/Joules(hint- just like a calculator, e). \n If not available, leave field blank.");
                System.out.print(wave + ": ");
                wavelength = scan.nextLine();
                System.out.print("E: ");
                energy = scan.nextLine();
                if (!wavelength.isEmpty() && energy.isEmpty()) {
                    while (force) {
                        try {
                            waveL = Double.parseDouble(wavelength);
                            System.out.println("The frequency is:" + frequency(waveL));
                            force = false;
                        } catch (Exception e) {
                            System.out.println("Enter numbers only please");
                            System.out.print(wave + ": ");
                            wavelength = scan.nextLine();
                        }
                    }

                }
                else if (!energy.isEmpty() && wavelength.isEmpty()) {
                    while (force) {
                        try {
                            enerG = Double.parseDouble(wavelength);
                            System.out.println("The frequency is: "+frequentEnergy(enerG) +"meters");
                            force = false;
                        } catch (Exception e) {
                            System.out.println("Enter numbers other than only please");
                            System.out.print("E: ");
                            energy = scan.nextLine();
                        }
                    }
                }
            }
            else if (whatCalc(calculate).equals("wavelength")){
                System.out.println("What are the input types?(Either \"energy\" or \"frequency\")");
                calculate=scan.nextLine();
                if (calculate.equalsIgnoreCase("energy")){
                    System.out.println("Input energy(hint- just like a calculator, e for scientific notation)");
                    while(force)
                        System.out.print("E: ");
                    try {
                        enerG=scan.nextDouble();
                        force=false;
                        System.out.println(wave+"= "+ waveEnergy(enerG));
                    }catch (Exception e){
                        System.out.println("Enter numbers only please");
                        System.out.print("E: ");
                        enerG = scan.nextDouble();
                    }
                }
                else if (calculate.equalsIgnoreCase("frequency")){
                    System.out.println("Input frequency(hint- just like a calculator, e for scientific notation)");
                    while(force)
                        System.out.print("s^-1: ");
                        try {
                            enerG=scan.nextDouble();
                            force=false;
                            System.out.println(wave+"= "+ waveEnergy(enerG));
                        }catch (Exception e){
                            System.out.println("\nEnter numbers only please");
                            System.out.print("E: ");
                            enerG = scan.nextDouble();
                    }
                }
            }
                //System.out.println("Now type in known values, in s^-1 or Joules(hint- just like a calculator, e).\n Leave values blank if not available");


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
        * energy*wavelength=H*C
        * wavelength= (H*C)/energy
        * */
        double wavelength =(H*C)/energy;
        return wavelength;
    }
    //Method to get frequency from wavelength
    public static double waveFreq(double frequency){
        return C/frequency;
    }
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
