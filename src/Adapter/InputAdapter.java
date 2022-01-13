package Adapter;

import Console.ConsoleReader;
import Utils.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputAdapter {

    private final ConsoleReader reader;
    private final static List<String> operators = Arrays.asList("+", "-", "/", "*");

    public InputAdapter(ConsoleReader reader){
        this.reader = reader;
    }

    public List<Pair> parse(){
        String rawInput = reader.readLine();
        String trimmed = rawInput.replaceAll("\\s+","");
        List<Pair> pairs = new ArrayList<>();
    //Splice it at index of match
        // remove all operators and keep execute in order
        String currentOperator = null;
        StringBuilder currentOperation = new StringBuilder();
        for(int i = 0; i < trimmed.length(); i++){
            String currentChar = Character.toString(trimmed.charAt(i));
            if(currentChar.matches("[+\\-*/.]")) {
                if(currentOperator != null){
                    pairs.add(convertToPair(currentOperation.toString(),currentOperator));
                    currentOperation = new StringBuilder();
                }
                currentOperator = currentChar;
            }
            currentOperation.append(currentChar);
        }
        return pairs;
    }

    private Pair convertToPair(String currentOperation, String operator){
        String[] parts = currentOperation.split(String.format("\\%s", operator));
        System.out.println(parts[0]);
        List<Number> numbers = getNumbers(parts);
        return new Pair(numbers, operator);
    }

    private List<Number> getNumbers(String[] parts) {
        List<Number> numbers = new ArrayList<>();
        for(String part : parts){
            try{
                double parsed = Double.parseDouble(part);
                numbers.add(parsed);
            }catch(NumberFormatException e){
                System.out.println("A non numeric string has been encountered.");
            }
        }
        return numbers;
    }
}
