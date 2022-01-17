package Adapter;

import Console.ConsoleReader;
import Utils.Pair;

import java.util.ArrayList;
import java.util.List;

public class InputAdapter {

    private final ConsoleReader reader;

    public InputAdapter(ConsoleReader reader){
        this.reader = reader;
    }

    public Pair parse(){
        String rawInput = reader.readLine();
        String trimmed = rawInput.replaceAll("\\s+","");
        List<String> operators = new ArrayList<>();
        List<Number> numbers = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < trimmed.length(); i++) {
            String currentChar = Character.toString(trimmed.charAt(i));
            if (currentChar.matches("[+\\-*/.]")) {
                numbers.add(convertToNumber(temp.toString()));
                temp = new StringBuilder();
                operators.add(currentChar);
                continue;
            }

            temp.append(currentChar);

            if(i == (trimmed.length() - 1)) numbers.add(convertToNumber(temp.toString()));
        }

        return new Pair(numbers, operators);
    }

    private Number convertToNumber(String number){
        try{
            return Double.parseDouble(number);
        }catch(NumberFormatException e){
            System.out.println("A non numeric string has been encountered.");
            return null;
        }
    }
}
