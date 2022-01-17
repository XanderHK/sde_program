import Adapter.InputAdapter;
import Console.ConsoleReader;
import Utils.Pair;

public class Main {
    public static void main(String[] args){
        InputAdapter adapter = new InputAdapter(new ConsoleReader());
        Pair input = adapter.parse();
        Calculator calculator = Calculator.getInstance();

        int index = 0;
        Number result = null;
        for(String operator : input.y){
            if(result == null) result = input.x.get(index);
            result = calculator.calculate(result, input.x.get(index + 1), operator);
            index++;
        }

        System.out.println(result);
    }
}
