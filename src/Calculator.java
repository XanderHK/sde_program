import Operations.*;

import java.util.HashMap;

public class Calculator {

    private final HashMap<String, OperationStrategy> strategies;
    private static Calculator instance;

    Calculator(){
        strategies = new HashMap<>();
        strategies.put("-", new SubtractStrategy());
        strategies.put("+", new AddStrategy());
        strategies.put("/", new DivideStrategy());
        strategies.put("*", new MultiplyStrategy());
    }

    public static Calculator getInstance(){
        if(instance == null){
            instance = new Calculator();
        }
        return instance;
    }

    public Number calculate(Number a, Number b, String operator){
        return strategies.get(operator).execute(a, b);
    }
}
