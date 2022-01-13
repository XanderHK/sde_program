import Operations.*;

import java.util.HashMap;
import java.util.List;

public class Calculator {

    private final HashMap<String, OperationStrategy> strategies;

    Calculator(){
        strategies = new HashMap<>();
        strategies.put("-", new SubtractStrategy());
        strategies.put("+", new AddStrategy());
        strategies.put("/", new DivideStrategy());
        strategies.put("*", new MultiplyStrategy());
    }

    public Number calculate(List<Number> numbers, String operator){
        return strategies.get(operator).operation(numbers.get(0), numbers.get(1));
    }
}
