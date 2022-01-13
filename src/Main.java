import Adapter.InputAdapter;
import Console.ConsoleReader;
import Utils.Pair;

import java.util.List;

public class Main {
    public static void main(String[] args){
        InputAdapter adapter = new InputAdapter(new ConsoleReader());
        List<Pair> input = adapter.parse();
        Calculator calculator = new Calculator();

        System.out.println(input);
//        System.out.println(input.x);
//        Number result = calculator.calculate(input.x, input.y);

//        System.out.println(result);
    }
}
