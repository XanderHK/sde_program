package Adapter;

import Console.ConsoleReader;
import Status.CalculatorStatusStrategy;

public class StatusAdapter {
    public static CalculatorStatusStrategy statusStrategy;
    private ConsoleReader reader;
    private static StatusAdapter instance;

    public StatusAdapter(ConsoleReader reader){
        this.reader = reader;
    }

    public String viewStatus() {
        return statusStrategy.getStatus();
    }

    public void printStatement() {
        System.out.println("Type: 1 to turn the calculator ON");
        System.out.println("Type: 2 to turn the calculator OFF");
        System.out.println("Type: 3 to RESET");
    }

    public int userInput() {
        String rawInput = reader.readLine();
        int convertedNumber = Integer.parseInt(rawInput);
        return convertedNumber;
    }

    public static StatusAdapter getInstance(ConsoleReader reader){
        if(instance == null){
            instance = new StatusAdapter(reader);
        }
        return instance;
    }

}
